package ge.unknown.entities;

import javax.persistence.*;

/**
 * Created by Mikheil on 6/27/2017.
 */
@Entity
@Table(name = "transactions")
public class Transaction extends SuperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Some Param

    @Column(name = "amount")
    private double amount = 0.0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
