package com.bun.miitmdid.d;

/* loaded from: classes.dex */
public class a {
    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            java.io.InputStream open = context.getAssets().open(str);
            int available = open.available();
            byte[] bArr = new byte[available];
            open.read(bArr);
            open.close();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr, 0, available);
            return byteArrayOutputStream.toString();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
