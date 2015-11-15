package com.example.junior.fireflyapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    private String sexo;

    //RadioButton
    private RadioGroup rdgSexo;
    private RadioButton rbtMasculino;
    private RadioButton rbtFeminino;

    //Button
    private Button btnCadastrar;

    private CheckBox cbxTermosUso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cadastrar);

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

        //CheckBox
        cbxTermosUso = (CheckBox)findViewById(R.id.cbxTermosUso);

            }


    public void onClickCadastrar(View view){

        boolean selectSexo;

        if (rbtMasculino.isChecked()){
           selectSexo = R.id.rbtMasculino == rdgSexo.getCheckedRadioButtonId();
           sexo = "M";
        }else {
            selectSexo = R.id.rbtFeminino == rdgSexo.getCheckedRadioButtonId();
            sexo = "F";
        }


        if(txtNome.getText().toString().isEmpty() ||
                txtSobrenome.getText().toString().isEmpty() ||
                txtDtNasc.getText().toString().isEmpty() ||
                txtEmail.getText().toString().isEmpty() ||
                txtSenha.getText().toString().isEmpty() ||
                !selectSexo) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(ActCadastro.this);
            dlg.setMessage("Todos os campos são obrigatórios.");
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }else if(!cbxTermosUso.isChecked()){
            AlertDialog.Builder dlg = new AlertDialog.Builder(ActCadastro.this);
            dlg.setMessage("Para prosseguir você precisa aceitar os termos de uso");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }else {
            this.usuario.setNome(this.txtNome.getText().toString());
            this.usuario.setSobrenome(this.txtSobrenome.getText().toString());
            this.usuario.setDataNascimento(this.txtDtNasc.getText().toString());
            this.usuario.setEmail(this.txtEmail.getText().toString());
            this.usuario.setSenha(this.txtSenha.getText().toString());
            this.usuario.setSexo(sexo);
        }
    }
}
