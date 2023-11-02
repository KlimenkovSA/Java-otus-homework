CREATE TABLE public.tests (
	id int4 NOT NULL, -- id
	test_name varchar NOT NULL DEFAULT 4000, -- название теста
	CONSTRAINT tests_pk PRIMARY KEY (id),
	CONSTRAINT tests_un UNIQUE (test_name)
);
COMMENT ON TABLE public.tests IS 'Тесты : номер теста, название теста';

-- Column comments

COMMENT ON COLUMN public.tests.id IS 'id';
COMMENT ON COLUMN public.tests.test_name IS 'название теста';


CREATE TABLE public.questions (
	id int4 NOT NULL, -- id
	question varchar NOT NULL DEFAULT 4000, -- текст вопроса
	quest_id int4 NOT NULL, -- связка с таблицей tests
	CONSTRAINT questions_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.questions IS 'Вопросы ( id, текст вопроса, связка с таблицей tests )';

-- Column comments

COMMENT ON COLUMN public.questions.id IS 'id';
COMMENT ON COLUMN public.questions.question IS 'текст вопроса';
COMMENT ON COLUMN public.questions.quest_id IS 'связка с таблицей tests';


-- public.questions foreign keys

ALTER TABLE public.questions ADD CONSTRAINT questions_fk FOREIGN KEY (quest_id) REFERENCES public.tests(id);

CREATE TABLE public.answers (
	id int4 NOT NULL, -- id
	answer_is varchar NOT NULL DEFAULT 4000, -- текст ответа
	"y/n" bpchar(1) NOT NULL, -- флаг ответа
	ans_id int4 NOT NULL, -- связка с таблицей question
	CONSTRAINT answers_pk PRIMARY KEY (id)
);
COMMENT ON TABLE public.answers IS 'ответы: (id ,текст ответа,флаг ответа, связка с таблицей question )';

-- Column comments

COMMENT ON COLUMN public.answers.id IS 'id';
COMMENT ON COLUMN public.answers.answer_is IS 'текст ответа';
COMMENT ON COLUMN public.answers."y/n" IS 'флаг ответа';
COMMENT ON COLUMN public.answers.ans_id IS 'связка с таблицей question';


-- public.answers foreign keys

ALTER TABLE public.answers ADD CONSTRAINT answers_fk FOREIGN KEY (ans_id) REFERENCES public.questions(id);