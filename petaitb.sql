CREATE EXTENSION postgis;

CREATE TABLE IF NOT EXISTS gedung(
id SERIAL,
nama VARCHAR(30),
geom geometry,
PRIMARY KEY (id)
);

INSERT INTO gedung (nama, geom) VALUES 
('SBM', 'POLYGON((88 585, 102 585, 102 588, 188 588, 188 602, 171 602, 171 609, 176 624, 154 624, 159 609, 159 602, 88 602, 88 585))'),
('Labtek 7', 'POLYGON((320 363, 399 363, 399 349, 420 349, 420 359, 428 360, 428 363, 431 363, 431 394, 320 394, 320 363))'),
('Labtek 6', 'POLYGON((187 363, 303 363, 303 394, 187 394, 187 363))'),
('Labtek 5', 'POLYGON((192 317, 303 317, 303 349, 192 349, 192 317))'),
('Labtek 8', 'POLYGON((320 317, 431 317, 431 349, 320 349, 320 317))'),
('Ex MKOR', 'POLYGON((104 568, 192 568, 192 577, 180 577, 180 579, 104 579, 104 568))'),
('Bengkel', 'POLYGON((101 493, 122 492, 122 496, 137 496, 137 506, 149 506, 149 513, 80 513, 80 506, 101 506, 101 493))'),
('Lab Metlurgi', 'POLYGON((76 442, 151 442, 151 484, 76 484, 76 442))'),
('Labtek 2', 'POLYGON((74 394, 148 394, 148 419, 129 419, 129 411, 113 411, 113 439, 74 439, 74 394))'),
('Lab Radar', 'POLYGON((71 337, 106 337, 106 351, 71 351, 71 337))'),
('Lab Konversi', 'POLYGON((123 303, 188 303, 188 327, 123 327, 123 303))'),
('Pengembangan SDA', 'POLYGON((168 223, 223 223, 223 237, 168 237, 168 223))'),
('T Sipil','MULTIPOLYGON(((137 173, 224 173, 224 187, 137 187, 137 173)),((123 195, 224 195, 224 210, 123 210, 123 195)))'),
('BSC A', 'POLYGON((70 224, 112 224, 112 234, 70 234, 70 224))'),
('GKU Barat', 'POLYGON((125 341, 146 341, 148 343, 150 341, 156 347, 153 349, 156 353, 156 371, 153 375, 156 377, 150 382, 148 379, 146 382, 125 382, 122 379, 121 382, 115 377, 118 375, 115 371, 114 353, 118 349, 115 347, 121 341, 122 343, 125 341),(132 354, 140 354, 143 359, 143 366, 140 371, 132 371, 127 366, 127 359, 132 354))'),
('Labtek 3', 'POLYGON((104 518, 147 518, 147 534, 137 534, 137 548, 162 548, 162 563, 88 563, 88 548, 104 548, 104 542, 80 542, 80 528, 104 528, 104 518),(111 534, 132 534, 132 548, 111 548, 111 534))'),
('Fisika','MULTIPOLYGON(((124 214, 162 214, 162 229, 124 229, 124 214)),((128 232, 164 232, 164 237, 128 237, 128 232)), ((224 240, 224 286, 173 286, 172 290, 170 290, 170 294, 132 294, 119 284, 119 251, 129 251, 129 240, 224 240), (147 258, 213 258, 213 274, 147 274, 147 258)))'),
('Ex GSG', 'POLYGON((215 536, 230 536, 230 539, 242 539, 246 544, 246 586, 242 590, 230 590, 230 592, 215 592, 215 590, 203 590, 199 586, 199 544, 203 539, 215 539, 215 536))'),
('Gedung Riset dan Inovasi', 'POLYGON((255 543, 291 543, 291 603, 288 603, 288 607, 284 607, 284 611, 247 611, 248 595, 255 595, 255 543))'),
('Perpustakaan Pusat', 'POLYGON((339 555, 347 548, 359 548, 359 544, 370 544, 370 548, 382 555, 382 567, 386 568, 386 584, 375 584, 375 595, 368 604, 353 604, 353 606, 342 606, 342 605, 338 605, 333 600, 333 585, 327 585, 327 571, 339 571, 339 555))'),
('Labtek 10','MULTIPOLYGON(((165 483, 245 483, 245 511, 226 511, 226 525, 186 525, 200 511, 165 511, 165 483)),((230 517, 238 517, 238 525, 230 525, 230 517)))'),
('Labtek 11','MULTIPOLYGON(((192 426, 203 426, 202 438, 245 438, 245 468, 222 468, 222 483, 179 483, 179 468, 165 468, 165 438, 192 438, 192 426)),((165 426, 177 426, 177 436, 165 436, 165 426)))'),
('PLN','POLYGON((329 443, 375 443, 379 447, 379 462, 374 468, 337 468, 324 455, 324 448, 329 443))'),
('Comlabs','POLYGON((336 482, 375 482, 379 486, 379 503, 376 506, 379 509, 379 521, 335 521, 327 512, 326 494, 336 482))'),
('Oktagon','POLYGON((272 480, 280 480, 285 485, 288 484, 293 489, 290 491, 297 497, 297 504, 290 510, 293 513, 288 518, 285 516, 280 521, 272 521, 267 516, 262 518, 258 513, 260 510, 254 504, 254 497, 260 491, 258 489, 262 485, 267 487, 272 480))'),
('TVST','POLYGON((265 432, 269 429, 281 429, 286 433, 284 437, 290 443, 292 439, 298 443, 298 456, 292 460, 290 456, 284 462, 286 466, 281 471, 269 471, 265 466, 269 462, 263 456, 258 460, 254 456, 254 443, 258 439, 263 443, 269 437, 265 432))'),
('Labtek 1', 'MULTIPOLYGON(((387 420, 430 420, 430 440, 387 440, 387 420)), ((384 440, 430 440, 430 511, 384 511, 384 440)))'),
('CC Barat','POLYGON((299 261, 299 285, 235 285, 235 261, 299 261))'),
('CC Timur','POLYGON((383 261, 383 285, 324 285, 324 261, 383 261))'),
('Ruang UKM','POLYGON((256 261, 240 261, 240 216, 256 216, 256 261))'),
('Information Center','POLYGON((307 262, 315 262, 319 266, 319 274, 315 278, 307 278, 303 274, 303 266, 307 262))'),
('Aula Barat','POLYGON((269 133, 219 133, 219 147, 207 147, 207 160, 231 160, 231 165, 224 165, 224 170, 258 170, 258 165, 269 165, 269 133))'),
('ATM Center', 'POLYGON((331 162, 331 190, 365 190, 365 196, 326 196, 326 162, 331 162))'),
('9009','POLYGON((367 183, 394 183, 394 200, 367 200, 367 183))'),
('Aula Timur','POLYGON((353 133, 402 133, 402 142, 422 142, 422 165, 399 165, 399 171, 360 171, 360 167, 353 167, 353 133))'),
('Seni Rupa', 'MULTIPOLYGON(((452 138, 481 152, 481 190, 461 190, 461 182, 451 182, 451 193, 405 193, 405 181, 403 181, 403 174, 420 174, 426 156, 452 156, 452 138)), ((457 197, 457 212, 406 212, 406 197, 457 197)))'),
('Labtek 9A','POLYGON((400 230, 458 230, 458 250, 400 250, 400 230))'),
('Labtek 9B','POLYGON((461 230, 509 230, 509 250, 461 250, 461 230))'),
('Labtek 9C','POLYGON((458 197, 509 197, 509 212, 458 212, 458 197))'),
('Mushola Bundar','POLYGON((455 215, 460 215, 464 219, 464 224, 460 227, 455 227, 451 224, 451 219, 455 215))'),
('Teknik Lingkungan', 'POLYGON((400 263, 469 263, 469 261, 477 261, 477 265, 504 265, 504 284, 413 284, 413 289, 400 289, 400 263))'),
('GKU Timur','POLYGON((477 351, 497 351, 497 355, 533 355, 533 374, 477 374, 477 351))'),
('Lab Doping','POLYGON((449 300, 497 300, 497 345, 449 345, 449 300))');

