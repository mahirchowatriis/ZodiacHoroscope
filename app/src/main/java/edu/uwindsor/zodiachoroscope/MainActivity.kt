package edu.uwindsor.zodiachoroscope


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exampleList = generateZodiacList()

        recycler_view.adapter = ZodiacAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generateZodiacList(): ArrayList<ZodiacItem> {
        val list = ArrayList<ZodiacItem>()
        var zodiac: List<String> = listOf(
            "Aries",
            "Taurus",
            "Gemini",
            "Cancer",
            "Leo",
            "Virgo",
            "Libra",
            "Scorpio",
            "Sagittarius",
            "Capricorn",
            "Aquarius",
            "Pisces"
        )
        var zodiac_img: List<Int> = listOf(
            R.drawable.aries,
            R.drawable.taurus,
            R.drawable.gemini,
            R.drawable.cancer,
            R.drawable.leo,
            R.drawable.virgo,
            R.drawable.libra,
            R.drawable.scorpio,
            R.drawable.sagittarius,
            R.drawable.capricorn,
            R.drawable.aquarius,
            R.drawable.pisces
        )
        for ((i, e) in zodiac.withIndex()) {
            val item = ZodiacItem(zodiac_img[i], e)
            list += item
        }
        return list
    }
}