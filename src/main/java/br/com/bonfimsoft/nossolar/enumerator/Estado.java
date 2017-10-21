package br.com.bonfimsoft.nossolar.enumerator;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

/**
 * Created by c090347 on 27/08/2014.
 */
@Convert
public enum Estado implements AttributeConverter<Estado, String> {

	AC("AC", "Acre"),
    AL("AL", "Alagoas"),
    AP("AP", "Amapá"),
    AM("AM", "Amazonas"),
    BA("BA", "Bahia"),
    CE("CE", "Ceará"),
    DF("DF", "Distrito Federal"),
    ES("ES", "Espirito Santo"),
    GO("GO", "Goias"),
    MA("MA", "Maranhão"),
    MT("MT", "Mato Grosso"),
    MS("MS", "Mato Grosso do Sul"),
    MG("MG", "Minas Gerais"),
    PA("PA", "Pará"),
    PB("PB", "Paraíba"),
    PR("PR", "Paraná"),
    PE("PE", "Pernambuco"),
    PI("PI", "Piauí"),
    RJ("RJ", "Rio de Janeiro"),
    RN("RN", "Rio Grande do Norte"),
    RS("RS", "Rio Grande do Sul"),
    RO("RO", "Rondonia"),
    RR("RR", "Roraima"),
    SC("SC", "Santa Catarina"),
    SP("SP", "São Paulo"),
    SE("SE", "Sergipe"),
    TO("TO", "Tocantins");

    private String sigla;
    private String descricao;

    Estado(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }


    @Override
    public String convertToDatabaseColumn(Estado estado) {
        return estado.getSigla();
    }

    @Override
    public Estado convertToEntityAttribute(String sigla) {
        if (sigla.equals("AC")) {
            return AC;
        } else if (sigla.equals("AL")) {
            return AL;
        } else if (sigla.equals("AP")) {
            return AP;
        } else if (sigla.equals("AM")) {
            return AM;
        } else if (sigla.equals("BA")) {
            return BA;
        } else if (sigla.equals("CE")) {
            return CE;
        } else if (sigla.equals("DF")) {
            return DF;
        } else if (sigla.equals("ES")) {
            return ES;
        } else if (sigla.equals("GO")) {
            return GO;
        } else if (sigla.equals("MA")) {
            return MA;
        } else if (sigla.equals("MT")) {
            return MT;
        } else if (sigla.equals("MS")) {
            return MS;
        } else if (sigla.equals("MG")) {
            return MG;
        } else if (sigla.equals("PA")) {
            return PA;
        } else if (sigla.equals("PB")) {
            return PB;
        } else if (sigla.equals("PR")) {
            return PR;
        } else if (sigla.equals("PE")) {
            return PE;
        } else if (sigla.equals("PI")) {
            return PI;
        } else if (sigla.equals("RJ")) {
            return RJ;
        } else if (sigla.equals("RN")) {
            return RN;
        } else if (sigla.equals("RS")) {
            return RS;
        } else if (sigla.equals("RO")) {
            return RO;
        } else if (sigla.equals("RR")) {
            return RR;
        } else if (sigla.equals("SC")) {
            return SC;
        } else if (sigla.equals("SP")) {
            return SP;
        } else if (sigla.equals("SE")) {
            return SE;
        } else if (sigla.equals("TO")) {
            return TO;
        } else {
            throw new IllegalArgumentException("Sigla de Estado Desconhecida: " + sigla);
        }
    }
}
