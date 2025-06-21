package com.anythink.expressad.out;

/* loaded from: classes12.dex */
public class LoadingActivity extends android.app.Activity {
    private android.widget.RelativeLayout b;
    private android.widget.ImageView c;
    private android.graphics.Bitmap d;
    private com.anythink.expressad.out.LoadingActivity.a e;
    private java.lang.String f;
    private android.graphics.drawable.Drawable h;
    private android.widget.RelativeLayout i;
    private com.anythink.expressad.foundation.g.d.c g = new com.anythink.expressad.out.LoadingActivity.AnonymousClass1();
    android.content.BroadcastReceiver a = new com.anythink.expressad.out.LoadingActivity.AnonymousClass2();

    /* renamed from: com.anythink.expressad.out.LoadingActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (com.anythink.expressad.out.LoadingActivity.this.c == null || bitmap == null || bitmap.isRecycled() || !((java.lang.String) com.anythink.expressad.out.LoadingActivity.this.c.getTag()).equals(str)) {
                return;
            }
            com.anythink.expressad.out.LoadingActivity.this.c.setImageBitmap(bitmap);
            com.anythink.expressad.out.LoadingActivity.this.d = bitmap;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.out.LoadingActivity$2, reason: invalid class name */
    public class AnonymousClass2 extends android.content.BroadcastReceiver {
        public AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            com.anythink.expressad.out.LoadingActivity.this.finish();
        }
    }

    public interface a {
        void a();
    }

    private android.view.View a() {
        if (this.b == null) {
            this.b = new android.widget.RelativeLayout(this);
            this.i = new android.widget.RelativeLayout(this);
            int b = com.anythink.expressad.foundation.h.t.b(this, 15.0f);
            this.i.setPadding(b, b, b, b);
            this.i.setBackgroundResource(getResources().getIdentifier("anythink_native_bg_loading_camera", com.anythink.expressad.foundation.h.i.c, getPackageName()));
            this.i.addView(new android.widget.TextView(this), new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(this, 140.0f), com.anythink.expressad.foundation.h.t.b(this, 31.5f)));
            com.anythink.expressad.widget.ATImageView aTImageView = new com.anythink.expressad.widget.ATImageView(this);
            this.c = aTImageView;
            aTImageView.setId(com.anythink.expressad.foundation.h.t.a());
            this.c.setTag(this.f);
            if (!android.text.TextUtils.isEmpty(this.f)) {
                com.anythink.expressad.foundation.g.d.b.a(getApplicationContext()).a(this.f, this.g);
            }
            int b2 = com.anythink.expressad.foundation.h.t.b(this, 64.0f);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(b2, b2);
            layoutParams.addRule(13, -1);
            this.i.addView(this.c, layoutParams);
            android.widget.TextView textView = new android.widget.TextView(this);
            textView.setSingleLine();
            textView.setTextColor(-1);
            textView.setTextSize(16.0f);
            textView.setText("Relax while loading....");
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(3, this.c.getId());
            layoutParams2.addRule(14, -1);
            this.i.addView(textView, layoutParams2);
            this.b.addView(this.i, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        }
        return this.b;
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("icon_url")) {
            this.f = getIntent().getStringExtra("icon_url");
        }
        if (this.b == null) {
            this.b = new android.widget.RelativeLayout(this);
            this.i = new android.widget.RelativeLayout(this);
            int b = com.anythink.expressad.foundation.h.t.b(this, 15.0f);
            this.i.setPadding(b, b, b, b);
            this.i.setBackgroundResource(getResources().getIdentifier("anythink_native_bg_loading_camera", com.anythink.expressad.foundation.h.i.c, getPackageName()));
            this.i.addView(new android.widget.TextView(this), new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(this, 140.0f), com.anythink.expressad.foundation.h.t.b(this, 31.5f)));
            com.anythink.expressad.widget.ATImageView aTImageView = new com.anythink.expressad.widget.ATImageView(this);
            this.c = aTImageView;
            aTImageView.setId(com.anythink.expressad.foundation.h.t.a());
            this.c.setTag(this.f);
            if (!android.text.TextUtils.isEmpty(this.f)) {
                com.anythink.expressad.foundation.g.d.b.a(getApplicationContext()).a(this.f, this.g);
            }
            int b2 = com.anythink.expressad.foundation.h.t.b(this, 64.0f);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(b2, b2);
            layoutParams.addRule(13, -1);
            this.i.addView(this.c, layoutParams);
            android.widget.TextView textView = new android.widget.TextView(this);
            textView.setSingleLine();
            textView.setTextColor(-1);
            textView.setTextSize(16.0f);
            textView.setText("Relax while loading....");
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(3, this.c.getId());
            layoutParams2.addRule(14, -1);
            this.i.addView(textView, layoutParams2);
            this.b.addView(this.i, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        }
        setContentView(this.b);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (this.a != null) {
            com.anythink.core.common.b.l.a(this).a(this.a);
        }
        android.widget.ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        this.c = null;
        this.b = null;
        this.g = null;
        this.h = null;
        android.widget.RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundDrawable(null);
        }
        this.i = null;
        android.graphics.Bitmap bitmap = this.d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.d = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("ExitApp");
        if (this.a != null) {
            com.anythink.core.common.b.l.a(this).a(this.a, intentFilter);
        }
    }
}
