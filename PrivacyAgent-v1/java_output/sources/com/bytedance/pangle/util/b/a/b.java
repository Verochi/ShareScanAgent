package com.bytedance.pangle.util.b.a;

/* loaded from: classes.dex */
public final class b {
    public static void a(com.bytedance.pangle.util.b.b.d dVar, java.io.ByteArrayOutputStream byteArrayOutputStream) {
        java.util.List<com.bytedance.pangle.util.b.b.c> list;
        com.bytedance.pangle.util.b.b.a aVar = dVar.a;
        if (aVar == null || (list = aVar.a) == null || list.size() <= 0) {
            return;
        }
        for (com.bytedance.pangle.util.b.b.c cVar : dVar.a.a) {
            com.bytedance.pangle.util.b.a.c cVar2 = dVar.c;
            if (cVar == null) {
                throw new java.io.IOException("input parameters is null, cannot write local file header");
            }
            byte[] bArr = {0, 0};
            cVar2.a((java.io.OutputStream) byteArrayOutputStream, 33639248);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, 0);
            cVar2.a(byteArrayOutputStream, cVar.a);
            cVar2.a(byteArrayOutputStream, 2081);
            cVar2.a(byteArrayOutputStream, 545);
            cVar2.a((java.io.OutputStream) byteArrayOutputStream, (int) cVar.b);
            cVar2.a((java.io.OutputStream) byteArrayOutputStream, (int) cVar.c);
            cVar2.a((java.io.OutputStream) byteArrayOutputStream, (int) cVar.d);
            byte[] bArr2 = new byte[0];
            java.lang.String str = cVar.h;
            if (str != null && str.trim().length() > 0) {
                bArr2 = cVar.h.getBytes(java.nio.charset.Charset.forName("UTF-8"));
            }
            cVar2.a(byteArrayOutputStream, bArr2.length);
            int i = cVar.f;
            cVar2.a(byteArrayOutputStream, i);
            cVar2.a(byteArrayOutputStream, 0);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr);
            cVar2.a((java.io.OutputStream) byteArrayOutputStream, (int) cVar.i);
            if (bArr2.length > 0) {
                byteArrayOutputStream.write(bArr2);
            }
            if (i > 0) {
                byteArrayOutputStream.write(new byte[i]);
            }
        }
    }
}
