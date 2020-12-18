package model;

import controller.Exceptions.NotNumberException;
import controller.Exceptions.NullException;

public class PartidaModel {

    private Integer _id;
    private Boolean deleted;
    private String adversario, resultado, local, golsTime, golsAdv;

    public PartidaModel() {

    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Partida" +
                "_id=" + _id +
                ", adversario='" + adversario + '\'' +
                ", resultado='" + resultado + '\'' +
                ", local='" + local + '\'' +
                ", golsTime=" + golsTime +
                ", golsAdv=" + golsAdv +
                ", deleted= " + deleted
                ;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) throws NullException {
        if (_id == null) throw new NullException("nulo");
        else this._id = _id;
    }

    public String getAdversario() {
        return adversario;
    }

    public void setAdversario(String adversario) throws NullException {
        if(adversario.matches("^[a-zA-Z0-9_ ]*$")) this.adversario = adversario;
        else throw new NullException("");
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) throws NullException {

        if (resultado == null) throw new NullException("");
        else this.resultado = resultado;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) throws NullException {

        if (local == null) throw new NullException("");
        else this.local = local;
    }

    public String getGolsTime() {
        return golsTime;
    }

    public void setGolsTime(String golsTime) throws NotNumberException {
        if(golsTime.matches("[0-9]+")) this.golsTime = golsTime;
        else throw new NotNumberException("Não tem só numeros");
    }

    public String getGolsAdv() {
        return golsAdv;
    }

    public void setGolsAdv(String golsAdv) throws NotNumberException {
        if(golsAdv.matches("[0-9]+")) this.golsAdv = golsAdv;
        else throw new NotNumberException("Não tem só numeros");
    }
}
