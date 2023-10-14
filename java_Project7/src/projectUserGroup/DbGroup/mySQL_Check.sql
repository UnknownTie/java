show members;

ALTER TABLE `members` 
ADD COLUMN `members_genderMan` BLOB NOT NULL DEFAULT true;

ALTER TABLE `javaproject7`.`members` 
ADD COLUMN `members_genderMan` TINYINT(4) NOT NULL DEFAULT true AFTER `members_name`;

ALTER TABLE `javaproject7`.`members` 
DROP COLUMN `members_genderMan`;

drop table insa;

desc members;

insert into insa (name) values ('D1');

select * from members;
