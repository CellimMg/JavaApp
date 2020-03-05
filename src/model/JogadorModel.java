package model;

import controller.Exceptions.MoreThanThreeException;
import controller.Exceptions.NotNumberException;
import controller.Exceptions.NotStringException;

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

    public void set_id(Integer _id) {   this._id = _id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NotStringException {
        if (nome.matches("^[ a-zA-Z á]*$")) this.nome = nome;
        else throw new NotStringException("Não é só String");
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) throws NotNumberException {

        if(idade.matches("[0-9]+")) this.idade = idade;
        else throw new NotNumberException("Não tem só numeros");

    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws NotStringException {

        if (cidade.matches("^[ a-zA-Z á]*$")) this.cidade = cidade;
        else throw new NotStringException("Não é só String");
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws NotStringException {

        if (estado.matches("^[ a-zA-Z á]*$")) this.estado = estado;
        else throw new NotStringException("Não é só String");

    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) throws NotStringException {

        if (pais.matches("^[ a-zA-Z á]*$")) this.pais = pais;
        else throw new NotStringException("Não é só String");
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) throws NotStringException {

        if (nomeMae.matches("^[ a-zA-Z á]*$")) this.nomeMae = nomeMae;
        else throw new NotStringException("Não é só String");
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

    public void setAltura(String altura) throws NotNumberException, MoreThanThreeException {
        if (altura.matches("[0-9]+")){
            if(altura.length() == 3){
                this.altura = altura;
            }else{
                throw new MoreThanThreeException("Não tem 3");
            }
        }else{
            throw new NotNumberException("Não é só número");
        }

    }



}
