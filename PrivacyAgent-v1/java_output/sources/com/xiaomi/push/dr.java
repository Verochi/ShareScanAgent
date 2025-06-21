package com.xiaomi.push;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes19.dex */
public class dr extends android.app.Notification.Builder {
    android.content.Context c;

    public dr(android.content.Context context) {
        super(context);
        this.c = context;
    }

    public static int a(android.content.res.Resources resources, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final com.xiaomi.push.dr addExtras(android.os.Bundle bundle) {
        super.addExtras(bundle);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final com.xiaomi.push.dr setCustomContentView(android.widget.RemoteViews remoteViews) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    public final com.xiaomi.push.dr a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                com.xiaomi.push.aj.a((java.lang.Object) this, "setColor", java.lang.Integer.valueOf(android.graphics.Color.parseColor(str)));
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to set color. ".concat(java.lang.String.valueOf(e)));
            }
        }
        return this;
    }

    public com.xiaomi.push.dr a(java.util.Map<java.lang.String, java.lang.String> map) {
        return this;
    }

    @Override // android.app.Notification.Builder
    public android.app.Notification build() {
        d();
        return super.build();
    }

    public void d() {
    }
}
