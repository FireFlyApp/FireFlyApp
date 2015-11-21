package com.example.junior.fireflyapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class ActCadastro extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, DialogInterface.OnCancelListener{

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

    //CheckBox
    private CheckBox cbxTermosUso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cadastrar);

        this.usuario = new Usuario();


        this.txtNome = (EditText)findViewById(R.id.txtNome);
        this.txtSobrenome = (EditText)findViewById(R.id.txtSobrenome);
        this.txtDtNasc = (EditText)findViewById(R.id.txtDtNasc);
        this.txtDtNasc.setInputType(InputType.TYPE_NULL);
        this.txtEmail = (EditText)findViewById(R.id.txtEmail);
        this.txtSenha = (EditText)findViewById(R.id.txtSenha);


        this.rdgSexo = (RadioGroup)findViewById(R.id.rdgSexo);
        this.rbtMasculino = (RadioButton)findViewById(R.id.rbtMasculino);
        this.rbtFeminino = (RadioButton)findViewById(R.id.rbtFeminino);


        this.btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

        //CheckBox
        this.cbxTermosUso = (CheckBox)findViewById(R.id.cbxTermosUso);
        
        txtDtNasc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                scheduleTestDrive(v);
            }
        });
        }

    private int day, month, year;

    private void scheduleTestDrive(View v) {
        InitDateTimeData();
        Calendar cDefault = Calendar.getInstance();
        cDefault.set(year, month,day);

        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
            this,
            cDefault.get(Calendar.YEAR),
            cDefault.get(Calendar.MONTH),
            cDefault.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.setOnCancelListener(this);
        datePickerDialog.show(getFragmentManager(),"DatePickerDialog");
    }

    private void InitDateTimeData(){
        if (year == 0){
            Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }
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
           !selectSexo)
        {
            Toast.makeText(getApplicationContext(),"Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();

        }else if(!cbxTermosUso.isChecked())
        {

            Toast.makeText(getApplicationContext(),"Para prosseguir você precisa aceitar os termos de uso", Toast.LENGTH_SHORT).show();

        }else if(txtSenha.length() < 6 || txtSenha.length() > 12)
        {

            Toast.makeText(getApplicationContext(),"Sua senha deve ter entre 6 e 12 caracteres.", Toast.LENGTH_SHORT).show();

        }else
        {
                this.usuario.setNome(this.txtNome.getText().toString());
                this.usuario.setSobrenome(this.txtSobrenome.getText().toString());
                this.usuario.setDataNascimento(this.txtDtNasc.getText().toString());
                this.usuario.setEmail(this.txtEmail.getText().toString());
                this.usuario.setSenha(this.txtSenha.getText().toString());
                this.usuario.setSexo(sexo);
                this.usuario.setDataNascimento(this.txtDtNasc.getText().toString());

                this.usuario.cadastrar();

                Toast.makeText(this, this.usuario.get_mensagem(), Toast.LENGTH_LONG).show();

                if(usuario.is_status())
                    finish();
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
         year = month = year = 0;
         txtDtNasc.setText("");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int y, int m, int d) {
        year = y;
        month = m;
        day = d;

        txtDtNasc.setText((day < 10 ? "0" + day : day) + "/" + (month+1 < 10 ? "0" + (month + 1) : (month+1)) + "/" + year);
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {

    }
}
