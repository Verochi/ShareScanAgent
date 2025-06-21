package com.loc;

/* loaded from: classes23.dex */
public abstract class cq {
    com.loc.cq c;

    public cq() {
    }

    public cq(com.loc.cq cqVar) {
        this.c = cqVar;
    }

    public void a(int i) {
        com.loc.cq cqVar = this.c;
        if (cqVar != null) {
            cqVar.a(i);
        }
    }

    public void a(boolean z) {
        com.loc.cq cqVar = this.c;
        if (cqVar != null) {
            cqVar.a(z);
        }
    }

    public abstract boolean a();

    public int b() {
        com.loc.cq cqVar = this.c;
        return java.lang.Math.min(Integer.MAX_VALUE, cqVar != null ? cqVar.b() : Integer.MAX_VALUE);
    }

    public final boolean c() {
        com.loc.cq cqVar = this.c;
        if (cqVar != null ? cqVar.c() : true) {
            return a();
        }
        return false;
    }
}
