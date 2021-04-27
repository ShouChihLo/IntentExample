package com.example.intentexample

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.intentexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val intent = Intent(this, SecondMainActivity::class.java) //explicit intent
            //val intent = Intent("com.example.intentexample.ACTION_START") //implicit intent
            //passing data
//            val bundle = Bundle().apply {
//                putString("Name", "Robert")
//                putInt("Age", 40)
//            }
//
            //passing object
            val robert = Person("Robert", 40)
            val zoey = Person("Zoey", 20)
            val userList = arrayListOf<Person>(robert, zoey)
            val bundle = Bundle().apply {
                //putParcelable("Person", robert)
                putParcelableArrayList("Person", userList)
            }

            intent.putExtras(bundle)

            startActivity(intent)
            //startActivityForResult(intent, 1)
        }

        binding.button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.yahoo.com.tw")
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:0800123456")
            startActivity(intent)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when (requestCode) {
//            1 -> if (resultCode == Activity.RESULT_OK) {
//                val returnedData = data?.getStringExtra("Message")
//                Log.d("Main", returnedData.toString())
//            }
//        }
//    }

}