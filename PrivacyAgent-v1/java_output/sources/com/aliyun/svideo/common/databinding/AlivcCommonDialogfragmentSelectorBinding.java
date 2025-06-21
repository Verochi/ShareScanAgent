package com.aliyun.svideo.common.databinding;

/* loaded from: classes.dex */
public final class AlivcCommonDialogfragmentSelectorBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView alivcCommonDialogRecyclerview;

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcTvCancel;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcCommonDialogfragmentSelectorBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.alivcCommonDialogRecyclerview = recyclerView;
        this.alivcTvCancel = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogfragmentSelectorBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.common.R.id.alivc_common_dialog_recyclerview;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = com.aliyun.svideo.common.R.id.alivc_tv_cancel;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new com.aliyun.svideo.common.databinding.AlivcCommonDialogfragmentSelectorBinding((android.widget.LinearLayout) view, recyclerView, textView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogfragmentSelectorBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogfragmentSelectorBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.common.R.layout.alivc_common_dialogfragment_selector, viewGroup, false);
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
