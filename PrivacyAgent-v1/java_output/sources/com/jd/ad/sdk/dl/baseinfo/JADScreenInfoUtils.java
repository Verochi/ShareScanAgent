package com.jd.ad.sdk.dl.baseinfo;

/* loaded from: classes23.dex */
public class JADScreenInfoUtils {
    public static int getScreenHeight(android.content.Context context) {
        try {
            if (com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("screenHeight")) {
                return jad_an(context)[1];
            }
            return -1;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    public static int getScreenWidth(android.content.Context context) {
        try {
            if (com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("screenWidth")) {
                return jad_an(context)[0];
            }
            return -1;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    public static int[] jad_an(android.content.Context context) {
        java.lang.String str;
        int[] iArr = new int[2];
        try {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("screenSize", true)) {
                str = jad_anVar.jad_dq("screenSize");
            } else {
                if (context == null) {
                    return iArr;
                }
                iArr = com.jd.ad.sdk.fdt.utils.ScreenUtils.getScreenSize(context);
                str = iArr[0] + "," + iArr[1];
                jad_anVar.jad_bo("screenSize", str);
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                java.lang.String[] split = str.split(",");
                if (split.length == 2) {
                    iArr[0] = java.lang.Integer.parseInt(split[0]);
                    iArr[1] = java.lang.Integer.parseInt(split[1]);
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return iArr;
    }
}
