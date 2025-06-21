package com.bytedance.sdk.openadsdk.downloadnew.core;

/* loaded from: classes31.dex */
public class DialogBuilder {
    public com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener dialogStatusChangedListener;
    public android.graphics.drawable.Drawable icon;
    public java.lang.String message;
    public java.lang.String negativeBtnText;
    public java.lang.String positiveBtnText;
    public java.lang.String title;

    public static com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder builder() {
        return new com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder();
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder setDialogStatusChangedListener(com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener iDialogStatusChangedListener) {
        this.dialogStatusChangedListener = iDialogStatusChangedListener;
        return this;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder setIcon(android.graphics.drawable.Drawable drawable) {
        this.icon = drawable;
        return this;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder setMessage(java.lang.String str) {
        this.message = str;
        return this;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder setNegativeBtnText(java.lang.String str) {
        this.negativeBtnText = str;
        return this;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder setPositiveBtnText(java.lang.String str) {
        this.positiveBtnText = str;
        return this;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder setTitle(java.lang.String str) {
        this.title = str;
        return this;
    }
}
