package activityTracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityDaoTest {
    ActivityDao  activityDao;

    @BeforeEach
    public void init(){
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    public void findActivityByIdTest(){
        Activity activity =activityDao.findActivityById(1);
        assertEquals(activity.getDesc(),"aaa");
    }

    @Test
    public void listActivities(){
        List<Activity> activities = activityDao.listActivities();
        assertEquals(activities.get(1).getDesc(),"bbb");
    }
}
