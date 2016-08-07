-- :name create-user! :! :n
-- :doc creates a new user record
INSERT INTO users
(id, username, email, password)
VALUES (:id, :username, :email, :password)

-- :name update-user! :! :n
-- :doc update an existing user record
UPDATE users
SET first_name = :first_name, last_name = :last_name, email = :email
WHERE id = :id

-- :name get-user :? :1
-- :doc retrieve a user given the id.
SELECT * FROM users
WHERE id = :id

-- :name get-user-by-email :? :1
-- :doc retrieve a user given the email
SELECT * FROM users
WHERE email = :email

-- :name delete-user! :! :n
-- :doc delete a user given the id
DELETE FROM users
WHERE id = :id

-- :name create-album! :! :n
-- :doc creates a new album record
INSERT INTO users
(id, userid, musicbrainzid, review, posted)
VALUES (:id, :userid, :musicbrainzid, :review, :posted)

