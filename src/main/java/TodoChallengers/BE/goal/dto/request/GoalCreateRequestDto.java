package TodoChallengers.BE.goal.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoalCreateRequestDto {

    private String goalName;

    private String state;

    private String color;
}
