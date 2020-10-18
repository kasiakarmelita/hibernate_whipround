package pl.Karmelita.dao;

import org.hibernate.Session;
import pl.Karmelita.database.SessionProvider;
import pl.Karmelita.model.User;

import java.util.List;

public class UserDao extends AbstractDao <User> {

    public UserDao() {
        super(User.class);
    }

    public List<User> getAllUser () {
        Session session = SessionProvider.getSession();
      List <User> list = session.createQuery("from User", User.class).list();
        session.close();
        return list;
    };
}
