package jpashop.repository;

import jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    // @PersistenceContext -> @Autowired (스프링에서 Autowired 사용하면 PersistenceContext 기능 제공)
    // @Autowired를 사용하는 경우 테스트 케이스 작성이 어려워짐
    // 생성자를 작성하여 em 주입되도록 설정
    // 생성자를 직접 작성하지 않도록 lombok 어노테이션 사용. @RequiredArgsConstructor
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m WHERE m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
