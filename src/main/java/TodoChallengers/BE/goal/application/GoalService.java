package TodoChallengers.BE.goal.application;

import TodoChallengers.BE.goal.dto.request.GoalCreateRequestDto;

public interface GoalService {
    String createGoal(GoalCreateRequestDto dto, String userId);

}
