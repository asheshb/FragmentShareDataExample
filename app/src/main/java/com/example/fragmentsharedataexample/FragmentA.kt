package com.example.fragmentsharedataexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_a.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val model: SharedViewModel = ViewModelProviders.of(activity!!)[SharedViewModel::class.java]


        model.updateProduct(2)

        model.product.observe(viewLifecycleOwner, Observer {
            product_name.text = getString(R.string.product_name, it.name)
        })
    }
}
