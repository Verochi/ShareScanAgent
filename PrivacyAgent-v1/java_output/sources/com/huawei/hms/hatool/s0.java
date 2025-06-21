package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class s0 {
    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (!android.text.TextUtils.isEmpty(str2)) {
            return a(str, str2, str3) ? str2 : str4;
        }
        com.huawei.hms.hatool.y.f("hmsSdk", "checkStrParameter() Parameter verification failure! Parameter:" + str);
        return str4;
    }

    public static boolean a(java.lang.String str) {
        return !a(com.heytap.mcssdk.constant.b.k, str, 256);
    }

    public static boolean a(java.lang.String str, java.lang.String str2, int i) {
        java.lang.StringBuilder sb;
        java.lang.String str3;
        if (android.text.TextUtils.isEmpty(str2)) {
            sb = new java.lang.StringBuilder();
            str3 = "checkString() Parameter is empty : ";
        } else {
            if (str2.length() <= i) {
                return true;
            }
            sb = new java.lang.StringBuilder();
            str3 = "checkString() Failure of parameter length check! Parameter:";
        }
        sb.append(str3);
        sb.append(str);
        com.huawei.hms.hatool.y.f("hmsSdk", sb.toString());
        return false;
    }

    public static boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb;
        java.lang.String str4;
        if (android.text.TextUtils.isEmpty(str2)) {
            sb = new java.lang.StringBuilder();
            str4 = "checkString() Parameter is null! Parameter:";
        } else {
            if (java.util.regex.Pattern.compile(str3).matcher(str2).matches()) {
                return true;
            }
            sb = new java.lang.StringBuilder();
            str4 = "checkString() Parameter verification failure! Parameter:";
        }
        sb.append(str4);
        sb.append(str);
        com.huawei.hms.hatool.y.f("hmsSdk", sb.toString());
        return false;
    }

    public static boolean a(java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String str;
        if (map == null || map.size() == 0) {
            str = "onEvent() mapValue has not data.so,The data will be empty";
        } else if (map.size() == 1 && (map.get("constants") != null || map.get("_constants") != null)) {
            str = "checkMap() the key can't be constants or _constants";
        } else {
            if (map.size() <= 2048 && map.toString().length() <= 204800) {
                return true;
            }
            str = "checkMap Map data is too big! size: " + map.size() + " length: " + map.toString().length();
        }
        com.huawei.hms.hatool.y.f("hmsSdk", str);
        return false;
    }
}
