CREATE TABLE entrega (
    id_entrega BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_pagamento BIGINT NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    status_pedido VARCHAR(50) DEFAULT 'pendente' NOT NULL
);
