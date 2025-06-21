package com.jd.ad.sdk.jad_dq;

/* loaded from: classes23.dex */
public final class jad_bo {

    public static class jad_an {
        public int jad_an;
        public int jad_bo;

        public final java.lang.String toString() {
            return this.jad_bo + "*" + this.jad_an;
        }
    }

    public static com.jd.ad.sdk.jad_dq.jad_bo.jad_an jad_an(android.content.Context context) {
        int i;
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.view.Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        int i2 = -1;
        if (defaultDisplay != null) {
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i3 = displayMetrics.widthPixels;
            int i4 = displayMetrics.heightPixels;
            if (i3 == -1 || i4 == -1) {
                android.util.DisplayMetrics displayMetrics2 = new android.util.DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                i = displayMetrics2.widthPixels;
                i2 = displayMetrics2.heightPixels;
            } else {
                i2 = i4;
                i = i3;
            }
        } else {
            i = -1;
        }
        com.jd.ad.sdk.jad_dq.jad_bo.jad_an jad_anVar = new com.jd.ad.sdk.jad_dq.jad_bo.jad_an();
        jad_anVar.jad_bo = i2;
        jad_anVar.jad_an = i;
        return jad_anVar;
    }
}
