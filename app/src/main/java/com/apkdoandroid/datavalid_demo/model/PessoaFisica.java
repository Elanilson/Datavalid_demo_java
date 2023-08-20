package com.apkdoandroid.datavalid_demo.model;

public class PessoaFisica {


    /**
     * code : 900902
     * message : Missing Credentials
     * description : Invalid Credentials. Make sure your API invocation call has a header: 'null : Bearer ACCESS_TOKEN' or 'null : Basic ACCESS_TOKEN' or 'apikey: API_KEY'
     */

    /**
     * cpf_disponivel : true
     * nome : false
     * nome_similaridade : 0.38095238095238093
     * data_nascimento : false
     * situacao_cpf : true
     * sexo : true
     * nacionalidade : true
     * cnh_disponivel : true
     * carteiraIdentificacao : {"nome":false,"nome_similaridade":0.38095238095238093,"numero_registro":false,"categoria":false,"codigo_situacao":true,"data_ultima_emissao":false,"data_primeira_habilitacao":false,"data_validade":false,"possui_impedimento":true,"observacoes":false,"observacoes_similaridade":0}
     * filiacao : {"nome_mae":false,"nome_mae_similaridade":0.30000000000000004,"nome_pai":false,"nome_pai_similaridade":0.23809523809523814}
     * documento : {"tipo":true,"numero":false,"numero_similaridade":0,"orgao_expedidor":true,"uf_expedidor":false}
     * endereco : {"logradouro":false,"logradouro_similaridade":0.16666666666666663,"numero":false,"numero_similaridade":0,"bairro":false,"bairro_similaridade":0.47058823529411764,"cep":false,"municipio":false,"municipio_similaridade":0.17647058823529416,"uf":false}
     */



    private boolean cpf_disponivel;
    private boolean nome;
    private double nome_similaridade;
    private boolean data_nascimento;
    private boolean situacao_cpf;
    private boolean sexo;
    private boolean nacionalidade;
    private boolean cnh_disponivel;
    private CarteiraIdentificacao cnh;
    private Filiacao filiacao;
    private Documento documento;
    private Endereco endereco;

    //resposta

    private String code;
    private String message;
    private String description;
    private String property;
    private BiometriaFacial biometria_face;
    private BiometriaDigital biometria_digital;


    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf_disponivel=" + cpf_disponivel +
                ", nome=" + nome +
                ", nome_similaridade=" + nome_similaridade +
                ", data_nascimento=" + data_nascimento +
                ", situacao_cpf=" + situacao_cpf +
                ", sexo=" + sexo +
                ", nacionalidade=" + nacionalidade +
                ", cnh_disponivel=" + cnh_disponivel +
                ", cnh=" + cnh +
                ", filiacao=" + filiacao +
                ", documento=" + documento +
                ", endereco=" + endereco +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

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

    public double getNome_similaridade() {
        return nome_similaridade;
    }

    public void setNome_similaridade(double nome_similaridade) {
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    //resposta
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
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
