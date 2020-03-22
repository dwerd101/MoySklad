package com.moysklad.dao.domain.documentsDaoJdbc;
import com.moysklad.dao.jdbcDao.CrudDao;
import com.moysklad.model.UserAccount;

import java.util.List;

public interface UserAccountDao extends CrudDao<UserAccount>{
    boolean isExist(String name, String password);
    List<UserAccount> findAll();
}
