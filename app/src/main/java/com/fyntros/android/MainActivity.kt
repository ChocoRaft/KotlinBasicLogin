package com.fyntros.android

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import com.google.android.play.core.tasks.Task

//Main Activity Class that starts the app

class MainActivity : AppCompatActivity() {
    private var reviewManager: ReviewManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        //Button that runs the review function
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            showRateAppFallbackDialog()
        }

    }

    private fun createReview(){
        //val manager = FakeReviewManager(applicationContext)
        reviewManager = ReviewManagerFactory.create(this)

        val request = reviewManager!!.requestReviewFlow()
        request.addOnCompleteListener { task: Task<ReviewInfo?> ->
            if (task.isSuccessful) {
                // We can get the ReviewInfo object
                val reviewInfo = task.result
                val flow =
                        reviewManager!!.launchReviewFlow(this, reviewInfo)
                //This function above launches the review flow, popping up the play store UI and the rate/review option

                //Needs a developer account to test.

                flow.addOnCompleteListener { }
            } else {
                Toast.makeText(this, "In-App Review was not called.", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun showRateAppFallbackDialog() {
        MaterialAlertDialogBuilder(this)
                .setTitle("Rate us")
                .setMessage("Liked us? Please rate us on play store")
                .setPositiveButton("Okay") { _, _ -> createReview()
                }
                .setNegativeButton(
                        "Not now"
                ) { _, _ -> }
                .setNeutralButton(
                        "Cancel"
                ) { _, _ -> }
                .setOnDismissListener { }
            .show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}