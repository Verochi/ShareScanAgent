package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIPasterController {
    long getDuration();

    long getDuration(java.util.concurrent.TimeUnit timeUnit);

    android.graphics.PointF getPosition();

    float getRotate();

    android.graphics.RectF getSize();

    long getStartTime();

    long getStartTime(java.util.concurrent.TimeUnit timeUnit);

    int getType();

    void setDuration(long j);

    void setDuration(long j, java.util.concurrent.TimeUnit timeUnit);

    void setPosition(android.graphics.PointF pointF);

    void setRotate(float f);

    void setStartTime(long j);

    void setStartTime(long j, java.util.concurrent.TimeUnit timeUnit);
}
