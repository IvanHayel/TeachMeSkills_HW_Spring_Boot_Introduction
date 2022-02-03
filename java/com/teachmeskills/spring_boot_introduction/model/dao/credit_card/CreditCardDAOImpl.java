package com.teachmeskills.spring_boot_introduction.model.dao.credit_card;

import com.teachmeskills.spring_boot_introduction.model.credit_card.CreditCard;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CreditCardDAOImpl implements CreditCardDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<CreditCard> getAllCreditCards() {
        Session session = entityManager.unwrap(Session.class);
        Query<CreditCard> query = session.createQuery("from CreditCard", CreditCard.class);
        List<CreditCard> cards = query.getResultList();
        return cards;
    }

    @Override
    public CreditCard getCreditCard(String cardNumber) {
        Session session = entityManager.unwrap(Session.class);
        CreditCard creditCard = session.get(CreditCard.class, cardNumber);
        return creditCard;
    }

    @Override
    public double getCardBalance(String cardNumber) {
        Session session = entityManager.unwrap(Session.class);
        CreditCard creditCard = session.get(CreditCard.class, cardNumber);
        return creditCard.getBalance();
    }

    @Override
    public boolean transfer(String fromCardNumber, String toCardNumber, double amount) {
        Session session = entityManager.unwrap(Session.class);
        CreditCard fromCard = session.get(CreditCard.class, fromCardNumber);
        if (fromCard.getBalance() < amount) {
            return false;
        }
        CreditCard toCard = session.get(CreditCard.class, toCardNumber);
        toCard.setBalance(toCard.getBalance() + amount);
        fromCard.setBalance(fromCard.getBalance() - amount);
        session.saveOrUpdate(toCard);
        session.saveOrUpdate(fromCard);
        return true;
    }
}