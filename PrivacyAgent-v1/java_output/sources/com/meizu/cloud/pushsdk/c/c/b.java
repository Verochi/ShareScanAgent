package com.meizu.cloud.pushsdk.c.c;

/* loaded from: classes23.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.j {
    private static final com.meizu.cloud.pushsdk.c.c.g a = com.meizu.cloud.pushsdk.c.c.g.a(com.anythink.expressad.foundation.g.f.g.b.e);
    private final java.util.List<java.lang.String> b;
    private final java.util.List<java.lang.String> c;

    public static final class a {
        private final java.util.List<java.lang.String> a = new java.util.ArrayList();
        private final java.util.List<java.lang.String> b = new java.util.ArrayList();

        public com.meizu.cloud.pushsdk.c.c.b.a a(java.lang.String str, java.lang.String str2) {
            this.a.add(com.meizu.cloud.pushsdk.c.c.f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.b.add(com.meizu.cloud.pushsdk.c.c.f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public com.meizu.cloud.pushsdk.c.c.b a() {
            return new com.meizu.cloud.pushsdk.c.c.b(this.a, this.b, null);
        }

        public com.meizu.cloud.pushsdk.c.c.b.a b(java.lang.String str, java.lang.String str2) {
            this.a.add(com.meizu.cloud.pushsdk.c.c.f.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.b.add(com.meizu.cloud.pushsdk.c.c.f.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

    private b(java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2) {
        this.b = com.meizu.cloud.pushsdk.c.c.m.a(list);
        this.c = com.meizu.cloud.pushsdk.c.c.m.a(list2);
    }

    public /* synthetic */ b(java.util.List list, java.util.List list2, com.meizu.cloud.pushsdk.c.c.b.AnonymousClass1 anonymousClass1) {
        this(list, list2);
    }

    private long a(com.meizu.cloud.pushsdk.c.g.c cVar, boolean z) {
        com.meizu.cloud.pushsdk.c.g.b bVar = z ? new com.meizu.cloud.pushsdk.c.g.b() : cVar.b();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                bVar.b(38);
            }
            bVar.b(this.b.get(i));
            bVar.b(61);
            bVar.b(this.c.get(i));
        }
        if (!z) {
            return 0L;
        }
        long a2 = bVar.a();
        bVar.j();
        return a2;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public com.meizu.cloud.pushsdk.c.c.g a() {
        return a;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(com.meizu.cloud.pushsdk.c.g.c cVar) {
        a(cVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() {
        return a((com.meizu.cloud.pushsdk.c.g.c) null, true);
    }
}
