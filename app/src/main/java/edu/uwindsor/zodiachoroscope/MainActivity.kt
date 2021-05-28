package edu.uwindsor.zodiachoroscope


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.uwindsor.zodiachoroscope.data.ZodiacItem
import edu.uwindsor.zodiachoroscope.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val currentFragment = supportFragmentManager.findFragmentById(R.id.main_container)


        if (currentFragment == null){
            val fragment = ZodiacListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_container, fragment)
                .commit()
        }
    }
}