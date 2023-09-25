package com.example.Product.Management.Service;

import com.example.Product.Management.Dto.ProductDto;
import com.example.Product.Management.Model.Product;

import java.util.List;

public interface ProductService {

   public ProductDto save(ProductDto product);

   public List<Product> getAllProduct();

   public Product getProductById(Integer id);

   public String  deleteProduct(Integer id);

public  Product editProd(Product product,Integer id);
}
