package com.jni;

import com.ice.jni.registry.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class RegistryTest {

    private static final String SOFTWARE = "SOFTWARE";

    public static void main(String[] args) throws RegistryException {
        List<String> result = getSubKeyNames("Clients");
        for(String str : result)
            System.out.println(str);
    }

    /**
     * 返回[HKEY_LOCAL_MACHINE\SOFTWARE]下指定节点的所有子节点的名称
     *
     * @param keyName
     * 指定的节点的名称
     * @return
     * @throws NoSuchKeyException
     * @throws RegistryException
     */
    private static List<String> getSubKeyNames(String keyName)
            throws NoSuchKeyException, RegistryException {
        List<String> result = new ArrayList<String>();
        RegistryKey software = Registry.HKEY_LOCAL_MACHINE.openSubKey(SOFTWARE);
        if (keyName != null)
            software = software.openSubKey(keyName);
        @SuppressWarnings("unchecked")
        Enumeration<String> enumeration = software.keyElements();
        for (; enumeration.hasMoreElements();) {
            result.add(enumeration.nextElement());
        }
        return result;
    }
}
