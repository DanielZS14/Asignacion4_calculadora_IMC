package zazueta.daniel.asignacion4_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val estatura: EditText = findViewById(R.id.etEstatura) as EditText
        val peso: EditText = findViewById(R.id.etPeso) as EditText
        val calcularImc: Button = findViewById(R.id.btnIMC) as Button
        val imc: TextView = findViewById(R.id.tvIMC) as TextView
        val rango: TextView = findViewById(R.id.tvRango) as TextView

        calcularImc.setOnClickListener {
            var resultadoImc: Double =
                calcularIMC(estatura.text.toString().toDouble(), peso.text.toString().toDouble())
            var rangoIMC: String = obtenerRango(resultadoImc)
            imc.setText(resultadoImc.toString())
            rango.setText(rangoIMC)
            when (rangoIMC) {
                "Bajo Peso" -> rango.setBackgroundResource(R.color.colorGreenish)
                "Normal" -> rango.setBackgroundResource(R.color.colorGreen)
                "Sobrepeso" -> rango.setBackgroundResource(R.color.colorYellow)
                "Obesidad grado 1" -> rango.setBackgroundResource(R.color.colorOrange)
                "Obesidad grado 2" -> rango.setBackgroundResource(R.color.colorBrown)
                "Obesidad grado 3" -> rango.setBackgroundResource(R.color.colorRed)
                else -> rango.setBackgroundResource(R.color.white)
            }

        }
    }
    //calculo de IMC
    fun calcularIMC(estatura: Double,peso:Double ):Double {
        return peso / (estatura * estatura)
    }

    //obtener rango de IMC
    fun obtenerRango(imc:Double):String {
        return when(imc){
            in 1.0..18.59 -> "Bajo Peso"
            in 18.6..24.99-> "Normal"
            in 25.0..29.99 -> "Sobrepeso"
            in 30.0..34.99 -> "Obesidad grado 1"
            in 35.0..39.99 -> "Obesidad grado 2"
            in 40.0..100.0 -> "Obesidad grado 3"
            else -> "fuera de rango"
        }
    }
}



