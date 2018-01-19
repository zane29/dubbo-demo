package com.dubbodemo.common;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 16-12-20
 * Time: 下午3:27
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo implements Serializable {

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
