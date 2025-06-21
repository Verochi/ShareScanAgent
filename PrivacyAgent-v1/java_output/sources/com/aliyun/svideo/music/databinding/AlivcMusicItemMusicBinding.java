package com.aliyun.svideo.music.databinding;

/* loaded from: classes12.dex */
public final class AlivcMusicItemMusicBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView alivcRecordLocalIv;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunMusicArtist;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunMusicEndTxt;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout aliyunMusicInfoLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunMusicName;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout aliyunMusicNameLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunMusicSelcetBg;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunMusicStartTxt;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.music.widget.MusicHorizontalScrollView aliyunScrollBar;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.music.widget.MusicWaveView aliyunWaveView;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.music.widget.CircleProgressBar downloadProgress;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcMusicItemMusicBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull com.aliyun.svideo.music.widget.MusicHorizontalScrollView musicHorizontalScrollView, @androidx.annotation.NonNull com.aliyun.svideo.music.widget.MusicWaveView musicWaveView, @androidx.annotation.NonNull com.aliyun.svideo.music.widget.CircleProgressBar circleProgressBar) {
        this.rootView = linearLayout;
        this.alivcRecordLocalIv = imageView;
        this.aliyunMusicArtist = textView;
        this.aliyunMusicEndTxt = textView2;
        this.aliyunMusicInfoLayout = linearLayout2;
        this.aliyunMusicName = textView3;
        this.aliyunMusicNameLayout = linearLayout3;
        this.aliyunMusicSelcetBg = imageView2;
        this.aliyunMusicStartTxt = textView4;
        this.aliyunScrollBar = musicHorizontalScrollView;
        this.aliyunWaveView = musicWaveView;
        this.downloadProgress = circleProgressBar;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.music.databinding.AlivcMusicItemMusicBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.music.R.id.alivc_record_local_iv;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.music.R.id.aliyun_music_artist;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = com.aliyun.svideo.music.R.id.aliyun_music_end_txt;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = com.aliyun.svideo.music.R.id.aliyun_music_info_layout;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = com.aliyun.svideo.music.R.id.aliyun_music_name;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = com.aliyun.svideo.music.R.id.aliyun_music_name_layout;
                            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = com.aliyun.svideo.music.R.id.aliyun_music_selcet_bg;
                                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = com.aliyun.svideo.music.R.id.aliyun_music_start_txt;
                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = com.aliyun.svideo.music.R.id.aliyun_scroll_bar;
                                        com.aliyun.svideo.music.widget.MusicHorizontalScrollView musicHorizontalScrollView = (com.aliyun.svideo.music.widget.MusicHorizontalScrollView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (musicHorizontalScrollView != null) {
                                            i = com.aliyun.svideo.music.R.id.aliyun_wave_view;
                                            com.aliyun.svideo.music.widget.MusicWaveView musicWaveView = (com.aliyun.svideo.music.widget.MusicWaveView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (musicWaveView != null) {
                                                i = com.aliyun.svideo.music.R.id.download_progress;
                                                com.aliyun.svideo.music.widget.CircleProgressBar circleProgressBar = (com.aliyun.svideo.music.widget.CircleProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (circleProgressBar != null) {
                                                    return new com.aliyun.svideo.music.databinding.AlivcMusicItemMusicBinding((android.widget.LinearLayout) view, imageView, textView, textView2, linearLayout, textView3, linearLayout2, imageView2, textView4, musicHorizontalScrollView, musicWaveView, circleProgressBar);
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
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.music.databinding.AlivcMusicItemMusicBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.music.databinding.AlivcMusicItemMusicBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.music.R.layout.alivc_music_item_music, viewGroup, false);
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
