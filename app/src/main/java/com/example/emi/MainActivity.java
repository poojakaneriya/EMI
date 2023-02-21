package com.example.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText amount, interest, month;
    TextView result;
    Button reset, calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.amount);
        interest = findViewById(R.id.interest);
        month = findViewById(R.id.month);
        result = findViewById(R.id.result);
        reset = findViewById(R.id.reset);


        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Float p = Float.parseFloat(amount.getText().toString());
                Float r = Float.parseFloat(interest.getText().toString());
                Float n = Float.parseFloat(month.getText().toString());

                r = r / (12 * 100);

                float final_r = 1.0f;

                for (int i = 0; i < n; i++) {
                    final_r = final_r * (1 + r);
                }
                float f_ans = p * r * (final_r / (final_r - 1));

                result.setText("Your payable amount With Interes.t : " + (f_ans + p) + "\n\n" + "Your Interest Is " + f_ans);

            }

        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount.setText("");
                interest.setText("");
                month.setText("");
                result.setText("");


            }
        });
    }
}