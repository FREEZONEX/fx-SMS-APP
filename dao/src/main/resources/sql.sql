 use sms;

create table local_message(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message_content varchar(500) not null ,
    status varchar(20) not null default 'NEW',
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp
)