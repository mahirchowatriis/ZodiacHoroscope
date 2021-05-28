package edu.uwindsor.zodiachoroscope

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.uwindsor.zodiachoroscope.data.ZodiacItem

class ZodiacAdapter(private val signs: List<ZodiacItem>) :
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

    class ZodiacViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val zodiacTextView: TextView = itemView.findViewById(R.id.zodiac_name)
        private val zodiacImage: ImageView = itemView.findViewById(R.id.image_view)
//        private val zodiacDescription: TextView = itemView.findViewById(R.id.description)
//        private val zodiacSymbol: TextView = itemView.findViewById(R.id.zodiac_symbol)
//        private val zodiacMonth: TextView = itemView.findViewById(R.id.zodiac_month)

        private lateinit var sign: ZodiacItem

//        init {
//            itemView.setOnClickListener{
//                Toast.makeText(this, "${sign.name} pressed!", Toast.LENGTH_SHORT).show()
//            }
//        }

        @SuppressLint("ResourceType")
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