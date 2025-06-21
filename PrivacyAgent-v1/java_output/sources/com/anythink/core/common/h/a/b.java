package com.anythink.core.common.h.a;

/* loaded from: classes12.dex */
public final class b extends com.anythink.core.common.h.a.c {
    java.lang.String a;
    int c;
    private final java.lang.String k = com.anythink.core.common.h.a.b.class.getSimpleName();
    boolean b = true;

    public b(java.lang.String str, int i) {
        this.c = 1;
        this.a = str;
        if (i == 1000) {
            this.c = 1;
        } else if (i == 1001) {
            this.c = 2;
        }
    }

    @Override // com.anythink.core.common.h.a.c
    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
    }

    @Override // com.anythink.core.common.h.a.c
    public final int c() {
        return this.c;
    }

    @Override // com.anythink.core.common.h.a.c
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.h.a.c
    public final byte[] e() {
        return !android.text.TextUtils.isEmpty(this.a) ? com.anythink.core.common.h.a.c.a(this.a) : new byte[0];
    }

    @Override // com.anythink.core.common.h.a.c
    public final boolean f() {
        return this.b;
    }
}
