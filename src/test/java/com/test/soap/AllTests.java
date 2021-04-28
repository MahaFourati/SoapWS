package com.test.soap;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.test.soap.adapter.DateAdapterTest;
import com.test.soap.services.AssociateServiceEndpointTest;
import com.test.soap.services.MerchantServiceEndpointTest;
import com.test.soap.services.ProductServiceEndpointTest;

@RunWith(Suite.class)
@SuiteClasses({ DateAdapterTest.class, AssociateServiceEndpointTest.class, MerchantServiceEndpointTest.class,
		ProductServiceEndpointTest.class })
public class AllTests {

}
