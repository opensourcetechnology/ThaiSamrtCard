
package com.hostos.lib.thaismartcard.converter;

import com.hostos.lib.thaismartcard.model.MoiApplet1Info;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SpecPropertyReader {

    private static Properties prop;
    private static SpecPropertyReader INSTANCE;

    public static SpecPropertyReader getInstance()
            throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new SpecPropertyReader();
            INSTANCE.init();
        }
        return INSTANCE;
    }

    public void init() throws IOException {
        prop = new Properties();
        prop.load(SpecPropertyReader.class.getResourceAsStream("field.properties"));
    }

    public List<Spec> getSpecs(Class clazz) {
        List specList = new ArrayList();
        String fieldProps = prop.getProperty(clazz.getSimpleName());
        String[] fieldMaps = fieldProps.split(",");
        for (String fieldMap : fieldMaps) {
            fieldMap = fieldMap.trim();
            String[] fieldNames = fieldMap.split("=");
            String name = fieldNames[0];
            String rawAPDU = fieldNames[1];
            try {
                Method[] methods = clazz.getMethods();
                Method method = findMatchMethod(methods, name);
                Spec spec = new Spec(rawAPDU, method);
                specList.add(spec);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return specList;
    }

    public Method findMatchMethod(Method[] methods, String name) {
        String methodname = "set" + toUpperCaseMethodName(name);
        for (Method method : methods) {
            if (methodname.equals(method.getName())) {
                return method;
            }
        }
        throw new RuntimeException("Not found method name=" + methodname + " please check your's config file 'field.properties'");
    }

    private String toUpperCaseMethodName(String name) {
        String smallPart = name.substring(1, name.length());
        String firstPart = name.substring(0, 1).toUpperCase();
        return firstPart + smallPart;
    }
}