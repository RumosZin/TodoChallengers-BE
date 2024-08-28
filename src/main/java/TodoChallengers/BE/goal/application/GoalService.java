package TodoChallengers.BE.goal.application;

import TodoChallengers.BE.goal.dto.request.GoalCreateRequestDto;
import TodoChallengers.BE.goal.entity.Goal;

public interface GoalService {
    String createGoal(Goal goal, String userId);

    String updateGoal(Goal goal, String userId);
}
