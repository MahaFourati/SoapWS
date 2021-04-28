package com.test.soap.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.soap.dto.ProductDto;
import com.test.soap.model.Product;
import com.test.soap.repository.ProductRepository;

@Service
public class ProductServiceEndpoint implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public ProductDto find(Integer id) {
		return mapper.map(productRepository.findOne(id), ProductDto.class);
	}

	@Override
	public List<ProductDto> list() {
		return productRepository.findAll().stream().map(p -> mapper.map(p, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public void save(ProductDto productDto) {
		Product p = mapper.map(productDto, Product.class);
		p.setCreateDate(new Date());
		productRepository.save(p);

	}

	@Override
	public void delete(Integer id) {
		productRepository.delete(id);
	}

}
