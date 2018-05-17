package com.zhuzb.entity;

import com.zhuzb.common.BaseEntity;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/1/17
 * Time：10:59
 */
public class Country extends BaseEntity {
    private int id;
    private String countryName;
    private String countryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
