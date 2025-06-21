package com.jd.ad.sdk.jad_oz;

/* loaded from: classes23.dex */
public final class jad_iv {
    public final int jad_an;
    public final int jad_bo;
    public final android.content.Context jad_cp;
    public final int jad_dq;

    public static final class jad_an {
        public static final int jad_er;
        public final android.content.Context jad_an;
        public android.app.ActivityManager jad_bo;
        public com.jd.ad.sdk.jad_oz.jad_iv.jad_cp jad_cp;
        public float jad_dq;

        static {
            jad_er = android.os.Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public jad_an(android.content.Context context) {
            this.jad_dq = jad_er;
            this.jad_an = context;
            this.jad_bo = (android.app.ActivityManager) context.getSystemService("activity");
            this.jad_cp = new com.jd.ad.sdk.jad_oz.jad_iv.jad_bo(context.getResources().getDisplayMetrics());
            if (android.os.Build.VERSION.SDK_INT < 26 || !com.jd.ad.sdk.jad_oz.jad_iv.jad_an(this.jad_bo)) {
                return;
            }
            this.jad_dq = 0.0f;
        }
    }

    public static final class jad_bo implements com.jd.ad.sdk.jad_oz.jad_iv.jad_cp {
        public final android.util.DisplayMetrics jad_an;

        public jad_bo(android.util.DisplayMetrics displayMetrics) {
            this.jad_an = displayMetrics;
        }

        public int jad_an() {
            return this.jad_an.heightPixels;
        }

        public int jad_bo() {
            return this.jad_an.widthPixels;
        }
    }

    public interface jad_cp {
    }

    public jad_iv(com.jd.ad.sdk.jad_oz.jad_iv.jad_an jad_anVar) {
        this.jad_cp = jad_anVar.jad_an;
        int i = jad_an(jad_anVar.jad_bo) ? 2097152 : 4194304;
        this.jad_dq = i;
        int jad_an2 = jad_an(jad_anVar.jad_bo, 0.4f, 0.33f);
        float jad_an3 = ((com.jd.ad.sdk.jad_oz.jad_iv.jad_bo) jad_anVar.jad_cp).jad_an() * ((com.jd.ad.sdk.jad_oz.jad_iv.jad_bo) jad_anVar.jad_cp).jad_bo() * 4;
        int round = java.lang.Math.round(jad_anVar.jad_dq * jad_an3);
        int round2 = java.lang.Math.round(jad_an3 * 2.0f);
        int i2 = jad_an2 - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.jad_bo = round2;
            this.jad_an = round;
        } else {
            float f = i2 / (jad_anVar.jad_dq + 2.0f);
            this.jad_bo = java.lang.Math.round(2.0f * f);
            this.jad_an = java.lang.Math.round(f * jad_anVar.jad_dq);
        }
        if (android.util.Log.isLoggable("MemorySizeCalculator", 3)) {
            java.lang.Object[] objArr = new java.lang.Object[1];
            java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Calculation complete, Calculated memory cache size: ");
            jad_an4.append(jad_an(this.jad_bo));
            jad_an4.append(", pool size: ");
            jad_an4.append(jad_an(this.jad_an));
            jad_an4.append(", byte array size: ");
            jad_an4.append(jad_an(i));
            jad_an4.append(", memory class limited? ");
            jad_an4.append(i3 > jad_an2);
            jad_an4.append(", max size: ");
            jad_an4.append(jad_an(jad_an2));
            jad_an4.append(", memoryClass: ");
            jad_an4.append(jad_anVar.jad_bo.getMemoryClass());
            jad_an4.append(", isLowMemoryDevice: ");
            jad_an4.append(jad_an(jad_anVar.jad_bo));
            objArr[0] = jad_an4.toString();
            com.jd.ad.sdk.logger.Logger.d("MemorySizeCalculator", objArr);
        }
    }

    public static int jad_an(android.app.ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (jad_an(activityManager)) {
            f = f2;
        }
        return java.lang.Math.round(memoryClass * f);
    }

    @android.annotation.TargetApi(19)
    public static boolean jad_an(android.app.ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    public final java.lang.String jad_an(int i) {
        return android.text.format.Formatter.formatFileSize(this.jad_cp, i);
    }
}
