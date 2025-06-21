package com.vivo.push.model;

/* loaded from: classes19.dex */
public class SubscribeAppInfo {
    public static final int SUBSCIRBE = 1;
    public static final int SUBSCIRBE_CANCLE = 2;
    private int mActualStatus;
    private java.lang.String mName;
    private int mTargetStatus;

    public SubscribeAppInfo(java.lang.String str, int i, int i2) {
        this.mName = str;
        this.mTargetStatus = i;
        this.mActualStatus = i2;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.vivo.push.model.SubscribeAppInfo subscribeAppInfo = (com.vivo.push.model.SubscribeAppInfo) obj;
        java.lang.String str = this.mName;
        if (str == null) {
            if (subscribeAppInfo.mName != null) {
                return false;
            }
        } else if (!str.equals(subscribeAppInfo.mName)) {
            return false;
        }
        return this.mTargetStatus == subscribeAppInfo.mTargetStatus;
    }

    public int getActualStatus() {
        return this.mActualStatus;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public int getTargetStatus() {
        return this.mTargetStatus;
    }

    public int hashCode() {
        java.lang.String str = this.mName;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.mTargetStatus;
    }

    public void setActualStatus(int i) {
        this.mActualStatus = i;
    }

    public void setName(java.lang.String str) {
        this.mName = str;
    }

    public void setTargetStatus(int i) {
        this.mTargetStatus = i;
    }

    public java.lang.String toString() {
        return "SubscribeAppInfo [mName=" + this.mName + ", mTargetStatus=" + this.mTargetStatus + ", mActualStatus=" + this.mActualStatus + "]";
    }
}
