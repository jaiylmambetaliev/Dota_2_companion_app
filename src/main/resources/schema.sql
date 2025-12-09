DROP TABLE IF EXISTS HERO_STATS;
DROP TABLE IF EXISTS HERO;

CREATE TABLE HERO (
                      ID INT PRIMARY KEY,
                      NAME VARCHAR(255) NOT NULL,
                      LOCALIZED_NAME VARCHAR(255),
                      PRIMARY_ATTR VARCHAR(50),
                      ATTACK_TYPE VARCHAR(50),
                      ROLES VARCHAR(500)
);

CREATE TABLE HERO_STATS (
                            ID INT PRIMARY KEY,
                            NAME VARCHAR(255),
                            LOCALIZED_NAME VARCHAR(255),
                            PRIMARY_ATTR VARCHAR(50),
                            ATTACK_TYPE VARCHAR(50),

                            BASE_HEALTH INT,
                            BASE_MANA INT,
                            BASE_ARMOR DOUBLE,
                            BASE_ATTACK_MIN INT,
                            BASE_ATTACK_MAX INT,
                            BASE_STR INT,
                            BASE_AGI INT,
                            BASE_INT INT,

                            MOVE_SPEED INT,
                            ATTACK_RANGE INT,

                            PRO_PICK INT,
                            PRO_WIN INT,
                            TURBO_PICKS INT,
                            TURBO_WINS INT
);