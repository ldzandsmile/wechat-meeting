package com.ldz.utils;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateConverter implements Converter<String, Date> {
    private static final String[] PATTERNS = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "HH:mm:ss", "yyyy-MM-dd HH:mm"};
    @Override
    public Date convert(String s) {
    	System.out.println("ss");
        if(!StringUtils.isBlank(s)) {
            try {
                return DateUtils.parseDateStrictly(s, PATTERNS);
            } catch (Exception e) {
            }
        }
        return null;
    }
}