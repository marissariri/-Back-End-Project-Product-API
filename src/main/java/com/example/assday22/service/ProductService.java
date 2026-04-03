package com.example.assday22.service;

import com.example.assday22.dto.ProductRequest;
import com.example.assday22.entity.Product;
import com.example.assday22.exception.CustomException;
import com.example.assday22.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());
        product.setStock(request.getStock());

        return productRepository.save(product);
    }

    public Product editProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomException("Product tidak ditemukan"));

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());
        product.setStock(request.getStock());

        return productRepository.save(product);
    }

    public Product updateStock(Long id, Integer soldQty) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomException("Product tidak ditemukan"));

        if (product.getStock() == 0) {
            throw new CustomException("Stock sudah habis");
        }

        if (product.getStock() - soldQty < 0) {
            throw new CustomException("Stock tidak mencukupi");
        }

        product.setStock(product.getStock() - soldQty);

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomException("Product tidak ditemukan"));

        productRepository.delete(product);
    }
}
