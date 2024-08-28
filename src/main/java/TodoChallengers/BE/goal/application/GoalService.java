package TodoChallengers.BE.goal.application;

import TodoChallengers.BE.goal.dto.request.GoalCreateRequestDto;
import TodoChallengers.BE.goal.entity.Goal;

import java.util.List;

public interface GoalService {
    String createGoal(GoalCreateRequestDto dto, String userId);

    String updateGoal(Goal goal, String userId);

    List<Goal> getAllGoals();

    void deleteGoal(String goalId, String id);
}
