package com.example.convertmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner SpinFrom, SpinTo;
    EditText edtAmount;
    TextView txtResult2, txtSpinFrom;
    int a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpinFrom = (Spinner)findViewById(R.id.SpinFrom);
        SpinTo = (Spinner)findViewById(R.id.SpinTo);
        edtAmount = (EditText)findViewById(R.id.edtAmount);
        txtResult2 = (TextView)findViewById(R.id.txtResult2);


        final ArrayList<String> items = new ArrayList<String>();
        items.add("VND");
        items.add("USD");
        items.add("JPY");
        items.add("EUR");
        items.add("GBP");
        items.add("RUB");
        items.add("CNY");
        items.add("KRW");
        items.add("INR");
        items.add("SGD");

        final Double[] values = new Double[]{1.0, 23270.00, 220.56, 27474.23, 30172.96, 301.11, 3486.36, 20.48, 315.57, 17115.75};

        ArrayAdapter<String> adapterFrom = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items);
        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinFrom.setAdapter(adapterFrom);

        SpinFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, items.get(i), Toast.LENGTH_SHORT).show();
                a = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SpinTo.setAdapter(adapterFrom);

        SpinTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, items.get(i), Toast.LENGTH_SHORT).show();
                b = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        edtAmount.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() > 0){
                    double edt = Double.parseDouble(edtAmount.getText().toString());
                    double res = (double)Math.round(edt * values[a] / values[b] * 1000) / 1000;

                    txtResult2.setText(String.valueOf(res));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


}