package com.example.models;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

@Entity
public class Producto implements Serializable {
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
    private Double price;
    private String description;

    @ManyToOne
    private Competitor competitor;

    public Producto() {
    }

    @PreUpdate
    private void updateTimestamp() { this.updatedAt = Calendar.getInstance(); }

    @PrePersist
    private void creationTimestamp() { this.createdAt = this.updatedAt = Calendar.getInstance(); }

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Calendar getCreatedAt() { return createdAt; }
    public void setCreatedAt(Calendar createdAt) { this.createdAt = createdAt; }
    public Calendar getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Calendar updatedAt) { this.updatedAt = updatedAt; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Competitor getCompetitor() { return competitor; }
    public void setCompetitor(Competitor competitor) { this.competitor = competitor; }
}