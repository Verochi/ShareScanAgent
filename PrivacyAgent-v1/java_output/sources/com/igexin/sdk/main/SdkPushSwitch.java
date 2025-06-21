package com.igexin.sdk.main;

/* loaded from: classes23.dex */
public class SdkPushSwitch {
    private java.lang.String mSdkSwitchPath;

    public SdkPushSwitch(android.content.Context context) {
        if (context == null) {
            return;
        }
        this.mSdkSwitchPath = context.getFilesDir().getPath() + "/push.pid";
    }

    public void delete() {
        switchOff();
    }

    public boolean isSwitchOn() {
        if (this.mSdkSwitchPath != null) {
            return new java.io.File(this.mSdkSwitchPath).exists();
        }
        return false;
    }

    public void switchOff() {
        if (!isSwitchOn() || this.mSdkSwitchPath == null || new java.io.File(this.mSdkSwitchPath).delete()) {
            return;
        }
        com.igexin.c.a.c.a.a("SdkPushSwitch | switchOff, delete file = " + this.mSdkSwitchPath + " failed !!!!!!!!!!!!", new java.lang.Object[0]);
    }

    public void switchOn() {
        if (isSwitchOn() || this.mSdkSwitchPath == null) {
            return;
        }
        try {
            new java.io.File(this.mSdkSwitchPath).createNewFile();
        } catch (java.io.IOException e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("SdkPushSwitch | switchOn, create file = " + this.mSdkSwitchPath + " exception, " + e.toString(), new java.lang.Object[0]);
        }
    }
}
