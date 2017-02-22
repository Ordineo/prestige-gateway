INSERT INTO userinfo (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ENABLED, last_password_reset_date) VALUES ('Nivek', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 1, GETDATE ());
INSERT INTO userinfo (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ENABLED, last_password_reset_date) VALUES ('RyDg', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'admin', 'admin', 1, GETDATE ());
INSERT INTO userinfo (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ENABLED, last_password_reset_date) VALUES ('PhDa', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'admin', 'admin', 1, GETDATE ());
INSERT INTO userinfo (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ENABLED, last_password_reset_date) VALUES ('Test', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'admin', 'admin', 1, GETDATE ());
INSERT INTO userinfo (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ENABLED, last_password_reset_date) VALUES ('Joris', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'admin', 'admin', 1, GETDATE ());

INSERT INTO authority (NAME) VALUES ('ROLE_USER');
INSERT INTO authority (NAME) VALUES ('ROLE_ADMIN');


INSERT INTO client_authority (userinfo_id, AUTHORITY_ID) VALUES ((SELECT id FROM userinfo where username='Nivek'), (SELECT id FROM authority where name='ROLE_USER'));
--RyDg
INSERT INTO client_authority (userinfo_id, AUTHORITY_ID) VALUES ((SELECT id FROM userinfo where username='RyDg'), (SELECT id FROM authority where name='ROLE_USER'));
INSERT INTO client_authority (userinfo_id, AUTHORITY_ID) VALUES ((SELECT id FROM userinfo where username='RyDg'), (SELECT id FROM authority where name='ROLE_ADMIN'));
--PhDa
INSERT INTO client_authority (userinfo_id, AUTHORITY_ID) VALUES ((SELECT id FROM userinfo where username='PhDa'), (SELECT id FROM authority where name='ROLE_USER'));
INSERT INTO client_authority (userinfo_id, AUTHORITY_ID) VALUES ((SELECT id FROM userinfo where username='PhDa'), (SELECT id FROM authority where name='ROLE_ADMIN'));
--Test
INSERT INTO client_authority (userinfo_id, AUTHORITY_ID) VALUES ((SELECT id FROM userinfo where username='Test'), (SELECT id FROM authority where name='ROLE_USER'));
INSERT INTO client_authority (userinfo_id, AUTHORITY_ID) VALUES ((SELECT id FROM userinfo where username='Test'), (SELECT id FROM authority where name='ROLE_ADMIN'));
--Joris
INSERT INTO client_authority (userinfo_id, AUTHORITY_ID) VALUES ((SELECT id FROM userinfo where username='Joris'), (SELECT id FROM authority where name='ROLE_USER'));
INSERT INTO client_authority (userinfo_id, AUTHORITY_ID) VALUES ((SELECT id FROM userinfo where username='Joris'), (SELECT id FROM authority where name='ROLE_ADMIN'));
