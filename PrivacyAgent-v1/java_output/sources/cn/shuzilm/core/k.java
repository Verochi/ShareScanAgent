package cn.shuzilm.core;

/* loaded from: classes.dex */
class k implements java.lang.Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ android.content.Context b;

    public k(boolean z, android.content.Context context) {
        this.a = z;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        cn.shuzilm.core.DUHelper dUHelper;
        boolean z;
        cn.shuzilm.core.DUHelper dUHelper2;
        cn.shuzilm.core.DUHelper dUHelper3;
        cn.shuzilm.core.DUHelper dUHelper4;
        try {
            java.lang.System.loadLibrary(com.umeng.analytics.pro.f.ac);
            dUHelper = cn.shuzilm.core.DUHelper.d;
            z = dUHelper.z;
            if (!z) {
                if (android.os.Looper.myLooper() == null) {
                    android.os.Looper.prepare();
                }
                if (android.os.Looper.myLooper() != null) {
                    android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) cn.shuzilm.core.DUHelper.mContext.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
                    dUHelper3 = cn.shuzilm.core.DUHelper.d;
                    telephonyManager.listen(dUHelper3, 256);
                    if (this.a) {
                        dUHelper4 = cn.shuzilm.core.DUHelper.d;
                        dUHelper4.i(this.b);
                    }
                }
                cn.shuzilm.core.DUHelper.j(cn.shuzilm.core.DUHelper.mContext);
            }
            dUHelper2 = cn.shuzilm.core.DUHelper.d;
            dUHelper2.z = true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
