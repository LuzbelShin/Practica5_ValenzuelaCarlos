package valenzuela.carlos.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.button_start) as Button
        button.setOnClickListener{
            var intent:Intent = Intent (this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

}