
DROP TABLE IF EXISTS gasbooking;

CREATE TABLE gasbooking(id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_Account_Number VARCHAR(255), booking_Date DATE, location VARCHAR(255),
is_Delivered VARCHAR(1), email VARCHAR(255));