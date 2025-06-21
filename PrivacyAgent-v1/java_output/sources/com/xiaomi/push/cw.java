package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class cw {

    public static final class a extends com.xiaomi.push.da {
        private boolean c;
        private boolean d;
        private boolean f;
        private boolean h;
        public int a = 0;
        private boolean e = false;
        private int g = 0;
        private boolean i = false;
        public java.util.List<java.lang.String> b = java.util.Collections.emptyList();
        private int j = -1;

        public static com.xiaomi.push.cw.a a(com.xiaomi.push.z zVar) {
            return new com.xiaomi.push.cw.a().b(zVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.xiaomi.push.da
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.xiaomi.push.cw.a b(com.xiaomi.push.z zVar) {
            while (true) {
                int a = zVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    int e = zVar.e();
                    this.c = true;
                    this.a = e;
                } else if (a == 16) {
                    boolean b = zVar.b();
                    this.d = true;
                    this.e = b;
                } else if (a == 24) {
                    int e2 = zVar.e();
                    this.f = true;
                    this.g = e2;
                } else if (a == 32) {
                    boolean b2 = zVar.b();
                    this.h = true;
                    this.i = b2;
                } else if (a == 42) {
                    java.lang.String c = zVar.c();
                    if (this.b.isEmpty()) {
                        this.b = new java.util.ArrayList();
                    }
                    this.b.add(c);
                } else if (!zVar.b(a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.da
        public final int a() {
            if (this.j < 0) {
                b();
            }
            return this.j;
        }

        @Override // com.xiaomi.push.da
        public final void a(com.xiaomi.push.az azVar) {
            if (this.c) {
                azVar.a(this.a);
            }
            if (this.d) {
                azVar.a(2, this.e);
            }
            if (this.f) {
                azVar.a(3, this.g);
            }
            if (this.h) {
                azVar.a(4, this.i);
            }
            java.util.Iterator<java.lang.String> it = this.b.iterator();
            while (it.hasNext()) {
                azVar.a(5, it.next());
            }
        }

        @Override // com.xiaomi.push.da
        public final int b() {
            int i = 0;
            int b = this.c ? com.xiaomi.push.az.b(this.a) + 0 : 0;
            if (this.d) {
                b += com.xiaomi.push.az.c(2) + 1;
            }
            if (this.f) {
                b += com.xiaomi.push.az.b(3, this.g);
            }
            if (this.h) {
                b += com.xiaomi.push.az.c(4) + 1;
            }
            java.util.Iterator<java.lang.String> it = this.b.iterator();
            while (it.hasNext()) {
                i += com.xiaomi.push.az.a(it.next());
            }
            int size = b + i + (this.b.size() * 1);
            this.j = size;
            return size;
        }
    }
}
