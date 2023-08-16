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

    public static String pessoa3Facial = "{\n" +
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
            "    \"biometria_face\": {\n" +
            "      \"formato\": \"PNG\",\n" +
            "      \"base64\": \"PNG\"\n" +
            "    }\n" +
            "  }\n" +
            "}";


    public static String pessoa4FacialCDV = "{\n" +
            "  \"key\": {\n" +
            "    \"cpf\": \"25774435016\"\n" +
            "  },\n" +
            "  \"answer\": {\n" +
            "    \"documento\": {\n" +
            "      \"formato\": \"JPG\",\n" +
            "      \"base64\": \"imagembase64\"\n" +
            "    }\n" +
            "  }\n" +
            "}";

    public static String pessoa5FacialDIGITAL = "{\n" +
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
            "    \"biometria_face\": {\n" +
            "      \"formato\": \"PNG\",\n" +
            "      \"base64\": \"imagem em base64\"\n" +
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
    public static String pessoaJuridica = "{\n" +
            "  \"key\": {\n" +
            "    \"cnpj\": \"33683111000107\"\n" +
            "  },\n" +
            "  \"answer\": {\n" +
            "    \"endereco\": {\n" +
            "      \"logradouro\": \"Nome do Logradouro\",\n" +
            "      \"numero\": \"0007\",\n" +
            "      \"complemento\": \"APTO 2015\",\n" +
            "      \"bairro\": \"Nome do Bairro\",\n" +
            "      \"cep\": \"0000001\",\n" +
            "      \"municipio\": \"Nome do municipio\",\n" +
            "      \"uf\": \"DF\"\n" +
            "    },\n" +
            "    \"porte\": \"00\",\n" +
            "    \"telefone\": {\n" +
            "      \"ddd\": \"00\",\n" +
            "      \"numero\": \"00000000\"\n" +
            "    },\n" +
            "    \"razao_social\": \"Nome da empresa\",\n" +
            "    \"nome_fantasia\": \"Nome Fantasia da Empresa\",\n" +
            "    \"data_abertura\": \"2000-01-01\",\n" +
            "    \"cnae_principal\": {\n" +
            "      \"codigo\": \"6204000\",\n" +
            "      \"descricao\": \"Descrição do cnae\"\n" +
            "    },\n" +
            "    \"natureza_juridica\": {\n" +
            "      \"codigo\": \"01\",\n" +
            "      \"descricao\": \"descrição\"\n" +
            "    },\n" +
            "    \"situacao_cadastral\": {\n" +
            "      \"codigo\": 2,\n" +
            "      \"data\": \"2000-02-01\",\n" +
            "      \"motivo\": \"Descrição do motivo\"\n" +
            "    },\n" +
            "    \"situacao_especial\": \"situação\",\n" +
            "    \"correio_eletronico\": \"empresa@dominio.com.br\",\n" +
            "    \"capital_social\": 0\n" +
            "  }\n" +
            "}";
}
