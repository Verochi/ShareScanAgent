package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class f implements com.anythink.expressad.exoplayer.j.h {
    public static final java.lang.String a = "data";
    private com.anythink.expressad.exoplayer.j.k b;
    private int c;
    private byte[] d;

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int length = this.d.length - this.c;
        if (length == 0) {
            return -1;
        }
        int min = java.lang.Math.min(i2, length);
        java.lang.System.arraycopy(this.d, this.c, bArr, i, min);
        this.c += min;
        return min;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) {
        this.b = kVar;
        android.net.Uri uri = kVar.c;
        java.lang.String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            throw new com.anythink.expressad.exoplayer.t("Unsupported scheme: ".concat(java.lang.String.valueOf(scheme)));
        }
        java.lang.String[] a2 = com.anythink.expressad.exoplayer.k.af.a(uri.getSchemeSpecificPart(), ",");
        if (a2.length != 2) {
            throw new com.anythink.expressad.exoplayer.t("Unexpected URI format: ".concat(java.lang.String.valueOf(uri)));
        }
        java.lang.String str = a2[1];
        if (a2[0].contains(";base64")) {
            try {
                this.d = android.util.Base64.decode(str, 0);
            } catch (java.lang.IllegalArgumentException e) {
                throw new com.anythink.expressad.exoplayer.t("Error while parsing Base64 encoded string: ".concat(java.lang.String.valueOf(str)), e);
            }
        } else {
            this.d = java.net.URLDecoder.decode(str, "US-ASCII").getBytes();
        }
        return this.d.length;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final android.net.Uri a() {
        com.anythink.expressad.exoplayer.j.k kVar = this.b;
        if (kVar != null) {
            return kVar.c;
        }
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.b = null;
        this.d = null;
    }
}
