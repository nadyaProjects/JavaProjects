CREATE TABLE SONG(
        ID BIGINT  PRIMARY KEY AUTO_INCREMENT,
        SONG_NAME VARCHAR(255),
        DATE_OF_RELEASE DATE,
        LENGTH_OF_SONG INT,
        ARTIST VARCHAR(255)
        );