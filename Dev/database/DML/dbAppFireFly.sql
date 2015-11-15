CREATE DATABASE dbAppFireFly;
 
CREATE  TABLE IF NOT EXISTS `dbAppFireFly`.`Usuario` (
  `usuario_ID` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `sobrenome` VARCHAR(45) NOT NULL ,
  `sexo` VARCHAR (1) NOT NULL ,
  `dataNascimento` DATETIME NOT NULL ,
  `email` VARCHAR(70) NOT NULL ,
  `senha` VARCHAR(45) NOT NULL ,
  -- 15/11/2015 - INSERIDO - {{INICIO}}
  `termoUso` INT NOT NULL,
  `login` INT NOT NULL,
  -- 15/11/2015 - INSERIDO - {{FIM}}
  PRIMARY KEY (`usuario_ID`) );
   
  CREATE  TABLE IF NOT EXISTS `dbAppFireFly`.`Promotor` (
  `promotor_ID` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `sobrenome` VARCHAR(45) NOT NULL ,
  `sexo` CHAR NOT NULL ,
  `dataNascimento` DATETIME NOT NULL ,
  `email` VARCHAR(70) NOT NULL ,
  `senha` VARCHAR(45) NOT NULL ,
  `CNPJ` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`promotor_ID`) );
   
   
  CREATE  TABLE IF NOT EXISTS `dbAppFireFly`.`Estabelecimento` (
  `estabelecimento_ID` INT NOT NULL AUTO_INCREMENT ,
  `nomeEstabelecimento` VARCHAR(45) NOT NULL ,
  `descricaoEstabelecimento` VARCHAR(100) NOT NULL ,
  `telefoneEstabelecimento` VARCHAR(15) NOT NULL ,
  `telefoneEstabelecimento2` VARCHAR(15) NULL ,
  `fPromotor_ID` INT NOT NULL ,
  PRIMARY KEY (`estabelecimento_ID`, `fPromotor_ID`) ,
  INDEX `fk_Estabelecimento_Promotor` (`fPromotor_ID` ASC) ,
  CONSTRAINT `fk_Estabelecimento_Cliente1`
    FOREIGN KEY (`fPromotor_ID` )
    REFERENCES `dbAppFireFly`.`Promotor` (`promotor_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
     
CREATE  TABLE IF NOT EXISTS `dbAppFireFly`.`Evento` (
  `evento_ID` INT NOT NULL AUTO_INCREMENT ,
  `nomeEvento` VARCHAR(45) NOT NULL ,
  `descricaoEvento` VARCHAR(100) NOT NULL ,
  `idadePermitida` INT NOT NULL ,
  `horarioEvento` DATETIME NOT NULL ,
  `fEstabelecimento_ID` INT NOT NULL ,
  PRIMARY KEY (`evento_ID`, `fEstabelecimento_ID`) ,
  INDEX `fk_Evento_Estabelecimento` (`fEstabelecimento_ID` ASC) ,
  CONSTRAINT `fk_Evento_Estabelecimento`
    FOREIGN KEY (`fEstabelecimento_ID` )
    REFERENCES `dbAppFireFly`.`Estabelecimento` (`estabelecimento_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
 
CREATE  TABLE IF NOT EXISTS `dbAppFireFly`.`Estado` (
  `estado_ID` INT NOT NULL AUTO_INCREMENT ,
  `nomeEstado` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`estado_ID`) )
ENGINE = InnoDB;
 
CREATE  TABLE IF NOT EXISTS `dbAppFireFly`.`Cidade` (
  `cidade_ID` INT NOT NULL AUTO_INCREMENT ,
  `nomeCidade` VARCHAR(45) NOT NULL ,
  `fEstado_ID` INT NOT NULL ,
  PRIMARY KEY (`cidade_ID`, `fEstado_ID`) ,
  INDEX `fk_Cidade_Estado` (`fEstado_ID` ASC) ,
  CONSTRAINT `fk_Cidade_Estado`
    FOREIGN KEY (`fEstado_ID` )
    REFERENCES `dbAppFireFly`.`Estado` (`estado_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
 
 
CREATE  TABLE IF NOT EXISTS `dbAppFireFly`.`EnderecoEstabelecimento` (
  `enderecoEstabelecimento_ID` INT NOT NULL AUTO_INCREMENT ,
  `rua` VARCHAR(45) NOT NULL ,
  `bairro` VARCHAR(45) NOT NULL ,
  `numero` INT NOT NULL ,
  `fCidade_ID` INT NOT NULL ,
  `fEstabelecimento_ID` INT NOT NULL ,
  PRIMARY KEY (`enderecoEstabelecimento_ID`, `fCidade_ID`, `fEstabelecimento_ID`) ,
  INDEX `fk_EnderecoEstabelecimento_Cidade` (`fCidade_ID` ASC) ,
  INDEX `fk_EnderecoEstabelecimento_Estabelecimento1` (`fEstabelecimento_ID` ASC) ,
  CONSTRAINT `fk_EnderecoEstabelecimento_Cidade`
    FOREIGN KEY (`fCidade_ID` )
    REFERENCES `dbAppFireFly`.`Cidade` (`cidade_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EnderecoEstabelecimento_Estabelecimento1`
    FOREIGN KEY (`fEstabelecimento_ID` )
    REFERENCES `dbAppFireFly`.`Estabelecimento` (`estabelecimento_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);