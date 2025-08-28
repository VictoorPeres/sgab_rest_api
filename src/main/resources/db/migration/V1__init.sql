create table tb_acesso (
   id_acesso bigint identity not null,
   ds_acesso varchar(255) not null,
   nm_acesso varchar(255) not null,
   primary key (id_acesso)
);

create table tb_categoria (
   id_categoria bigint identity not null,
   ds_categoria varchar(255) not null,
   id_secao bigint not null,
   primary key (id_categoria)
);

create table tb_cliente (
   id_cliente bigint identity not null,
   nm_cliente varchar(255) not null,
   cpf varchar(255) not null,
   email varchar(255),
   nr_telefone varchar(255) not null,
   tp_cliente smallint not null check (tp_cliente between 0 and 1),
   primary key (id_cliente)
);

create table tb_departamento (
   id_departamento bigint identity not null,
   ds_departamento varchar(255) not null,
   primary key (id_departamento)
);

create table tb_documento_entrada (
   id_documento_entrada bigint identity not null,
   ds_documento_entrada varchar(255) not null,
   dt_abertura varchar(255) not null,
   dt_fechamento varchar(255),
   dt_previsao_saida varchar(255) not null,
   nr_serie_emprestimo varchar(255),
   bi_relatorio_sinistro varbinary(255),
   bi_relatorio_sinistro_resumo varbinary(255),
   sn_produto_emprestado varchar(255),
   status_documento smallint not null check (status_documento between 0 and 2),
   id_cliente bigint not null,
   id_empresa bigint not null,
   id_produto_emprestado bigint,
   id_usuario bigint not null,
   primary key (id_documento_entrada)
);

create table tb_documento_saida (
   id_documento_saida bigint identity not null,
   bi_anexo_ varbinary(255),
   dt_acaoo varchar(255) not null,
   ds_documento_saida varchar(255) not null,
   nm_anexo varchar(255),
   ds_tipo_anexo varchar(255),
   documento_entrada bigint not null,
   id_usuario bigint not null,
   primary key (id_documento_saida)
);

create table tb_empresa (
   id_empresa bigint identity not null,
   cnpj varchar(255) not null,
   email varchar(255),
   nm_fantasia varchar(255) not null,
   razao_social varchar(255) not null,
   nr_telefone varchar(255) not null,
   tp_empresa smallint not null check (tp_empresa between 0 and 1),
   id_distribuidora bigint,
   primary key (id_empresa)
);

create table tb_item_documento_entrada (
   id_item bigint identity not null,
   dt_compra datetime2(6) not null,
   nr_serie varchar(255) not null,
   id_documento_entrada bigint not null,
   id_produto bigint not null,
   primary key (id_item)
);

create table tb_marca (
   id_marca bigint identity not null,
   ds_marca varchar(255) not null,
   status smallint not null check (status between 0 and 1),
   primary key (id_marca)
);

create table tb_perfil (
   id_perfil bigint identity not null,
   ds_perfil varchar(255) not null,
   nm_perfil varchar(255) not null,
   status smallint not null check (status between 0 and 1),
   primary key (id_perfil)
);

create table tb_perfil_acesso (
   id_perfil_acesso bigint identity not null,
   id_acesso bigint,
   id_perfil bigint,
   primary key (id_perfil_acesso)
);

create table tb_produto (
   id_produto bigint identity not null,
   ds_produto varchar(255) not null,
   ds_modelo varchar(255) not null,
   altura float(53),
   largura float(53),
   peso float(53) not null,
   profundidade float(53),
   observacoes varchar(255),
   id_categoria bigint not null,
   id_marca bigint not null,
   primary key (id_produto)
);

create table tb_secao (
   id_secao bigint identity not null,
   ds_secao varchar(255) not null,
   id_departamento bigint not null,
   primary key (id_secao)
);

create table tb_usuario (
   id_usuario bigint identity not null,
   email varchar(255) not null,
   nm_usuario varchar(255) not null,
   password varchar(255) not null,
   primeiro_acesso bit not null,
   sn_usuario varchar(255) not null,
   status smallint not null check (status between 0 and 1),
   username varchar(255) not null,
   id_empresa bigint not null,
   perfil bigint not null,
   primary key (id_usuario)
);

alter table tb_categoria add constraint FK54e72jvehqi3qo1b0qkrclo8o foreign key (id_secao) references tb_secao;

alter table tb_documento_entrada add constraint FKxixbqtoaa917bilxx4ddt4l0 foreign key (id_cliente) references tb_cliente;

alter table tb_documento_entrada add constraint FK422hvn4654m29vg0l255uexdx foreign key (id_empresa) references tb_empresa;

alter table tb_documento_entrada add constraint FKrduwkgoyd0ctp8p7wg6c87cl4 foreign key (id_produto_emprestado) references tb_produto;

alter table tb_documento_entrada add constraint FK5bthjenhxud1j4u68patlp2ml foreign key (id_usuario) references tb_usuario;

alter table tb_documento_saida add constraint FKhn5vex3hnlj0f30cpq70s701i foreign key (documento_entrada) references tb_documento_entrada;

alter table tb_documento_saida add constraint FK3d0url6h532xsm03ranf6saq5 foreign key (id_usuario) references tb_usuario;

alter table tb_empresa add constraint FKd26qr6l1a23b0xp8edqc3hm1h foreign key (id_distribuidora) references tb_empresa;

alter table tb_item_documento_entrada add constraint FKnerlffl3cb4nn95vqq7haftwi foreign key (id_documento_entrada) references tb_documento_entrada;

alter table tb_item_documento_entrada add constraint FKaf5gdtr8697frrhvldlr66h4a foreign key (id_produto) references tb_produto;

alter table tb_perfil_acesso add constraint FKqhgsg5uixxhku7y4ocdblkkjt foreign key (id_acesso) references tb_acesso;

alter table tb_perfil_acesso add constraint FKjlj9366q1v8xmnc02mvdghyjh foreign key (id_perfil) references tb_perfil;

alter table tb_produto add constraint FKnihko7fk99g20gbvnv8h56ppg foreign key (id_categoria) references tb_categoria;

alter table tb_produto add constraint FKrp1hdbmswf2jjr03vptbathd7 foreign key (id_marca) references tb_marca;

alter table tb_secao add constraint FKdvhrka8tq3nph01wg9nd4sgi2 foreign key (id_departamento) references tb_departamento;

alter table tb_usuario add constraint FKi6nqpy1qcovllypvag46ldf0s foreign key (id_empresa) references tb_empresa;

alter table tb_usuario add constraint FKmy59s4tgrdbt2q3go752cx6io foreign key (perfil) references tb_perfil;
