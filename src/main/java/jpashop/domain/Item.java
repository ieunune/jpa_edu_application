package jpashop.domain;

import jpashop.Category;
import jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    // 多:多 관계는 현업에서는 사용하기에는 어려운 관계 도식.
    // 이유 : 1. 매핑을 위한 테이블이 존재해야하고,
    //        2. 연관관계 추가시 지속적으로 추가등 되어야 하나 관리 불가능
    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<Category> categories = new ArrayList<>();

    // 재고 수량 증가
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    // 재고 수량 감소
    public void removeStock(int quantity) {
        int tempCnt = this.stockQuantity - quantity;
        if (tempCnt < 0) {
            throw new NotEnoughStockException("need more stock");
        }
    }

}
