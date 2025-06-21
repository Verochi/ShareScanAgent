package com.anythink.expressad.exoplayer.l;

/* loaded from: classes12.dex */
public interface h {

    public static final class a {

        @androidx.annotation.Nullable
        private final android.os.Handler a;

        @androidx.annotation.Nullable
        private final com.anythink.expressad.exoplayer.l.h b;

        /* renamed from: com.anythink.expressad.exoplayer.l.h$a$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.c.d a;

            public AnonymousClass1(com.anythink.expressad.exoplayer.c.d dVar) {
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.l.h.a.this.b.a(this.a);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.l.h$a$2, reason: invalid class name */
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
                com.anythink.expressad.exoplayer.l.h.a.this.b.a(this.a, this.b, this.c);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.l.h$a$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.m a;

            public AnonymousClass3(com.anythink.expressad.exoplayer.m mVar) {
                this.a = mVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.l.h.a.this.b.a(this.a);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.l.h$a$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ long b;

            public AnonymousClass4(int i, long j) {
                this.a = i;
                this.b = j;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.l.h.a.this.b.a(this.a, this.b);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.l.h$a$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ float d;

            public AnonymousClass5(int i, int i2, int i3, float f) {
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.d = f;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.l.h.a.this.b.a(this.a, this.b, this.c, this.d);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.l.h$a$6, reason: invalid class name */
        public class AnonymousClass6 implements java.lang.Runnable {
            final /* synthetic */ android.view.Surface a;

            public AnonymousClass6(android.view.Surface surface) {
                this.a = surface;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.l.h.a.this.b.a(this.a);
            }
        }

        /* renamed from: com.anythink.expressad.exoplayer.l.h$a$7, reason: invalid class name */
        public class AnonymousClass7 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.exoplayer.c.d a;

            public AnonymousClass7(com.anythink.expressad.exoplayer.c.d dVar) {
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.exoplayer.l.h.a.this.b.b(this.a);
            }
        }

        public a(@androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.l.h hVar) {
            this.a = hVar != null ? (android.os.Handler) com.anythink.expressad.exoplayer.k.a.a(handler) : null;
            this.b = hVar;
        }

        public final void a(int i, int i2, int i3, float f) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.l.h.a.AnonymousClass5(i, i2, i3, f));
            }
        }

        public final void a(int i, long j) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.l.h.a.AnonymousClass4(i, j));
            }
        }

        public final void a(android.view.Surface surface) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.l.h.a.AnonymousClass6(surface));
            }
        }

        public final void a(com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.l.h.a.AnonymousClass1(dVar));
            }
        }

        public final void a(com.anythink.expressad.exoplayer.m mVar) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.l.h.a.AnonymousClass3(mVar));
            }
        }

        public final void a(java.lang.String str, long j, long j2) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.l.h.a.AnonymousClass2(str, j, j2));
            }
        }

        public final void b(com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.a.post(new com.anythink.expressad.exoplayer.l.h.a.AnonymousClass7(dVar));
            }
        }
    }

    void a(int i, int i2, int i3, float f);

    void a(int i, long j);

    void a(android.view.Surface surface);

    void a(com.anythink.expressad.exoplayer.c.d dVar);

    void a(com.anythink.expressad.exoplayer.m mVar);

    void a(java.lang.String str, long j, long j2);

    void b(com.anythink.expressad.exoplayer.c.d dVar);
}
