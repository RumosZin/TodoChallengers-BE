package TodoChallengers.BE.user.repository;

import TodoChallengers.BE.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findById(String userId);
    Optional<User> findByKakaoId(String kakaoId);
}
