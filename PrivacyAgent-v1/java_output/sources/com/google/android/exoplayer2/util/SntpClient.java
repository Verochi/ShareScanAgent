package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class SntpClient {
    public static final java.lang.String DEFAULT_NTP_HOST = "time.android.com";
    public static final java.lang.Object a = new java.lang.Object();
    public static final java.lang.Object b = new java.lang.Object();

    @androidx.annotation.GuardedBy("valueLock")
    public static boolean c = false;

    @androidx.annotation.GuardedBy("valueLock")
    public static long d = 0;

    @androidx.annotation.GuardedBy("valueLock")
    public static java.lang.String e = "time.android.com";

    public interface InitializationCallback {
        void onInitializationFailed(java.io.IOException iOException);

        void onInitialized();
    }

    public static final class NtpTimeCallback implements com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.Loader.Loadable> {

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.util.SntpClient.InitializationCallback n;

        public NtpTimeCallback(@androidx.annotation.Nullable com.google.android.exoplayer2.util.SntpClient.InitializationCallback initializationCallback) {
            this.n = initializationCallback;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCanceled(com.google.android.exoplayer2.upstream.Loader.Loadable loadable, long j, long j2, boolean z) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public void onLoadCompleted(com.google.android.exoplayer2.upstream.Loader.Loadable loadable, long j, long j2) {
            if (this.n != null) {
                if (com.google.android.exoplayer2.util.SntpClient.isInitialized()) {
                    this.n.onInitialized();
                } else {
                    this.n.onInitializationFailed(new java.io.IOException(new java.util.ConcurrentModificationException()));
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.Loader.Loadable loadable, long j, long j2, java.io.IOException iOException, int i) {
            com.google.android.exoplayer2.util.SntpClient.InitializationCallback initializationCallback = this.n;
            if (initializationCallback != null) {
                initializationCallback.onInitializationFailed(iOException);
            }
            return com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
        }
    }

    public static final class NtpTimeLoadable implements com.google.android.exoplayer2.upstream.Loader.Loadable {
        public NtpTimeLoadable() {
        }

        public /* synthetic */ NtpTimeLoadable(com.google.android.exoplayer2.util.SntpClient.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws java.io.IOException {
            synchronized (com.google.android.exoplayer2.util.SntpClient.a) {
                synchronized (com.google.android.exoplayer2.util.SntpClient.b) {
                    if (com.google.android.exoplayer2.util.SntpClient.c) {
                        return;
                    }
                    long h = com.google.android.exoplayer2.util.SntpClient.h();
                    synchronized (com.google.android.exoplayer2.util.SntpClient.b) {
                        long unused = com.google.android.exoplayer2.util.SntpClient.d = h;
                        boolean unused2 = com.google.android.exoplayer2.util.SntpClient.c = true;
                    }
                }
            }
        }
    }

    public static void g(byte b2, byte b3, int i, long j) throws java.io.IOException {
        if (b2 == 3) {
            throw new java.io.IOException("SNTP: Unsynchronized server");
        }
        if (b3 != 4 && b3 != 5) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(26);
            sb.append("SNTP: Untrusted mode: ");
            sb.append((int) b3);
            throw new java.io.IOException(sb.toString());
        }
        if (i != 0 && i <= 15) {
            if (j == 0) {
                throw new java.io.IOException("SNTP: Zero transmitTime");
            }
        } else {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(36);
            sb2.append("SNTP: Untrusted stratum: ");
            sb2.append(i);
            throw new java.io.IOException(sb2.toString());
        }
    }

    public static long getElapsedRealtimeOffsetMs() {
        long j;
        synchronized (b) {
            j = c ? d : -9223372036854775807L;
        }
        return j;
    }

    public static java.lang.String getNtpHost() {
        java.lang.String str;
        synchronized (b) {
            str = e;
        }
        return str;
    }

    public static long h() throws java.io.IOException {
        java.net.InetAddress byName = java.net.InetAddress.getByName(getNtpHost());
        java.net.DatagramSocket datagramSocket = new java.net.DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            java.net.DatagramPacket datagramPacket = new java.net.DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = com.google.common.base.Ascii.ESC;
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            k(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new java.net.DatagramPacket(bArr, 48));
            long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            long j = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
            byte b2 = bArr[0];
            int i = bArr[1] & 255;
            long j2 = j(bArr, 24);
            long j3 = j(bArr, 32);
            long j4 = j(bArr, 40);
            g((byte) ((b2 >> 6) & 3), (byte) (b2 & 7), i, j4);
            long j5 = (j + (((j3 - j2) + (j4 - j)) / 2)) - elapsedRealtime2;
            datagramSocket.close();
            return j5;
        } catch (java.lang.Throwable th) {
            try {
                datagramSocket.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long i(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
    }

    public static void initialize(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.Loader loader, @androidx.annotation.Nullable com.google.android.exoplayer2.util.SntpClient.InitializationCallback initializationCallback) {
        if (isInitialized()) {
            if (initializationCallback != null) {
                initializationCallback.onInitialized();
            }
        } else {
            if (loader == null) {
                loader = new com.google.android.exoplayer2.upstream.Loader("SntpClient");
            }
            loader.startLoading(new com.google.android.exoplayer2.util.SntpClient.NtpTimeLoadable(null), new com.google.android.exoplayer2.util.SntpClient.NtpTimeCallback(initializationCallback), 1);
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (b) {
            z = c;
        }
        return z;
    }

    public static long j(byte[] bArr, int i) {
        long i2 = i(bArr, i);
        long i3 = i(bArr, i + 4);
        if (i2 == 0 && i3 == 0) {
            return 0L;
        }
        return ((i2 - 2208988800L) * 1000) + ((i3 * 1000) / tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_RIGHT);
    }

    public static void k(byte[] bArr, int i, long j) {
        if (j == 0) {
            java.util.Arrays.fill(bArr, i, i + 8, (byte) 0);
            return;
        }
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + 2208988800L;
        int i2 = i + 1;
        bArr[i] = (byte) (j4 >> 24);
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j4 >> 16);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j4 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j4 >> 0);
        long j5 = (j3 * tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_RIGHT) / 1000;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j5 >> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j5 >> 16);
        bArr[i7] = (byte) (j5 >> 8);
        bArr[i7 + 1] = (byte) (java.lang.Math.random() * 255.0d);
    }

    public static void setNtpHost(java.lang.String str) {
        synchronized (b) {
            if (!e.equals(str)) {
                e = str;
                c = false;
            }
        }
    }
}
