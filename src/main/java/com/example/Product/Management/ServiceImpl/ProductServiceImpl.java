package com.example.Product.Management.ServiceImpl;

import com.example.Product.Management.Dto.ProductDto;
import com.example.Product.Management.Exception.UserNotFoundException;
import com.example.Product.Management.Mapper.ProductMapper;
import com.example.Product.Management.Model.Product;
import com.example.Product.Management.Repository.ProductRepository;
import com.example.Product.Management.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    private ModelMapper modelMapper;

    public ProductServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto save(ProductDto product) {

        Product product1=modelMapper.map(product,Product.class);

        //dto to entity
       // Product product1= ProductMapper.ConvertDtoToEntity(product);

        Product savedProduct= productRepository.save(product1);
        //entity to dto

       // ProductDto productDto=ProductMapper.ConvertObjectEntityToDto(savedProduct);

        ProductDto productDto=modelMapper.map(savedProduct,ProductDto.class);
        return productDto;

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        Product product=productRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("Product","id",id)
        );
        //return productRepository.findById(id).get();
        return product;
    }

    @Override
    public String deleteProduct(Integer id) {
        Product prod = productRepository.findById(id).get();
        if (prod != null) {
            productRepository.delete(prod);
            return "Product deleted";
        }
        return "Something wrong";
    }

    @Override
    public Product editProd(Product p, Integer id) {

        Product oldPro = productRepository.findById(id).get();
        System.out.println("id==" + oldPro);
        if (oldPro != null) {
            oldPro.setName(p.getName());
            oldPro.setStatus(p.getStatus());
            oldPro.setType(p.getType());
            oldPro.setPrice(p.getPrice());
            return productRepository.save(oldPro);
        }

        return null;
    }
}
