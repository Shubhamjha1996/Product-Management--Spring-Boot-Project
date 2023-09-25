package com.example.Product.Management.Mapper;

import com.example.Product.Management.Dto.ProductDto;
import com.example.Product.Management.Model.Product;

public class ProductMapper {

    public static ProductDto ConvertObjectEntityToDto(Product product) {
        ProductDto productDto = new ProductDto(product.getId()
                , product.getName(), product.getType(), product.getStatus(), product.getPrice());

        return productDto;
    }

    public static Product ConvertDtoToEntity(ProductDto productDto1) {
        Product product = new Product(productDto1.getId(),
                productDto1.getName(), productDto1.getType(), productDto1.getStatus(), productDto1.getPrice());

        return product;
    }
}
