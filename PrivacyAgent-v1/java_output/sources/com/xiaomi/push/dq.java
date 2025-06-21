package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class dq extends com.xiaomi.push.dt {
    public android.graphics.Bitmap a;
    public android.graphics.Bitmap b;
    private int j;

    public dq(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.j = 16777216;
    }

    private com.xiaomi.push.dq b(java.lang.String str) {
        if (this.e && !android.text.TextUtils.isEmpty(str)) {
            try {
                this.j = android.graphics.Color.parseColor(str);
            } catch (java.lang.Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dt
    /* renamed from: a */
    public final com.xiaomi.push.dt setLargeIcon(android.graphics.Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.dt
    public final java.lang.String a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.dt
    public final java.lang.String b() {
        return null;
    }

    @Override // com.xiaomi.push.dt
    public final boolean c() {
        if (!com.xiaomi.push.iu.a()) {
            return false;
        }
        android.content.res.Resources resources = this.c.getResources();
        java.lang.String packageName = this.c.getPackageName();
        return (com.xiaomi.push.dr.a(this.c.getResources(), "bg", "id", this.c.getPackageName()) == 0 || com.xiaomi.push.dr.a(resources, "icon", "id", packageName) == 0 || com.xiaomi.push.dr.a(resources, "title", "id", packageName) == 0 || com.xiaomi.push.iu.g() < 9) ? false : true;
    }

    @Override // com.xiaomi.push.dt, com.xiaomi.push.dr
    public final void d() {
        android.widget.RemoteViews remoteViews;
        android.graphics.Bitmap bitmap;
        if (!this.e || this.a == null) {
            e();
            return;
        }
        super.d();
        android.content.res.Resources resources = this.c.getResources();
        java.lang.String packageName = this.c.getPackageName();
        int a = com.xiaomi.push.dr.a(resources, "bg", "id", packageName);
        if (com.xiaomi.push.iu.g() >= 10) {
            remoteViews = this.d;
            bitmap = com.xiaomi.push.dt.b(this.a);
        } else {
            remoteViews = this.d;
            bitmap = this.a;
        }
        remoteViews.setImageViewBitmap(a, bitmap);
        int a2 = com.xiaomi.push.dr.a(resources, "icon", "id", packageName);
        android.graphics.Bitmap bitmap2 = this.b;
        if (bitmap2 != null) {
            this.d.setImageViewBitmap(a2, bitmap2);
        } else {
            a(a2);
        }
        int a3 = com.xiaomi.push.dr.a(resources, "title", "id", packageName);
        this.d.setTextViewText(a3, this.g);
        java.util.Map<java.lang.String, java.lang.String> map = this.i;
        if (map != null && this.j == 16777216) {
            b(map.get("notification_image_text_color"));
        }
        android.widget.RemoteViews remoteViews2 = this.d;
        int i = this.j;
        remoteViews2.setTextColor(a3, (i == 16777216 || !com.xiaomi.push.dt.b(i)) ? -1 : androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        setCustomContentView(this.d);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }

    @Override // com.xiaomi.push.dt, android.app.Notification.Builder
    public final /* synthetic */ android.app.Notification.Builder setLargeIcon(android.graphics.Bitmap bitmap) {
        return this;
    }
}
