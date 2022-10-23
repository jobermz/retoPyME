CREATE TABLE hackaton.dataset (
  srl_id serial NOT NULL,
  int_index integer NOT NULL,
  var_nombre1 character varying(100) NOT NULL,
  var_nombre2 character varying(100) NOT NULL,
  var_nombre3 character varying(100) NOT NULL,
  var_direccion1 character varying(100) NOT NULL,
  var_direccion2 character varying(100) NOT NULL,
  var_direccion3 character varying(100) NOT NULL,
  
  var_colonia character varying(100) NOT NULL,
  var_municipio_del character varying(100) NOT NULL,
  var_cp character varying(100) NOT NULL,
  var_entre_calle1 character varying(100) NOT NULL,
  var_entre_calle2 character varying(100) NOT NULL,
  var_estado character varying(100) NOT NULL,
  var_nomb_comp character varying(400) NOT NULL,
  CONSTRAINT dataset_pkey PRIMARY KEY (srl_id)
);



CREATE TABLE hackaton.empresa_bing (
  srl_id serial NOT NULL,
  int_id_dataset bigint unsigned NOT NULL,
  var_nomb_comp character varying(400) NOT NULL,
  var_direccion character varying(300) NOT NULL,
  
  int_califi_estrellas  integer NOT NULL,
  int_sentimiento_comentarios  integer NOT NULL,
  CONSTRAINT empresa_bing_pkey PRIMARY KEY (srl_id),
  CONSTRAINT dataset1_fkey FOREIGN KEY(int_id_dataset) REFERENCES hackaton.dataset(srl_id)
);
CREATE TABLE hackaton.empresa_bing_comentarios (
  srl_id serial NOT NULL,
  int_id_empresa_bing bigint unsigned NOT NULL,
  var_comentario character varying(400) NOT NULL,
  int_sentimiento_comentarios  integer NOT NULL,
  CONSTRAINT empresa_bing_comentarios_pkey PRIMARY KEY (srl_id),
  CONSTRAINT empresa_bing1_fkey FOREIGN KEY(int_id_empresa_bing) REFERENCES hackaton.empresa_bing(srl_id)
);

CREATE TABLE hackaton.empresa_google (
  srl_id serial NOT NULL,
  int_id_dataset bigint unsigned NOT NULL,
  var_nomb_comp character varying(400) NOT NULL,
  var_direccion character varying(300) NOT NULL,
  
  int_califi_estrellas  integer NOT NULL,
  int_sentimiento_comentarios  integer NOT NULL,
  
  CONSTRAINT empresa_google_pkey PRIMARY KEY (srl_id),
  CONSTRAINT dataset2_fkey FOREIGN KEY(int_id_dataset) REFERENCES hackaton.dataset(srl_id)
);
CREATE TABLE hackaton.empresa_google_comentarios (
  srl_id serial NOT NULL,
  int_id_empresa_google bigint unsigned NOT NULL,
  var_comentario character varying(400) NOT NULL,
  int_sentimiento_comentarios  integer NOT NULL,
  CONSTRAINT empresa_google_comentarios_pkey PRIMARY KEY (srl_id),
  CONSTRAINT empresa_google1_fkey FOREIGN KEY(int_id_empresa_google) REFERENCES hackaton.empresa_google(srl_id)
);




CREATE TABLE hackaton.inegi (
  srl_id serial NOT NULL,
  int_id_dataset bigint unsigned NULL,
  var_nomb_comp character varying(400) NOT NULL,
  var_direccion character varying(300) NOT NULL,
  
  int_estrato_perso_ocupado  integer NOT NULL, 
  int_tipo_establecimiento  integer NOT NULL,
  
  CONSTRAINT inegi_pkey PRIMARY KEY (srl_id)
);









INSERT INTO `hackaton`.`dataset`
(`int_index`,`var_nombre1`,`var_nombre2`,`var_nombre3`,`var_direccion1`,
`var_direccion2`,`var_direccion3`,`var_colonia`,`var_municipio_del`,`var_cp`,
`var_entre_calle1`,`var_entre_calle2`,`var_estado`,`var_nomb_comp`)
VALUES
(1,'aaa','bbb','ccc','d1',
'd2','d3','colo','muni','15012',
'calle1','calle2','est','Nombre completo empresa');




INSERT INTO `hackaton`.`empresa_bing`(`int_id_dataset`,`var_nomb_comp`,`var_direccion`,`int_califi_estrellas`,`int_sentimiento_comentarios`)
VALUES
(4037,'EMpresa 1','Direccion 1',10,


INSERT INTO `hackaton`.`empresa_bing_comentarios`
(`int_id_empresa_bing`,`var_comentario`,`int_sentimiento_comentarios`)
VALUES
(1,'mesaje xy',3);



INSERT INTO `hackaton`.`empresa_google`(`int_id_dataset`,`var_nomb_comp`,`var_direccion`,`int_califi_estrellas`,`int_sentimiento_comentarios`)
VALUES
(4037,'EMpresa 61','Direccion 13',5,3);


INSERT INTO `hackaton`.`empresa_google_comentarios`
(`int_id_empresa_google`,`var_comentario`,`int_sentimiento_comentarios`)
VALUES
(1,'mesaje XR',1);



INSERT INTO `hackaton`.`inegi`
(`int_id_dataset`,`var_nomb_comp`,`var_direccion`,`int_estrato_perso_ocupado`,`int_tipo_establecimiento`)
VALUES
(4037,'Empresa 33','Direccion real 1',150,1);

