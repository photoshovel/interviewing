-- The 3-month period under test is 2022-01-01 through 2022-03-31.
-- Test case Customers
INSERT INTO customer (id,first_name,last_name,zip_code) VALUES
    (1, 'Jane', 'Doe', '90210'),
    (2, 'John', 'Doe', '70117'),
    (3, 'Paul', 'Smith', '55143'),
    (4, 'Tammy', 'Tanaka', '90210'),
    (5, 'Sam', 'Walton', '72712'),
    (6, 'Janet', 'Smith', '90211'),
    (7, 'Walter', 'Whale', '90210'),
    (8, 'Rita', 'Random', '98101');

-- Test case Transactions for Jane Doe, who doesn't spend enough to get any points.
INSERT INTO customer_transaction (id, customer_id, amount, tx_date) VALUES 
    (1, 1, 50, '2022-01-03 13:27:19'),
    (2, 1, 1, '2022-01-17 12:52:00'),
    (3, 1, 11, '2022-02-09 13:08:21'),
    (4, 1, 49, '2022-02-14 14:14:14'),
    (5, 1, 50, '2022-03-25 09:10:37');

-- Test case Transacations for John Doe, who spends enough to get points in 
-- every transaction.
INSERT INTO customer_transaction (id, customer_id, amount, tx_date) VALUES 
    (6, 2, 250, '2022-01-01 13:33:29'),
    (7, 2, 101, '2022-01-17 12:52:00'),
    (8, 2, 110, '2022-02-09 13:08:21'),
    (9, 2, 149, '2022-02-15 14:14:14'),
    (10, 2, 250, '2022-03-25 09:10:37'),
    (11, 2, 100, '2022-03-31 09:10:17'),
    (12, 2, 175, '2022-04-02 03:00:00'),
    (13, 2, 100, '2021-12-31 09:00:01'),
    (14, 2, 175, '2021-11-28 09:00:01'),
    (15, 2, 200, '2022-05-28 09:00:01');

-- Test case Transacations for Paul Smith, who doesn't spend any money 
-- in this 3 month period of time, only before and after.

-- LACK OF test case Transactions for Tammy Tanaka, who hasn't every spent any 
-- money with this business for all of time.

-- Test case Transactions for Sam Walton, who has only spent money before 
-- the 3 month period of time.

-- Test case Transactions for Janet Smith, who has only spent money after 
-- the 3 month period of time.

-- Test case Transactions for Walter Whale, who has spends enough to get points 
-- in ALL transactions.

-- Test case Trasactions for Rita Random, who spends enough to get points in 
-- in SOME transactions.
