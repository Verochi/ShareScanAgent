package com.alimm.tanx.core.web.webview;

/* loaded from: classes.dex */
public class PreloadWebView {
    private static final int CACHED_WEB_VIEW_MAX_NUM = 3;
    private static java.lang.String TAG = "PreloadWebView";
    private static final java.util.Stack<java.lang.ref.WeakReference<com.alimm.tanx.core.web.webview.TanxAdWebView>> mCachedWebViewStack = new java.util.Stack<>();
    private android.os.Handler mainHandler;

    /* renamed from: com.alimm.tanx.core.web.webview.PreloadWebView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alimm.tanx.core.web.webview.PreloadWebView.this.pushCachedWebViewStack();
        }
    }

    /* renamed from: com.alimm.tanx.core.web.webview.PreloadWebView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.os.MessageQueue.IdleHandler {
        public AnonymousClass2() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            com.alimm.tanx.core.utils.LogUtils.d("PreloadWebView", "-->queueIdle");
            com.alimm.tanx.core.web.webview.PreloadWebView.mCachedWebViewStack.push(com.alimm.tanx.core.web.webview.PreloadWebView.this.createWebView());
            return false;
        }
    }

    public static class Holder {
        private static final com.alimm.tanx.core.web.webview.PreloadWebView INSTANCE = new com.alimm.tanx.core.web.webview.PreloadWebView(null);

        private Holder() {
        }
    }

    private PreloadWebView() {
    }

    public /* synthetic */ PreloadWebView(com.alimm.tanx.core.web.webview.PreloadWebView.AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.ref.WeakReference<com.alimm.tanx.core.web.webview.TanxAdWebView> createWebView() {
        com.alimm.tanx.core.web.webview.TanxAdWebView tanxAdWebView = new com.alimm.tanx.core.web.webview.TanxAdWebView(new android.content.MutableContextWrapper(com.alimm.tanx.core.TanxCoreSdk.getApplication()));
        tanxAdWebView.getSettings().setJavaScriptEnabled(true);
        java.lang.String html = getHtml();
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(tanxAdWebView, "file:///android_asset/article/?item_id=0&token=0", html, "text/html", "utf-8", "file:///android_asset/article/?item_id=0&token=0");
        tanxAdWebView.loadDataWithBaseURL("file:///android_asset/article/?item_id=0&token=0", html, "text/html", "utf-8", "file:///android_asset/article/?item_id=0&token=0");
        return new java.lang.ref.WeakReference<>(tanxAdWebView);
    }

    private static java.lang.String getHtml() {
        return "<!DOCTYPE html>\n<html>\n<head>\n<meta charset=\"utf-8\">\n<meta name=\"viewport\" content=\"initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n<link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/article/css/android.css\">\n</head>\n<body class=\"font_m\"><header></header><article></article><footer></footer><script type=\"text/javascript\" src=\"file:///android_asset/article/js/lib.js\"></script><script type=\"text/javascript\" src=\"file:///android_asset/article/js/android.js\" ></script>\n</body>\n</html>\n";
    }

    private long getInitDelayTime(boolean z) {
        if (!z) {
            return 0L;
        }
        com.alimm.tanx.core.orange.bean.WebConfigBean webConfigBean = com.alimm.tanx.core.orange.OrangeManager.getInstance().getWebConfigBean();
        if (webConfigBean == null) {
            webConfigBean = new com.alimm.tanx.core.orange.bean.WebConfigBean();
        }
        long j = webConfigBean.sdkInitWebViewPreloadDelayed;
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public static com.alimm.tanx.core.web.webview.PreloadWebView getInstance() {
        return com.alimm.tanx.core.web.webview.PreloadWebView.Holder.INSTANCE;
    }

    private void initSettings(com.alimm.tanx.core.web.webview.TanxAdWebView tanxAdWebView) {
        android.webkit.WebSettings settings = tanxAdWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setDefaultTextEncodingName("UTF-8");
        android.webkit.CookieManager.getInstance();
        settings.setMixedContentMode(2);
    }

    private boolean isPreload(boolean z) {
        com.alimm.tanx.core.orange.bean.WebConfigBean webConfigBean = com.alimm.tanx.core.orange.OrangeManager.getInstance().getWebConfigBean();
        if (webConfigBean == null) {
            webConfigBean = new com.alimm.tanx.core.orange.bean.WebConfigBean();
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "isPreload webConfigBean:" + webConfigBean.toString());
        if (z) {
            boolean z2 = webConfigBean.closeInitWebPreload;
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "isPreload initSwitch:" + z2);
            return !z2;
        }
        boolean z3 = webConfigBean.closeNextWebPreload;
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "isPreload nextWebSwitch:" + z3);
        return !z3;
    }

    public static void loadBaseHtml(com.alimm.tanx.core.web.webview.TanxAdWebView tanxAdWebView) {
        if (tanxAdWebView == null) {
            return;
        }
        java.lang.String html = getHtml();
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(tanxAdWebView, "file:///android_asset/article/?item_id=0&token=0", html, "text/html", "utf-8", "file:///android_asset/article/?item_id=0&token=0");
        tanxAdWebView.loadDataWithBaseURL("file:///android_asset/article/?item_id=0&token=0", html, "text/html", "utf-8", "file:///android_asset/article/?item_id=0&token=0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushCachedWebViewStack() {
        android.os.Looper.myQueue().addIdleHandler(new com.alimm.tanx.core.web.webview.PreloadWebView.AnonymousClass2());
    }

    public void destroy() {
        java.util.Stack<java.lang.ref.WeakReference<com.alimm.tanx.core.web.webview.TanxAdWebView>> stack = mCachedWebViewStack;
        if (stack != null) {
            stack.clear();
        }
    }

    public com.alimm.tanx.core.web.webview.TanxAdWebView getWebView(android.content.Context context) {
        com.alimm.tanx.core.web.webview.TanxAdWebView tanxAdWebView;
        java.util.Stack<java.lang.ref.WeakReference<com.alimm.tanx.core.web.webview.TanxAdWebView>> stack = mCachedWebViewStack;
        if (stack == null || stack.isEmpty() || (tanxAdWebView = stack.pop().get()) == null) {
            java.lang.ref.WeakReference<com.alimm.tanx.core.web.webview.TanxAdWebView> createWebView = createWebView();
            ((android.content.MutableContextWrapper) createWebView.get().getContext()).setBaseContext(context);
            tanxAdWebView = createWebView.get();
        } else {
            ((android.content.MutableContextWrapper) tanxAdWebView.getContext()).setBaseContext(context);
        }
        tanxAdWebView.setWebClickable(true);
        initSettings(tanxAdWebView);
        return tanxAdWebView;
    }

    public void preload(boolean z) {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "webView preload formSdkInit :" + z);
        if (!isPreload(z)) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "preload取消");
            return;
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "webView preload开始");
        if (mCachedWebViewStack.size() >= 3) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "webView preload mCachedWebViewStack已满，取消");
            return;
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "webView preload 通过mainHandler pushCachedWebViewStack");
        if (this.mainHandler == null) {
            this.mainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        }
        long initDelayTime = getInitDelayTime(z);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "webView preload delayTime毫秒 :" + initDelayTime);
        this.mainHandler.postDelayed(new com.alimm.tanx.core.web.webview.PreloadWebView.AnonymousClass1(), initDelayTime);
    }
}
