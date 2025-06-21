package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentWeatherListLayoutBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.Space avatarRightLine;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivEggIcon;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivEggVideo;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.avatar.PageAvatarView pageAvatarView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.FakeSceneImageView pageFakeScene2;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout pageTextureViewContainer;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.WeatherListView recyclerView;

    @androidx.annotation.NonNull
    public final androidx.legacy.widget.Space spaceWeatherBgTop;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.HomeTitleBarLayout titleBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvEggClose;

    public FragmentWeatherListLayoutBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.Space space, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.moji.mjweather.weather.avatar.PageAvatarView pageAvatarView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.FakeSceneImageView fakeSceneImageView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.WeatherListView weatherListView, @androidx.annotation.NonNull androidx.legacy.widget.Space space2, @androidx.annotation.NonNull com.moji.mjweather.weather.view.HomeTitleBarLayout homeTitleBarLayout, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = view;
        this.avatarRightLine = space;
        this.ivEggIcon = imageView;
        this.ivEggVideo = imageView2;
        this.pageAvatarView = pageAvatarView;
        this.pageFakeScene2 = fakeSceneImageView;
        this.pageTextureViewContainer = constraintLayout;
        this.recyclerView = weatherListView;
        this.spaceWeatherBgTop = space2;
        this.titleBar = homeTitleBarLayout;
        this.tvEggClose = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentWeatherListLayoutBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.avatar.PageAvatarView findChildViewById;
        com.moji.mjweather.weather.view.FakeSceneImageView findChildViewById2;
        com.moji.mjweather.weather.view.WeatherListView findChildViewById3;
        com.moji.mjweather.weather.view.HomeTitleBarLayout findChildViewById4;
        int i = moji.com.mjweather.R.id.avatarRightLine;
        android.widget.Space space = (android.widget.Space) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (space != null) {
            i = moji.com.mjweather.R.id.iv_egg_icon;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.iv_egg_video;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.page_avatar_view))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.page_fake_scene_2))) != null) {
                    i = moji.com.mjweather.R.id.page_texture_view_container;
                    androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.recycler_view))) != null) {
                        i = moji.com.mjweather.R.id.space_weather_bg_top;
                        androidx.legacy.widget.Space space2 = (androidx.legacy.widget.Space) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (space2 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_bar))) != null) {
                            i = moji.com.mjweather.R.id.tv_egg_close;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new moji.com.mjweather.databinding.FragmentWeatherListLayoutBinding(view, space, imageView, imageView2, findChildViewById, findChildViewById2, constraintLayout, findChildViewById3, space2, findChildViewById4, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentWeatherListLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_weather_list_layout, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
