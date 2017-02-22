
DROP TABLE IF EXISTS userinfo;
CREATE TABLE userinfo (
    id INT IDENTITY(1,1) PRIMARY KEY
  , username VARCHAR(60) NOT NULL
  , password VARCHAR(255) NOT NULL
  , firstname VARCHAR(60) NOT NULL
  , lastname VARCHAR(40) NOT NULL
  , enabled INT
  , last_password_reset_date DATE
);

DROP TABLE IF EXISTS authority;
CREATE TABLE authority (
    id INT IDENTITY(1,1) PRIMARY KEY
  , name VARCHAR(60) NOT NULL
);

DROP TABLE IF EXISTS userinfo_authority;
CREATE TABLE userinfo_authority (
    id INT IDENTITY(1,1) PRIMARY KEY
  , userinfo_id INT NOT NULL
  , authority_id INT NOT NULL
  , CONSTRAINT FK_USERINFO_1 FOREIGN KEY (userinfo_id) REFERENCES userinfo (id)
  , CONSTRAINT FK_AUTHORITY_2 FOREIGN KEY (authority_id) REFERENCES authority(id)
);