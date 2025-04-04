-- V2: Migrations para adicionar a coluna img_url na tabela de cadastro
ALTER TABLE tb_cadastro
ADD COLUMN IMG_URL VARCHAR(255);