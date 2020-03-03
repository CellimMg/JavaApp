package model;

public class EscalacaoModel {

    private int _id;
    private int idPartida;

    public EscalacaoModel(int id, int idPartida) {
        this._id = id;
        this.idPartida = idPartida;
    }

    public EscalacaoModel(){}

    @Override
    public String toString() {
        return "EscalacaoModel{" +
                "id=" + _id +
                ", idPartida=" + idPartida +
                '}';
    }

    public int get_Id() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }
}
