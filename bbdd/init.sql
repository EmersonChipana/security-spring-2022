-- Datos de prueba para la tabla mr_user
INSERT INTO mr_user ( username, secret, status, tx_username, tx_host, tx_date)
VALUES ('jperez', 'ASDASD!@#123123123123', true, 'admin', '127.0.0.1', now());

INSERT INTO mr_user ( username, secret, status, tx_username, tx_host, tx_date)
VALUES ('mgomez', 'ASDASD!@#123123123123', true, 'admin', '127.0.0.1', now());

INSERT INTO mr_user ( username, secret, status, tx_username, tx_host, tx_date)
VALUES ('lramirez', 'ASDASD!@#123123123123', true, 'admin', '127.0.0.1', now());


-- Inserto datos para los grupos
INSERT INTO mr_group ( name, description, status, tx_username, tx_host, tx_date) VALUES
('CAJERO', 'GRUPO PARA CAJEROS DE VENTANILLAS', true, 'admin', '127.0.0.1', now());
INSERT INTO mr_group ( name, description, status, tx_username, tx_host, tx_date) VALUES
('PLATAFORMA', 'GRUPO PARA OFICIALES DE PLATAFORMA', true, 'admin', '127.0.0.1', now());
INSERT INTO mr_group ( name, description, status, tx_username, tx_host, tx_date) VALUES
    ('ADMIN', 'ADMINISTRADOR DEL SISTEMA', true, 'admin', '127.0.0.1', now());


-- Inserto datos para los roles
INSERT INTO mr_role ( name, description, status, tx_username, tx_host, tx_date) VALUES
    ('CREAR_ORDEN', null, true, 'admin', '127.0.0.1', now());
INSERT INTO mr_role ( name, description, status, tx_username, tx_host, tx_date) VALUES
    ('LEER_ORDEN', null, true, 'admin', '127.0.0.1', now());
INSERT INTO mr_role ( name, description, status, tx_username, tx_host, tx_date) VALUES
    ('CREAR_USUARIO', null, true, 'admin', '127.0.0.1', now());

INSERT INTO mr_group_role (group_id, role_id, status, tx_username, tx_host, tx_date)
VALUES (1, 3, true, 'admin', '127.0.0.1', now());

INSERT INTO mr_group_role (group_id, role_id, status, tx_username, tx_host, tx_date)
VALUES (2, 1, true, 'admin', '127.0.0.1', now());

INSERT INTO mr_group_role (group_id, role_id, status, tx_username, tx_host, tx_date)
VALUES (3, 2, true, 'admin', '127.0.0.1', now());

INSERT INTO mr_user_group ( user_id, group_id, status, tx_username, tx_host, tx_date)
VALUES (1, 1, true, 'admin', '127.0.0.1', now());

INSERT INTO mr_user_group ( user_id, group_id, status, tx_username, tx_host, tx_date)
VALUES (2, 2, true, 'admin', '127.0.0.1', now());

INSERT INTO mr_user_group ( user_id, group_id, status, tx_username, tx_host, tx_date)
VALUES (3, 3, true, 'admin', '127.0.0.1', now());

-- PROBAMOS
SELECT mr.name, mr.description
FROM
    mr_user usr
    LEFT JOIN mr_user_group mug on usr.user_id = mug.user_id
    LEFT JOIN mr_group mg on mug.group_id = mg.group_id
    LEFT JOIN mr_group_role mgr on mg.group_id = mgr.group_id
    LEFT JOIN mr_role mr on mgr.role_id = mr.role_id
WHERE
    usr.username = 'lramirez';


