
package com.hostos.lib.thaismartcard.api;

import java.util.Map;
import javax.smartcardio.Card;

public abstract interface SmartCardServices {

    public abstract Map<Class, Object> getAvialableDataInfo(Card cardManager, boolean paramBoolean)
            throws Exception;

    public abstract LaserNumber getLaserNumber();

    public abstract CID getCID();
}
