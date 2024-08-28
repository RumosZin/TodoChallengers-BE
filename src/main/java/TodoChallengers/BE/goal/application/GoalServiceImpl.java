package TodoChallengers.BE.goal.application;

import TodoChallengers.BE.common.exception.BaseException;
import TodoChallengers.BE.common.util.ResponseCode;
import TodoChallengers.BE.goal.dto.request.GoalCreateRequestDto;
import TodoChallengers.BE.goal.entity.Goal;
import TodoChallengers.BE.goal.repository.GoalRepository;
import TodoChallengers.BE.user.domain.User;
import TodoChallengers.BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {
    private final UserRepository userRepository;
    private final GoalRepository goalRepository;

    @Override
    public String createGoal(Goal goal, String userId) {
        // 예외) 유저 존재 확인
        User user = userRepository.findById(userId).orElseThrow(() -> new BaseException(ResponseCode.USER_NOT_FOUND));

        // 목표 저장
        goalRepository.save(goal);
        return goal.getId();
    }

    @Override
    public String updateGoal(Goal goal, String userId) {
        // 예외) 유저 존재 확인
        userRepository.findById(userId).orElseThrow(() -> new BaseException(ResponseCode.USER_NOT_FOUND));

        // 예외) 목표 존재 확인
        goalRepository.findById(goal.getId()).orElseThrow(() -> new BaseException(ResponseCode.CHALLENGE_NOT_FOUND));

        // 목표 수정
        goalRepository.save(goal);
        return goal.getId();

    }
}
