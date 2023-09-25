package com.example.Product.Management.Controller;

import com.example.Product.Management.Dto.ProductDto;
import com.example.Product.Management.Exception.ErrorDetails;
import com.example.Product.Management.Exception.UserNotFoundException;
import com.example.Product.Management.Model.Product;
import com.example.Product.Management.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/getProduct")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        //productService.deleteProduct(id);
         return  new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product,@PathVariable Integer id){
        return new ResponseEntity<>(productService.editProd(product,id), HttpStatus.CREATED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlesUserNotFoundException(UserNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }
}
