package com.example.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Competitor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "create_at", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar updatedAt;

    private String name;
    private String surname;
    private int age;
    private String telephone;
    private String cellphone;
    private String address;
    private String city;
    private String country;
    private boolean winner;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competitor")
    private Set<Producto> products;

    public Competitor() {
    }

    public Competitor(String name, String surname, int age, String telephone, String cellphone, String address, String city, String country, boolean winner, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.winner = winner;
        this.password = password;
    }

    @PreUpdate
    private void updateTimestamp() { this.updatedAt = Calendar.getInstance(); }

    @PrePersist
    private void creationTimestamp() { this.createdAt = this.updatedAt = Calendar.getInstance(); }

    // --- GETTERS Y SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Calendar getCreatedAt() { return createdAt; }
    public void setCreatedAt(Calendar createdAt) { this.createdAt = createdAt; }
    public Calendar getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Calendar updatedAt) { this.updatedAt = updatedAt; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getCellphone() { return cellphone; }
    public void setCellphone(String cellphone) { this.cellphone = cellphone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public boolean isWinner() { return winner; }
    public void setWinner(boolean winner) { this.winner = winner; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Set<Producto> getProducts() { return products; }
    public void setProducts(Set<Producto> products) { this.products = products; }
}