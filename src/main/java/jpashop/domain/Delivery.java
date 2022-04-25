package jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    @JsonIgnore
    @OneToOne(mappedBy = "delivery")
    private Order order;
    @Embedded
    private Address address;

    // Enum타입을 사용할때는 STRING형식을 사용하도록 하자
    // default ORDINAL 설정으로 필요한 상태 값이 추가되게 되면 꼬이기 쉽다.
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // Ready, Comp
}
