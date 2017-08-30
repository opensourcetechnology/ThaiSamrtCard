
package com.hostos.lib.thaismartcard.converter;

import com.hostos.lib.thaismartcard.model.Name;

public class NameConverter implements Converter {

    public Object toObject(byte[] src) {
        String fullName = new String(src, TIS620).trim();
        String[] names = fullName.split("#");
        if (names.length == 4) {
            return new Name(names[0], names[1], names[2], names[3]);
        }
        return new Name();
    }
}