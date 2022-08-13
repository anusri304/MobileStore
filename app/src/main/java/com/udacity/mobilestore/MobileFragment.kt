package com.udacity.mobilestore

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.mobilestore.databinding.FragmentMobileBinding


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
         initCardView()
        })
        return binding.root
    }

    private fun initCardView() {

        var cardview: CardView = CardView(requireContext())
//
//        var layoutparams: ViewGroup.LayoutParams = ViewGroup.LayoutParams(
//            350,
//            350
//        )
//        cardview.setLayoutParams(layoutparams)
//        cardview.setRadius(15F);
//        cardview.setPadding(25, 25, 25, 25);
//        cardview.setCardBackgroundColor(Color.GRAY);
//        cardview.setMaxCardElevation(30F);
//        cardview.setMaxCardElevation(6F);
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(250,100,100,100);
        val textCard:TextView = TextView(requireContext())
        textCard.setTextSize(50F)
        textCard.setText("Test")
        textCard.setTextColor(Color.BLACK)
        textCard.setLayoutParams(params)
      //  cardview.addView(textCard)
        binding.linearLayout.addView(textCard)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}