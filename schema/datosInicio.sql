INSERT INTO usuario(user_name,nombre,password,email,activo) VALUES('administrador','Administrador','J92+gtgO1bA=','contacto@contacto.com',1);

INSERT INTO departamento(nombre,activo) VALUES('Electrónica',1);
INSERT INTO departamento(nombre,activo) VALUES('Laudería',1);
INSERT INTO departamento(nombre,activo) VALUES('Pintura',1);
INSERT INTO departamento(nombre,activo) VALUES('Servicio Técnico',1);

INSERT INTO servicio(nombre,departamento_id,activo) VALUES('Ajuste Acción',4,1);
INSERT INTO servicio(nombre,departamento_id,activo) VALUES('Ajuste General',4,1);
INSERT INTO servicio(nombre,departamento_id,activo) VALUES('Cambio cables Batería',1,1);
INSERT INTO servicio(nombre,departamento_id,activo) VALUES('Cambio de Pastillas',1,1);
INSERT INTO servicio(nombre,departamento_id,activo) VALUES('Lacado',3,1);
INSERT INTO servicio(nombre,departamento_id,activo) VALUES('Lijado',2,1);
INSERT INTO servicio(nombre,departamento_id,activo) VALUES('Pegado de Clavijero',2,1);
INSERT INTO servicio(nombre,departamento_id,activo) VALUES('Pintado',3,1);
INSERT INTO servicio(nombre,departamento_id,activo) VALUES('Rebajado de Trastes',4,1);
