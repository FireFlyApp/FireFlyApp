package com.example.junior.fireflyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtSenha;
    private Button btnEntrar;
    private TextView lblEsqSenha;
    private TextView lblCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtSenha = (EditText)findViewById(R.id.txtSenha);
        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        lblEsqSenha = (TextView)findViewById(R.id.lblEsqSenha);
        lblCadastrar = (TextView)findViewById(R.id.lblCadastrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtEmail.getText().toString().isEmpty() || txtSenha.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(),"Campo Email/Senha vazio", Toast.LENGTH_SHORT).show();

                }else{
                    Intent it = new Intent(MainActivity.this, ActListarOpcoes.class);
                    startActivity(it);
                }
            }
        });
    }

    public void onClickCadastrar(View view){

        Intent cadastrarAct = new Intent(MainActivity.this, ActCadastro.class);
        startActivity (cadastrarAct);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
