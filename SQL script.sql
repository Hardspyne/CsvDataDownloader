CREATE SCHEMA `test_task` DEFAULT CHARACTER SET utf8 ;

DROP TABLE IF EXISTS `test_task`.`processed_data`;
CREATE TABLE `test_task`.`processed_data` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `value` FLOAT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
