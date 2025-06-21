package com.umeng.vt.diff;

/* loaded from: classes19.dex */
public class Channel {
    private static final java.lang.String UM_VISUAL_IMPRINT = "utm-visual";

    /* renamed from: com.umeng.vt.diff.Channel$1, reason: invalid class name */
    public class AnonymousClass1 implements com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass1(android.content.Context context) {
            this.val$context = context;
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
            if (com.umeng.vt.diff.Channel.UM_VISUAL_IMPRINT.equals(str)) {
                com.umeng.vt.diff.Channel.this.loadConfig(this.val$context);
            }
        }
    }

    private void download() {
        java.lang.reflect.Method method;
        try {
            java.lang.Class<?> findClass = com.umeng.vt.diff.util.ClassLoadUtil.findClass("com.umeng.vt.vismode.config.ConfigTools");
            if (findClass == null || (method = findClass.getMethod("download", new java.lang.Class[0])) == null) {
                return;
            }
            method.invoke(findClass.getMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]), new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void storeConfig(java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.reflect.Method method;
        try {
            java.lang.Class<?> findClass = com.umeng.vt.diff.util.ClassLoadUtil.findClass("com.umeng.vt.vismode.config.ConfigTools");
            if (findClass == null || (method = findClass.getMethod("storeConfig", java.util.Map.class)) == null) {
                return;
            }
            method.invoke(findClass.getMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]), map);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void init(android.content.Context context) {
        if (context == null) {
            return;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        loadConfig(applicationContext);
        registerListener(applicationContext);
    }

    public void loadConfig(android.content.Context context) {
        java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, UM_VISUAL_IMPRINT, null);
        if (android.text.TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        java.lang.String str = new java.lang.String(android.util.Base64.decode(imprintProperty, 0));
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("data-track", str);
        storeConfig(hashMap);
    }

    public void registerListener(android.content.Context context) {
        com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(context).registImprintCallback(UM_VISUAL_IMPRINT, new com.umeng.vt.diff.Channel.AnonymousClass1(context));
    }
}
