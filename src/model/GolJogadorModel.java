package model;

import controller.Exceptions.NotNumberException;
import controller.Exceptions.NullException;

public class GolJogadorModel {

    private Integer _id;
    private int idJogador;
    private int idPartida;
    private String qtd;

    public GolJogadorModel(int _id, int idJogador, int idPartida, String qtd) {
        this._id = _id;
        this.idJogador = idJogador;
        this.idPartida = idPartida;
        this.qtd = qtd;
    }


    public GolJogadorModel() {}

    @Override
    public String toString() {
        return "GolJogadorModel{" +
                "_id=" + _id +
                ", idJogador=" + idJogador +
                ", idPartida=" + idPartida +
                ", qtd='" + qtd + '\'' +
                '}';
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) throws NullException {

        if(idPartida == null) throw new NullException("erro");
        else this.idPartida = idPartida;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) throws NotNumberException {
        if(qtd.matches("[1-9]+")) this.qtd = qtd;
        else throw new NotNumberException("Não tem só numeros");
    }
}
