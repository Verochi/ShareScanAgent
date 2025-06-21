package com.sensorsdata.analytics.android.sdk.visual.view;

/* loaded from: classes19.dex */
interface IPairingCodeInterface {

    public interface OnPairingCodeChangedListener {
        void onInputCompleted(java.lang.CharSequence charSequence);

        void onPairingCodeChanged(java.lang.CharSequence charSequence, int i, int i2, int i3);
    }

    void setBottomLineHeight(int i);

    void setBottomNormalColor(int i);

    void setBottomSelectedColor(int i);

    void setFigures(int i);

    void setOnPairingCodeChangedListener(com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface.OnPairingCodeChangedListener onPairingCodeChangedListener);

    void setPairingCodeMargin(int i);

    void setSelectedBackgroundColor(int i);
}
