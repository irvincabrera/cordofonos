# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table accesorio (
  id                            bigint auto_increment not null,
  marca                         varchar(255),
  modelo                        varchar(255),
  descripcion                   varchar(255),
  precio_compra                 decimal(7,2),
  precio_venta                  decimal(7,2),
  existencias                   integer,
  existencias_minimas           integer,
  activo                        tinyint(1) default 0,
  orden_servicio_id             bigint,
  detalle_venta_id              bigint,
  created_by_id                 bigint,
  created                       datetime(6) not null,
  updated                       datetime(6) not null,
  constraint pk_accesorio primary key (id)
);

create table accion_entonacion (
  id                            bigint auto_increment not null,
  accion_puente                 varchar(255),
  accion_cejuela                varchar(255),
  curvatura                     varchar(255),
  entonacion                    varchar(255),
  instrumento_id                bigint,
  constraint pk_accion_entonacion primary key (id)
);

create table cliente (
  id                            bigint auto_increment not null,
  nombre_completo               varchar(255),
  ciudad                        varchar(255),
  email                         varchar(255),
  facebook                      varchar(255),
  whatsapp                      integer,
  telefono                      integer,
  registered_by_id              bigint,
  created                       datetime(6) not null,
  updated                       datetime(6) not null,
  constraint pk_cliente primary key (id)
);

create table condiciones_ajuste (
  id                            bigint auto_increment not null,
  puente                        varchar(255),
  cejuela                       varchar(255),
  trastes                       varchar(255),
  ajuste_alma                   varchar(255),
  tuerca_alma                   varchar(255),
  diapason                      varchar(255),
  brazo                         varchar(255),
  angulo_brazo                  varchar(255),
  instrumento_id                bigint,
  constraint pk_condiciones_ajuste primary key (id)
);

create table departamento (
  id                            bigint auto_increment not null,
  nombre                        varchar(255),
  activo                        tinyint(1) default 0,
  constraint pk_departamento primary key (id)
);

create table detalle_servicio (
  id                            bigint auto_increment not null,
  servicio_id                   bigint,
  estatus                       varchar(255),
  tecnico_responsable_id        bigint,
  orden_servicio_id             bigint,
  costo                         decimal(7,2),
  fecha_termino                 datetime(6),
  created_by_id                 bigint,
  created                       datetime(6) not null,
  updated                       datetime(6) not null,
  constraint uq_detalle_servicio_servicio_id unique (servicio_id),
  constraint uq_detalle_servicio_tecnico_responsable_id unique (tecnico_responsable_id),
  constraint uq_detalle_servicio_created_by_id unique (created_by_id),
  constraint pk_detalle_servicio primary key (id)
);

create table detalle_venta (
  id                            bigint auto_increment not null,
  venta_id                      bigint,
  cantidad                      bigint,
  costo                         decimal(7,2),
  constraint pk_detalle_venta primary key (id)
);

create table electronica (
  id                            bigint auto_increment not null,
  pastilla_puente               varchar(255),
  pastilla_centro               varchar(255),
  pastilla_brazo                varchar(255),
  piezo_micro                   varchar(255),
  jack                          varchar(255),
  pot_volumen1                  varchar(255),
  pot_volumen2                  varchar(255),
  pot_tono1                     varchar(255),
  pot_tono2                     varchar(255),
  selector                      varchar(255),
  interruptores                 varchar(255),
  calidad_conexion              varchar(255),
  tierra_fisica                 varchar(255),
  blindaje                      varchar(255),
  preamplificador               varchar(255),
  pot_blend                     varchar(255),
  pot_eqgrav                    varchar(255),
  pot_eqmed                     varchar(255),
  pot_eqagu                     varchar(255),
  bateria                       varchar(255),
  conexion_bateria              varchar(255),
  instrumento_id                bigint,
  constraint pk_electronica primary key (id)
);

