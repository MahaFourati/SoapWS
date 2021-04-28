package com.test.soap.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.test.soap.dto.ProductDto;

@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ProductService {

	@WebMethod
	public ProductDto find(Integer id);

	@WebMethod
	public List<ProductDto> list();

	@WebMethod
	public void save(ProductDto merchant);

	@WebMethod
	public void delete(Integer id);
}
