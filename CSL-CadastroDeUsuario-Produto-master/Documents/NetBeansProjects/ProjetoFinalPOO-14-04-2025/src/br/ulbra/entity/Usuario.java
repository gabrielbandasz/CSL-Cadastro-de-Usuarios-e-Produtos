package br.ulbra.entity;

public class Usuario {

    protected int pkidusu;
    protected String nomeusu;
    protected String emailusu;
    protected String senhausu;
    protected String foneusu;
    protected String cpfusu;
    protected String cepusu;
    protected String logradourousu;
    protected String numerousu;
    protected String bairrousu;
    protected String cidadeusu;
    protected String estadousu;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String senha, String fone, String cpf, String cepusu, String logradourousu,
            String numerousu, String bairrousu, String cidadeusu, String estado) {
        this.pkidusu = id;
        this.nomeusu = nomeusu;
        this.emailusu = emailusu;
        this.senhausu = senhausu;
        this.foneusu = foneusu;
        this.cpfusu = cpfusu;
        this.cepusu = cepusu;
        this.logradourousu = logradourousu;
        this.numerousu = numerousu;
        this.bairrousu = bairrousu;
        this.cidadeusu = cidadeusu;
        this.estadousu = estadousu;
    }

    public int getPkidusu() {
        return pkidusu;
    }

    public void setPkidusu(int pkidusu) {
        this.pkidusu = pkidusu;
    }

    public String getNomeusu() {
        return nomeusu;
    }

    public void setNomeusu(String nomeusu) {
        this.nomeusu = nomeusu;
    }

    public String getEmailusu() {
        return emailusu;
    }

    public void setEmailusu(String emailusu) {
        this.emailusu = emailusu;
    }

    public String getSenhausu() {
        return senhausu;
    }

    public void setSenhausu(String senhausu) {
        this.senhausu = senhausu;
    }

    public String getFoneusu() {
        return foneusu;
    }

    public void setFoneusu(String foneusu) {
        this.foneusu = foneusu;
    }

    public String getCpfusu() {
        return cpfusu;
    }

    public void setCpfusu(String cpfusu) {
        this.cpfusu = cpfusu;
    }

    public String getCepusu() {
        return cepusu;
    }

    public void setCepusu(String cepusu) {
        this.cepusu = cepusu;
    }

    public String getLogradourousu() {
        return logradourousu;
    }

    public void setLogradourousu(String logradourousu) {
        this.logradourousu = logradourousu;
    }

    public String getNumerousu() {
        return numerousu;
    }

    public void setNumerososu(String numerousu) {
        this.numerousu = numerousu;
    }

    public String getBairrousu() {
        return bairrousu;
    }

    public void setBairrousu(String bairrousu) {
        this.bairrousu = bairrousu;
    }

    public String getCidadeusu() {
        return cidadeusu;
    }

    public void setCidadeusu(String cidadeusu) {
        this.cidadeusu = cidadeusu;
    }

    public String getEstadousu() {
        return estadousu;
    }

    public void setEstadousu(String estadousu) {
        this.estadousu = estadousu;
    }

    public boolean validarSenha(String senha) {
       String regex =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
       
        // A função matches retorna true se a senha atender aos requisitos da expressão regular
        return senha.matches(regex);
    }
    
    public String exibirInformacoes() {
    return "ID: " + pkidusu + "\n"
         + "Nome: " + nomeusu + "\n"
         + "Email: " + emailusu + "\n"
         + "Fone: " + foneusu + "\n"
         + "CPF: " + cpfusu + "\n"
         + "CEP: " + cepusu + "\n"
         + "Logradouro: " + logradourousu + "\n"
         + "Número: " + numerousu + "\n"
         + "Bairro: " + bairrousu + "\n"
         + "Cidade: " + cidadeusu + "\n"
         + "Estado: " + estadousu;
}

}
