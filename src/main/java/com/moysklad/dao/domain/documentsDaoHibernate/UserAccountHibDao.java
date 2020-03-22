package com.moysklad.dao.domain.documentsDaoHibernate;

import com.moysklad.dao.hibernateDao.CrudHibernateDao;
import com.moysklad.model.UserAccount;

import java.util.List;

public interface UserAccountHibDao extends CrudHibernateDao<UserAccount, Integer> {
    boolean isExist(String name, String password);
    List<UserAccount> findAll();
}
