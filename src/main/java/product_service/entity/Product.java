package product_service.entity;

import java.time.Instant;
import java.time.LocalDate;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "products")
public class Product {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "product_seq_generator"
    )
    @SequenceGenerator(
        name = "product_seq_generator",
        sequenceName = "product_id_seq"
    )
    private Long id;
    private String sku;
    private String name;
    private String description;
    private String category;
    private LocalDate validFrom;
    private LocalDate validUntil;
    private Instant updatedAt;
    private String updatedBy;
    private Instant createdAt;

    
    public Product(String sku, String name, String description, String category, LocalDate validFrom,
            LocalDate validUntil) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.category = category;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }
    protected Product(){

    }
    public Long getId() {
    return id;
}
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public LocalDate getValidFrom() {
        return validFrom;
    }
    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }
    public LocalDate getValidUntil() {
        return validUntil;
    }
    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }
    public Instant getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    

    
     public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
     public void setSku(String sku){
        this.sku=sku;
    }
    public String getSku(){
        return sku;
    }
    

}
