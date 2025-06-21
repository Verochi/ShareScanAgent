package com.igexin.push.core.g;

/* loaded from: classes23.dex */
public abstract class a<T> {

    /* renamed from: com.igexin.push.core.g.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.core.g.a<T> {
        final /* synthetic */ com.igexin.push.core.g.a a;

        public AnonymousClass1(com.igexin.push.core.g.a aVar) {
            this.a = aVar;
        }

        @Override // com.igexin.push.core.g.a
        public final void a(T t) {
            com.igexin.push.core.g.a.this.a((com.igexin.push.core.g.a) t);
            com.igexin.push.core.g.a aVar = this.a;
            if (aVar != null) {
                aVar.a((com.igexin.push.core.g.a) t);
            }
        }
    }

    public final com.igexin.push.core.g.a<T> a(com.igexin.push.core.g.a<? super T> aVar) {
        return new com.igexin.push.core.g.a.AnonymousClass1(aVar);
    }

    public abstract void a(T t);
}
