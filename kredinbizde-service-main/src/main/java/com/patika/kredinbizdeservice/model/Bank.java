package com.patika.kredinbizdeservice.model;

import lombok.ToString;

import java.util.List;

@ToString
public class Bank {

    private String name;
    private List<Loan> loanList;
    private List<CreditCard> creditCards;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

}
