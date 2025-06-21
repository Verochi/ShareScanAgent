package com.jd.ad.sdk.jad_lo;

/* loaded from: classes23.dex */
public class jad_an {
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
    
        if (r1.waitFor() == 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (r1 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        r1.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String jad_an(java.lang.String str) {
        boolean waitFor;
        java.lang.String str2 = "";
        java.lang.Process process = null;
        try {
            if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
                process = java.lang.Runtime.getRuntime().exec(str);
                process.getOutputStream().close();
                com.jd.ad.sdk.jad_lo.jad_jt jad_jtVar = new com.jd.ad.sdk.jad_lo.jad_jt(process.getInputStream(), false);
                jad_jtVar.start();
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    waitFor = process.waitFor(2L, java.util.concurrent.TimeUnit.SECONDS);
                    if (waitFor) {
                        str2 = jad_jtVar.jad_an();
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
