package com.alimm.tanx.ui.image.glide.request.target;

/* loaded from: classes.dex */
public class AppWidgetTarget extends com.alimm.tanx.ui.image.glide.request.target.SimpleTarget<android.graphics.Bitmap> {
    private final android.content.ComponentName componentName;
    private final android.content.Context context;
    private final android.widget.RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    public AppWidgetTarget(android.content.Context context, android.widget.RemoteViews remoteViews, int i, int i2, int i3, android.content.ComponentName componentName) {
        super(i2, i3);
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null!");
        }
        if (componentName == null) {
            throw new java.lang.NullPointerException("ComponentName can not be null!");
        }
        if (remoteViews == null) {
            throw new java.lang.NullPointerException("RemoteViews object can not be null!");
        }
        this.context = context;
        this.remoteViews = remoteViews;
        this.viewId = i;
        this.componentName = componentName;
        this.widgetIds = null;
    }

    public AppWidgetTarget(android.content.Context context, android.widget.RemoteViews remoteViews, int i, int i2, int i3, int... iArr) {
        super(i2, i3);
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null!");
        }
        if (iArr == null) {
            throw new java.lang.NullPointerException("WidgetIds can not be null!");
        }
        if (iArr.length == 0) {
            throw new java.lang.IllegalArgumentException("WidgetIds must have length > 0");
        }
        if (remoteViews == null) {
            throw new java.lang.NullPointerException("RemoteViews object can not be null!");
        }
        this.context = context;
        this.remoteViews = remoteViews;
        this.viewId = i;
        this.widgetIds = iArr;
        this.componentName = null;
    }

    public AppWidgetTarget(android.content.Context context, android.widget.RemoteViews remoteViews, int i, android.content.ComponentName componentName) {
        this(context, remoteViews, i, Integer.MIN_VALUE, Integer.MIN_VALUE, componentName);
    }

    public AppWidgetTarget(android.content.Context context, android.widget.RemoteViews remoteViews, int i, int... iArr) {
        this(context, remoteViews, i, Integer.MIN_VALUE, Integer.MIN_VALUE, iArr);
    }

    private void update() {
        android.appwidget.AppWidgetManager appWidgetManager = android.appwidget.AppWidgetManager.getInstance(this.context);
        android.content.ComponentName componentName = this.componentName;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.remoteViews);
        } else {
            appWidgetManager.updateAppWidget(this.widgetIds, this.remoteViews);
        }
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
