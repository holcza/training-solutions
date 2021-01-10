package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities = new ArrayList<>();

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public int numberOfTrackActivities() {
        int sum = 0;
        for (Activity a : activities) {
            if (a instanceof ActivityWithTrack) {
                sum++;
            }
        }
        return sum;
    }

    public int numberOfWithoutTrackActivities() {
        int sum = 0;
        for (Activity a : activities) {
            if (a instanceof ActivityWithoutTrack) {
                sum++;
            }
        }
        return sum;
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();

        for(ActivityType at:ActivityType.values()){
            int sum = 0;
            for (Activity a:activities){
                if (a.getType()==at){
                    sum += a.getDistance();
                }
            }
            reports.add(new Report(at,sum));
        }

        return reports;
    }
}
