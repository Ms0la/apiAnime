CREATE TABLE IF NOT EXISTS anime (
    animeid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name text,
    description text,
    type text,
    year smallint,
    imageurl text);

;

INSERT INTO anime(name, description, type, year, imageurl) VALUES
    ('Mushishi','Ginko se dedica a investigar a los mushis en sus viajes','TV', 2005, 'https://images.mubicdn.net/images/film/153182/cache-133623-1587132044/image-w1280.jpg?size=1200x'),
    ('Evangelion','Niño lloron, llora mucho y muy fuerte mientras pelea en un robot gigante y se masturba','TV', 1995, 'https://images.mubicdn.net/images/film/154627/cache-146791-1611262868/image-w1280.jpg?size=1200x'),
    ('Berserk','Un puto chad reparte espadazos en un mundo medieval en el que todo son violaciones','TV', 1997, 'https://images.mubicdn.net/images/film/178494/cache-245510-1502335231/image-w1280.jpg?size=1200x'),
    ('Inicial D','Niño coche brum brum manda a tomar por culo a furcia','TV', 1998, 'https://i.ytimg.com/vi/yK3-cgVejaw/maxresdefault.jpg'),
    ('GTO','Se le hinchan los huevos a un profe mafioso y pues acontecen eventos','TV', 1999, 'https://images.mubicdn.net/images/film/255010/cache-505973-1579403203/image-w1280.jpg?size=1200x');

