package model;

public class PartidaModel {

    private Integer _id;

    private String adversario, resultado, local, golsTime, golsAdv;

    public PartidaModel() {

    }

    public PartidaModel(Integer _id, String adversario, String resultado, String local, String golsTime, String golsAdv) {
        this._id = _id;
        this.adversario = adversario;
        this.resultado = resultado;
        this.local = local;
        this.golsTime = golsTime;
        this.golsAdv = golsAdv;
    }

    public PartidaModel(String adversario, String resultado, String local, String golsTime, String golsAdv) {
        this.adversario = adversario;
        this.resultado = resultado;
        this.local = local;
        this.golsTime = golsTime;
        this.golsAdv = golsAdv;
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

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getAdversario() {
        return adversario;
    }

    public void setAdversario(String adversario) {
        this.adversario = adversario;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getGolsTime() {
        return golsTime;
    }

    public void setGolsTime(String golsTime) {
        this.golsTime = golsTime;
    }

    public String getGolsAdv() {
        return golsAdv;
    }

    public void setGolsAdv(String golsAdv) {
        this.golsAdv = golsAdv;
    }
}
