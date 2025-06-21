package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public final class f extends com.anythink.core.common.h.a {
    public static final int c = 1;
    java.lang.String a;
    int b;
    private com.anythink.core.common.f.bb d;

    private f(java.lang.String str) {
        this.b = 0;
        this.a = str;
    }

    private f(java.lang.String str, com.anythink.core.common.f.bb bbVar) {
        this(str);
        this.b = 1;
        this.d = bbVar;
    }

    public static com.anythink.core.common.h.f a(java.lang.String str) {
        return new com.anythink.core.common.h.f(str);
    }

    public static com.anythink.core.common.h.f a(java.lang.String str, com.anythink.core.common.f.bb bbVar) {
        return new com.anythink.core.common.h.f(str, bbVar);
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        com.anythink.core.common.f.bb bbVar;
        if (1 != this.b || (bbVar = this.d) == null) {
            return null;
        }
        bbVar.a(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE);
        com.anythink.core.common.n.c.a(this.d);
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final void a(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        return this.a;
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
        com.anythink.core.common.f.bb bbVar;
        if (1 == this.b && com.anythink.core.api.ErrorCode.httpStatuException.equals(adError.getCode()) && (bbVar = this.d) != null) {
            bbVar.a(adError.getPlatformCode());
            this.d.b(adError.getPlatformMSG());
            com.anythink.core.common.n.c.a(this.d);
        }
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final byte[] d() {
        return new byte[0];
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String g() {
        return "";
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String h() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final android.content.Context i() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String j() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.Object> k() {
        return null;
    }
}
