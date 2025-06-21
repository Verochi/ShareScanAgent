package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class dy {
    public com.amap.api.col.s.dy c;

    public dy() {
    }

    public dy(com.amap.api.col.s.dy dyVar) {
        this.c = dyVar;
    }

    public void a(int i) {
        com.amap.api.col.s.dy dyVar = this.c;
        if (dyVar != null) {
            dyVar.a(i);
        }
    }

    public void a(boolean z) {
        com.amap.api.col.s.dy dyVar = this.c;
        if (dyVar != null) {
            dyVar.a(z);
        }
    }

    public abstract boolean a();

    public int b() {
        com.amap.api.col.s.dy dyVar = this.c;
        return java.lang.Math.min(Integer.MAX_VALUE, dyVar != null ? dyVar.b() : Integer.MAX_VALUE);
    }

    public final boolean c() {
        com.amap.api.col.s.dy dyVar = this.c;
        if (dyVar != null ? dyVar.c() : true) {
            return a();
        }
        return false;
    }
}
