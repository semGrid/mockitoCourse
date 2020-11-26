DROP TABLE IF EXISTS banks;

CREATE TABLE banks (
  code VARCHAR(4) PRIMARY KEY,
  currency VARCHAR(4) NOT NULL,
  name VARCHAR(250) NOT NULL,
  commission_percentage DECIMAL NOT NULL
);

INSERT INTO banks (code, currency, name, commission_percentage) VALUES
('HSBC', 'EUR', 'HSBC Holdings PLC', 3.25),
('CB', 'USD', 'Citibank', 2.50),
('MLM', 'PLN', 'Bank Millennium', 3.00),
('PRIV', 'UAH', 'PrivatBank', 2.40),
('VTB', 'RUB', 'VTB Bank', 2.00);