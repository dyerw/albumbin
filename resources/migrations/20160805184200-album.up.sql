CREATE TABLE albums
(id VARCHAR(100) PRIMARY KEY,
 user VARCHAR(100) REFERENCES users(id),
 musicbrainzid VARCHAR(30),
 posted TIME);
