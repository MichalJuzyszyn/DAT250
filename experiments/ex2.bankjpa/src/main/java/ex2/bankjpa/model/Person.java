package ex2.bankjpa.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String name;

    private List<CreditCard> cardList = new ArrayList<CreditCard>();

    private List<Adress> adressList = new ArrayList<Adress>();

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

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


    @ManyToMany
    public List<Adress> getAdressList() {
        return this.adressList;
    }

    public void setAdressList(List<Adress> adressList) {
        this.adressList = adressList;
    }

}
