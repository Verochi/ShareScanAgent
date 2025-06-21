package com.loc;

/* loaded from: classes23.dex */
public final class av extends com.loc.s {
    private byte[] a;
    private java.lang.String b;

    public av(byte[] bArr, java.lang.String str) {
        this.b = "1";
        this.a = (byte[]) bArr.clone();
        this.b = str;
        a(com.loc.bu.a.SINGLE);
        a(com.loc.bu.c.HTTP);
    }

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", java.lang.String.valueOf(this.a.length));
        return hashMap;
    }

    @Override // com.loc.bu
    public final java.lang.String b() {
        java.lang.String c = com.loc.y.c(com.loc.ah.b);
        byte[] a = com.loc.y.a(com.loc.ah.a);
        byte[] bArr = new byte[a.length + 50];
        java.lang.System.arraycopy(this.a, 0, bArr, 0, 50);
        java.lang.System.arraycopy(a, 0, bArr, 50, a.length);
        return java.lang.String.format(c, "1", this.b, "1", com.igexin.sdk.PushBuildConfig.sdk_conf_channelid, com.loc.t.a(bArr));
    }

    @Override // com.loc.bu
    public final byte[] d() {
        return this.a;
    }

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        return null;
    }

    @Override // com.loc.bu
    public final boolean h() {
        return false;
    }
}
