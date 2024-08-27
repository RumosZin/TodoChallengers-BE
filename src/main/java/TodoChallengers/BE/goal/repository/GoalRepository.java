package TodoChallengers.BE.goal.repository;

import TodoChallengers.BE.goal.entity.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoalRepository extends MongoRepository<Goal, String> {
}
