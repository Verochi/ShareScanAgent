package com.sina.weibo.sdk.share;

/* loaded from: classes19.dex */
public class ShareChatActivity extends com.sina.weibo.sdk.share.BaseActivity {
    private android.content.Intent u;
    private android.widget.FrameLayout v;
    private com.sina.weibo.sdk.b.d w;
    private android.os.Handler x = new com.sina.weibo.sdk.share.ShareChatActivity.AnonymousClass1(android.os.Looper.getMainLooper());

    /* renamed from: com.sina.weibo.sdk.share.ShareChatActivity$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            com.sina.weibo.sdk.share.ShareChatActivity.a(com.sina.weibo.sdk.share.ShareChatActivity.this);
        }
    }

    /* renamed from: com.sina.weibo.sdk.share.ShareChatActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.sina.weibo.sdk.net.c<java.lang.String> {
        final /* synthetic */ com.sina.weibo.sdk.api.ChatObject z;

        public AnonymousClass2(com.sina.weibo.sdk.api.ChatObject chatObject) {
            this.z = chatObject;
        }

        @Override // com.sina.weibo.sdk.net.c
        public final /* synthetic */ void a(java.lang.String str) {
            java.lang.String str2 = str;
            com.sina.weibo.sdk.share.ShareChatActivity.this.v.setVisibility(4);
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
                int optInt = jSONObject.optInt("code");
                java.lang.String optString = jSONObject.optString("errmsg");
                java.lang.String optString2 = jSONObject.optString("data");
                if (optInt == 0 && !android.text.TextUtils.isEmpty(optString2)) {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(optString2);
                    com.sina.weibo.sdk.share.ShareChatActivity.a(com.sina.weibo.sdk.share.ShareChatActivity.this, this.z, jSONObject2.optString("short_url"), jSONObject2.optString("object_id"));
                    return;
                }
                com.sina.weibo.sdk.share.ShareChatActivity.a(com.sina.weibo.sdk.share.ShareChatActivity.this, optString + "(" + optInt + ")");
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.sina.weibo.sdk.net.c
        public final void onError(java.lang.Throwable th) {
            com.sina.weibo.sdk.share.ShareChatActivity.this.v.setVisibility(4);
            com.sina.weibo.sdk.share.ShareChatActivity.a(com.sina.weibo.sdk.share.ShareChatActivity.this, th.getMessage());
        }
    }

    public static /* synthetic */ void a(com.sina.weibo.sdk.share.ShareChatActivity shareChatActivity) {
        android.widget.FrameLayout frameLayout = shareChatActivity.v;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        try {
            android.content.Intent intent = new android.content.Intent();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("_weibo_resp_errcode", 1);
            intent.putExtras(bundle);
            shareChatActivity.setResult(-1, intent);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        android.os.Handler handler = shareChatActivity.x;
        if (handler != null) {
            handler.removeMessages(0);
            shareChatActivity.x = null;
        }
        shareChatActivity.finish();
    }

    public static /* synthetic */ void a(com.sina.weibo.sdk.share.ShareChatActivity shareChatActivity, com.sina.weibo.sdk.api.ChatObject chatObject, java.lang.String str, java.lang.String str2) {
        try {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("page_url", str);
            bundle.putString("page_id", str2);
            bundle.putInt("page_type", 0);
            bundle.putInt("composer_launch_type", 4002);
            bundle.putBoolean("page_showcard", true);
            bundle.putString("page_pic", chatObject.image_url);
            bundle.putString(com.baidu.mobads.sdk.api.ArticleInfo.PAGE_TITLE, chatObject.content);
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(android.net.Uri.parse("sinaweibo://extendthirdshare"));
            intent.setPackage("com.sina.weibo");
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putBundle("param_bundle", bundle);
            bundle2.putInt("share_type", 1001);
            intent.putExtras(bundle2);
            shareChatActivity.startActivityForResult(intent, 10001);
        } catch (java.lang.Exception unused) {
        }
    }

    public static /* synthetic */ void a(com.sina.weibo.sdk.share.ShareChatActivity shareChatActivity, java.lang.String str) {
        android.widget.FrameLayout frameLayout = shareChatActivity.v;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        android.content.Intent intent = new android.content.Intent();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", str);
        intent.putExtras(bundle);
        shareChatActivity.setResult(-1, intent);
        shareChatActivity.finish();
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
        com.sina.weibo.sdk.b.b bVar;
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
        android.os.Bundle extras = this.u.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        com.sina.weibo.sdk.api.ChatObject chatObject = (com.sina.weibo.sdk.api.ChatObject) extras.getParcelable("chat_object");
        if (chatObject == null) {
            this.v.setVisibility(4);
            return;
        }
        com.sina.weibo.sdk.b.d dVar = this.w;
        if (dVar != null) {
            dVar.S.cancel(true);
        }
        this.w = new com.sina.weibo.sdk.b.d(this, chatObject, new com.sina.weibo.sdk.share.ShareChatActivity.AnonymousClass2(chatObject));
        bVar = com.sina.weibo.sdk.b.b.a.P;
        bVar.a(this.w);
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        android.os.Handler handler = this.x;
        if (handler != null) {
            handler.removeMessages(0);
            this.x = null;
        }
        setResult(-1, intent);
        finish();
    }
}
