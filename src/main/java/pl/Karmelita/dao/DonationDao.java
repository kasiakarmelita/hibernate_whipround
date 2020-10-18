package pl.Karmelita.dao;

import org.hibernate.Session;
import pl.Karmelita.database.SessionProvider;
import pl.Karmelita.model.Donation;

import java.util.List;

public class DonationDao extends AbstractDao<Donation> {


    public DonationDao() {
        super(Donation.class);
    }

    public List<Donation> findByWhiproundId (int id){
        Session session = SessionProvider.getSession();
        List <Donation> list = session.createQuery("from Donation where whipround.id=:id", Donation.class)
                .setParameter("id",id)
                .list();
        session.close();
        return list;
    };

    public  List <Donation> findByUserId (int id){
    Session session = SessionProvider.getSession();
    List <Donation> list = session.createQuery("from Donation where user.id=:id", Donation.class)
            .setParameter("id",id)
            .list();
    session.close();
    return list;

    }

}
