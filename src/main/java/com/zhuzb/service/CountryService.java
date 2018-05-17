package com.zhuzb.service;

import com.zhuzb.entity.Country;
import net.sf.ehcache.search.aggregator.Count;

import java.util.List;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/1/17
 * Time：11:12
 */
public interface CountryService {

    public List<Country> getAll();

    public void save(Country country);

    public Country getName(String name);

    public List<Country> getCountryList(Country country);

    public void update(Country country);

    public void delete(Country country);
}
