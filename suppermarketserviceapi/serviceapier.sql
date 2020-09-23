SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX fk_cashBook_branch1_idx ON cashbook;
DROP INDEX fk_cashBook_purchase1_idx ON cashbook;
DROP INDEX fk_cashBook_saleInvoice1_idx ON cashbook;
DROP INDEX fk_chequeBook_branch1_idx ON chequebook;
DROP INDEX fk_chequeBook_purchase1_idx ON chequebook;
DROP INDEX fk_chequeBook_saleInvoice1_idx ON chequebook;
DROP INDEX fk_customer_branch1_idx ON customer;
DROP INDEX fk_customer_customerCreditAccount1_idx ON customer;
DROP INDEX fk_customerCreditInvoice_customerCreditAccount1_idx ON customercreditinvoice;
DROP INDEX fk_customerPayment_customerCreditInvoice1_idx ON customerpayment;
DROP INDEX fk_item_itemGroup1_idx ON item;
DROP INDEX fk_item_itemSubGroup1_idx ON item;
DROP INDEX fk_purchase_branch1_idx ON purchase;
DROP INDEX fk_purchase_supplier1_idx ON purchase;
DROP INDEX fk_purchase_user1_idx ON purchase;
DROP INDEX fk_purchaseItem_purchase1_idx ON purchaseitem;
DROP INDEX fk_saleInvoice_branch1_idx ON saleinvoice;
DROP INDEX fk_saleInvoice_customer1_idx ON saleinvoice;
DROP INDEX fk_saleInvoice_user1_idx ON saleinvoice;
DROP INDEX fk_saleItem_saleInvoice1_idx ON saleitem;
DROP INDEX fk_storeInfor_branch1_idx ON storeinfor;
DROP INDEX fk_storeInfor_item1_idx ON storeinfor;
DROP INDEX fk_supplier_branch1_idx ON supplier;
DROP INDEX fk_supplier_supplierCreditAccount1_idx ON supplier;
DROP INDEX fk_supplierCreditInvoice_supplierCreditAccount1_idx ON suppliercreditinvoice;
DROP INDEX fk_supplierPayment_supplierCreditInvoice1_idx ON supplierpayment;
DROP INDEX fk_user_branch_idx ON user;



/* Drop Tables */

DROP TABLE IF EXISTS bank;
DROP TABLE IF EXISTS cashbook;
DROP TABLE IF EXISTS chequebook;
DROP TABLE IF EXISTS saleitem;
DROP TABLE IF EXISTS saleinvoice;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS purchaseitem;
DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS storeinfor;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS branch;
DROP TABLE IF EXISTS customerpayment;
DROP TABLE IF EXISTS customercreditinvoice;
DROP TABLE IF EXISTS customercreditaccount;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS itemgroup;
DROP TABLE IF EXISTS itemsubgroup;
DROP TABLE IF EXISTS supplierpayment;
DROP TABLE IF EXISTS suppliercreditinvoice;
DROP TABLE IF EXISTS suppliercreditaccount;




/* Create Tables */

