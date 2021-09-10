package ex2.bankjpa.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String street;
    private int number;
    private List<Person> peopleList = new ArrayList<Person>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @ManyToMany
    public List<Person> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Person> personList) {
        this.peopleList = personList;
    }

}