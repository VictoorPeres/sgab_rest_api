package br.com.atom.sgab_rest_api.model.enums;

public enum TipoCliente {

    REVENDEDOR(0, "REVENDEDOR"), CONSUMIDOR_FINAL(1, "CONSUMIDOR FINAL");

    private final int codigo;
    private final String descricao;

    TipoCliente(int codigo, String descricao) {
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
