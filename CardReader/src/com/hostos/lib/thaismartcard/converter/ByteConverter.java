
package com.hostos.lib.thaismartcard.converter;

public class ByteConverter implements Converter {

    public Object toObject(byte[] src) {
        return Byte.valueOf(src[0]);
    }
}
