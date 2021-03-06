package com.example.pichau.servicos

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.graphics.Bitmap
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    lateinit var btFoto:Button
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btFoto = findViewById(R.id.btFoto)
        this.btFoto.setOnClickListener{tirarFoto(it)}




    }

    fun tirarFoto(view:View){
        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(it.resolveActivity(packageManager) != null){
            startActivityForResult(it, REQUEST_IMAGE_CAPTURE)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            val img = data?.extras
            val it = Intent(Intent.ACTION_SEND)
            it.setType("image/*")
            it.putExtra(Intent.EXTRA_STREAM, img)
            startActivity(it)
        }
    }


}
