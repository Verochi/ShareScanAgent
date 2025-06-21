package com.alimm.tanx.core.ad.interaction;

/* loaded from: classes.dex */
public class tanxc_for {
    private long tanxc_do;

    public static class tanxc_do {
        private static final com.alimm.tanx.core.ad.interaction.tanxc_for tanxc_do = new com.alimm.tanx.core.ad.interaction.tanxc_for((byte) 0);
    }

    private tanxc_for() {
    }

    public /* synthetic */ tanxc_for(byte b) {
        this();
    }

    private void tanxc_do(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "DeepLinkManager", str, "forwardToActivityTask", str2, str3, str4, "DeepLinkManager");
    }

    private boolean tanxc_do(android.content.Context context, android.content.Intent intent, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "startActivity...");
        try {
            context.startActivity(intent);
            return true;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("DeepLinkManager", e);
            e.printStackTrace();
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "DeepLinkManager", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "startActivityTask", str, str2, str3, "DeepLinkManager");
            com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "startActivity failed.");
            return false;
        }
    }

    private boolean tanxc_if(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "start..");
        if (android.text.TextUtils.isEmpty(str)) {
            com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "forwardToActivity deepLinkUrl is null or empty.");
            return false;
        }
        try {
            com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "start parseUri");
            android.content.Intent parseUri = android.content.Intent.parseUri(str, 1);
            if (parseUri == null) {
                tanxc_do("intent == null", str3, str2, str);
            }
            if (parseUri != null) {
                parseUri.setFlags(805339136);
            }
            com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "start startActivity");
            int i = android.os.Build.VERSION.SDK_INT;
            if (i < 30 || context.getApplicationContext().getApplicationInfo().targetSdkVersion < 30) {
                boolean z = context.getPackageManager().resolveActivity(parseUri, 0) != null;
                if (!z) {
                    tanxc_do("2appInstalled为false-sdk_version:" + i + ",targetSdkVersion" + context.getApplicationContext().getApplicationInfo().targetSdkVersion, str3, str2, str);
                }
                return com.alimm.tanx.core.orange.OrangeManager.getInstance().getCommonSwitch("resolveActivitySwitch") ? parseUri != null && z && tanxc_do(context, parseUri, str3, str2, str) : parseUri != null && tanxc_do(context, parseUri, str3, str2, str);
            }
            com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "设备和targetSdkVersion均>=30");
            if (androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.QUERY_ALL_PACKAGES") != 0) {
                com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "没有权限:QUERY_ALL_PACKAGES");
                return parseUri != null && tanxc_do(context, parseUri, str3, str2, str);
            }
            com.alimm.tanx.core.utils.LogUtils.d("DeepLinkManager", "有权限:QUERY_ALL_PACKAGES");
            boolean z2 = context.getPackageManager().resolveActivity(parseUri, 0) != null;
            if (!z2) {
                tanxc_do("1appInstalled为false-sdk_version:" + i + ",targetSdkVersion" + context.getApplicationContext().getApplicationInfo().targetSdkVersion, str3, str2, str);
            }
            return com.alimm.tanx.core.orange.OrangeManager.getInstance().getCommonSwitch("resolveActivitySwitch30") ? parseUri != null && z2 && tanxc_do(context, parseUri, str3, str2, str) : parseUri != null && tanxc_do(context, parseUri, str3, str2, str);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("DeepLinkManager", e);
            tanxc_do(com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), str3, str2, str);
            return false;
        }
    }

    public boolean tanxc_do(android.content.Context context, java.lang.String str) {
        return tanxc_do(context, str, "", "");
    }

    public boolean tanxc_do(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        boolean tanxc_if = tanxc_if(context, str, str2, str3);
        if (tanxc_if) {
            this.tanxc_do = java.lang.System.currentTimeMillis();
            com.alimm.tanx.core.utils.TanxTestLog.sendLog("deepLink", str);
        } else {
            this.tanxc_do = -1L;
        }
        com.alimm.tanx.core.utils.LogUtils.v("DeepLinkManager", "forwardToDeepLink: forwardSucceed = " + tanxc_if);
        return tanxc_if;
    }
}
