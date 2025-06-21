package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class e {
    private java.lang.String a;
    private java.lang.String b;
    private int c;

    public e(java.lang.String str, java.lang.String str2, int i) {
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    private java.lang.String b() {
        return this.a;
    }

    private int c() {
        return this.c;
    }

    public final java.lang.String a() {
        return this.b;
    }

    public final boolean a(com.anythink.core.common.f.au auVar) {
        if (auVar != null) {
            int i = auVar.a;
            return i != 2 ? i == 3 && auVar.d() == this.c : auVar.u().equals(this.a);
        }
        return false;
    }
}
