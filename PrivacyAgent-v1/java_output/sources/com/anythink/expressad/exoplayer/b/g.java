package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
public interface g {

    public static final class a {

        @androidx.annotation.Nullable
        private final android.os.Handler a;

        @androidx.annotation.Nullable
        private final com.anythink.expressad.exoplayer.b.g b;

        /* renamed from: com.anythink.expressad.exoplayer.b.g$a$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.c.d a;

            public AnonymousClass1(com.anythink.expressad.exoplayer.c.d dVar) {
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.b.g.a.this.b.c(this.a);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.b.g$a$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            public AnonymousClass2(java.lang.String str, long j, long j2) {
                this.a = str;
                this.b = j;
                this.c = j2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.b.g.a.this.b.b(this.a, this.b, this.c);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.b.g$a$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.m a;

            public AnonymousClass3(com.anythink.expressad.exoplayer.m mVar) {
                this.a = mVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.b.g.a.this.b.b(this.a);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.b.g$a$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            public AnonymousClass4(int i, long j, long j2) {
                this.a = i;
                this.b = j;
                this.c = j2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.b.g.a.this.b.a(this.a, this.b, this.c);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.b.g$a$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.c.d a;

            public AnonymousClass5(com.anythink.expressad.exoplayer.c.d dVar) {
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.b.g.a.this.b.d(this.a);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.b.g$a$6, reason: invalid class name */
        public class AnonymousClass6 implements java.lang.Runnable {
            final /* synthetic */ int a;

            public AnonymousClass6(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.b.g.a.this.b.a(this.a);
            }
        }

        public a(@androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.b.g gVar) {
            this.a = gVar != null ? (android.os.Handler) com.anythink.expressad.exoplayer.k.a.a(handler) : null;
            this.b = gVar;
        }

        public final void a(int i) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.b.g.a.AnonymousClass6(i));
            }
        }

        public final void a(int i, long j, long j2) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.b.g.a.AnonymousClass4(i, j, j2));
            }
        }

        public final void a(com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.b.g.a.AnonymousClass1(dVar));
            }
        }

        public final void a(com.anythink.expressad.exoplayer.m mVar) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.b.g.a.AnonymousClass3(mVar));
            }
        }

        public final void a(java.lang.String str, long j, long j2) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.b.g.a.AnonymousClass2(str, j, j2));
            }
        }

        public final void b(com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.b.g.a.AnonymousClass5(dVar));
            }
        }
    }

    void a(int i);

    void a(int i, long j, long j2);

    void b(com.anythink.expressad.exoplayer.m mVar);

    void b(java.lang.String str, long j, long j2);

    void c(com.anythink.expressad.exoplayer.c.d dVar);

    void d(com.anythink.expressad.exoplayer.c.d dVar);
}
