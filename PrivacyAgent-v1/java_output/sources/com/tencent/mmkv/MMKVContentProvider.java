package com.tencent.mmkv;

/* loaded from: classes19.dex */
public class MMKVContentProvider extends android.content.ContentProvider {
    protected static final java.lang.String FUNCTION_NAME = "mmkvFromAshmemID";
    protected static final java.lang.String KEY = "KEY";
    protected static final java.lang.String KEY_CRYPT = "KEY_CRYPT";
    protected static final java.lang.String KEY_MODE = "KEY_MODE";
    protected static final java.lang.String KEY_SIZE = "KEY_SIZE";
    private static android.net.Uri gUri;

    @androidx.annotation.Nullable
    public static android.net.Uri contentUri(android.content.Context context) {
        java.lang.String queryAuthority;
        android.net.Uri uri = gUri;
        if (uri != null) {
            return uri;
        }
        if (context == null || (queryAuthority = queryAuthority(context)) == null) {
            return null;
        }
        android.net.Uri parse = android.net.Uri.parse("content://" + queryAuthority);
        gUri = parse;
        return parse;
    }

    public static java.lang.String getProcessNameByPID(android.content.Context context, int i) {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    private android.os.Bundle mmkvFromAshmemID(java.lang.String str, int i, int i2, java.lang.String str2) throws java.lang.RuntimeException {
        com.tencent.mmkv.MMKV mmkvWithAshmemID = com.tencent.mmkv.MMKV.mmkvWithAshmemID(getContext(), str, i, i2, str2);
        com.tencent.mmkv.ParcelableMMKV parcelableMMKV = new com.tencent.mmkv.ParcelableMMKV(mmkvWithAshmemID);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(" fd = ");
        sb.append(mmkvWithAshmemID.ashmemFD());
        sb.append(", meta fd = ");
        sb.append(mmkvWithAshmemID.ashmemMetaFD());
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable(KEY, parcelableMMKV);
        return bundle;
    }

    private static java.lang.String queryAuthority(android.content.Context context) {
        android.content.pm.ProviderInfo providerInfo;
        try {
            android.content.ComponentName componentName = new android.content.ComponentName(context, com.tencent.mmkv.MMKVContentProvider.class.getName());
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (providerInfo = packageManager.getProviderInfo(componentName, 0)) == null) {
                return null;
            }
            return providerInfo.authority;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.os.Bundle call(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable android.os.Bundle bundle) {
        if (str.equals(FUNCTION_NAME) && bundle != null) {
            try {
                return mmkvFromAshmemID(str2, bundle.getInt(KEY_SIZE), bundle.getInt(KEY_MODE), bundle.getString(KEY_CRYPT));
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        throw new java.lang.UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public java.lang.String getType(@androidx.annotation.NonNull android.net.Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.net.Uri insert(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues) {
        throw new java.lang.UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        java.lang.String queryAuthority;
        android.content.Context context = getContext();
        if (context == null || (queryAuthority = queryAuthority(context)) == null) {
            return false;
        }
        if (gUri != null) {
            return true;
        }
        gUri = android.net.Uri.parse("content://" + queryAuthority);
        return true;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable java.lang.String str2) {
        throw new java.lang.UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public int update(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        throw new java.lang.UnsupportedOperationException("Not implement in MMKV");
    }
}