create table herrajes (
  id                            bigint auto_increment not null,
  segletas                      varchar(255),
  prisioneros                   varchar(255),
  bujes_postes                  varchar(255),
  palanca_tremolo               varchar(255),
  maquinaria                    varchar(255),
  candados                      varchar(255),
  guias_cuerda                  varchar(255),
  resortes                      varchar(255),
  pin_tahali                    varchar(255),
  pin_cuerdas                   varchar(255),
  instrumento_id                bigint,
  constraint pk_herrajes primary key (id)
);

create table instrumento (
  id                            bigint auto_increment not null,
  tipo_instrumento              varchar(255),
  marca                         varchar(255),
  modelo                        varchar(255),
  num_serie                     varchar(255),
  color                         varchar(255),
  fecha_produccion              datetime(6),
  cliente_id                    bigint,
  registered_by_id              bigint,
  created                       datetime(6) not null,
  updated                       datetime(6) not null,
  constraint pk_instrumento primary key (id)
);

create table orden_servicio (
  id                            bigint auto_increment not null,
  fecha_recepcion               datetime(6),
  cliente_id                    bigint,
  instrumento_id                bigint,
  contenedor                    varchar(255),
  contenedor_descripcion        varchar(255),
  almacen                       varchar(255),
  indicaciones_accion           varchar(255),
  indicaciones_afinacion        varchar(255),
  indicaciones_encordar         varchar(255),
  anotaciones                   varchar(255),
  condiciones_frente            LONGBLOB,
  condiciones_reverso           LONGBLOB,
  firma_electronica             varchar(255),
  total                         decimal(7,2),
  abono                         decimal(7,2),
  fecha_entrega                 datetime(6),
  created_by_id                 bigint,
  delivered_by_id               bigint,
  created                       datetime(6) not null,
  updated                       datetime(6) not null,
  constraint uq_orden_servicio_instrumento_id unique (instrumento_id),
  constraint pk_orden_servicio primary key (id)
);

create table plasticos_tapas_placas (
  id                            bigint auto_increment not null,
  mica                          varchar(255),
  marcos_pastillas              varchar(255),
  perillas                      varchar(255),
  portajack                     varchar(255),
  tapa_alma                     varchar(255),
  tapa_circuitos                varchar(255),
  tapa_resortes                 varchar(255),
  tapa_bateria                  varchar(255),
  tapa_ron_brazo                varchar(255),
  ferrules                      varchar(255),
  tornilleria                   varchar(255),
  instrumento_id                bigint,
  constraint pk_plasticos_tapas_placas primary key (id)
);

create table servicio (
  id                            bigint auto_increment not null,
  nombre                        varchar(255),
  departamento_id               bigint,
  activo                        tinyint(1) default 0,
  constraint pk_servicio primary key (id)
);

create table usuario (
  id                            bigint auto_increment not null,
  user_name                     varchar(255),
  nombre                        varchar(255),
  paterno                       varchar(255),
  materno                       varchar(255),
  password                      varchar(255),
  email                         varchar(255),
  pregunta_secreta              varchar(255),
  respuesta_secreta             varchar(255),
  activo                        tinyint(1) default 0,
  constraint uq_usuario_user_name unique (user_name),
  constraint pk_usuario primary key (id)
);

create table venta (
  id                            bigint auto_increment not null,
  fecha_venta                   datetime(6),
  nombre                        varchar(255),
  contacto                      varchar(255),
  total                         decimal(7,2),
  created_by_id                 bigint,
  created                       datetime(6) not null,
  updated                       datetime(6) not null,
  constraint pk_venta primary key (id)
);

alter table accesorio add constraint fk_accesorio_orden_servicio_id foreign key (orden_servicio_id) references orden_servicio (id) on delete restrict on update restrict;
create index ix_accesorio_orden_servicio_id on accesorio (orden_servicio_id);

alter table accesorio add constraint fk_accesorio_detalle_venta_id foreign key (detalle_venta_id) references detalle_venta (id) on delete restrict on update restrict;
create index ix_accesorio_detalle_venta_id on accesorio (detalle_venta_id);

