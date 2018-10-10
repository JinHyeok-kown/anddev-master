package com.example.user.anddev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    EditText et_no1 = null , et_no2 = null;
    TextView tv_calc = null, tv_result = null;
    Button div = null;
    String Operator = "";
    String result1 = "";
    String result2 = "";
//yyyyy
    @Override
    //실행
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();

    }
    private void init() {
        getSupportActionBar().setTitle("계산기");
        et_no1 = findViewById(R.id.et_no1);
        et_no1.setShowSoftInputOnFocus(false);
        et_no2 = findViewById(R.id.et_no2);
        et_no2.setShowSoftInputOnFocus(false);
        tv_calc = findViewById(R.id.tv_calc);
        tv_result = findViewById(R.id.tv_result);

    }

    public void clkRightBtn(View view) {
        Button btn = (Button)view;
        String str = btn.getText().toString();
        Operator = str;
        if(str.equals("C")) {
            result1="";
            result2="";
            Operator="";
            et_no1.setText("");
            et_no2.setText("");
            tv_calc.setText("");
            tv_result.setText("");

        } else {
            tv_calc.setText(str);
        }
    }
    public void inputOperend(View view) {
        Button btn =(Button)view;
        String str = btn.getText().toString();

        if(Operator.equals("") && et_no1.length()<4) {
            result1 += btn.getText();
            et_no1.setText(result1);
        } else if(!Operator.equals("") && et_no2.length()<4){
            result2 += btn.getText();
            et_no2.setText(result2);
        }

    }
    public void inputOperetion(View view) {
        if(Operator.equals("+")) {
            String str =(Integer.parseInt(result1)+Integer.parseInt(result2))+"";
            tv_result.setText(str);
        } else if(Operator.equals("-")) {
            String str =(Integer.parseInt(result1)-Integer.parseInt(result2))+"";
            tv_result.setText(str);
        }else if(Operator.equals("*")) {
            String str =(Integer.parseInt(result1)*Integer.parseInt(result2))+"";
            tv_result.setText(str);
        }else if(Operator.equals("/")) {
            if(result2.equals("0")) {
                tv_result.setText("0");
            } else {
                String str =((double)Integer.parseInt(result1)/Integer.parseInt(result2))+"";
                tv_result.setText(str);
            }
                    }
    }
}
