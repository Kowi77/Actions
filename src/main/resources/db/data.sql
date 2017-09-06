DELETE FROM actions;
DELETE FROM gifts;
ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO actions (name, amount) VALUES
  ('Жаркое лето', 20),
  ('Ласковая осень', 8),
  ('Снежная зима', 12);

INSERT INTO gifts (name, quantity) VALUES
  ('Конфеты', 10),
  ('Шарики', 8),
  ('Котлеты', 5),
  ('Варежки', 12),
  ('Машина', 1),
  ('Сок', 4);
