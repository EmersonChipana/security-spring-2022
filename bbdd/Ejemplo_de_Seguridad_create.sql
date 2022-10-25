-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-10-20 23:41:35.603

-- tables
-- Table: mr_group
CREATE TABLE mr_group (
    group_id serial  NOT NULL,
    name varchar(100)  NOT NULL,
    description varchar(400)  NULL,
    status boolean  NOT NULL,
    tx_username varchar(50)  NOT NULL,
    tx_host varchar(50)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT mr_group_pk PRIMARY KEY (group_id)
);

-- Table: mr_group_role
CREATE TABLE mr_group_role (
    group_role_id serial  NOT NULL,
    group_id int  NOT NULL,
    role_id int  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(50)  NOT NULL,
    tx_host varchar(50)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT mr_group_role_pk PRIMARY KEY (group_role_id)
);

-- Table: mr_order
CREATE TABLE mr_order (
    order_id serial  NOT NULL,
    customer_name varchar(400)  NOT NULL,
    customer_address varchar(400)  NOT NULL,
    vat_number varchar(100)  NOT NULL,
    order_date timestamp  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(50)  NOT NULL,
    tx_host varchar(50)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT mr_order_pk PRIMARY KEY (order_id)
);

-- Table: mr_order_detail
CREATE TABLE mr_order_detail (
    order_detail_id serial  NOT NULL,
    order_id int  NOT NULL,
    product_name varchar(400)  NOT NULL,
    unit_price decimal(15,5)  NOT NULL,
    qtty decimal(8,4)  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(50)  NOT NULL,
    tx_host varchar(50)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT mr_order_detail_pk PRIMARY KEY (order_detail_id)
);

-- Table: mr_role
CREATE TABLE mr_role (
    role_id serial  NOT NULL,
    name varchar(100)  NOT NULL,
    description varchar(400)  NULL,
    status boolean  NOT NULL,
    tx_username varchar(50)  NOT NULL,
    tx_host varchar(50)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT mr_role_pk PRIMARY KEY (role_id)
);

-- Table: mr_user
CREATE TABLE mr_user (
    user_id serial  NOT NULL,
    username varchar(100)  NOT NULL,
    secret varchar(100)  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(50)  NOT NULL,
    tx_host varchar(50)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT mr_user_pk PRIMARY KEY (user_id)
);

-- Table: mr_user_group
CREATE TABLE mr_user_group (
    user_group_id serial  NOT NULL,
    user_id int  NOT NULL,
    group_id int  NOT NULL,
    status boolean  NOT NULL,
    tx_username varchar(50)  NOT NULL,
    tx_host varchar(50)  NOT NULL,
    tx_date timestamp  NOT NULL,
    CONSTRAINT mr_user_group_pk PRIMARY KEY (user_group_id)
);

-- foreign keys
-- Reference: mr_group_role_mr_group (table: mr_group_role)
ALTER TABLE mr_group_role ADD CONSTRAINT mr_group_role_mr_group
    FOREIGN KEY (group_id)
    REFERENCES mr_group (group_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: mr_group_role_mr_role (table: mr_group_role)
ALTER TABLE mr_group_role ADD CONSTRAINT mr_group_role_mr_role
    FOREIGN KEY (role_id)
    REFERENCES mr_role (role_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: mr_order_detail_mr_order (table: mr_order_detail)
ALTER TABLE mr_order_detail ADD CONSTRAINT mr_order_detail_mr_order
    FOREIGN KEY (order_id)
    REFERENCES mr_order (order_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: mr_user_group_mr_group (table: mr_user_group)
ALTER TABLE mr_user_group ADD CONSTRAINT mr_user_group_mr_group
    FOREIGN KEY (group_id)
    REFERENCES mr_group (group_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: mr_user_group_mr_user (table: mr_user_group)
ALTER TABLE mr_user_group ADD CONSTRAINT mr_user_group_mr_user
    FOREIGN KEY (user_id)
    REFERENCES mr_user (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

-- CONSTRAINT DE UNIOQUE para la tabla mr_user
ALTER TABLE mr_user ADD CONSTRAINT mr_user_username UNIQUE (username);