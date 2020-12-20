package com.event.prototype.config;

import com.event.prototype.data.enums.SortOrder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class SortOrderConvertor implements Converter<String, SortOrder> {

    @Override
    public SortOrder convert(String source) {
        return SortOrder.valueOf();
    }
}
