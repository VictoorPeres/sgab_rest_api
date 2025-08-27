package br.com.atom.sgab_rest_api.model.enums;

public enum TipoEmpresa {

    DISTRIBUIDORA(0, "DISTRIBUIDORA"), ASSISTENCIA(1, "ASSISTENCIA");

    private Integer codigo;
    private String descricao;

    TipoEmpresa(int codigo, String descricao) {
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
