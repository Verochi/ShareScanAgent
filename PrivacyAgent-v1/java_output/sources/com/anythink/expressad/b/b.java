package com.anythink.expressad.b;

/* loaded from: classes12.dex */
public final class b extends com.anythink.core.common.res.image.b {
    java.lang.String a;

    private b(java.lang.String str, java.lang.String str2) {
        super(str);
        this.a = str2;
    }

    @Override // com.anythink.core.common.res.image.b
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(com.anythink.core.common.o.b.d dVar) {
        com.anythink.core.common.o.b.b.a().a(dVar, 2);
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(java.lang.String str, java.lang.String str2) {
    }

    @Override // com.anythink.core.common.res.image.b
    public final boolean a(java.io.InputStream inputStream) {
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(this.a);
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    @Override // com.anythink.core.common.res.image.b
    public final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    public final void c() {
    }
}
