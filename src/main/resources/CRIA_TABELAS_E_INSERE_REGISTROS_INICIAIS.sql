CREATE TABLE exame (codigo_exame bigint auto_increment, nm_exame VARCHAR(255) , PRIMARY KEY (codigo_exame));
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue');

CREATE TABLE funcionario (codigo_funcionario bigint auto_increment, nm_funcionario VARCHAR(255) , PRIMARY KEY (codigo_funcionario));
INSERT INTO funcionario (nm_funcionario) VALUES ('Larissa'), ('Carlos'), ('Camila'), ('Fatima');