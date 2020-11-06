package com.example.pn17_i04_001_ev_2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtV1;
    private TextView txtV2;
    private String Operacion="";
    private String Resultado="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        txtV1=findViewById(R.id.txtV1);
        txtV2=findViewById(R.id.txtV2);

        Button btnAC=findViewById(R.id.btnAC);
        Button btnDEL=findViewById(R.id.btnDEL);
        Button btnSuma=findViewById(R.id.btnSuma);
        Button btnResta=findViewById(R.id.btnResta);
        Button btn7=findViewById(R.id.btn7);
        Button btn8=findViewById(R.id.btn8);
        Button btn9=findViewById(R.id.btn9);
        Button btnMult=findViewById(R.id.btnMult);
        Button btnDiv=findViewById(R.id.btnDiv);
        Button btnIgual=findViewById(R.id.btnIgual);
        Button btn4=findViewById(R.id.btn4);
        Button btn5=findViewById(R.id.btn5);
        Button btn6=findViewById(R.id.btn6);
        Button btn1=findViewById(R.id.btn1);
        Button btn2=findViewById(R.id.btn2);
        Button btn3=findViewById(R.id.btn3);
        Button btn0=findViewById(R.id.btn0);

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
        btnDEL.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnIgual.setOnClickListener(this);

        //Validar si nos encontramos en landscape para evitar problemas
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Se cumple que sea Landscape entonces llamo a mis controles
            Button btnPI=findViewById(R.id.btnPI);
            Button btnPD=findViewById(R.id.btnPD);
            Button btnP=findViewById(R.id.btnP);
            btnPD.setOnClickListener(this);
            btnPI.setOnClickListener(this);
            btnP.setOnClickListener(this);
        }
    }
    public void onSaveInstanceState(Bundle estado){
        super.onSaveInstanceState(estado);
        estado.putString("numero", this.Operacion);
        estado.putString("resultado", this.Resultado);
    }
    public void onRestoreInstanceState(Bundle estadoAnterior){
        super.onRestoreInstanceState(estadoAnterior);
        this.Operacion=estadoAnterior.getString("numero");
        this.Resultado=estadoAnterior.getString("resultado");
        txtV1.setText(this.Operacion);
        txtV2.setText(this.Resultado);
    }

    @Override
    public void onClick(View v){
        StringBuilder entrada=new StringBuilder();
        entrada.append(txtV1.getText().toString());
        switch(v.getId()){
            case R.id.btn0:
                entrada.append(0);
                //Toast.makeText(this,entrada.toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn1:
                entrada.append(1);
                break;
            case R.id.btn2:
                entrada.append(2);
                break;
            case R.id.btn3:
                entrada.append(3);
                break;
            case R.id.btn4:
                entrada.append(4);
                break;
            case R.id.btn5:
                entrada.append(5);
                break;
            case R.id.btn6:
                entrada.append(6);
                break;
            case R.id.btn7:
                entrada.append(7);
                break;
            case R.id.btn8:
                entrada.append(8);
                break;
            case R.id.btn9:
                entrada.append(9);
                break;
            case R.id.btnSuma:
                entrada.append("+");
                break;
            case R.id.btnResta:
                entrada.append("-");
                break;
            case R.id.btnMult:
                entrada.append("*");
                break;
            case R.id.btnDiv:
                entrada.append("/");
                break;
            case R.id.btnIgual:
                Expression e=new ExpressionBuilder(entrada.toString()).build();
                txtV2.setText(String.valueOf(e.evaluate()));
                break;
            case R.id.btnDEL:
                if(entrada.length()>0)
                    entrada.deleteCharAt(entrada.length()-1);
                break;
            case R.id.btnAC:
                entrada.delete(0,entrada.length());
                txtV2.setText("");
                break;
            case R.id.btnPI:
                entrada.append("(");
                break;
            case R.id.btnPD:
                entrada.append(")");
                break;
            case R.id.btnP:
                entrada.append(".");
                break;
        }
        this.Operacion=entrada.toString();
        txtV1.setText(this.Operacion);
    }
}