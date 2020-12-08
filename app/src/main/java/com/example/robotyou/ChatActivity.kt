package com.example.robotyou

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import androidx.core.view.setPadding

class ChatActivity : AppCompatActivity() {
    private lateinit var container: LinearLayout
    private lateinit var sendBtn: ImageButton
    private lateinit var chatText: EditText
    private lateinit var clearBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        container = findViewById(R.id.ll_chat_container)
        initializeSendButton()
        initializeClearButton()
    }

    private fun initializeClearButton() {
        clearBtn = findViewById(R.id.ib_clear)
        clearBtn.setOnClickListener {
            container.removeAllViews()
        }
    }

    private fun initializeSendButton() {
        sendBtn = findViewById(R.id.ib_send)
        chatText = findViewById(R.id.et_chat_text)
        sendBtn.setOnClickListener {
            createChatMessage(chatText.text.toString(), 1)
            createReplyMessage(chatText.text.toString())
            chatText.setText("")
        }
    }

    private fun createChatMessage(chat: String, type: Int) {
        val ll: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val rl: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        val relativeContainer = RelativeLayout(this)

        val chatContainer = CardView(this)
        chatContainer.radius = 20F
        if (type == 1){
            chatContainer.setCardBackgroundColor(ContextCompat.getColor(this, R.color.grey))
        }else{
            chatContainer.setCardBackgroundColor(ContextCompat.getColor(this, R.color.primary))
        }
        chatContainer.cardElevation = 0F

        val scale = resources.displayMetrics.density
        val vertical = (5 * scale + 0.5f).toInt()
        val horizontal = (15 * scale + 0.5f).toInt()

        val chatText = TextView(this)
        chatText.textSize = 16F
        chatText.text = chat
        chatText.setTextColor(ContextCompat.getColor(this, R.color.black))
        chatText.setPadding(horizontal, vertical, horizontal, vertical)
        chatContainer.addView(chatText, rl)

        if (type == 1){
            rl.addRule(RelativeLayout.ALIGN_PARENT_END)
        }else{
            rl.addRule(RelativeLayout.ALIGN_PARENT_START)
        }
        rl.setMargins(horizontal, horizontal, horizontal, 0)
        relativeContainer.addView(chatContainer, rl)

        container.addView(relativeContainer, ll)
    }

    private fun createReplyMessage(chat: String) {
        var robotText = "Hai sayang"
        if(chat.contains("masalah") || chat.contains("cerita")){
            robotText = "Yuk sini ceritaa"
        }
        else if(chat.contains("kangen")){
            robotText = "Yuk sini ceritaa"
        }
        else if(chat.contains("doi")){
            robotText = "Kan ada aku disini ;)"
        }
        else if(chat.contains("cuek")){
            robotText = "Sini cerita sama aku ajaa"
        }
        else if(chat.contains("bokek")){
            robotText = "Mom push cow\nEh canda, yuk mulai belajar berhematt"
        }
        else if(chat.contains("dimarahin") || chat.contains("dimarain")){
            robotText = "Siapa yang marahin kamu?"
        }
        else if(chat.contains("hiks") || chat.contains("huhu")){
            robotText = "Jangan sedih teruss kan ada aku ;)"
        }
        else if(chat.contains("yuhu")){
            robotText = "Ada apa zheyenkk"
        }
        else if(chat.contains("hai") || chat.contains("halo")){
            robotText = "Haii kenalan yuk"
        }
        else if(chat.contains("belum makan")||chat.contains("belom makan")||chat.contains("lom makan")||chat.contains("laper")||chat.contains("lapar")){
            robotText = "Makan dulu gihh. Ntar kamu sakit lohh"
        }
        else if(chat.contains("makan")){
            robotText = "Selamat makann"
        }
        else if(chat.contains("euy")){
            robotText = "Oii"
        }
        else if(chat.contains("bau")){
            robotText = "Mandi gih baunya nyebar ampe sini"
        }
        else if(chat.contains("ortu")||chat.contains("orang tua")){
            robotText = "Orang tua kamu kenapaa"
        }
        else if(chat.contains("berantem")){
            robotText = "Tapi kamu gapapa kan??"
        }
        createChatMessage(robotText, 0)
    }
}