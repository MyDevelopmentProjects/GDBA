INSERT INTO `role` (`id`, `date_created`, `date_updated`, `name`) VALUES
(1, '2017-04-23 05:26:12', NULL, 'USER'),
(2, '2017-04-23 05:26:12', NULL, 'ADMIN');


INSERT INTO `user` (`id`, `date_created`, `date_updated`, `is_active`, `email`, `first_name`, `last_name`, `password`, `phone_number`, `user_name`, `role_id`) VALUES
(2, '2017-04-23 05:50:21', NULL, b'1', 'mjaniko@gmail.com', 'Mikheil', 'Janiashvili', '$2a$10$R.CiPGwEFxyol7OMPvDAren0t8zYwa7FH49hVZqCeZ9fQaouGOEG6', '593474004', 'mjaniko', 2),
(3, '2017-04-25 18:11:34', NULL, b'1', 'mjaniko@gmail.com', 'Vasho', 'Vashakidze', '$2a$10$qnGG0qleVGvVbiERLvGQDe8dk/s8PzVx1CipRieuzHeqhpH.ao7VO', '593474004', 'butquchuna', 1);