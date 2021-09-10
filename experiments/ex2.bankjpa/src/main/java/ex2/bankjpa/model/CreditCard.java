package ex2.bankjpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private Integer balance;
    private Integer number;
    private Integer limit;

    @OneToOne
    private Pincode pincode = new Pincode();

    @ManyToOne
    private Bank bank = new Bank();

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }



    public void setBank(Bank bank) { this.bank = bank; }

    @ManyToOne
    public Bank getBank() { return bank; }

    public void setPincode(Pincode pincode) { this.pincode = pincode; }

    @OneToOne
    public Pincode getPincode() { return pincode; }


}
