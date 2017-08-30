
package com.hostos.lib.thaismartcard.converter;

import java.nio.ByteBuffer;

public class JPEGMaker {

    public static ByteBuffer toJPEGByteBuffer(ByteBuffer buff) {
        int startPosition = 0;
        int endPosition = 0;
        buff.limit(buff.capacity());
        while (buff.hasRemaining()) {
            int b1 = buff.get() & 0xFF;

            if (b1 == 255) {
                int b2 = buff.get() & 0xFF;
                if (b2 == 216) {
                    startPosition = buff.position() - 2;
                } else if (b2 == 217) {
                    endPosition = buff.position();
                }
            }
        }

        buff.position(endPosition);
        buff.flip();
        buff.position(startPosition);
        return buff.slice();
    }
}
