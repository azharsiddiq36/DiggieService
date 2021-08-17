package com.example.diggieservice.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.diggieservice.MainActivity
import com.example.diggieservice.R
import com.example.diggieservice.databinding.FragmentHomeBinding
import com.example.diggieservice.enum.Constant.ASC
import com.example.diggieservice.enum.Constant.CUSTOMER
import com.example.diggieservice.enum.Constant.TECHNICIAN_ID
import com.example.diggieservice.enum.Constant.TECHNICIAN_TOTAL_SCORE
import com.example.diggieservice.lib.PictureLib.loadPicture
import com.example.diggieservice.model.jual.Jual
import com.example.diggieservice.model.jual.Result
import com.example.diggieservice.model.teknisi.Teknisi
import com.example.rdiandroiddevelopertest.repository.NavigatorRepository.openShopDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private val jualViewModel:JualViewModel by viewModels()
    private val technicianViewModel:TeknisiViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val act: MainActivity = activity as MainActivity
        act.supportActionBar?.hide()
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false)
        return _binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            jualViewModel.getJualAll(CUSTOMER, ASC)?.observe(it, Observer { _jual->
                if (_jual.result.size!=0){
                loadNewsHighLight(it,_jual)
                }
            })
            technicianViewModel.getTechnicanAll(TECHNICIAN_ID, ASC)?.observe(it, Observer { _technician->
                if (_technician.result.size!=0){
                    loadTechnicianHighlight(it,_technician)
                }
            })
            technicianViewModel.getTechnicanAll(TECHNICIAN_TOTAL_SCORE,ASC)?.observe(it, Observer { _technician->
                if (_technician.result.size!=0){
                    loadTopTechnicianHighlight(it,_technician)
                }
            })

        }
    }

    private fun loadTopTechnicianHighlight(fragmentActivity: FragmentActivity, _technician: Teknisi?) {
        if (_technician!!.result.size>1){
            _binding.tvAddress1.text = String.format("%.1f", (_technician.result[0].teknisi_total_score/_technician.result[0].teknisi_total_responden)).toDouble().toString()
            loadPicture(fragmentActivity,_technician.result[0].teknisi_foto,_binding.ivPopular1)
            _binding.tvPopular1.text = "${_technician.result[0].teknisi_nama}"
            _binding.tvAddress2.text = String.format("%.1f", (_technician.result[1].teknisi_total_score/_technician.result[1].teknisi_total_responden)).toDouble().toString()
            loadPicture(fragmentActivity,_technician.result[1].teknisi_foto,_binding.ivPopular2)
            _binding.tvPopular2.text = "${_technician.result[1].teknisi_nama}"
        }
        else{
            _binding.tvAddress1.text = String.format("%.1f", (_technician.result[0].teknisi_total_score/_technician.result[0].teknisi_total_responden)).toDouble().toString()
            loadPicture(fragmentActivity,_technician.result[0].teknisi_foto,_binding.ivPopular1)
            _binding.tvPopular1.text = "${_technician.result[0].teknisi_nama}"
            _binding.tvAddress2.text = String.format("%.1f", (_technician.result[0].teknisi_total_score/_technician.result[0].teknisi_total_responden)).toDouble().toString()
            loadPicture(fragmentActivity,_technician.result[0].teknisi_foto,_binding.ivPopular2)
            _binding.tvPopular2.text = "${_technician.result[0].teknisi_nama}"
        }
    }

    private fun loadTechnicianHighlight(it: FragmentActivity, _technician: Teknisi?) {
        if (_technician!!.result.size > 2){
            _binding.tvTechnician1.text = _technician.result[0].teknisi_nama
            _binding.tvTechnician2.text = _technician.result[1].teknisi_nama
            _binding.tvTechnician3.text = _technician.result[2].teknisi_nama
            loadPicture(it,_technician.result[0].teknisi_foto,_binding.ivTechnician1)
            loadPicture(it,_technician.result[1].teknisi_foto,_binding.ivTechnician2)
            loadPicture(it,_technician.result[2].teknisi_foto,_binding.ivTechnician3)
        }
        else if (_technician!!.result.size in 2..2){
            _binding.tvTechnician1.text = _technician.result[0].teknisi_nama
            _binding.tvTechnician2.text = _technician.result[1].teknisi_nama
            _binding.tvTechnician3.text = _technician.result[0].teknisi_nama
            loadPicture(it,_technician.result[0].teknisi_foto,_binding.ivTechnician1)
            loadPicture(it,_technician.result[1].teknisi_foto,_binding.ivTechnician2)
            loadPicture(it,_technician.result[0].teknisi_foto,_binding.ivTechnician3)
        }
        else{
            _binding.tvTechnician1.text = _technician.result[0].teknisi_nama
            _binding.tvTechnician2.text = _technician.result[0].teknisi_nama
            _binding.tvTechnician3.text = _technician.result[0].teknisi_nama
            loadPicture(it,_technician.result[0].teknisi_foto,_binding.ivTechnician1)
            loadPicture(it,_technician.result[0].teknisi_foto,_binding.ivTechnician2)
            loadPicture(it,_technician.result[0].teknisi_foto,_binding.ivTechnician3)
        }
    }
    private fun loadNewsHighLight(fragmentActivity: FragmentActivity, _jual: Jual?){

        if (_jual!!.result.size>1){
            _binding.highlight1.text = _jual.result[0].jual_judul
            loadPicture(fragmentActivity,_jual.result[0].jual_foto,_binding.ivNewproduct1)
            _binding.tvPrice.text = "Rp ${_jual.result[0].jual_harga}"
            _binding.highlight2.text = _jual.result[1].jual_judul
            loadPicture(fragmentActivity,_jual.result[1].jual_foto,_binding.ivNewproduct2)
            _binding.tvPrice2.text = "Rp ${_jual.result[1].jual_harga}"
            _binding.cvNewProduct1.setOnClickListener {
                openShopDetailsActivity(fragmentActivity,_jual.result[0])
            }
            _binding.cvNewProduct2.setOnClickListener {
                openShopDetailsActivity(fragmentActivity,_jual.result[1])
            }
        }
        else{
            _binding.highlight1.text = _jual.result[0].jual_judul
            loadPicture(fragmentActivity,_jual.result[0].jual_foto,_binding.ivNewproduct1)
            _binding.tvPrice.text = "Rp ${_jual.result[0].jual_harga}"
            _binding.highlight2.text = _jual.result[0].jual_judul
            loadPicture(fragmentActivity,_jual.result[0].jual_foto,_binding.ivNewproduct2)
            _binding.tvPrice2.text = "Rp ${_jual.result[0].jual_harga}"
            _binding.cvNewProduct1.setOnClickListener {
                openShopDetailsActivity(fragmentActivity,_jual.result[0])
            }
            _binding.cvNewProduct2.setOnClickListener {
                openShopDetailsActivity(fragmentActivity,_jual.result[0])
            }
        }

    }
}