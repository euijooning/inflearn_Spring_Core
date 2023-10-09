package inflearn.spring_core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }


    //테스트 용도 추가
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
