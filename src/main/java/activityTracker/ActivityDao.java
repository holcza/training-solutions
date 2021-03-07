package activityTracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {
    private MariaDbDataSource dataSource;

    public ActivityDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveActivity(Activity activity){
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("insert into activities(start_time,activity_des,activity_type) values (?,?,?)")) {
            stmt.setString(1, String.valueOf(Timestamp.valueOf(activity.getStartTime())));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public Activity findActivityById(long id){
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select * from activities where id = ?");
        ) {
            stmt.setLong(1, id);
            return getActivity(stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    private Activity getActivity(PreparedStatement stmt) {
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            if (rs.next()) {
                int id = rs.getInt("id");
                LocalDateTime localDateTime = rs.getTimestamp("start_time").toLocalDateTime();
                String desc = rs.getString("activity_des");
                String type = rs.getString("activity_type");
                return new Activity(id,localDateTime,desc,ActivityType.valueOf(type));
            }
            throw new IllegalArgumentException("No result");
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public List<Activity> listActivities(){
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from activities")
        ) {
            List<Activity> activities = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                LocalDateTime localDateTime = rs.getTimestamp("start_time").toLocalDateTime();
                String desc = rs.getString("activity_des");
                String type = rs.getString("activity_type");
                activities.add(new Activity(id,localDateTime,desc,ActivityType.valueOf(type)));
            }
            return activities;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot select activities", se);
        }
    }
}
