CREATE TABLE public.tests (
	id int4 NOT NULL,
	test_name int4 NOT NULL DEFAULT 4000,
	CONSTRAINT tests_pk PRIMARY KEY (id)
);

CREATE TABLE public.questions (
	id_q int4 NOT NULL,
	quest_numb int4 NOT NULL,
	question varchar NULL DEFAULT 4000,
	id_tests int4 NULL,
	CONSTRAINT questions_pk PRIMARY KEY (id_q)
);


-- public.questions foreign keys

ALTER TABLE public.questions ADD CONSTRAINT questions_fk FOREIGN KEY (id_tests) REFERENCES public.tests(id);

CREATE TABLE public.answers (
	id_ans int4 NOT NULL,
	answer_is varchar NULL,
	"y/n" bpchar(1) NULL,
	id_quest int4 NULL,
	CONSTRAINT answers_pk PRIMARY KEY (id_ans)
);


-- public.answers foreign keys

ALTER TABLE public.answers ADD CONSTRAINT answers_fk FOREIGN KEY (id_quest) REFERENCES public.questions(id_q);