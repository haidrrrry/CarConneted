package com.codecue.carconnected.Activities.OnboardingActitvty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.codecue.carconnected.Adapters.OnboardingAdapter
import com.codecue.carconnected.R
import com.codecue.carconnected.models.onboarding_model

class Onboarding_Splash : AppCompatActivity() {

    private lateinit var onboradingitemAdapter: OnboardingAdapter
    private lateinit var indictorcontainer: LinearLayout
    private lateinit var tvSkip: TextView
    private lateinit var getstartedbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_splash)

        initializeViews()
        setOnClickListner()
        setonboardingitem()
        setupindicator()
        setCurrentindictor(0)
    }

    private fun setOnClickListner() {
        getstartedbtn.setOnClickListener {

            val i= Intent(this,getstart_Activity::class.java)
            startActivity(i)
        }

        tvSkip.setOnClickListener {
            val i= Intent(this, getstart_Activity::class.java)
            startActivity(i)
        }

    }

    private fun initializeViews() {

        getstartedbtn=findViewById(R.id.onboarding_btn)
        tvSkip=findViewById(R.id.skip_tv)
    }

    private fun setonboardingitem()
    {
        onboradingitemAdapter= OnboardingAdapter(
            listOf(

                onboarding_model(
                    onboardingimage = R.drawable.onboardingscreenitem_1,
                    descriptoin="khan jsndaj ",
                    title="Lots of Doctors Available Whenever You Need"
                ),
                onboarding_model(
                    onboardingimage = R.drawable.onboardingscreenitem_2,
                    descriptoin="khan jsndaj ",
                    title="Chat and Consultation without Hassle "

                )
            )

        )

        val onboardinviewpager=findViewById<ViewPager2>(R.id.onboarding_viewpager)
        onboardinviewpager.adapter=onboradingitemAdapter
        if (onboardinviewpager.currentItem +1 >onboradingitemAdapter.itemCount )
        {
            getstartedbtn.visibility= View.INVISIBLE
        }
        onboardinviewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentindictor(position)
            }

        })
        (onboardinviewpager.getChildAt(0) as RecyclerView).overScrollMode=
            RecyclerView.OVER_SCROLL_NEVER

    }
    private fun setupindicator(){

        indictorcontainer=findViewById(R.id.onboarding_indictor_contanier)
        val indicator = arrayOfNulls<ImageView>(onboradingitemAdapter.itemCount)
        val layoutparams: LinearLayout.LayoutParams=
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutparams.setMargins(8,0,8,0)
        for (i in indicator.indices)
        {
            indicator[i]= ImageView(applicationContext)
            indicator[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(


                        applicationContext,
                        R.drawable.indictor_inactive_onboarding)
                )
                it.layoutParams=layoutparams
                indictorcontainer.addView(it)
            }

        }
    }
    private fun setCurrentindictor(position:Int)
    {
        val childCount=indictorcontainer.childCount
        for (i in 0 until childCount)
        {
            val imageView=indictorcontainer.getChildAt(i) as ImageView
            if (position==1)
            {
                getstartedbtn.visibility= View.VISIBLE
            }
            else{
                getstartedbtn.visibility= View.INVISIBLE
            }
            if (i==position)
            {

                imageView.setImageDrawable(
                    ContextCompat.getDrawable(

                        applicationContext,R.drawable.indictor_active_onboarding


                    )
                )
            }
            else
            {

                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,R.drawable.indictor_inactive_onboarding
                    )
                )

            }

        }

    }
}