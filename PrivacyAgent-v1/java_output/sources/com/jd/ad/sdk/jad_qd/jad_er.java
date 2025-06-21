package com.jd.ad.sdk.jad_qd;

/* loaded from: classes23.dex */
public class jad_er {
    public static int jad_an(android.content.Context context) {
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("plugged")) {
            return -1;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            android.content.Intent registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"), null, null);
            int intExtra = registerReceiver.getIntExtra(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("plugged", -1);
            int intExtra3 = registerReceiver.getIntExtra("status", -1);
            jSONObject.put(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, intExtra);
            jSONObject.put("plugged", intExtra2);
            jSONObject.put("status", intExtra3);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while getBatteryInfo: ");
            jad_an.append(android.util.Log.getStackTraceString(e));
            com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
        }
        return jSONObject.optInt("plugged");
    }

    public static java.lang.String jad_an() {
        java.lang.String str = "";
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("board")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("board", true)) {
            str = (java.lang.String) jad_anVar.jad_bo("board");
        } else {
            str = android.os.Build.BOARD;
            jad_anVar.jad_bo("board", str);
        }
        return str;
    }

    public static java.lang.String jad_bo() {
        java.lang.String str = "";
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("hwModel")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("hwModel", true)) {
            str = jad_anVar.jad_dq("hwModel");
        } else {
            str = android.os.Build.DEVICE;
            jad_anVar.jad_bo("hwModel", str);
        }
        return str;
    }

    public static java.lang.String jad_bo(android.content.Context context) {
        java.lang.String str = "";
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("sysDiskSize")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("sysDiskSize", true)) {
            str = jad_anVar.jad_dq("sysDiskSize");
        } else if (context != null) {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
            str = java.lang.String.valueOf(statFs.getBlockCount() * statFs.getBlockSize());
            jad_anVar.jad_bo("sysDiskSize", str);
        }
        return str;
    }

    public static java.lang.String jad_cp() {
        java.lang.String str = "";
        if (!com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("sysMemory")) {
            return "";
        }
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("sysMemory", true)) {
            str = jad_anVar.jad_dq("sysMemory");
        } else {
            str = com.jd.ad.sdk.jad_fq.jad_er.jad_an();
            jad_anVar.jad_bo("sysMemory", str);
        }
        return str;
    }
}
