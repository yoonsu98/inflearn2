package hello.core.member;

/**
 * packageName    : hello.core.member
 * fileName       : MemberService
 * author         : yoons
 * date           : 2025-01-11
 * description    :
 */
public interface MemberService {

    void join(Member member);
    Member findMember(Long memberId);
}
