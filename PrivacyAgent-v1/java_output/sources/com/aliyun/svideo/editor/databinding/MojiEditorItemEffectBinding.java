package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class MojiEditorItemEffectBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.cardview.widget.CardView cardView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivSelectLayerMask;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivSelectState;

    @androidx.annotation.NonNull
    public final android.view.View line;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llBackView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llResourceView;

    @androidx.annotation.NonNull
    public final android.widget.TextView resourceBackName;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout resourceImage;

    @androidx.annotation.NonNull
    public final android.widget.ImageView resourceImageBackView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView resourceImageView;

    @androidx.annotation.NonNull
    public final android.widget.TextView resourceName;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private MojiEditorItemEffectBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.cardview.widget.CardView cardView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.ImageView imageView4, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.rootView = linearLayout;
        this.cardView = cardView;
        this.ivSelectLayerMask = imageView;
        this.ivSelectState = imageView2;
        this.line = view;
        this.llBackView = linearLayout2;
        this.llResourceView = linearLayout3;
        this.resourceBackName = textView;
        this.resourceImage = frameLayout;
        this.resourceImageBackView = imageView3;
        this.resourceImageView = imageView4;
        this.resourceName = textView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.MojiEditorItemEffectBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = com.aliyun.svideo.editor.R.id.card_view;
        androidx.cardview.widget.CardView cardView = (androidx.cardview.widget.CardView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = com.aliyun.svideo.editor.R.id.iv_select_layer_mask;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.editor.R.id.iv_select_state;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.aliyun.svideo.editor.R.id.line))) != null) {
                    i = com.aliyun.svideo.editor.R.id.ll_back_view;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = com.aliyun.svideo.editor.R.id.ll_resource_view;
                        android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = com.aliyun.svideo.editor.R.id.resource_back_name;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = com.aliyun.svideo.editor.R.id.resource_image;
                                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (frameLayout != null) {
                                    i = com.aliyun.svideo.editor.R.id.resource_image_back_view;
                                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = com.aliyun.svideo.editor.R.id.resource_image_view;
                                        android.widget.ImageView imageView4 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = com.aliyun.svideo.editor.R.id.resource_name;
                                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                return new com.aliyun.svideo.editor.databinding.MojiEditorItemEffectBinding((android.widget.LinearLayout) view, cardView, imageView, imageView2, findChildViewById, linearLayout, linearLayout2, textView, frameLayout, imageView3, imageView4, textView2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.MojiEditorItemEffectBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.MojiEditorItemEffectBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.moji_editor_item_effect, viewGroup, false);
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
