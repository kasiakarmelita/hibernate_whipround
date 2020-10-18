package pl.Karmelita.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "whipround")
public class Whipround {

    @Id
    @Column(name="id")
    @GeneratedValue(generator = "whiproundSeq")
    @GenericGenerator(name = "whiproundSeq", strategy ="increment")
    private int id;

    @Column
    private String name;

    @Column
    private BigDecimal goal;

    public Whipround() {
    }

    public Whipround(String name, BigDecimal goal) {
        this.name = name;
        this.goal = goal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getGoal() {
        return goal;
    }

    public void setGoal(BigDecimal goal) {
        this.goal = goal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Whipround whipround = (Whipround) o;
        return id == whipround.id &&
                Objects.equals(name, whipround.name) &&
                Objects.equals(goal, whipround.goal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, goal);
    }

    @Override
    public String toString() {
        return "Whipround{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goal=" + goal +
                '}';
    }
}
