CREATE TABLE IF NOT EXISTS bubble_sort_request(
  id BIGSERIAL PRIMARY KEY,
  data VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS bubble_sort_result(
  id BIGSERIAL PRIMARY KEY,
  request_id BIGINT NOT NULL,
  data_char CHARACTER(1) NOT NULL,
  data_index INTEGER NOT NULL,
  FOREIGN KEY (request_id) REFERENCES bubble_sort_request(id)
);


