package com.sijla.h.c.a.a;

/* loaded from: classes19.dex */
public final class a implements com.sijla.h.c.a.a {
    @Override // com.sijla.h.c.a.a
    public final com.sijla.h.j a(java.io.InputStream inputStream) {
        com.sijla.h.j jVar = new com.sijla.h.j();
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                sb.append(new java.lang.String(bArr, 0, read));
            }
            jVar.a(sb.toString());
        } catch (java.io.IOException e) {
            e.printStackTrace();
            jVar.a(com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_URL_CODE);
            jVar.a(e.getMessage());
        }
        return jVar;
    }
}
