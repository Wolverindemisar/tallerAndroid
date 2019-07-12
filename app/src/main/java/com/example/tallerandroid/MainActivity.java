package com.example.tallerandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    EditText cant_Manillas;
    String materialManilla[];
    String tipoDije[];
    String tipoMaterialDije[];
    Spinner comboMaterialManilla;
    Spinner comboTipoDije;
    Spinner comboTipoMaterialDije;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cant_Manillas = findViewById(R.id.txt_amountBracelet);
        resultado = findViewById(R.id.txt_resultado);
        comboMaterialManilla = findViewById(R.id.cmbMaterial);
        comboTipoDije = findViewById(R.id.cmbTipoDije);
        comboTipoMaterialDije = findViewById(R.id.cmbMaterialDije);

        materialManilla = getResources().getStringArray(R.array.material);
        ArrayAdapter<String> adapterMaterial = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, materialManilla);
        comboMaterialManilla.setAdapter(adapterMaterial);

        tipoDije = getResources().getStringArray(R.array.dije);
        ArrayAdapter<String> adapterTipoDije = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipoDije);
        comboTipoDije.setAdapter(adapterTipoDije);

        tipoMaterialDije = getResources().getStringArray(R.array.tipo);
        ArrayAdapter<String> adapterTipoMaterialDije = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipoMaterialDije);
        comboTipoMaterialDije.setAdapter(adapterTipoMaterialDije);
    }

    public void visualizarLayout()
    {

    }

    public void Limpiar()
    {

    }

    public void validar()
    {

    }

    public void calcular(View v)
    {

    }
}
