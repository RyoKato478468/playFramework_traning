
# --- !Ups

insert into t_user values(
1,
'firstUser',
2,
192,
'バナナ',
TIMESTAMP'1999-05-25 14:35:00',
TIMESTAMP'2020-05-25 14:35:00',
TIMESTAMP'2020-05-25 14:35:00'
),
(
2,
'secondUser',
3,
168,
'ケーキ',
TIMESTAMP'1989-02-25 14:35:00',
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP()
),
(
3,
'thirdUser',
4,
205,
'プリン',
TIMESTAMP'1999-08-25 14:35:00',
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP()
);

# --- !Downs

delete from t_user