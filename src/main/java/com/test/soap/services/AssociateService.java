package com.test.soap.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.test.soap.dto.AssociateDto;

@WebService
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface AssociateService {

	@WebMethod
	public void associate(AssociateDto associateDto);
}
