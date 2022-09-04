package com.example.scanner.presentation.scan

import android.Manifest
import android.content.pm.PackageManager
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.scanner.R
import com.example.scanner.databinding.FragmentScanBinding
import com.example.scanner.di.App
import com.example.scanner.di.DaggerScanComponent
import com.example.scanner.domain.models.HistoryModel
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView
import javax.inject.Inject


class ScanFragment : Fragment(), ZBarScannerView.ResultHandler {

    lateinit var scanView: ZBarScannerView
    lateinit var scanBinding: FragmentScanBinding
    lateinit var btn: Button
    lateinit var tv: TextView
    lateinit var arl: ActivityResultLauncher<String>

    @Inject
    lateinit var viewModel: ScanViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val comp = DaggerScanComponent.builder()
            .context(requireContext())
            .build()
        comp.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        scanBinding = FragmentScanBinding.inflate(layoutInflater, container, false)
        btn = scanBinding.btn
        tv = scanBinding.tv
        scanView = scanBinding.scanview
        arl = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                runScan()
            }
        }
        btn.setOnClickListener {

            arl.launch(Manifest.permission.CAMERA)
        }
        return scanBinding.root
    }

    override fun onResume() {
        super.onResume()

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED
        ) {
            runScan()
        }else{
            tv.visibility = View.VISIBLE
            btn.visibility = View.VISIBLE
        }
    }

    override fun onPause() {
        super.onPause()
        scanView.stopCamera()
    }

    override fun handleResult(res: Result?) {
        if (res?.contents?.startsWith("01") == true) {
            onResume()
        } else {
            if (res?.contents != null) viewModel.insertScan(HistoryModel(message = res.contents))
            val bundle = Bundle()
            bundle.putString("1", res?.contents)
            findNavController().navigate(R.id.action_scanFragment_to_resultFragment, bundle)
        }
    }

    private fun runScan() {
        tv.visibility = View.GONE
        btn.visibility = View.GONE
        scanView.setResultHandler(this)
        scanView.startCamera()
    }

}


