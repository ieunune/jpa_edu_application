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

    // @JsonIgnore : 양방향으로 데이터 처리 할때 JSON에서 무한 루프 생성하기 때문에 설정 필요.
    // 클라이언트의 요구사항에 따라 수많은 케이스가 발생하게됨. Entity에서 처리하게 되면 관리안되고 수정하기 힘듬
    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


}
