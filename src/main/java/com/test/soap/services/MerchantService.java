package com.test.soap.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.test.soap.dto.MerchantDto;

@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface MerchantService {

	@WebMethod
	public MerchantDto find(Integer id);

	@WebMethod
	public List<MerchantDto> list();

	@WebMethod
	public void save(MerchantDto merchant);

	@WebMethod
	public void delete(Integer id);
}
