package com.tencent.connect.avatar;

/* loaded from: classes19.dex */
public class ImageActivity extends android.app.Activity {
    android.widget.RelativeLayout a;
    private com.tencent.connect.auth.QQToken b;
    private java.lang.String c;
    private android.os.Handler d;
    private com.tencent.connect.avatar.c e;
    private android.widget.Button f;
    private android.widget.Button g;
    private com.tencent.connect.avatar.b h;
    private android.widget.TextView i;
    private android.widget.ProgressBar j;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private android.graphics.Bitmap f435s;
    private int k = 0;
    private boolean l = false;
    private long m = 0;
    private int n = 0;
    private final int o = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
    private final int p = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
    private android.graphics.Rect q = new android.graphics.Rect();
    private final android.view.View.OnClickListener t = new com.tencent.connect.avatar.ImageActivity.AnonymousClass2();
    private final android.view.View.OnClickListener u = new com.tencent.connect.avatar.ImageActivity.AnonymousClass3();
    private final com.tencent.tauth.IUiListener v = new com.tencent.connect.avatar.ImageActivity.AnonymousClass5();
    private final com.tencent.tauth.IUiListener w = new com.tencent.connect.avatar.ImageActivity.AnonymousClass6();

    /* renamed from: com.tencent.connect.avatar.ImageActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            com.tencent.connect.avatar.ImageActivity.this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            com.tencent.connect.avatar.ImageActivity imageActivity = com.tencent.connect.avatar.ImageActivity.this;
            imageActivity.q = imageActivity.h.a();
            com.tencent.connect.avatar.ImageActivity.this.e.a(com.tencent.connect.avatar.ImageActivity.this.q);
        }
    }

    /* renamed from: com.tencent.connect.avatar.ImageActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {

        /* renamed from: com.tencent.connect.avatar.ImageActivity$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.connect.avatar.ImageActivity.this.c();
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.tencent.connect.avatar.ImageActivity.this.j.setVisibility(0);
            com.tencent.connect.avatar.ImageActivity.this.g.setEnabled(false);
            com.tencent.connect.avatar.ImageActivity.this.g.setTextColor(android.graphics.Color.rgb(21, 21, 21));
            com.tencent.connect.avatar.ImageActivity.this.f.setEnabled(false);
            com.tencent.connect.avatar.ImageActivity.this.f.setTextColor(android.graphics.Color.rgb(36, 94, 134));
            new java.lang.Thread(new com.tencent.connect.avatar.ImageActivity.AnonymousClass2.AnonymousClass1()).start();
            if (com.tencent.connect.avatar.ImageActivity.this.l) {
                com.tencent.connect.avatar.ImageActivity.this.a("10657", 0L);
            } else {
                com.tencent.connect.avatar.ImageActivity.this.a("10655", java.lang.System.currentTimeMillis() - com.tencent.connect.avatar.ImageActivity.this.m);
                if (com.tencent.connect.avatar.ImageActivity.this.e.b) {
                    com.tencent.connect.avatar.ImageActivity.this.a("10654", 0L);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.tencent.connect.avatar.ImageActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.tencent.connect.avatar.ImageActivity.this.a("10656", java.lang.System.currentTimeMillis() - com.tencent.connect.avatar.ImageActivity.this.m);
            com.tencent.connect.avatar.ImageActivity.this.setResult(0);
            com.tencent.connect.avatar.ImageActivity.this.d();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.tencent.connect.avatar.ImageActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;

        public AnonymousClass4(java.lang.String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.connect.avatar.ImageActivity.this.b(this.a, this.b);
        }
    }

    /* renamed from: com.tencent.connect.avatar.ImageActivity$5, reason: invalid class name */
    public class AnonymousClass5 extends com.tencent.tauth.DefaultUiListener {
        public AnonymousClass5() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            com.tencent.connect.avatar.ImageActivity.this.g.setEnabled(true);
            int i = -1;
            com.tencent.connect.avatar.ImageActivity.this.g.setTextColor(-1);
            com.tencent.connect.avatar.ImageActivity.this.f.setEnabled(true);
            com.tencent.connect.avatar.ImageActivity.this.f.setTextColor(-1);
            com.tencent.connect.avatar.ImageActivity.this.j.setVisibility(8);
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            try {
                i = jSONObject.getInt("ret");
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            if (i != 0) {
                com.tencent.connect.avatar.ImageActivity.this.a("设置出错了，请重新登录再尝试下呢：）", 1);
                com.tencent.open.a.d.a().a(com.tencent.connect.avatar.ImageActivity.this.b.getOpenId(), com.tencent.connect.avatar.ImageActivity.this.b.getAppId(), com.tencent.connect.common.Constants.VIA_SET_AVATAR_SUCCEED, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN, "1");
                return;
            }
            com.tencent.connect.avatar.ImageActivity.this.a("设置成功", 0);
            com.tencent.connect.avatar.ImageActivity.this.a("10658", 0L);
            com.tencent.open.a.d.a().a(com.tencent.connect.avatar.ImageActivity.this.b.getOpenId(), com.tencent.connect.avatar.ImageActivity.this.b.getAppId(), com.tencent.connect.common.Constants.VIA_SET_AVATAR_SUCCEED, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, "3", "0");
            com.tencent.connect.avatar.ImageActivity imageActivity = com.tencent.connect.avatar.ImageActivity.this;
            if (imageActivity.c != null && !"".equals(com.tencent.connect.avatar.ImageActivity.this.c)) {
                android.content.Intent intent = new android.content.Intent();
                intent.setClassName(imageActivity, com.tencent.connect.avatar.ImageActivity.this.c);
                if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                    imageActivity.startActivity(intent);
                }
            }
            com.tencent.connect.avatar.ImageActivity.this.a(0, jSONObject.toString(), null, null);
            com.tencent.connect.avatar.ImageActivity.this.d();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.connect.avatar.ImageActivity.this.g.setEnabled(true);
            com.tencent.connect.avatar.ImageActivity.this.g.setTextColor(-1);
            com.tencent.connect.avatar.ImageActivity.this.f.setEnabled(true);
            com.tencent.connect.avatar.ImageActivity.this.f.setTextColor(-1);
            com.tencent.connect.avatar.ImageActivity.this.f.setText("重试");
            com.tencent.connect.avatar.ImageActivity.this.j.setVisibility(8);
            com.tencent.connect.avatar.ImageActivity.this.l = true;
            com.tencent.connect.avatar.ImageActivity.this.a(uiError.errorMessage, 1);
            com.tencent.connect.avatar.ImageActivity.this.a("10660", 0L);
        }
    }

    /* renamed from: com.tencent.connect.avatar.ImageActivity$6, reason: invalid class name */
    public class AnonymousClass6 extends com.tencent.tauth.DefaultUiListener {

        /* renamed from: com.tencent.connect.avatar.ImageActivity$6$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;

            public AnonymousClass1(java.lang.String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.connect.avatar.ImageActivity.this.c(this.a);
            }
        }

        public AnonymousClass6() {
        }

        private void a(int i) {
            if (com.tencent.connect.avatar.ImageActivity.this.k < 2) {
                com.tencent.connect.avatar.ImageActivity.this.e();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            int i = -1;
            try {
                i = jSONObject.getInt("ret");
                if (i == 0) {
                    com.tencent.connect.avatar.ImageActivity.this.d.post(new com.tencent.connect.avatar.ImageActivity.AnonymousClass6.AnonymousClass1(jSONObject.getString("nickname")));
                    com.tencent.connect.avatar.ImageActivity.this.a("10659", 0L);
                } else {
                    com.tencent.connect.avatar.ImageActivity.this.a("10661", 0L);
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            if (i != 0) {
                a(i);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            a(0);
        }
    }

    public class QQAvatarImp extends com.tencent.connect.common.BaseApi {
        public QQAvatarImp(com.tencent.connect.auth.QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(android.graphics.Bitmap bitmap, com.tencent.tauth.IUiListener iUiListener) {
            android.os.Bundle a = a();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            com.tencent.connect.common.BaseApi.TempRequestListener tempRequestListener = new com.tencent.connect.common.BaseApi.TempRequestListener(iUiListener);
            a.putByteArray("picture", byteArray);
            com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), "user/set_user_face", a, "POST", tempRequestListener);
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SET_AVATAR_SUCCEED, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    public class a extends android.view.View {
        public a(android.content.Context context) {
            super(context);
        }

        public void a(android.widget.Button button) {
            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
            android.graphics.drawable.Drawable b = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.blue_normal.png");
            android.graphics.drawable.Drawable b2 = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.blue_down.png");
            android.graphics.drawable.Drawable b3 = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(android.view.View.PRESSED_ENABLED_STATE_SET, b2);
            stateListDrawable.addState(android.view.View.ENABLED_FOCUSED_STATE_SET, b);
            stateListDrawable.addState(android.view.View.ENABLED_STATE_SET, b);
            stateListDrawable.addState(android.view.View.FOCUSED_STATE_SET, b);
            stateListDrawable.addState(android.view.View.EMPTY_STATE_SET, b3);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void b(android.widget.Button button) {
            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
            android.graphics.drawable.Drawable b = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.gray_normal.png");
            android.graphics.drawable.Drawable b2 = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.gray_down.png");
            android.graphics.drawable.Drawable b3 = com.tencent.connect.avatar.ImageActivity.this.b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(android.view.View.PRESSED_ENABLED_STATE_SET, b2);
            stateListDrawable.addState(android.view.View.ENABLED_FOCUSED_STATE_SET, b);
            stateListDrawable.addState(android.view.View.ENABLED_STATE_SET, b);
            stateListDrawable.addState(android.view.View.FOCUSED_STATE_SET, b);
            stateListDrawable.addState(android.view.View.EMPTY_STATE_SET, b3);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    private android.graphics.Bitmap a(java.lang.String str) throws java.io.IOException {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        android.net.Uri parse = android.net.Uri.parse(str);
        java.io.InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            android.graphics.BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (java.lang.OutOfMemoryError e) {
            e.printStackTrace();
        }
        openInputStream.close();
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        while (i2 * i3 > 4194304) {
            i2 /= 2;
            i3 /= 2;
            i *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        try {
            return android.graphics.BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private android.view.View a() {
        android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
        android.view.ViewGroup.LayoutParams layoutParams2 = new android.view.ViewGroup.LayoutParams(-1, -1);
        android.view.ViewGroup.LayoutParams layoutParams3 = new android.view.ViewGroup.LayoutParams(-2, -2);
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this);
        this.a = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.a.setBackgroundColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        android.widget.RelativeLayout relativeLayout2 = new android.widget.RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.a.addView(relativeLayout2);
        com.tencent.connect.avatar.c cVar = new com.tencent.connect.avatar.c(this);
        this.e = cVar;
        cVar.setLayoutParams(layoutParams2);
        this.e.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.e);
        this.h = new com.tencent.connect.avatar.b(this);
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.h.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.h);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutParams5 = new android.widget.RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.a.a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.a.addView(linearLayout);
        android.widget.ImageView imageView = new android.widget.ImageView(this);
        imageView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 24.0f), com.tencent.connect.avatar.a.a(this, 24.0f)));
        imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.i = new android.widget.TextView(this);
        android.widget.LinearLayout.LayoutParams layoutParams6 = new android.widget.LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.i.setLayoutParams(layoutParams6);
        this.i.setEllipsize(android.text.TextUtils.TruncateAt.END);
        this.i.setSingleLine();
        this.i.setTextColor(-1);
        this.i.setTextSize(24.0f);
        this.i.setVisibility(8);
        linearLayout.addView(this.i);
        android.widget.RelativeLayout relativeLayout3 = new android.widget.RelativeLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutParams7 = new android.widget.RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.a.a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int a2 = com.tencent.connect.avatar.a.a(this, 10.0f);
        relativeLayout3.setPadding(a2, a2, a2, 0);
        this.a.addView(relativeLayout3);
        com.tencent.connect.avatar.ImageActivity.a aVar = new com.tencent.connect.avatar.ImageActivity.a(this);
        int a3 = com.tencent.connect.avatar.a.a(this, 14.0f);
        int a4 = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.g = new android.widget.Button(this);
        this.g.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f)));
        this.g.setText("取消");
        this.g.setTextColor(-1);
        this.g.setTextSize(18.0f);
        this.g.setPadding(a3, a4, a3, a4);
        aVar.b(this.g);
        relativeLayout3.addView(this.g);
        this.f = new android.widget.Button(this);
        android.widget.RelativeLayout.LayoutParams layoutParams8 = new android.widget.RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f.setLayoutParams(layoutParams8);
        this.f.setTextColor(-1);
        this.f.setTextSize(18.0f);
        this.f.setPadding(a3, a4, a3, a4);
        this.f.setText("选取");
        aVar.a(this.f);
        relativeLayout3.addView(this.f);
        android.widget.TextView textView = new android.widget.TextView(this);
        android.widget.RelativeLayout.LayoutParams layoutParams9 = new android.widget.RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, com.tencent.connect.avatar.a.a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout3.addView(textView);
        this.j = new android.widget.ProgressBar(this);
        android.widget.RelativeLayout.LayoutParams layoutParams10 = new android.widget.RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.j.setLayoutParams(layoutParams10);
        this.j.setVisibility(8);
        this.a.addView(this.j);
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ERROR_CODE, i);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    private void a(android.graphics.Bitmap bitmap) {
        new com.tencent.connect.avatar.ImageActivity.QQAvatarImp(this.b).setAvator(bitmap, this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, int i) {
        this.d.post(new com.tencent.connect.avatar.ImageActivity.AnonymousClass4(str, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.drawable.Drawable b(java.lang.String str) {
        return com.tencent.open.utils.l.a(str, this);
    }

    private void b() {
        android.graphics.Bitmap a2;
        try {
            a2 = a(this.r);
            this.f435s = a2;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            a(com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, e.getMessage());
            d();
        }
        if (a2 != null) {
            this.e.setImageBitmap(a2);
            this.f.setOnClickListener(this.t);
            this.g.setOnClickListener(this.u);
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(new com.tencent.connect.avatar.ImageActivity.AnonymousClass1());
            return;
        }
        throw new java.io.IOException("cannot read picture: '" + this.r + "'!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str, int i) {
        android.widget.Toast makeText = android.widget.Toast.makeText(this, str, 1);
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) makeText.getView();
        ((android.widget.TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        android.widget.ImageView imageView = new android.widget.ImageView(this);
        imageView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 16.0f), com.tencent.connect.avatar.a.a(this, 16.0f)));
        if (i == 0) {
            imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        float width = this.q.width();
        android.graphics.Matrix imageMatrix = this.e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float f4 = 640.0f / width;
        android.graphics.Rect rect = this.q;
        int i = (int) ((rect.left - f) / f3);
        int i2 = i < 0 ? 0 : i;
        int i3 = (int) ((rect.top - f2) / f3);
        int i4 = i3 < 0 ? 0 : i3;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(f4, f4);
        int i5 = (int) (650.0f / f3);
        try {
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(this.f435s, i2, i4, java.lang.Math.min(this.f435s.getWidth() - i2, i5), java.lang.Math.min(this.f435s.getHeight() - i4, i5), matrix, true);
            android.graphics.Bitmap createBitmap2 = android.graphics.Bitmap.createBitmap(createBitmap, 0, 0, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH);
            createBitmap.recycle();
            a(createBitmap2);
        } catch (java.lang.IllegalArgumentException e) {
            e.printStackTrace();
            a(com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, com.tencent.connect.common.Constants.MSG_IMAGE_ERROR, e.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(java.lang.String str) {
        java.lang.String d = d(str);
        if ("".equals(d)) {
            return;
        }
        this.i.setText(d);
        this.i.setVisibility(0);
    }

    private java.lang.String d(java.lang.String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        finish();
        int i = this.n;
        if (i != 0) {
            overridePendingTransition(0, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.k++;
        new com.tencent.connect.UserInfo(this, this.b).getUserInfo(this.w);
    }

    public void a(java.lang.String str, long j) {
        com.tencent.open.utils.l.a(this, str, j, this.b.getAppId());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        d();
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(a());
        this.d = new android.os.Handler();
        android.os.Bundle bundleExtra = getIntent().getBundleExtra(com.tencent.connect.common.Constants.KEY_PARAMS);
        this.r = bundleExtra.getString("picture");
        this.c = bundleExtra.getString("return_activity");
        java.lang.String string = bundleExtra.getString("appid");
        java.lang.String string2 = bundleExtra.getString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN);
        long j = bundleExtra.getLong(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN);
        java.lang.String string3 = bundleExtra.getString("openid");
        this.n = bundleExtra.getInt("exitAnim");
        com.tencent.connect.auth.QQToken qQToken = new com.tencent.connect.auth.QQToken(string);
        this.b = qQToken;
        qQToken.setAccessToken(string2, ((j - java.lang.System.currentTimeMillis()) / 1000) + "");
        this.b.setOpenId(string3);
        b();
        e();
        this.m = java.lang.System.currentTimeMillis();
        a("10653", 0L);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.e.setImageBitmap(null);
        android.graphics.Bitmap bitmap = this.f435s;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f435s.recycle();
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
