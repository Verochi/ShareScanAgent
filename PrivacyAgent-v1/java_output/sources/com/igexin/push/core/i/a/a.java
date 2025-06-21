package com.igexin.push.core.i.a;

/* loaded from: classes23.dex */
public final class a {
    private static final java.lang.String a = "BufferGifDecoder";
    private final android.content.Context b;
    private final com.igexin.push.core.i.a.c d = new com.igexin.push.core.i.a.c();
    private final com.igexin.push.core.i.a.j c = new com.igexin.push.core.i.a.j();

    public a(android.content.Context context) {
        this.b = context.getApplicationContext();
    }

    private static int a(com.igexin.push.core.i.a.i iVar, int i, int i2) {
        int min = java.lang.Math.min(iVar.i / i2, iVar.h / i);
        int max = java.lang.Math.max(1, min == 0 ? 0 : java.lang.Integer.highestOneBit(min));
        com.igexin.c.a.c.a.b(a, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + iVar.h + "x" + iVar.i + "]");
        return max;
    }

    private com.igexin.push.core.i.a.f a(java.nio.ByteBuffer byteBuffer, int i, int i2, com.igexin.push.core.i.a.j jVar) {
        com.igexin.push.core.i.a.i b = jVar.b();
        if (b.e <= 0 || b.d != 0) {
            return null;
        }
        android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.ARGB_8888;
        int min = java.lang.Math.min(b.i / i2, b.h / i);
        int max = java.lang.Math.max(1, min == 0 ? 0 : java.lang.Integer.highestOneBit(min));
        com.igexin.c.a.c.a.b(a, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + b.h + "x" + b.i + "]");
        com.igexin.push.core.i.a.n nVar = new com.igexin.push.core.i.a.n(this.d, b, byteBuffer, max);
        nVar.a(config);
        nVar.e();
        android.graphics.Bitmap n = nVar.n();
        if (n == null) {
            return null;
        }
        return new com.igexin.push.core.i.a.f(new com.igexin.push.core.i.a.e(nVar, n));
    }

    private com.igexin.push.core.i.a.f a(byte[] bArr, int i, int i2) {
        return a(java.nio.ByteBuffer.wrap(bArr), i, i2);
    }

    public final com.igexin.push.core.i.a.f a(java.nio.ByteBuffer byteBuffer, int i, int i2) {
        com.igexin.push.core.i.a.j a2 = this.c.a(byteBuffer);
        com.igexin.push.core.i.a.f fVar = null;
        try {
            com.igexin.push.core.i.a.i b = a2.b();
            if (b.e > 0 && b.d == 0) {
                android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.ARGB_8888;
                int min = java.lang.Math.min(b.i / i2, b.h / i);
                int max = java.lang.Math.max(1, min == 0 ? 0 : java.lang.Integer.highestOneBit(min));
                com.igexin.c.a.c.a.b(a, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + b.h + "x" + b.i + "]");
                com.igexin.push.core.i.a.n nVar = new com.igexin.push.core.i.a.n(this.d, b, byteBuffer, max);
                nVar.a(config);
                nVar.e();
                android.graphics.Bitmap n = nVar.n();
                if (n != null) {
                    fVar = new com.igexin.push.core.i.a.f(new com.igexin.push.core.i.a.e(nVar, n));
                }
            }
            return fVar;
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                return null;
            } finally {
                a2.a();
            }
        }
    }
}
