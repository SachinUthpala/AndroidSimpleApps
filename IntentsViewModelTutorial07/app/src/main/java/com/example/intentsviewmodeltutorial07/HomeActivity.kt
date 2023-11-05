package com.example.intentsviewmodeltutorial07

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button

class HomeActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HomeActivity> {
        override fun createFromParcel(parcel: Parcel): HomeActivity {
            return HomeActivity(parcel)
        }

        override fun newArray(size: Int): Array<HomeActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)

        button2.setOnClickListener() {

            //explisit intent
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener() {

            val number = "0762712200"
            val uri = Uri.parse(String.format("tel : $number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)


        }

        button4.setOnClickListener() {
            val massage = "Hello MAD 2023"
            val number = "076281222"
            val uri = Uri.parse(String.format("smsto:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_SENDTO
            intent.data = uri
            intent.putExtra("sms_body",massage)
            startActivity(intent)
        }

        button5.setOnClickListener() {
            var url = "https://22222//222//2//2/"
            val uri = Uri.parse(url)
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = uri
            startActivity(intent)
        }

        button6.setOnClickListener() {
            var massage = "hello"
            var mail = arrayOf("sachin@gmail.com")
            val subject = "test"

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "massage/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL,mail)
            intent.putExtra(Intent.EXTRA_SUBJECT,subject)
            intent.putExtra(Intent.EXTRA_TEXT,massage)
            startActivity(intent)



        }

        button7.setOnClickListener() {

        }

    }

}