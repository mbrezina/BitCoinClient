package da.project.sporteezone.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Fitness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String street;
    private String city;
    private String postalcode;
    private Boolean multisport;
    private Boolean activepass;
    private String payment;
    private String sex;
    private Boolean mhd;

    public Fitness() {
    }

    public Fitness(Integer id, String name, String street, String city, String postalcode, Boolean multisport, Boolean activepass, String payment, String sex, Boolean mhd) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.postalcode = postalcode;
        this.multisport = multisport;
        this.activepass = activepass;
        this.payment = payment;
        this.sex = sex;
        this.mhd = mhd;
    }

    public Fitness(String name, String street, String city, String postalcode, Boolean multisport, Boolean activepass, String payment, String sex, Boolean mhd) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.postalcode = postalcode;
        this.multisport = multisport;
        this.activepass = activepass;
        this.payment = payment;
        this.sex = sex;
        this.mhd = mhd;
    }

    public int getFit_id() {
        return id;
    }

    public String getFit_name() {
        return name;
    }

    public String getFit_street() {
        return street;
    }

    public String getFit_city() {
        return city;
    }

    @Override
    public String toString() {
        return "Fitness{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", street='" + street + '\'' +
            ", city='" + city + '\'' +
            ", postalcode='" + postalcode + '\'' +
            ", multisport=" + multisport +
            ", activepass=" + activepass +
            ", payment='" + payment + '\'' +
            ", sex='" + sex + '\'' +
            ", mhd=" + mhd +
            '}';
    }

    public void setFit_id(int id) {
        this.id = id;
    }

    public void setFit_name(String name) {
        this.name = name;
    }

    public void setFit_street(String street) {
        this.street = street;
    }

    public void setFit_city(String city) {
        this.city = city;
    }

    public void setFit_postalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public void setFit_multisport(Boolean multisport) {
        this.multisport = multisport;
    }

    public void setFit_activepass(Boolean activepass) {
        this.activepass = activepass;
    }

    public void setFit_payment(String payment) {
        this.payment = payment;
    }

    public void setFit_sex(String sex) {
        this.sex = sex;
    }

    public void setFit_mhd(Boolean mhd) {
        this.mhd = mhd;
    }

    public String getFit_postalcode() {
        return postalcode;
    }

    public Boolean getFit_multisport() {
        return multisport;
    }

    public Boolean getFit_activepass() {
        return activepass;
    }

    public String getFit_payment() {
        return payment;
    }

    public String getFit_sex() {
        return sex;
    }

    public Boolean getFit_mhd() {
        return mhd;
    }


}
