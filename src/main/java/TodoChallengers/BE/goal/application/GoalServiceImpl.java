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

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {
    private final UserRepository userRepository;
    private final GoalRepository goalRepository;

    /**
     * 단일 목표 생성
     * @param dto
     * @param userId
     */
    @Override
    public String createGoal(GoalCreateRequestDto dto, String userId) {
        // 예외) 유저 존재 확인
        userRepository.findById(userId).orElseThrow(() -> new BaseException(ResponseCode.USER_NOT_FOUND));

        // 목표 저장
        Goal goal = Goal.builder().goalName(dto.getGoalName()).state(dto.getState()).color(dto.getColor()).build();
        goalRepository.save(goal);
        return goal.getId();
    }

    /**
     * 단일 목표 수정
     * @param goal
     * @param userId
     */
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

    /**
     * 모든 목표 조회
     */
    @Override
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    /**
     * 단일 목표 삭제
     */
    @Override
    public void deleteGoal(String goalId, String id) {
        goalRepository.deleteById(goalId);
    }
}
