package items.handlers;

import org.modelmapper.AbstractConverter;

public class StringToObjectConvertor extends AbstractConverter<String, Object> {
    @Override
    protected Object convert(String source) {
        return JsonHandler.convertJsonStringToObject(source, Object.class);
    }
}