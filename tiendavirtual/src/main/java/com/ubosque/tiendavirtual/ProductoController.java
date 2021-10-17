package com.ubosque.tiendavirtual;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ubosque.DAO.ProductoDAO;
import com.ubosque.DTO.Productos;

@RestController
@ComponentScan(basePackages = { "com.ubosque.DAO" })
@RequestMapping("/productos")
public class ProductoController {

	@RequestMapping("listar")
	public ArrayList<Productos> listarProductos() {
		ProductoDAO productosDAO = new ProductoDAO();
		return productosDAO.listarProductos();
	}

	@RequestMapping("listar/{codigo_producto}")
	public ArrayList<Productos> listarProducto(@PathVariable("codigo_producto") int codigo_producto) {
		ProductoDAO productosDAO = new ProductoDAO();
		return productosDAO.listarProducto(codigo_producto);
	}

	@PutMapping("actualizar/{codigo_producto}")
	public void updateProducto(@PathVariable("codigo_producto") int codigo_producto, @RequestBody Productos productos) {
		ProductoDAO productosDAO = new ProductoDAO();
		productosDAO.updateProduct(productos);
	}

	@DeleteMapping("eliminar/{codigo_producto}")
	public void deleteProducto(@PathVariable("codigo_producto") int codigo_producto) {
		ProductoDAO productosDAO = new ProductoDAO();
		productosDAO.deleteProduct(codigo_producto);
	}

	@PostMapping("guardar")
	public int agregarProducto(@RequestParam("file") MultipartFile file) throws IOException {
		int contador2 = 0;
		if (file != null) {
			ProductoDAO p = new ProductoDAO();
			p.deleteAllProduct();
			
			java.nio.file.Path productos = Paths.get("src//main//resources//documentosCSV");
			String ruta = productos.toFile().getAbsolutePath();
			file.transferTo(new File(ruta + "//" + file.getOriginalFilename()));
			BufferedReader csvReader = new BufferedReader(new FileReader(ruta + "//" + file.getOriginalFilename()));

			String row;
			int contador = 0;

			while ((row = csvReader.readLine()) != null) {
				if (contador == 0) {
					contador++;
				} else {
					contador2++;
					Productos producto = new Productos();

					String[] data = row.split(",");
					producto.setCodigoProducto(Integer.parseInt(data[0].replaceAll("\"", "")));
					producto.setNombreProducto(data[1].replaceAll("\"", ""));
					producto.setNitProveedor(Integer.parseInt(data[2].replaceAll("\"", "")));
					producto.setPrecioCompra(Double.parseDouble(data[3].replaceAll("\"", "")));
					producto.setIvaCompra(Double.parseDouble(data[4].replaceAll("\"", "")));
					producto.setPrecioVenta(Double.parseDouble(data[5].replaceAll("\"", "")));
					ProductoDAO productoDAO = new ProductoDAO();

					productoDAO.createProduct(producto);
				}
			}
			csvReader.close();
		}else {
			System.out.println("No se a cargado correctamente el archivo! ");
		}
		return contador2;
	}
}
