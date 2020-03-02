package User;

import com.moysklad.dao.domain.UserCrudDaoImpl;
import com.moysklad.model.UserAccount;
import com.moysklad.service.crypt.CryptPasswordImpl;
import com.moySklad.dao.domain.UserAccountDao;


public class AddUser {
    public static void main(String[] args) {
        UserAccountDao userAccount = new UserCrudDaoImpl();
        String password = new CryptPasswordImpl().cryptPassword("root");
        UserAccount userAccount1 = new UserAccount("Anna", password);
        userAccount.save(userAccount1);
    }

}
