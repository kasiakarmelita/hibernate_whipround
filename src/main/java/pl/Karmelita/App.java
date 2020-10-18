package pl.Karmelita;

import pl.Karmelita.dao.DonationDao;
import pl.Karmelita.dao.UserDao;
import pl.Karmelita.dao.WhiproundDao;
import pl.Karmelita.model.Donation;
import pl.Karmelita.model.User;
import pl.Karmelita.model.Whipround;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        WhiproundDao whiproundDao = new WhiproundDao();
        UserDao userDao = new UserDao();
        DonationDao donationDao = new DonationDao();

        Whipround whipround1 = new Whipround("Szlachetna paczka", new BigDecimal(5000.34));
        Whipround whipround2 = new Whipround("Uratuj rysie", new BigDecimal(400));
        Whipround whipround3 = new Whipround("Plantacja tulipanów", new BigDecimal(3333.33));

        whiproundDao.add(whipround1);
        whiproundDao.add(whipround2);
        whiproundDao.add(whipround3);


        User userKasia = new User("Kasia", "Karmelita");
        User userJan = new User("Jan", "Kowalski");

        userDao.add(userKasia);
        userDao.add(userJan);


        Donation donation1 = new Donation(new BigDecimal(300), userDao.findById(1), whiproundDao.findById(1));
        Donation donation2 = new Donation(new BigDecimal(700), userDao.findById(1), whiproundDao.findById(2));
        Donation donation3 = new Donation(new BigDecimal(300), userDao.findById(2), whiproundDao.findById(3));
        Donation donation4 = new Donation(new BigDecimal(300), userDao.findById(1), whiproundDao.findById(3));

        donationDao.add(donation1);
        donationDao.add(donation2);
        donationDao.add(donation3);
        donationDao.add(donation4);

        donationDao.findByUserId(1).forEach(donation -> {
            System.out.println(donation.toString());
        });

        donationDao.findByWhiproundId(3).forEach(donation -> {
            System.out.println(donation.toString());
        });
        System.out.println(donationDao.findById(2));

        userDao.getAllUser().forEach(user -> {
            System.out.println(user.toString());
        });

        System.out.println(userDao.findById(2).toString());

        whiproundDao.getActiveWhipround().forEach(whipround -> {
            System.out.println(whipround.toString());
        });


    }
}