CREATE TABLE bank
(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(45) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE branch
(
	id int NOT NULL AUTO_INCREMENT,
	branchCode varchar(20) NOT NULL,
	branchName varchar(100) NOT NULL,
	branchAddress varchar(250),
	branchContact varchar(40) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (branchCode)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE cashbook
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	transactionDate date NOT NULL,
	description varchar(50) NOT NULL,
	bookType varchar(10) NOT NULL,
	amount decimal(10,2) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	branchId int NOT NULL,
	purchaseId bigint(20),
	saleInvoiceId bigint(20),
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE chequebook
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	transactionDate date NOT NULL,
	bookType varchar(10) NOT NULL,
	bookDescription varchar(50) NOT NULL,
	chequeNo varchar(10) NOT NULL,
	chequeAmount decimal(10,2) NOT NULL,
	chequeStatus varchar(20) NOT NULL,
	description varchar(250),
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	branchId int NOT NULL,
	purchaseId bigint(20),
	saleInvoiceId bigint(20),
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE customer
(
	id bigint(20) NOT NULL,
	code varchar(50),
	name varchar(100) NOT NULL,
	address varchar(150),
	contact varchar(40),
	description varchar(250),
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	branchId int NOT NULL,
	customerCreditAccountId bigint(20) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE customercreditaccount
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	totalCredit decimal(10,2) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE customercreditinvoice
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	creditAmount decimal(10,2) NOT NULL,
	paidAmount decimal(10,2) NOT NULL,
	balanceAmount decimal(10,2) NOT NULL,
	customerCreditAccountId bigint(20) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE customerpayment
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	payDate date NOT NULL,
	payMethod varchar(20) NOT NULL,
	amount decimal(10,2) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	customerCreditInvoiceId bigint(20) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (payMethod)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE item
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	code varchar(50) NOT NULL,
	barcode varchar(50) NOT NULL,
	name varchar(150) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	itemGroupId int NOT NULL,
	itemSubGroupId int NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE itemgroup
(
	id int NOT NULL AUTO_INCREMENT,
	groupName varchar(100) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (groupName)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE itemsubgroup
(
	id int NOT NULL AUTO_INCREMENT,
	subGroupName varchar(50) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (subGroupName)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE purchase
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	invoiceNo varchar(50),
	purchaseDate date NOT NULL,
	invoiceType varchar(50) NOT NULL,
	invoiceAmount decimal(10,2) NOT NULL,
	purchaseDiscount decimal(10,2) NOT NULL,
	discountPercent double NOT NULL,
	netAmount decimal(10,2) NOT NULL,
	cashPayAmount decimal(10,2),
	chequePayAmount decimal(10,2),
	creditAmount decimal(10,2) NOT NULL,
	totalPurchaseItem int,
	recordState varchar(20) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	branchId int NOT NULL,
	userId int NOT NULL,
	supplierId bigint(20) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (invoiceNo)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE purchaseitem
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	cost decimal(10,2) NOT NULL,
	discount decimal(10,2) NOT NULL,
	quantity decimal(10,2) NOT NULL,
	freeQuantity decimal(10,2) NOT NULL,
	availableQuantity decimal(10,2) NOT NULL,
	amount decimal(10,2) NOT NULL,
	wholesalePrice decimal(10,2) NOT NULL,
	retailPrice decimal(10,2) NOT NULL,
	reorderLevel decimal(10,2),
	purchaseDate date NOT NULL,
	manufactureDate date,
	expireDate date,
	purchaseType varchar(20) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	purchaseId bigint(20) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE saleinvoice
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	invoiceNo varchar(50),
	invoiceDate date NOT NULL,
	saleType varchar(20) NOT NULL,
	totalCost decimal(10,2) NOT NULL,
	totalAmount decimal(10,2) NOT NULL,
	totalDiscount decimal(10,2),
	invoiceDiscount decimal(10,2),
	netAmount decimal(10,2) NOT NULL,
	paidAmount decimal(10,2) NOT NULL,
	balanceAmount decimal(10,2),
	creditAmount decimal(10,2),
	payMethod varchar(20) NOT NULL,
	totalProfit decimal(10,2) NOT NULL,
	invoiceType varchar(20) NOT NULL,
	invoiceState varchar(20) NOT NULL,
	recordState varchar(20) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	branchId int NOT NULL,
	userId int NOT NULL,
	customerId bigint(20),
	PRIMARY KEY (id),
	UNIQUE (invoiceNo)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE saleitem
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	issueNo int NOT NULL,
	saleDate date NOT NULL,
	cost decimal(10,2) NOT NULL,
	salePrice decimal(10,2) NOT NULL,
	discount decimal(10,2),
	quantity decimal(10,2) NOT NULL,
	amount decimal(10,2) NOT NULL,
	netAmount decimal(10,2) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	saleInvoiceId bigint(20) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE storeinfor
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	cost decimal(10,2),
	wholesalePrice decimal(10,2),
	retailPrice decimal(10,2),
	discount decimal(10,2),
	availableQuantity decimal(10,2),
	reorderLevel decimal(10,2),
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	itemId bigint(20) NOT NULL,
	branchId int NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE supplier
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	code varchar(50) NOT NULL,
	name varchar(100) NOT NULL,
	address varchar(150),
	contact varchar(40),
	description varchar(250),
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	branchId int NOT NULL,
	supplierCreditAccountId bigint(20) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE suppliercreditaccount
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	totalCredit decimal(10,2) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE suppliercreditinvoice
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	creditAmount decimal(10,2) NOT NULL,
	paidAmount decimal(10,2) NOT NULL,
	balanceAmount decimal(10,2) NOT NULL,
	supplierCreditAccountId bigint(20) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE supplierpayment
(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	payDate date NOT NULL,
	payMethod varchar(20) NOT NULL,
	amonut decimal(10,2) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	supplierCreditInvoiceId bigint(20) NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


CREATE TABLE user
(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	userRole varchar(20) NOT NULL,
	password varchar(50) NOT NULL,
	createdAt datetime NOT NULL,
	updatedAt datetime NOT NULL,
	branchId int NOT NULL,
	PRIMARY KEY (id)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;



/* Create Foreign Keys */

ALTER TABLE cashbook
	ADD CONSTRAINT fk_cashBook_branch1 FOREIGN KEY (branchId)
	REFERENCES branch (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE chequebook
	ADD CONSTRAINT fk_chequeBook_branch1 FOREIGN KEY (branchId)
	REFERENCES branch (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE customer
	ADD CONSTRAINT fk_customer_branch1 FOREIGN KEY (branchId)
	REFERENCES branch (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE purchase
	ADD CONSTRAINT fk_purchase_branch1 FOREIGN KEY (branchId)
	REFERENCES branch (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE saleinvoice
	ADD CONSTRAINT fk_saleInvoice_branch1 FOREIGN KEY (branchId)
	REFERENCES branch (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE storeinfor
	ADD CONSTRAINT fk_storeInfor_branch1 FOREIGN KEY (branchId)
	REFERENCES branch (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE supplier
	ADD CONSTRAINT fk_supplier_branch1 FOREIGN KEY (branchId)
	REFERENCES branch (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE user
	ADD CONSTRAINT fk_user_branch FOREIGN KEY (branchId)
	REFERENCES branch (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE saleinvoice
	ADD CONSTRAINT fk_saleInvoice_customer1 FOREIGN KEY (customerId)
	REFERENCES customer (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE customer
	ADD CONSTRAINT fk_customer_customerCreditAccount1 FOREIGN KEY (customerCreditAccountId)
	REFERENCES customercreditaccount (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE customercreditinvoice
	ADD CONSTRAINT fk_customerCreditInvoice_customerCreditAccount1 FOREIGN KEY (customerCreditAccountId)
	REFERENCES customercreditaccount (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE customerpayment
	ADD CONSTRAINT fk_customerPayment_customerCreditInvoice1 FOREIGN KEY (customerCreditInvoiceId)
	REFERENCES customercreditinvoice (id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE storeinfor
	ADD CONSTRAINT fk_storeInfor_item1 FOREIGN KEY (itemId)
	REFERENCES item (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE item
	ADD CONSTRAINT fk_item_itemGroup1 FOREIGN KEY (itemGroupId)
	REFERENCES itemgroup (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE item
	ADD CONSTRAINT fk_item_itemSubGroup1 FOREIGN KEY (itemSubGroupId)
	REFERENCES itemsubgroup (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE cashbook
	ADD CONSTRAINT fk_cashBook_purchase1 FOREIGN KEY (purchaseId)
	REFERENCES purchase (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE chequebook
	ADD CONSTRAINT fk_chequeBook_purchase1 FOREIGN KEY (purchaseId)
	REFERENCES purchase (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE purchaseitem
	ADD CONSTRAINT fk_purchaseItem_purchase1 FOREIGN KEY (purchaseId)
	REFERENCES purchase (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE cashbook
	ADD CONSTRAINT fk_cashBook_saleInvoice1 FOREIGN KEY (saleInvoiceId)
	REFERENCES saleinvoice (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE chequebook
	ADD CONSTRAINT fk_chequeBook_saleInvoice1 FOREIGN KEY (saleInvoiceId)
	REFERENCES saleinvoice (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE saleitem
	ADD CONSTRAINT fk_saleItem_saleInvoice1 FOREIGN KEY (saleInvoiceId)
	REFERENCES saleinvoice (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE purchase
	ADD CONSTRAINT fk_purchase_supplier1 FOREIGN KEY (supplierId)
	REFERENCES supplier (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE supplier
	ADD CONSTRAINT fk_supplier_supplierCreditAccount1 FOREIGN KEY (supplierCreditAccountId)
	REFERENCES suppliercreditaccount (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE suppliercreditinvoice
	ADD CONSTRAINT fk_supplierCreditInvoice_supplierCreditAccount1 FOREIGN KEY (supplierCreditAccountId)
	REFERENCES suppliercreditaccount (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE supplierpayment
	ADD CONSTRAINT fk_supplierPayment_supplierCreditInvoice1 FOREIGN KEY (supplierCreditInvoiceId)
	REFERENCES suppliercreditinvoice (id)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE purchase
	ADD CONSTRAINT fk_purchase_user1 FOREIGN KEY (userId)
	REFERENCES user (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE saleinvoice
	ADD CONSTRAINT fk_saleInvoice_user1 FOREIGN KEY (userId)
	REFERENCES user (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;



/* Create Indexes */

CREATE INDEX fk_cashBook_branch1_idx USING BTREE ON cashbook (branchId ASC);
CREATE INDEX fk_cashBook_purchase1_idx USING BTREE ON cashbook (purchaseId ASC);
CREATE INDEX fk_cashBook_saleInvoice1_idx USING BTREE ON cashbook (saleInvoiceId ASC);
CREATE INDEX fk_chequeBook_branch1_idx USING BTREE ON chequebook (branchId ASC);
CREATE INDEX fk_chequeBook_purchase1_idx USING BTREE ON chequebook (purchaseId ASC);
CREATE INDEX fk_chequeBook_saleInvoice1_idx USING BTREE ON chequebook (saleInvoiceId ASC);
CREATE INDEX fk_customer_branch1_idx USING BTREE ON customer (branchId ASC);
CREATE INDEX fk_customer_customerCreditAccount1_idx USING BTREE ON customer (customerCreditAccountId ASC);
CREATE INDEX fk_customerCreditInvoice_customerCreditAccount1_idx USING BTREE ON customercreditinvoice (customerCreditAccountId ASC);
CREATE INDEX fk_customerPayment_customerCreditInvoice1_idx USING BTREE ON customerpayment (customerCreditInvoiceId ASC);
CREATE INDEX fk_item_itemGroup1_idx USING BTREE ON item (itemGroupId ASC);
CREATE INDEX fk_item_itemSubGroup1_idx USING BTREE ON item (itemSubGroupId ASC);
CREATE INDEX fk_purchase_branch1_idx USING BTREE ON purchase (branchId ASC);
CREATE INDEX fk_purchase_supplier1_idx USING BTREE ON purchase (supplierId ASC);
CREATE INDEX fk_purchase_user1_idx USING BTREE ON purchase (userId ASC);
CREATE INDEX fk_purchaseItem_purchase1_idx USING BTREE ON purchaseitem (purchaseId ASC);
CREATE INDEX fk_saleInvoice_branch1_idx USING BTREE ON saleinvoice (branchId ASC);
CREATE INDEX fk_saleInvoice_customer1_idx USING BTREE ON saleinvoice (customerId ASC);
CREATE INDEX fk_saleInvoice_user1_idx USING BTREE ON saleinvoice (userId ASC);
CREATE INDEX fk_saleItem_saleInvoice1_idx USING BTREE ON saleitem (saleInvoiceId ASC);
CREATE INDEX fk_storeInfor_branch1_idx USING BTREE ON storeinfor (branchId ASC);
CREATE INDEX fk_storeInfor_item1_idx USING BTREE ON storeinfor (itemId ASC);
CREATE INDEX fk_supplier_branch1_idx USING BTREE ON supplier (branchId ASC);
CREATE INDEX fk_supplier_supplierCreditAccount1_idx USING BTREE ON supplier (supplierCreditAccountId ASC);
CREATE INDEX fk_supplierCreditInvoice_supplierCreditAccount1_idx USING BTREE ON suppliercreditinvoice (supplierCreditAccountId ASC);
CREATE INDEX fk_supplierPayment_supplierCreditInvoice1_idx USING BTREE ON supplierpayment (supplierCreditInvoiceId ASC);
CREATE INDEX fk_user_branch_idx USING BTREE ON user (branchId ASC);



