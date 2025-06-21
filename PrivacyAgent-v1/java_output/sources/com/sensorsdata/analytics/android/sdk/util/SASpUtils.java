package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class SASpUtils {
    private static final java.lang.String TAG = "SA.SASpUtils";
    private static com.sensorsdata.analytics.android.sdk.util.SASpUtils.ISharedPreferencesProvider mSharedPreferencesProvider;

    public interface ISharedPreferencesProvider {
        android.content.SharedPreferences createSharedPreferences(android.content.Context context, java.lang.String str, int i);
    }

    public static android.content.SharedPreferences getSharedPreferences(android.content.Context context, java.lang.String str, int i) {
        android.content.SharedPreferences createSharedPreferences;
        com.sensorsdata.analytics.android.sdk.util.SASpUtils.ISharedPreferencesProvider iSharedPreferencesProvider = mSharedPreferencesProvider;
        if (iSharedPreferencesProvider == null || (createSharedPreferences = iSharedPreferencesProvider.createSharedPreferences(context, str, i)) == null) {
            return context.getSharedPreferences(str, i);
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "create SharedPreferences by user default, file name is: " + str);
        return createSharedPreferences;
    }

    public static void setSharedPreferencesProvider(com.sensorsdata.analytics.android.sdk.util.SASpUtils.ISharedPreferencesProvider iSharedPreferencesProvider) {
        mSharedPreferencesProvider = iSharedPreferencesProvider;
    }
}
