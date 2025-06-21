package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class v {
    public static com.huawei.hms.hatool.e1 a(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.e1 e1Var = new com.huawei.hms.hatool.e1();
        e1Var.a(com.huawei.hms.hatool.z0.a().a(str, str2));
        return e1Var;
    }

    public static com.huawei.hms.hatool.f1 a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.huawei.hms.hatool.f1 f1Var = new com.huawei.hms.hatool.f1();
        f1Var.a(str);
        f1Var.b(com.huawei.hms.hatool.b.f());
        f1Var.e(str2);
        f1Var.c(str4);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("hmshi");
        stringBuffer.append(str3);
        stringBuffer.append("qrt");
        f1Var.d(stringBuffer.toString());
        return f1Var;
    }

    public static com.huawei.hms.hatool.g1 a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.huawei.hms.hatool.g1 g1Var = new com.huawei.hms.hatool.g1();
        g1Var.c(com.huawei.hms.hatool.b.j());
        g1Var.e(com.huawei.hms.hatool.b.l());
        g1Var.a(str3);
        g1Var.b(com.huawei.hms.hatool.z0.a().b(str2, str));
        return g1Var;
    }

    public static com.huawei.hms.hatool.C0546r b(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.y.c("hmsSdk", "generate UploadData EventModelHandlerBase");
        com.huawei.hms.hatool.x.d().a(str, str2);
        if (!android.text.TextUtils.isEmpty(com.huawei.hms.hatool.x.d().a())) {
            return new com.huawei.hms.hatool.C0546r(com.huawei.hms.hatool.x.d().c());
        }
        com.huawei.hms.hatool.y.f("hmsSdk", "event chifer is empty");
        return null;
    }

    public static java.util.Map<java.lang.String, java.lang.String> c(java.lang.String str, java.lang.String str2) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("App-Id", com.huawei.hms.hatool.b.f());
        hashMap.put("App-Ver", com.huawei.hms.hatool.b.g());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.313");
        hashMap.put("Device-Type", android.os.Build.MODEL);
        hashMap.put("servicetag", str);
        com.huawei.hms.hatool.y.a("hmsSdk", "sendData RequestId : %s", str2);
        hashMap.put("Request-Id", str2);
        return hashMap;
    }
}
