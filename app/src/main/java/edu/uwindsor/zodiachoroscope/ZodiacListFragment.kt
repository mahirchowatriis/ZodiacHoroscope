package edu.uwindsor.zodiachoroscope

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ZodiacListFragment : Fragment(){
    private lateinit var zodiacRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_zodiac_list, container, false)
        zodiacRecyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        zodiacRecyclerView.layoutManager = LinearLayoutManager(context)

        val dividerItemDecoration = DividerItemDecoration(
            zodiacRecyclerView.context,
            (zodiacRecyclerView.layoutManager as LinearLayoutManager).orientation
        )
        zodiacRecyclerView.addItemDecoration(dividerItemDecoration)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ZodiacRepo.get().getSigns().observe(
            viewLifecycleOwner,
            Observer { signs ->
                signs?.let {
                    Log.d("BISH", signs.size.toString())
                    zodiacRecyclerView.adapter = ZodiacAdapter(signs)
                }
            }
        )
    }

    companion object {
        fun newInstance(): ZodiacListFragment {
            return ZodiacListFragment()
        }
    }

}