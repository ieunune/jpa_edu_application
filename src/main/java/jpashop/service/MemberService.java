package jpashop.service;

import jpashop.domain.Member;
import jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    // @Autowired 테스트 케이스 작성시 더미값을 설정할 수 없는 단점
    private final MemberRepository memberRepository;

    // 롬복에서 지원하는 RequiredArgsConstructor 어노테이션을 사용하여 직접 작성하지 않음
    //    public MemberService(MemberRepository memberRepository) {
    //        this.memberRepository = memberRepository;
    //    }

    // 회원가입
    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 중복체크 예외처리
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원 입니다.");
        }
    }

    // 회원 조회
    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
