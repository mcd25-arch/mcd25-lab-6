package com.example.lab6;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void compoundInterest(View view) {
        TextView tv1;
        TextView tv2;
        EditText et1;
        EditText et2;
        EditText et3;
        int principal;
        int years;
        double interest;

        tv1 = (TextView) findViewById(R.id.CompundInterest);
        tv2 = (TextView) findViewById(R.id.result);

        et1 = (EditText) findViewById(R.id.principal);
        principal = Integer.parseInt(et1.getText().toString());

        et2 = (EditText) findViewById(R.id.years);
        years = Integer.parseInt(et2.getText().toString());

        et3 = (EditText) findViewById(R.id.interest);
        interest = Double.parseDouble(et3.getText().toString());

        double result = principal(years, principal, interest);
        tv2.setText(String.format("Principal after %d is %.2f\n",years, result));
        double AInterest = result - principal;
        tv2.append(String.format("Accrued Interest: %.2f",AInterest));

    }

    public double principal(int y, double p_org, double i_rate) {
        if (y == 0) {
            return p_org;
        } else {
            return principal(y - 1, p_org, i_rate) * (1.0 + i_rate);
        }
    }
}