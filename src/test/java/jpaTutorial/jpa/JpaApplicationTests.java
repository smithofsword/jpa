package jpaTutorial.jpa;

import jpaTutorial.jpa.entities.ProductEntity;
import jpaTutorial.jpa.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	ProductRepository productRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = ProductEntity.builder().
				sku("nestle1324").
				price(BigDecimal.valueOf(234)).
				title("NEstle coco").
				quantity(13)
				.build();

		ProductEntity saved=productRepository.save(productEntity);
		System.out.println(saved);
	}

}
