package com.example.silvertownapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 메인 화면의 XML 이름

        val goToProfileButton = findViewById<Button>(R.id.buttonGoToProfile)
        goToProfileButton.setOnClickListener {
            val intent = Intent(this, ProfileInputActivity::class.java)
            startActivity(intent)
        }
    }
}