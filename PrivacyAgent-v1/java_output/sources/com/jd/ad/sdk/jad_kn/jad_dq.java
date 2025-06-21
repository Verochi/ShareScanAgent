package com.jd.ad.sdk.jad_kn;

/* loaded from: classes23.dex */
public class jad_dq {
    public static java.util.List<java.lang.String> jad_bo = java.util.Arrays.asList("Lenovo TB-J606F", "Xiaomi Pad 5 Pro", "Xiaomi Pad 5", "Lenovo TB-9707F", "AGS3-AL09HN", "AGR-AL09HN", "AGS3K-AL20", "SM-T735C", "SM-X205C", "AGM3-AL09HN", "BAH2-AL10", "CMR-AL19", "AGS2-AL00", "AGS3-AL00", "BAH2-AL10", "JDN2-AL50HN", "JDN2-AL50", "AGS2-AL00HN", "JDN2-AL00HN", "JDN2-AL00", "SM-T505C", "HDL-AL09", "CPN-AL00", "MI PAD 4 PLUS", "MI PAD 4", "SM-T725C", "BTV-DL09", "BAH-AL00", "SHT-AL09", "DBY-W09", "BAH3-W59", "MRX-W09", "MRR-W29", "SCM-W09", "MRX-W29", "SCM-W09", "MRX-W29", "SCM-W09", "MRX-W29", "SCMR-W09", "TAS-AN00", "BRT-W09", "KJR-W09", "WGR-W09", "BAH3-W09", "AGM3-W09HN", "VRD-W09", "VRD-W10", "KRJ-W09", "BTV-W09", "PA2170", "GOT-W09", "OPD2101", "AGS2-W09HN", "JDN2-W09HN", "JDN2-W09", "BAH2-W09", "CMR-W09", "BAH2-W09", "KRJ2-W09", "AGS3-W00E", "AGS2-W09", "BAH4-W29", "M2012K11AC", "BAH4-W29", "SHT-W09", "LSA-AN00", "GOT-W29", "MRX-W19", "MRX-W39", "SHT-W09", "GOT-W29", "MRX-W19", "MRX-W39", "HEY-W09");
    public android.content.Context jad_an;

    public jad_dq(android.content.Context context) {
        this.jad_an = context;
    }

    public final boolean jad_an() {
        try {
            java.lang.String bluetoothName = com.jd.android.sdk.coreinfo.CoreInfo.Device.getBluetoothName(this.jad_an);
            if (!bluetoothName.contains("平板") && !bluetoothName.contains("Pad")) {
                if (!bluetoothName.contains("Tab")) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_bo.jad_bo.jad_an("bluetoothNameCheck异常").append(e.getMessage());
            return false;
        }
    }

    public final boolean jad_bo() {
        try {
            return jad_bo.contains(android.os.Build.MODEL);
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_bo.jad_bo.jad_an("modelListCheck异常").append(e.getMessage());
            return false;
        }
    }

    public boolean jad_cp() {
        try {
            boolean z = (this.jad_an.getResources().getConfiguration().screenLayout & 15) >= 3;
            android.view.Display defaultDisplay = ((android.view.WindowManager) this.jad_an.getSystemService("window")).getDefaultDisplay();
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return z || java.lang.Math.sqrt(java.lang.Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + java.lang.Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
