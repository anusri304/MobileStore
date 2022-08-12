package com.udacity.mobilestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.udacity.mobilestore.databinding.FragmentMobileBinding
import com.udacity.mobilestore.databinding.FragmentWelcomeBinding

class MobileFragment : Fragment() {

    companion object {
        fun newInstance() = MobileFragment()
    }

    private lateinit var viewModel: MobileViewModel

    lateinit var binding: FragmentMobileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_mobile,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(MobileViewModel::class.java)
        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.setLifecycleOwner(this)


        viewModel.mobiles.observe(viewLifecycleOwner, Observer { mobileList ->
            println(mobileList.get(0))
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}