package com.bumptech.glide.request.target;

/* loaded from: classes.dex */
public class AppWidgetTarget extends com.bumptech.glide.request.target.CustomTarget<android.graphics.Bitmap> {
    private final android.content.ComponentName componentName;
    private final android.content.Context context;
    private final android.widget.RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    public AppWidgetTarget(android.content.Context context, int i, int i2, int i3, android.widget.RemoteViews remoteViews, android.content.ComponentName componentName) {
        super(i, i2);
        this.context = (android.content.Context) com.bumptech.glide.util.Preconditions.checkNotNull(context, "Context can not be null!");
        this.remoteViews = (android.widget.RemoteViews) com.bumptech.glide.util.Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.componentName = (android.content.ComponentName) com.bumptech.glide.util.Preconditions.checkNotNull(componentName, "ComponentName can not be null!");
        this.viewId = i3;
        this.widgetIds = null;
    }

    public AppWidgetTarget(android.content.Context context, int i, int i2, int i3, android.widget.RemoteViews remoteViews, int... iArr) {
        super(i, i2);
        if (iArr.length == 0) {
            throw new java.lang.IllegalArgumentException("WidgetIds must have length > 0");
        }
        this.context = (android.content.Context) com.bumptech.glide.util.Preconditions.checkNotNull(context, "Context can not be null!");
        this.remoteViews = (android.widget.RemoteViews) com.bumptech.glide.util.Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.widgetIds = (int[]) com.bumptech.glide.util.Preconditions.checkNotNull(iArr, "WidgetIds can not be null!");
        this.viewId = i3;
        this.componentName = null;
    }

    public AppWidgetTarget(android.content.Context context, int i, android.widget.RemoteViews remoteViews, android.content.ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, componentName);
    }

    public AppWidgetTarget(android.content.Context context, int i, android.widget.RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, iArr);
    }

    private void setBitmap(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
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

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        setBitmap(null);
    }

    public void onResourceReady(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap> transition) {
        setBitmap(bitmap);
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition transition) {
        onResourceReady((android.graphics.Bitmap) obj, (com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap>) transition);
    }
}
