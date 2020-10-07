package com.example.cal;

import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public Button btn1 , btn2 ,btn3 , btn4 , btn5 , btn6 , btn7 , btn8 , btn9 , btn0 , btnmulty , btndiv , btnsum , btnmin , btnequal , btnce , btn100 , btn11;
    TextView op , ans;
    String input ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn100 = (Button) findViewById(R.id.btn10);
        btn11 = (Button) findViewById(R.id.btn11);
        btn0 = (Button) findViewById(R.id.btn8);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn16);
        btn9 = (Button) findViewById(R.id.btn9);
        btnmulty = (Button) findViewById(R.id.btnmul);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnsum = (Button) findViewById(R.id.btn12);
        btnmin = (Button) findViewById(R.id.btn13);
        btnequal = (Button) findViewById(R.id.btn14);
        btnce = (Button) findViewById(R.id.btn5);
        input = "0";
        op = (TextView) findViewById(R.id.op);
        ans = (TextView) findViewById(R.id.ans);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnmulty.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnsum.setOnClickListener(this);
        btnmin.setOnClickListener(this);
        btnequal.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btnce.setOnClickListener(this);
        btn100.setOnClickListener(this);

    }

    public  void  displayop (String a){
        this.op.append(a);
    }
    public void displayans(String b){
        ans.setText(b);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn8 :
                input += "0" ;
                this.displayop("0");
                break;
            case R.id.btn1 :
                input += "1" ;
                this.displayop("1");
                break;
            case R.id.btn2 :
                input += "2" ;
                this.displayop("2");
                break;
            case R.id.btn3 :
                input += "3" ;
                this.displayop("3");
                break;
            case R.id.btn4 :
                input += "4" ;
                this.displayop("4");
                break;
            case R.id.btn:
                input += "5" ;
                this.displayop("5");
                break;
            case R.id.btn6 :
                input += "6" ;
                this.displayop("6");
                break;
            case R.id.btn7 :
                input += "7" ;
                this.displayop("7");
                break;
            case R.id.btn16 :
                input += "8" ;
                this.displayop("8");
                break;
            case R.id.btn9 :
                input += "9" ;
                this.displayop("9");
                break;
            case R.id.btnmul :
                input += " * " ;
                displayop(" * ");
                break;
            case R.id.btndiv :
                input += " / " ;
                displayop(" / ");
                break;
            case R.id.btn12 :
                input += " + " ;
                displayop(" + ");
                break;
            case R.id.btn13:
                input += " - " ;
                displayop(" - ");
                break;
            case R.id.btn5 :
                input += "" ;
                op.setText("");
                ans.setText("");
                break;
            case R.id.btn14 :
                //equal
                op.setText("");
                prepareInput(input);
                input = "" ;
                break;
            case R.id.btn10 :
                //%
                input += " % ";
                displayop(" % ");
                break;

            case R.id.btn11 :
                //.
                input += ".";
                displayop(".");
                break;
        }
    }
    public  void prepareInput(String input){
        if(input.startsWith(" ")){
            String firstChar = String.valueOf(input.charAt(1));
            if (firstChar.contains("/") || firstChar.contains("*")){
                displayans("Error");
            }
            else {
                if(firstChar.contains("+")){
                    input = input.replace("+" , "");
                }
                if(firstChar.contains("-")){
                    input = input.replace(" - " , "-");
                }
            }
        }
        calculate(input);
    }
    public void calculate (String input){
        String[] arr = input.split(" ");
        if(arr.length > 1 ){
            for (int i = 0 ; i < arr.length ; i++){
                float temp = 0 ;
                try {
                    if (arr[i].contains("/")){
                        float op1 = Float.parseFloat(arr[i-1]);
                        float op2 = Float.parseFloat(arr[i+1]);
                        if(op2 == 0){
                            ans.setText("Error");
                            System.out.println("! Not allowed !");
                            input = "" ;
                            return;
                        }
                        temp = op1 / op2 ;
                        arr[i-1] = " ";
                        arr[i] = String.valueOf(temp);
                        arr[i+1] = " ";
                    }
                    if(arr[i].contains("*")){
                        float  op1 = Float.parseFloat(arr[i-1]);
                        float op2 = Float.parseFloat(arr[i+1]);
                        temp = op1 * op2 ;
                        arr[i-1] = " ";
                        arr[i] = String.valueOf(temp);
                        arr[i+1] = " ";
                    }
                    if (arr[i].contains("%")){
                        float op1 = Float.parseFloat(arr[i-1]);
                        float op2 = Float.parseFloat(arr[i+1]);
                        temp = op1 * op2 / 100 ;
                        if (op2 == 0){
                            displayop("0");
                        }
                        arr[i-1] = " ";
                        arr[i] = String.valueOf(temp) ;
                        arr[i+1] = " ";
                    }
                    if(arr[i] .contains(".")){
                        float op1 = Float.parseFloat(arr[i-1]);
                        float op2 = Float.parseFloat(arr[i+1]);
                        for (int b = 0 ; b < arr.length ; b++){
                            arr[i + 1 + b] = String.valueOf(op2);
                        }
                        temp = op1 + (op2 / arr.length) ;
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            for (int i =0 ; i < arr.length ; i++){
                float temp = 0;
                try {
                    if(arr[i].contains("+")){
                        float op1 = Float.parseFloat(arr[i-1]);
                        float op2 = Float.parseFloat(arr[i+1]);
                        temp = op1 + op2 ;
                        arr[i-1] = " ";
                        arr[i] = String.valueOf(temp);
                        arr[i+1] = " ";
                    }
                    if (arr[i].contains("-")){
                        float op1 = Float.parseFloat(arr[i-1]);
                        float op2 = Float.parseFloat(arr[i+1]);
                        temp = op1 - op2 ;
                        arr[i-1] = " ";
                        arr[i] = String.valueOf(temp);
                        arr[i+1] = " ";

                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            this.input = "";
            for (String s : arr){
                if (s != " ") {
                    this.input += s;
                    this.input += " ";
                }
            }
            calculate(this.input);
        }else  {
            displayans(arr[0]);
        }
    }

}
