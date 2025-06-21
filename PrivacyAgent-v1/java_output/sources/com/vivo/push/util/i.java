package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class i implements com.vivo.push.util.BaseNotifyLayoutAdapter {
    private android.content.res.Resources a;
    private java.lang.String b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.a.getIdentifier("push_notify", "layout", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        android.content.res.Resources resources;
        java.lang.String str;
        if (com.vivo.push.util.j.c) {
            resources = this.a;
            str = "notify_icon_rom30";
        } else if (com.vivo.push.util.j.b) {
            resources = this.a;
            str = "notify_icon_rom20";
        } else {
            resources = this.a;
            str = "notify_icon";
        }
        return resources.getIdentifier(str, "id", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i;
        try {
            i = ((java.lang.Integer) com.vivo.push.util.z.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            return this.a.getColor(i);
        }
        boolean z = com.vivo.push.util.j.c;
        if (z) {
            return -1;
        }
        if (!com.vivo.push.util.j.b) {
            return androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
        }
        if (z) {
            return android.graphics.Color.parseColor("#ff999999");
        }
        return -1;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(android.content.Context context) {
        this.b = context.getPackageName();
        this.a = context.getResources();
    }
}
