package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
final class i {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5000;
    private static final int g = 10000000;
    private static final int h = 500000;
    private static final int i = 500000;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.b.i.a j;
    private int k;
    private long l;
    private long m;
    private long n;
    private long o;

    @android.annotation.TargetApi(19)
    public static final class a {
        private final android.media.AudioTrack a;
        private final android.media.AudioTimestamp b = new android.media.AudioTimestamp();
        private long c;
        private long d;
        private long e;

        public a(android.media.AudioTrack audioTrack) {
            this.a = audioTrack;
        }

        public final boolean a() {
            boolean timestamp = this.a.getTimestamp(this.b);
            if (timestamp) {
                long j = this.b.framePosition;
                if (this.d > j) {
                    this.c++;
                }
                this.d = j;
                this.e = j + (this.c << 32);
            }
            return timestamp;
        }

        public final long b() {
            return this.b.nanoTime / 1000;
        }

        public final long c() {
            return this.e;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface b {
    }

    public i(android.media.AudioTrack audioTrack) {
        if (com.anythink.expressad.exoplayer.k.af.a >= 19) {
            this.j = new com.anythink.expressad.exoplayer.b.i.a(audioTrack);
            e();
        } else {
            this.j = null;
            a(3);
        }
    }

    private void a(int i2) {
        this.k = i2;
        if (i2 == 0) {
            this.n = 0L;
            this.o = -1L;
            this.l = java.lang.System.nanoTime() / 1000;
            this.m = 5000L;
            return;
        }
        if (i2 == 1) {
            this.m = 5000L;
            return;
        }
        if (i2 == 2 || i2 == 3) {
            this.m = 10000000L;
        } else {
            if (i2 != 4) {
                throw new java.lang.IllegalStateException();
            }
            this.m = 500000L;
        }
    }

    public final void a() {
        a(4);
    }

    public final boolean a(long j) {
        com.anythink.expressad.exoplayer.b.i.a aVar = this.j;
        if (aVar == null || j - this.n < this.m) {
            return false;
        }
        this.n = j;
        boolean a2 = aVar.a();
        int i2 = this.k;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new java.lang.IllegalStateException();
                        }
                    } else if (a2) {
                        e();
                    }
                } else if (!a2) {
                    e();
                }
            } else if (!a2) {
                e();
            } else if (this.j.c() > this.o) {
                a(2);
            }
        } else if (a2) {
            if (this.j.b() < this.l) {
                return false;
            }
            this.o = this.j.c();
            a(1);
        } else if (j - this.l > 500000) {
            a(3);
        }
        return a2;
    }

    public final void b() {
        if (this.k == 4) {
            e();
        }
    }

    public final boolean c() {
        int i2 = this.k;
        return i2 == 1 || i2 == 2;
    }

    public final boolean d() {
        return this.k == 2;
    }

    public final void e() {
        if (this.j != null) {
            a(0);
        }
    }

    public final long f() {
        com.anythink.expressad.exoplayer.b.i.a aVar = this.j;
        if (aVar != null) {
            return aVar.b();
        }
        return -9223372036854775807L;
    }

    public final long g() {
        com.anythink.expressad.exoplayer.b.i.a aVar = this.j;
        if (aVar != null) {
            return aVar.c();
        }
        return -1L;
    }
}
