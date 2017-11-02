package com.example.pichau.jogodoarrocha

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.LinearLayout
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    lateinit var tvResultado: TextView
    lateinit var layoutz: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        this.tvResultado = findViewById(R.id.tvResultado)

        this.layoutz = findViewById(R.id.layoutId)

        if(intent.getStringExtra("TEXTO").toString() == "Voce ganhou!!!" ){
            this.layoutz.setBackgroundColor(Color.GREEN)
            this.tvResultado.text = intent.getStringExtra("TEXTO")
        }else{
            this.layoutz.setBackgroundColor(Color.RED)
            this.tvResultado.text = intent.getStringExtra("TEXTO")
        }

    }
}
