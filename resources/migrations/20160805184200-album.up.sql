CREATE TABLE albums
(id VARCHAR(100) PRIMARY KEY,
 userid VARCHAR(100) REFERENCES users(id),
 musicbrainzid VARCHAR(30),
 review VARCHAR(1000), 
 posted TIME);
