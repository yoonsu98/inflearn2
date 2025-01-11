package hello.core.member;

/**
 * packageName    : hello.core.member
 * fileName       : MemberServiceImpl
 * author         : yoons
 * date           : 2025-01-11
 * description    :
 */
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
