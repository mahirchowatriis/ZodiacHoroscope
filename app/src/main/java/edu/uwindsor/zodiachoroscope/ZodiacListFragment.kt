package edu.uwindsor.zodiachoroscope

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uwindsor.zodiachoroscope.data.ZodiacItem
import edu.uwindsor.zodiachoroscope.data.ZodiacRepo
import java.util.*

class ZodiacListFragment : Fragment(){

    /**
     * Required interface for hosting activities
     */
    interface Callbacks {
        fun onZodiacSelected(signID: Int)
    }
    private var callbacks: Callbacks? = null


    private lateinit var zodiacRecyclerView: RecyclerView


    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
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

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }


    companion object {
        fun newInstance(): ZodiacListFragment {
            return ZodiacListFragment()
        }
    }


    private inner class ZodiacAdapter(private val signs: List<ZodiacItem>) :
        RecyclerView.Adapter<ZodiacAdapter.ZodiacViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZodiacViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
                parent, false)

            return ZodiacViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ZodiacViewHolder, position: Int) {
            val currentItem = signs[position]

            holder.bind(currentItem)


//        holder.imageView.setImageResource(currentItem.imageResource)
//        holder.imageView.setImageResource(R.drawable.aries)
//        holder.zodiac_name.text = currentItem.name
        }

        override fun getItemCount() = signs.size

        private inner class ZodiacViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

            private val zodiacTextView: TextView = itemView.findViewById(R.id.zodiac_name)
            private val zodiacImage: ImageView = itemView.findViewById(R.id.image_view)
//        private val zodiacDescription: TextView = itemView.findViewById(R.id.description)
//        private val zodiacSymbol: TextView = itemView.findViewById(R.id.zodiac_symbol)
//        private val zodiacMonth: TextView = itemView.findViewById(R.id.zodiac_month)

            private lateinit var sign: ZodiacItem

        init {
            itemView.setOnClickListener{
                callbacks?.onZodiacSelected(sign.id)
            }
        }

            fun bind(zodiac: ZodiacItem) {
                sign = zodiac
                zodiacTextView.text = "${sign.name}"
                zodiacImage.setImageResource(sign.symbol)
//            zodiacDescription.text = "Description: ${sign.description}"
//            zodiacSymbol.text = "Symbol: ${sign.symbol}"
//            zodiacMonth.text = "Month: ${sign.month}"
            }
        }
    }

}