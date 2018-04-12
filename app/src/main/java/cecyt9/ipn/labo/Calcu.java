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
    String usr = getIntent().getStringExtra("usr"),
    pass = getIntent().getStringExtra("pass"),
    email = getIntent().getStringExtra("email");
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
        mail = (Button)findViewById(R.id.email);
        texto = (EditText) findViewById(R.id.texto);
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
        } else {
        }
    }

    public void onClickMas(View view) {
            guardaUno(view);
            operador = "+";

    }

    public void onClickMenos(View view) {
            guardaUno(view);
            operador = "-";

    }

    public void onClickPor(View view) {
            guardaUno(view);
            operador = "*";

    }

    public void onClickEntre(View view) {
            guardaUno(view);
            operador = "/";

    }

    public void guardaUno(View view) {
        num1 = Double.parseDouble(texto.getText().toString());
        texto.setText("");
    }

    public void onClickCE(View view){
        texto.setText("");
        num1 = 0;
        num2 = 0;
    }

    public void onClickIgual(View view) {
        num2 = Double.parseDouble(texto.getText().toString());

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
                default:break;
            }
            texto.setText(String.valueOf(result));

    }

    public void onClickEnviar(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","correo@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Android APP - ");
        startActivity(Intent.createChooser(emailIntent, email));
    }
}
