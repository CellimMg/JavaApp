package model;

public class PartidaModel {

    private Integer _id;

    private String adversario, resultado, local;

    private int golsTime, golsAdv;

    public PartidaModel(Integer _id, String adversario, String resultado, String local, int golsTime, int golsAdv) {
        this._id = _id;
        this.adversario = adversario;
        this.resultado = resultado;
        this.local = local;
        this.golsTime = golsTime;
        this.golsAdv = golsAdv;
    }

    public PartidaModel(String adversario, String resultado, String local, int golsTime, int golsAdv) {
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

    public int getGolsTime() {
        return golsTime;
    }

    public void setGolsTime(int golsTime) {
        this.golsTime = golsTime;
    }

    public int getGolsAdv() {
        return golsAdv;
    }

    public void setGolsAdv(int golsAdv) {
        this.golsAdv = golsAdv;
    }
}
