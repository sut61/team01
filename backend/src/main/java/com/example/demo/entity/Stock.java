package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Stock")
public class Stock {
    @Id
    @SequenceGenerator(name="stock_seq",sequenceName="stock_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stock_seq")
    @Column(name = "Stock_Id")
    private @NotNull Long stockid;
    @Min(value = 25)
    @Max(value = 1000)
    private @NotNull Integer priceperitem;
    private @NotNull Integer totalprice;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @OneToOne(fetch = FetchType.EAGER)
    private Amount amount;

    @OneToOne(fetch = FetchType.EAGER)
    private Unit unit;

    public Long getStockid() {
        return stockid;
    }

    public void setStockid(Long stockid) {
        this.stockid = stockid;
    }

    public int getPriceperitem() {
        return priceperitem;
    }

    public void setPriceperitem(int priceperitem) {
        this.priceperitem = priceperitem;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
