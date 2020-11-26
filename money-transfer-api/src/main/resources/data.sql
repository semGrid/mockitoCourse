DROP TABLE IF EXISTS transfer_transactions;

CREATE TABLE transfer_transactions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  transaction_date DATETIME NOT NULL,
  bank_of_recipient VARCHAR(4) NOT NULL,
  transaction_currency VARCHAR(4) NOT NULL,
  transaction_amount DECIMAL NOT NULL
);

INSERT INTO transfer_transactions (transaction_date, bank_of_recipient, transaction_currency, transaction_amount) VALUES
('2020-05-06 10:50:10', 'HSBC', 'USD', 150.50),
('2020-04-10 10:30:10', 'PRIV', 'EUR', 1400.0),
('2020-12-08 07:10:10', 'CB', 'USD', 800.0);