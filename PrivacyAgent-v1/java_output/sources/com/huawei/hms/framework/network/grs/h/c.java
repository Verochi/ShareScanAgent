package com.huawei.hms.framework.network.grs.h;

/* loaded from: classes22.dex */
public class c {
    private static final java.lang.String a = "c";

    public static java.lang.String a(java.lang.String str, android.content.Context context) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.InputStream inputStream = null;
        try {
            try {
                if (!new java.io.File(str).isDirectory()) {
                    inputStream = context.getAssets().open(str);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            byteArrayOutputStream.flush();
                            return new java.lang.String(byteArrayOutputStream.toByteArray(), "UTF-8");
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
            } catch (java.io.IOException unused) {
                com.huawei.hms.framework.common.Logger.w(a, "local config file is not exist.filename is {%s}", str);
            }
            return "";
        } finally {
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) byteArrayOutputStream);
            com.huawei.hms.framework.common.IoUtils.closeSecure(inputStream);
        }
    }
}
