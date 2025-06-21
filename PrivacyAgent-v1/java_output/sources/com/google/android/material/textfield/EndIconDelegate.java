package com.google.android.material.textfield;

/* loaded from: classes22.dex */
abstract class EndIconDelegate {
    android.content.Context context;
    com.google.android.material.internal.CheckableImageButton endIconView;
    com.google.android.material.textfield.TextInputLayout textInputLayout;

    public EndIconDelegate(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout) {
        this.textInputLayout = textInputLayout;
        this.context = textInputLayout.getContext();
        this.endIconView = textInputLayout.getEndIconView();
    }

    public abstract void initialize();

    public boolean isBoxBackgroundModeSupported(int i) {
        return true;
    }

    public void onSuffixVisibilityChanged(boolean z) {
    }

    public boolean shouldTintIconOnError() {
        return false;
    }
}
