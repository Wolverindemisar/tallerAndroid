package com.example.tallerandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Double num;
    EditText cant_Manillas;
    String materialManilla[];
    String tipoDije[];
    String tipoMaterialDije[];
    String moneda[];
    Spinner comboMaterialManilla;
    Spinner comboTipoDije;
    Spinner comboTipoMaterialDije;
    Spinner comboMoneda;
    TextView resultado;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cant_Manillas = findViewById(R.id.txt_amountBracelet);
        resultado = findViewById(R.id.txt_resultado);
        comboMaterialManilla = findViewById(R.id.cmbMaterial);
        comboTipoDije = findViewById(R.id.cmbTipoDije);
        comboTipoMaterialDije = findViewById(R.id.cmbMaterialDije);
        comboMoneda = findViewById(R.id.cmbMoneda);
        layout = findViewById(R.id.layout_vertical);

        materialManilla = getResources().getStringArray(R.array.material);
        ArrayAdapter<String> adapterMaterial = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, materialManilla);
        comboMaterialManilla.setAdapter(adapterMaterial);

        tipoDije = getResources().getStringArray(R.array.dije);
        ArrayAdapter<String> adapterTipoDije = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipoDije);
        comboTipoDije.setAdapter(adapterTipoDije);

        tipoMaterialDije = getResources().getStringArray(R.array.tipo);
        ArrayAdapter<String> adapterTipoMaterialDije = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipoMaterialDije);
        comboTipoMaterialDije.setAdapter(adapterTipoMaterialDije);

        moneda = getResources().getStringArray(R.array.moneda);
        ArrayAdapter<String> adapterMoneda = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, moneda);
        comboMoneda.setAdapter(adapterMoneda);
    }

    public void visualizarLayout(View v)
    {
        layout.setVisibility(View.VISIBLE);
    }

    public void Limpiar()
    {
        cant_Manillas.setText("");
        comboMaterialManilla.setSelection(0);
        comboTipoMaterialDije.setSelection(0);
        comboTipoDije.setSelection(0);
        comboMoneda.setSelection(0);
        resultado.setText("");
        cant_Manillas.requestFocus();
        layout.setVisibility(View.INVISIBLE);
    }

    public boolean validar()
    {
        return true;
    }

    public void calcular(View v)
    {
            int opcComboMaterialManilla;
            int opcComboTipoDije;
            int opComboTipoMaterialDije;
            num = Double.parseDouble(cant_Manillas.getText().toString());
            opcComboMaterialManilla = comboMaterialManilla.getSelectedItemPosition();
            opcComboTipoDije = comboTipoDije.getSelectedItemPosition();
            opComboTipoMaterialDije = comboTipoMaterialDije.getSelectedItemPosition();


            Limpiar();
    }
}
