package com.sensorsdata.sf.core.http.internal;

/* loaded from: classes19.dex */
public class ResponseBody {
    java.lang.String body = "";
    public int code;
    long contentLength;
    java.io.InputStream errorStream;
    java.io.InputStream inputStream;

    private byte[] inputStream2Byte(java.io.InputStream inputStream) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return new byte[0];
        }
    }

    private java.lang.String inputStream2String(java.io.InputStream inputStream) {
        try {
            return new java.lang.String(inputStream2Byte(inputStream));
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public java.lang.String body() {
        java.io.InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            return inputStream2String(inputStream);
        }
        java.io.InputStream inputStream2 = this.errorStream;
        return inputStream2 != null ? inputStream2String(inputStream2) : this.body;
    }

    public byte[] bytes() {
        java.io.InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            return inputStream2Byte(inputStream);
        }
        java.io.InputStream inputStream2 = this.errorStream;
        return inputStream2 != null ? inputStream2Byte(inputStream2) : new byte[0];
    }

    public java.lang.String toString() {
        return "ResponseBody{code = " + this.code + "，message = " + this.body + com.alipay.sdk.m.u.i.d;
    }
}
