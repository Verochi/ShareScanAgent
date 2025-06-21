package com.autonavi.extra;

/* loaded from: classes12.dex */
public class b {
    private java.util.List<com.autonavi.extra.a> a = new java.util.ArrayList();

    public final void a() {
        synchronized (com.autonavi.extra.b.class) {
            java.util.List<com.autonavi.extra.a> list = this.a;
            if (list != null) {
                list.add(null);
            }
        }
    }

    public final void b() {
        synchronized (com.autonavi.extra.b.class) {
            java.util.Iterator<com.autonavi.extra.a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void c() {
        synchronized (com.autonavi.extra.b.class) {
            java.util.Iterator<com.autonavi.extra.a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void d() {
        synchronized (com.autonavi.extra.b.class) {
            java.util.Iterator<com.autonavi.extra.a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void e() {
        synchronized (com.autonavi.extra.b.class) {
            java.util.Iterator<com.autonavi.extra.a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void f() {
        synchronized (com.autonavi.extra.b.class) {
            java.util.Iterator<com.autonavi.extra.a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.a.clear();
        }
    }

    public final java.lang.String g() {
        java.lang.String stringBuffer;
        synchronized (com.autonavi.extra.b.class) {
            java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
            for (com.autonavi.extra.a aVar : this.a) {
                if (aVar != null) {
                    java.lang.String a = aVar.a();
                    if (!android.text.TextUtils.isEmpty(a)) {
                        stringBuffer2.append(a);
                        if (!a.endsWith(com.alipay.sdk.m.u.i.b)) {
                            stringBuffer2.append(com.alipay.sdk.m.u.i.b);
                        }
                    }
                }
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }

    public final void h() {
        synchronized (com.autonavi.extra.b.class) {
            java.util.Iterator<com.autonavi.extra.a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void i() {
        synchronized (com.autonavi.extra.b.class) {
            java.util.Iterator<com.autonavi.extra.a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final java.lang.Object j() {
        java.lang.Object b;
        synchronized (com.autonavi.extra.b.class) {
            for (com.autonavi.extra.a aVar : this.a) {
                if (aVar != null && (b = aVar.b()) != null) {
                    return b;
                }
            }
            return null;
        }
    }
}
