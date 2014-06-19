CREATE EXTENSION postgis;

CREATE TABLE IF NOT EXISTS wilayah
(nama_wilayah varchar(20),
 geom_wilayah geometry,
 PRIMARY KEY (nama_wilayah));

INSERT INTO wilayah (nama_wilayah, geom_wilayah) VALUES 
('Bojonegara', 'POLYGON((986 854, 990 1132, 962 1138, 950 1374, 830 1562, 844 1660, 870 1676, 852 1694, 888 1868, 926 1938, 876 1968, 882 2020, 762 1742, 588 1622, 514 1384, 572 1282, 444 1324, 290 1306, 537 909, 986 854'),
('Tegallega', 'POLYGON((190 714, 220 774, 411 672, 474.5 990.5, 544 901, 986 850, 976 617, 1013 617, 1130 289, 863 249, 593 290,364 488, 190 714))'),
('Karees', 'POLYGON((1122 319, 1103 617, 976 617, 986 850, 1176 822, 1731 1106, 1799 1100, 1790 1055, 1666 1041, 1669 908, 1771 786, 1776 639, 1731 642, 1708 560, 1242 452, 1250 398, 1225 384, 1162 384, 1122 319))'),
('Gede Bage', 'POLYGON((1112 288, 1164 384, 1208 396, 1226 378, 1254 392, 1242 446, 1708 552, 1734 636, 1776 640, 1784 732, 2390 542, 2294 702, 2352 830, 2454 826, 2474 508, 2582 476, 2584 398, 2616 384, 2626 274, 2576 210, 2356 158, 2018 188, 1813 200, 1646 232, 1112 288))'),
('Cibeunying', 'POLYGON((986 850, 1176 822, 1731 1106, 1873 1351, 1845 1373, 1651 1176, 1591 1218, 1676 1351, 1566 1260, 1470 1306, 1415 1318, 1149 1877, 995 1726, 944 1788, 976 1961, 892 1961, 933 1935, 833 1563, 954 1365, 961 1138, 998 1134, 986 850))'),
('Ujung Berung', 'POLYGON((1784 732, 2390 542, 2294 702, 2352 830, 2454 826, 2474 508, 2582 476, 2749 830, 2764 972, 2894 1145, 2697 1224, 2564 1106, 2552 1291, 2421 1239, 2403 1048, 2264 1066, 2288 1094, 2085 1282, 2003 1230, 1912 1254, 1945 1360, 1760 1112, 1806 1100, 1791 1051, 1673 1048, 1703 875, 1784 732))');

CREATE TABLE IF NOT EXISTS wisata(
id INT,
nama_wisata VARCHAR(30),
geom_wisata geometry,
kategori VARCHAR(20),
alamat VARCHAR(50),
PRIMARY KEY (id)
);

INSERT INTO wisata (id, nama_wisata, geom_wisata, kategori, alamat) VALUES 
(1, 'Kebun Binatang Bandung', 'POINT(229 334)', 'FloraFauna', 'Jln. Taman Sari'),
(2, 'Tahura', 'POINT(225 376)', 'FloraFauna', 'Dago Pakar'),
(3, 'Wahana Wisata Gunung Puntang', 'POINT(225 376)', 'FloraFauna', 'Desa Puntang, Kec. Cimaung Kabupaten Bandung'),
(4, 'Taman Kupu-kupu', 'POINT(229 334)', 'FloraFauna', 'Jln. Cihanjuang Cibaligo Km 3 No 58'),
(5, 'Wisata Bunga Cihideung', 'POINT(225 376)', 'FloraFauna', 'Desa Cihideung, Kec. Parompong'),
(6, 'Curug Dago', 'POINT(225 376)', 'Air Terjun', 'Kampung Curug Dago, Kec. Cidadap Bandung'),
(7, 'Gedung Merdeka dan Museum KAA', 'POINT(225 376)', 'GedungTua', 'Jln. Asia Afrika'),
(8, 'AACC (Majestic)', 'POINT(225 376)', 'GedungTua', 'Braga'),
(9, 'Saung Angklung Udjo', 'POINT(225 376)', 'Budaya', 'Jln. Padasuka 118 Kota Bandung'),
(10, 'Taman Budaya Dago', 'POINT(225 376)', 'Budaya', 'Jln. Bukit Dago Selatan Kota Bandung');