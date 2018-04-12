package cecyt9.ipn.labo;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LaboActivity extends AppCompatActivity {
    EditText usr,pass, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labo);
        usr = (EditText)findViewById(R.id.usr);
        pass = (EditText)findViewById(R.id.pass);
        email = (EditText)findViewById(R.id.email);
    }

    public void evalua(View view){
        if(usr.getText().toString().trim().equals("Playbol")
                &&pass.getText().toString().trim().equals("123")){
            Intent intent = new Intent(LaboActivity.this, Calcu.class);
            intent.putExtra("usr", usr.getText().toString().trim());
            intent.putExtra("pass", pass.getText().toString().trim());
            intent.putExtra("email", email.getText().toString().trim());
            finish();
            startActivity(intent);
        }else{
            Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_SHORT).show();
            usr.setText("");
            pass.setText("");
        }
    }


}
