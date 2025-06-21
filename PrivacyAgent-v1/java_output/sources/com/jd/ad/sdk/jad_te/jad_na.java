package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public final class jad_na {
    public static final boolean jad_hu;
    public static final java.io.File jad_iv;
    public static final boolean jad_jt;
    public static volatile com.jd.ad.sdk.jad_te.jad_na jad_jw;
    public static volatile int jad_kx;
    public final int jad_bo;
    public final int jad_cp;

    @androidx.annotation.GuardedBy("this")
    public int jad_dq;

    @androidx.annotation.GuardedBy("this")
    public boolean jad_er = true;
    public final java.util.concurrent.atomic.AtomicBoolean jad_fs = new java.util.concurrent.atomic.AtomicBoolean(false);
    public final boolean jad_an = jad_bo();

    static {
        int i = android.os.Build.VERSION.SDK_INT;
        jad_jt = i < 29;
        jad_hu = i >= 26;
        jad_iv = new java.io.File("/proc/self/fd");
        jad_kx = -1;
    }

    @androidx.annotation.VisibleForTesting
    public jad_na() {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            this.jad_bo = 20000;
            this.jad_cp = 0;
        } else {
            this.jad_bo = 700;
            this.jad_cp = 128;
        }
    }

    public static com.jd.ad.sdk.jad_te.jad_na jad_an() {
        if (jad_jw == null) {
            synchronized (com.jd.ad.sdk.jad_te.jad_na.class) {
                if (jad_jw == null) {
                    jad_jw = new com.jd.ad.sdk.jad_te.jad_na();
                }
            }
        }
        return jad_jw;
    }

    public static boolean jad_bo() {
        boolean z;
        if (android.os.Build.VERSION.SDK_INT == 26) {
            java.util.Iterator it = java.util.Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
            while (it.hasNext()) {
                if (android.os.Build.MODEL.startsWith((java.lang.String) it.next())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            if (!(android.os.Build.VERSION.SDK_INT != 27 ? false : java.util.Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(android.os.Build.MODEL))) {
                return true;
            }
        }
        return false;
    }

    @android.annotation.TargetApi(26)
    public boolean jad_an(int i, int i2, android.graphics.BitmapFactory.Options options, boolean z, boolean z2) {
        android.graphics.Bitmap.Config config;
        boolean jad_an = jad_an(i, i2, z, z2);
        if (jad_an) {
            config = android.graphics.Bitmap.Config.HARDWARE;
            options.inPreferredConfig = config;
            options.inMutable = false;
        }
        return jad_an;
    }

    public boolean jad_an(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        if (!z) {
            if (android.util.Log.isLoggable("HardwareConfig", 2)) {
                com.jd.ad.sdk.logger.Logger.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!this.jad_an) {
            if (android.util.Log.isLoggable("HardwareConfig", 2)) {
                com.jd.ad.sdk.logger.Logger.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        }
        if (!jad_hu) {
            if (android.util.Log.isLoggable("HardwareConfig", 2)) {
                com.jd.ad.sdk.logger.Logger.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (jad_jt && !this.jad_fs.get()) {
            if (android.util.Log.isLoggable("HardwareConfig", 2)) {
                com.jd.ad.sdk.logger.Logger.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z2) {
            if (android.util.Log.isLoggable("HardwareConfig", 2)) {
                com.jd.ad.sdk.logger.Logger.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        int i3 = this.jad_cp;
        if (i < i3) {
            if (android.util.Log.isLoggable("HardwareConfig", 2)) {
                com.jd.ad.sdk.logger.Logger.v("HardwareConfig", "Hardware config disallowed because width is too small");
            }
            return false;
        }
        if (i2 < i3) {
            if (android.util.Log.isLoggable("HardwareConfig", 2)) {
                com.jd.ad.sdk.logger.Logger.v("HardwareConfig", "Hardware config disallowed because height is too small");
            }
            return false;
        }
        synchronized (this) {
            int i4 = this.jad_dq + 1;
            this.jad_dq = i4;
            if (i4 >= 50) {
                this.jad_dq = 0;
                int length = jad_iv.list().length;
                long j = jad_kx != -1 ? jad_kx : this.jad_bo;
                boolean z4 = ((long) length) < j;
                this.jad_er = z4;
                if (!z4 && android.util.Log.isLoggable("Downsampler", 5)) {
                    com.jd.ad.sdk.logger.Logger.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + j);
                }
            }
            z3 = this.jad_er;
        }
        if (z3) {
            return true;
        }
        if (android.util.Log.isLoggable("HardwareConfig", 2)) {
            com.jd.ad.sdk.logger.Logger.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }
}
