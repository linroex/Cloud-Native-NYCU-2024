USE app;
CREATE TABLE messages (
  id INT NOT NULL AUTO_INCREMENT,
  message TEXT NOT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);
SHOW TABLES;
INSERT INTO messages (message) VALUES ('Hello, World!'), ('Hello, MySQL!');
SELECT * FROM messages;