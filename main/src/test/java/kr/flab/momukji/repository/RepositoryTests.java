package kr.flab.momukji.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import kr.flab.momukji.entity.Category;
import kr.flab.momukji.entity.Order;
import kr.flab.momukji.entity.Product;
import kr.flab.momukji.entity.Region;
import kr.flab.momukji.entity.Store;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class RepositoryTests {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveAndfindById_RegionCategoryStoreProductUserOrder() {
        Region region = regionRepository.save(Region.builder().name("지역").build());
        assertEquals(region, regionRepository.findById(region.getId()).get());
        
        Category category = categoryRepository.save(Category.builder().name("카테고리").build());
        assertEquals(category, categoryRepository.findById(category.getId()).get());
        
        Store store = storeRepository.save(Store.builder()
            .info(null)
            .region(region)
            .category(category)
            .name("상점 이름")
            .isOpen(false)
            .deleted(false)
            .build()
        );
        assertEquals(store, storeRepository.findById(store.getId()).get());

        Product product = productRepository.save(Product.builder()
            .store(store)
            .name("상품 이름")
            .price(10000L)
            .deleted(false)
            .build()
        );
        assertEquals(product, productRepository.findById(product.getId()).get());

        Set<Product> products = new HashSet<>();
        products.add(product);

        Order order = orderRepository.save(Order.builder()
            .userId("userId")
            .store(store)
            .status(0L)
            .isDelivery(true)
            .message(null)
            .estimatedMinutes(null)
            .products(products)
            .build()
        );
        assertEquals(order, orderRepository.findById(order.getId()).get());
    }
}
