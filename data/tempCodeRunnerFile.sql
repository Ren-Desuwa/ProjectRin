CREATE TABLE blocks (
    block_id INTEGER PRIMARY KEY AUTOINCREMENT,
    block_type TEXT NOT NULL,
    before_block_id INTEGER,
    next_block_id INTEGER,
    foreign key (before_block_id) references blocks(id),
    foreign key (next_block_id) references blocks(id),
);

CREATE TABLE notes (
    note_id INTEGER PRIMARY KEY,
    content TEXT NOT NULL,
    FOREIGN KEY (note_id) REFERENCES blocks(id)
);

CREATE TABLE pages (
    page_id INTEGER PRIMARY KEY,
    page_title TEXT NOT NULL,
    content TEXT,
    FOREIGN KEY (page_id) REFERENCES blocks(id)
);