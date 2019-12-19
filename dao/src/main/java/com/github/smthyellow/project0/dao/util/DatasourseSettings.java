package com.github.smthyellow.project0.dao.util;

import org.springframework.beans.factory.annotation.Value;

public class DatasourseSettings {
    @Value("${dburl}")
    private String url;

    @Value("${dbusername}")
    private String user;

    @Value("${password}")
    private String password;

    @Value("${driver}")
    private String driver;

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }
}
