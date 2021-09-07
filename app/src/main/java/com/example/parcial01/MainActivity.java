package com.example.parcial01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre, edtHorasTrabajadas,edtPrecioHora;
    TextView tvNombre
            , tvHorasTrabajadas
            , tvPago
            , tvNormales
            , tvDobles
            , tvTriplesdo
            , tvPagoNeto;

    Button btnCalcular, btnNuevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = findViewById(R.id.edtNombre);
        edtHorasTrabajadas = findViewById(R.id.edtHorasTrabajadas);
        edtPrecioHora = findViewById(R.id.edtPrecioHora);
        tvNombre = findViewById(R.id.tvNombre);
        tvHorasTrabajadas = findViewById(R.id.tvHorasTrabajadas);
        tvPago = findViewById(R.id.tvPago);
        tvNormales = findViewById(R.id.tvNormales);
        tvDobles = findViewById(R.id.tvDobles);
        tvTriples = findViewById(R.id.tvTriples);
        tvPagoNeto= findViewById(R.id.tvPagoNeto);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnNuevo = findViewById(R.id.btnNuevo);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verificar si hay casillas vacías
                if (TextUtils.isEmpty(edtNombre.getText())) {
                    edtNombre.setError("Ingrese nombre");
                    edtNombre.requestFocus();
                } else if (TextUtils.isEmpty(edtHorasTrabajadas.getText())){
                    edtHorasTrabajadas.setError("Ingrese horas trabajadas");
                    edtHorasTrabajadas.requestFocus();
                } else if (!TextUtils.isDigitsOnly(edtHorasTrabajadas.getText())) {
                    edtHorasTrabajadas.setError("Ingrese horas correctas");
                    edtHorasTrabajadas.requestFocus();

                } else if (TextUtils.isEmpty(edtPrecioHora.getText())){
                    edtPrecioHora.setError("Ingrese precio de horas");
                    edtPrecioHora.requestFocus();
                } else if (!TextUtils.isDigitsOnly(edtPrecioHora.getText())){
                    edtPrecioHora.setError("Ingrese un precio válido");
                    edtPrecioHora.requestFocus();
                } else {
                    //lógica calcular
                    tvNombre.setText("Nombre: " + edtNombre.getText().toString());
                    tvHorasTrabajadas.setText("Horas trabajadas: " + edtHorasTrabajadas.getText().toString());
                    double horasTrabajadas = new Double(edtHorasTrabajadas.getText().toString());
                    double horasExtrasDoble = 0, horasExtrasTriple = 0, horasNormales = 0;
                    if (horasTrabajadas > 44) {
                        horasNormales = 44;
                        //verificar si hay horas dobles
                        if ((horasTrabajadas - 44) <= 6) {
                            horasExtrasDoble = horasTrabajadas - 44;
                        } else {
                            //verificar si hay horas extras tribles
                            horasExtrasDoble = 6;
                            horasExtrasTriple = horasTrabajadas - 50;

                        }
                    } else {
                        horasNormales = horasTrabajadas;
                    }
                    double precioHora = new Double(edtPrecioHora.getText().toString());
                    String salNormal = new Double(horasNormales * precioHora).toString();
                    String salDoble = new Double(horasExtrasDoble * (precioHora * 2)).toString();
                    String salTriple = new Double(horasExtrasTriple * (precioHora * 3)).toString();
                    String salNeto = new Double((horasNormales * precioHora + (horasExtrasDoble * (precioHora * 2)) + (horasExtrasTriple * (precioHora * 3)))).toString();
                    tvPago.setText("****** PAGO ******");
                    tvNormales.setText("Normales:" + salNormal);
                    tvDobles.setText("Dobles $:" + salDoble);
                    tvTriples.setText("Triples $:" + salTriple);
                    tvPagoNeto.setText("Pago Neto$:" + salNeto);


                }
            }
        });

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNombre.setText("");
                edtHorasTrabajadas.setText("");
                edtPrecioHora.setText("");
                tvNombre.setText("Nombre:");
                tvHorasTrabajadas.setText("Horas trabajadas:");
                tvPago.setText("****** PAGO ******");
                tvNormales.setText("Normales $:");
                tvDobles.setText("Dobles $:");
                tvTriples.setText("Triples $:");
                tvPagoNeto.setText("Pago Neto$:");
            }
        });
    }



}