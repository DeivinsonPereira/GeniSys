INSERT INTO tb_usuario (nome, email, idade) VALUES ('Bruno','bruno@gmail.com', 25);

INSERT INTO tb_tarefa (titulo, descricao, data_Inclusao, vencimento, concluida, usuario_id) VALUES ('Passar no mercado', 'Comprar: Arroz, feijão, carne, sal, ovos', NOW(), TIMESTAMP WITH TIME ZONE '2024-10-20T15:00:00Z', True, 1);
INSERT INTO tb_tarefa (titulo, descricao, data_Inclusao, vencimento, concluida, usuario_id) VALUES ('Provas', 'Estudar matemática e história', NOW(), TIMESTAMP WITH TIME ZONE '2024-09-10T10:00:00Z', False, 1); 
INSERT INTO tb_tarefa (titulo, descricao, data_Inclusao, vencimento, concluida, usuario_id) VALUES ('Pagar luz', 'Pagar a conta de Luz', NOW(), TIMESTAMP WITH TIME ZONE '2024-09-10T15:00:00Z', False, 1); 
INSERT INTO tb_tarefa (titulo, descricao, data_Inclusao, vencimento, concluida, usuario_id) VALUES ('Pagar água', 'Pagar a conta de água', NOW(), TIMESTAMP WITH TIME ZONE '2024-09-15T15:00:00Z', False, 1); 
INSERT INTO tb_tarefa (titulo, descricao, data_Inclusao, vencimento, concluida, usuario_id) VALUES ('Pagar aluguel', 'Pagar o aluguel', NOW(), TIMESTAMP WITH TIME ZONE '2024-10-20T15:00:00Z', False, 1); 
INSERT INTO tb_tarefa (titulo, descricao, data_Inclusao, vencimento, concluida, usuario_id) VALUES ('Comprar presente de Natal', 'Comprar presente de natal para as crianças', NOW(), TIMESTAMP WITH TIME ZONE '2024-12-24T23:59:59Z', True, 1);  

INSERT INTO tb_notificacao (mensagem, data_Hora, exibida, usuario_id, tarefa_id) VALUES ('Lembrete: estudar para a prova', TIMESTAMP WITH TIME ZONE '2024-09-05T10:00:00Z', False, 1, 2);
INSERT INTO tb_notificacao (mensagem, data_Hora, exibida, usuario_id, tarefa_id) VALUES ('Lembrete: últimas 24 horas para concluir a tarefa.', TIMESTAMP WITH TIME ZONE '2024-09-09T10:00:00Z', False, 1, 2);
INSERT INTO tb_notificacao (mensagem, data_Hora, exibida, usuario_id, tarefa_id) VALUES ('Lembrete: falta apenas 1 hora para o vencimento da tarefa', TIMESTAMP WITH TIME ZONE '2024-09-05T09:00:00Z', False, 1, 2);