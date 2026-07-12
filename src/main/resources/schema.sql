CREATE TABLE tb_roles (
    id      IDENTITY PRIMARY KEY,
    name    VARCHAR(50) NOT NULL
);

CREATE TABLE tb_users (
      id  IDENTITY PRIMARY KEY,
      cpf          VARCHAR(14),
      nome         VARCHAR(100) NOT NULL,
      nome_social  VARCHAR(100),
      email        VARCHAR(100) NOT NULL UNIQUE,
      password     VARCHAR(255) NOT NULL,
      campus       VARCHAR(100) NOT NULL,
      formacao     VARCHAR(100) NOT NULL,
      titulacao    VARCHAR(100) NOT NULL,
      sexo         VARCHAR(20),
      lattes       VARCHAR(255),
      telefone     VARCHAR(20)
);

CREATE TABLE tb_user_role (
    user_cpf VARCHAR(14),
    role_id INT
);

INSERT INTO tb_roles (id, name) VALUES (1, 'ROLE_COORDENADOR');
INSERT INTO tb_roles (id, name) VALUES (2, 'ROLE_AVALIADOR');