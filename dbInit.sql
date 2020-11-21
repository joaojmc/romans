CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO territory (id, name, square_kilometers)
VALUES ('9a0e49bf-5df6-4229-abe3-116de2f588b0', 'Rome', null)
ON CONFLICT DO NOTHING;

INSERT INTO person (dtype, id, adopted, cause_of_death, date_of_birth, date_of_death, name, biography,
                    date_of_abdication, date_of_crowning, maximum_army_size, most_notable_conflict, most_notable_law,
                    birthplace_id, place_of_death_id)
VALUES ('Emperor', '237293fd-b5e4-4de6-819a-92a47e34cd6d', true, 'Stabbed', '0063-09-23 BC', '0014-08-19',
        'Caesar Augustus',
        'Caesar Augustus was the first Roman emperor',
        '0014-08-19', '0027-01-16 BC', null, null, null, '9a0e49bf-5df6-4229-abe3-116de2f588b0',
        '9a0e49bf-5df6-4229-abe3-116de2f588b0')
ON CONFLICT DO NOTHING;

INSERT INTO person (dtype, id, adopted, cause_of_death, date_of_birth, date_of_death, name, biography,
                    date_of_abdication, date_of_crowning, maximum_army_size, most_notable_conflict, most_notable_law,
                    birthplace_id, place_of_death_id)
VALUES ('Emperor', '0e3d9ed9-ba92-410b-b07b-0df501f58e1d', false, 'Stabbed', '0100-06-12 BC', '0044-05-15 BC',
        'Gaius Julius Caesar',
        'Gaius Julius Caesar as a Roman general and statesman who played a critical role in the events that led to the demise of the Roman Republic and the rise of the Roman Empire.',
        null, null, null, null, null, '9a0e49bf-5df6-4229-abe3-116de2f588b0',
        '9a0e49bf-5df6-4229-abe3-116de2f588b0')
ON CONFLICT DO NOTHING;

INSERT INTO person (dtype, id, adopted, cause_of_death, date_of_birth, date_of_death, name, biography,
                    date_of_abdication, date_of_crowning, maximum_army_size, most_notable_conflict, most_notable_law,
                    birthplace_id, place_of_death_id)
VALUES ('Person', '664a5771-79ce-48a8-8985-6f44262768c1', false, null, '0076-01-01 BC', null,
        'Calpurnia ',
        'Calpurnia was either the third or the fourth wife of Julius Caesar, and the one to whom he was married at the time of his assassination.',
        null, null, null, null, null, '9a0e49bf-5df6-4229-abe3-116de2f588b0',
        '9a0e49bf-5df6-4229-abe3-116de2f588b0')
ON CONFLICT DO NOTHING;

INSERT INTO person_wives (person_id, wives_id)
VALUES ('0e3d9ed9-ba92-410b-b07b-0df501f58e1d', '664a5771-79ce-48a8-8985-6f44262768c1')
ON CONFLICT DO NOTHING;