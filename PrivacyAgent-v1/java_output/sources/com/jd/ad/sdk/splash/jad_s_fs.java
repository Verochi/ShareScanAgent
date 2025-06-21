package com.jd.ad.sdk.splash;

/* loaded from: classes23.dex */
public class jad_s_fs implements android.os.Handler.Callback {
    public final float jad_s_bo;
    public com.jd.ad.sdk.splash.jad_s_fs.jad_s_an jad_s_dq;
    public boolean jad_s_an = false;
    public long jad_s_er = 0;
    public android.os.Handler jad_s_cp = new android.os.Handler(android.os.Looper.getMainLooper(), this);

    public interface jad_s_an {
        void onCounterFinish();
    }

    public jad_s_fs(float f) {
        this.jad_s_bo = f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@androidx.annotation.NonNull android.os.Message message) {
        com.jd.ad.sdk.splash.jad_s_fs.jad_s_an jad_s_anVar = this.jad_s_dq;
        if (jad_s_anVar != null) {
            jad_s_anVar.onCounterFinish();
        }
        jad_s_an();
        return true;
    }

    public void jad_s_an() {
        android.os.Handler handler = this.jad_s_cp;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.jad_s_cp = null;
        }
        this.jad_s_dq = null;
    }
}
