// hari tanggal pengerjaan : 27 Mei 2025
// nim                     : 10122362
// nama lengkap            : Louis Jonathan Susanto Putra
// kelas                   : PA 4


package com.example.praktikfragmentproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.praktikfragmentproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val fragmentA = FragmentA()
        val fragmentB = FragmentB()

        fragmentManager.beginTransaction()
            .add(R.id.frameContainer, fragmentA, fragmentA::class.java.simpleName)
            .commit()

        binding.btnA.setOnClickListener {
            var fragment = fragmentManager.findFragmentByTag(FragmentA::class.java.simpleName)

            if (fragment !is FragmentA) {
                fragmentManager.beginTransaction()
                    .replace(R.id.frameContainer, fragmentA, fragmentA::class.java.simpleName)
                    .commit()
            }
        }
        binding.btnB.setOnClickListener {
            var fragment = fragmentManager.findFragmentByTag(FragmentB::class.java.simpleName)

            if (fragment !is FragmentB) {
                fragmentManager.beginTransaction()
                    .replace(R.id.frameContainer, fragmentB, fragmentB::class.java.simpleName)
                    .commit()
            }
        }
    }
}