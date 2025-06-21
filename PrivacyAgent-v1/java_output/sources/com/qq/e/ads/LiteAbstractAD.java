package com.qq.e.ads;

/* loaded from: classes19.dex */
public abstract class LiteAbstractAD<T extends com.qq.e.comm.pi.LADI> extends com.qq.e.ads.AbstractAD<T> implements com.qq.e.comm.pi.LADI, com.qq.e.comm.compliance.DownloadConfirmListener {
    private com.qq.e.comm.compliance.DownloadConfirmListener h;

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public java.lang.String getApkInfoUrl() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.LADI) t).getApkInfoUrl();
        }
        a("getApkInfoUrl");
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.LADI) t).getECPM();
        }
        a("getECPM");
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public java.lang.String getECPMLevel() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.LADI) t).getECPMLevel();
        }
        a("getECPMLevel");
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public java.util.Map<java.lang.String, java.lang.Object> getExtraInfo() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.LADI) t).getExtraInfo();
        }
        a("getExtraInfo");
        return new java.util.HashMap();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        T t = this.a;
        if (t != 0) {
            return ((com.qq.e.comm.pi.LADI) t).isValid();
        }
        a("isValid");
        return false;
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(android.app.Activity activity, int i, java.lang.String str, com.qq.e.comm.compliance.DownloadConfirmCallBack downloadConfirmCallBack) {
        com.qq.e.comm.compliance.DownloadConfirmListener downloadConfirmListener = this.h;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, java.lang.String str) {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.LADI) t).sendLossNotification(i, i2, str);
        } else {
            a("sendLossNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(java.util.Map<java.lang.String, java.lang.Object> map) {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.LADI) t).sendLossNotification(map);
        } else {
            a("sendLossNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.LADI) t).sendWinNotification(i);
        } else {
            a("sendWinNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(java.util.Map<java.lang.String, java.lang.Object> map) {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.LADI) t).sendWinNotification(map);
        } else {
            a("sendWinNotification");
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.LADI) t).setBidECPM(i);
        } else {
            a("setBidECPM");
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(com.qq.e.comm.compliance.DownloadConfirmListener downloadConfirmListener) {
        this.h = downloadConfirmListener;
        T t = this.a;
        if (t != 0) {
            ((com.qq.e.comm.pi.LADI) t).setDownloadConfirmListener(this);
        }
    }
}
