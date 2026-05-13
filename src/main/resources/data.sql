-- TUTORES
INSERT INTO TUTOR (id, nome, email, telefone) VALUES (1, 'Joao Silva', 'joao@email.com', '11999990001');
INSERT INTO TUTOR (id, nome, email, telefone) VALUES (2, 'Maria Souza', 'maria@email.com', '11999990002');
INSERT INTO TUTOR (id, nome, email, telefone) VALUES (3, 'Carlos Lima', 'carlos@email.com', '11999990003');

-- VETERINÁRIOS
INSERT INTO VETERINARIO (id, nome, especialidade) VALUES (1, 'Dra. Ana Paula', 'cao');
INSERT INTO VETERINARIO (id, nome, especialidade) VALUES (2, 'Dr. Bruno Costa', 'gato');
INSERT INTO VETERINARIO (id, nome, especialidade) VALUES (3, 'Dra. Camila Reis', 'ave');

-- ANIMAIS
INSERT INTO ANIMAL (id, nome, especie, raca, idade, tutor_id) VALUES (1, 'Rex',    'cao',  'Labrador',       4, 1);
INSERT INTO ANIMAL (id, nome, especie, raca, idade, tutor_id) VALUES (2, 'Mia',    'gato', 'Siames',         2, 2);
INSERT INTO ANIMAL (id, nome, especie, raca, idade, tutor_id) VALUES (3, 'Piu',    'ave',  'Calopsita',      1, 3);
INSERT INTO ANIMAL (id, nome, especie, raca, idade, tutor_id) VALUES (4, 'Bolinha','cao',  'Poodle',         6, 1);

-- CONSULTAS
INSERT INTO CONSULTA (id, data_hora, status, motivo_consulta, animal_id, veterinario_id)
    VALUES (1, '2025-05-01 09:00:00', 'REALIZADA', 'Consulta de rotina',    1, 1);
INSERT INTO CONSULTA (id, data_hora, status, motivo_consulta, animal_id, veterinario_id)
    VALUES (2, '2025-05-03 14:00:00', 'REALIZADA', 'Vomito frequente',      2, 2);
INSERT INTO CONSULTA (id, data_hora, status, motivo_consulta, animal_id, veterinario_id)
    VALUES (3, '2025-05-10 10:30:00', 'AGENDADA',  'Perda de penas',        3, 3);
INSERT INTO CONSULTA (id, data_hora, status, motivo_consulta, animal_id, veterinario_id)
    VALUES (4, '2025-05-15 11:00:00', 'AGENDADA',  'Check-up anual',        4, 1);

-- PRONTUÁRIOS (apenas para consultas já realizadas)
INSERT INTO PRONTUARIO (id, diagnostico, tratamento, data, consulta_id)
    VALUES (1, 'Animal saudavel',          'Nenhum tratamento necessário',   '2025-05-01', 1);
INSERT INTO PRONTUARIO (id, diagnostico, tratamento, data, consulta_id)
    VALUES (2, 'Gastrite leve',            'Ração especial por 10 dias',     '2025-05-03', 2);

-- VACINAS
INSERT INTO VACINA (id, nome, data_aplicacao, proxima_dose, animal_id)
    VALUES (1, 'Antirrabica',  '2025-01-10', '2026-01-10', 1);
INSERT INTO VACINA (id, nome, data_aplicacao, proxima_dose, animal_id)
    VALUES (2, 'V10',          '2025-02-15', '2026-02-15', 1);
INSERT INTO VACINA (id, nome, data_aplicacao, proxima_dose, animal_id)
    VALUES (3, 'Antirrabica',  '2025-03-20', '2026-03-20', 2);
INSERT INTO VACINA (id, nome, data_aplicacao, proxima_dose, animal_id)
    VALUES (4, 'V4 Felina',    '2025-03-20', '2026-03-20', 2);