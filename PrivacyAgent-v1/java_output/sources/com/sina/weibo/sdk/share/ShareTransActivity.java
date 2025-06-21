package com.sina.weibo.sdk.share;

/* loaded from: classes19.dex */
public class ShareTransActivity extends com.sina.weibo.sdk.share.BaseActivity {
    private com.sina.weibo.sdk.share.d C;
    private android.content.Intent u;
    private android.widget.FrameLayout v;
    private android.os.Handler x = new com.sina.weibo.sdk.share.ShareTransActivity.AnonymousClass1(android.os.Looper.getMainLooper());

    /* renamed from: com.sina.weibo.sdk.share.ShareTransActivity$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            com.sina.weibo.sdk.share.ShareTransActivity.a(com.sina.weibo.sdk.share.ShareTransActivity.this);
        }
    }

    /* renamed from: com.sina.weibo.sdk.share.ShareTransActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.sina.weibo.sdk.share.b {
        public AnonymousClass2() {
        }

        @Override // com.sina.weibo.sdk.share.b
        public final void a(com.sina.weibo.sdk.share.c cVar) {
            com.sina.weibo.sdk.share.ShareTransActivity.this.v.setVisibility(4);
            if (cVar == null) {
                com.sina.weibo.sdk.share.ShareTransActivity.this.c("Trans result is null.");
                return;
            }
            if (cVar.E) {
                com.sina.weibo.sdk.share.ShareTransActivity.this.a(cVar.F);
            } else if (android.text.TextUtils.isEmpty(cVar.errorMessage)) {
                com.sina.weibo.sdk.share.ShareTransActivity.this.c("Trans resource fail.");
            } else {
                com.sina.weibo.sdk.share.ShareTransActivity.this.c(cVar.errorMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.sina.weibo.sdk.api.WeiboMultiMessage weiboMultiMessage) {
        com.sina.weibo.sdk.c.c.a("WBShareTag", "start wb composer");
        try {
            this.u.putExtra("start_flag", -1);
            android.os.Bundle extras = this.u.getExtras();
            android.content.Intent intent = new android.content.Intent("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
            intent.putExtras(weiboMultiMessage.writeToBundle(extras));
            intent.putExtra("_weibo_sdkVersion", "0041005000");
            intent.putExtra("_weibo_appPackage", getPackageName());
            intent.putExtra("_weibo_appKey", com.sina.weibo.sdk.a.a().getAppKey());
            intent.putExtra("_weibo_flag", 538116905);
            intent.putExtra("_weibo_sign", com.sina.weibo.sdk.c.d.f(com.sina.weibo.sdk.c.e.e(this, getPackageName())));
            java.lang.String stringExtra = this.u.getStringExtra("start_web_activity");
            if (!android.text.TextUtils.isEmpty(stringExtra) && "com.sina.weibo.sdk.web.WebActivity".equals(stringExtra)) {
                intent.setClassName(this, stringExtra);
                startActivityForResult(intent, 10001);
            } else {
                if (!com.sina.weibo.sdk.a.a(this)) {
                    c("Start weibo client's composer fail. And Weibo client is not installed.");
                    return;
                }
                com.sina.weibo.sdk.c.a.C0466a c = com.sina.weibo.sdk.c.a.c(this);
                if (c != null) {
                    intent.setPackage(c.packageName);
                }
                startActivityForResult(intent, 10001);
            }
        } catch (java.lang.Throwable th) {
            com.sina.weibo.sdk.c.c.b("WBShareTag", "start wb composer fail," + th.getMessage());
            c("Start weibo client's composer fail. " + th.getMessage());
        }
    }

    public static /* synthetic */ void a(com.sina.weibo.sdk.share.ShareTransActivity shareTransActivity) {
        android.widget.FrameLayout frameLayout = shareTransActivity.v;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        try {
            android.content.Intent intent = new android.content.Intent();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("_weibo_resp_errcode", 1);
            intent.putExtras(bundle);
            shareTransActivity.setResult(-1, intent);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        android.os.Handler handler = shareTransActivity.x;
        if (handler != null) {
            handler.removeMessages(0);
            shareTransActivity.x = null;
        }
        shareTransActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(java.lang.String str) {
        android.widget.FrameLayout frameLayout = this.v;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        android.content.Intent intent = new android.content.Intent();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", str);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "onActivityResult.");
        android.os.Handler handler = this.x;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 100L);
        }
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "start share activity.");
        android.content.Intent intent = getIntent();
        this.u = intent;
        if (intent == null) {
            finish();
            return;
        }
        if (intent.getIntExtra("start_flag", -1) != 0) {
            finish();
            return;
        }
        this.v = new android.widget.FrameLayout(this);
        int intExtra = getIntent().getIntExtra("progress_id", -1);
        android.view.View inflate = intExtra != -1 ? ((android.view.LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra, (android.view.ViewGroup) null) : new android.widget.ProgressBar(this);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.v.addView(inflate, layoutParams);
        this.v.setBackgroundColor(855638016);
        setContentView(this.v);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "prepare wb resource.");
        android.os.Bundle extras = this.u.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        com.sina.weibo.sdk.api.WeiboMultiMessage weiboMultiMessage = new com.sina.weibo.sdk.api.WeiboMultiMessage();
        weiboMultiMessage.readFromBundle(extras);
        if (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.videoSourceObject == null) {
            a(weiboMultiMessage);
            return;
        }
        com.sina.weibo.sdk.share.d dVar = this.C;
        if (dVar != null) {
            dVar.cancel(true);
        }
        com.sina.weibo.sdk.share.d dVar2 = new com.sina.weibo.sdk.share.d(this, new com.sina.weibo.sdk.share.ShareTransActivity.AnonymousClass2());
        this.C = dVar2;
        dVar2.execute(weiboMultiMessage);
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "start share activity again.");
        android.os.Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            this.x = null;
        }
        setResult(-1, intent);
        finish();
    }
}