CREATE TABLE IF NOT EXISTS zona
(nama_zona varchar(20),
 geom_zona geometry,
 PRIMARY KEY (nama_zona));

INSERT INTO zona (nama_zona, geom_zona) VALUES 
('Zona Tengah', 'POLYGON((191 315, 189.5 354.5, 182.5 362.5, 183.5 399, 252 399, 252 527, 382 527, 382 394.5, 438 396.5, 438 315, 191 315))'),
('Zona Barat', 'POLYGON((227 172, 227 297.5, 190.5 301.5, 189 314, 187.5 384.5, 156.5 389.5, 157.5 542.5, 192.5 562.5, 197 629.5, 134.5 628.5, 79 604, 60 174.5, 227 172))'),
('Zona Timur', 'POLYGON((446 131.5, 446 150.5, 425.5 150.5, 424.5 169, 401 169, 400.5 207, 393.5 209, 393 292.5, 501.5 293.5, 504.5 354.33, 542 352, 531 250, 512 192.5, 485.5 176.5, 482 134.5, 446 131.5))'),
('Zona Timur Jauh', 'POLYGON((452.5 374, 466.5 374, 466.5 379.5, 476.5 380.5, 476.5 376.5, 539 377, 574 573, 451 579.5, 447 404, 447 374, 452.5 374))'),
('Zona Labtek Biru', 'POLYGON((162 420.5, 162 527, 246 527, 246 420.5, 162 420.5))');

