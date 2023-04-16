package com.eotrophy.bitsandpizzaz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val pizzaGroupe = view.findViewById<RadioGroup>(R.id.radio_group)
            val pizzaType = pizzaGroupe.checkedRadioButtonId
            if (pizzaType == -1) {
                val text = "You need to choose pizza type"
                Toast.makeText(activity, text,Toast.LENGTH_LONG).show()
            } else {
                var text = (when (pizzaType) {
                    R.id.radio_diavolo -> "Diavolo pizza"
                    else -> "Finghi pizza"
                })

                val parmesan = view.findViewById<Chip>(R.id.chip_parmesan)
                text += if (parmesan.isChecked) ", extra parmesan" else ""
                val chillOil = view.findViewById<Chip>(R.id.chip_chill_oil)
                text += if (chillOil.isChecked) ", extra chill oil" else ""
                Snackbar.make(fab, text, Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }
}