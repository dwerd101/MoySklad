package User;

import com.moysklad.dao.domain.JdbcDaoImpl.UserCrudDaoImpl;
import com.moysklad.model.UserAccount;
import com.moysklad.service.crypt.CryptPasswordImpl;
import com.moysklad.dao.domain.documentsDaoJdbc.UserAccountDao;


public class AddUser {
    public static void main(String[] args) {
        UserAccountDao userAccount = new UserCrudDaoImpl();
        String password = new CryptPasswordImpl().cryptPassword("root");
        UserAccount userAccount1 = new UserAccount("Anna", password);
        userAccount.save(userAccount1);
    }

}
