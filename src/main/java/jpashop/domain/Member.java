package jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;

    @Embedded
    private Address address;

    // @JsonIgnore
    // 클라이언트의 요구사항에 따라 수많은 케이스가 발생하게됨. Entity에서 처리하게 되면 관리안되고 수정하기 힘듬
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


}
