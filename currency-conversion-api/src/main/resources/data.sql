DROP TABLE IF EXISTS exchange_rates;

CREATE TABLE exchange_rates (
  from_currency VARCHAR(4) NOT NULL,
  to_currency VARCHAR(4) NOT NULL,
  exchange_rate DECIMAL NOT NULL,
  PRIMARY KEY (from_currency, to_currency)
);

INSERT INTO exchange_rates (from_currency, to_currency, exchange_rate) VALUES
('EUR', 'USD', 1.19),
('EUR', 'RUB', 90.63),
('EUR', 'PLN', 4.47),
('EUR', 'UAH', 33.63),
('USD', 'EUR', 0.84),
('USD', 'RUB', 76.21),
('USD', 'PLN', 3.77),
('USD', 'UAH', 28.36),
('PLN', 'EUR', 0.22),
('PLN', 'RUB', 20.21),
('PLN', 'USD', 0.27),
('PLN', 'UAH', 7.52),
('UAH', 'EUR', 0.03),
('UAH', 'RUB', 2.69),
('UAH', 'USD', 0.035),
('UAH', 'PLN', 0.13),
('RUB', 'EUR', 0.0011),
('RUB', 'UAH', 0.37),
('RUB', 'USD', 0.0013),
('RUB', 'PLN', 0.005);