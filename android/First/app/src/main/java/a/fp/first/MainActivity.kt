package a.fp.first

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private fun goToNextActivity(){
        val intent = Intent(this, NextActivity::class.java)
        Handler().postDelayed({ startActivity(intent) }, 200)
    }

    private var ignoreflag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextBtn.setOnClickListener {
            if(ignoreflag) return@setOnClickListener
            Thread(){
                kotlin.run { Thread.sleep(200) ; ignoreflag = false }
            }.start()
            ignoreflag = true
            goToNextActivity()
        }

        loadBtn.setOnClickListener {
            Thread.sleep(3000)
            textView.text = "ロードしたつもり"
        }

        resetBtn.setOnClickListener{
            textView.text = "リセットした"
        }

    }
}
