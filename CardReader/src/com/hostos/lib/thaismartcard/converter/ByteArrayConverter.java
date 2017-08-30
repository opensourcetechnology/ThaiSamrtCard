
package com.hostos.lib.thaismartcard.converter;

import java.nio.ByteBuffer;

public class ByteArrayConverter implements Converter {

    public Object toObject(byte[] src) {
        ByteBuffer buff = ByteBuffer.wrap(src);
        buff = JPEGMaker.toJPEGByteBuffer(buff);
        byte[] b = new byte[buff.limit() - buff.position()];
        buff.get(b, 0, b.length);
        
        return b;
    }
}
