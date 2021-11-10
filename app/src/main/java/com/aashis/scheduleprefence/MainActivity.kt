package com.aashis.scheduleprefence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aashis.scheduleprefence.util.Constants
import com.aashis.scheduleprefence.util.FileFunctions
import com.aashis.scheduleprefence.util.PreferenceUtils

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var submitBtn: Button
    private lateinit var btnDeleteFile: Button
    private lateinit var fileText: EditText
    private lateinit var fileTextData: TextView
    private lateinit var logOutBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitBtn = findViewById(R.id.btnSubmit)
        btnDeleteFile = findViewById(R.id.btnDeleteFile)
        fileText = findViewById(R.id.fileText)
        fileTextData = findViewById(R.id.fileTextShow)
        logOutBtn = findViewById(R.id.btnLogout)

        FileText()
        submitBtn.setOnClickListener(this)
        btnDeleteFile.setOnClickListener(this)
        logOutBtn.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view == submitBtn) {

            Toast.makeText(this, Constants.LOG_FILE_NAME, Toast.LENGTH_LONG).show()
            FileFunctions.appendFileValue(
                Constants.LOG_FILE_NAME,
                fileText.text.toString(),
                applicationContext
            )
            fileText.setText("")
            FileText()
        } else if (view == btnDeleteFile) {
            FileFunctions.deleteFile(Constants.LOG_FILE_NAME, applicationContext)
            Toast.makeText(this, Constants.LOG_FILE_NAME, Toast.LENGTH_LONG).show()

        } else if (view == logOutBtn) {
            PreferenceUtils.removeLoginState(applicationContext)
            Toast.makeText(this, getString(R.string.logOutSuccess), Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }

    fun FileText() {
        fileTextData.text =
            FileFunctions.getFileValue(Constants.LOG_FILE_NAME, applicationContext).toString()

    }


}