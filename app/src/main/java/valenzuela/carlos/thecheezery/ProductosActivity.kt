package valenzuela.carlos.thecheezery


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import java.util.ArrayList

class ProductosActivity : AppCompatActivity() {

    private var productsList = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        val bundle: Bundle? = intent.extras
        val message = bundle!!.getString("type")

        if (message != null) {
            addProducts(message)
        }

        val listView = findViewById<ListView>(R.id.listViewProducts)

        val adapter = AdapterProduct(this, productsList)
        val image = findViewById<ImageView>(R.id.productTitle)

        when(message) {
            "Cold Drinks" -> {
                image.setImageResource(R.drawable.colddrinks)
            }
            "Hot Drinks" -> {
                image.setImageResource(R.drawable.hotdrinks)
            }
            "Sweets" -> {
                image.setImageResource(R.drawable.sweets)
            }
            "Salties" -> {
                image.setImageResource(R.drawable.salties)
            }
        }
        listView.adapter = adapter
    }

    private fun addProducts(type: String){
        when(type){
            "Cold Drinks" -> {
                productsList.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
                productsList.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
                productsList.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
                productsList.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
                productsList.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
                productsList.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))
            }

            "Hot Drinks" -> {
                productsList.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
                productsList.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0))
                productsList.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
                productsList.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
                productsList.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
                productsList.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))
            }

            "Sweets" -> {
                productsList.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0))
                productsList.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.0))
                productsList.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.0))
                productsList.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0))
                productsList.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
                productsList.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))
            }

            "Salties" -> {
                productsList.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
                productsList.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0))
                productsList.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.0))
                productsList.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
                productsList.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.0))
            }

        }

    }

    private class AdapterProduct(context: Context, var products: ArrayList<Product>) :
        BaseAdapter() {
        var context :Context? = context

        override fun getCount(): Int {
            return products.size
        }

        override fun getItem(position: Int): Any {
            return products[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val product = products[position]
            val inflator = LayoutInflater.from(context)
            val view = inflator.inflate(R.layout.producto_view, null)

            val image = view.findViewById(R.id.productImg) as ImageView
            val name = view.findViewById(R.id.productName) as TextView
            val description = view.findViewById(R.id.productDescription) as TextView
            val price = view.findViewById(R.id.productPrice) as TextView

            image.setImageResource(product.image)
            name.text = product.name
            description.text = product.description
            price.text = "$${product.price}"

            return view
        }
    }
}