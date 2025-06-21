package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class u {
    private static final java.lang.String a = "SerializeTools";

    private static java.lang.Object a(java.lang.String str) {
        try {
            java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(str.getBytes("ISO-8859-1"));
            java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(byteArrayInputStream);
            java.lang.Object readObject = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return readObject;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static java.lang.String a(java.lang.Object obj) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.flush();
            objectOutputStream.close();
            return new java.lang.String(byteArray, "ISO-8859-1");
        } catch (java.io.IOException unused) {
            return "";
        }
    }
}
