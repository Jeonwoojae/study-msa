package com.example.chapter03.domain.format;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatter implements Formatter<Date> {

    private SimpleDateFormat sdf;

//    인자를 받아 멤버 변수에 객체 할당
    public DateFormatter(String pattern) {
        if (StringUtils.isEmpty(pattern))
            throw new IllegalArgumentException("Pattern is empty");

        this.sdf = new SimpleDateFormat(pattern);
    }

    @Override
//    설정된 패턴으로 변환하여 문자열로 리턴하는 메소드
    public String of(Date target) {
        return sdf.format(target);
    }

    public Date parse(String dateString) throws ParseException {
        return sdf.parse(dateString);
    }
}
