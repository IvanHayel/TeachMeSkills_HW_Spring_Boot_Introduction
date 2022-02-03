package com.teachmeskills.spring_boot_introduction.controller;

import com.teachmeskills.spring_boot_introduction.model.credit_card.CreditCard;
import com.teachmeskills.spring_boot_introduction.model.service.credit_card.CreditCardService;
import com.teachmeskills.spring_boot_introduction.model.service.user.UserService;
import com.teachmeskills.spring_boot_introduction.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class RESTController {
    @Autowired
    private UserService userService;
    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("/users")
    public List<User> showAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        return user;
    }

    @GetMapping("/cards")
    public List<CreditCard> showAllCreditCards() {
        List<CreditCard> allCreditCards = creditCardService.getAllCreditCards();
        return allCreditCards;
    }

    @PostMapping("/cards")
    public CreditCard getCreditCard(@RequestBody String cardNumber) {
        CreditCard creditCard = creditCardService.getCreditCard(cardNumber);
        return creditCard;
    }

    @PostMapping("/cards/balance")
    public String getCardBalance(@RequestBody String cardNumber) {
        double cardBalance = creditCardService.getCardBalance(cardNumber);
        return String.format("Card number: %s\n Balance: %.2f", cardNumber, cardBalance);
    }

    @GetMapping("/cards/transfer/{from}:{to}:{amount}")
    public String transfer(@PathVariable String from, @PathVariable String to, @PathVariable double amount) {
        boolean isTransferSuccess = creditCardService.transfer(from,to,amount);
        if(isTransferSuccess){
            return String.format("Successfully transferred %.2f from %s to %s.", amount, from, to);
        }
        return "Transfer denied!";
    }
}