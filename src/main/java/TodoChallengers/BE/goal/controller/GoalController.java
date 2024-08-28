package TodoChallengers.BE.goal.controller;

import TodoChallengers.BE.common.annotation.Challenger;
import TodoChallengers.BE.common.util.ApiResponse;
import TodoChallengers.BE.common.util.ResponseCode;
import TodoChallengers.BE.goal.application.GoalService;
import TodoChallengers.BE.goal.dto.request.GoalCreateRequestDto;
import TodoChallengers.BE.goal.entity.Goal;
import TodoChallengers.BE.user.domain.User;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goal")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;

    @GetMapping("/")
    public ApiResponse<List<Goal>> getAllGoals() {
        return ApiResponse.success(goalService.getAllGoals(), ResponseCode.CHALLENGE_FINDALL_SUCCESS.getMessage());
    }

    @PostMapping("/")
    public ApiResponse<String> createGoal(@Parameter(hidden = true) @Challenger User user, @RequestBody @Valid GoalCreateRequestDto dto) {
        return ApiResponse.success(goalService.createGoal(dto, user.getId()), ResponseCode.CHALLENGE_CREATE_SUCCESS.getMessage());
    }

    @PutMapping("/")
    public ApiResponse<String> updateGoal(@Parameter(hidden = true) @Challenger User user, @RequestBody @Valid Goal goal) {
        return ApiResponse.success(goalService.updateGoal(goal, user.getId()), ResponseCode.CHALLENGE_UPDATE_SUCCESS.getMessage());
    }
}
