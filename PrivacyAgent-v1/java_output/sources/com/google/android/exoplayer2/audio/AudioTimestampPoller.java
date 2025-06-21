package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
final class AudioTimestampPoller {

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.audio.AudioTimestampPoller.AudioTimestampV19 a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;

    @androidx.annotation.RequiresApi(19)
    public static final class AudioTimestampV19 {
        public final android.media.AudioTrack a;
        public final android.media.AudioTimestamp b = new android.media.AudioTimestamp();
        public long c;
        public long d;
        public long e;

        public AudioTimestampV19(android.media.AudioTrack audioTrack) {
            this.a = audioTrack;
        }

        public long a() {
            return this.e;
        }

        public long b() {
            return this.b.nanoTime / 1000;
        }

        public boolean c() {
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
    }

    public AudioTimestampPoller(android.media.AudioTrack audioTrack) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 19) {
            this.a = new com.google.android.exoplayer2.audio.AudioTimestampPoller.AudioTimestampV19(audioTrack);
            g();
        } else {
            this.a = null;
            h(3);
        }
    }

    public void a() {
        if (this.b == 4) {
            g();
        }
    }

    @android.annotation.TargetApi(19)
    public long b() {
        com.google.android.exoplayer2.audio.AudioTimestampPoller.AudioTimestampV19 audioTimestampV19 = this.a;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.a();
        }
        return -1L;
    }

    @android.annotation.TargetApi(19)
    public long c() {
        com.google.android.exoplayer2.audio.AudioTimestampPoller.AudioTimestampV19 audioTimestampV19 = this.a;
        if (audioTimestampV19 != null) {
            return audioTimestampV19.b();
        }
        return -9223372036854775807L;
    }

    public boolean d() {
        return this.b == 2;
    }

    @android.annotation.TargetApi(19)
    public boolean e(long j) {
        com.google.android.exoplayer2.audio.AudioTimestampPoller.AudioTimestampV19 audioTimestampV19 = this.a;
        if (audioTimestampV19 == null || j - this.e < this.d) {
            return false;
        }
        this.e = j;
        boolean c = audioTimestampV19.c();
        int i = this.b;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new java.lang.IllegalStateException();
                        }
                    } else if (c) {
                        g();
                    }
                } else if (!c) {
                    g();
                }
            } else if (!c) {
                g();
            } else if (this.a.a() > this.f) {
                h(2);
            }
        } else if (c) {
            if (this.a.b() < this.c) {
                return false;
            }
            this.f = this.a.a();
            h(1);
        } else if (j - this.c > 500000) {
            h(3);
        }
        return c;
    }

    public void f() {
        h(4);
    }

    public void g() {
        if (this.a != null) {
            h(0);
        }
    }

    public final void h(int i) {
        this.b = i;
        if (i == 0) {
            this.e = 0L;
            this.f = -1L;
            this.c = java.lang.System.nanoTime() / 1000;
            this.d = 10000L;
            return;
        }
        if (i == 1) {
            this.d = 10000L;
            return;
        }
        if (i == 2 || i == 3) {
            this.d = 10000000L;
        } else {
            if (i != 4) {
                throw new java.lang.IllegalStateException();
            }
            this.d = 500000L;
        }
    }
}
