INSERT INTO tb_user (name, email, age) VALUES ('Bob','bob@gmail.com', 25);

INSERT INTO tb_task_list (title, inclusion_Date, expiration_Date, completed, user_id) VALUES ('Go shopping', NOW(), TIMESTAMP WITH TIME ZONE '2023-09-30T15:00:00Z', TRUE, 1);
INSERT INTO tb_task_list (title, inclusion_Date, expiration_Date, completed, user_id) VALUES ('Exams', NOW(), TIMESTAMP WITH TIME ZONE '2023-10-10T10:00:00Z', FALSE, 1);
INSERT INTO tb_task_list (title, inclusion_Date, expiration_Date, completed, user_id) VALUES ('household bills', NOW(), TIMESTAMP WITH TIME ZONE '2023-09-20T15:00:00Z', FALSE, 1);
INSERT INTO tb_task_list (title, inclusion_Date, expiration_Date, completed, user_id) VALUES ('Christmas gift for son', NOW(), TIMESTAMP WITH TIME ZONE '2023-12-24T15:00:00Z', FALSE, 1); 

INSERT INTO tb_task (name, description, completed, task_list_id) VALUES ('Rice', 'Rice for lunch', TRUE, 1);
INSERT INTO tb_task (name, description, completed, task_list_id) VALUES ('study math', 'Mathematics test on 10/10', FALSE, 2); 
INSERT INTO tb_task (name, description, completed, task_list_id) VALUES ('Pay electricity', 'pay the electricity bill', FALSE, 3); 
INSERT INTO tb_task (name, description, completed, task_list_id) VALUES ('Pay water', 'pay the water bill', FALSE, 3); 
INSERT INTO tb_task (name, description, completed, task_list_id) VALUES ('Pay rent', 'Pay rent', FALSE, 3); 
INSERT INTO tb_task (name, description, completed, task_list_id) VALUES ('Toy plane', 'Buy a Christmas gift for my son', TRUE, 4);  

INSERT INTO tb_notification (message, date_Time, displayed, user_id, task_list_id) VALUES ('Reminder: study for the test', TIMESTAMP WITH TIME ZONE '2024-09-05T10:00:00Z', False, 1, 2);
INSERT INTO tb_notification (message, date_Time, displayed, user_id, task_list_id) VALUES ('Reminder: last 24 hours to complete the task', TIMESTAMP WITH TIME ZONE '2024-09-09T10:00:00Z', False, 1, 4);
INSERT INTO tb_notification (message, date_Time, displayed, user_id, task_list_id) VALUES ('Reminder: only 1 hour left until the task deadline', TIMESTAMP WITH TIME ZONE '2024-09-05T09:00:00Z', False, 1, 4);

