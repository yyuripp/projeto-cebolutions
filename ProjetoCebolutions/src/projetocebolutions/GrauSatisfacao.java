/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocebolutions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class GrauSatisfacao {
    static Connection conn;
    static Statement stmt;
    private String[] satisfacao = new String[5];
    private short[] resp = new short[10];
    private int i = 0;
    
    public void populaVetor(String satis) {
        satisfacao[i] = satis;
        i++;
    }
    
    public void satisfacao(){
        try {

            stmt = conn.createStatement();
            ResultSet satis = stmt.executeQuery("SELECT * FROM tblSatisfacao");

            while (satis.next()) {
                String satisfacao = satis.getString("descricaoSatisfacao");
                populaVetor(satisfacao);
            }

            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void imprimeSatisfacao(){
        
        
            System.out.println("A: "+satisfacao[0]);
            System.out.println("B: "+satisfacao[1]);
            System.out.println("C: "+satisfacao[2]);
            System.out.println("D: "+satisfacao[3]);
            System.out.println("E: "+satisfacao[4]);
        
    }
    public void iniciarConexao() {
        Conexao conexao = new Conexao();
        try {
            conn = conexao.getConexao();
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    public void encerraConexao() {
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    /**
     * @param resp the resp to set
     */
    public void setResp(int i, short resp) {
        this.resp[i] = resp;
    }

    /**
     * @return the resp
     */
    public short[] getResp() {
        return resp;
    }
    
    public String[] getSatisfacao() {
        return satisfacao;
    }
}


