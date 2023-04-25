package com.eotrophy.bitsandpizzaz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eotrophy.bitsandpizzaz.databinding.FragmentOrderBinding
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

    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater,container,false)
        val view = binding.root
//        val view = inflater.inflate(R.layout.fragment_order, container, false)
//        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

//        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        binding.fab.setOnClickListener {
//            val pizzaGroupe = view.findViewById<RadioGroup>(R.id.radio_group)
            val pizzaType = binding.radioGroup.checkedRadioButtonId
            if (pizzaType == -1) {
                val text = "You need to choose pizza type"
                Toast.makeText(activity, text,Toast.LENGTH_LONG).show()
            } else {
                var text = (when (pizzaType) {
                    R.id.radio_diavolo -> "Diavolo pizza"
                    else -> "Funghi pizza"
                })

//                val parmesan = view.findViewById<Chip>(R.id.chip_parmesan)
                text += if (binding.chipParmesan.isChecked) ", extra parmesan" else ""
//                val chillOil = view.findViewById<Chip>(R.id.chip_chill_oil)
                text += if (binding.chipChillOil.isChecked) ", extra chill oil" else ""
                Snackbar.make(binding.fab, text, Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}