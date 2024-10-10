package com.czh.springboot.configure.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

import javax.sql.DataSource;

@Slf4j
//public class CustomTransactionManager extends AbstractPlatformTransactionManager {
public class CustomTransactionManager extends DataSourceTransactionManager {

    public CustomTransactionManager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected Object doGetTransaction() throws TransactionException {
        log.info("do Get transaction");
        return super.doGetTransaction();
    }

    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) throws TransactionException {
        log.info("do Begin transaction");
        super.doBegin(transaction, definition);
    }

    @Override
    protected void doCommit(DefaultTransactionStatus status) throws TransactionException {
        log.info("do Commit transaction");
        super.doCommit(status);
    }

    @Override
    protected void doRollback(DefaultTransactionStatus status) throws TransactionException {
        log.info("do Rollback transaction");
        super.doRollback(status);
    }
}