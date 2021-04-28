package com.test.soap.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.soap.dto.AssociateDto;
import com.test.soap.exception.SoapWsException;
import com.test.soap.model.AffectationProduit;
import com.test.soap.model.AffectationProduitId;
import com.test.soap.model.Merchant;
import com.test.soap.model.Product;
import com.test.soap.repository.AssociateRepository;
import com.test.soap.repository.MerchantRepository;
import com.test.soap.repository.ProductRepository;

@Service
public class AssociateServiceEndpoint implements AssociateService {

	@Autowired
	private AssociateRepository associateRepository;
	@Autowired
	private MerchantRepository merchantRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void associate(AssociateDto dto) {
		Merchant m = merchantRepository.findOne(dto.getMerchantId());
		if (m == null) {
			throw new SoapWsException("Merchant Id not found");
		}
		Product p = productRepository.findOne(dto.getProductId());
		if (p == null) {
			throw new SoapWsException("Product Id not found");
		}
		AffectationProduit af = new AffectationProduit();
		af.setCreateDate(new Date());
		AffectationProduitId afi = new AffectationProduitId();
		afi.setMerchant(m);
		afi.setProduct(p);
		af.setId(afi);
		associateRepository.save(af);
	}
}
