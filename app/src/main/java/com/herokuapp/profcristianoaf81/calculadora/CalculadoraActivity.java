package com.herokuapp.profcristianoaf81.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraActivity extends Activity implements OnClickListener{

    /*
        Baseado no código disponível em:
        http://codigosandroid.blogspot.com/2013/03/v-behaviorurldefaultvmlo.html

    */

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnCLEAR;
    private Button btnDOT;
    private Button btnIGUAL;
    private Button opSOMA;
    private Button opSUB;
    private Button opDIV;
    private Button opMULTI;
    private TextView visorCalculadora;
    private TextView visorResultado;


    private double n1,n2=0d;
    private String operacao;
    private String opTOTAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);
        inicializar();
        listeners();
    }


   private void  inicializar(){
        visorCalculadora = (TextView) findViewById(R.id.visor);
        visorResultado = (TextView) findViewById(R.id.visor_resultado);

        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btn0 = (Button) findViewById(R.id.btn_0);
        btnIGUAL = (Button) findViewById(R.id.btn_igual);
        btnCLEAR = (Button) findViewById(R.id.btn_limpar);
        btnDOT = (Button) findViewById(R.id.btn_ponto);
        opSOMA = (Button) findViewById(R.id.btn_somar);
        opSUB = (Button) findViewById(R.id.btn_subtracao);
        opMULTI = (Button) findViewById(R.id.btn_multiplicar);
        opDIV = (Button) findViewById(R.id.btn_divisao);


   }

   private void listeners(){
       btn1.setOnClickListener(this);
       btn2.setOnClickListener(this);
       btn3.setOnClickListener(this);
       btn4.setOnClickListener(this);
       btn5.setOnClickListener(this);
       btn6.setOnClickListener(this);
       btn7.setOnClickListener(this);
       btn8.setOnClickListener(this);
       btn9.setOnClickListener(this);
       btn0.setOnClickListener(this);
       btnIGUAL.setOnClickListener(this);
       btnCLEAR.setOnClickListener(this);
       btnDOT.setOnClickListener(this);
       opSOMA.setOnClickListener(this);
       opSUB.setOnClickListener(this);
       opMULTI.setOnClickListener(this);
       opDIV.setOnClickListener(this);
   }

   private void TecladoNumerico(int leNumero){
        if(visorCalculadora.getText().toString().trim().equals("0.0")){
            limparVisor();
            visorCalculadora.setText(
                    visorCalculadora.getText()
                            .toString()+String.valueOf(leNumero)
            );


        }else{
            visorCalculadora.setText(
                    visorCalculadora.getText()
                            .toString()+String.valueOf(leNumero)
            );
        }
   }

   private void ponto(String ponto){
        if(!visorCalculadora.getText().toString().trim().equals("0.0")) {
            visorCalculadora.setText(
                    visorCalculadora.getText().toString() + ponto
            );
        }else{
            visorCalculadora.setText("0.");
        }

        if(visorCalculadora.getText().toString().equals("0.0")){
            visorCalculadora.setText("0.");
        }
   }

   private void limparVisor(){
        this.visorCalculadora.setText("");
        this.visorResultado.setText("");
   }

   public void operacoes(String operacao){
        this.operacao = operacao;

        if(n2==0d) {
            if (operacao == "+") {
                n1 = Double.parseDouble(visorCalculadora.getText().toString().trim());
                limparVisor();
            }

            if (operacao == "-") {
                n1 = Double.parseDouble(visorCalculadora.getText().toString().trim());
                limparVisor();
            }

            if (operacao == "X") {
                n1 = Double.parseDouble(visorCalculadora.getText().toString().trim());
                limparVisor();
            }

            if (operacao == "/") {
                n1 = Double.parseDouble(visorCalculadora.getText().toString().trim());
                limparVisor();
            }
        }



   }

   private void igual(){
        if(!visorCalculadora.getText().toString().trim().equals(""))
        {
           if(n2==0d) {
               opTOTAL = String.valueOf(n1) + operacao
                       + Double.parseDouble(visorCalculadora.getText().toString());

               if (operacao == "+") {
                   n2 = n1 + Double.parseDouble(visorCalculadora.getText().toString().trim());
               } else if (operacao == "-") {
                   n2 = n1 - Double.parseDouble(visorCalculadora.getText().toString().trim());
               } else if (operacao == "X") {
                   n2 = n1 * Double.parseDouble(visorCalculadora.getText().toString().trim());
               } else if (operacao == "/") {

                   double Verificador = Double.parseDouble(
                           visorCalculadora.getText().toString().trim()
                   );

                   if (Verificador != 0d || Verificador != 0.0d) {
                       n2 = n1 / Verificador;
                   } else {
                       n2 = 0;
                   }

               }
           }

        }else{
            n2 = 0d;
        }

        visorCalculadora.setText(String.valueOf(opTOTAL));
        visorResultado.setText("Resultado: "+String.valueOf(n2));


   }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_0:

                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }

                TecladoNumerico(0);
            break;

            case R.id.btn_1:

                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }

                TecladoNumerico(1);
            break;

            case R.id.btn_2:

                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }

                TecladoNumerico(2);
            break;

            case R.id.btn_3:

                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }

                TecladoNumerico(3);
            break;

            case R.id.btn_4:

                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }

                TecladoNumerico(4);
            break;

            case R.id.btn_5:

                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }

                TecladoNumerico(5);
            break;

            case R.id.btn_6:

                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }

                TecladoNumerico(6);
            break;

            case R.id.btn_7:

                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }

                TecladoNumerico(7);
            break;

            case R.id.btn_8:

                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }

                TecladoNumerico(8);
            break;

            case R.id.btn_9:

                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }

                TecladoNumerico(9);
            break;

            case R.id.btn_limpar:
                limparVisor();
            break;

            case R.id.btn_somar:

                operacoes("+");
            break;

            case R.id.btn_subtracao:

                operacoes("-");
            break;

            case R.id.btn_multiplicar:

                operacoes("X");
            break;

            case R.id.btn_divisao:

                operacoes("/");
            break;

            case R.id.btn_ponto:
                if(n2!=0d){
                    limparVisor();
                    n2=0;
                }
                String teste = visorCalculadora.getText().toString();
                System.out.println(teste);
                ponto(".");
            break;

            case R.id.btn_igual:
                igual();
            break;
        }
    }
}
