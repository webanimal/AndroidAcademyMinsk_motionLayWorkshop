package com.egoriku.motionlayoutandroidacademy.activity.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.egoriku.motionlayoutandroidacademy.R
import com.egoriku.motionlayoutandroidacademy.common.toast
import kotlinx.android.synthetic.main.step_9.*

class MotionActivityTodo : AppCompatActivity(R.layout.step_9) {

    private var completedTransitionId = R.id.start

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        motionLayout.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                super.onTransitionCompleted(motionLayout, currentId)

                completedTransitionId = currentId
            }
        })

        login_text.setOnClickListener {
            when (completedTransitionId) {
                R.id.start -> toast("Perform Login")
                else -> motionLayout.transitionToStart()
            }
        }

        sign_up_text.setOnClickListener {
            when (completedTransitionId) {
                R.id.end -> toast("Perform Sign Up")
                else -> motionLayout.transitionToEnd()
            }
        }
    }
}
