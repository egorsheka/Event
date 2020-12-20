package com.event.prototype.data.converter;

import com.event.prototype.data.enums.EventSortOrder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class EventSortOrderConvertor implements Converter<String, EventSortOrder> {

    @Override
    public EventSortOrder convert(String source) {
        return EventSortOrder.valueOf(source.toUpperCase());
    }
}
