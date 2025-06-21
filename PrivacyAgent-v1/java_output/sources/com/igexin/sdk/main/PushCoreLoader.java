package com.igexin.sdk.main;

/* loaded from: classes23.dex */
public class PushCoreLoader {
    private static java.lang.String TAG = "PushSdk";
    private static com.igexin.sdk.main.PushCoreLoader instance;
    private com.igexin.sdk.IPushCore gtcCore;
    private com.igexin.sdk.IPushCore pushCore;

    private PushCoreLoader() {
    }

    public static com.igexin.sdk.main.PushCoreLoader getInstance() {
        if (instance == null) {
            instance = new com.igexin.sdk.main.PushCoreLoader();
        }
        return instance;
    }

    public com.igexin.sdk.IPushCore getGtcCore() {
        return this.gtcCore;
    }

    public com.igexin.sdk.IPushCore getPushCore() {
        return this.pushCore;
    }

    public boolean init(android.content.Context context) {
        setPushCore(new com.igexin.push.core.stub.PushCore());
        setGtcCore(new com.igexin.push.core.stub.GtcCore());
        return true;
    }

    public void onDestroy() {
    }

    public void setGtcCore(com.igexin.sdk.IPushCore iPushCore) {
        this.gtcCore = iPushCore;
    }

    public void setPushCore(com.igexin.sdk.IPushCore iPushCore) {
        this.pushCore = iPushCore;
    }
}
