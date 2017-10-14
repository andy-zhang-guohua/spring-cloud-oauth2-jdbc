insert into users VALUE ('admin','admin',1);
insert into authorities VALUE ('admin','管理员');
INSERT INTO auth.oauth_client_details
(client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES ('web', 'user,auth', 'web_secret', 'user_read,user_write', 'password', '', 'read,write', 3600, 3600, '{}', 'user_read,user_write');