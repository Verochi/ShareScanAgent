package com.aliyun.svideo.music.databinding;

/* loaded from: classes12.dex */
public final class AlivcMusicViewChooserMusicBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcMusicCopyright;

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunBackBtn;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunCompeletBtn;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunLocalMusic;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView aliyunMusicList;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunOnlineMusic;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcMusicViewChooserMusicBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.rootView = linearLayout;
        this.alivcMusicCopyright = textView;
        this.aliyunBackBtn = imageView;
        this.aliyunCompeletBtn = textView2;
        this.aliyunLocalMusic = textView3;
        this.aliyunMusicList = recyclerView;
        this.aliyunOnlineMusic = textView4;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.music.databinding.AlivcMusicViewChooserMusicBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.music.R.id.alivc_music_copyright;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = com.aliyun.svideo.music.R.id.aliyun_back_btn;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.music.R.id.aliyun_compelet_btn;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = com.aliyun.svideo.music.R.id.aliyun_local_music;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = com.aliyun.svideo.music.R.id.aliyun_music_list;
                        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = com.aliyun.svideo.music.R.id.aliyun_online_music;
                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new com.aliyun.svideo.music.databinding.AlivcMusicViewChooserMusicBinding((android.widget.LinearLayout) view, textView, imageView, textView2, textView3, recyclerView, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.music.databinding.AlivcMusicViewChooserMusicBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.music.databinding.AlivcMusicViewChooserMusicBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.music.R.layout.alivc_music_view_chooser_music, viewGroup, false);
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
