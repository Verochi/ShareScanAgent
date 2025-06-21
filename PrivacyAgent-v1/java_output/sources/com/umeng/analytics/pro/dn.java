package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class dn extends com.umeng.analytics.pro.dp {
    protected java.io.InputStream a;
    protected java.io.OutputStream b;

    public dn() {
        this.a = null;
        this.b = null;
    }

    public dn(java.io.InputStream inputStream) {
        this.b = null;
        this.a = inputStream;
    }

    public dn(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        this.a = inputStream;
        this.b = outputStream;
    }

    public dn(java.io.OutputStream outputStream) {
        this.a = null;
        this.b = outputStream;
    }

    @Override // com.umeng.analytics.pro.dp
    public int a(byte[] bArr, int i, int i2) throws com.umeng.analytics.pro.dq {
        java.io.InputStream inputStream = this.a;
        if (inputStream == null) {
            throw new com.umeng.analytics.pro.dq(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new com.umeng.analytics.pro.dq(4);
        } catch (java.io.IOException e) {
            throw new com.umeng.analytics.pro.dq(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.dp
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.dp
    public void b() throws com.umeng.analytics.pro.dq {
    }

    @Override // com.umeng.analytics.pro.dp
    public void b(byte[] bArr, int i, int i2) throws com.umeng.analytics.pro.dq {
        java.io.OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new com.umeng.analytics.pro.dq(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (java.io.IOException e) {
            throw new com.umeng.analytics.pro.dq(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.dp
    public void c() {
        java.io.InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            this.a = null;
        }
        java.io.OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
            this.b = null;
        }
    }

    @Override // com.umeng.analytics.pro.dp
    public void d() throws com.umeng.analytics.pro.dq {
        java.io.OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new com.umeng.analytics.pro.dq(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (java.io.IOException e) {
            throw new com.umeng.analytics.pro.dq(0, e);
        }
    }
}
