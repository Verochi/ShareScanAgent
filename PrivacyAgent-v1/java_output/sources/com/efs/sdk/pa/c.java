package com.efs.sdk.pa;

/* loaded from: classes22.dex */
public final class c {
    private static java.lang.String a(android.content.Context context) {
        java.lang.Class<com.umeng.commonsdk.statistics.common.DeviceConfig> cls;
        java.lang.reflect.Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = com.umeng.commonsdk.statistics.common.DeviceConfig.class;
            java.lang.String str = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW;
        } catch (java.lang.ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getSid", android.content.Context.class);
        } catch (java.lang.NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            java.lang.Object invoke = method.invoke(null, context);
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused3) {
            return null;
        }
    }

    public static synchronized void a(com.efs.sdk.pa.PAFactory pAFactory, java.lang.String str, java.lang.String str2) {
        synchronized (com.efs.sdk.pa.c.class) {
            com.efs.sdk.base.protocol.file.EfsTextFile efsTextFile = new com.efs.sdk.base.protocol.file.EfsTextFile(str);
            com.efs.sdk.base.protocol.file.section.KVSection createAndAddKVSection = efsTextFile.createAndAddKVSection(com.qq.e.comm.managers.setting.GlobalSetting.CUSTOM_INFO_KEY);
            createAndAddKVSection.put("bserial", pAFactory.getSerial());
            createAndAddKVSection.put("bsver", pAFactory.getSver());
            java.util.HashMap<java.lang.String, java.lang.String> extend = pAFactory.getExtend();
            if (extend != null && !extend.isEmpty()) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : extend.entrySet()) {
                    createAndAddKVSection.put(entry.getKey(), entry.getValue());
                }
            }
            createAndAddKVSection.put("crver", "2.1.160.umeng");
            java.lang.String a = a(pAFactory.getContext());
            if (!android.text.TextUtils.isEmpty(a)) {
                createAndAddKVSection.put(com.umeng.umcrash.UMCrash.KEY_CALLBACK_SESSION_ID, a);
            }
            if (!android.text.TextUtils.isEmpty(str2)) {
                try {
                    java.lang.String onGetCallbackInfo = pAFactory.getPaClient().onGetCallbackInfo("um_user_string");
                    if (pAFactory.getPaClient() != null && !android.text.TextUtils.isEmpty(onGetCallbackInfo)) {
                        createAndAddKVSection.put("um_user_string", com.efs.sdk.base.core.util.secure.EncodeUtil.base64EncodeToStr(onGetCallbackInfo.getBytes()));
                    }
                    java.lang.String onGetCallbackInfo2 = pAFactory.getPaClient().onGetCallbackInfo(com.umeng.umcrash.UMCrash.KEY_CALLBACK_PAGE_ACTION);
                    if (pAFactory.getPaClient() != null && !android.text.TextUtils.isEmpty(onGetCallbackInfo2)) {
                        createAndAddKVSection.put(com.umeng.umcrash.UMCrash.KEY_CALLBACK_PAGE_ACTION, com.efs.sdk.base.core.util.secure.EncodeUtil.base64EncodeToStr(onGetCallbackInfo2.getBytes()));
                    }
                    java.lang.String customMappingJsonStr = com.efs.sdk.base.custommapping.InnerCustomMappingManager.getCustomMappingJsonStr();
                    if (pAFactory.getPaClient() != null && !android.text.TextUtils.isEmpty(customMappingJsonStr)) {
                        createAndAddKVSection.put(com.umeng.umcrash.UMCrash.KEY_CALLBACK_CUSTOM_MAPPING, com.efs.sdk.base.core.util.secure.EncodeUtil.base64EncodeToStr(customMappingJsonStr.getBytes()));
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                com.efs.sdk.base.protocol.file.section.TextSection createAndAddTextSection = efsTextFile.createAndAddTextSection("stack");
                createAndAddTextSection.setBody(str2);
                createAndAddTextSection.setSep(com.efs.sdk.base.protocol.file.section.AbsSection.SEP_LINE_BREAK);
            }
            com.efs.sdk.base.EfsReporter reporter = pAFactory.getReporter();
            if (reporter != null) {
                reporter.send(efsTextFile);
            }
            pAFactory.getConfigManager().increaseUploadSmoothLogCnt();
            "reportPaWpkStats: stack: ".concat(java.lang.String.valueOf(str2));
        }
    }
}
