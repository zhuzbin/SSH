package com.zhuzb.repository.impl;

import com.zhuzb.entity.Country;
import com.zhuzb.repository.BaseDao;
import com.zhuzb.repository.CountryDao;
import com.zhuzb.util.SessionConfig;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/1/17
 * Time：11:04
 */
@Repository
public class CountryDaoImpl extends BaseDaoImpl<Country> implements CountryDao  {

    public List<Country> getAll() {
        String hql = "from Country";
        Query query = super.getSession().createQuery(hql);
        List<Country> list = query.list();
        return list;
    }

    public void save(Country country){
        super.getSession().save(country);
    }

    public Country getByName(String name){
        String hql = "select countryName,countryCode from Country where countryName = ?";
        Query query = super.getSession().createQuery(hql).setString(0,name);
        List<Country> list = query.list();
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public List<Country> getCountryList(Country country){
        StringBuffer hql = new StringBuffer("from Country where 1=1 ");
        if(country.getCountryCode()!=null&&!"".equals(country.getCountryCode())){
            hql.append(" AND countryCode = "+country.getCountryCode());
        }
        if(country.getCountryName()!=null&&!"".equals(country.getCountryName())){
            hql.append(" AND countryName = "+country.getCountryName());
        }
        Query query = super.getSession().createQuery(hql.toString());
        query.setFirstResult(country.getPageSize()*(country.getPageNumber()-1));
        query.setMaxResults(country.getPageSize());
        List<Country> list = query.list();
        return list;
    }

    @Override
    public void add(Country country) {
        super.add(country);
    }

    @Override
    public void update(Country country) {
        super.update(country);
    }

    @Override
    public void delete(Country country) {
        super.delete(country);
    }

    @Override
    public Country getEntity(Integer id) {
        return super.getEntity(id);
    }
}
