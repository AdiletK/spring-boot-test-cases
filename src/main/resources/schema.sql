CREATE TABLE customer_contact(
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      first_name VARCHAR(64),
                      last_name VARCHAR(64),
                      email VARCHAR(64),
                      address1 VARCHAR(64),
                      address2 VARCHAR(64),
                      city VARCHAR(64),
                      state VARCHAR(64),
                      zipcode VARCHAR(64)
);

CREATE TABLE delivery_address(
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 line1 VARCHAR(64),
                                 line2 VARCHAR(64),
                                 city VARCHAR(64),
                                 state VARCHAR(64),
                                 zipCode VARCHAR(64)
);

