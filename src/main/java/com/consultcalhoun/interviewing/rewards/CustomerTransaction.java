package com.consultcalhoun.interviewing.rewards;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "customer_transaction")
public class CustomerTransaction { 
    // id, customer_id, amount, tx_date
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // TODO: Need to convey this is a foreign key constraint.
    //@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Integer customerId;
    
    @Column(nullable = false, name = "amount")
    private Integer amount;
    
    @Column(nullable = false, name = "tx_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date txDate;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getAmount() {
        return amount;
    }
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    public Date getTxDate() {
        return txDate;
    }
    
    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.customerId, this.amount, this.txDate);
    }
}
