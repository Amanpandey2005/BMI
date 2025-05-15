package com.example.bmi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding  // ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val weight = binding.Weight.text.toString().toFloatOrNull()
            val heightFeet = binding.heightfeet.text.toString().toFloatOrNull()
            val heightInches = binding.heightinches.text.toString().toFloatOrNull()
            if (weight != null && heightFeet != null && heightInches != null) {

                val totalinches = heightFeet * 12 + heightInches
               val totalcm = totalinches * 2.54 ;
                val totalmeter = totalcm / 100;
                val bmi = weight / (totalmeter * totalmeter)
                binding.textans.text =  "${bmi.toInt()}"
                if(bmi<18.5){
                    Toast.makeText(this, "Underweight", Toast.LENGTH_SHORT).show()
                    binding.main.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
                    binding.resulttitle.text = "Underweight"

                }
                else if(bmi<24.9){
                    Toast.makeText(this, "Normal", Toast.LENGTH_SHORT).show()
                    binding.main.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                    binding.resulttitle.text = "Normal"

                    }
                else if(bmi<29.9){
                    Toast.makeText(this, "Overweight", Toast.LENGTH_SHORT).show()
                    binding.main.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
                    binding.resulttitle.text = "Overweight"
                }
                else{
                    Toast.makeText(this, "Obese", Toast.LENGTH_SHORT).show()
                    binding.resulttitle.text = "Obese"
                    binding.main.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                }
                binding.textans.text = "%.2f".format(bmi)
            }
            else{
                Toast.makeText(this, "Please fill up all the required Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
