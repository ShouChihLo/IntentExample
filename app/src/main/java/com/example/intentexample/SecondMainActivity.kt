package com.example.intentexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intentexample.databinding.ActivitySecondMainBinding

class SecondMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("Message", "No problem")
            setResult(Activity.RESULT_OK, intent)
            finish()  // close the current activity
        }

        //get the bundle
        val bundle = intent.extras
        //val name = bundle?.getString("Name")
        //val age = bundle?.getInt("Age")
        //val user = bundle?.getParcelable<Person>("Person")
        val userList = bundle?.getParcelableArrayList<Person>("Person")
        val user = userList?.get(1)
        //Toast.makeText(this, "Name: $name Age: $age", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Name: ${user?.name} Age: ${user?.age}", Toast.LENGTH_SHORT).show()
    }
}