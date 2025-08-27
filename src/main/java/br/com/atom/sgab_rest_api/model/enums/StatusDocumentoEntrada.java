package br.com.atom.sgab_rest_api.model.enums;

public enum StatusDocumentoEntrada {

    FINALIZADO(0, "FINALIZADO"), EM_ANALISE(1, "EM ANALISE"), AGUARDANDO_RETIRADA(2, "AGUARDANDO RETIRADA");

    private final int codigo;
    private final String descricao;

    StatusDocumentoEntrada(int codigo, String descricao) {
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
