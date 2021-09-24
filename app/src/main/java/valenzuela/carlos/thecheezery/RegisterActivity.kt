package valenzuela.carlos.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button = findViewById(R.id.singInButton) as Button
        button.setOnClickListener{
            var intent: Intent = Intent (this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}