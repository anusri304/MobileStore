package com.udacity.mobilestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.mobilestore.databinding.FragmentMobileBinding
import com.udacity.mobilestore.databinding.FragmentMobileDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

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
            viewModel.addMobile()
            view?.findNavController()?.navigate(MobileDetailFragmentDirections.actionMobileDetailFragmentToMobileFragment())
        }
        binding.buttonCancel.setOnClickListener {
            view?.findNavController()?.navigate(MobileDetailFragmentDirections.actionMobileDetailFragmentToMobileFragment())
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MobileDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MobileDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}