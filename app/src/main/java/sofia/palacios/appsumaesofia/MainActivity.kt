package sofia.palacios.appsumaesofia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1. Llamar a todos los elementos de la vista
        val txtNum1 = findViewById<EditText>(R.id.txtNum1)
        val txtNum2 = findViewById<EditText>(R.id.txtNum2)
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val lblResultado= findViewById<TextView>(R.id.lblResultado)

        //2. Crear un objeto de la clase Calculadora
        //para accceder al método
        val objCal = Calculadora()

        //3. Programar: el botón
        btnSumar.setOnClickListener {
        val resul =  objCal.sumar(txtNum1.text.toString().toInt(), txtNum2.text.toString().toInt())

            println("Este es el resultado: $resul")

            lblResultado.text = "El resultado es $resul"




        }

    }
}