package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public class NotificationTarget extends com.alimm.tanx.ui.image.glide.request.target.SimpleTarget<android.graphics.Bitmap> {
    private final android.content.Context context;
    private final android.app.Notification notification;
    private final int notificationId;
    private final android.widget.RemoteViews remoteViews;
    private final int viewId;

    public NotificationTarget(android.content.Context context, android.widget.RemoteViews remoteViews, int i, int i2, int i3, android.app.Notification notification, int i4) {
        super(i2, i3);
        if (context == null) {
            throw new java.lang.NullPointerException("Context must not be null!");
        }
        if (notification == null) {
            throw new java.lang.NullPointerException("Notification object can not be null!");
        }
        if (remoteViews == null) {
            throw new java.lang.NullPointerException("RemoteViews object can not be null!");
        }
        this.context = context;
        this.viewId = i;
        this.notification = notification;
        this.notificationId = i4;
        this.remoteViews = remoteViews;
    }

    public NotificationTarget(android.content.Context context, android.widget.RemoteViews remoteViews, int i, android.app.Notification notification, int i2) {
        this(context, remoteViews, i, Integer.MIN_VALUE, Integer.MIN_VALUE, notification, i2);
    }

    private void update() {
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) this.context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        int i = this.notificationId;
        android.app.Notification notification = this.notification;
        notificationManager.notify(i, notification);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNotify(notificationManager, i, notification);
    }

    public void onResourceReady(android.graphics.Bitmap bitmap, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super android.graphics.Bitmap> glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object obj, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation glideAnimation) {
        onResourceReady((android.graphics.Bitmap) obj, (com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super android.graphics.Bitmap>) glideAnimation);
    }
}