CREATE TABLE IF NOT EXISTS fasilitas(
id SERIAL,
nama_fasilitas VARCHAR(30),
geom geometry,
PRIMARY KEY (id)
);

INSERT INTO fasilitas (nama_fasilitas, geom) VALUES 
('Toilet', 'POINT(229 334)'),
('Toilet', 'POINT(225 376)'),
('Toilet', 'POINT(373 365)'),
('Toilet', 'POINT(414 342)'), 
('Toilet', 'POINT(347 491)'),
('Toilet', 'POINT(262 511)'),
('Toilet', 'POINT(265 457)'),
('Toilet', 'POINT(350 600)'), 
('Toilet', 'POINT(276 579)'),
('Toilet', 'POINT(155 596)'),
('Toilet', 'POINT(213 501)'),
('Toilet', 'POINT(205 453)'), 
('Toilet', 'POINT(151 354)'),
('Toilet', 'POINT(243 275)'),
('Toilet', 'POINT(365 276)'),
('Toilet', 'POINT(516 369)'), 
('Toilet', 'POINT(331 152)'),
('Mushola', 'POINT(219 344)'),
('Mushola', 'POINT(426 340)'), 
('Mushola', 'POINT(522 365)'),
('Mushola', 'POINT(369 512)'),
('Mushola', 'POINT(122 368)'),
('Mushola', 'POINT(168 598)'), 
('Mushola', 'POINT(240 267)'),
('Mushola', 'POINT(84 417)'),
('Kantin Borju', 'POINT(195 323)'),
('Kantin GKU Barat', 'POINT(149 367)'), 
('Coffee Toffee', 'POINT(212 460)'),
('Kantin Kebab', 'POINT(182 462)'),
('Kantin Oktagon', 'POINT(291 498)'),
('Kantin GKU Timur', 'POINT(481 355)'), 
('Kantin CC Barat', 'POINT(267 279)'),
('Kantin CC Timur', 'POINT(358 269)'),
('KKP', 'POINT(328 178)');

CREATE TABLE IF NOT EXISTS question(
id SERIAL references gedung(id),
no_q SERIAL,
pertanyaan VARCHAR(140),
PRIMARY KEY (no_q)
);

INSERT INTO question (id, pertanyaan) VALUES 
('4','Ruang 7602 ada di mana?'),
('15','Gedung rancangan Ir. Soekarno bernama?'),
('24','Tempat aktivasi AI3 ada di mana?'),
('6','Apa nama gedung yang ada TOKEMA nya?'),
('28','Lembaga Kemahasiswaan ada di mana?'),
('34','Bioskop kampus biasa diselenggarakan di mana?'),
('30','Sekre KPA ada di mana?'),
('5','Laboratorium Telematika ada di gedung apa?'),
('19','Apa bangunan tertinggi di ITB Ganesha?'),
('42','BNI dalam kampus Ganesha ada di gedung apa?');