package com.huawei.hms.base.log;

/* loaded from: classes22.dex */
public class d implements com.huawei.hms.base.log.b {
    public final com.huawei.hms.support.log.HMSExtLogger a;
    public com.huawei.hms.base.log.b b;

    public d(com.huawei.hms.support.log.HMSExtLogger hMSExtLogger) {
        this.a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(android.content.Context context, java.lang.String str) {
        com.huawei.hms.base.log.b bVar = this.b;
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(com.huawei.hms.base.log.b bVar) {
        this.b = bVar;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        com.huawei.hms.support.log.HMSExtLogger hMSExtLogger = this.a;
        if (hMSExtLogger != null) {
            if (i == 3) {
                hMSExtLogger.d(str2, str3);
            } else if (i == 4) {
                hMSExtLogger.i(str2, str3);
            } else if (i != 5) {
                hMSExtLogger.e(str2, str3);
            } else {
                hMSExtLogger.w(str2, str3);
            }
        }
        com.huawei.hms.base.log.b bVar = this.b;
        if (bVar != null) {
            bVar.a(str, i, str2, str3);
        }
    }
}
