package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class m1 {
    public com.huawei.hms.hatool.k a;
    public com.huawei.hms.hatool.k b;
    public android.content.Context c;
    public java.lang.String d;

    public m1(android.content.Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        }
        this.a = new com.huawei.hms.hatool.k();
        this.b = new com.huawei.hms.hatool.k();
    }

    public com.huawei.hms.hatool.m1 a(int i, java.lang.String str) {
        com.huawei.hms.hatool.k kVar;
        com.huawei.hms.hatool.y.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i);
        if (!com.huawei.hms.hatool.v0.b(str)) {
            str = "";
        }
        if (i == 0) {
            kVar = this.a;
        } else {
            if (i != 1) {
                com.huawei.hms.hatool.y.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            }
            kVar = this.b;
        }
        kVar.b(str);
        return this;
    }

    public com.huawei.hms.hatool.m1 a(java.lang.String str) {
        com.huawei.hms.hatool.y.c("hmsSdk", "Builder.setAppID is execute");
        this.d = str;
        return this;
    }

    @java.lang.Deprecated
    public com.huawei.hms.hatool.m1 a(boolean z) {
        com.huawei.hms.hatool.y.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.a.j().a(z);
        this.b.j().a(z);
        return this;
    }

    public void a() {
        if (this.c == null) {
            com.huawei.hms.hatool.y.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        com.huawei.hms.hatool.y.c("hmsSdk", "Builder.create() is execute.");
        com.huawei.hms.hatool.j1 j1Var = new com.huawei.hms.hatool.j1("_hms_config_tag");
        j1Var.b(new com.huawei.hms.hatool.k(this.a));
        j1Var.a(new com.huawei.hms.hatool.k(this.b));
        com.huawei.hms.hatool.h1.a().a(this.c);
        com.huawei.hms.hatool.i1.a().a(this.c);
        com.huawei.hms.hatool.o1.c().a(j1Var);
        com.huawei.hms.hatool.h1.a().a(this.d);
    }

    @java.lang.Deprecated
    public com.huawei.hms.hatool.m1 b(boolean z) {
        com.huawei.hms.hatool.y.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.a.j().b(z);
        this.b.j().b(z);
        return this;
    }

    @java.lang.Deprecated
    public com.huawei.hms.hatool.m1 c(boolean z) {
        com.huawei.hms.hatool.y.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.a.j().c(z);
        this.b.j().c(z);
        return this;
    }
}
