package com.igexin.push.core.d;

/* loaded from: classes23.dex */
public abstract class g {
    com.getui.gtc.dyc.b.c b = new com.igexin.push.core.d.g.AnonymousClass1();

    /* renamed from: com.igexin.push.core.d.g$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.dyc.b.c {
        public AnonymousClass1() {
        }

        @Override // com.getui.gtc.dyc.b.c
        public final void a(java.util.Map map, java.util.Map map2) {
            com.igexin.push.core.d.g.this.a((java.util.Map<java.lang.String, java.lang.String>) map2);
        }

        @Override // com.getui.gtc.dyc.b.c
        public final void b(java.lang.String str) {
            com.igexin.push.core.d.g.this.a(str);
        }
    }

    private com.getui.gtc.dyc.b.c a() {
        return this.b;
    }

    public abstract void a(java.lang.String str);

    public abstract void a(java.util.Map<java.lang.String, java.lang.String> map);
}
