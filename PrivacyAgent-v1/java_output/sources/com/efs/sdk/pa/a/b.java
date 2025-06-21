package com.efs.sdk.pa.a;

/* loaded from: classes22.dex */
final class b {
    java.util.HashMap<java.lang.String, com.efs.sdk.pa.a.b.a> a = new java.util.HashMap<>();
    boolean b = false;

    public static class a {
        long a;
        long b;
        android.view.ViewTreeObserver.OnPreDrawListener c;
        android.view.View d;

        /* renamed from: com.efs.sdk.pa.a.b$a$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.ViewTreeObserver.OnPreDrawListener {
            public AnonymousClass1() {
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                com.efs.sdk.pa.a.b.a.this.b++;
                return true;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }
}
