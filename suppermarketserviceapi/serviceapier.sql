SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS sale_Item;
DROP TABLE IF EXISTS sale_Invoice;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS purchase_Item;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS item_Group;
DROP TABLE IF EXISTS item_Sub_Group;
DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS user;




/* Create Tables */

CREATE TABLE customer
(
	customer_Id bigint(20) NOT NULL AUTO_INCREMENT,
	customer_Code varchar(50),
	customer_Name varchar(100) NOT NULL,
	customer_Address varchar(150),
	customer_Contact varchar(40),
	description varchar(250),
	on_Update datetime NOT NULL,
	PRIMARY KEY (customer_Id),
	UNIQUE (customer_Id)
);


CREATE TABLE item
(
	item_Id bigint(20) NOT NULL AUTO_INCREMENT,
	item_Code varchar(50) NOT NULL,
	item_Barcode varchar(50) NOT NULL,
	item_Name varchar(150) NOT NULL,
	group_Name varchar(100) NOT NULL,
	sub_Group_Name varchar(100) NOT NULL,
	item_Cost decimal(10,2),
	item_Wholesale_Price decimal(10,2),
	item_Retail_Price decimal(10,2),
	item_discount decimal(10,2),
	available_Quantity decimal(10,2),
	reorder_Level decimal(10,2),
	record_State varchar(20) NOT NULL,
	on_Updated datetime,
	PRIMARY KEY (item_Id),
	UNIQUE (item_Id),
	UNIQUE (group_Name),
	UNIQUE (sub_Group_Name)
);


CREATE TABLE item_Group
(
	group_Name varchar(100) NOT NULL,
	PRIMARY KEY (group_Name),
	UNIQUE (group_Name)
);


CREATE TABLE item_Sub_Group
(
	sub_Group_Name varchar(100) NOT NULL,
	PRIMARY KEY (sub_Group_Name),
	UNIQUE (sub_Group_Name)
);


CREATE TABLE purchase
(
	purchase_Id bigint(20) NOT NULL AUTO_INCREMENT,
	supplier_Id bigint(20) NOT NULL,
	invoice_No varchar(50),
	purchase_Date date NOT NULL,
	invoice_Type varchar(50) NOT NULL,
	invoice_Amount decimal(10,2) NOT NULL,
	purchase_Discount decimal(10,2) NOT NULL,
	discount_Percent double NOT NULL,
	net_Amount decimal(10,2) NOT NULL,
	cash_Pay_Amount decimal(10,2),
	cheque_Pay_Amount decimal(10,2),
	credit_Amount decimal(10,2) NOT NULL,
	purchase_Day int NOT NULL,
	purchase_Month int NOT NULL,
	purchase_Year int NOT NULL,
	total_Purchase_Item int,
	record_State varchar(20) NOT NULL,
	on_Update datetime NOT NULL,
	user_Id int NOT NULL,
	PRIMARY KEY (purchase_Id),
	UNIQUE (purchase_Id),
	UNIQUE (supplier_Id),
	UNIQUE (invoice_No),
	UNIQUE (user_Id)
);


CREATE TABLE purchase_Item
(
	purchase_Item_Id bigint(20) NOT NULL AUTO_INCREMENT,
	purchase_Id bigint(20) NOT NULL,
	item_Id bigint(20) NOT NULL,
	cost decimal(10,2) NOT NULL,
	discount decimal(10,2) NOT NULL,
	quantity decimal(10,2) NOT NULL,
	free_Quantity decimal(10,2) NOT NULL,
	available_Quantity decimal(10,2) NOT NULL,
	amount decimal(10,2) NOT NULL,
	wholesale_Price decimal(10,2) NOT NULL,
	retail_Price decimal(10,2) NOT NULL,
	reorder_Level decimal(10,2),
	purchase_Date date NOT NULL,
	manufacture_Date date,
	expire_Date date,
	purchase_Type varchar(20) NOT NULL,
	on_Update date NOT NULL,
	PRIMARY KEY (purchase_Item_Id),
	UNIQUE (purchase_Item_Id),
	UNIQUE (purchase_Id),
	UNIQUE (item_Id)
);


