package com.test.soap.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.soap.config.DataConfig;
import com.test.soap.dto.ProductDto;
import com.test.soap.model.Product;
import com.test.soap.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class ProductServiceEndpointTest {

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	private ProductServiceEndpoint endpoint;

	@Mock
	private ProductRepository productRepository;

	@Mock
	private Mapper mapper;

	@Test
	public void testFind() throws Exception {
		Product p = new Product();
		when(productRepository.findOne(1)).thenReturn(p);
		when(mapper.map(p, ProductDto.class)).thenReturn(new ProductDto());
		ProductDto dto = endpoint.find(1);
		assertNotNull(dto);
	}

	@Test
	public void testList() throws Exception {
		List<Product> list = new ArrayList<>();
		Product dto = new Product();
		dto.setId(2);
		dto.setCurrency("EUR");
		dto.setLabel("label");
		dto.setCreateDate(new Date());
		list.add(dto);
		when(productRepository.findAll()).thenReturn(list);
		when(mapper.map(dto, ProductDto.class)).thenReturn(new ProductDto());
		List<ProductDto> dtos = endpoint.list();
		assertNotNull(dtos);
		assertEquals(1, dtos.size());
	}

	@Test
	public void testSave() throws Exception {
		try {
			ProductDto dto = new ProductDto();
			dto.setId(3);
			dto.setCurrency("EUR");
			dto.setLabel("label");
			dto.setCreateDate(new Date());
			when(mapper.map(dto, Product.class)).thenReturn(new Product());
			endpoint.save(dto);
		} catch (Exception e) {
			fail("Should not be failed");
		}
	}

	@Test
	public void testDelete() throws Exception {
		try {
			endpoint.delete(1);
		} catch (Exception e) {
			fail("Should not be failed");
		}
	}
}