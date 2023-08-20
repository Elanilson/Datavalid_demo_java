package com.apkdoandroid.datavalid_demo.model;

public class CarteiraIdentificacao {

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
    /**
     * numero_registro_ocr : 987654321
     * nome_similaridade : 1.0
     * nome_ocr : MANUELA ELISA DA MOTA
     * identidade : true
     * identidade_similaridade : 1.0
     * identidade_ocr : 123456789 SSP SP
     * data_nascimento : true
     * data_nascimento_ocr : 1975-06-04
     * data_primeira_habilitacao_ocr : 2000-04-03
     * data_ultima_emissao_ocr : 2020-04-03
     * data_validade_ocr : 2025-04-03
     * retrato : {"disponivel":true,"probabilidade":"Altíssima probabilidade","similaridade":0.9956858549207501}
     */


    private boolean nome;
    private double nome_similaridade;
    private boolean numero_registro;
    private boolean categoria;
    private boolean codigo_situacao;
    private boolean data_ultima_emissao;
    private boolean data_primeira_habilitacao;
    private boolean data_validade;
    private boolean data_nascimento;
    private boolean possui_impedimento;
    private boolean observacoes;
    private boolean identidade;
    private double observacoes_similaridade;
    private double identidade_similaridade;
    private String numero_registro_ocr;
    private String nome_ocr;
    private String identidade_ocr;
    private String data_nascimento_ocr;
    private String data_primeira_habilitacao_ocr;
    private String data_ultima_emissao_ocr;
    private String data_validade_ocr;
    private Retrato retrato;


    @Override
    public String toString() {
        return "CarteiraIdentificacao{" +
                "nome=" + nome +
                ", nome_similaridade=" + nome_similaridade +
                ", numero_registro=" + numero_registro +
                ", categoria=" + categoria +
                ", codigo_situacao=" + codigo_situacao +
                ", data_ultima_emissao=" + data_ultima_emissao +
                ", data_primeira_habilitacao=" + data_primeira_habilitacao +
                ", data_validade=" + data_validade +
                ", possui_impedimento=" + possui_impedimento +
                ", observacoes=" + observacoes +
                ", observacoes_similaridade=" + observacoes_similaridade +
                ", numero_registro_ocr='" + numero_registro_ocr + '\'' +
                ", nome_ocr='" + nome_ocr + '\'' +
                ", identidade_ocr='" + identidade_ocr + '\'' +
                ", data_nascimento_ocr='" + data_nascimento_ocr + '\'' +
                ", data_primeira_habilitacao_ocr='" + data_primeira_habilitacao_ocr + '\'' +
                ", data_ultima_emissao_ocr='" + data_ultima_emissao_ocr + '\'' +
                ", data_validade_ocr='" + data_validade_ocr + '\'' +
                ", retrato=" + retrato +
                '}';
    }


    public boolean isIdentidade() {
        return identidade;
    }

    public void setIdentidade(boolean identidade) {
        this.identidade = identidade;
    }

    public boolean isData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(boolean data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public double getIdentidade_similaridade() {
        return identidade_similaridade;
    }

    public void setIdentidade_similaridade(double identidade_similaridade) {
        this.identidade_similaridade = identidade_similaridade;
    }

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

    public String getNumero_registro_ocr() {
        return numero_registro_ocr;
    }

    public void setNumero_registro_ocr(String numero_registro_ocr) {
        this.numero_registro_ocr = numero_registro_ocr;
    }

    public String getNome_ocr() {
        return nome_ocr;
    }

    public void setNome_ocr(String nome_ocr) {
        this.nome_ocr = nome_ocr;
    }

    public String getIdentidade_ocr() {
        return identidade_ocr;
    }

    public void setIdentidade_ocr(String identidade_ocr) {
        this.identidade_ocr = identidade_ocr;
    }

    public String getData_nascimento_ocr() {
        return data_nascimento_ocr;
    }

    public void setData_nascimento_ocr(String data_nascimento_ocr) {
        this.data_nascimento_ocr = data_nascimento_ocr;
    }

    public String getData_primeira_habilitacao_ocr() {
        return data_primeira_habilitacao_ocr;
    }

    public void setData_primeira_habilitacao_ocr(String data_primeira_habilitacao_ocr) {
        this.data_primeira_habilitacao_ocr = data_primeira_habilitacao_ocr;
    }

    public String getData_ultima_emissao_ocr() {
        return data_ultima_emissao_ocr;
    }

    public void setData_ultima_emissao_ocr(String data_ultima_emissao_ocr) {
        this.data_ultima_emissao_ocr = data_ultima_emissao_ocr;
    }

    public String getData_validade_ocr() {
        return data_validade_ocr;
    }

    public void setData_validade_ocr(String data_validade_ocr) {
        this.data_validade_ocr = data_validade_ocr;
    }

    public Retrato getRetrato() {
        return retrato;
    }

    public void setRetrato(Retrato retrato) {
        this.retrato = retrato;
    }
}
