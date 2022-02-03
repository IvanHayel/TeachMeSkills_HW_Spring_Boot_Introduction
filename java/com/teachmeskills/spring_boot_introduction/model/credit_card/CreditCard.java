package com.teachmeskills.spring_boot_introduction.model.credit_card;

import com.teachmeskills.spring_boot_introduction.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class CreditCard {
    @Id
    @Column(name = "card_number")
    private String card_number;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
    @Column(name = "balance")
    private double balance;

    public CreditCard() {
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}