CREATE TABLE t_user (
    id bigint PRIMARY KEY,
    username varchar(40) UNIQUE
);

CREATE TABLE chat (
      id bigint PRIMARY KEY
);

CREATE TABLE chat_message (
      message_id int NOT NULL,
      chat_id bigint REFERENCES chat(id) ON DELETE NO ACTION NOT NULL ,
      user_id bigint REFERENCES t_user(id) ON DELETE NO ACTION NOT NULL ,
      text text NOT NULL,
      date timestamp NOT NULL,
      PRIMARY KEY (chat_id, message_id)
);