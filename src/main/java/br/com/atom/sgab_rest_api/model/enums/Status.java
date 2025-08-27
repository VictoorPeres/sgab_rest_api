package br.com.atom.sgab_rest_api.model.enums;

public enum Status {

    INATIVO(0, "INATIVO"), ATIVO(1, "ATIVO");

    private Integer codigo;
    private String descricao;

    Status(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
