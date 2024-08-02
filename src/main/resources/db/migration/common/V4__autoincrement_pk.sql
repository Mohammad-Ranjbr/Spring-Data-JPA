-- This command changes the id column to BIGINT type with AUTO_INCREMENT property.
-- This feature causes the value of this column to be generated automatically and incrementally by the database.
ALTER TABLE book MODIFY COLUMN id BIGINT AUTO_INCREMENT;
ALTER TABLE author MODIFY COLUMN id BIGINT AUTO_INCREMENT;
