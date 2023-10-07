package inflearn.spring_core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository; // 수정

    // 수정 후 생성자 추가
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
