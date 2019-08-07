package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button zero=(Button)findViewById(R.id.zero);
        Button one=(Button)findViewById(R.id.one);
        Button two=(Button)findViewById(R.id.two);
        Button three=(Button)findViewById(R.id.three);
        Button four=(Button)findViewById(R.id.four);
        Button five=(Button)findViewById(R.id.five);
        Button six=(Button)findViewById(R.id.six);
        Button seven=(Button)findViewById(R.id.seven);
        Button eight=(Button)findViewById(R.id.eight);
        Button nine=(Button)findViewById(R.id.nine);
        Button cls=(Button)findViewById(R.id.cls);//清楚全部
        Button div=(Button)findViewById(R.id.div);
        Button mul=(Button)findViewById(R.id.mul);
        Button backspace=(Button)findViewById(R.id.Backspace);
        Button sub=(Button)findViewById(R.id.sub);//减
        Button add=(Button)findViewById(R.id.add);//加
        Button equal=(Button)findViewById(R.id.equal);
         Button point=(Button)findViewById(R.id.point);
         Button percent=(Button)findViewById(R.id.percent);
        editText=(EditText)findViewById(R.id.result);
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        cls.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        backspace.setOnClickListener(this);
        sub.setOnClickListener(this);
        add.setOnClickListener(this);
        equal.setOnClickListener(this);
        point.setOnClickListener(this);
        percent.setOnClickListener(this);
        editText.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        str=editText.getText().toString();
        switch(v.getId()){
            case R.id.zero:
                str+="0";
                editText.setText(str);
                break;
            case R.id.one:
                str+="1";
                editText.setText(str);
                break;
            case  R.id.two:
                str+="2";
                editText.setText(str);
                break;
            case R.id.three:
                str+="3";
                editText.setText(str);
                break;
            case R.id.four:
                str+="4";
                editText.setText(str);
                break;
            case R.id.five:
                str+="5";
                editText.setText(str);
                break;
            case R.id.six:
                str+="6";
                editText.setText(str);
                break;
            case R.id.seven:
                str+="7";
                editText.setText(str);
                break;
            case R.id.eight:
                str+="8";
                editText.setText(str);
                break;
            case R.id.nine:
                str+="9";
                editText.setText(str);
                break;
            case R.id.cls:
                editText.setText("");
                break;
            case R.id.Backspace:
                if (str.length() > 0 )
                {
                    if(str.length()==2)
                        str=str.substring(0,1);
                    else if(str.length()==1)
                        str="";
                    else {
                        if (str.indexOf(" ") == str.length() - 3)
                        {
                            str = str.substring(0, str.length() - 2);
                        }
                        if(str.length()>0)
                        str = str.substring(0, str.length() - 1);
                    }
                }
                editText.setText(str);
                break;
            case R.id.add:
                str+=" + ";
                editText.setText(str);
                break;
            case R.id.sub:
                str+=" - ";
                editText.setText(str);
                break;
            case R.id.mul:
                str+=" * ";
                editText.setText(str);
                break;
            case R.id.div:
                str+=" / ";
                editText.setText(str);
                break;
            case R.id.equal:
                Result();
                break;
            case R.id.point:
                str+=".";
                editText.setText(str);
                break;
            case R.id.percent:
                str+=" % ";
                editText.setText(str);
                break;

        }
    }
    public void Result() {
        double result=0;
        if(str==null||str.equals("")) return;
        if(!str.contains(" "))  return;
        String s1=str.substring(0,str.indexOf(" "));
        String op=str.substring(str.indexOf(" ")+1,str.indexOf(" ")+2);
        String s2=str.substring(str.indexOf(" ")+3);
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2 );
            switch (op)
            {
                case "+": result=d1+d2;break;
                case "-": result=d1-d2;break;
                case "*": result=d1*d2;break;
                case "/":
                {
                    if(d2==0)
                    {
                        Toast.makeText(this, "不能除以零", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    result=d1/d2*1.0;
                }
                break;
            }
            String s=""+result;
            editText.setText(s);

        }
}


