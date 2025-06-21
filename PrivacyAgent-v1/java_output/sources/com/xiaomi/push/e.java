package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class e {
    public static boolean a() {
        try {
            return android.os.Environment.getExternalStorageState().equals("removed");
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    public static boolean b() {
        try {
            return !android.os.Environment.getExternalStorageState().equals("mounted");
        } catch (java.lang.Exception e) {
            "check SDCard is busy: ".concat(java.lang.String.valueOf(e));
            return true;
        }
    }

    public static boolean c() {
        if (!b()) {
            if (!(d() <= com.alibaba.sdk.android.oss.common.OSSConstants.MIN_PART_SIZE_LIMIT) && !a()) {
                return true;
            }
        }
        return false;
    }

    private static long d() {
        java.io.File externalStorageDirectory;
        if (!b() && (externalStorageDirectory = android.os.Environment.getExternalStorageDirectory()) != null && !android.text.TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                android.os.StatFs statFs = new android.os.StatFs(externalStorageDirectory.getPath());
                return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
            } catch (java.lang.Throwable unused) {
            }
        }
        return 0L;
    }
}
