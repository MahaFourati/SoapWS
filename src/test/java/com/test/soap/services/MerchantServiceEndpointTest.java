package com.test.soap.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.test.soap.dto.AddressDto;
import com.test.soap.dto.MerchantDto;
import com.test.soap.model.Address;
import com.test.soap.model.Merchant;
import com.test.soap.repository.MerchantRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class MerchantServiceEndpointTest {

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	private MerchantServiceEndpoint endpoint;

	@Mock
	private MerchantRepository merchantRepository;

	@Mock
	private Mapper mapper;

	@Test
	public void testFind() {
		Merchant m = new Merchant();
		when(merchantRepository.findOne(1)).thenReturn(m);
		when(mapper.map(m, MerchantDto.class)).thenReturn(new MerchantDto());
		MerchantDto dto = endpoint.find(1);
		assertNotNull(dto);
	}

	@Test
	public void testFind_with_address() {
		// TODO to verify
		Merchant m = new Merchant();
		Address a = new Address();
		m.setAddresses(Arrays.asList(a));
		when(merchantRepository.findOne(1)).thenReturn(m);
		when(mapper.map(m, MerchantDto.class)).thenReturn(new MerchantDto());
		when(mapper.map(a, AddressDto.class)).thenReturn(new AddressDto());
		MerchantDto dto = endpoint.find(1);
		assertNotNull(dto.getAddresses());
	}

	@Test
	public void testFind_not_found() {
		Merchant m = new Merchant();
		when(merchantRepository.findOne(1)).thenReturn(null);
		when(mapper.map(m, MerchantDto.class)).thenReturn(new MerchantDto());
		MerchantDto dto = endpoint.find(1);
		assertNull(dto);
	}

	@Test
	public void testList() {
		List<Merchant> list = new ArrayList<>();
		Merchant dto = new Merchant();
		dto.setId(2);
		dto.setLastname("llll");
		dto.setName("kkk");
		dto.setCreateDate(new Date());
		list.add(dto);
		when(merchantRepository.findAll()).thenReturn(list);
		when(mapper.map(dto, MerchantDto.class)).thenReturn(new MerchantDto());
		List<MerchantDto> dtos = endpoint.list();
		assertNotNull(dtos);
		assertEquals(1, dtos.size());
	}

	@Test
	public void testSave() {
		try {
			MerchantDto dto = new MerchantDto();
			when(mapper.map(dto, Merchant.class)).thenReturn(new Merchant());
			endpoint.save(dto);
		} catch (Exception e) {
			fail("Should not be failed");
		}
	}

	@Test
	public void testSave_with_adress() {
		MerchantDto dto = new MerchantDto();
		AddressDto address = new AddressDto();
		address.setNumber(15);
		address.setStreet("rue vv");
		address.setZipcode("92400");
		dto.setAddresses(Arrays.asList(address));
		when(mapper.map(dto, Merchant.class)).thenReturn(new Merchant());
		when(mapper.map(address, Address.class)).thenReturn(new Address());
		try {
			endpoint.save(dto);
		} catch (Exception e) {
			fail("Should not be failed");
		}
	}

	@Test
	public void testDelete() {
		try {
			endpoint.delete(1);
		} catch (Exception e) {
			fail("Should not be failed");
		}
	}

}
