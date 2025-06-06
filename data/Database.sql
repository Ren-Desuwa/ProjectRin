CREATE TABLE blocks (
    block_id INTEGER PRIMARY KEY AUTOINCREMENT,
    block_type TEXT NOT NULL,
    page_id INTEGER,
    order_index INTEGER,
    previous_block_id INTEGER,
    next_block_id INTEGER,
    foreign key (page_id) references pages(page_id) ON DELETE SET NULL,
    foreign key (previous_block_id) references blocks(block_id) ON DELETE SET NULL,
    foreign key (next_block_id) references blocks(block_id) ON DELETE SET NULL
);

CREATE TABLE notes (
    note_id INTEGER PRIMARY KEY,
    block_id INTEGER,
    content TEXT NOT NULL,
    FOREIGN KEY (block_id) REFERENCES blocks(block_id) ON DELETE CASCADE
);

CREATE TABLE pages (
    page_id PRIMARY KEY,
    block_id INTEGER,
    page_title TEXT NOT NULL,
    FOREIGN KEY (block_id) REFERENCES blocks(block_id) ON DELETE CASCADE
);