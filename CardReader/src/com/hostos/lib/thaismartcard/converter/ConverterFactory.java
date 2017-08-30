
package com.hostos.lib.thaismartcard.converter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.hostos.lib.thaismartcard.model.Name;

public class ConverterFactory {
    private Map<Class, Converter> map;

    public ConverterFactory() {
        this.map = new HashMap();
        
        this.map.put(String.class, new StringConverter());
        this.map.put(Name.class, new NameConverter());
        this.map.put(byte[].class, new ByteArrayConverter());
        this.map.put(byte.class, new ByteConverter());
        
        this.map = Collections.synchronizedMap(this.map);
    }
    
    public Converter getConverter(Class clazz) {
        return (Converter)this.map.get(clazz);
    }
}
