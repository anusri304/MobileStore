package com.udacity.mobilestore

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.card.MaterialCardView
import com.udacity.mobilestore.databinding.FragmentMobileBinding
import com.udacity.mobilestore.databinding.FragmentWelcomeBinding
import com.udacity.mobilestore.models.Mobile
import kotlinx.android.synthetic.main.fragment_login.*


class MobileFragment : Fragment(), MenuProvider {
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
        val viewModel: MobileViewModel by activityViewModels()
        viewModel.mobiles.observe(viewLifecycleOwner) {
            println(it.get(0))
            for (mobile in it) {
                initCardView(mobile)
            }
        }
        return binding.root
    }

    private fun initCardView(mobile: Mobile) {

        var cardview: CardView = CardView(requireContext())
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                600,
                150
            )
        params.setMargins(0, 150, 0, 0);
        params.gravity = Gravity.CENTER
        cardview.setLayoutParams(params)
        cardview.setRadius(15F);
        cardview.setMaxCardElevation(50F)
        // cardview.setPadding(60, 60, 60, 60);
        cardview.setCardBackgroundColor(Color.LTGRAY);


        val textCard: TextView = TextView(requireContext())
        textCard.setTextSize(20F)
        textCard.setText(mobile.company.plus(" ").plus(mobile.model))
        textCard.setTextColor(Color.BLACK)
        textCard.setGravity(Gravity.CENTER)
        // textCard.setLayoutParams(params)
        cardview.addView(textCard)
        binding.linearLayout.addView(cardview)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        binding.floatingActionButton.setOnClickListener {
            view.findNavController()
                .navigate(MobileFragmentDirections.actionMobileFragmentToMobileDetailFragment())
        }

    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_mobile_list, menu)
    }
    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        // Handle the menu selection
        return when (menuItem.itemId) {
            R.id.action_logout -> {
                view?.findNavController()
                    ?.navigate(MobileFragmentDirections.actionMobileFragmentToLoginFragment())
                true
            }
            else -> false
        }

    }
}