package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class s {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;

    public s(android.content.Context context, long j, java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
        if (java.lang.System.currentTimeMillis() - j <= 86400000) {
            this.c = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.p, "det".concat(java.lang.String.valueOf(str)), "");
        } else {
            this.c = com.anythink.core.common.o.e.a(context, str2);
            com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, "det".concat(java.lang.String.valueOf(str)), this.c);
        }
    }

    private java.lang.String c() {
        return this.b;
    }

    public final java.lang.String a() {
        return this.a;
    }

    public final java.lang.String b() {
        return this.c;
    }
}
