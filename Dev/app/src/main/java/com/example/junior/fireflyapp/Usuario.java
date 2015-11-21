package com.example.junior.fireflyapp;

/**
 * Created by Junior on 03/11/2015.
 */
public class Usuario extends _Default {

    private int usuarioId;
    private String nome;
    private String sobrenome;
    private String sexo;
    private String dataNascimento;
    private String email;
    private String senha;


    public int getUsuarioId() { return usuarioId; }

    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() { return sexo;}

    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) { this.senha = senha; }

    public Usuario(){
        super();
        this.usuarioId = -1;
        this.nome = "";
        this.sobrenome = "";
        this.sexo = "";
        this.email = "";
        this.senha = "";
    }

    public void cadastrar(){

        String comando = "";
        if(this.getUsuarioId() == -1){
            comando = String.format("INSERT INTO Usuario (nome, sobrenome, sexo, dataNascimento, email, senha, termouso, login) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%d', '%d');",
                    this.getNome(), this.getSobrenome(), this.getSexo(), this.getDataNascimento(), this.getEmail(), this.getSenha(), 1, 0);
        }else{
            comando = String.format("UPDATE Usuario SET nome = '%s', sobrenome = '%s', sexo = '%s', dataNascimento = '%s', email = '%s', senha = '%s' WHERE usuario_Id = %d);",
                    this.getNome(), this.getSobrenome(), this.getSexo(), this.getDataNascimento(), this.getEmail(), this.getSenha(), getUsuarioId());
        }

        DB db = new DB();
        db.executar(comando);
        this._mensagem = db._mensagem;
        this._status = db._status;
    }
}
