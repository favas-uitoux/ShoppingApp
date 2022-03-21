package com.project.shoppingapp.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.project.shoppingapp.R
import maes.tech.intentanim.CustomIntent.customType

class SplashScreenActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({ gotoNextScreen() }, 3000)


    }


    private fun gotoNextScreen() {
        startActivity(Intent(this@SplashScreenActivity, DashBoardActivity::class.java))
        customType(this@SplashScreenActivity, "fadein-to-fadeout")

        finish()

    }

}