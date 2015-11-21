package com.example.junior.fireflyapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by Junior on 08/11/2015.
 */
public class DB extends _Default implements Runnable {

    private Connection conn;
    private String host = "127.0.0.1";
    private String db = "dbAppFireFly";
    private int port = 3306;
    private String user = "root";
    private String pass = "junior3xtreme92";
    private String url = "jdbc:mysql://%s:%d/%s";

    public DB() {
        super();
        this.url = String.format(this.url, this.host, this.port, this.db);

        this.conectar();
        this.desconectar();
        }

    @Override
    public void run() {
        try{

            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        }catch(Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void conectar(){

        Thread tread = new Thread(this);
        tread.start();
        try{
            tread.join();//Aplicação espera a conclusão do metodo run

        }catch (Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }

    }

    private void desconectar(){

        if(this.conn != null){
            try{
                this.conn.close();
            }catch(Exception e){

            }finally {
                this.conn = null;
            }
        }

    }

    public ResultSet select(String query){
       this.conectar();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        }catch (Exception e){
            this._status = false;
            this._mensagem = e.getMessage();
        }

        return resultSet;
    }

    public ResultSet executar(String query) {
        this.conectar();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        } catch (Exception e) {
            this._status = false;
            this._mensagem = e.getMessage();
        }

        return resultSet;
    }
}
