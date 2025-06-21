package com.meizu.cloud.pushsdk.c.c;

/* loaded from: classes23.dex */
public abstract class j {

    /* renamed from: com.meizu.cloud.pushsdk.c.c.j$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.meizu.cloud.pushsdk.c.c.j {
        final /* synthetic */ com.meizu.cloud.pushsdk.c.c.g a;
        final /* synthetic */ int b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ int d;

        public AnonymousClass1(com.meizu.cloud.pushsdk.c.c.g gVar, int i, byte[] bArr, int i2) {
            this.a = gVar;
            this.b = i;
            this.c = bArr;
            this.d = i2;
        }

        @Override // com.meizu.cloud.pushsdk.c.c.j
        public com.meizu.cloud.pushsdk.c.c.g a() {
            return this.a;
        }

        @Override // com.meizu.cloud.pushsdk.c.c.j
        public void a(com.meizu.cloud.pushsdk.c.g.c cVar) throws java.io.IOException {
            cVar.c(this.c, this.d, this.b);
        }

        @Override // com.meizu.cloud.pushsdk.c.c.j
        public long b() {
            return this.b;
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.j$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.meizu.cloud.pushsdk.c.c.j {
        final /* synthetic */ com.meizu.cloud.pushsdk.c.c.g a;
        final /* synthetic */ java.io.File b;

        public AnonymousClass2(com.meizu.cloud.pushsdk.c.c.g gVar, java.io.File file) {
            this.a = gVar;
            this.b = file;
        }

        @Override // com.meizu.cloud.pushsdk.c.c.j
        public com.meizu.cloud.pushsdk.c.c.g a() {
            return this.a;
        }

        @Override // com.meizu.cloud.pushsdk.c.c.j
        public void a(com.meizu.cloud.pushsdk.c.g.c cVar) throws java.io.IOException {
            com.meizu.cloud.pushsdk.c.g.m mVar = null;
            try {
                mVar = com.meizu.cloud.pushsdk.c.g.g.a(this.b);
                cVar.a(mVar);
            } finally {
                com.meizu.cloud.pushsdk.c.c.m.a(mVar);
            }
        }

        @Override // com.meizu.cloud.pushsdk.c.c.j
        public long b() {
            return this.b.length();
        }
    }

    public static com.meizu.cloud.pushsdk.c.c.j a(com.meizu.cloud.pushsdk.c.c.g gVar, java.io.File file) {
        if (file != null) {
            return new com.meizu.cloud.pushsdk.c.c.j.AnonymousClass2(gVar, file);
        }
        throw new java.lang.NullPointerException("content == null");
    }

    public static com.meizu.cloud.pushsdk.c.c.j a(com.meizu.cloud.pushsdk.c.c.g gVar, java.lang.String str) {
        java.nio.charset.Charset charset = com.meizu.cloud.pushsdk.c.c.m.c;
        if (gVar != null) {
            java.nio.charset.Charset b = gVar.b();
            if (b == null) {
                gVar = com.meizu.cloud.pushsdk.c.c.g.a(gVar + "; charset=utf-8");
            } else {
                charset = b;
            }
        }
        return a(gVar, str.getBytes(charset));
    }

    public static com.meizu.cloud.pushsdk.c.c.j a(com.meizu.cloud.pushsdk.c.c.g gVar, byte[] bArr) {
        return a(gVar, bArr, 0, bArr.length);
    }

    public static com.meizu.cloud.pushsdk.c.c.j a(com.meizu.cloud.pushsdk.c.c.g gVar, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("content == null");
        }
        com.meizu.cloud.pushsdk.c.c.m.a(bArr.length, i, i2);
        return new com.meizu.cloud.pushsdk.c.c.j.AnonymousClass1(gVar, i2, bArr, i);
    }

    public abstract com.meizu.cloud.pushsdk.c.c.g a();

    public abstract void a(com.meizu.cloud.pushsdk.c.g.c cVar) throws java.io.IOException;

    public long b() throws java.io.IOException {
        return -1L;
    }
}
