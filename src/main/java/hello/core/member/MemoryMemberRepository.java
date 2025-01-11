package hello.core.member;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : hello.core.member
 * fileName       : MemberRepositoryImpl
 * author         : yoons
 * date           : 2025-01-11
 * description    :
 */
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
