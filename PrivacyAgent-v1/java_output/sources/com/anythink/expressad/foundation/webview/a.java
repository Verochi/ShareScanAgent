package com.anythink.expressad.foundation.webview;

/* loaded from: classes12.dex */
public interface a {
    public static final int a = 4;
    public static final int b = 5;
    public static final int c = 6;
    public static final int d = 7;
    public static final int e = 8;

    /* renamed from: com.anythink.expressad.foundation.webview.a$a, reason: collision with other inner class name */
    public interface InterfaceC0215a {
        void a();

        void b();
    }

    android.graphics.drawable.Drawable getBackground();

    android.view.ViewGroup.LayoutParams getLayoutParams();

    float getProgress();

    int getVisibility();

    void initResource(boolean z);

    void onThemeChange();

    void setBackgroundColor(int i);

    void setBackgroundDrawable(android.graphics.drawable.Drawable drawable);

    void setLayoutParams(android.view.ViewGroup.LayoutParams layoutParams);

    void setPaused(boolean z);

    void setProgress(float f, boolean z);

    void setProgressBarListener(com.anythink.expressad.foundation.webview.a.InterfaceC0215a interfaceC0215a);

    void setProgressState(int i);

    void setVisibility(int i);

    void setVisible(boolean z);

    void startEndAnimation();
}
