package com.igexin.push.core;

/* loaded from: classes23.dex */
public final class j {
    private static final java.lang.String b = "HeartBeatGenerator";
    private static com.igexin.push.core.j e;
    public long a = 240000;
    private int c = com.igexin.push.core.j.b.a;
    private long d = 0;

    /* renamed from: com.igexin.push.core.j$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.igexin.push.core.j.a.a().length];
            b = iArr;
            try {
                iArr[com.igexin.push.core.j.a.a - 1] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                b[com.igexin.push.core.j.a.b - 1] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                b[com.igexin.push.core.j.a.c - 1] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                b[com.igexin.push.core.j.a.d - 1] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[com.igexin.push.core.j.b.a().length];
            a = iArr2;
            try {
                iArr2[com.igexin.push.core.j.b.a - 1] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.igexin.push.core.j.b.b - 1] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.igexin.push.core.j.b.c - 1] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = {1, 2, 3, 4};

        private a(java.lang.String str, int i) {
        }

        public static int[] a() {
            return (int[]) e.clone();
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};

        private b(java.lang.String str, int i) {
        }

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    private j() {
    }

    public static com.igexin.push.core.j a() {
        if (e == null) {
            e = new com.igexin.push.core.j();
        }
        return e;
    }

    private void a(long j) {
        this.a = j;
    }

    private void b(int i) {
        int i2;
        int i3 = com.igexin.push.core.j.AnonymousClass1.b[i - 1];
        if (i3 == 1) {
            this.a = java.lang.Math.min(this.a + 60000, com.igexin.push.config.c.n);
            i2 = com.igexin.push.core.j.b.a;
        } else {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                this.a = 240000L;
                e(com.igexin.push.core.j.b.a);
                return;
            }
            long j = this.d + 1;
            this.d = j;
            if (j < 2) {
                return;
            }
            this.a = java.lang.Math.max(this.a - 60000, 240000L);
            i2 = com.igexin.push.core.j.b.b;
        }
        e(i2);
    }

    private void c(int i) {
        int i2;
        int i3 = com.igexin.push.core.j.AnonymousClass1.b[i - 1];
        if (i3 == 1) {
            i2 = com.igexin.push.core.j.b.b;
        } else {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                this.a = 240000L;
                e(com.igexin.push.core.j.b.a);
                return;
            }
            this.a = java.lang.Math.max(this.a - 60000, 240000L);
            long j = this.d + 1;
            this.d = j;
            if (j < 2) {
                return;
            }
            this.a = 240000L;
            i2 = com.igexin.push.core.j.b.c;
        }
        e(i2);
    }

    private void d(int i) {
        int i2;
        int i3 = com.igexin.push.core.j.AnonymousClass1.b[i - 1];
        if (i3 == 1) {
            this.a = 240000L;
            i2 = com.igexin.push.core.j.b.a;
        } else {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                this.a = 240000L;
                e(com.igexin.push.core.j.b.a);
                return;
            }
            i2 = com.igexin.push.core.j.b.c;
        }
        e(i2);
    }

    private void e(int i) {
        this.c = i;
        this.d = 0L;
    }

    public final void a(int i) {
        int i2;
        int i3 = com.igexin.push.core.j.AnonymousClass1.a[this.c - 1];
        if (i3 != 1) {
            if (i3 == 2) {
                int i4 = com.igexin.push.core.j.AnonymousClass1.b[i - 1];
                if (i4 != 1) {
                    if (i4 != 2 && i4 != 3) {
                        if (i4 != 4) {
                            return;
                        }
                        this.a = 240000L;
                        e(com.igexin.push.core.j.b.a);
                        return;
                    }
                    this.a = java.lang.Math.max(this.a - 60000, 240000L);
                    long j = this.d + 1;
                    this.d = j;
                    if (j < 2) {
                        return;
                    } else {
                        this.a = 240000L;
                    }
                }
                i2 = com.igexin.push.core.j.b.b;
            } else {
                if (i3 != 3) {
                    return;
                }
                int i5 = com.igexin.push.core.j.AnonymousClass1.b[i - 1];
                if (i5 == 1) {
                    this.a = 240000L;
                    i2 = com.igexin.push.core.j.b.a;
                } else if (i5 != 2 && i5 != 3) {
                    if (i5 != 4) {
                        return;
                    }
                    this.a = 240000L;
                    e(com.igexin.push.core.j.b.a);
                    return;
                }
            }
            i2 = com.igexin.push.core.j.b.c;
        } else {
            int i6 = com.igexin.push.core.j.AnonymousClass1.b[i - 1];
            if (i6 == 1) {
                this.a = java.lang.Math.min(this.a + 60000, com.igexin.push.config.c.n);
                i2 = com.igexin.push.core.j.b.a;
            } else {
                if (i6 != 2 && i6 != 3) {
                    if (i6 != 4) {
                        return;
                    }
                    this.a = 240000L;
                    e(com.igexin.push.core.j.b.a);
                    return;
                }
                long j2 = this.d + 1;
                this.d = j2;
                if (j2 < 2) {
                    return;
                }
                this.a = java.lang.Math.max(this.a - 60000, 240000L);
                i2 = com.igexin.push.core.j.b.b;
            }
        }
        e(i2);
    }

    public final long b() {
        long j = this.a;
        int i = com.igexin.push.config.d.e;
        if (i > 0) {
            j = i * 1000;
        }
        if (com.igexin.push.core.e.n && com.igexin.push.core.e.u && com.igexin.push.core.d.a.a.h.b) {
            return j;
        }
        return 3600000L;
    }
}
