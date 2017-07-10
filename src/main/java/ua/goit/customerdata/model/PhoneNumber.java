package ua.goit.customerdata.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_number")
public class PhoneNumber implements Serializable {
    private static final long serialVersionUID = 3783650251420353344L;
    private Long id;
    private String phoneNumber;
    private String comment;
    private Type type;
    private Customer customer;

    public PhoneNumber() {
    }

    public PhoneNumber(Long id, String phoneNumber, String comment, Type type, Customer customer) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.type = type;
        this.customer = customer;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @OneToOne(mappedBy = "phoneNumber", cascade = CascadeType.ALL)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", comment='" + comment + '\'' +
                ", type=" + type +
                '}';
    }
}