CREATE TABLE sale_Invoice
(
	sale_Id bigint(20) NOT NULL AUTO_INCREMENT,
	invoice_No varchar(50),
	invoice_Date date NOT NULL,
	total_Cost decimal(10,2) NOT NULL,
	total_Amount decimal(10,2) NOT NULL,
	total_Discount decimal(10,2),
	invoice_Discount decimal(10,2),
	net_Amount decimal(10,2) NOT NULL,
	recieved_Cash decimal(10,2),
	recieved_Cheque decimal(10,2),
	paid_Amount decimal(10,2) NOT NULL,
	card_Pay decimal(10,2),
	balance_Amount decimal(10,2),
	credit_Amount decimal(10,2),
	total_profit decimal(10,2) NOT NULL,
	invoice_Type varchar(20) NOT NULL,
	sale_Day int NOT NULL,
	sale_Month int NOT NULL,
	sale_Year int NOT NULL,
	record_State varchar(20) NOT NULL,
	customer_Id bigint(20),
	user_Id int NOT NULL,
	on_Update datetime NOT NULL,
	PRIMARY KEY (sale_Id),
	UNIQUE (sale_Id),
	UNIQUE (invoice_No),
	UNIQUE (user_Id)
);


CREATE TABLE sale_Item
(
	sale_Item_Id bigint(20) NOT NULL AUTO_INCREMENT,
	issue_No int NOT NULL,
	sale_Date date NOT NULL,
	sale_Id bigint(20) NOT NULL,
	item_Id bigint(20) NOT NULL,
	purchase_Item_Id bigint(20),
	cost decimal(10,2) NOT NULL,
	sale_Price decimal(10,2) NOT NULL,
	discount decimal(10,2),
	quantity decimal(10,2) NOT NULL,
	amount decimal(10,2) NOT NULL,
	net_Amount decimal(10,2) NOT NULL,
	sale_Day int NOT NULL,
	sale_Month int NOT NULL,
	sale_Year int NOT NULL,
	user_Id int NOT NULL,
	PRIMARY KEY (sale_Item_Id),
	UNIQUE (sale_Item_Id),
	UNIQUE (sale_Id),
	UNIQUE (item_Id),
	UNIQUE (user_Id)
);


CREATE TABLE supplier
(
	supplier_Id bigint(20) NOT NULL AUTO_INCREMENT,
	suplier_Code varchar(50),
	supplier_Name varchar(100) NOT NULL,
	supplier_Address varchar(150),
	supplier_Contact varchar(40),
	description varchar(250),
	on_Update datetime NOT NULL,
	PRIMARY KEY (supplier_Id),
	UNIQUE (supplier_Id)
);


CREATE TABLE user
(
	user_Id int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	password varchar(50) NOT NULL,
	PRIMARY KEY (user_Id),
	UNIQUE (user_Id)
);



/* Create Foreign Keys */

ALTER TABLE sale_Invoice
	ADD FOREIGN KEY (customer_Id)
	REFERENCES customer (customer_Id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE purchase_Item
	ADD FOREIGN KEY (item_Id)
	REFERENCES item (item_Id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE sale_Item
	ADD FOREIGN KEY (item_Id)
	REFERENCES item (item_Id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE item
	ADD FOREIGN KEY (group_Name)
	REFERENCES item_Group (group_Name)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE item
	ADD FOREIGN KEY (sub_Group_Name)
	REFERENCES item_Sub_Group (sub_Group_Name)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE purchase_Item
	ADD FOREIGN KEY (purchase_Id)
	REFERENCES purchase (purchase_Id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE sale_Item
	ADD FOREIGN KEY (purchase_Item_Id)
	REFERENCES purchase_Item (purchase_Item_Id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE sale_Item
	ADD FOREIGN KEY (sale_Id)
	REFERENCES sale_Invoice (sale_Id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE purchase
	ADD FOREIGN KEY (supplier_Id)
	REFERENCES supplier (supplier_Id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE purchase
	ADD FOREIGN KEY (user_Id)
	REFERENCES user (user_Id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE sale_Invoice
	ADD FOREIGN KEY (user_Id)
	REFERENCES user (user_Id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE sale_Item
	ADD FOREIGN KEY (user_Id)
	REFERENCES user (user_Id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;



