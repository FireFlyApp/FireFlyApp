package com.example.junior.fireflyapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActCadastro extends AppCompatActivity {

    private Usuario usuario;

    //EditText
    private EditText txtNome;
    private EditText txtSobrenome;
    private EditText txtDtNasc;
    private EditText txtEmail;
    private EditText txtSenha;

    //RadioButton
    private RadioGroup rdgSexo;
    private RadioButton rbtMasculino;
    private RadioButton rbtFeminino;

    //Button
    private Button btnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cadastrar);

        //Mapeamento EditText
        this.txtNome = (EditText)findViewById(R.id.txtNome);
        this.txtSobrenome = (EditText)findViewById(R.id.txtSobrenome);
        this.txtDtNasc = (EditText)findViewById(R.id.txtDtNasc);
        this.txtEmail = (EditText)findViewById(R.id.txtEmail);
        this.txtSenha = (EditText)findViewById(R.id.txtSenha);

        //Mapeamento RadioButton
        rdgSexo = (RadioGroup)findViewById(R.id.rdgSexo);
        rbtMasculino = (RadioButton)findViewById(R.id.rbtMasculino);
        rbtFeminino = (RadioButton)findViewById(R.id.rbtFeminino);

        //Mapeamento Button
        btnCadastrar = (Button)findViewById(R.id.btnCadastrar);


            }


    public void onClickCadastrar(View view){

        if(txtNome.getText().toString().isEmpty() ||
                txtSobrenome.getText().toString().isEmpty() ||
                txtDtNasc.getText().toString().isEmpty() ||
                txtEmail.getText().toString().isEmpty() ||
                txtSenha.getText().toString().isEmpty())
        {
            AlertDialog.Builder dlg = new AlertDialog.Builder(ActCadastro.this);
            dlg.setMessage("Todos os campos são obrigatórios.");
            dlg.setNeutralButton("OK", null);
            dlg.show();


        }else {
            this.usuario.setNome(this.txtNome.getText().toString());
            this.usuario.setSobrenome(this.txtSobrenome.getText().toString());
            this.usuario.setDataNascimento(this.txtDtNasc.getText().toString());
            this.usuario.setEmail(this.txtEmail.getText().toString());
            this.usuario.setSenha(this.txtSenha.getText().toString());
        }
    }
}
