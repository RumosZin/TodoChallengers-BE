package TodoChallengers.BE.goal.application;

import TodoChallengers.BE.goal.dto.request.GoalCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl  implements GoalService{

    @Override
    public String createGoal(GoalCreateRequestDto dto, String userId) {
        return "";
    }
}
