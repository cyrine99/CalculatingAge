package com.example.calculatingageinminutes

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var  datePicker: DatePicker


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("احسب عمرك ")

        datePicker =findViewById(R.id.date_picker)


        val today=Calendar.getInstance()

        val year=today.get(Calendar.YEAR)
        val month =today.get(Calendar.MONTH)+1
        val day=today.get(Calendar.DAY_OF_MONTH)
        val todayDate="$day-$month-$year"

        val yearBD=datePicker.year
        val monthBD =datePicker.month+1
        val dayBD=datePicker.dayOfMonth
        var birthDate="$dayBD-$monthBD-$yearBD"

        datePicker.setMaxDate(today.timeInMillis)

        datePicker.init(year,month,day)
        { view , year, month,day ->
            val month=month+1
            birthDate="$day-$month-$year"

        }

        val but : Button = findViewById(R.id.but_calculating)

        but.setOnClickListener {

            //Toast.makeText(applicationContext,"BD"+birthDate+ "  / "+"Today"+todayDate,Toast.LENGTH_LONG).show()
            val obj = AgeCalculating(birthDate,todayDate)
            dialog(obj.calculating())

            }
        }

    private  fun dialog(text:String)
    {
        val alert = AlertDialog.Builder(this)
        val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.age_result,null)


        alert.setView(view)
        alert.setCancelable(true)

        val alertDialog = alert.create()
        alertDialog.show()

        val but_ok:Button= view.findViewById(R.id.but_ok)
        val tv:TextView =view.findViewById(R.id.tv_age)

        tv.setText(text)

        but_ok.setOnClickListener {
            alertDialog.dismiss();
        }
    }
    }
