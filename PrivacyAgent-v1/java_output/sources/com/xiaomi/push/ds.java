package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ds extends com.xiaomi.push.dt {
    public android.graphics.Bitmap a;
    private int b;
    private java.lang.CharSequence j;
    private android.app.PendingIntent k;
    private int l;
    private int m;

    public ds(android.content.Context context, int i, java.lang.String str) {
        super(context, i, str);
        this.b = 16777216;
        this.l = 16777216;
        this.m = 16777216;
    }

    private static android.graphics.drawable.Drawable a(int i, int i2, int i3, float f) {
        android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable();
        shapeDrawable.setShape(new android.graphics.drawable.shapes.RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(android.graphics.Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i3);
        return shapeDrawable;
    }

    private void a(android.widget.RemoteViews remoteViews, int i, int i2, int i3, boolean z) {
        int a = a(6.0f);
        remoteViews.setViewPadding(i, a, 0, a, 0);
        int i4 = z ? -1 : androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
        remoteViews.setTextColor(i2, i4);
        remoteViews.setTextColor(i3, i4);
    }

    private com.xiaomi.push.ds d(java.lang.String str) {
        if (this.e && !android.text.TextUtils.isEmpty(str)) {
            try {
                this.m = android.graphics.Color.parseColor(str);
            } catch (java.lang.Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.a("parse colorful notification image text color error");
            }
        }
        return this;
    }

    public final com.xiaomi.push.ds a(java.lang.CharSequence charSequence, android.app.PendingIntent pendingIntent) {
        if (this.e) {
            super.addAction(0, charSequence, pendingIntent);
            this.j = charSequence;
            this.k = pendingIntent;
        }
        return this;
    }

    @Override // com.xiaomi.push.dt
    public final java.lang.String a() {
        return "notification_colorful";
    }

    public final com.xiaomi.push.ds b(java.lang.String str) {
        if (this.e && !android.text.TextUtils.isEmpty(str)) {
            try {
                this.l = android.graphics.Color.parseColor(str);
            } catch (java.lang.Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dt
    public final java.lang.String b() {
        return "notification_colorful_copy";
    }

    public final com.xiaomi.push.ds c(java.lang.String str) {
        if (this.e && !android.text.TextUtils.isEmpty(str)) {
            try {
                this.b = android.graphics.Color.parseColor(str);
            } catch (java.lang.Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dt
    public final boolean c() {
        if (!com.xiaomi.push.iu.a()) {
            return false;
        }
        android.content.res.Resources resources = this.c.getResources();
        java.lang.String packageName = this.c.getPackageName();
        return (com.xiaomi.push.dr.a(resources, "icon", "id", packageName) == 0 || com.xiaomi.push.dr.a(resources, "title", "id", packageName) == 0 || com.xiaomi.push.dr.a(resources, "content", "id", packageName) == 0) ? false : true;
    }

    @Override // com.xiaomi.push.dt, com.xiaomi.push.dr
    public final void d() {
        android.widget.RemoteViews remoteViews;
        android.graphics.Bitmap bitmap;
        boolean z;
        android.widget.RemoteViews remoteViews2;
        android.widget.RemoteViews remoteViews3;
        int i;
        float f;
        if (!this.e) {
            e();
            return;
        }
        super.d();
        android.content.res.Resources resources = this.c.getResources();
        java.lang.String packageName = this.c.getPackageName();
        int a = com.xiaomi.push.dr.a(resources, "icon", "id", packageName);
        android.graphics.Bitmap bitmap2 = this.f;
        if (bitmap2 == null) {
            a(a);
        } else {
            this.d.setImageViewBitmap(a, bitmap2);
        }
        int a2 = com.xiaomi.push.dr.a(resources, "title", "id", packageName);
        int a3 = com.xiaomi.push.dr.a(resources, "content", "id", packageName);
        this.d.setTextViewText(a2, this.g);
        this.d.setTextViewText(a3, this.h);
        if (!android.text.TextUtils.isEmpty(this.j)) {
            int a4 = com.xiaomi.push.dr.a(resources, "buttonContainer", "id", packageName);
            int a5 = com.xiaomi.push.dr.a(resources, com.sensorsdata.sf.ui.view.UIProperty.type_button, "id", packageName);
            int a6 = com.xiaomi.push.dr.a(resources, "buttonBg", "id", packageName);
            this.d.setViewVisibility(a4, 0);
            this.d.setTextViewText(a5, this.j);
            this.d.setOnClickPendingIntent(a4, this.k);
            if (this.l != 16777216) {
                int a7 = a(70.0f);
                int a8 = a(29.0f);
                this.d.setImageViewBitmap(a6, com.xiaomi.push.service.p.a(a(this.l, a7, a8, a8 / 2.0f)));
                this.d.setTextColor(a5, com.xiaomi.push.dt.b(this.l) ? -1 : androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
            }
        }
        int a9 = com.xiaomi.push.dr.a(resources, "bg", "id", packageName);
        int a10 = com.xiaomi.push.dr.a(resources, "container", "id", packageName);
        if (this.b != 16777216) {
            if (com.xiaomi.push.iu.g() >= 10) {
                remoteViews3 = this.d;
                i = this.b;
                f = 30.0f;
            } else {
                remoteViews3 = this.d;
                i = this.b;
                f = 0.0f;
            }
            remoteViews3.setImageViewBitmap(a9, com.xiaomi.push.service.p.a(a(i, 984, 192, f)));
            remoteViews2 = this.d;
            z = com.xiaomi.push.dt.b(this.b);
        } else {
            if (this.a == null) {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    this.d.setViewVisibility(a, 8);
                    this.d.setViewVisibility(a9, 8);
                    try {
                        com.xiaomi.push.aj.a((java.lang.Object) this, "setStyle", com.xiaomi.push.jc.a(this.c, "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]));
                    } catch (java.lang.Exception unused) {
                        com.xiaomi.channel.commonutils.logger.b.a("load class DecoratedCustomViewStyle failed");
                    }
                }
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putBoolean("miui.customHeight", true);
                addExtras(bundle);
                setCustomContentView(this.d);
            }
            if (com.xiaomi.push.iu.g() >= 10) {
                remoteViews = this.d;
                bitmap = com.xiaomi.push.dt.b(this.a);
            } else {
                remoteViews = this.d;
                bitmap = this.a;
            }
            remoteViews.setImageViewBitmap(a9, bitmap);
            java.util.Map<java.lang.String, java.lang.String> map = this.i;
            if (map != null && this.m == 16777216) {
                d(map.get("notification_image_text_color"));
            }
            int i2 = this.m;
            z = i2 == 16777216 || !com.xiaomi.push.dt.b(i2);
            remoteViews2 = this.d;
        }
        a(remoteViews2, a10, a2, a3, z);
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putBoolean("miui.customHeight", true);
        addExtras(bundle2);
        setCustomContentView(this.d);
    }
}
