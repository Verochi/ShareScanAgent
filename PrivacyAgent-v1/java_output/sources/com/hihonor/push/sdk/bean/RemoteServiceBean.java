package com.hihonor.push.sdk.bean;

/* loaded from: classes22.dex */
public class RemoteServiceBean {
    private java.lang.String packageAction;
    private java.lang.String packageName;
    private java.lang.String packageServiceName;
    private java.lang.String packageSignature;

    public boolean checkServiceInfo() {
        return ((android.text.TextUtils.isEmpty(this.packageServiceName) && android.text.TextUtils.isEmpty(this.packageAction)) || android.text.TextUtils.isEmpty(this.packageName)) ? false : true;
    }

    public java.lang.String getPackageAction() {
        return this.packageAction;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public java.lang.String getPackageServiceName() {
        return this.packageServiceName;
    }

    public java.lang.String getPackageSignature() {
        return this.packageSignature;
    }

    public void setPackageAction(java.lang.String str) {
        this.packageAction = str;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setPackageServiceName(java.lang.String str) {
        this.packageServiceName = str;
    }

    public void setPackageSignature(java.lang.String str) {
        this.packageSignature = str;
    }

    public java.lang.String toString() {
        return " packageName : " + this.packageName + " , action : " + this.packageAction + " , serviceName : " + this.packageServiceName;
    }
}
