package model;

import controller.Exceptions.NotNumberException;
import controller.Exceptions.NullException;

public class PartidaModel {

    private Integer _id;

    private String adversario, resultado, local, golsTime, golsAdv;

    public PartidaModel() {

    }

    @Override
    public String toString() {
        return "Partida" +
                "_id=" + _id +
                ", adversario='" + adversario + '\'' +
                ", resultado='" + resultado + '\'' +
                ", local='" + local + '\'' +
                ", golsTime=" + golsTime +
                ", golsAdv=" + golsAdv
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

        if(adversario == null || adversario.isEmpty()) throw new NullException("a");
        else this.adversario = adversario;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) throws NullException {

        if (resultado == null) throw new NullException("a");
        else this.resultado = resultado;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) throws NullException {

        if (local == null) throw new NullException("a");
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
