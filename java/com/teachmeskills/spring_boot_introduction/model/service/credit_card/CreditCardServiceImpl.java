package com.teachmeskills.spring_boot_introduction.model.service.credit_card;

import com.teachmeskills.spring_boot_introduction.model.credit_card.CreditCard;
import com.teachmeskills.spring_boot_introduction.model.dao.credit_card.CreditCardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService{
    @Autowired
    private CreditCardDAO creditCardDAO;

    @Override
    @Transactional
    public List<CreditCard> getAllCreditCards() {
        return creditCardDAO.getAllCreditCards();
    }

    @Override
    @Transactional
    public CreditCard getCreditCard(String cardNumber) {
        return creditCardDAO.getCreditCard(cardNumber);
    }

    @Override
    @Transactional
    public double getCardBalance(String cardNumber) {
        return creditCardDAO.getCardBalance(cardNumber);
    }

    @Override
    @Transactional
    public boolean transfer(String fromCardNumber, String toCardNumber, double amount) {
        return creditCardDAO.transfer(fromCardNumber, toCardNumber, amount);
    }
}