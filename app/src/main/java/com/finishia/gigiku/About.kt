package com.finishia.gigiku

import android.content.Intent
import android.net.InetAddresses
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.about.*
import javax.security.auth.Subject

class About:AppCompatActivity(), View.OnClickListener {
    private var title :String = "About Me"

    companion object{
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_SUBJECT = "extra_subject"
        const val EXTRA_TEXT = "extra_text"

    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)
        setActionBarTitle(title)
        supportActionBar!!.title = "About Me"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val btnDialPhone: Button = findViewById(R.id.btn_phone)
        btnDialPhone.setOnClickListener(this)

        val btnSendEmail: Button= findViewById(R.id.btn_email)
        btnSendEmail.setOnClickListener(this)

    }


    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.btn_phone -> {
                val phoneNumber = "082131830898"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_email -> {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "*/*"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf<String>("drg.finish@gmail.com"))
                    putExtra(Intent.EXTRA_SUBJECT, "subject")
                    putExtra(Intent.EXTRA_TEXT, "text")
                }
                startActivity(intent)

            }
        }
    }

}