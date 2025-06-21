package com.aliyun.svideo.common.databinding;

/* loaded from: classes.dex */
public final class AlivcCommonDialogRvSelectorItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcTvName;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcCommonDialogRvSelectorItemBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.alivcTvName = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogRvSelectorItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.common.R.id.alivc_tv_name;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new com.aliyun.svideo.common.databinding.AlivcCommonDialogRvSelectorItemBinding((android.widget.LinearLayout) view, textView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogRvSelectorItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogRvSelectorItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.common.R.layout.alivc_common_dialog_rv_selector_item, viewGroup, false);
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
