package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeSheetItem {

    private final Employee employee;
    private final Project project;
    private final LocalDateTime beginDate;
    private final LocalDateTime endDate;

    public TimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        if (!beginDate.toLocalDate().equals(endDate.toLocalDate())){
            throw new IllegalArgumentException("The two times should be on the same day");
        }

        if (beginDate.isAfter(endDate)){
            throw new IllegalArgumentException("Start time should be before the end time");
        }

        this.employee = employee;
        this.project = project;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public long hoursBetweenDates(){
        return Duration.between(beginDate, endDate).toHours();
    }
}
