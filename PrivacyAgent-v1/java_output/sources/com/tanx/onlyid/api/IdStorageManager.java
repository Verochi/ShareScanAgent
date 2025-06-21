package com.tanx.onlyid.api;

/* loaded from: classes19.dex */
public class IdStorageManager {
    public static final java.lang.String KEY_ANDROID_ID = "KEY_ANDROID_ID";
    public static final java.lang.String KEY_CLIENT_ID = "KEY_CLIENT_ID";
    public static final java.lang.String KEY_IMEI = "KEY_IMEI";
    public static final java.lang.String KEY_OAID = "KEY_OAID";
    public static final java.lang.String KEY_PSEUDO_ID = "KEY_PSEUDO_ID";
    public static final java.lang.String KEY_WIDEVINE_ID = "KEY_WIDEVINE_ID";
    public static final java.lang.String b = "IdStorageManager";
    public static com.tanx.onlyid.api.IdStorageManager instance;
    public android.content.SharedPreferences a;

    /* renamed from: com.tanx.onlyid.api.IdStorageManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String n;
        public final /* synthetic */ java.lang.String t;

        public AnonymousClass1(java.lang.String str, java.lang.String str2) {
            this.n = str;
            this.t = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                android.content.SharedPreferences.Editor edit = com.tanx.onlyid.api.IdStorageManager.this.a.edit();
                edit.putString(this.n, this.t);
                edit.apply();
            } catch (java.lang.Exception unused) {
                java.lang.String unused2 = com.tanx.onlyid.api.IdStorageManager.b;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("putString异常 key");
                sb.append(this.n);
                sb.append(" value:");
                sb.append(this.t);
            }
        }
    }

    public IdStorageManager(android.content.Context context) {
        this.a = android.preference.PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static com.tanx.onlyid.api.IdStorageManager getInstance(android.content.Context context) {
        if (instance == null) {
            synchronized (com.tanx.onlyid.api.IdStorageManager.class) {
                if (instance == null) {
                    instance = new com.tanx.onlyid.api.IdStorageManager(context);
                }
            }
        }
        return instance;
    }

    public java.lang.String getString(java.lang.String str) {
        try {
            return this.a.getString(str, "");
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getString异常 key:");
            sb.append(str);
            return "";
        }
    }

    public void putId(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            putString(str, str2);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("key:");
        sb.append(str);
        sb.append(" v");
        sb.append(str2);
        sb.append(" 过程有key或value为空，终止");
    }

    public void putString(java.lang.String str, java.lang.String str2) {
        com.tanx.onlyid.api.ThreadPool.post(new com.tanx.onlyid.api.IdStorageManager.AnonymousClass1(str, str2));
    }
}
