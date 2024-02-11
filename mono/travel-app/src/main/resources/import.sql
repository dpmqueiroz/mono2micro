create sequence travelorder_sequence start with 1 increment by 1;
create sequence flight_sequence start with 1 increment by 1;
create sequence hotel_sequence start with 1 increment by 1;

INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));

INSERT INTO flight(id, travelorderId, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 1, 'GRU', 'BSB');
INSERT INTO flight(id, travelorderId, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 2, 'GYM', 'VCP');
INSERT INTO flight(id, travelorderId, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 3, 'ATL', 'AJU');
INSERT INTO flight(id, travelorderId, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 3, 'JFK', 'MCO');

INSERT INTO hotel(id, travelorderId, nights) VALUES (nextval('hotel_sequence'), 1, 5);
INSERT INTO hotel(id, travelorderId, nights) VALUES (nextval('hotel_sequence'), 2, 3);
INSERT INTO hotel(id, travelorderId, nights) VALUES (nextval('hotel_sequence'), 3, 10);
INSERT INTO hotel(id, travelorderId, nights) VALUES (nextval('hotel_sequence'), 4, 7);
INSERT INTO hotel(id, travelorderId, nights) VALUES (nextval('hotel_sequence'), 5, 30);