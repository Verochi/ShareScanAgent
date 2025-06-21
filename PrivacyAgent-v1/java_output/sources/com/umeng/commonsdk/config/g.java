package com.umeng.commonsdk.config;

/* loaded from: classes19.dex */
public class g implements com.umeng.commonsdk.config.e {
    @Override // com.umeng.commonsdk.config.e
    public void a(java.lang.String str, java.lang.Object obj, java.lang.String[] strArr) {
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            long parseLong = java.lang.Long.parseLong(str);
            if (parseLong == -1) {
                com.umeng.commonsdk.debug.UMRTLog.e("Config", "--->>> SensitiveFieldHandler: handleConfigItem: invalid config value.");
                return;
            }
            com.umeng.commonsdk.debug.UMRTLog.i("Config", "--->>> CollectFieldJudgment: handleConfigItem: item : " + str);
            if (obj == null || !(obj instanceof com.umeng.commonsdk.config.b)) {
                return;
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    java.lang.String str2 = strArr[i];
                    if (com.umeng.commonsdk.config.d.a(str2)) {
                        ((com.umeng.commonsdk.config.b) obj).a(str2, java.lang.Boolean.valueOf(com.umeng.commonsdk.config.a.a(parseLong, i)));
                    }
                } catch (java.lang.Throwable unused) {
                    return;
                }
            }
        } catch (java.lang.Throwable unused2) {
            com.umeng.commonsdk.debug.UMRTLog.e("Config", "--->>> SensitiveFieldHandler: handleConfigItem: parseLong exception.");
        }
    }
}
