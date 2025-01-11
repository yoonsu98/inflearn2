package hello.core.member;

/**
 * packageName    : hello.core.member
 * fileName       : MemberRepository
 * author         : yoons
 * date           : 2025-01-11
 * description    :
 */
public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
