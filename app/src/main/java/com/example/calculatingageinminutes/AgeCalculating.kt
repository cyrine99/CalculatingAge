package com.example.calculatingageinminutes


import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.Month
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs

class AgeCalculating (birthDate:String , todayDate:String)
{
    var birthDate:String
    var todayDate:String

    init
    {
         this.birthDate =birthDate
         this.todayDate=todayDate
    }




    fun calculating(): String
    {

        val todayDateNow:Date
        val birthDateAge:Date
        val dates=SimpleDateFormat("dd-MM-yyyy")

        todayDateNow=dates.parse(todayDate)
        birthDateAge=dates.parse(birthDate)




        if(todayDateNow.compareTo(birthDateAge)==0)
        {
            val today=Calendar.getInstance()

            val HOUR_OF_DAY=today.get(Calendar.HOUR_OF_DAY)

            var MINUTE_OF_DAY = (HOUR_OF_DAY*60)+today.get(Calendar.MINUTE)


            if(HOUR_OF_DAY==0)
            {
                MINUTE_OF_DAY=today.get(Calendar.MINUTE)
            }
            var SECOND_OF_DAY = MINUTE_OF_DAY *60

            var y_m_d=0
            return "$y_m_d سنة "+"\n"+" $y_m_d  شهر "+"\n"+"  $y_m_d يوم  "+"\n"+" $HOUR_OF_DAY  ساعة "+"\n"+" $MINUTE_OF_DAY دقيقة "+"\n"+" $SECOND_OF_DAY  ثانية "

        }
       
        else
        {

            val diff= abs(todayDateNow.time - birthDateAge.time)



            val age_in_secound= diff /1000//عمر بالثواني

            val age_in_days= diff / (24*60*60*1000)//عمر بالأيام

            //اليوم به 0.032855 شهر
            val age_in_month = (age_in_days*0.032855).toInt()//عمر بالأشهر

            val age_in_hours= diff / (60*60*1000)//عمر بالساعات

            val age_in_year = age_in_days/365// عمر بالسنوات

            //1440 عدد الدقائق في اليوم
            val age_in_minutes = (age_in_days * 1440)//عمر بالدقائق


            return " $age_in_year  سنة   "+"\n"+" $age_in_month شهر "+"\n"+" $age_in_days يوم "+"\n"+" $age_in_hours  ساعة "+"\n"+" $age_in_minutes دقيقة "+"\n"+" $age_in_secound  ثانية "
        }


    }
}
