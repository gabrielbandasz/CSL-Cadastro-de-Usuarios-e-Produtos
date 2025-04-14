package br.ulbra.entity;

public class Produto {

    private int pkidprod;
    private String nomeprod;
    private String dataCadProd;
    private String categoriaprod;
    private double valorunitprod;
    private int quantestoqueprod;

    // Construtor padrão
    public Produto() {
    }

    //Construtor completo
    public Produto(int pkidprod, String nomeprod, String dataCadProd, String categoriaprod, double valorunitprod, int quantestoqueprod) {
        this.pkidprod = pkidprod;
        this.nomeprod = nomeprod;
        this.dataCadProd = dataCadProd;
        this.categoriaprod = categoriaprod;
        this.valorunitprod = valorunitprod;
        this.quantestoqueprod = quantestoqueprod;
    }

    // Getters e Setters
    public int getPkidprod() {
        return pkidprod;
    }

    public void setPkidprod(int pkidprod) {
        this.pkidprod = pkidprod;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public String getDataCadProd() {
        return dataCadProd;
    }

    public void setDataCadProd(String dataCadProd) {
        this.dataCadProd = dataCadProd;
    }

    public String getCategoriaprod() {
        return categoriaprod;
    }

    public void setCategoriaprod(String categoriaprod) {
        this.categoriaprod = categoriaprod;
    }

    public double getValorunitprod() {
        return valorunitprod;
    }

    public void setValorunitprod(double valorunitprod) {
        this.valorunitprod = valorunitprod;
    }

    public int getQuantestoqueprod() {
        return quantestoqueprod;
    }

    public void setQuantestoqueprod(int quantestoqueprod) {
        this.quantestoqueprod = quantestoqueprod;
    }

    public double calcularEstoque() {
        return this.valorunitprod * this.quantestoqueprod;
    }

    public String exibirInformacoes() {
        return "ID: " + pkidprod + "\n"
                + "Nome: " + nomeprod + "\n"
                + "Data Cadastro: " + dataCadProd + "\n"
                + "Categoria: " + categoriaprod + "\n"
                + "Valor Unitário: R$ " + valorunitprod + "\n"
                + "Quantidade em Estoque: " + quantestoqueprod + "\n"
                + "Valor Total em Estoque: R$ " + calcularEstoque();
    }

}