alter table accesorio add constraint fk_accesorio_created_by_id foreign key (created_by_id) references usuario (id) on delete restrict on update restrict;
create index ix_accesorio_created_by_id on accesorio (created_by_id);

alter table accion_entonacion add constraint fk_accion_entonacion_instrumento_id foreign key (instrumento_id) references instrumento (id) on delete restrict on update restrict;
create index ix_accion_entonacion_instrumento_id on accion_entonacion (instrumento_id);

alter table cliente add constraint fk_cliente_registered_by_id foreign key (registered_by_id) references usuario (id) on delete restrict on update restrict;
create index ix_cliente_registered_by_id on cliente (registered_by_id);

alter table condiciones_ajuste add constraint fk_condiciones_ajuste_instrumento_id foreign key (instrumento_id) references instrumento (id) on delete restrict on update restrict;
create index ix_condiciones_ajuste_instrumento_id on condiciones_ajuste (instrumento_id);

alter table detalle_servicio add constraint fk_detalle_servicio_servicio_id foreign key (servicio_id) references servicio (id) on delete restrict on update restrict;

alter table detalle_servicio add constraint fk_detalle_servicio_tecnico_responsable_id foreign key (tecnico_responsable_id) references usuario (id) on delete restrict on update restrict;

alter table detalle_servicio add constraint fk_detalle_servicio_orden_servicio_id foreign key (orden_servicio_id) references orden_servicio (id) on delete restrict on update restrict;
create index ix_detalle_servicio_orden_servicio_id on detalle_servicio (orden_servicio_id);

alter table detalle_servicio add constraint fk_detalle_servicio_created_by_id foreign key (created_by_id) references usuario (id) on delete restrict on update restrict;

alter table detalle_venta add constraint fk_detalle_venta_venta_id foreign key (venta_id) references venta (id) on delete restrict on update restrict;
create index ix_detalle_venta_venta_id on detalle_venta (venta_id);

alter table electronica add constraint fk_electronica_instrumento_id foreign key (instrumento_id) references instrumento (id) on delete restrict on update restrict;
create index ix_electronica_instrumento_id on electronica (instrumento_id);

alter table herrajes add constraint fk_herrajes_instrumento_id foreign key (instrumento_id) references instrumento (id) on delete restrict on update restrict;
create index ix_herrajes_instrumento_id on herrajes (instrumento_id);

alter table instrumento add constraint fk_instrumento_cliente_id foreign key (cliente_id) references cliente (id) on delete restrict on update restrict;
create index ix_instrumento_cliente_id on instrumento (cliente_id);

alter table instrumento add constraint fk_instrumento_registered_by_id foreign key (registered_by_id) references usuario (id) on delete restrict on update restrict;
create index ix_instrumento_registered_by_id on instrumento (registered_by_id);

alter table orden_servicio add constraint fk_orden_servicio_cliente_id foreign key (cliente_id) references cliente (id) on delete restrict on update restrict;
create index ix_orden_servicio_cliente_id on orden_servicio (cliente_id);

alter table orden_servicio add constraint fk_orden_servicio_instrumento_id foreign key (instrumento_id) references instrumento (id) on delete restrict on update restrict;

alter table orden_servicio add constraint fk_orden_servicio_created_by_id foreign key (created_by_id) references usuario (id) on delete restrict on update restrict;
create index ix_orden_servicio_created_by_id on orden_servicio (created_by_id);

alter table orden_servicio add constraint fk_orden_servicio_delivered_by_id foreign key (delivered_by_id) references usuario (id) on delete restrict on update restrict;
create index ix_orden_servicio_delivered_by_id on orden_servicio (delivered_by_id);

alter table plasticos_tapas_placas add constraint fk_plasticos_tapas_placas_instrumento_id foreign key (instrumento_id) references instrumento (id) on delete restrict on update restrict;
create index ix_plasticos_tapas_placas_instrumento_id on plasticos_tapas_placas (instrumento_id);

