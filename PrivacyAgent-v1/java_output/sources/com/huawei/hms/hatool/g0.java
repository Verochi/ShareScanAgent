package com.huawei.hms.hatool;

@android.annotation.SuppressLint({"ApplySharedPref"})
/* loaded from: classes22.dex */
public class g0 {
    public static long a(android.content.Context context, java.lang.String str, java.lang.String str2, long j) {
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.huawei.hms.hatool.y.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return j;
        }
        android.content.SharedPreferences b = b(context, str);
        return b != null ? b.getLong(str2, j) : j;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.huawei.hms.hatool.y.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return str3;
        }
        android.content.SharedPreferences b = b(context, str);
        return b != null ? b.getString(str2, str3) : str3;
    }

    public static java.util.Map<java.lang.String, ?> a(android.content.Context context, java.lang.String str) {
        return b(context, str).getAll();
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String... strArr) {
        java.lang.String str2;
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            str2 = "clearData(): parameter error.context,spname";
        } else {
            if (strArr != null) {
                android.content.SharedPreferences b = b(context, str);
                if (b != null) {
                    android.content.SharedPreferences.Editor edit = b.edit();
                    if (strArr.length == 0) {
                        edit.clear();
                        edit.commit();
                        return;
                    }
                    for (java.lang.String str3 : strArr) {
                        if (b.contains(str3)) {
                            edit.remove(str3);
                            edit.commit();
                        }
                    }
                    return;
                }
                return;
            }
            str2 = "clearData(): No data need to be deleted,keys is null";
        }
        com.huawei.hms.hatool.y.f("hmsSdk", str2);
    }

    public static android.content.SharedPreferences b(android.content.Context context, java.lang.String str) {
        return context.getSharedPreferences(c(context, str), 0);
    }

    public static void b(android.content.Context context, java.lang.String str, java.lang.String str2, long j) {
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.huawei.hms.hatool.y.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        android.content.SharedPreferences b = b(context, str);
        if (b != null) {
            android.content.SharedPreferences.Editor edit = b.edit();
            edit.putLong(str2, j);
            edit.commit();
        }
    }

    public static void b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.huawei.hms.hatool.y.e("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        android.content.SharedPreferences b = b(context, str);
        if (b != null) {
            android.content.SharedPreferences.Editor edit = b.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static java.lang.String c(android.content.Context context, java.lang.String str) {
        java.lang.String packageName = context.getPackageName();
        java.lang.String n = com.huawei.hms.hatool.c.n("_hms_config_tag", "oper");
        if (android.text.TextUtils.isEmpty(n)) {
            return "hms_" + str + "_" + packageName;
        }
        return "hms_" + str + "_" + packageName + "_" + n;
    }
}
