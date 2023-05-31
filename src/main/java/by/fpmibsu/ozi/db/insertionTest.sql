INSERT INTO user VALUES
(1, '+375445918769', 'stas315172004@mail.ru', ?, 'Stas', 'Zaycev', '2004-02-05', 'm', 'Belarus', 'Minsk', 'My name is Stas and I like playing guitar', null),
(2, '+375445918768', 'stas315172005@mail.ru', ?, 'Dasha', 'Glovackay', '2004-05-30', 'f', 'Belarus', 'Minsk', 'My name is Dasha', null),
(3, '+375445918767', 'stas315172006@mail.ru', ?, 'Nastya', 'Krech', '2004-02-03', 'f', 'Belarus', 'Minsk', 'My name is Nastya', null),
(4, '+375445918766', 'stas315172007@mail.ru', ?, 'Dasha', 'Vusik', '2004-03-16', 'f', 'Belarus', 'Minsk', 'My name is Dasha and i am dasha', null),
(5, '+375445918765', 'stas315172008@mail.ru', ?, 'Maxim', 'Kinchikov', '2003-06-04', 'm', 'Belarus', 'Minsk', 'My name is Max', null);
INSERT INTO posts VALUES
(1, 1, 'I am being cool', '2023-05-12'),
(2, 1, 'I am being cool', '2023-05-11'),
(3, 2, 'I am being cool', '2023-05-05'),
(4, 2, 'I am being cool', '2023-03-11'),
(5, 3, 'I am being cool', '2023-01-01'),
(6, 4, 'I am being cool', '2023-02-12'),
(7, 5, 'I am being cool', '2023-02-28'),
(8, 5, 'I am being cool', '2023-01-01');
INSERT INTO friends VALUES
(1, '2022-01-01', 1, 5),
(2, '2022-02-01', 1, 4),
(3, '2022-03-01', 1, 3),
(5, '2022-01-01', 5, 1),
(6, '2022-02-01', 4, 1),
(7, '2022-03-01', 3, 1),
(8, '2022-04-01', 2, 1);

INSERT INTO friend_requests VALUES
(1, '2022-01-01', 2, 3),
(2, '2022-02-01', 3, 4),
(3, '2022-03-01', 5, 4),
(4, '2022-04-01', 2, 5);

INSERT INTO messages VALUES
(1, '2022-01-01', 'Hello!', 1, 2),
(2, '2022-01-01', 'Hi!', 2, 1),
(3, '2022-01-01', 'How are you?!', 1, 2),
(4, '2022-01-01', 'Hey!!', 2, 3),
(5, '2022-01-01', 'Hello)))!', 3, 2),
(6, '2022-01-01', 'My name is LOL!', 4, 5);