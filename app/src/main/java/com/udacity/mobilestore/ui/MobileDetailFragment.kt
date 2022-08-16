package com.udacity.mobilestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.mobilestore.R
import com.udacity.mobilestore.databinding.FragmentMobileDetailBinding
import com.udacity.mobilestore.viewmodel.MobileViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [MobileDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MobileDetailFragment : Fragment() {
    lateinit var binding: FragmentMobileDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_mobile_detail,
            container,
            false
        )
        val mobileviewModel: MobileViewModel by activityViewModels()
        binding.mobileViewModel = mobileviewModel
        mobileviewModel.resetMobile()
        binding.buttonSave.setOnClickListener {
            if(mobileviewModel.validate()) {
                mobileviewModel.addMobile()
                view?.findNavController()?.navigate(MobileDetailFragmentDirections.actionMobileDetailFragmentToMobileFragment())
            }
            else {
                Snackbar.make(
                    requireView(),
                    getString(R.string.validation_mobile_detail_message),
                    Snackbar.LENGTH_LONG)
                    .show()
            }

        }
        binding.buttonCancel.setOnClickListener {
            view?.findNavController()?.navigate(MobileDetailFragmentDirections.actionMobileDetailFragmentToMobileFragment())
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}