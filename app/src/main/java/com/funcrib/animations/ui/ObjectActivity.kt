package com.funcrib.animations.ui

import android.animation.*
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.funcrib.animations.R
import kotlinx.android.synthetic.main.activity_object.*

class ObjectActivity : AppCompatActivity() {

    private lateinit var fadeAnimator: ObjectAnimator
    private lateinit var scaleAnimator: ObjectAnimator
    private lateinit var translateAnimator: ObjectAnimator
    private lateinit var rotateAnimator: ObjectAnimator
    private lateinit var flipAnimator: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object)

    }

    private fun disableViewDuringAnimation(view: View, animator: ObjectAnimator) {
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                super.onAnimationStart(animation)
                view.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                view.isEnabled = true
            }
        })

    }

    fun scaleAnimation(view: View) {
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.5f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.5f)
        scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(targetImage, scaleX, scaleY)
        scaleAnimator.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            interpolator = OvershootInterpolator()
            disableViewDuringAnimation(btScale, scaleAnimator)
            start()
        }
    }

    fun translateAnimation(view: View) {
        translateAnimator = ObjectAnimator.ofFloat(targetImage, "translationX", 200f)
        translateAnimator.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            interpolator = OvershootInterpolator()
            disableViewDuringAnimation(btTranslate, translateAnimator)
            start()
        }
    }

    fun rotateAnimation(view: View) {
        rotateAnimator = ObjectAnimator.ofFloat(targetImage, "rotation", 0f, 360f)
        rotateAnimator.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            disableViewDuringAnimation(btRotate, rotateAnimator)
            start()
        }
    }

    fun flipAnimation(view: View) {
        flipAnimator = ObjectAnimator.ofFloat(targetImage, "rotationX", 0f, 360f)
        flipAnimator.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            interpolator = AccelerateDecelerateInterpolator()
            disableViewDuringAnimation(btFlip, flipAnimator)
            start()
        }
    }

    fun fadeAnimation(view: View) {
        fadeAnimator = ObjectAnimator.ofFloat(targetImage, "alpha", 1.0f, 0.0f)
        fadeAnimator.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            disableViewDuringAnimation(btFade, fadeAnimator)
            start()
        }
    }

    fun sequentialAnimation(view: View) {

        val rootSet = AnimatorSet()

        val flipAnimator1 = ObjectAnimator.ofFloat(targetImage, "rotationX", 0f, 360f)
        flipAnimator1.apply {
            duration = 500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            disableViewDuringAnimation(btSequentially, flipAnimator1)
            start()
        }
        val translateAnimator1 = ObjectAnimator.ofFloat(targetImage, "translationX", 0f, 200f)
        translateAnimator1.apply {
            duration = 500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            interpolator = AccelerateDecelerateInterpolator()
            disableViewDuringAnimation(btSequentially, translateAnimator1)
            start()
        }

        val childSet = AnimatorSet()

        val flipAnimator2 = ObjectAnimator.ofFloat(targetImage, "rotationX", 0f, 360f)
        flipAnimator2.apply {
            duration = 500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            disableViewDuringAnimation(btSequentially, flipAnimator2)
            start()
        }
        val translateAnimator2 = ObjectAnimator.ofFloat(targetImage, "translationX", 0f, -200f)
        translateAnimator2.apply {
            duration = 500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            interpolator = AccelerateDecelerateInterpolator()
            disableViewDuringAnimation(btSequentially, translateAnimator2)
            start()
        }

        rootSet.play(flipAnimator1).with(translateAnimator1).before(childSet)
        childSet.play(flipAnimator2).with(translateAnimator2)

        rootSet.start()
    }
}