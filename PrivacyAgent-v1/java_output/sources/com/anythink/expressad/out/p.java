package com.anythink.expressad.out;

/* loaded from: classes12.dex */
public final class p {

    public interface a {
        void a();
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public interface c {
        void a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str);

        void a(com.anythink.expressad.out.j jVar);

        void a(com.anythink.expressad.out.j jVar, java.lang.String str);

        boolean a();

        void b();

        void b(com.anythink.expressad.out.j jVar);

        void b(com.anythink.expressad.out.j jVar, java.lang.String str);

        void c(com.anythink.expressad.out.j jVar);

        void d(com.anythink.expressad.out.j jVar);
    }

    public static class d {
        private int a;
        private int b;

        private d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        private int a() {
            return this.a;
        }

        private void a(int i) {
            this.a = i;
        }

        private int b() {
            return this.b;
        }

        private void b(int i) {
            this.b = i;
        }
    }

    public interface e extends com.anythink.expressad.out.p.c {
        void c();
    }
}
