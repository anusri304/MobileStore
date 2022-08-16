package com.udacity.mobilestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.mobilestore.databinding.FragmentMobileDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MobileDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MobileDetailFragment : Fragment() {
    private val binding by lazy {
        FragmentMobileDetailBinding.inflate(layoutInflater)
    }
    private val viewModel: MobileViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.mobileViewModel = viewModel
        viewModel.resetMobile()
        binding.buttonSave.setOnClickListener {
            if(viewModel.validate()) {
                viewModel.addMobile()
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