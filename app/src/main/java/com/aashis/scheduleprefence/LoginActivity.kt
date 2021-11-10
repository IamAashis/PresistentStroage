package com.aashis.scheduleprefence

import android.R.string
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aashis.scheduleprefence.util.PreferenceUtils


class LoginActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var edtEmail: EditText
    lateinit var btnLogin: Button
    val preferenceUtils = PreferenceUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        edtEmail = findViewById(R.id.email)
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener(this)

        var checkName: string

        if (preferenceUtils.getLoginState(baseContext)) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onClick(view: View) {
        if (view == btnLogin) {
            val preferenceUtils = PreferenceUtils

            val name = edtEmail.editableText.toString()
            preferenceUtils.setLoginState(baseContext, true)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}