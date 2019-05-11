DROP
	TABLE
		tab_account IF EXISTS

DROP
	TABLE
		tab_address IF EXISTS

DROP
	TABLE
		tab_agency IF EXISTS

DROP
	TABLE
		tab_checking_account IF EXISTS

DROP
	TABLE
		tab_savings_account IF EXISTS

DROP
	TABLE
		tab_user IF EXISTS

DROP
	SEQUENCE IF EXISTS hibernate_sequence

CREATE
	SEQUENCE hibernate_sequence
START WITH
	1 INCREMENT BY 1

CREATE
	TABLE
		tab_account (id BIGINT NOT NULL,
		agency_id BIGINT,
		checking_account_id BIGINT,
		savings_account_id BIGINT,
		PRIMARY KEY (id))

CREATE
	TABLE
		tab_address (id BIGINT NOT NULL,
		neighborhood VARCHAR(255),
		cep VARCHAR(255),
		locality VARCHAR(255),
		public_place VARCHAR(255),
		uf VARCHAR(255),
		PRIMARY KEY (id))

CREATE
	TABLE
		tab_agency (id BIGINT NOT NULL,
		address_id BIGINT,
		PRIMARY KEY (id))

CREATE
	TABLE
		tab_checking_account (id BIGINT NOT NULL,
		saudo DOUBLE,
		PRIMARY KEY (id))

CREATE
	TABLE
		tab_savings_account (id BIGINT NOT NULL,
		saudo DOUBLE,
		PRIMARY KEY (id))

CREATE
	TABLE
		tab_user (id BIGINT NOT NULL,
		cpf VARCHAR(255),
		divida_ativa BOOLEAN,
		email VARCHAR(255),
		name VARCHAR(255),
		cell VARCHAR(255),
		account_id BIGINT,
		address_id BIGINT,
		PRIMARY KEY (id))

ALTER TABLE
	tab_account ADD CONSTRAINT FKj6yvrb1uwyf4m3kr5ll9caenn FOREIGN KEY (agency_id) REFERENCES tab_agency

ALTER TABLE
	tab_account ADD CONSTRAINT FKhsytonkmxvpl42c2c2t48c1y8 FOREIGN KEY (checking_account_id) REFERENCES tab_checking_account

ALTER TABLE
	tab_account ADD CONSTRAINT FKtki7uvevprf8n5a2sswi5iibb FOREIGN KEY (savings_account_id) REFERENCES tab_savings_account

ALTER TABLE
	tab_agency ADD CONSTRAINT FK7clv6jm567q4uaecxq9p8vtl4 FOREIGN KEY (address_id) REFERENCES tab_address

ALTER TABLE
	tab_user ADD CONSTRAINT FKhm74onhoabkcsalf3qj7cwyjc FOREIGN KEY (account_id) REFERENCES tab_account

ALTER TABLE
	tab_user ADD CONSTRAINT FKcj3u00j6bg2610ci0bi9swyvq FOREIGN KEY (address_id) REFERENCES tab_address