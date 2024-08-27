package TodoChallengers.BE.goal.entity;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Goal {
    @Id
    private String id;

    private String goalName;

    private String state;

    private String color;

    @Builder
    public Goal(String id, String goalName, String state, String color) {
        this.id = id;
        this.goalName = goalName;
        this.state = state;
        this.color = color;
    }
}
