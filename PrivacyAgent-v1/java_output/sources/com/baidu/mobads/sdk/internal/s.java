package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class s {
    private static volatile com.baidu.mobads.sdk.internal.s a;
    private java.util.List<com.baidu.mobads.sdk.internal.aa.a> b = new java.util.concurrent.CopyOnWriteArrayList();

    private s() {
    }

    public static com.baidu.mobads.sdk.internal.s a() {
        if (a == null) {
            synchronized (com.baidu.mobads.sdk.internal.s.class) {
                if (a == null) {
                    a = new com.baidu.mobads.sdk.internal.s();
                }
            }
        }
        return a;
    }

    private void b(com.baidu.mobads.sdk.internal.aa.a aVar) {
        if (this.b.contains(aVar)) {
            this.b.remove(aVar);
        }
    }

    public void a(int i) {
        for (com.baidu.mobads.sdk.internal.aa.a aVar : this.b) {
            if (i == 1) {
                aVar.onSuccess();
            } else if (i == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }

    public void a(com.baidu.mobads.sdk.internal.aa.a aVar) {
        if (aVar == null || this.b.contains(aVar)) {
            return;
        }
        this.b.add(aVar);
    }
}
