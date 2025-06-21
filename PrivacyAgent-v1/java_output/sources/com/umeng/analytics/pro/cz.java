package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public final class cz {
    public final java.lang.String a;
    public final byte b;
    public final int c;

    public cz() {
        this("", (byte) 0, 0);
    }

    public cz(java.lang.String str, byte b, int i) {
        this.a = str;
        this.b = b;
        this.c = i;
    }

    public boolean a(com.umeng.analytics.pro.cz czVar) {
        return this.a.equals(czVar.a) && this.b == czVar.b && this.c == czVar.c;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.umeng.analytics.pro.cz) {
            return a((com.umeng.analytics.pro.cz) obj);
        }
        return false;
    }

    public java.lang.String toString() {
        return "<TMessage name:'" + this.a + "' type: " + ((int) this.b) + " seqid:" + this.c + ">";
    }
}
