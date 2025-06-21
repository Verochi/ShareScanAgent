package com.aliyun.svideo.common.databinding;

/* loaded from: classes.dex */
public final class AlivcCommonDialogTipBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout contentWrap;

    @androidx.annotation.NonNull
    private final android.view.View rootView;

    private AlivcCommonDialogTipBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout) {
        this.rootView = view;
        this.contentWrap = linearLayout;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogTipBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.common.R.id.contentWrap;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            return new com.aliyun.svideo.common.databinding.AlivcCommonDialogTipBinding(view, linearLayout);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogTipBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(com.aliyun.svideo.common.R.layout.alivc_common_dialog_tip, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.rootView;
    }
}
