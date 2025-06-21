package com.anythink.core.common;

/* loaded from: classes12.dex */
public abstract class m<T extends com.anythink.core.common.f.x> {
    protected android.content.Context d;
    final java.lang.String a = getClass().getSimpleName();
    java.util.ArrayList<T> b = new java.util.ArrayList<>();
    java.lang.Runnable f = new com.anythink.core.common.m.AnonymousClass1();
    java.lang.String c = com.anythink.core.common.b.o.a().o();
    protected android.os.Handler e = com.anythink.core.common.o.b.b.a().a(9);

    /* renamed from: com.anythink.core.common.m$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.m.this.a(true);
        }
    }

    public m(android.content.Context context) {
        this.d = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        if (z) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.addAll(this.b);
            if (arrayList.size() > 0) {
                a(arrayList);
            }
            this.b.clear();
        } else {
            com.anythink.core.d.a b = com.anythink.core.d.b.a(this.d).b(this.c);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (this.b.size() >= b.ai()) {
                for (int ai = b.ai() - 1; ai >= 0; ai--) {
                    arrayList2.add(this.b.get(ai));
                    this.b.remove(ai);
                }
                if (arrayList2.size() > 0) {
                    a(arrayList2);
                }
            }
        }
        if (this.b.isEmpty()) {
            this.e.removeCallbacks(this.f);
        }
    }

    public final synchronized void a(T t, boolean z) {
        boolean z2 = true;
        if (z) {
            this.b.add(t);
            a(true);
            return;
        }
        com.anythink.core.d.a b = com.anythink.core.d.b.a(this.d).b(this.c);
        if (this.b.isEmpty()) {
            if (b.ak() > 0) {
                this.e.removeCallbacks(this.f);
                this.e.postDelayed(this.f, b.ak());
            }
            this.b.add(t);
            a(z2);
        }
        z2 = false;
        this.b.add(t);
        a(z2);
    }

    public abstract void a(java.util.List<T> list);
}
