package com.example.junior.fireflyapp;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActCadastro extends AppCompatActivity {

    //TextView
    private TextView lblCadastrarTela;
    private TextView lblNome;
    private TextView lblSobrenome;
    private TextView lblSexo;
    private TextView lblDtNascimento;
    private TextView lblEmail;
    private TextView lblSenha;
    private TextView teste;

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

        //Mapeamento TextView
        lblCadastrarTela = (TextView)findViewById(R.id.lblCadastrarTela);
        lblNome = (TextView)findViewById(R.id.lblNome);
        lblSobrenome = (TextView)findViewById(R.id.lblSobrenome);
        lblSexo = (TextView)findViewById(R.id.lblSexo);
        lblDtNascimento = (TextView)findViewById(R.id.lblDtNascimento);
        lblEmail = (TextView)findViewById(R.id.lblEmail);
        lblSenha = (TextView)findViewById(R.id.lblSenha);

        //Mapeamento EditText
        txtNome = (EditText)findViewById(R.id.txtNome);
        txtSobrenome = (EditText)findViewById(R.id.txtSobrenome);
        txtDtNasc = (EditText)findViewById(R.id.txtDtNasc);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtSenha = (EditText)findViewById(R.id.txtSenha);

        //Mapeamento RadioButton
        rdgSexo = (RadioGroup)findViewById(R.id.rdgSexo);
        rbtMasculino = (RadioButton)findViewById(R.id.rbtMasculino);
        rbtFeminino = (RadioButton)findViewById(R.id.rbtFeminino);

        //Mapeamento Button
        btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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

                       Usuario usuario = new Usuario();

                }

            }
        });



    }
}
