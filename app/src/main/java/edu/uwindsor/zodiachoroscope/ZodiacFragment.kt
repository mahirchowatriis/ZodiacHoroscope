package edu.uwindsor.zodiachoroscope

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import edu.uwindsor.zodiachoroscope.data.ZodiacRepo


private const val ARG_ZODIAC_ID = "apple"

private const val TAG = "BISH"
class ZodiacFragment : Fragment() {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val crimeId: Int = arguments?.getSerializable(ARG_ZODIAC_ID) as Int
        Log.d(TAG, "args bundle crime ID: $crimeId")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zodiac, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ZodiacRepo.get().getSigns().observe(
            viewLifecycleOwner,
            Observer { signs ->
                signs?.let {
                    zodiacRecyclerView.adapter = ZodiacAdapter(signs)
                }
            }
        )
    }

    private fun updateUI() {
        titleField.setText(crime.title)
        dateButton.text = crime.date.toString()
        solvedCheckBox.isChecked = crime.isSolved
    }

    companion object {
        fun newInstance(signID: Int): ZodiacFragment {
            val args = Bundle().apply {
                putSerializable(ARG_ZODIAC_ID, signID)
            }
            return ZodiacFragment().apply {
                arguments = args
            }
        }
    }

}