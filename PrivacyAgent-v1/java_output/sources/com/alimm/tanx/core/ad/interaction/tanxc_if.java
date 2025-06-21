package com.alimm.tanx.core.ad.interaction;

/* loaded from: classes.dex */
public class tanxc_if {
    public static boolean tanxc_do(int i, long j) {
        if (i != 0) {
            if (i == 1 || i == 5 || i == 6 || i == 7 || i == 8) {
                return true;
            }
        } else {
            if (j == -1) {
                return false;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("isUserHit: diff = ");
            long j2 = currentTimeMillis - j;
            sb.append(j2);
            sb.append(", hitTest = ");
            sb.append(5000);
            com.alimm.tanx.core.utils.LogUtils.d("AdWebHelper", sb.toString());
            if (j2 > 5000) {
                return true;
            }
        }
        return false;
    }

    public static boolean tanxc_do(android.content.Context context, java.lang.String str) {
        com.alimm.tanx.core.ad.interaction.tanxc_for tanxc_forVar;
        if (!(!tanxc_do(str))) {
            return false;
        }
        tanxc_forVar = com.alimm.tanx.core.ad.interaction.tanxc_for.tanxc_do.tanxc_do;
        return tanxc_forVar.tanxc_do(context, str);
    }

    private static boolean tanxc_do(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https://");
    }
}
