
package com.hostos.lib.thaismartcard.converter;

public class StringConverter implements Converter {

    public Object toObject(byte[] src) {
        return new String(src, TIS620).trim();
    }
}
