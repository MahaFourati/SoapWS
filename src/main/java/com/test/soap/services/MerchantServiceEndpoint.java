package com.test.soap.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.soap.dto.AddressDto;
import com.test.soap.dto.MerchantDto;
import com.test.soap.model.Address;
import com.test.soap.model.Merchant;
import com.test.soap.repository.MerchantRepository;

@Service
public class MerchantServiceEndpoint implements MerchantService {

	@Autowired
	private MerchantRepository merchantRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public MerchantDto find(Integer id) {
		Merchant m = merchantRepository.findOne(id);
		if (m != null) {
			return mapperMerchantDto(m);
		}
		return null;
	}

	@Override
	public List<MerchantDto> list() {
		return merchantRepository.findAll().stream().map(this::mapperMerchantDto).collect(Collectors.toList());
	}

	@Override
	public void save(MerchantDto merchant) {
		Merchant m = mapper.map(merchant, Merchant.class);
		m.setCreateDate(new Date());
		if (!CollectionUtils.isEmpty(merchant.getAddresses())) {
			m.setAddresses(new ArrayList<>());
			merchant.getAddresses().forEach(a -> {
				Address address = mapper.map(a, Address.class);
				address.setMerchant(m);
				m.getAddresses().add(address);
			});
		}

		merchantRepository.save(m);
	}

	@Override
	public void delete(Integer id) {
		merchantRepository.delete(id);
	}

	private MerchantDto mapperMerchantDto(Merchant m) {
		MerchantDto dto = mapper.map(m, MerchantDto.class);
		if (!CollectionUtils.isEmpty(m.getAddresses())) {
			dto.setAddresses(new ArrayList<>());
			m.getAddresses().forEach(a -> dto.getAddresses().add(mapper.map(a, AddressDto.class)));
		}
		return dto;

	}
}
