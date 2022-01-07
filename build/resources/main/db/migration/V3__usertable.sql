CREATE TABLE animeuser (
    userid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    username varchar(24) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    role varchar(10),
    enabled boolean DEFAULT true
  );


  CREATE EXTENSION IF NOT EXISTS pgcrypto;
  INSERT INTO animeuser (username, password) VALUES ('user', crypt('pass', gen_salt('bf')));