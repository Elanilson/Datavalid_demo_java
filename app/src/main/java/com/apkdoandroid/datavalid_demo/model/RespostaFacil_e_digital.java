package com.apkdoandroid.datavalid_demo.model;

public class RespostaFacil_e_digital {

    /**
     * cpf_disponivel : true
     * nome : true
     * nome_similaridade : 0
     * data_nascimento : true
     * situacao_cpf : true
     * sexo : true
     * nacionalidade : true
     * cnh_disponivel : true
     * carteiraIdentificacao : {"nome":true,"nome_similaridade":0,"numero_registro":true,"categoria":true,"codigo_situacao":true,"registro_nacional_estrangeiro":true,"data_ultima_emissao":true,"data_primeira_habilitacao":true,"data_validade":true,"possui_impedimento":true,"observacoes":true,"observacoes_similaridade":0}
     * filiacao : {"nome_mae":true,"nome_mae_similaridade":0,"nome_pai":true,"nome_pai_similaridade":0}
     * documento : {"tipo":true,"numero":true,"numero_similaridade":0,"orgao_expedidor":true,"uf_expedidor":true}
     * endereco : {"logradouro":true,"logradouro_similaridade":0,"complemento":true,"complemento_similaridade":0,"numero":true,"numero_similaridade":0,"bairro":true,"bairro_similaridade":0,"cep":true,"municipio":true,"municipio_similaridade":0,"uf":true}
     * biometria_face : {"disponivel":true,"probabilidade":"Altíssima probabilidade","similaridade":0}
     * biometria_digital : {"disponivel":true,"digitais":[{"posicao":0,"probabilidade":"Altíssima probabilidade","similaridade":0}]}
     */

    private boolean cpf_disponivel;
    private boolean nome;
    private int nome_similaridade;
    private boolean data_nascimento;
    private boolean situacao_cpf;
    private boolean sexo;
    private boolean nacionalidade;
    private boolean cnh_disponivel;
    private CarteiraIdentificacao cnh;
    private Filiacao filiacao;
    private Documento documento;
    private EnderecoB endereco;
    private BiometriaFacial biometria_face;
    private BiometriaDigital biometria_digital;


    public boolean isCpf_disponivel() {
        return cpf_disponivel;
    }

    public void setCpf_disponivel(boolean cpf_disponivel) {
        this.cpf_disponivel = cpf_disponivel;
    }

    public boolean isNome() {
        return nome;
    }

    public void setNome(boolean nome) {
        this.nome = nome;
    }

    public int getNome_similaridade() {
        return nome_similaridade;
    }

    public void setNome_similaridade(int nome_similaridade) {
        this.nome_similaridade = nome_similaridade;
    }

    public boolean isData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(boolean data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public boolean isSituacao_cpf() {
        return situacao_cpf;
    }

    public void setSituacao_cpf(boolean situacao_cpf) {
        this.situacao_cpf = situacao_cpf;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public boolean isNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(boolean nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public boolean isCnh_disponivel() {
        return cnh_disponivel;
    }

    public void setCnh_disponivel(boolean cnh_disponivel) {
        this.cnh_disponivel = cnh_disponivel;
    }

    public CarteiraIdentificacao getCnh() {
        return cnh;
    }

    public void setCnh(CarteiraIdentificacao cnh) {
        this.cnh = cnh;
    }

    public Filiacao getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(Filiacao filiacao) {
        this.filiacao = filiacao;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public EnderecoB getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoB endereco) {
        this.endereco = endereco;
    }

    public BiometriaFacial getBiometria_face() {
        return biometria_face;
    }

    public void setBiometria_face(BiometriaFacial biometria_face) {
        this.biometria_face = biometria_face;
    }

    public BiometriaDigital getBiometria_digital() {
        return biometria_digital;
    }

    public void setBiometria_digital(BiometriaDigital biometria_digital) {
        this.biometria_digital = biometria_digital;
    }
}
