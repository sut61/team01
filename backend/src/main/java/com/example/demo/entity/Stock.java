package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Stock")
public class Stock {

    @Id
    @SequenceGenerator(name="stock_seq",sequenceName="stock_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stock_seq")

    private  @NotNull Long stockid;
    @NotNull
    @Min(value = 25)
    @Max(value = 1000)
    private Double priceperitem;
    private @NotNull Double totalprice;
    @Temporal(TemporalType.DATE)
    @NotNull Date date;

    @NotNull
    @Pattern(regexp = "[-a-zก-๛]+")
    private  String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Amount amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Unit unit;

    public Long getStockid() {
        return stockid;
    }

    public void setStockid(Long stockid) {
        this.stockid = stockid;
    }

    public void setPriceperitem(Double priceperitem) {
        this.priceperitem = priceperitem;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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