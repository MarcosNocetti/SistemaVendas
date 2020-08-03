-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 15-Jul-2020 às 23:40
-- Versão do servidor: 10.4.13-MariaDB
-- versão do PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
CREATE DATABASE  IF NOT EXISTS dbsistemavenda;

USE dbsistemavenda;
--
-- Banco de dados: `dbsistemavenda`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcliente`
--

CREATE TABLE `tbcliente` (
  `Codigo` int(11) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `DataNascimento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcompra`
--

CREATE TABLE `tbcompra` (
  `Codigo` int(11) NOT NULL,
  `CodigoFornecedor` int(11) NOT NULL,
  `DataCompra` date NOT NULL,
  `ValorTotal` decimal(10,2) NOT NULL,
  `Situacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbdespesas`
--

CREATE TABLE `tbdespesas` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `datapagamento` date NOT NULL,
  `valor` double NOT NULL,
  `situacao` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbdespesas`
--

INSERT INTO `tbdespesas` (`codigo`, `nome`, `datapagamento`, `valor`, `situacao`) VALUES
(1, 'salario ronaldinho', '2020-07-15', 1000, '2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbfornecedor`
--

CREATE TABLE `tbfornecedor` (
  `Codigo` int(11) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `CNPJ` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbfuncionario`
--

CREATE TABLE `tbfuncionario` (
  `idfuncionario` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `dataNascimento` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `nivel` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbfuncionario`
--

INSERT INTO `tbfuncionario` (`idfuncionario`, `nome`, `cpf`, `dataNascimento`, `senha`, `nivel`) VALUES
(1, 'admin', '444.444.444-44', '25/09/2000', 'admin', '2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbitemcompra`
--

CREATE TABLE `tbitemcompra` (
  `Codigo` int(11) NOT NULL,
  `CodigoProduto` int(11) NOT NULL,
  `CodigoCompra` int(11) NOT NULL,
  `Quantidade` int(11) NOT NULL,
  `ValorUnitario` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbitemvenda`
--

CREATE TABLE `tbitemvenda` (
  `Codigo` int(11) NOT NULL,
  `CodigoProduto` int(11) NOT NULL,
  `CodigoVenda` int(11) NOT NULL,
  `Quantidade` int(11) NOT NULL,
  `ValorUnitario` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbproduto`
--

CREATE TABLE `tbproduto` (
  `Codigo` int(11) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `PrecoCompra` decimal(10,2) NOT NULL,
  `PrecoVenda` decimal(10,2) NOT NULL,
  `QuantidadeEstoque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbvenda`
--

CREATE TABLE `tbvenda` (
  `Codigo` int(11) NOT NULL,
  `CodigoCliente` int(11) NOT NULL,
  `DataVenda` date NOT NULL,
  `ValorTotal` decimal(10,2) NOT NULL,
  `Situacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`Codigo`);

--
-- Índices para tabela `tbcompra`
--
ALTER TABLE `tbcompra`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `FK_CodigoFornecedor_idx` (`CodigoFornecedor`);

--
-- Índices para tabela `tbdespesas`
--
ALTER TABLE `tbdespesas`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `tbfornecedor`
--
ALTER TABLE `tbfornecedor`
  ADD PRIMARY KEY (`Codigo`);

--
-- Índices para tabela `tbfuncionario`
--
ALTER TABLE `tbfuncionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- Índices para tabela `tbitemcompra`
--
ALTER TABLE `tbitemcompra`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `FK_CodigoCompra_idx2` (`CodigoCompra`),
  ADD KEY `FK_CodigoProduto_idx2` (`CodigoProduto`);

--
-- Índices para tabela `tbitemvenda`
--
ALTER TABLE `tbitemvenda`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `FK_CodigoVenda_idx` (`CodigoVenda`),
  ADD KEY `FK_CodigoProduto_idx` (`CodigoProduto`);

--
-- Índices para tabela `tbproduto`
--
ALTER TABLE `tbproduto`
  ADD PRIMARY KEY (`Codigo`);

--
-- Índices para tabela `tbvenda`
--
ALTER TABLE `tbvenda`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `FK_CodigoCliente_idx` (`CodigoCliente`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbcliente`
--
ALTER TABLE `tbcliente`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbcompra`
--
ALTER TABLE `tbcompra`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbdespesas`
--
ALTER TABLE `tbdespesas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tbfornecedor`
--
ALTER TABLE `tbfornecedor`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbfuncionario`
--
ALTER TABLE `tbfuncionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tbitemcompra`
--
ALTER TABLE `tbitemcompra`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbitemvenda`
--
ALTER TABLE `tbitemvenda`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbproduto`
--
ALTER TABLE `tbproduto`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbvenda`
--
ALTER TABLE `tbvenda`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tbcompra`
--
ALTER TABLE `tbcompra`
  ADD CONSTRAINT `FK_CodigoFornecedor` FOREIGN KEY (`CodigoFornecedor`) REFERENCES `tbfornecedor` (`Codigo`);

--
-- Limitadores para a tabela `tbitemcompra`
--
ALTER TABLE `tbitemcompra`
  ADD CONSTRAINT `FK_CodigoCompra2` FOREIGN KEY (`CodigoCompra`) REFERENCES `tbcompra` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_CodigoProduto2` FOREIGN KEY (`CodigoProduto`) REFERENCES `tbproduto` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `tbitemvenda`
--
ALTER TABLE `tbitemvenda`
  ADD CONSTRAINT `FK_CodigoProduto` FOREIGN KEY (`CodigoProduto`) REFERENCES `tbproduto` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_CodigoVenda` FOREIGN KEY (`CodigoVenda`) REFERENCES `tbvenda` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `tbvenda`
--
ALTER TABLE `tbvenda`
  ADD CONSTRAINT `FK_CodigoCliente` FOREIGN KEY (`CodigoCliente`) REFERENCES `tbcliente` (`Codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
