package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class ActivityRollCaptionSubtitleBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunBackIv;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivCommit;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivEditColor;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView rollCaptionColorView;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rollCaptionRecyclerview;

    @androidx.annotation.NonNull
    private final android.widget.RelativeLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout title;

    private ActivityRollCaptionSubtitleBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView rollCaptionColorView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.aliyunBackIv = imageView;
        this.ivCommit = imageView2;
        this.ivEditColor = imageView3;
        this.rollCaptionColorView = rollCaptionColorView;
        this.rollCaptionRecyclerview = recyclerView;
        this.title = relativeLayout2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.ActivityRollCaptionSubtitleBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.aliyun_back_iv;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.editor.R.id.iv_commit;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = com.aliyun.svideo.editor.R.id.iv_edit_color;
                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = com.aliyun.svideo.editor.R.id.roll_caption_color_view;
                    com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView rollCaptionColorView = (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (rollCaptionColorView != null) {
                        i = com.aliyun.svideo.editor.R.id.roll_caption_recyclerview;
                        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = com.aliyun.svideo.editor.R.id.title;
                            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                return new com.aliyun.svideo.editor.databinding.ActivityRollCaptionSubtitleBinding((android.widget.RelativeLayout) view, imageView, imageView2, imageView3, rollCaptionColorView, recyclerView, relativeLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.ActivityRollCaptionSubtitleBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.ActivityRollCaptionSubtitleBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.activity_roll_caption_subtitle, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.rootView;
    }
}
