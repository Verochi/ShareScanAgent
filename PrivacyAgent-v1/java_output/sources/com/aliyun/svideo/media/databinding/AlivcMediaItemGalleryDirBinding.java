package com.aliyun.svideo.media.databinding;

/* loaded from: classes12.dex */
public final class AlivcMediaItemGalleryDirBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout sortVideoLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView thumbImage;

    @androidx.annotation.NonNull
    public final android.widget.TextView videoDirName;

    @androidx.annotation.NonNull
    public final android.widget.TextView videoFileCount;

    @androidx.annotation.NonNull
    public final android.widget.TextView videoLeftBrachet;

    @androidx.annotation.NonNull
    public final android.widget.TextView videoRightBrachet;

    private AlivcMediaItemGalleryDirBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.rootView = linearLayout;
        this.sortVideoLayout = linearLayout2;
        this.thumbImage = imageView;
        this.videoDirName = textView;
        this.videoFileCount = textView2;
        this.videoLeftBrachet = textView3;
        this.videoRightBrachet = textView4;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemGalleryDirBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.media.R.id.sort_video_layout;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = com.aliyun.svideo.media.R.id.thumb_image;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.media.R.id.video_dir_name;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = com.aliyun.svideo.media.R.id.video_file_count;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = com.aliyun.svideo.media.R.id.video_left_brachet;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = com.aliyun.svideo.media.R.id.video_right_brachet;
                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new com.aliyun.svideo.media.databinding.AlivcMediaItemGalleryDirBinding((android.widget.LinearLayout) view, linearLayout, imageView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemGalleryDirBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemGalleryDirBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.media.R.layout.alivc_media_item_gallery_dir, viewGroup, false);
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
