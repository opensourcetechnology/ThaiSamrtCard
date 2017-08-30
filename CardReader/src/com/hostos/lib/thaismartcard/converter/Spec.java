
package com.hostos.lib.thaismartcard.converter;

import java.lang.reflect.Method;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Spec {

    private byte[][] apduCommands;
    private Method settingMethod;

    public Spec(String rawCommand, Method settingMethod) {
        String[] eachApdu = rawCommand.split(":");
        if (eachApdu.length == 1) {
            this.apduCommands = new byte[1][];
            parseCommand(this.apduCommands, rawCommand, 0);
        } else {
            this.apduCommands = new byte[eachApdu.length][];
            for (int i = 0; i < eachApdu.length; i++) {
                parseCommand(this.apduCommands, eachApdu[i], i);
            }
        }
        this.settingMethod = settingMethod;
    }

    private void parseCommand(byte[][] _apduCommands, String rawCommand, int row) throws NumberFormatException {
        String[] split = rawCommand.trim().split(" ");
        byte[] apdu = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            byte parseByte = (byte) Integer.parseInt(split[i], 16);
            apdu[i] = parseByte;
        }
        _apduCommands[row] = apdu;
    }

    public Method getSettingMethod() {
        return this.settingMethod;
    }

    public void setSettingMethod(Method settingMethod) {
        this.settingMethod = settingMethod;
    }

    public byte[][] getApduCommands() {
        return this.apduCommands;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Spec other = (Spec) obj;
        if ((this.settingMethod != other.settingMethod) && ((this.settingMethod == null) || (!this.settingMethod.equals(other.settingMethod)))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.settingMethod != null ? this.settingMethod.hashCode() : 0);
        return hash;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
