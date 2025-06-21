package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class ToastUtil implements com.alimm.tanx.core.utils.NotConfused {
    public static int LONG_TIME = 3500;
    public static int SHORT_TIME = 2000;
    private static android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
    private static android.widget.Toast mToast;

    /* renamed from: com.alimm.tanx.core.utils.ToastUtil$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String tanxc_do;
        final /* synthetic */ int tanxc_for;
        final /* synthetic */ android.content.Context tanxc_if;

        public AnonymousClass1(java.lang.String str, android.content.Context context, int i) {
            this.tanxc_do = str;
            this.tanxc_if = context;
            this.tanxc_for = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.content.Context context;
            if (android.text.TextUtils.isEmpty(this.tanxc_do) || (context = this.tanxc_if) == null) {
                return;
            }
            android.content.Context applicationContext = context.getApplicationContext();
            android.widget.Toast unused = com.alimm.tanx.core.utils.ToastUtil.mToast = new android.widget.Toast(applicationContext);
            android.view.View inflate = ((android.view.LayoutInflater) applicationContext.getSystemService("layout_inflater")).inflate(com.alimm.tanx.core.R.layout.layout_commont_toast, (android.view.ViewGroup) null);
            com.alimm.tanx.core.utils.ToastUtil.mToast.setView(inflate);
            com.alimm.tanx.core.utils.ToastUtil.mToast.setGravity(80, 0, com.alimm.tanx.core.utils.SysUtils.getScreenHeight(this.tanxc_if) / 2);
            com.alimm.tanx.core.utils.ToastUtil.mToast.setDuration(this.tanxc_for);
            ((android.widget.TextView) inflate.findViewById(com.alimm.tanx.core.R.id.tv_toast)).setText(this.tanxc_do);
            com.alimm.tanx.core.utils.ToastUtil.mToast.show();
        }
    }

    private static boolean isMainThread() {
        return java.lang.Thread.currentThread().getName().equals("main");
    }

    public static void showLongToast(android.content.Context context, java.lang.String str) {
        showToast(context, str, LONG_TIME);
    }

    public static void showShortToast(android.content.Context context, java.lang.String str) {
        showToast(context, str, SHORT_TIME);
    }

    public static void showShortToast(java.lang.String str) {
        showShortToast(com.alimm.tanx.core.TanxCoreSdk.getApplication(), str);
    }

    public static void showToast(android.content.Context context, java.lang.String str, int i) {
        handler.post(new com.alimm.tanx.core.utils.ToastUtil.AnonymousClass1(str, context, i));
    }

    public static android.widget.Toast showToastImg(android.content.Context context, java.lang.String str, int i, int i2) {
        if (android.text.TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        mToast = new android.widget.Toast(applicationContext);
        android.view.View inflate = ((android.view.LayoutInflater) applicationContext.getSystemService("layout_inflater")).inflate(com.alimm.tanx.core.R.layout.layout_commont_toast_img, (android.view.ViewGroup) null);
        mToast.setView(inflate);
        mToast.setGravity(80, 0, com.alimm.tanx.core.utils.SysUtils.getScreenHeight(context) / 2);
        mToast.setDuration(i);
        android.widget.TextView textView = (android.widget.TextView) inflate.findViewById(com.alimm.tanx.core.R.id.tv_toast);
        ((android.widget.ImageView) inflate.findViewById(com.alimm.tanx.core.R.id.iv_img)).setImageResource(i2);
        textView.setText(str);
        mToast.show();
        return mToast;
    }

    public static android.widget.Toast showToastImg(java.lang.String str, int i) {
        return showToastImg(com.alimm.tanx.core.TanxCoreSdk.getApplication(), str, LONG_TIME, i);
    }
}
