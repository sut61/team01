package comeng.sut.se.team01.demo.entity;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name ="CoffeeOrders")

public class CoffeeOrder{
    @Id
    @SequenceGenerator(name = "orderId_seq", sequenceName="orderId_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "orderId_seq")
    @Column(name="ORDER_ID", unique = true, nullable = true)
    
    private @NotNull Integer orderId;
    private @NotNull String staffName;
    private @NotNull Integer orderTypeId;
    private @NotNull Integer customerId;
    private @NotNull String customerName;
    private @NotNull Integer itemId; 
    private @NotNull String itemName;
    private @NotNull Double itemPrice;
    private @NotNull Integer itemPiece;
    private @NotNull Double totalPrice;
    private @NotNull Integer cPoint;


}

