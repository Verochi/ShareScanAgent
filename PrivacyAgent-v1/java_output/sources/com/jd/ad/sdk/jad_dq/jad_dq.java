package com.jd.ad.sdk.jad_dq;

/* loaded from: classes23.dex */
public final class jad_dq {
    public static volatile java.lang.String jad_an;

    public static class jad_an implements java.lang.Runnable {
        public final /* synthetic */ android.content.Context jad_an;
        public final /* synthetic */ java.util.concurrent.CountDownLatch jad_bo;

        public jad_an(android.content.Context context, java.util.concurrent.CountDownLatch countDownLatch) {
            this.jad_an = context;
            this.jad_bo = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.jd.ad.sdk.jad_dq.jad_dq.jad_an == null) {
                com.jd.ad.sdk.jad_dq.jad_dq.jad_an = com.jd.ad.sdk.jad_dq.jad_dq.jad_an(this.jad_an);
            }
            this.jad_bo.countDown();
        }
    }

    public static java.lang.String jad_an(android.content.Context context) {
        try {
            android.webkit.WebView webView = new android.webkit.WebView(context);
            webView.getSettings().setAllowFileAccess(false);
            webView.getSettings().setSavePassword(false);
            return webView.getSettings().getUserAgentString();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String jad_an(android.content.Context context, long j) {
        android.os.Looper mainLooper;
        if (jad_an == null) {
            if (context == null || (mainLooper = android.os.Looper.getMainLooper()) == null) {
                return "";
            }
            if (java.lang.Thread.currentThread() == mainLooper.getThread()) {
                jad_an = jad_an(context);
            } else {
                java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
                new android.os.Handler(mainLooper).post(new com.jd.ad.sdk.jad_dq.jad_dq.jad_an(context, countDownLatch));
                try {
                    countDownLatch.await(j, java.util.concurrent.TimeUnit.MILLISECONDS);
                } catch (java.lang.InterruptedException unused) {
                }
            }
            if (jad_an == null) {
                jad_an = "";
            }
        }
        return jad_an;
    }
}
