package br.com.marbook.marbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {
    EditText camponome,camposenha,campotelefone,campotelefone2,campoemail,camporua,campobairro,camponum,campocomplem;
    Button btcad,btcancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        camponome = (EditText) findViewById(R.id.camponome);
        camposenha = (EditText) findViewById(R.id.camposenha);
        campotelefone = (EditText) findViewById(R.id.campotelefone);
        campotelefone2 = (EditText) findViewById(R.id.campotelefone2);
        campoemail = (EditText) findViewById(R.id.campoemail);

        camporua = (EditText) findViewById(R.id.camporua);
        campobairro = (EditText) findViewById(R.id.campobairro);
        camponum = (EditText) findViewById(R.id.camponum);
        campocomplem = (EditText) findViewById(R.id.campocomplem);
        btcad = (Button) findViewById(R.id.btcad);


        btcad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final Intent abreCadastro = new Intent(CadastroActivity.this, PaginaInicial.class);
                startActivity(abreCadastro);


                btcancel = (Button) findViewById(R.id.btcancel);
                btcancel.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent fechaCadastro = new Intent(CadastroActivity.this, LoginActivity.class);
                        startActivity(fechaCadastro);
                    }
                });
            }
        });
    }
}


