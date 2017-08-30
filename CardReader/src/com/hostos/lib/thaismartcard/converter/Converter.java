/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostos.lib.thaismartcard.converter;

import java.nio.charset.Charset;

public abstract interface Converter {

    public static final Charset TIS620 = Charset.forName("TIS-620");
    public static final Charset DEFAULT = Charset.defaultCharset();

    public abstract Object toObject(byte[] paramArrayOfByte);
}

