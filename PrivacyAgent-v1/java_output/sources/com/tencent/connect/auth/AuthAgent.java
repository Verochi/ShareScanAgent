package com.tencent.connect.auth;

/* loaded from: classes19.dex */
public class AuthAgent extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String KEY_FORCE_QR_LOGIN = "KEY_FORCE_QR_LOGIN";
    public static final java.lang.String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final java.lang.String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static java.lang.String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static java.lang.String SECURE_LIB_NAME = null;
    public static final int SECURE_LIB_VERSION = 5;
    public static final java.lang.String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final java.lang.String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";
    private com.tencent.tauth.IUiListener a;
    private java.lang.String d;
    private java.lang.ref.WeakReference<android.app.Activity> e;

    /* renamed from: com.tencent.connect.auth.AuthAgent$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.tencent.tauth.IUiListener b;

        /* renamed from: com.tencent.connect.auth.AuthAgent$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04941 implements java.lang.Runnable {
            final /* synthetic */ android.app.Activity a;

            public RunnableC04941(android.app.Activity activity) {
                this.a = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.tencent.open.web.security.JniInterface.isJniOk) {
                    android.app.Activity activity = this.a;
                    com.tencent.connect.auth.AuthAgent.AnonymousClass1 anonymousClass1 = com.tencent.connect.auth.AuthAgent.AnonymousClass1.this;
                    com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity, "action_login", anonymousClass1.a, anonymousClass1.b, ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c);
                    if (this.a.isFinishing()) {
                        return;
                    }
                    aVar.show();
                    return;
                }
                com.tencent.open.log.SLog.w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                android.app.Activity activity2 = this.a;
                java.lang.String a = com.tencent.connect.auth.AuthAgent.this.a("");
                com.tencent.connect.auth.AuthAgent.AnonymousClass1 anonymousClass12 = com.tencent.connect.auth.AuthAgent.AnonymousClass1.this;
                com.tencent.open.TDialog tDialog = new com.tencent.open.TDialog(activity2, "", a, anonymousClass12.b, ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c);
                if (this.a.isFinishing()) {
                    return;
                }
                tDialog.show();
            }
        }

        public AnonymousClass1(java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
            this.a = str;
            this.b = iUiListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.app.Activity activity;
            com.tencent.open.utils.i.a(com.tencent.connect.auth.AuthAgent.SECURE_LIB_FILE_NAME, com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME, 5);
            com.tencent.open.web.security.JniInterface.loadSo();
            if (com.tencent.connect.auth.AuthAgent.this.e == null || (activity = (android.app.Activity) com.tencent.connect.auth.AuthAgent.this.e.get()) == null) {
                return;
            }
            activity.runOnUiThread(new com.tencent.connect.auth.AuthAgent.AnonymousClass1.RunnableC04941(activity));
        }
    }

    public class a extends com.tencent.tauth.DefaultUiListener {
        com.tencent.tauth.IUiListener a;

        public a(com.tencent.tauth.IUiListener iUiListener) {
            this.a = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            com.tencent.tauth.IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            if (obj == null) {
                com.tencent.open.log.SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            try {
                int i = jSONObject.getInt("ret");
                java.lang.String string = i == 0 ? "success" : jSONObject.getString("msg");
                com.tencent.tauth.IUiListener iUiListener = this.a;
                if (iUiListener != null) {
                    iUiListener.onComplete(new org.json.JSONObject().put("ret", i).put("msg", string));
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                com.tencent.open.log.SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.tauth.IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    public class b extends com.tencent.tauth.DefaultUiListener {
        java.lang.ref.WeakReference<com.tencent.tauth.IUiListener> a;
        private final java.lang.String c = "sendinstall";
        private final java.lang.String d = "installwording";
        private final java.lang.String e = "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        /* renamed from: com.tencent.connect.auth.AuthAgent$b$1, reason: invalid class name */
        public class AnonymousClass1 extends com.tencent.connect.auth.AuthAgent.b.a {
            final /* synthetic */ com.tencent.tauth.IUiListener a;
            final /* synthetic */ java.lang.Object b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(android.app.Dialog dialog, com.tencent.tauth.IUiListener iUiListener, java.lang.Object obj) {
                super(dialog);
                this.a = iUiListener;
                this.b = obj;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                com.tencent.connect.auth.AuthAgent.b.this.a();
                android.app.Dialog dialog = this.d;
                if (dialog != null && dialog.isShowing()) {
                    this.d.dismiss();
                }
                com.tencent.tauth.IUiListener iUiListener = this.a;
                if (iUiListener != null) {
                    iUiListener.onComplete(this.b);
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        /* renamed from: com.tencent.connect.auth.AuthAgent$b$2, reason: invalid class name */
        public class AnonymousClass2 extends com.tencent.connect.auth.AuthAgent.b.a {
            final /* synthetic */ com.tencent.tauth.IUiListener a;
            final /* synthetic */ java.lang.Object b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(android.app.Dialog dialog, com.tencent.tauth.IUiListener iUiListener, java.lang.Object obj) {
                super(dialog);
                this.a = iUiListener;
                this.b = obj;
            }

            @Override // android.view.View.OnClickListener
            @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
            public void onClick(android.view.View view) {
                android.app.Dialog dialog = this.d;
                if (dialog != null && dialog.isShowing()) {
                    this.d.dismiss();
                }
                com.tencent.tauth.IUiListener iUiListener = this.a;
                if (iUiListener != null) {
                    iUiListener.onComplete(this.b);
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        /* renamed from: com.tencent.connect.auth.AuthAgent$b$3, reason: invalid class name */
        public class AnonymousClass3 implements android.content.DialogInterface.OnCancelListener {
            final /* synthetic */ com.tencent.tauth.IUiListener a;
            final /* synthetic */ java.lang.Object b;

            public AnonymousClass3(com.tencent.tauth.IUiListener iUiListener, java.lang.Object obj) {
                this.a = iUiListener;
                this.b = obj;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(android.content.DialogInterface dialogInterface) {
                com.tencent.tauth.IUiListener iUiListener = this.a;
                if (iUiListener != null) {
                    iUiListener.onComplete(this.b);
                }
            }
        }

        public abstract class a implements android.view.View.OnClickListener {
            android.app.Dialog d;

            public a(android.app.Dialog dialog) {
                this.d = dialog;
            }
        }

        public b(com.tencent.tauth.IUiListener iUiListener) {
            this.a = new java.lang.ref.WeakReference<>(iUiListener);
        }

        private android.graphics.drawable.Drawable a(java.lang.String str, android.content.Context context) {
            java.io.InputStream open;
            android.graphics.Bitmap bitmap;
            android.graphics.drawable.Drawable drawable = null;
            try {
                open = context.getApplicationContext().getAssets().open(str);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            if (open == null) {
                return null;
            }
            if (!str.endsWith(".9.png")) {
                drawable = android.graphics.drawable.Drawable.createFromStream(open, str);
                open.close();
                return drawable;
            }
            try {
                bitmap = android.graphics.BitmapFactory.decodeStream(open);
            } catch (java.lang.OutOfMemoryError e2) {
                e2.printStackTrace();
                bitmap = null;
            }
            if (bitmap == null) {
                return null;
            }
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            android.graphics.NinePatch.isNinePatchChunk(ninePatchChunk);
            return new android.graphics.drawable.NinePatchDrawable(bitmap, ninePatchChunk, new android.graphics.Rect(), null);
        }

        private android.view.View a(android.content.Context context, android.graphics.drawable.Drawable drawable, java.lang.String str, android.view.View.OnClickListener onClickListener, android.view.View.OnClickListener onClickListener2) {
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f = displayMetrics.density;
            android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(context);
            android.widget.ImageView imageView = new android.widget.ImageView(context);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            imageView.setId(1);
            int i = (int) (60.0f * f);
            int i2 = (int) (f * 14.0f);
            int i3 = (int) (18.0f * f);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i3, (int) (6.0f * f), i3);
            relativeLayout.addView(imageView, layoutParams);
            android.widget.TextView textView = new android.widget.TextView(context);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setGravity(3);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
            textView.setLines(2);
            textView.setId(5);
            textView.setMinWidth((int) (185.0f * f));
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, 1);
            layoutParams2.addRule(6, 1);
            float f2 = 5.0f * f;
            layoutParams2.setMargins(0, 0, (int) f2, 0);
            relativeLayout.addView(textView, layoutParams2);
            android.view.View view = new android.view.View(context);
            view.setBackgroundColor(android.graphics.Color.rgb(214, 214, 214));
            view.setId(3);
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, 2);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            layoutParams3.addRule(7, 5);
            int i4 = (int) (12.0f * f);
            layoutParams3.setMargins(0, 0, 0, i4);
            relativeLayout.addView(view, layoutParams3);
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
            android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(5, 1);
            layoutParams4.addRule(7, 5);
            layoutParams4.addRule(3, 3);
            android.widget.Button button = new android.widget.Button(context);
            button.setText("跳过");
            button.setBackgroundDrawable(a("buttonNegt.png", context));
            button.setTextColor(android.graphics.Color.rgb(36, 97, 131));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            int i5 = (int) (45.0f * f);
            android.widget.LinearLayout.LayoutParams layoutParams5 = new android.widget.LinearLayout.LayoutParams(0, i5);
            layoutParams5.rightMargin = i2;
            int i6 = (int) (4.0f * f);
            layoutParams5.leftMargin = i6;
            layoutParams5.weight = 1.0f;
            linearLayout.addView(button, layoutParams5);
            android.widget.Button button2 = new android.widget.Button(context);
            button2.setText("确定");
            button2.setTextSize(20.0f);
            button2.setTextColor(android.graphics.Color.rgb(255, 255, 255));
            button2.setBackgroundDrawable(a("buttonPost.png", context));
            button2.setOnClickListener(onClickListener);
            android.widget.LinearLayout.LayoutParams layoutParams6 = new android.widget.LinearLayout.LayoutParams(0, i5);
            layoutParams6.weight = 1.0f;
            layoutParams6.rightMargin = i6;
            linearLayout.addView(button2, layoutParams6);
            relativeLayout.addView(linearLayout, layoutParams4);
            android.view.ViewGroup.LayoutParams layoutParams7 = new android.widget.FrameLayout.LayoutParams((int) (279.0f * f), (int) (f * 163.0f));
            relativeLayout.setPadding(i2, 0, i4, i4);
            relativeLayout.setLayoutParams(layoutParams7);
            relativeLayout.setBackgroundColor(android.graphics.Color.rgb(247, 251, 247));
            android.graphics.drawable.PaintDrawable paintDrawable = new android.graphics.drawable.PaintDrawable(android.graphics.Color.rgb(247, 251, 247));
            paintDrawable.setCornerRadius(f2);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        private void a(java.lang.String str, com.tencent.tauth.IUiListener iUiListener, java.lang.Object obj) {
            android.content.pm.PackageInfo packageInfo;
            if (com.tencent.connect.auth.AuthAgent.this.e == null) {
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity null and return");
                return;
            }
            android.app.Activity activity = (android.app.Activity) com.tencent.connect.auth.AuthAgent.this.e.get();
            if (activity == null) {
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity.get() null and return");
                return;
            }
            android.app.Dialog dialog = new android.app.Dialog(activity);
            dialog.requestWindowFeature(1);
            android.content.pm.PackageManager packageManager = activity.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.AuthAgent", "showFeedConfrimDialog exception:" + e.getStackTrace().toString());
                packageInfo = null;
            }
            android.graphics.drawable.Drawable loadIcon = packageInfo != null ? packageInfo.applicationInfo.loadIcon(packageManager) : null;
            android.view.View.OnClickListener anonymousClass1 = new com.tencent.connect.auth.AuthAgent.b.AnonymousClass1(dialog, iUiListener, obj);
            android.view.View.OnClickListener anonymousClass2 = new com.tencent.connect.auth.AuthAgent.b.AnonymousClass2(dialog, iUiListener, obj);
            android.graphics.drawable.ColorDrawable colorDrawable = new android.graphics.drawable.ColorDrawable();
            colorDrawable.setAlpha(0);
            dialog.getWindow().setBackgroundDrawable(colorDrawable);
            dialog.setContentView(a(activity, loadIcon, str, anonymousClass1, anonymousClass2));
            dialog.setOnCancelListener(new com.tencent.connect.auth.AuthAgent.b.AnonymousClass3(iUiListener, obj));
            if (activity.isFinishing()) {
                return;
            }
            dialog.show();
        }

        public void a() {
            android.app.Activity activity;
            android.os.Bundle b = com.tencent.connect.auth.AuthAgent.this.b();
            if (com.tencent.connect.auth.AuthAgent.this.e == null || (activity = (android.app.Activity) com.tencent.connect.auth.AuthAgent.this.e.get()) == null) {
                return;
            }
            com.tencent.open.utils.HttpUtils.requestAsync(((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c, activity, "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", b, "POST", null);
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.a.get() != null) {
                this.a.get().onCancel();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onComplete(java.lang.Object obj) {
            boolean z;
            java.lang.String str;
            com.tencent.tauth.IUiListener iUiListener;
            if (obj != null) {
                org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
                boolean z2 = false;
                try {
                    z = jSONObject.getInt("sendinstall") == 1;
                } catch (org.json.JSONException unused) {
                    z = false;
                }
                try {
                    str = jSONObject.getString("installwording");
                } catch (org.json.JSONException unused2) {
                    com.tencent.open.log.SLog.w("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                    str = "";
                    java.lang.String decode = java.net.URLDecoder.decode(str);
                    com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", " WORDING = " + decode + "xx,showConfirmDialog=" + z);
                    if (!z) {
                    }
                    iUiListener = this.a.get();
                    if (iUiListener != null) {
                    }
                }
                java.lang.String decode2 = java.net.URLDecoder.decode(str);
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", " WORDING = " + decode2 + "xx,showConfirmDialog=" + z);
                if (!z && !android.text.TextUtils.isEmpty(decode2)) {
                    a(decode2, this.a.get(), obj);
                    com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", " WORDING is not empty and return");
                    return;
                }
                iUiListener = this.a.get();
                if (iUiListener != null) {
                    com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", " userListener is null");
                    return;
                }
                if (((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c != null) {
                    z2 = ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c.saveSession(jSONObject);
                    com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", " saveSession saveSuccess=" + z2);
                }
                if (z2) {
                    iUiListener.onComplete(obj);
                } else {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PERSISTENCE_FAIL, null));
                }
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            if (this.a.get() != null) {
                this.a.get().onError(uiError);
            }
        }
    }

    public class c extends com.tencent.tauth.DefaultUiListener {
        private final com.tencent.tauth.IUiListener b;
        private final boolean c;
        private final android.content.Context d;

        public c(android.content.Context context, com.tencent.tauth.IUiListener iUiListener, boolean z, boolean z2) {
            this.d = context;
            this.b = iUiListener;
            this.c = z;
            com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.b.onCancel();
            com.tencent.open.log.SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            try {
                java.lang.String string = jSONObject.getString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN);
                java.lang.String string2 = jSONObject.getString(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN);
                java.lang.String string3 = jSONObject.getString("openid");
                if (string != null && ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c != null && string3 != null) {
                    ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c.setAccessToken(string, string2);
                    ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c.setOpenId(string3);
                    com.tencent.connect.a.a.d(this.d, ((com.tencent.connect.common.BaseApi) com.tencent.connect.auth.AuthAgent.this).c);
                }
                java.lang.String string4 = jSONObject.getString("pf");
                if (string4 != null) {
                    try {
                        this.d.getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0).edit().putString("pf", string4).commit();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        com.tencent.open.log.SLog.e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e);
                    }
                }
                if (this.c) {
                    android.webkit.CookieSyncManager.getInstance().sync();
                }
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
                com.tencent.open.log.SLog.e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
            }
            this.b.onComplete(jSONObject);
            com.tencent.connect.auth.AuthAgent.this.releaseResource();
            com.tencent.open.log.SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.b.onError(uiError);
            com.tencent.open.log.SLog.release();
        }
    }

    static {
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        java.lang.String str = android.os.Build.CPU_ABI;
        if (str == null || str.equals("")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
            return;
        }
        if (str.equalsIgnoreCase("arm64-v8a")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM64_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
            return;
        }
        if (str.equalsIgnoreCase("x86")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "is x86 architecture");
            return;
        }
        if (str.equalsIgnoreCase("x86_64")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "is x86_64 architecture");
            return;
        }
        SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
    }

    public AuthAgent(com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    private int a(boolean z, com.tencent.tauth.IUiListener iUiListener, boolean z2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
        android.webkit.CookieSyncManager.createInstance(com.tencent.open.utils.f.a());
        android.os.Bundle a2 = a();
        if (z) {
            a2.putString("isadd", "1");
        }
        a2.putString(com.tencent.connect.common.Constants.PARAM_SCOPE, this.d);
        a2.putString(com.tencent.connect.common.Constants.PARAM_CLIENT_ID, this.c.getAppId());
        if (com.tencent.connect.common.BaseApi.isOEM) {
            a2.putString("pf", "desktop_m_qq-" + com.tencent.connect.common.BaseApi.installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.tencent.connect.common.BaseApi.registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.tencent.connect.common.BaseApi.businessId);
        } else {
            a2.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
        }
        java.lang.String str = (java.lang.System.currentTimeMillis() / 1000) + "";
        a2.putString("sign", com.tencent.open.utils.i.b(com.tencent.open.utils.f.a(), str));
        a2.putString("time", str);
        a2.putString("display", moji.com.mjwallet.InputSmsCodeFragmentKt.MOBILE);
        a2.putString("response_type", "token");
        a2.putString("redirect_uri", "auth://tauth.qq.com/");
        a2.putString("cancel_display", "1");
        a2.putString("switch", "1");
        a2.putString("compat_v", "1");
        if (z2) {
            a2.putString(com.anythink.expressad.foundation.h.i.e, "qr");
        }
        java.lang.String str2 = com.tencent.open.utils.h.a().a(com.tencent.open.utils.f.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + com.tencent.open.utils.HttpUtils.encodeUrl(a2);
        com.tencent.connect.auth.AuthAgent.c cVar = new com.tencent.connect.auth.AuthAgent.c(com.tencent.open.utils.f.a(), iUiListener, true, false);
        com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        com.tencent.open.utils.j.a(new com.tencent.connect.auth.AuthAgent.AnonymousClass1(str2, cVar));
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    private java.lang.String a(android.os.Bundle bundle) {
        java.lang.String string = bundle.getString("status_os");
        java.lang.String string2 = bundle.getString("status_machine");
        java.lang.String string3 = bundle.getString("status_version");
        java.lang.String string4 = bundle.getString("sdkv");
        java.lang.String string5 = bundle.getString(com.tencent.connect.common.Constants.PARAM_CLIENT_ID);
        java.lang.String string6 = bundle.getString("need_pay");
        java.lang.String string7 = bundle.getString("pf");
        com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "os=" + string + ", machine=" + string2 + ", version=" + string3 + ", sdkv=" + string4 + ", appId=" + string5 + ", needPay=" + string6 + ", pf=" + string7);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (string == null) {
            string = "";
        }
        sb.append(string);
        if (string2 == null) {
            string2 = "";
        }
        sb.append(string2);
        if (string3 == null) {
            string3 = "";
        }
        sb.append(string3);
        if (string4 == null) {
            string4 = "";
        }
        sb.append(string4);
        if (string5 == null) {
            string5 = "";
        }
        sb.append(string5);
        if (string6 == null) {
            string6 = "";
        }
        sb.append(string6);
        if (string7 == null) {
            string7 = "";
        }
        sb.append(string7);
        return sb.toString();
    }

    private void a(android.os.Bundle bundle, java.util.Map<java.lang.String, java.lang.Object> map) {
    }

    private boolean a(android.app.Activity activity, androidx.fragment.app.Fragment fragment, java.util.Map<java.lang.String, java.lang.Object> map, boolean z, java.lang.Object[] objArr) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        android.content.Intent b2 = b("com.tencent.open.agent.AgentActivity");
        if (b2 != null) {
            android.os.Bundle a2 = a();
            if (z) {
                a2.putString("isadd", "1");
            }
            a2.putString(com.tencent.connect.common.Constants.PARAM_SCOPE, this.d);
            a2.putString(com.tencent.connect.common.Constants.PARAM_CLIENT_ID, this.c.getAppId());
            if (com.tencent.connect.common.BaseApi.isOEM) {
                a2.putString("pf", "desktop_m_qq-" + com.tencent.connect.common.BaseApi.installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.tencent.connect.common.BaseApi.registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.tencent.connect.common.BaseApi.businessId);
            } else {
                a2.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
            }
            a2.putString("need_pay", "1");
            a(a2, map);
            a2.putString(com.tencent.connect.common.Constants.KEY_APP_NAME, com.tencent.open.utils.i.a(com.tencent.open.utils.f.a()));
            b2.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_login");
            b2.putExtra(com.tencent.connect.common.Constants.KEY_PARAMS, a2);
            b2.putExtra("appid", this.c.getAppId());
            a2.putString(com.tencent.connect.common.Constants.KEY_PPSTS, com.tencent.open.utils.i.a(activity, a(a2)));
            if (a(b2)) {
                this.a = new com.tencent.connect.auth.AuthAgent.b(this.a);
                com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_LOGIN, this.a);
                if (fragment != null) {
                    com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    a(fragment, b2, com.tencent.connect.common.Constants.REQUEST_LOGIN, map);
                } else {
                    com.tencent.open.log.SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    a(activity, b2, com.tencent.connect.common.Constants.REQUEST_LOGIN, map);
                }
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                com.tencent.open.a.d.a().a(0, "LOGIN_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), "", java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "");
                objArr[0] = "0";
                objArr[1] = 1;
                return true;
            }
        }
        com.tencent.open.a.d.a().a(1, "LOGIN_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), "", java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    public int a(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z, androidx.fragment.app.Fragment fragment, boolean z2) {
        return doLogin(activity, str, iUiListener, z, fragment, z2, null);
    }

    public void a(com.tencent.tauth.IUiListener iUiListener) {
        java.lang.String str;
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        java.lang.String accessToken = this.c.getAccessToken();
        java.lang.String openId = this.c.getOpenId();
        java.lang.String appId = this.c.getAppId();
        if (android.text.TextUtils.isEmpty(accessToken) || android.text.TextUtils.isEmpty(openId) || android.text.TextUtils.isEmpty(appId)) {
            str = "";
        } else {
            str = com.tencent.open.utils.l.f("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        android.os.Bundle a2 = a();
        a2.putString("encrytoken", str);
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), "https://openmobile.qq.com/user/user_login_statis", a2, "POST", null);
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }

    public void b(com.tencent.tauth.IUiListener iUiListener) {
        android.os.Bundle a2 = a();
        a2.putString("reqType", "checkLogin");
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), "https://openmobile.qq.com/v3/user/get_info", a2, "GET", new com.tencent.connect.common.BaseApi.TempRequestListener(new com.tencent.connect.auth.AuthAgent.a(iUiListener)));
    }

    public int doLogin(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z, androidx.fragment.app.Fragment fragment, boolean z2, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.d = str;
        this.e = new java.lang.ref.WeakReference<>(activity);
        this.a = iUiListener;
        java.lang.Object[] objArr = new java.lang.Object[2];
        if (!activity.getIntent().getBooleanExtra(KEY_FORCE_QR_LOGIN, false) && !com.tencent.open.utils.g.a(activity, this.c.getAppId()).b("C_LoginWeb") && a(activity, fragment, map, z, objArr)) {
            com.tencent.open.log.SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), "2", "1", "5", (java.lang.String) objArr[0], "0", "0");
            return ((java.lang.Integer) objArr[1]).intValue();
        }
        com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), "2", "1", "5", "1", "0", "0");
        com.tencent.open.log.SLog.w("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
        com.tencent.connect.auth.AuthAgent.b bVar = new com.tencent.connect.auth.AuthAgent.b(this.a);
        this.a = bVar;
        return a(z, bVar, z2);
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        this.a = null;
    }
}
