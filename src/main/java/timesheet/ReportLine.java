package timesheet;

public class ReportLine {
    private Project project;
    private long time;

    public ReportLine(Project project, long time) {
        this.project = project;
        this.time = time;
    }

    public Project getProject() {
        return project;
    }

    public long getTime() {
        return time;
    }

    public void addTime(long hour) {
        time =time + hour;
    }

    @Override
    public String toString() {
        if (time!=0){

            return project +
                    "\t" + time;
        } else {
            return "";
        }
    }
}
