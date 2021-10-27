package ru.arvalon.hellokotlin.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.arvalon.hellokotlin.MainActivity
import ru.arvalon.hellokotlin.MainActivity.Companion.TAG
import ru.arvalon.hellokotlin.R
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)

        homeViewModel.text.observe(viewLifecycleOwner, Observer { textView.text = it })

        val btn1:Button = root.findViewById(R.id.ex_bnt1)
        btn1.setOnClickListener({
            Log.d(TAG,"Click!")
            //throw IllegalArgumentException("Exception test")

            try {
                val rowNum = "e1"
                val num = Integer.parseInt(rowNum)
            }catch (e: NumberFormatException){
                Log.d(TAG,e.toString())
            }finally {
                Log.d(TAG,"finnaly")
            }
        })

        val btn2:Button = root.findViewById(R.id.ex_bnt2)
        btn2.setOnClickListener({ parseNum("q")})

        return root
    }

    private fun parseNum (rowNum: String){

        val num = try {
            Integer.parseInt(rowNum)
        }catch (e: NumberFormatException){
            Log.d(TAG, e.toString())
            null
        }
        Log.d(TAG,"Parse num = "+num)
    }
}