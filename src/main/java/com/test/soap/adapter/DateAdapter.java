package com.test.soap.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.cxf.common.util.StringUtils;

public class DateAdapter extends XmlAdapter<String, Date> {

	private static final String DATE_FORMAT = "dd/MM/yyyy";

	@Override
	public Date unmarshal(String v) throws Exception {
		if (StringUtils.isEmpty(v)) {
			return null;
		}
		return new SimpleDateFormat(DATE_FORMAT).parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		if (v == null) {
			return null;
		}
		return new SimpleDateFormat(DATE_FORMAT).format(v);
	}

}
