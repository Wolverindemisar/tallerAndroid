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
        if(validar())
        {
            layout.setVisibility(View.VISIBLE);
        }
    }

    public void Limpiar(View v)
    {
        cant_Manillas.setText("");
        comboMaterialManilla.setSelection(0);
        comboTipoMaterialDije.setSelection(0);
        comboTipoDije.setSelection(0);
        comboMoneda.setSelection(0);
        resultado.setText("");
        cant_Manillas.requestFocus();
        layout.setVisibility(v.INVISIBLE);
    }

    public boolean validar()
    {
        if(cant_Manillas.getText().toString().isEmpty())
        {
            cant_Manillas.setError(getResources().getString(R.string.error_1));
            return false;
        }
        return true;
    }

    public void calcular(View v)
    {
        if(validar())
        {
            int opcComboMaterialManilla;
            int opcComboTipoDije;
            int opComboTipoMaterialDije;
            int opComboMoneda;
            opcComboMaterialManilla = comboMaterialManilla.getSelectedItemPosition();
            opcComboTipoDije = comboTipoDije.getSelectedItemPosition();
            opComboTipoMaterialDije = comboTipoMaterialDije.getSelectedItemPosition();
            opComboMoneda = comboMoneda.getSelectedItemPosition();

            if(opcComboMaterialManilla == 0 && opcComboTipoDije == 0)
            {
                if(opComboTipoMaterialDije == 0 || opComboTipoMaterialDije == 1)
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,100));
                }
                else if(opComboTipoMaterialDije == 2)
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,80));
                }
                else
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,70));
                }
            }
            else if(opcComboMaterialManilla == 0 && opcComboTipoDije == 1)
            {
                if(opComboTipoMaterialDije == 0 || opComboTipoMaterialDije == 1)
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,120));
                }
                else if(opComboTipoMaterialDije == 2)
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,100));
                }
                else
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,90));
                }
            }
            else if(opcComboMaterialManilla == 1 && opcComboTipoDije == 0)
            {
                if(opComboTipoMaterialDije == 0 || opComboTipoMaterialDije == 1)
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,90));
                }
                else if(opComboTipoMaterialDije == 2)
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,70));
                }
                else
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,50));
                }
            }
            else
            {
                if(opComboTipoMaterialDije == 0 || opComboTipoMaterialDije == 1)
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,110));
                }
                else if(opComboTipoMaterialDije == 2)
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,90));
                }
                else
                {
                    resultado.setText("" + conversionMoneda(opComboMoneda,80));
                }
            }
        }
    }


    public double conversionMoneda(int op,double val)
    {
        num = Double.parseDouble(cant_Manillas.getText().toString());
        switch (op)
        {
            case 0:
                val = (val * 3200) * num;
                return val;
            case 1:
                return (val * num);
        }
        return 0;
    }
}
