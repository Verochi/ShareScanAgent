package com.getui.gtc.dyc;

/* loaded from: classes22.dex */
public class h implements java.io.Serializable {
    private java.lang.String a;
    private long c;
    private java.lang.String d;
    private java.lang.String e;
    private java.util.Map<java.lang.String, java.lang.String> f;

    public static com.getui.gtc.dyc.h e(java.lang.String str) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.ObjectInputStream objectInputStream;
        try {
            try {
                objectInputStream = new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().decrypt(android.util.Base64.decode(str.getBytes(), 0))));
                try {
                    com.getui.gtc.dyc.h hVar = (com.getui.gtc.dyc.h) objectInputStream.readObject();
                    com.getui.gtc.base.util.io.IOUtils.safeClose(objectInputStream);
                    return hVar;
                } catch (java.io.IOException e) {
                    e = e;
                    com.getui.gtc.dyc.a.a.a.a(e);
                    com.getui.gtc.base.util.io.IOUtils.safeClose(objectInputStream);
                    return null;
                } catch (java.lang.ClassNotFoundException e2) {
                    e = e2;
                    com.getui.gtc.dyc.a.a.a.a(e);
                    com.getui.gtc.base.util.io.IOUtils.safeClose(objectInputStream);
                    return null;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.getui.gtc.base.util.io.IOUtils.safeClose(null);
                throw th;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            objectInputStream = null;
            com.getui.gtc.dyc.a.a.a.a(e);
            com.getui.gtc.base.util.io.IOUtils.safeClose(objectInputStream);
            return null;
        } catch (java.lang.ClassNotFoundException e4) {
            e = e4;
            objectInputStream = null;
            com.getui.gtc.dyc.a.a.a.a(e);
            com.getui.gtc.base.util.io.IOUtils.safeClose(objectInputStream);
            return null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            com.getui.gtc.base.util.io.IOUtils.safeClose(null);
            throw th;
        }
    }

    public java.lang.String a() {
        return this.a;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(java.lang.String str) {
        this.a = str;
    }

    public void a(java.util.Map<java.lang.String, java.lang.String> map) {
        this.f = map;
    }

    public long c() {
        return this.c;
    }

    public void c(java.lang.String str) {
        this.e = str;
    }

    public java.lang.String d() {
        return this.e;
    }

    public void d(java.lang.String str) {
        this.d = str;
    }

    public java.lang.String e() {
        return this.d;
    }

    public java.util.Map<java.lang.String, java.lang.String> f() {
        return this.f;
    }

    public java.lang.String g() throws java.lang.Throwable {
        java.io.ObjectOutputStream objectOutputStream;
        java.io.IOException e;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new java.io.ObjectOutputStream(byteArrayOutputStream);
            try {
                try {
                    objectOutputStream.writeObject(this);
                } catch (java.io.IOException e2) {
                    e = e2;
                    com.getui.gtc.dyc.a.a.a.a(e);
                    com.getui.gtc.base.util.io.IOUtils.safeClose(objectOutputStream);
                    return android.util.Base64.encodeToString(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().encrypt(byteArrayOutputStream.toByteArray()), 0);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                objectOutputStream2 = objectOutputStream;
                com.getui.gtc.base.util.io.IOUtils.safeClose(objectOutputStream2);
                throw th;
            }
        } catch (java.io.IOException e3) {
            objectOutputStream = null;
            e = e3;
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.getui.gtc.base.util.io.IOUtils.safeClose(objectOutputStream2);
            throw th;
        }
        com.getui.gtc.base.util.io.IOUtils.safeClose(objectOutputStream);
        return android.util.Base64.encodeToString(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().encrypt(byteArrayOutputStream.toByteArray()), 0);
    }
}
