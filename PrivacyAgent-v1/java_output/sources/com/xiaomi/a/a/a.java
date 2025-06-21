package com.xiaomi.a.a;

/* loaded from: classes19.dex */
public final class a {
    public boolean a;
    public boolean b;
    public boolean c;
    public long d;
    public long e;
    public long f;
    private java.lang.String g;

    /* renamed from: com.xiaomi.a.a.a$a, reason: collision with other inner class name */
    public static class C0531a {
        int a = -1;
        int b = -1;
        int c = -1;
        public java.lang.String d = null;
        public long e = -1;
        public long f = -1;
        public long g = -1;

        public final com.xiaomi.a.a.a.C0531a a(boolean z) {
            this.a = z ? 1 : 0;
            return this;
        }

        public final com.xiaomi.a.a.a a(android.content.Context context) {
            return new com.xiaomi.a.a.a(context, this, (byte) 0);
        }

        public final com.xiaomi.a.a.a.C0531a b(boolean z) {
            this.b = z ? 1 : 0;
            return this;
        }

        public final com.xiaomi.a.a.a.C0531a c(boolean z) {
            this.c = z ? 1 : 0;
            return this;
        }
    }

    private a() {
        this.a = true;
        this.b = false;
        this.c = false;
        this.d = 1048576L;
        this.e = com.anythink.expressad.d.a.b.aT;
        this.f = com.anythink.expressad.d.a.b.aT;
    }

    private a(android.content.Context context, com.xiaomi.a.a.a.C0531a c0531a) {
        this.a = true;
        this.b = false;
        this.c = false;
        this.d = 1048576L;
        this.e = com.anythink.expressad.d.a.b.aT;
        this.f = com.anythink.expressad.d.a.b.aT;
        if (c0531a.a == 0) {
            this.a = false;
        } else {
            this.a = true;
        }
        this.g = !android.text.TextUtils.isEmpty(c0531a.d) ? c0531a.d : com.xiaomi.push.as.a(context);
        long j = c0531a.e;
        if (j > -1) {
            this.d = j;
        } else {
            this.d = 1048576L;
        }
        long j2 = c0531a.f;
        if (j2 > -1) {
            this.e = j2;
        } else {
            this.e = com.anythink.expressad.d.a.b.aT;
        }
        long j3 = c0531a.g;
        if (j3 > -1) {
            this.f = j3;
        } else {
            this.f = com.anythink.expressad.d.a.b.aT;
        }
        int i = c0531a.b;
        if (i == 0 || i != 1) {
            this.b = false;
        } else {
            this.b = true;
        }
        int i2 = c0531a.c;
        if (i2 == 0 || i2 != 1) {
            this.c = false;
        } else {
            this.c = true;
        }
    }

    public /* synthetic */ a(android.content.Context context, com.xiaomi.a.a.a.C0531a c0531a, byte b) {
        this(context, c0531a);
    }

    public final java.lang.String toString() {
        return "Config{mEventEncrypted=" + this.a + ", mAESKey='" + this.g + "', mMaxFileLength=" + this.d + ", mEventUploadSwitchOpen=" + this.b + ", mPerfUploadSwitchOpen=" + this.c + ", mEventUploadFrequency=" + this.e + ", mPerfUploadFrequency=" + this.f + '}';
    }
}
