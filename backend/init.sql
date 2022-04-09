CREATE TABLE IF NOT EXISTS area (
                                    id INTEGER PRIMARY KEY,
                                    name VARCHAR(200)
    );





CREATE TABLE IF NOT EXISTS employer (
                                        id INTEGER PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    date_create DATE NOT NULL DEFAULT CURRENT_DATE,
    description TEXT,
    area_id INTEGER,
    comment VARCHAR(255),
    viewsCount INTEGER default 0,
    FOREIGN KEY (area_id) REFERENCES area(id)
    );

CREATE TABLE IF NOT EXISTS vacancy (
                                       id INTEGER PRIMARY KEY,
                                       name varchar,
                                       date_create DATE NOT NULL DEFAULT CURRENT_DATE,
                                       area_id INTEGER,
                                       salary_from INTEGER,
                                       salary_to INTEGER,
                                       salary_gross bool,
                                       currency varchar(5),
                                       createdAt DATE,
    employer_id INTEGER,
    viewsCount INTEGER,
    comment varchar(255),
    FOREIGN KEY (area_id) REFERENCES area(id),
    FOREIGN KEY (employer_id) REFERENCES employer(id)

    )