package com.teachmeskills.spring_boot_introduction.model.dao.credit_card;

import com.teachmeskills.spring_boot_introduction.model.credit_card.CreditCard;

import java.util.List;

public interface CreditCardDAO {
    List<CreditCard> getAllCreditCards();

    CreditCard getCreditCard(String cardNumber);

    double getCardBalance(String cardNumber);

    boolean transfer(String fromCardNumber, String toCardNumber, double amount);
}