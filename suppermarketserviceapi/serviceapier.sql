SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS item_Group;
DROP TABLE IF EXISTS item_Sub_Group;
DROP TABLE IF EXISTS user;




/* Create Tables */

CREATE TABLE item
(
	id bigint NOT NULL AUTO_INCREMENT,
	item_Code varchar(50) NOT NULL,
	item_Barcode varchar(50) NOT NULL,
	item_Name varchar(150) NOT NULL,
	group_Name varchar(100),
	sub_Group_Name varchar(100),
	item_Cost decimal(18,2),
	PRIMARY KEY (id),
	UNIQUE (id),
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


CREATE TABLE user
(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	password varchar(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id)
);



/* Create Foreign Keys */

ALTER TABLE item
	ADD FOREIGN KEY (group_Name)
	REFERENCES item_Group (group_Name)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE item
	ADD FOREIGN KEY (sub_Group_Name)
	REFERENCES item_Sub_Group (sub_Group_Name)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



