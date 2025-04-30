package com.example.silvertownapp

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class DailyQuestionActivity : AppCompatActivity() {
    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_question)
        val textView = findViewById<TextView>(R.id.textViewQuestion)
        val buttonHappy = findViewById<Button>(R.id.buttonHappy)
        val buttonSad = findViewById<Button>(R.id.buttonSad)
        val buttonNeutral = findViewById<Button>(R.id.buttonNeutral)

        // TTS 초기화하고 질문 읽어주기
        tts = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale.KOREAN
                tts.speak("오늘의 기분은?", TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }

        // 버튼 클릭 시 음성 출력
        buttonHappy.setOnClickListener {
            val message = "오늘은 기쁜 날이에요!"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, null)
        }

        buttonSad.setOnClickListener {
            val message = "오늘은 슬펐군요. 힘내세요!"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, null)
        }

        buttonNeutral.setOnClickListener {
            val message = "오늘은 평범한 하루였군요!"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    override fun onDestroy() {
        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
        super.onDestroy()
    }
}