alter table servicio add constraint fk_servicio_departamento_id foreign key (departamento_id) references departamento (id) on delete restrict on update restrict;
create index ix_servicio_departamento_id on servicio (departamento_id);

alter table venta add constraint fk_venta_created_by_id foreign key (created_by_id) references usuario (id) on delete restrict on update restrict;
create index ix_venta_created_by_id on venta (created_by_id);


# --- !Downs

alter table accesorio drop foreign key fk_accesorio_orden_servicio_id;
drop index ix_accesorio_orden_servicio_id on accesorio;

alter table accesorio drop foreign key fk_accesorio_detalle_venta_id;
drop index ix_accesorio_detalle_venta_id on accesorio;

alter table accesorio drop foreign key fk_accesorio_created_by_id;
drop index ix_accesorio_created_by_id on accesorio;

alter table accion_entonacion drop foreign key fk_accion_entonacion_instrumento_id;
drop index ix_accion_entonacion_instrumento_id on accion_entonacion;

alter table cliente drop foreign key fk_cliente_registered_by_id;
drop index ix_cliente_registered_by_id on cliente;

alter table condiciones_ajuste drop foreign key fk_condiciones_ajuste_instrumento_id;
drop index ix_condiciones_ajuste_instrumento_id on condiciones_ajuste;

alter table detalle_servicio drop foreign key fk_detalle_servicio_servicio_id;

alter table detalle_servicio drop foreign key fk_detalle_servicio_tecnico_responsable_id;

alter table detalle_servicio drop foreign key fk_detalle_servicio_orden_servicio_id;
drop index ix_detalle_servicio_orden_servicio_id on detalle_servicio;

alter table detalle_servicio drop foreign key fk_detalle_servicio_created_by_id;

alter table detalle_venta drop foreign key fk_detalle_venta_venta_id;
drop index ix_detalle_venta_venta_id on detalle_venta;

alter table electronica drop foreign key fk_electronica_instrumento_id;
drop index ix_electronica_instrumento_id on electronica;

alter table herrajes drop foreign key fk_herrajes_instrumento_id;
drop index ix_herrajes_instrumento_id on herrajes;

alter table instrumento drop foreign key fk_instrumento_cliente_id;
drop index ix_instrumento_cliente_id on instrumento;

alter table instrumento drop foreign key fk_instrumento_registered_by_id;
drop index ix_instrumento_registered_by_id on instrumento;

alter table orden_servicio drop foreign key fk_orden_servicio_cliente_id;
drop index ix_orden_servicio_cliente_id on orden_servicio;

alter table orden_servicio drop foreign key fk_orden_servicio_instrumento_id;

alter table orden_servicio drop foreign key fk_orden_servicio_created_by_id;
drop index ix_orden_servicio_created_by_id on orden_servicio;

alter table orden_servicio drop foreign key fk_orden_servicio_delivered_by_id;
drop index ix_orden_servicio_delivered_by_id on orden_servicio;

alter table plasticos_tapas_placas drop foreign key fk_plasticos_tapas_placas_instrumento_id;
drop index ix_plasticos_tapas_placas_instrumento_id on plasticos_tapas_placas;

alter table servicio drop foreign key fk_servicio_departamento_id;
drop index ix_servicio_departamento_id on servicio;

alter table venta drop foreign key fk_venta_created_by_id;
drop index ix_venta_created_by_id on venta;

drop table if exists accesorio;

drop table if exists accion_entonacion;

drop table if exists cliente;

drop table if exists condiciones_ajuste;

drop table if exists departamento;

drop table if exists detalle_servicio;

drop table if exists detalle_venta;

drop table if exists electronica;

drop table if exists herrajes;

drop table if exists instrumento;

drop table if exists orden_servicio;

drop table if exists plasticos_tapas_placas;

drop table if exists servicio;

drop table if exists usuario;

drop table if exists venta;

