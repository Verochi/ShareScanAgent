package com.igexin.sdk.main;

/* loaded from: classes23.dex */
public class SdkInitSwitch {
    private java.lang.String mSdkSwitchPath;

    public SdkInitSwitch(android.content.Context context) {
        if (context == null) {
            return;
        }
        this.mSdkSwitchPath = context.getFilesDir().getPath() + "/init.pid";
    }

    public void delete() {
        java.io.File file = new java.io.File(this.mSdkSwitchPath);
        if (file.exists()) {
            file.delete();
        }
    }

    public boolean isSwitchOn() {
        if (this.mSdkSwitchPath != null) {
            return new java.io.File(this.mSdkSwitchPath).exists();
        }
        return false;
    }

    public void switchOn() {
        if (isSwitchOn() || this.mSdkSwitchPath == null) {
            return;
        }
        try {
            new java.io.File(this.mSdkSwitchPath).createNewFile();
        } catch (java.io.IOException e) {
            com.igexin.c.a.c.a.a(e);
        }
    }
}
