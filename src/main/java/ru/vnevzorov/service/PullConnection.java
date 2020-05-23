package ru.vnevzorov.service;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PullConnection {

    private static final Logger log = LogManager.getLogger();

    private static BasicDataSource dataSource;

    public BasicDataSource getPullConnection() {
        if (dataSource == null) {
            log.info("pullConnection = null. Creating new connection");

            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("org.h2.Driver");
            dataSource.setUrl("jdbc:h2:mem:tiles_project");
            dataSource.setUsername("admin");
            dataSource.setPassword("");
        }
        return dataSource;
    }
}
