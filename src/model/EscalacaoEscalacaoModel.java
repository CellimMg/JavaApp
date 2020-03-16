package model;

public class EscalacaoEscalacaoModel {

    private Integer idEscalacao;
    private Integer idPartida;
    private Integer idJogador;

    @Override
    public String toString() {
        return "EscalacaoEscalacaoModel{" +
                "idEscalacao=" + idEscalacao +
                ", idPartida=" + idPartida +
                ", idJogador=" + idJogador +
                '}';
    }

    public Integer getIdEscalacao() {
        return idEscalacao;
    }

    public void setIdEscalacao(Integer idEscalacao) {
        this.idEscalacao = idEscalacao;
    }

    public Integer getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }
}
