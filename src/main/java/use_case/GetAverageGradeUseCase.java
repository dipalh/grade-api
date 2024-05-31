package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        int total = 0;
        int member = 0;
        for (String utorid: gradeDB.getMyTeam().getMembers()) {
         total += gradeDB.getGrade(utorid, course).getGrade();
         member++;
        }
        if (member == 0){
        return 0.0f;}
        else {
            return (float) total / member;
        }
    }
}
