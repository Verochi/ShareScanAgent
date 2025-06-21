package com.huawei.secure.android.common.webview;

/* loaded from: classes22.dex */
public class SafeGetUrl {
    public java.lang.String a;
    public android.webkit.WebView b;

    public class a implements java.lang.Runnable {
        public final /* synthetic */ java.util.concurrent.CountDownLatch n;

        public a(java.util.concurrent.CountDownLatch countDownLatch) {
            this.n = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.secure.android.common.webview.SafeGetUrl safeGetUrl = com.huawei.secure.android.common.webview.SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.b.getUrl());
            this.n.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public SafeGetUrl(android.webkit.WebView webView) {
        this.b = webView;
    }

    public java.lang.String getUrlMethod() {
        if (this.b == null) {
            return "";
        }
        if (com.huawei.secure.android.common.util.b.a()) {
            return this.b.getUrl();
        }
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.huawei.secure.android.common.util.c.a(new com.huawei.secure.android.common.webview.SafeGetUrl.a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (java.lang.InterruptedException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getUrlMethod: InterruptedException ");
            sb.append(e.getMessage());
        }
        return this.a;
    }

    public android.webkit.WebView getWebView() {
        return this.b;
    }

    public void setUrl(java.lang.String str) {
        this.a = str;
    }

    public void setWebView(android.webkit.WebView webView) {
        this.b = webView;
    }
}
