package pl.Karmelita.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.Karmelita.database.SessionProvider;

public abstract class AbstractDao<T> {

    private Class<T> clazz;

    protected AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void add (T record){
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(record);
        transaction.commit();
        session.close();

    }

    public T findById (int id){
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
      T record = session.find(clazz, id);
        transaction.commit();
        session.close();
        return record;
    }

}
