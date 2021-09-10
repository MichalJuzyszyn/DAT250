package ex2.bankjpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    private List<CreditCard> cardList = new ArrayList<CreditCard>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    public List<CreditCard> getCardList() {
        return cardList;
    }

    public void setCardList(List<CreditCard> cardList) {
        this.cardList = cardList;
    }

}