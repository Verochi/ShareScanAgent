package com.jd.ad.sdk.mdt.service;

/* loaded from: classes23.dex */
public interface JADTouchService {
    int onUserCancelJdJump(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str);

    int onViewClicked(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.String str);

    void onViewTouch(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.MotionEvent motionEvent, @androidx.annotation.NonNull java.lang.String str);

    void registerTouchView(@androidx.annotation.NonNull java.lang.String str);

    void unregisterTouchView(@androidx.annotation.NonNull java.lang.String str);
}
