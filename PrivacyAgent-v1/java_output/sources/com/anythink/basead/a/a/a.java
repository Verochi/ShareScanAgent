package com.anythink.basead.a.a;

/* loaded from: classes12.dex */
public abstract class a<R, E> implements com.anythink.basead.a.a.c<R, E> {
    private final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(1);
    private com.anythink.basead.a.a.b<R, E> c;

    @Override // com.anythink.basead.a.a.c
    public final void a() {
        if (!this.a.get() && this.b.decrementAndGet() == 0) {
            this.a.set(true);
            com.anythink.basead.a.a.b<R, E> bVar = this.c;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // com.anythink.basead.a.a.c
    public final void a(int i) {
        this.b.set(i);
    }

    @Override // com.anythink.basead.a.a.c
    public final void a(com.anythink.basead.a.a.b<R, E> bVar) {
        this.c = bVar;
    }

    @Override // com.anythink.basead.a.a.c
    public final void a(E e) {
        if (this.a.get()) {
            return;
        }
        this.a.set(true);
        com.anythink.basead.a.a.b<R, E> bVar = this.c;
        if (bVar != null) {
            bVar.a(e);
        }
    }
}
