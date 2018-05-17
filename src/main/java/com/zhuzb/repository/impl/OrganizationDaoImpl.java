package com.zhuzb.repository.impl;

import com.zhuzb.entity.Country;
import com.zhuzb.entity.Organization;
import com.zhuzb.repository.BaseDao;
import com.zhuzb.repository.OrganizationDao;
import com.zhuzb.util.SessionConfig;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Organization: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Repository
public class OrganizationDaoImpl extends BaseDaoImpl<Organization> implements OrganizationDao {

    @Override
    public void createOrganization(final Organization organization) {
        //final String sql = "insert into sys_organization( name, parent_id, parent_ids, available) values(?,?,?,?)";
        super.getSession().save(organization);
    }

    @Override
    public void updateOrganization(Organization organization) {
        super.getSession().update(organization);
    }

    @Override
    public void deleteOrganization(Long organizationId) {
/*        Organization organization = findOne(organizationId);
        final String deleteSelfSql = "delete from sys_organization where id=?";
        jdbcTemplate.update(deleteSelfSql, organizationId);
        final String deleteDescendantsSql = "delete from sys_organization where parent_ids like ?";
        jdbcTemplate.update(deleteDescendantsSql, organization.makeSelfAsParentIds() + "%");*/
        super.getSession().delete(organizationId);
    }


    @Override
    public Organization findOne(Long organizationId) {
        System.out.println(super.getSession().get(Organization.class,organizationId));
        return (Organization) super.getSession().get(Organization.class,organizationId);
    }

    @Override
    public List<Organization> findAll() {
        String hql = "select  org from Organization org";
        Query query = super.getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Organization> findAllWithExclude(Organization excludeOraganization) {
        //TODO 改成not exists 利用索引
/*
        String hql = "select id, name, parentId, parentIds, available from Organization where id!=? and parent_ids not like ?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Organization.class), excludeOraganization.getId(), excludeOraganization.makeSelfAsParentIds() + "%");
*/
        return null;
    }

    @Override
    public void move(Organization source, Organization target) {
/*
        String moveSourceSql = "update sys_organization set parent_id=?,parent_ids=? where id=?";
        jdbcTemplate.update(moveSourceSql, target.getId(), target.getParentIds(), source.getId());
        String moveSourceDescendantsSql = "update sys_organization set parent_ids=concat(?, substring(parent_ids, length(?))) where parent_ids like ?";
        jdbcTemplate.update(moveSourceDescendantsSql, target.makeSelfAsParentIds(), source.makeSelfAsParentIds(), source.makeSelfAsParentIds() + "%");
*/
    }
}
