package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class as {
    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return context == null ? str2 : com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, str, str2);
    }

    public static java.util.Map<java.lang.String, java.lang.String> a() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.umeng.analytics.pro.bo.bi, com.umeng.commonsdk.internal.a.e);
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_ANALYTICS_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bj, com.umeng.commonsdk.utils.UMUtils.VALUE_ANALYTICS_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_GAME_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bk, com.umeng.commonsdk.utils.UMUtils.VALUE_GAME_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_PUSH_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bl, com.umeng.commonsdk.utils.UMUtils.VALUE_PUSH_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_SHARE_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bm, com.umeng.commonsdk.utils.UMUtils.VALUE_SHARE_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_APM_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bn, com.umeng.commonsdk.utils.UMUtils.VALUE_APM_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_VERIFY_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bo, com.umeng.commonsdk.utils.UMUtils.VALUE_VERIFY_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_SMS_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bp, com.umeng.commonsdk.utils.UMUtils.VALUE_SMS_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_REC_VERSION_NAME)) {
            hashMap.put(com.umeng.analytics.pro.bo.bq, com.umeng.commonsdk.utils.UMUtils.VALUE_REC_VERSION_NAME);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_VISUAL_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.br, com.umeng.commonsdk.utils.UMUtils.VALUE_VISUAL_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_ASMS_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bs, com.umeng.commonsdk.utils.UMUtils.VALUE_ASMS_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_LINK_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bt, com.umeng.commonsdk.utils.UMUtils.VALUE_LINK_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_ABTEST_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bu, com.umeng.commonsdk.utils.UMUtils.VALUE_ABTEST_VERSION);
        }
        if (!android.text.TextUtils.isEmpty(com.umeng.commonsdk.utils.UMUtils.VALUE_ANTI_VERSION)) {
            hashMap.put(com.umeng.analytics.pro.bo.bv, com.umeng.commonsdk.utils.UMUtils.VALUE_ANTI_VERSION);
        }
        return hashMap;
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(org.json.JSONObject jSONObject) {
        java.lang.String str;
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                java.lang.String valueOf = java.lang.String.valueOf(keys.next());
                if (!android.text.TextUtils.isEmpty(valueOf) && (str = (java.lang.String) jSONObject.get(valueOf)) != null) {
                    hashMap.put(valueOf, str);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return hashMap;
    }

    public static void a(android.content.Context context, java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.uyumao.sdk.UYMManager");
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("processEvent", android.content.Context.class, java.lang.String.class);
            if (declaredMethod != null) {
                declaredMethod.invoke(cls, context, str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Throwable unused) {
            }
        }
    }
}
