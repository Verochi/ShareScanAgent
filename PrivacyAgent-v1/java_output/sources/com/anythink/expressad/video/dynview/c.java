package com.anythink.expressad.video.dynview;

/* loaded from: classes12.dex */
public final class c {
    private android.content.Context a;
    private java.lang.String b;
    private int c;
    private float d;
    private float e;
    private int f;
    private int g;
    private android.view.View h;
    private java.util.List<com.anythink.expressad.foundation.d.c> i;
    private int j;
    private boolean k;
    private java.lang.String l;
    private int m;

    public static class a implements com.anythink.expressad.video.dynview.c.b {
        private android.content.Context a;
        private java.lang.String b;
        private int c;
        private float d;
        private float e;
        private int f;
        private int g;
        private android.view.View h;
        private java.util.List<com.anythink.expressad.foundation.d.c> i;
        private int j;
        private boolean k;
        private java.lang.String l;
        private int m;

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b a(float f) {
            this.d = f;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b a(int i) {
            this.c = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b a(android.content.Context context) {
            this.a = context.getApplicationContext();
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b a(android.view.View view) {
            this.h = view;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b a(java.lang.String str) {
            this.b = str;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
            this.i = list;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b a(boolean z) {
            this.k = z;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c a() {
            return new com.anythink.expressad.video.dynview.c(this, (byte) 0);
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b b(float f) {
            this.e = f;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b b(int i) {
            this.f = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b b(java.lang.String str) {
            this.l = str;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b c(int i) {
            this.g = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b d(int i) {
            this.j = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.c.b
        public final com.anythink.expressad.video.dynview.c.b e(int i) {
            this.m = i;
            return this;
        }
    }

    public interface b {
        com.anythink.expressad.video.dynview.c.b a(float f);

        com.anythink.expressad.video.dynview.c.b a(int i);

        com.anythink.expressad.video.dynview.c.b a(android.content.Context context);

        com.anythink.expressad.video.dynview.c.b a(android.view.View view);

        com.anythink.expressad.video.dynview.c.b a(java.lang.String str);

        com.anythink.expressad.video.dynview.c.b a(java.util.List<com.anythink.expressad.foundation.d.c> list);

        com.anythink.expressad.video.dynview.c.b a(boolean z);

        com.anythink.expressad.video.dynview.c a();

        com.anythink.expressad.video.dynview.c.b b(float f);

        com.anythink.expressad.video.dynview.c.b b(int i);

        com.anythink.expressad.video.dynview.c.b b(java.lang.String str);

        com.anythink.expressad.video.dynview.c.b c(int i);

        com.anythink.expressad.video.dynview.c.b d(int i);

        com.anythink.expressad.video.dynview.c.b e(int i);
    }

    private c(com.anythink.expressad.video.dynview.c.a aVar) {
        this.e = aVar.e;
        this.d = aVar.d;
        this.f = aVar.f;
        this.g = aVar.g;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
    }

    public /* synthetic */ c(com.anythink.expressad.video.dynview.c.a aVar, byte b2) {
        this(aVar);
    }

    private static com.anythink.expressad.video.dynview.c.a l() {
        return new com.anythink.expressad.video.dynview.c.a();
    }

    public final android.content.Context a() {
        return this.a;
    }

    public final java.lang.String b() {
        return this.b;
    }

    public final float c() {
        return this.d;
    }

    public final float d() {
        return this.e;
    }

    public final int e() {
        return this.f;
    }

    public final android.view.View f() {
        return this.h;
    }

    public final java.util.List<com.anythink.expressad.foundation.d.c> g() {
        return this.i;
    }

    public final int h() {
        return this.c;
    }

    public final int i() {
        return this.j;
    }

    public final int j() {
        return this.g;
    }

    public final boolean k() {
        return this.k;
    }
}
