package com.example.pichau.jogodoarrocha

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    val random = Random()
    var num_sorteado : Int = rand(1, 99)
    var pontuacao = 50
    var valor_minimo : Int = 0
    var valor_maximo : Int = 100
    lateinit var etChute: EditText
    lateinit var btnChutar : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChutar = findViewById(R.id.btnMainChutar)
        btnChutar.setOnClickListener{(onClick(it))}

        etChute = findViewById(R.id.etMainEntrada)
    }

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }

    fun verificarChute(){
        if(etChute.text.toString() == num_sorteado.toString() ||
                etChute.text.toString().toInt() <= valor_minimo ||
                etChute.text.toString().toInt() >= valor_maximo){
            this.pontuacao -= 10
           Toast.makeText(this,"Vc Perdeu! num sorteado: ${this.num_sorteado}", Toast.LENGTH_SHORT).show()
        }else if(etChute.text.toString().toInt() < num_sorteado){
            this.valor_minimo = etChute.text.toString().toInt()
            this.pontuacao += 5
            Toast.makeText(this, "Novo limite inferior: ${this.valor_minimo}", Toast.LENGTH_SHORT).show()
        }else if(etChute.text.toString().toInt() > num_sorteado){
            this.valor_maximo = etChute.text.toString().toInt()
            this.pontuacao += 5
            Toast.makeText(this, "Novo limite maximo: ${this.valor_maximo}", Toast.LENGTH_SHORT).show()
        }

        if(this.pontuacao <= 0){
            Toast.makeText(this, "Voce Perdeu!, pontuacao : ${this.pontuacao}", Toast.LENGTH_SHORT).show()
            //TELA VERMELHA : VC PERDEU!
        }else{
            Toast.makeText(this, "Sua pontuacao: ${this.pontuacao}", Toast.LENGTH_SHORT).show()
        }

        //QUANDO GANHAR
        if(this.valor_minimo == this.num_sorteado - 1 && this.valor_maximo == this.num_sorteado + 1){
            Toast.makeText(this, "VC GANHOU! PARABENS. Arrochou (${this.num_sorteado})", Toast.LENGTH_SHORT).show()
        }
    }


    fun onClick(view: View){
        verificarChute()
        //Toast.makeText(this, num_sorteado.toString(), Toast.LENGTH_SHORT).show()
    }
}
