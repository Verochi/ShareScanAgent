package com.xiaomi.push;

/* loaded from: classes19.dex */
final class gd extends com.xiaomi.push.p.b {
    final /* synthetic */ android.content.Context a;

    public gd(android.content.Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.p.b
    public final void a() {
        java.lang.Object obj;
        java.util.ArrayList arrayList;
        java.util.List list;
        java.util.List list2;
        obj = com.xiaomi.push.gc.d;
        synchronized (obj) {
            list = com.xiaomi.push.gc.e;
            arrayList = new java.util.ArrayList(list);
            list2 = com.xiaomi.push.gc.e;
            list2.clear();
        }
        com.xiaomi.push.gc.a(this.a, arrayList);
    }
}
