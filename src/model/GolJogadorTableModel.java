package model;

import controller.Exceptions.NotNumberException;
import controller.Exceptions.NullException;

public class GolJogadorTableModel {

    private Integer id;
    private String nome;
    private String qtd;

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd){
        this.qtd = qtd;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
