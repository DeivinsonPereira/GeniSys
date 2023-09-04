INSERT INTO tb_usuario (nome, email, idade) VALUES ('Bruno','bruno@gmail.com', 25);

INSERT INTO tb_lista_tarefa (titulo, data_Inclusao, vencimento, concluida, usuario_id) VALUES ('Passar no mercado', NOW(), TIMESTAMP WITH TIME ZONE '2023-09-30T15:00:00Z', TRUE, 1);
INSERT INTO tb_lista_tarefa (titulo, data_Inclusao, vencimento, concluida, usuario_id) VALUES ('Provas', NOW(), TIMESTAMP WITH TIME ZONE '2023-10-10T10:00:00Z', FALSE, 1);
INSERT INTO tb_lista_tarefa (titulo, data_Inclusao, vencimento, concluida, usuario_id) VALUES ('Contas Casa', NOW(), TIMESTAMP WITH TIME ZONE '2023-09-20T15:00:00Z', FALSE, 1);
INSERT INTO tb_lista_tarefa (titulo, data_Inclusao, vencimento, concluida, usuario_id) VALUES ('Presente Natal Filho', NOW(), TIMESTAMP WITH TIME ZONE '2023-12-24T15:00:00Z', FALSE, 1); 

INSERT INTO tb_tarefa (nome, descricao, concluida, lista_tarefa_id) VALUES ('Arroz', 'Arroz para o almoço', TRUE, 1);
INSERT INTO tb_tarefa (nome, descricao, concluida, lista_tarefa_id) VALUES ('Estudar matemática', 'Prova de matemática dia 10/10', FALSE, 2); 
INSERT INTO tb_tarefa (nome, descricao, concluida, lista_tarefa_id) VALUES ('Pagar Luz', 'Pagar a conta de Luz', FALSE, 3); 
INSERT INTO tb_tarefa (nome, descricao, concluida, lista_tarefa_id) VALUES ('Pagar água', 'Pagar a conta de água', FALSE, 3); 
INSERT INTO tb_tarefa (nome, descricao, concluida, lista_tarefa_id) VALUES ('Pagar aluguel', 'Pagar o aluguel', FALSE, 3); 
INSERT INTO tb_tarefa (nome, descricao, concluida, lista_tarefa_id) VALUES ('Avião de Brinquedo', 'Comprar presente de natal para o meu filho', TRUE, 4);  

INSERT INTO tb_notificacao (mensagem, data_Hora, exibida, usuario_id, lista_tarefa_id) VALUES ('Lembrete: estudar para a prova', TIMESTAMP WITH TIME ZONE '2024-09-05T10:00:00Z', False, 1, 2);
INSERT INTO tb_notificacao (mensagem, data_Hora, exibida, usuario_id, lista_tarefa_id) VALUES ('Lembrete: últimas 24 horas para concluir a tarefa.', TIMESTAMP WITH TIME ZONE '2024-09-09T10:00:00Z', False, 1, 4);
INSERT INTO tb_notificacao (mensagem, data_Hora, exibida, usuario_id, lista_tarefa_id) VALUES ('Lembrete: falta apenas 1 hora para o vencimento da tarefa', TIMESTAMP WITH TIME ZONE '2024-09-05T09:00:00Z', False, 1, 4);

