package com.test.soap.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateAdapterTest {

	private DateAdapter createTestSubject() {
		return new DateAdapter();
	}

	@Test
	public void testUnmarshal_null() throws Exception {
		DateAdapter testSubject;
		String v = "";

		// default test
		testSubject = createTestSubject();
		Date result = testSubject.unmarshal(v);
		assertNull(result);
	}

	@Test
	public void testUnmarshal() throws Exception {
		DateAdapter testSubject;
		String v = "01/01/2021";

		// default test
		testSubject = createTestSubject();
		Date result = testSubject.unmarshal(v);
		assertNotNull(result);
	}

	@Test
	public void testMarshal() throws Exception {
		DateAdapter testSubject;
		Calendar v = Calendar.getInstance();
		v.set(2021, 0, 1);

		// default test
		testSubject = createTestSubject();
		String result = testSubject.marshal(v.getTime());
		assertNotNull(result);
		assertEquals("01/01/2021", result);
	}

	@Test
	public void testMarshal_null() throws Exception {
		DateAdapter testSubject;
		Date v = null;

		// default test
		testSubject = createTestSubject();
		String result = testSubject.marshal(v);
		assertNull(result);
	}
}