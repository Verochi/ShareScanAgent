package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogAvatarChangeBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.avatar.DialogAvatarView diaAvatarView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivClose;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainVoiceView ivVoice;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLoader;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlAvatar;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlAvatarArea;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlAvatarMain;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rvAvatar;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout window;

    public DialogAvatarChangeBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.avatar.DialogAvatarView dialogAvatarView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainVoiceView mainVoiceView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout3, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout4, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout5) {
        this.n = relativeLayout;
        this.diaAvatarView = dialogAvatarView;
        this.ivClose = imageView;
        this.ivVoice = mainVoiceView;
        this.llLoader = linearLayout;
        this.rlAvatar = relativeLayout2;
        this.rlAvatarArea = relativeLayout3;
        this.rlAvatarMain = relativeLayout4;
        this.rvAvatar = recyclerView;
        this.window = relativeLayout5;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogAvatarChangeBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.view.MainVoiceView findChildViewById;
        int i = moji.com.mjweather.R.id.dia_avatar_view;
        com.moji.mjweather.weather.avatar.DialogAvatarView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = moji.com.mjweather.R.id.iv_close;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_voice))) != null) {
                i = moji.com.mjweather.R.id.ll_loader;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = moji.com.mjweather.R.id.rl_avatar;
                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = moji.com.mjweather.R.id.rl_avatar_area;
                        android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            android.widget.RelativeLayout relativeLayout3 = (android.widget.RelativeLayout) view;
                            i = moji.com.mjweather.R.id.rv_avatar;
                            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = moji.com.mjweather.R.id.window;
                                android.widget.RelativeLayout relativeLayout4 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (relativeLayout4 != null) {
                                    return new moji.com.mjweather.databinding.DialogAvatarChangeBinding(relativeLayout3, findChildViewById2, imageView, findChildViewById, linearLayout, relativeLayout, relativeLayout2, relativeLayout3, recyclerView, relativeLayout4);
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
    public static moji.com.mjweather.databinding.DialogAvatarChangeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogAvatarChangeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_avatar_change, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.n;
    }
}
