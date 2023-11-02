CREATE TABLE public.tests (
	id int4 NOT NULL,                                 id
	test_name varchar NOT NULL,                       название теста
	CONSTRAINT tests_pk PRIMARY KEY (id),
	CONSTRAINT tests_un UNIQUE (test_name)
);


CREATE TABLE public.questions (
	id int4 NOT NULL,                                  id
	question varchar NOT NULL DEFAULT 4000,            текст вопроса
	quest_id int4 NOT NULL,                            поле для связки с таблицей tests
	CONSTRAINT questions_pk PRIMARY KEY (id)
);


-- public.questions foreign keys

ALTER TABLE public.questions ADD CONSTRAINT questions_fk FOREIGN KEY (quest_id) REFERENCES public.tests(id);

CREATE TABLE public.answers (
	id int4 NOT NULL,                                 id
	answer_is varchar NOT NULL DEFAULT 4000,          текст ответа
	"y/n" bpchar(1) NOT NULL,                         флаг ответа
	ans_id int4 NOT NULL,                             поле для связки с таблицей question
	CONSTRAINT answers_pk PRIMARY KEY (id)
);


-- public.answers foreign keys

ALTER TABLE public.answers ADD CONSTRAINT answers_fk FOREIGN KEY (ans_id) REFERENCES public.questions(id);