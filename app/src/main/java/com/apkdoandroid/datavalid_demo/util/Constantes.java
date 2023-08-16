package com.apkdoandroid.datavalid_demo.util;

public  class Constantes {
    public static String base_url = "https://gateway.apiserpro.serpro.gov.br/datavalid-demonstracao/v3/";

    //Dados demo
    public static String pessoa1 = "{\n" +
            "  \"key\": {\n" +
            "    \"cpf\": \"25774435016\"\n" +
            "  },\n" +
            "  \"answer\": {\n" +
            "    \"nome\": \"Maria Barbosa\",\n" +
            "    \"data_nascimento\": \"2001-01-01\",\n" +
            "    \"situacao_cpf\": \"regular\",\n" +
            "    \"sexo\": \"F\",\n" +
            "    \"nacionalidade\": 1,\n" +
            "    \"cnh\": {\n" +
            "      \"numero_registro\": \"0000001\",\n" +
            "      \"categoria\": \"AB\",\n" +
            "      \"codigo_situacao\": \"3\",\n" +
            "      \"data_ultima_emissao\": \"2000-10-01\",\n" +
            "      \"data_validade\": \"2005-12-10\",\n" +
            "      \"data_primeira_habilitacao\": \"2000-10-31\",\n" +
            "      \"registro_nacional_estrangeiro\": \"123456\",\n" +
            "      \"possui_impedimento\": true,\n" +
            "      \"observacoes\": \"ear\"\n" +
            "    },\n" +
            "    \"filiacao\": {\n" +
            "      \"nome_mae\": \"Maria José\",\n" +
            "      \"nome_pai\": \"José Maria\"\n" +
            "    },\n" +
            "    \"documento\": {\n" +
            "      \"tipo\": 1,\n" +
            "      \"numero\": \"000001\",\n" +
            "      \"orgao_expedidor\": \"SSP\",\n" +
            "      \"uf_expedidor\": \"DF\"\n" +
            "    },\n" +
            "    \"endereco\": {\n" +
            "      \"logradouro\": \"Nome do Logradouro\",\n" +
            "      \"numero\": \"0007\",\n" +
            "      \"complemento\": \"APTO 2015\",\n" +
            "      \"bairro\": \"Nome do Bairro\",\n" +
            "      \"cep\": \"0000001\",\n" +
            "      \"municipio\": \"Nome do municipio\",\n" +
            "      \"uf\": \"DF\"\n" +
            "    }\n" +
            "  }\n" +
            "}";

    public static String pessoa2Digital = "{\n" +
            "  \"key\": {\n" +
            "    \"cpf\": \"25774435016\"\n" +
            "  },\n" +
            "  \"answer\": {\n" +
            "    \"nome\": \"Maria Barbosa\",\n" +
            "    \"data_nascimento\": \"2001-01-01\",\n" +
            "    \"situacao_cpf\": \"regular\",\n" +
            "    \"sexo\": \"F\",\n" +
            "    \"nacionalidade\": 1,\n" +
            "    \"cnh\": {\n" +
            "      \"numero_registro\": \"0000001\",\n" +
            "      \"categoria\": \"AB\",\n" +
            "      \"codigo_situacao\": \"3\",\n" +
            "      \"data_ultima_emissao\": \"2000-10-01\",\n" +
            "      \"data_validade\": \"2005-12-10\",\n" +
            "      \"data_primeira_habilitacao\": \"2000-10-31\",\n" +
            "      \"registro_nacional_estrangeiro\": \"123456\",\n" +
            "      \"possui_impedimento\": true,\n" +
            "      \"observacoes\": \"ear\"\n" +
            "    },\n" +
            "    \"filiacao\": {\n" +
            "      \"nome_mae\": \"Maria José\",\n" +
            "      \"nome_pai\": \"José Maria\"\n" +
            "    },\n" +
            "    \"documento\": {\n" +
            "      \"tipo\": 1,\n" +
            "      \"numero\": \"000001\",\n" +
            "      \"orgao_expedidor\": \"SSP\",\n" +
            "      \"uf_expedidor\": \"DF\"\n" +
            "    },\n" +
            "    \"endereco\": {\n" +
            "      \"logradouro\": \"Nome do Logradouro\",\n" +
            "      \"numero\": \"0007\",\n" +
            "      \"complemento\": \"APTO 2015\",\n" +
            "      \"bairro\": \"Nome do Bairro\",\n" +
            "      \"cep\": \"0000001\",\n" +
            "      \"municipio\": \"Nome do municipio\",\n" +
            "      \"uf\": \"DF\"\n" +
            "    },\n" +
            "    \"digitais\": [\n" +
            "      {\n" +
            "        \"posicao\": 0,\n" +
            "        \"formato\": \"WSQ\",\n" +
            "        \"base64\": \"imagem em base64\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

}
