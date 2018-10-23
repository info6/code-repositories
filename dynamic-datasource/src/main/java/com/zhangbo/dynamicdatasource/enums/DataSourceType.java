package com.zhangbo.dynamicdatasource.enums;


public enum DataSourceType {

    WRITE("write"),
    READ("read");

    DataSourceType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}