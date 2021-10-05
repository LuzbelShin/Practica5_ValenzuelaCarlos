package valenzuela.carlos.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonColdDrinks: Button = findViewById(R.id.coldDrinksButton)
        val buttonHotDrinks: Button  = findViewById(R.id.hotDrinksButton)
        val buttonSweets: Button  = findViewById(R.id.sweetsButton)
        val buttonSalties: Button  = findViewById(R.id.saltiesButton)

        buttonColdDrinks.setOnClickListener{
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("type", "Cold Drinks")
            startActivity(intent)
        }

        buttonHotDrinks.setOnClickListener{
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("type", "Hot Drinks")
            startActivity(intent)
        }

        buttonSweets.setOnClickListener{
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("type", "Sweets")
            startActivity(intent)
        }

        buttonSalties.setOnClickListener{
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("type", "Salties")
            startActivity(intent)
        }
    }
}