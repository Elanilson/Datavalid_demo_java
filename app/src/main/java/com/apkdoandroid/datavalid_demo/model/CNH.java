package com.apkdoandroid.datavalid_demo.model;

public class CNH {

    /**
     * nome : false
     * nome_similaridade : 0.38095238095238093
     * numero_registro : false
     * categoria : false
     * codigo_situacao : true
     * data_ultima_emissao : false
     * data_primeira_habilitacao : false
     * data_validade : false
     * possui_impedimento : true
     * observacoes : false
     * observacoes_similaridade : 0.0
     */

    private boolean nome;
    private double nome_similaridade;
    private boolean numero_registro;
    private boolean categoria;
    private boolean codigo_situacao;
    private boolean data_ultima_emissao;
    private boolean data_primeira_habilitacao;
    private boolean data_validade;
    private boolean possui_impedimento;
    private boolean observacoes;
    private double observacoes_similaridade;

    public boolean isNome() {
        return nome;
    }

    public void setNome(boolean nome) {
        this.nome = nome;
    }

    public double getNome_similaridade() {
        return nome_similaridade;
    }

    public void setNome_similaridade(double nome_similaridade) {
        this.nome_similaridade = nome_similaridade;
    }

    public boolean isNumero_registro() {
        return numero_registro;
    }

    public void setNumero_registro(boolean numero_registro) {
        this.numero_registro = numero_registro;
    }

    public boolean isCategoria() {
        return categoria;
    }

    public void setCategoria(boolean categoria) {
        this.categoria = categoria;
    }

    public boolean isCodigo_situacao() {
        return codigo_situacao;
    }

    public void setCodigo_situacao(boolean codigo_situacao) {
        this.codigo_situacao = codigo_situacao;
    }

    public boolean isData_ultima_emissao() {
        return data_ultima_emissao;
    }

    public void setData_ultima_emissao(boolean data_ultima_emissao) {
        this.data_ultima_emissao = data_ultima_emissao;
    }

    public boolean isData_primeira_habilitacao() {
        return data_primeira_habilitacao;
    }

    public void setData_primeira_habilitacao(boolean data_primeira_habilitacao) {
        this.data_primeira_habilitacao = data_primeira_habilitacao;
    }

    public boolean isData_validade() {
        return data_validade;
    }

    public void setData_validade(boolean data_validade) {
        this.data_validade = data_validade;
    }

    public boolean isPossui_impedimento() {
        return possui_impedimento;
    }

    public void setPossui_impedimento(boolean possui_impedimento) {
        this.possui_impedimento = possui_impedimento;
    }

    public boolean isObservacoes() {
        return observacoes;
    }

    public void setObservacoes(boolean observacoes) {
        this.observacoes = observacoes;
    }

    public double getObservacoes_similaridade() {
        return observacoes_similaridade;
    }

    public void setObservacoes_similaridade(double observacoes_similaridade) {
        this.observacoes_similaridade = observacoes_similaridade;
    }
}
