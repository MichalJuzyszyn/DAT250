package ex2.bankjpa.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String pincode;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

}
