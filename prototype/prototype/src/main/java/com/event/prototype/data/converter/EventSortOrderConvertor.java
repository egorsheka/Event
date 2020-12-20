package com.event.prototype.data.converter;

import com.event.prototype.data.enums.SortOrder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class EventSortOrderConvertor implements Converter<String, SortOrder> {

    @Override
    public SortOrder convert(String source) {
        return SortOrder.valueOf(source.toUpperCase());
    }
}
