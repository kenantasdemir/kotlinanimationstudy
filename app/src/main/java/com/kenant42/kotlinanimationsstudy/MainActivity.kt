package com.kenant42.kotlinanimationsstudy

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import com.kenant42.kotlinanimationsstudy.databinding.ActivityMainBinding
import java.util.Objects

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            alphaAnimation()
        }

        binding.button2.setOnClickListener {
            scaleXAnimation()
        }

        binding.button3.setOnClickListener {
            rotatationAnimation()
        }

        binding.button4.setOnClickListener {
            translationAnimation()
        }

        binding.button5.setOnClickListener {
            delay()
        }

        binding.button6.setOnClickListener {
            ivmeOzelligi()
        }
    }


    fun multipleAnimation(){
        val a = ObjectAnimator.ofFloat(binding.image,"alpha",1.0f,0.0f)
        val sX = ObjectAnimator.ofFloat(binding.image,"scaleX",1.0F,2.0F)
        val sY =ObjectAnimator.ofFloat(binding.image,"scaleY",1.0f,3.0f)

        val coklu = AnimatorSet().apply {
            duration = 1000
            playTogether(a,sX,sY)
        }

        coklu.start()
    }

    fun repeat(){
        val repeat = ObjectAnimator.ofFloat(binding.image,"translationY",0.0f,0.100f).apply {
            duration = 1
           // repeatCount = 4
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
    }

    fun ivmeOzelligi(){
        val ivme = ObjectAnimator.ofFloat(binding.image,"translationY",0.0f,0.300f).apply {
            duration = 3000
            //interpolator = OvershootInterpolator()
            interpolator = BounceInterpolator()
        }
    }

    fun delay(){
        val delay = ObjectAnimator.ofFloat(binding.image,"translationY",0.0f,0.50f).apply {
            duration = 3000
            startDelay = 3000
        }
    }

    fun imageFromLeftToScreen(){
        val animation = ObjectAnimator.ofFloat(binding.image,"translationX",-800.0F,0.0F).apply {
            duration = 3000
        }

        animation.start()
    }

    fun textFromRightToScreen(){
        val animation = ObjectAnimator.ofFloat(binding.textView,"translationY",800.0f,0.0f).apply {
            duration = 3000
        }
        animation.start()
    }

    fun buttonFromDownToScreen(){
        val animation = ObjectAnimator.ofFloat(binding.button1,"translationY",800.0F,0.0F).apply {
            duration = 3000
        }
        animation.start()
    }

    fun translationAnimation(){
        val translationAnimation = ObjectAnimator.ofFloat(binding.textView,"translationX",0.0f,-50.0f).apply {
            duration = 3000
        }
            translationAnimation.start()
    }

    fun rotatationAnimation(){
        val rotation = ObjectAnimator.ofFloat(binding.textView,"rotation",45.0f,90.0f).apply {
            duration = 3000
        }

        rotation.start()
    }

    fun scaleYAnimation(){
        val scaleY = ObjectAnimator.ofFloat(binding.image,"scaleY",1.0f,0.5f).apply {
            duration = 2000
        }

        scaleY.start()
    }

    fun scaleXAnimation(){
        val scale = ObjectAnimator.ofFloat(binding.image,"scaleX",1.0f,2.0f).apply {
            duration = 3000
        }

        scale.start()
    }

    fun alphaAnimation(){
        val alpha = ObjectAnimator.ofFloat(binding.image,"alpha",0.0f,1.0f).apply {
            duration = 3000
        }

        alpha.start()
    }


}