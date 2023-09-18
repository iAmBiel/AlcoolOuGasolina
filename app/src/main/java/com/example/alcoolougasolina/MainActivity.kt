package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual: Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23", "No onCreate, $percentual")

        val btCalcular: Button = findViewById(R.id.btCalcular)
        val gasolina: EditText = findViewById(R.id.edGasolina)
        val alcool: EditText = findViewById(R.id.edAlcool)
        val textResultado: TextView = findViewById(R.id.textResultado)
        val switchPorcentagem: Switch = findViewById(R.id.swPercentual)

        // Inicializa o textResultado com um valor padrão
        textResultado.setText("Digite os valores e clique em CALCULAR")

        btCalcular.setOnClickListener(View.OnClickListener {
            if (gasolina.text.isNotEmpty() and alcool.text.isNotEmpty()) {
                var valorGasolina: Double = gasolina.text.toString().toDouble()
                var valorAlcool: Double = alcool.text.toString().toDouble()
                if (valorAlcool <= percentual * valorGasolina) {
                    textResultado.setText("Álcool é a melhor opção!")
                } else {
                    textResultado.setText("Gasolina é a melhor opção!")
                }
            } else {
                textResultado.setText("Preencha os campos corretamente!")
            }
        })

        switchPorcentagem.setOnCheckedChangeListener { _ , isChecked ->
            percentual = if (!isChecked) {
                0.7
            } else {
                0.75
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("PDM23", "No onResume, $percentual")
    }

    override fun onStart() {
        super.onStart()
        Log.d("PDM23", "No onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("PDM23", "No onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("PDM23", "No onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("PDM23", "No onDestroy")
    }
}
