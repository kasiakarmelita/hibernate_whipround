package pl.Karmelita.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "donationSeq")
    @GenericGenerator(name = "donationSeq", strategy = "increment")
    private int id;

    @Column
    private BigDecimal amount;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToOne(targetEntity = Whipround.class)
    private Whipround whipround;

    public Donation() {
    }

    public Donation(BigDecimal amount, User user, Whipround whipround) {
        this.amount = amount;
        this.user = user;
        this.whipround = whipround;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", amount=" + amount +
                ", user=" + user +
                ", whipround=" + whipround +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return id == donation.id &&
                Objects.equals(amount, donation.amount) &&
                Objects.equals(user, donation.user) &&
                Objects.equals(whipround, donation.whipround);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, user, whipround);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Whipround getWhipround() {
        return whipround;
    }

    public void setWhipround(Whipround whipround) {
        this.whipround = whipround;
    }
}
