package com.aliyun.svideo.common.databinding;

/* loaded from: classes.dex */
public final class AlivcCommonDialogfragmentWheelviewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcTvCancel;

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcTvSure;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.common.widget.WheelView alivcWheelViewDialog;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcCommonDialogfragmentWheelviewBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull com.aliyun.svideo.common.widget.WheelView wheelView) {
        this.rootView = linearLayout;
        this.alivcTvCancel = textView;
        this.alivcTvSure = textView2;
        this.alivcWheelViewDialog = wheelView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogfragmentWheelviewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.common.R.id.alivc_tv_cancel;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = com.aliyun.svideo.common.R.id.alivc_tv_sure;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = com.aliyun.svideo.common.R.id.alivc_wheelView_dialog;
                com.aliyun.svideo.common.widget.WheelView wheelView = (com.aliyun.svideo.common.widget.WheelView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (wheelView != null) {
                    return new com.aliyun.svideo.common.databinding.AlivcCommonDialogfragmentWheelviewBinding((android.widget.LinearLayout) view, textView, textView2, wheelView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogfragmentWheelviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogfragmentWheelviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.common.R.layout.alivc_common_dialogfragment_wheelview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }
}
