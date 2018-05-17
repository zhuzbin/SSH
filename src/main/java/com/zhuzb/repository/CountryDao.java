package com.zhuzb.repository;

import com.zhuzb.entity.Country;

import java.util.List;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/1/17
 * Time：11:04
 */
public interface CountryDao extends BaseDao<Country> {

    public List<Country> getAll();

    public void save(Country country);

    public Country getByName(String name);

    public List<Country> getCountryList(Country country);
}
