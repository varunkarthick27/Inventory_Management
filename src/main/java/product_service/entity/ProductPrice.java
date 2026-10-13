package product_service.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity 
@Table (name = "product_prices")
public class ProductPrice {
    @Id
    @GeneratedValue (  
        strategy = GenerationType.SEQUENCE,
        generator = "product_price_seq_generator"
    )
    @SequenceGenerator(
        name = "product_price_seq_generator",
        sequenceName = "product_price_id_seq",
        allocationSize = 1
    )
    private Long id;
    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;
    @Column(name = "price_without_tax")
    private BigDecimal priceWithoutTax;
    @Column (name = "tax_percentage")
    private BigDecimal taxPercentage;
    @Column (name = "valid_from")
    private LocalDate validFrom;
    @Column (name = "valid_until")
    private LocalDate validUntil;
    @Column(insertable = false, updatable = false)
    private Instant createdAt;
    @Column (name = "created_by")
    private String createdBy;

}
