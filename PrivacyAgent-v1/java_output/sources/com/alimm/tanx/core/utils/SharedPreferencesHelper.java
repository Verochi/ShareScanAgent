package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class SharedPreferencesHelper implements com.alimm.tanx.core.utils.NotConfused {
    public static final java.lang.String KEY_DEBUG_URL_SWITCH = "KEY_DEBUG_URL_SWITCH";
    public static final java.lang.String KEY_ENCRYPT_SWITCH = "KEY_ENCRYPT_SWITCH";
    public static final java.lang.String KEY_HTTPS_SWITCH = "KEY_HTTPS_SWITCH";
    public static final java.lang.String KEY_ORANGE = "KEY_ORANGE";
    public static final java.lang.String KEY_SETTING = "KEY_SETTING";
    public static final java.lang.String KEY_SPLASH_AD_COUNT = "key_splash_ad_count";
    public static final java.lang.String KEY_SPLASH_COVER = "KEY_SPLASH_COVER";
    public static final java.lang.String KEY_SPLASH_COVER_H_RATIO = "key_splash_cover_h_ratio";
    public static final java.lang.String KEY_SPLASH_COVER_TIME = "key_splash_cover_time";
    public static final java.lang.String KEY_SPLASH_COVER_TIME_DURATION = "key_splash_cover_time_duration";
    public static final java.lang.String KEY_SPLASH_COVER_W_RATIO = "key_splash_cover_w_ratio";
    public static final java.lang.String KEY_SPLASH_PRELOAD_SWITCH = "KEY_SPLASH_PRELOAD_SWITCH";
    public static final java.lang.String REWARD_URL = "RewardUrl";
    private static final java.lang.String TAG = "SharedPreferencesHelper";
    private static com.alimm.tanx.core.utils.SharedPreferencesHelper mInstance;
    private final android.content.SharedPreferences mPrefs;

    /* renamed from: com.alimm.tanx.core.utils.SharedPreferencesHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends com.alimm.tanx.core.utils.ThreadUtils.SimpleTask<java.lang.Object> {
        final /* synthetic */ java.lang.String val$k;
        final /* synthetic */ java.lang.String val$v;

        public AnonymousClass1(java.lang.String str, java.lang.String str2) {
            this.val$k = str;
            this.val$v = str2;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public java.lang.Object doInBackground() throws java.lang.Throwable {
            android.content.SharedPreferences.Editor edit = com.alimm.tanx.core.utils.SharedPreferencesHelper.this.mPrefs.edit();
            edit.putString(this.val$k, this.val$v);
            edit.apply();
            return null;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onSuccess(java.lang.Object obj) {
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.SharedPreferencesHelper$2, reason: invalid class name */
    public class AnonymousClass2 extends com.alimm.tanx.core.utils.ThreadUtils.SimpleTask<java.lang.Object> {
        final /* synthetic */ java.lang.String val$k;
        final /* synthetic */ float val$v;

        public AnonymousClass2(java.lang.String str, float f) {
            this.val$k = str;
            this.val$v = f;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public java.lang.Object doInBackground() throws java.lang.Throwable {
            android.content.SharedPreferences.Editor edit = com.alimm.tanx.core.utils.SharedPreferencesHelper.this.mPrefs.edit();
            edit.putFloat(this.val$k, this.val$v);
            edit.apply();
            return null;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onSuccess(java.lang.Object obj) {
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.SharedPreferencesHelper$3, reason: invalid class name */
    public class AnonymousClass3 extends com.alimm.tanx.core.utils.ThreadUtils.SimpleTask<java.lang.Object> {
        final /* synthetic */ java.lang.String val$k;
        final /* synthetic */ java.lang.Integer val$v;

        public AnonymousClass3(java.lang.String str, java.lang.Integer num) {
            this.val$k = str;
            this.val$v = num;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public java.lang.Object doInBackground() throws java.lang.Throwable {
            android.content.SharedPreferences.Editor edit = com.alimm.tanx.core.utils.SharedPreferencesHelper.this.mPrefs.edit();
            edit.putInt(this.val$k, this.val$v.intValue());
            edit.apply();
            return null;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onSuccess(java.lang.Object obj) {
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.SharedPreferencesHelper$4, reason: invalid class name */
    public class AnonymousClass4 extends com.alimm.tanx.core.utils.ThreadUtils.SimpleTask<java.lang.Object> {
        final /* synthetic */ boolean val$v;

        public AnonymousClass4(boolean z) {
            this.val$v = z;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public java.lang.Object doInBackground() throws java.lang.Throwable {
            android.content.SharedPreferences.Editor edit = com.alimm.tanx.core.utils.SharedPreferencesHelper.this.mPrefs.edit();
            edit.putBoolean(com.alimm.tanx.core.utils.SharedPreferencesHelper.KEY_DEBUG_URL_SWITCH, this.val$v);
            edit.apply();
            return null;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onSuccess(java.lang.Object obj) {
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.SharedPreferencesHelper$5, reason: invalid class name */
    public class AnonymousClass5 extends com.alimm.tanx.core.utils.ThreadUtils.SimpleTask<java.lang.Object> {
        final /* synthetic */ java.lang.String val$key;
        final /* synthetic */ java.lang.Boolean val$v;

        public AnonymousClass5(java.lang.String str, java.lang.Boolean bool) {
            this.val$key = str;
            this.val$v = bool;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public java.lang.Object doInBackground() throws java.lang.Throwable {
            android.content.SharedPreferences.Editor edit = com.alimm.tanx.core.utils.SharedPreferencesHelper.this.mPrefs.edit();
            edit.putBoolean(this.val$key, this.val$v.booleanValue());
            edit.apply();
            return null;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onSuccess(java.lang.Object obj) {
        }
    }

    private SharedPreferencesHelper(android.content.Context context) {
        this.mPrefs = android.preference.PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static com.alimm.tanx.core.utils.SharedPreferencesHelper getInstance() {
        return getInstance(com.alimm.tanx.core.TanxCoreSdk.getApplication());
    }

    public static com.alimm.tanx.core.utils.SharedPreferencesHelper getInstance(android.content.Context context) {
        if (mInstance == null) {
            synchronized (com.alimm.tanx.core.utils.SharedPreferencesHelper.class) {
                if (mInstance == null) {
                    mInstance = new com.alimm.tanx.core.utils.SharedPreferencesHelper(context);
                }
            }
        }
        return mInstance;
    }

    public boolean getBoolean(java.lang.String str, java.lang.Boolean bool) {
        return this.mPrefs.getBoolean(str, bool.booleanValue());
    }

    public boolean getDebugUrlBoolean() {
        boolean z = this.mPrefs.getBoolean(KEY_DEBUG_URL_SWITCH, false);
        com.alimm.tanx.core.utils.LogUtils.d2print(TAG, "now deBugUrl Switch ->" + z);
        return z;
    }

    public boolean getEncryptBoolean() {
        boolean z = getBoolean(KEY_ENCRYPT_SWITCH, java.lang.Boolean.TRUE);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "now encryptSwitch ->" + z);
        return z;
    }

    public float getFloat(java.lang.String str) {
        return this.mPrefs.getFloat(str, 0.0f);
    }

    public boolean getHttpsBoolean() {
        boolean z = getBoolean(KEY_HTTPS_SWITCH, java.lang.Boolean.FALSE);
        com.alimm.tanx.core.utils.LogUtils.d2print(TAG, "now httpsSwitch ->" + z);
        return z;
    }

    public int getInt(java.lang.String str) {
        return this.mPrefs.getInt(str, 0);
    }

    public int getInt(java.lang.String str, int i) {
        return this.mPrefs.getInt(str, i);
    }

    public boolean getSplashPreloadBoolean() {
        boolean z = getBoolean(KEY_SPLASH_PRELOAD_SWITCH, java.lang.Boolean.TRUE);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "now splashPreload ->" + z);
        return z;
    }

    public java.lang.String getString(java.lang.String str) {
        return this.mPrefs.getString(str, "");
    }

    public boolean isOpenSplashCover() {
        return this.mPrefs.getBoolean(KEY_SPLASH_COVER, false);
    }

    public void putBoolean(java.lang.String str, java.lang.Boolean bool) {
        com.alimm.tanx.core.utils.ThreadUtils.executeByIo(new com.alimm.tanx.core.utils.SharedPreferencesHelper.AnonymousClass5(str, bool));
    }

    public void putDebugUrlBoolean(boolean z) {
        com.alimm.tanx.core.utils.ThreadUtils.executeByIo(new com.alimm.tanx.core.utils.SharedPreferencesHelper.AnonymousClass4(z));
    }

    public void putEncryptBoolean(boolean z) {
        putBoolean(KEY_ENCRYPT_SWITCH, java.lang.Boolean.valueOf(z));
    }

    public void putFloat(java.lang.String str, float f) {
        com.alimm.tanx.core.utils.ThreadUtils.executeByIo(new com.alimm.tanx.core.utils.SharedPreferencesHelper.AnonymousClass2(str, f));
    }

    public void putHttpsBoolean(boolean z) {
        putBoolean(KEY_HTTPS_SWITCH, java.lang.Boolean.valueOf(z));
    }

    public void putInt(java.lang.String str, java.lang.Integer num) {
        com.alimm.tanx.core.utils.ThreadUtils.executeByIo(new com.alimm.tanx.core.utils.SharedPreferencesHelper.AnonymousClass3(str, num));
    }

    public void putSplashPreloadBoolean(boolean z) {
        putBoolean(KEY_SPLASH_PRELOAD_SWITCH, java.lang.Boolean.valueOf(z));
    }

    public void putString(java.lang.String str, java.lang.String str2) {
        com.alimm.tanx.core.utils.ThreadUtils.executeByIo(new com.alimm.tanx.core.utils.SharedPreferencesHelper.AnonymousClass1(str, str2));
    }

    public void switchSplashCover(boolean z) {
        android.content.SharedPreferences.Editor edit = this.mPrefs.edit();
        edit.putBoolean(KEY_SPLASH_COVER, z);
        edit.apply();
    }
}
