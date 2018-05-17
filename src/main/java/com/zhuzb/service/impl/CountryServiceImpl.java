package com.zhuzb.service.impl;

import com.zhuzb.entity.Country;
import com.zhuzb.repository.CountryDao;
import com.zhuzb.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/1/17
 * Time：11:13
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    public List<Country> getAll() {
        return countryDao.getAll();
    }

    public void save(Country country){
        countryDao.save(country);
    }

    public Country getName(String name) {
        return countryDao.getByName(name);
    }

    public List<Country> getCountryList(Country country){
        return countryDao.getCountryList(country);
    }

    public void update(Country country){
        countryDao.update(country);
    }

    @Override
    public void delete(Country country) {
        countryDao.delete(country);
    }
}
