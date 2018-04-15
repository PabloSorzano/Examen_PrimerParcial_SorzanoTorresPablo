package cecyt9.ipn.labo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Calcu extends AppCompatActivity {
    Button uno, dos, tres, cuatro, cinco, seis, site, ocho, nueve, cero, punto, igual, mail;
    EditText texto;
    String operador;
    double pts = 0, num1 = 0, num2 = 0;
    double result = 0;
    String usr, pass, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu);
        uno = (Button) findViewById(R.id.uno);
        dos = (Button) findViewById(R.id.dos);
        tres = (Button) findViewById(R.id.tres);
        cuatro = (Button) findViewById(R.id.cuatro);
        cinco = (Button) findViewById(R.id.cinco);
        seis = (Button) findViewById(R.id.seis);
        site = (Button) findViewById(R.id.siete);
        ocho = (Button) findViewById(R.id.ocho);
        nueve = (Button) findViewById(R.id.nueve);
        cero = (Button) findViewById(R.id.cero);
        punto = (Button) findViewById(R.id.punto);
        igual = (Button) findViewById(R.id.igual);
        mail = (Button)findViewById(R.id.mail);
        texto = (EditText) findViewById(R.id.texto);

        usr = getIntent().getStringExtra("usr");
        pass = getIntent().getStringExtra("pass");
        email = getIntent().getStringExtra("email");
    }

    public void onClickUno(View view) {
        texto.append("1");
    }

    public void onClickDos(View view) {
        texto.append("2");
    }

    public void onClickTres(View view) {
        texto.append("3");
    }

    public void onClickCuatro(View view) {
        texto.append("4");
    }

    public void onClickCinco(View view) {
        texto.append("5");
    }

    public void onClickSeis(View view) {
        texto.append("6");
    }

    public void onClickSiete(View view) {
        texto.append("7");
    }

    public void onClickOcho(View view) {
        texto.append("8");
    }

    public void onClickNueve(View view) {
        texto.append("9");
    }

    public void onClickCero(View view) {
        texto.append("0");
    }

    public void onClickPunto(View view) {
        if (pts == 0) {
            texto.append(".");
            pts++;
        }
    }

    public void onClickMas(View view) {
        operador = "+";
        guardaUno(view);


    }

    public void onClickMenos(View view) {
        operador = "-";
        guardaUno(view);


    }

    public void onClickPor(View view) {
        operador = "*";
        guardaUno(view);


    }

    public void onClickEntre(View view) {
        operador = "/";
        guardaUno(view);


    }

    public void onClickRaiz(View view) {
        operador = "√x";
        guardaUno(view);

    }

    public void onClickPotencia(View view) {
        operador = "^";
        guardaUno(view);

    }

    public void guardaUno(View view) {
        if(operador.equals("√x")){
            num1 = Double.parseDouble(texto.getText().toString());
            result = Math.sqrt(num1);
            texto.setText(String.valueOf(result));
        }else{
            num1 = Double.parseDouble(texto.getText().toString());
            texto.setText("");
        }
    }

    public void onClickCE(View view){
        texto.setText("");
        num1 = 0;
        num2 = 0;
        operador="";
    }

    public void onClickIgual(View view) {

        if( texto.getText().toString().isEmpty() || operador.isEmpty()){
            Toast.makeText(this,"Realize una operación",Toast.LENGTH_SHORT).show();
        }else {
            num2 = Double.parseDouble(texto.getText().toString());
            System.out.println(num2);
            switch (operador) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "^":
                    result = Math.pow(num1,num2);
                    break;
                case "":
                    break;
                default:
                    break;
            }
            texto.setText(String.valueOf(result));
        }


    }

    public void onClickEnviar(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email, null));
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Usuario: "+usr+"\n"+"Contraseña: "+pass+"\n"+"Resultado: "+texto.getText());
        startActivity(Intent.createChooser(emailIntent, email));
    }

    public void onClickVisitar(View view){
        Intent batiz = new Intent(this, MapsActivity.class);
        finish();
        startActivity(batiz);
    }
}
