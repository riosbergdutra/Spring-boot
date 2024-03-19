CREATE TABLE pagamento (
    id_pagamento BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor DOUBLE NOT NULL,
    endereco VARCHAR(255) NOT NULL
);
