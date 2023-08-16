package com.apkdoandroid.datavalid_demo.model;

public class PessoaJuridica {

    /**
     * porte : true
     * telefone : {"ddd":true,"numero":true}
     * endereco : {"logradouro":true,"logradouro_similaridade":1,"complemento":true,"complemento_similaridade":1,"numero":true,"numero_similaridade":1,"bairro":true,"bairro_similaridade":1,"cep":true,"municipio":true,"municipio_similaridade":1,"uf":true}
     * cnpj_disponivel : true
     * razao_social : true
     * razao_social_similaridade : 1.0
     * nome_fantasia : true
     * nome_fantasia_similaridade : 1.0
     * data_abertura : true
     * cnae_principal : {"codigo":true,"descricao":true,"descricao_similaridade":1}
     * natureza_juridica : {"codigo":true,"descricao":true,"descricao_similaridade":1}
     * situacao_cadastral : {"codigo":true,"data":true,"motivo":true,"motivo_similaridade":1}
     * situacao_especial : true
     * situacao_especial_similaridade : 1.0
     * correio_eletronico : true
     * correio_eletronico_similaridade : 1.0
     * capital_social : true
     */

    private boolean porte;
    private Telefone telefone;
    private EnderecoB endereco;
    private boolean cnpj_disponivel;
    private boolean razao_social;
    private double razao_social_similaridade;
    private boolean nome_fantasia;
    private double nome_fantasia_similaridade;
    private boolean data_abertura;
    private CNAE_principal cnae_principal;
    private NaturezaJuridica natureza_juridica;
    private SituacaoCadastral situacao_cadastral;
    private boolean situacao_especial;
    private double situacao_especial_similaridade;
    private boolean correio_eletronico;
    private double correio_eletronico_similaridade;
    private boolean capital_social;
    /**
     * property : cnpj
     * message : CNPJ inválido
     * code : DV020
     */

    private String property;
    private String message;
    private String code;


    public boolean isPorte() {
        return porte;
    }

    public void setPorte(boolean porte) {
        this.porte = porte;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public EnderecoB getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoB endereco) {
        this.endereco = endereco;
    }

    public boolean isCnpj_disponivel() {
        return cnpj_disponivel;
    }

    public void setCnpj_disponivel(boolean cnpj_disponivel) {
        this.cnpj_disponivel = cnpj_disponivel;
    }

    public boolean isRazao_social() {
        return razao_social;
    }

    public void setRazao_social(boolean razao_social) {
        this.razao_social = razao_social;
    }

    public double getRazao_social_similaridade() {
        return razao_social_similaridade;
    }

    public void setRazao_social_similaridade(double razao_social_similaridade) {
        this.razao_social_similaridade = razao_social_similaridade;
    }

    public boolean isNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(boolean nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public double getNome_fantasia_similaridade() {
        return nome_fantasia_similaridade;
    }

    public void setNome_fantasia_similaridade(double nome_fantasia_similaridade) {
        this.nome_fantasia_similaridade = nome_fantasia_similaridade;
    }

    public boolean isData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(boolean data_abertura) {
        this.data_abertura = data_abertura;
    }

    public CNAE_principal getCnae_principal() {
        return cnae_principal;
    }

    public void setCnae_principal(CNAE_principal cnae_principal) {
        this.cnae_principal = cnae_principal;
    }

    public NaturezaJuridica getNatureza_juridica() {
        return natureza_juridica;
    }

    public void setNatureza_juridica(NaturezaJuridica natureza_juridica) {
        this.natureza_juridica = natureza_juridica;
    }

    public SituacaoCadastral getSituacao_cadastral() {
        return situacao_cadastral;
    }

    public void setSituacao_cadastral(SituacaoCadastral situacao_cadastral) {
        this.situacao_cadastral = situacao_cadastral;
    }

    public boolean isSituacao_especial() {
        return situacao_especial;
    }

    public void setSituacao_especial(boolean situacao_especial) {
        this.situacao_especial = situacao_especial;
    }

    public double getSituacao_especial_similaridade() {
        return situacao_especial_similaridade;
    }

    public void setSituacao_especial_similaridade(double situacao_especial_similaridade) {
        this.situacao_especial_similaridade = situacao_especial_similaridade;
    }

    public boolean isCorreio_eletronico() {
        return correio_eletronico;
    }

    public void setCorreio_eletronico(boolean correio_eletronico) {
        this.correio_eletronico = correio_eletronico;
    }

    public double getCorreio_eletronico_similaridade() {
        return correio_eletronico_similaridade;
    }

    public void setCorreio_eletronico_similaridade(double correio_eletronico_similaridade) {
        this.correio_eletronico_similaridade = correio_eletronico_similaridade;
    }

    public boolean isCapital_social() {
        return capital_social;
    }

    public void setCapital_social(boolean capital_social) {
        this.capital_social = capital_social;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
