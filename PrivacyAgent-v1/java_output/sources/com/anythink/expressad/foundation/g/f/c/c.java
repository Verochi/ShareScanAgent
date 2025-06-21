package com.anythink.expressad.foundation.g.f.c;

/* loaded from: classes12.dex */
public final class c {
    private final java.lang.String a;
    private final java.lang.String b;

    public c(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    public final java.lang.String a() {
        return this.a;
    }

    public final java.lang.String b() {
        return this.b;
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.anythink.expressad.foundation.g.f.c.c.class == obj.getClass()) {
            com.anythink.expressad.foundation.g.f.c.c cVar = (com.anythink.expressad.foundation.g.f.c.c) obj;
            if (android.text.TextUtils.equals(this.a, cVar.a) && android.text.TextUtils.equals(this.b, cVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final java.lang.String toString() {
        return "Header[name=" + this.a + ",value=" + this.b + "]";
    }
}
