package com.sina.weibo.sdk.share;

/* loaded from: classes19.dex */
public class ShareStoryActivity extends com.sina.weibo.sdk.share.BaseActivity {
    private com.sina.weibo.sdk.share.e A;
    private android.content.Intent u;
    private android.widget.FrameLayout v;
    private android.os.Handler x = new com.sina.weibo.sdk.share.ShareStoryActivity.AnonymousClass1(android.os.Looper.getMainLooper());

    /* renamed from: com.sina.weibo.sdk.share.ShareStoryActivity$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            com.sina.weibo.sdk.share.ShareStoryActivity.this.a(1, com.anythink.expressad.d.a.b.dO);
        }
    }

    /* renamed from: com.sina.weibo.sdk.share.ShareStoryActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.sina.weibo.sdk.share.b {
        public AnonymousClass2() {
        }

        @Override // com.sina.weibo.sdk.share.b
        public final void a(com.sina.weibo.sdk.share.c cVar) {
            com.sina.weibo.sdk.share.ShareStoryActivity.this.v.setVisibility(4);
            if (cVar == null) {
                com.sina.weibo.sdk.share.ShareStoryActivity.this.c("Trans result is null.");
                return;
            }
            if (cVar.E) {
                com.sina.weibo.sdk.share.ShareStoryActivity.a(com.sina.weibo.sdk.share.ShareStoryActivity.this, cVar.G);
            } else if (android.text.TextUtils.isEmpty(cVar.errorMessage)) {
                com.sina.weibo.sdk.share.ShareStoryActivity.this.c("Trans story fail.");
            } else {
                com.sina.weibo.sdk.share.ShareStoryActivity.this.c(cVar.errorMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, java.lang.String str) {
        android.widget.FrameLayout frameLayout = this.v;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        try {
            try {
                android.content.Intent intent = new android.content.Intent();
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putInt("_weibo_resp_errcode", i);
                bundle.putString("_weibo_resp_errstr", str);
                intent.putExtras(bundle);
                setResult(-1, intent);
                android.os.Handler handler = this.x;
                if (handler != null) {
                    handler.removeMessages(0);
                    this.x = null;
                }
                finish();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                android.os.Handler handler2 = this.x;
                if (handler2 != null) {
                    handler2.removeMessages(0);
                    this.x = null;
                }
                finish();
            }
        } catch (java.lang.Throwable th) {
            android.os.Handler handler3 = this.x;
            if (handler3 != null) {
                handler3.removeMessages(0);
                this.x = null;
            }
            finish();
            throw th;
        }
    }

    public static /* synthetic */ void a(com.sina.weibo.sdk.share.ShareStoryActivity shareStoryActivity, com.sina.weibo.sdk.api.StoryObject storyObject) {
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("sinaweibo://story/publish?forceedit=1&finish=true"));
            intent.setPackage("com.sina.weibo");
            intent.putExtra("storyData", storyObject);
            shareStoryActivity.startActivityForResult(intent, 10001);
        } catch (java.lang.Exception e) {
            shareStoryActivity.c(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(java.lang.String str) {
        android.os.Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            this.x = null;
        }
        a(2, str);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        android.os.Handler handler = this.x;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 100L);
        }
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
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
        if (this.u.getExtras() == null) {
            finish();
            return;
        }
        com.sina.weibo.sdk.api.StoryMessage storyMessage = (com.sina.weibo.sdk.api.StoryMessage) getIntent().getParcelableExtra("_weibo_message_stroy");
        if (storyMessage == null) {
            c("StoryMessage is null.");
            return;
        }
        if (!storyMessage.checkResource() || !com.sina.weibo.sdk.a.b(this)) {
            c("StoryMessage's resource is error.");
            return;
        }
        com.sina.weibo.sdk.share.e eVar = this.A;
        if (eVar != null) {
            eVar.cancel(true);
        }
        com.sina.weibo.sdk.share.e eVar2 = new com.sina.weibo.sdk.share.e(this, new com.sina.weibo.sdk.share.ShareStoryActivity.AnonymousClass2());
        this.A = eVar2;
        eVar2.execute(storyMessage);
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        android.os.Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            this.x = null;
        }
        if (intent.getIntExtra("backType", 0) == 0) {
            a(1, com.anythink.expressad.d.a.b.dO);
        } else {
            a(0, "ok");
        }
    }
}
