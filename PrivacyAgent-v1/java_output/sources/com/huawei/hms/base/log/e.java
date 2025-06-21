package com.huawei.hms.base.log;

/* loaded from: classes22.dex */
public class e implements com.huawei.hms.base.log.b {
    public com.huawei.hms.base.log.b a;

    @Override // com.huawei.hms.base.log.b
    public void a(android.content.Context context, java.lang.String str) {
        com.huawei.hms.base.log.b bVar = this.a;
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(com.huawei.hms.base.log.b bVar) {
        this.a = bVar;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        android.util.Log.println(i, "HMSSDK_" + str2, str3);
        com.huawei.hms.base.log.b bVar = this.a;
        if (bVar != null) {
            bVar.a(str, i, str2, str3);
        }
    }
}
