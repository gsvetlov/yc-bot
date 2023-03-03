CREATE TABLE `updates/bot_updates`
(
    `bot_id_msb` Int64 NOT NULL, -- most significant bits of bot UUID
    `bot_id_lsb` Int64 NOT NULL, -- least significant bits of bot UUID
    `update_id` Int64 NOT NULL, -- UNIX timestamp in milliseconds
    `type` Int32, -- update type integer value
    `chat_uid` Utf8, -- chat uuid if applicable
    `user_uid` Utf8, -- user uuid if applicable
    `update` Json, -- update payload
    PRIMARY KEY (`bot_id_msb`, `bot_id_lsb`, `update_id`)
);