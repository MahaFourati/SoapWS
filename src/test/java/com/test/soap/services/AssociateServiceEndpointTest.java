package com.test.soap.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.soap.config.DataConfig;
import com.test.soap.dto.AssociateDto;
import com.test.soap.model.Merchant;
import com.test.soap.model.Product;
import com.test.soap.repository.AssociateRepository;
import com.test.soap.repository.MerchantRepository;
import com.test.soap.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class AssociateServiceEndpointTest {

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	private AssociateServiceEndpoint endpoint;

	@Mock
	private AssociateRepository associateRepository;

	@Mock
	private MerchantRepository merchantRepository;

	@Mock
	private ProductRepository productRepository;

	@Test
	public void testAssociate() throws Exception {
		AssociateDto dto = new AssociateDto();
		dto.setMerchantId(1);
		dto.setProductId(1);
		when(merchantRepository.findOne(1)).thenReturn(new Merchant());
		when(productRepository.findOne(1)).thenReturn(new Product());
		try {
			endpoint.associate(dto);
		} catch (Exception e) {
			fail("should be passed");
		}

	}

	@Test
	public void testAssociate_merchant_not_found() {
		AssociateDto dto = new AssociateDto();
		dto.setMerchantId(1);
		dto.setProductId(1);
		when(merchantRepository.findOne(1)).thenReturn(null);
		try {
			endpoint.associate(dto);
			fail("should throw exception");
		} catch (Exception e) {
			assertEquals("Merchant Id not found", e.getMessage());
		}
	}

	@Test
	public void testAssociate_product_not_found() {
		AssociateDto dto = new AssociateDto();
		dto.setMerchantId(1);
		dto.setProductId(1);
		when(merchantRepository.findOne(1)).thenReturn(new Merchant());
		when(productRepository.findOne(1)).thenReturn(null);
		try {
			endpoint.associate(dto);
			fail("should throw exception");
		} catch (Exception e) {
			assertEquals("Product Id not found", e.getMessage());
		}
	}
}