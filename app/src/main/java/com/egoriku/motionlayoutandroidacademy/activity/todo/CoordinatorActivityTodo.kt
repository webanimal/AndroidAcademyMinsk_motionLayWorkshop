package com.egoriku.motionlayoutandroidacademy.activity.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.egoriku.motionlayoutandroidacademy.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.step_10_todo.*

class CoordinatorActivityTodo : AppCompatActivity(R.layout.step_10_todo) {

    var completedTransitionId = R.id.start

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initCoordinatorWithMotion()
    }

    private fun initCoordinatorWithMotion() {
        val listener = AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            motionLayout.progress = -verticalOffset / appbarLayout.totalScrollRange.toFloat()
        }

        appbarLayout.addOnOffsetChangedListener(listener)

        motionLayout.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                super.onTransitionCompleted(motionLayout, currentId)

                completedTransitionId = currentId
            }
        })

        appLogo.setOnClickListener {
            val setExpanded = completedTransitionId != R.id.start
            appbarLayout.setExpanded(setExpanded)
        }
    }
}