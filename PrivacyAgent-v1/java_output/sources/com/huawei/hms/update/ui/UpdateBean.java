package com.huawei.hms.update.ui;

/* loaded from: classes22.dex */
public class UpdateBean implements java.io.Serializable {
    public boolean a;
    public java.lang.String b;
    public java.util.ArrayList c;
    public boolean d = true;

    public static <T> T a(T t) {
        return t;
    }

    public java.lang.String getClientAppName() {
        return (java.lang.String) a(this.b);
    }

    public boolean getResolutionInstallHMS() {
        return this.a;
    }

    public java.util.ArrayList getTypeList() {
        return (java.util.ArrayList) a(this.c);
    }

    public boolean isNeedConfirm() {
        return ((java.lang.Boolean) a(java.lang.Boolean.valueOf(this.d))).booleanValue();
    }

    public void setClientAppId(java.lang.String str) {
    }

    public void setClientAppName(java.lang.String str) {
        this.b = str;
    }

    public void setClientPackageName(java.lang.String str) {
    }

    public void setClientVersionCode(int i) {
    }

    public void setHmsOrApkUpgrade(boolean z) {
    }

    public void setNeedConfirm(boolean z) {
        this.d = z;
    }

    public void setResolutionInstallHMS(boolean z) {
        this.a = z;
    }

    public void setTypeList(java.util.ArrayList arrayList) {
        this.c = arrayList;
    }
}
