package com.anythink.expressad.video.signal;

/* loaded from: classes12.dex */
public interface j {
    public static final int m_ = 1;
    public static final int n_ = 2;
    public static final int o = 2;
    public static final int o_ = 3;
    public static final int p = 1;
    public static final int p_ = 4;
    public static final int q = 2;
    public static final int q_ = 5;
    public static final int r = 0;
    public static final int r_ = 0;

    /* renamed from: s, reason: collision with root package name */
    public static final int f282s = 1;
    public static final int s_ = 1;
    public static final int t_ = 1;
    public static final int u_ = 2;
    public static final int v_ = 1;
    public static final int w_ = 2;
    public static final int x_ = -1;
    public static final int y_ = 1;

    void alertWebViewShowed();

    void closeVideoOperate(int i, int i2);

    void dismissAllAlert();

    int getBorderViewHeight();

    int getBorderViewLeft();

    int getBorderViewRadius();

    int getBorderViewTop();

    int getBorderViewWidth();

    java.lang.String getCurrentProgress();

    void hideAlertView(int i);

    boolean isH5Canvas();

    void notifyCloseBtn(int i);

    void progressBarOperate(int i);

    void progressOperate(int i, int i2);

    void setCover(boolean z);

    void setInstallDialogState(boolean z);

    void setMiniEndCardState(boolean z);

    void setScaleFitXY(int i);

    void setVisible(int i);

    void showAlertView();

    void showIVRewardAlertView(java.lang.String str);

    void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    void soundOperate(int i, int i2);

    void soundOperate(int i, int i2, java.lang.String str);

    void videoOperate(int i);
}
