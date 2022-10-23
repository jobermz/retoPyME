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
  int_id_dataset integer NOT NULL,
  var_nomb_comp character varying(400) NOT NULL,
  var_direccion character varying(300) NOT NULL,
  
  int_califi_estrellas  integer NOT NULL,
  int_sentimiento_comentarios  integer NOT NULL,
  CONSTRAINT empresa_bing_pkey PRIMARY KEY (srl_id),
  CONSTRAINT dataset1_fkey FOREIGN KEY(int_id_dataset) REFERENCES hackaton.dataset(srl_id)
);
CREATE TABLE hackaton.empresa_bing_comentarios (
  srl_id serial NOT NULL,
  int_id_empresa_bing integer NOT NULL,
  var_comentario character varying(400) NOT NULL,
  int_sentimiento_comentarios  integer NOT NULL,
  CONSTRAINT empresa_bing_comentarios_pkey PRIMARY KEY (srl_id),
  CONSTRAINT empresa_bing1_fkey FOREIGN KEY(int_id_empresa_bing) REFERENCES hackaton.empresa_bing(srl_id)
);

CREATE TABLE hackaton.empresa_google (
  srl_id serial NOT NULL,
  int_id_dataset integer NOT NULL,
  var_nomb_comp character varying(400) NOT NULL,
  var_direccion character varying(300) NOT NULL,
  
  int_califi_estrellas  integer NOT NULL,
  int_sentimiento_comentarios  integer NOT NULL,
  
  CONSTRAINT empresa_google_pkey PRIMARY KEY (srl_id),
  CONSTRAINT dataset2_fkey FOREIGN KEY(int_id_dataset) REFERENCES hackaton.dataset(srl_id)
);
CREATE TABLE hackaton.empresa_google_comentarios (
  srl_id serial NOT NULL,
  int_id_empresa_google integer NOT NULL,
  var_comentario character varying(400) NOT NULL,
  int_sentimiento_comentarios  integer NOT NULL,
  CONSTRAINT empresa_google_comentarios_pkey PRIMARY KEY (srl_id),
  CONSTRAINT empresa_google1_fkey FOREIGN KEY(int_id_empresa_google) REFERENCES hackaton.empresa_google(srl_id)
);




CREATE TABLE hackaton.inegi (
  srl_id serial NOT NULL,
  int_id_dataset integer NULL,
  var_nomb_comp character varying(400) NOT NULL,
  var_direccion character varying(300) NOT NULL,
  
  int_estrato_perso_ocupado  integer NOT NULL, --Descripcion estrato personal ocupado
  int_tipo_establecimiento  integer NOT NULL,
  
  CONSTRAINT inegi_pkey PRIMARY KEY (srl_id)
);
