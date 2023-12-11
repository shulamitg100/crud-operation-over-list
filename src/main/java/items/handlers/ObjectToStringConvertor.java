package items.handlers;

import org.modelmapper.AbstractConverter;

public class ObjectToStringConvertor extends AbstractConverter<Object, String> {
    @Override
    protected String convert(Object source) {
        return JsonHandler.convertObjectToJsonString(source);
    }
}