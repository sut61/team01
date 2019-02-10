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

    private  Long stockid;
    private @NotNull Integer priceperitem;
    private @NotNull Integer totalprice;
    @Temporal(TemporalType.DATE)
    @NotNull Date date;

    @NotNull
    @Pattern(regexp = "[-A-Zก-๛]+")
    @Size(min = 2, max = 40 )
    private  String note;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    private Amount amount;

    @ManyToOne(fetch = FetchType.EAGER)
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

    public void setPriceperitem(Integer priceperitem) {
        this.priceperitem = priceperitem;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
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