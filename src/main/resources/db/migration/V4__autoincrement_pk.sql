# This command changes the id column to BIGINT type with AUTO_INCREMENT property.
# This feature causes the value of this column to be generated automatically and incrementally by the database.
alter table book change id id BIGINT auto_increment;
alter table author change id id BIGINT auto_increment;