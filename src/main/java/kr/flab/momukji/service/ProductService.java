package kr.flab.momukji.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.flab.momukji.entity.Product;
import kr.flab.momukji.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

}
