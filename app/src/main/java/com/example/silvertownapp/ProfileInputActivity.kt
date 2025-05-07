package com.example.silvertownapp  // 네 패키지명에 맞게 수정해야 해

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_input)

        val nameEditText = findViewById<EditText>(R.id.editTextName)
        val ageEditText = findViewById<EditText>(R.id.editTextAge)
        val hobbyEditText = findViewById<EditText>(R.id.editTextHobby)
        val saveButton = findViewById<Button>(R.id.buttonSaveProfile)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()
            val hobby = hobbyEditText.text.toString()

            // 간단하게 입력값 출력
            Toast.makeText(this, "이름: $name\n나이: $age\n취미: $hobby", Toast.LENGTH_LONG).show()

            // 추후 여기에 저장하는 코드 추가할 수 있음
        }
    }
}
