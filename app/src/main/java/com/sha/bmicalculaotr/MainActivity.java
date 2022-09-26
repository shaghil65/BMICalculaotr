package com.sha.bmicalculaotr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edtTxtWt, edtTxtHtFt, edtTxtHtIn;
        TextView txtView;
        Button btnResult;
        LinearLayoutCompat layout;

        edtTxtWt = findViewById(R.id.edtTxtWt);
        edtTxtHtFt = findViewById(R.id.edtTxtHtFt);
        edtTxtHtIn = findViewById(R.id.edtTxtHtIn);
        txtView = findViewById(R.id.txtView);
        btnResult = findViewById(R.id.btnCalculate);
        layout = findViewById(R.id.rootMainLayout);

        btnResult.setOnClickListener(v -> {
            int wt = Integer.parseInt(edtTxtWt.getText().toString());
            int ft = Integer.parseInt(edtTxtHtFt.getText().toString());
            int in = Integer.parseInt(edtTxtHtIn.getText().toString());

            int totalIn = ft * 12 + in;

            double totalCm = totalIn * 2.53;

            double totalM = totalCm / 100;

            double bmi = wt / (totalM * totalM);

            if (bmi > 25) {
                txtView.setText(getResources().getString(R.string.OW));
                layout.setBackgroundColor(getResources().getColor(R.color.red));

            } else if (bmi < 18) {
                txtView.setText(getResources().getString(R.string.UW));
                layout.setBackgroundColor(getResources().getColor(R.color.yellow));
            } else {
                txtView.setText(getResources().getString(R.string.Healthy));
                layout.setBackgroundColor(getResources().getColor(R.color.teal_200));
            }
        });





    }
}