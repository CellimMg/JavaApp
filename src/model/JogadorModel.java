package model;

public class JogadorModel {

    private Integer _id;

    private String nome, idade, cidade, estado, pais, nomeMae, posicao, pernaChute, altura;

    @Override
    public String toString() {
        return "JogadorModel{" +
                ", nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", posicao='" + posicao + '\'' +
                ", pernaChute='" + pernaChute + '\'' +
                ", altura='" + altura + '\'' +
                '}';
    }

    public JogadorModel(Integer _id, String nome, String idade, String cidade, String estado, String pais,
                        String nomeMae, String posicao, String pernaChute, String altura) {
        this._id = _id;
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.nomeMae = nomeMae;
        this.posicao = posicao;
        this.pernaChute = pernaChute;
        this.altura = altura;
    }

    public JogadorModel(){

    }

    public JogadorModel(String nome, String idade, String cidade, String estado, String pais, String nomeMae,
                        String posicao, String pernaChute, String altura) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.nomeMae = nomeMae;
        this.posicao = posicao;
        this.pernaChute = pernaChute;
        this.altura = altura;
    }



    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {

        this.estado = estado;

    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getPernaChute() {
        return pernaChute;
    }

    public void setPernaChute(String pernaChute) {
        this.pernaChute = pernaChute;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }



}
