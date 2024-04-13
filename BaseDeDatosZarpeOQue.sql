
# Se crea la base de datos 
drop schema if exists ZarpeOQue;
CREATE SCHEMA ZarpeOQue ;

#Se crea un usuario para la base de datos llamado "Admin" y tiene la contraseña "Admin404."
create user 'Admin'@'%' identified by 'Admin404';

#Se asignan los prvilegios sobr ela base de datos ZarpeOQue al usuario creado
grant all privileges on ZarpeOQue.* to 'Admin'@'%';
flush privileges;

# la tabla de categoria contiene categorias de productos
create table ZarpeOQue.categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  PRIMARY KEY (id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table ZarpeOQue.producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  descripcion VARCHAR(30) NOT NULL,  
  detalle VARCHAR(1600) NOT NULL, 
  precio_bruto double,
  precio_neto double,
  existencias int,  
  ruta_imagen varchar(1024),
  PRIMARY KEY (id_producto),
  foreign key fk_producto_categoria (id_categoria) references categoria(id_categoria)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO ZarpeOQue.categoria (descripcion, ruta_imagen) VALUES
("categoria ejemplo 1", "ruta/elsapo.jpg"),
("categoria ejemplo 2", "ruta/labota.jpg"),
("categoria ejemplo 3", "ruta/elzapato.jpg"); 

INSERT INTO ZarpeOQue.producto (id_categoria, descripcion, detalle, precio_bruto, precio_neto, existencias, ruta_imagen) 
VALUES 
(1, 'Camisa', 'Camiseta de algodón de color blanco', 20.50, 15.99, 50, 'ruta/camiseta.jpg'),
(2, 'Pantalón', 'Pantalón vaquero azul de corte recto', 35.75, 29.99, 30, 'ruta/pantalon.jpg'),
(1, 'Tenis', 'Tenis deportivas blancas y rojas', 45.00, 39.99, 20, 'ruta/tenis.jpg');


# select * from zarpeoque.producto;