package com.anythink.expressad.foundation.g.f.d;

/* loaded from: classes12.dex */
public class a extends com.anythink.expressad.foundation.g.f.i<java.lang.Void> {
    private static final java.lang.String c = "a";
    private java.io.File d;
    private java.io.File e;

    public a(java.io.File file, java.lang.String str) {
        super(str);
        this.d = file;
        this.e = new java.io.File(file + com.baidu.mobads.sdk.internal.al.k);
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final com.anythink.expressad.foundation.g.f.k<java.lang.Void> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        return !f() ? (!this.e.canRead() || this.e.length() <= 0) ? com.anythink.expressad.foundation.g.f.k.a(new com.anythink.expressad.foundation.g.f.a.a(4, cVar)) : this.e.renameTo(this.d) ? com.anythink.expressad.foundation.g.f.k.a(null, cVar) : com.anythink.expressad.foundation.g.f.k.a(new com.anythink.expressad.foundation.g.f.a.a(4, cVar)) : com.anythink.expressad.foundation.g.f.k.a(new com.anythink.expressad.foundation.g.f.a.a(-2, cVar));
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final byte[] a(com.anythink.expressad.foundation.g.f.f.b bVar, com.anythink.expressad.foundation.g.f.c cVar) {
        java.lang.String a = com.anythink.expressad.foundation.g.f.g.d.a(bVar.b(), "Content-Length");
        long j = 0;
        long longValue = !android.text.TextUtils.isEmpty(a) ? java.lang.Long.valueOf(a).longValue() : 0L;
        java.io.InputStream inputStream = null;
        if (longValue > 0 && this.d.length() == longValue) {
            this.d.renameTo(this.e);
            cVar.a(this, longValue, longValue);
            return null;
        }
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(this.e.getAbsolutePath(), "rw");
        randomAccessFile.setLength(0L);
        try {
            java.io.InputStream c2 = bVar.c();
            try {
                java.io.InputStream gZIPInputStream = (!com.anythink.expressad.foundation.g.f.g.d.b(bVar.b()) || (c2 instanceof java.util.zip.GZIPInputStream)) ? c2 : new java.util.zip.GZIPInputStream(c2);
                try {
                    byte[] bArr = new byte[com.badlogic.gdx.graphics.GL30.GL_COLOR];
                    try {
                        do {
                            int read = gZIPInputStream.read(bArr);
                            if (read != -1) {
                                randomAccessFile.write(bArr, 0, read);
                                j += read;
                                cVar.a(this, longValue, j);
                            }
                            break;
                        } while (!f());
                        break;
                        gZIPInputStream.close();
                    } catch (java.lang.Exception e) {
                        e.getMessage();
                    }
                    cVar.b(this);
                    randomAccessFile.close();
                    return null;
                } catch (java.lang.Throwable th) {
                    inputStream = gZIPInputStream;
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Exception e2) {
                            e2.getMessage();
                        }
                    }
                    randomAccessFile.close();
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStream = c2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final int j() {
        return 1;
    }
}
