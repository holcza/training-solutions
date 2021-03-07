CREATE TABLE activities (
                        id BIGINT AUTO_INCREMENT,
                        start_time TIMESTAMP,
                        activity_des VARCHAR(255),
                        activity_type VARCHAR(100),
                        PRIMARY KEY(id));

INSERT INTO activities (start_time,activity_des,activity_type) VALUE ('2020-11-04 11:22:00','aaa','BIKING');
INSERT INTO activities (start_time,activity_des,activity_type) VALUE ('2020-11-04 11:22:00','bbb','BIKING');
INSERT INTO activities (start_time,activity_des,activity_type) VALUE ('2020-11-04 11:22:00','ccc','BIKING');