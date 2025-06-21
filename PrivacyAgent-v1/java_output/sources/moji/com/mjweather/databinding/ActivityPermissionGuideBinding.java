package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityPermissionGuideBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView guidePermissionBack;

    @androidx.annotation.NonNull
    public final android.widget.TextView guidePermissionTitle;

    @androidx.annotation.NonNull
    public final android.widget.ImageView iconFloatBall;

    @androidx.annotation.NonNull
    public final android.widget.ImageView iconNotificationRemind;

    @androidx.annotation.NonNull
    public final android.widget.ImageView iconNotifySystem;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView imageTitle;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout mDesktopLayout;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.view.View permissionGuideDivide1;

    @androidx.annotation.NonNull
    public final android.view.View permissionGuideDivide2;

    @androidx.annotation.NonNull
    public final android.view.View permissionGuideDivide3;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvOpenFloat;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvOpenNotify;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvOpenPermission;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSubTitleFloat;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSubTitleNotify;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSubTitlePermission;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitleFloat;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitleNotify;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTitlePermission;

    public ActivityPermissionGuideBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.ImageView imageView4, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8, @androidx.annotation.NonNull android.widget.TextView textView9, @androidx.annotation.NonNull android.widget.TextView textView10) {
        this.n = relativeLayout;
        this.guidePermissionBack = imageView;
        this.guidePermissionTitle = textView;
        this.iconFloatBall = imageView2;
        this.iconNotificationRemind = imageView3;
        this.iconNotifySystem = imageView4;
        this.imageTitle = mJImageView;
        this.mDesktopLayout = relativeLayout2;
        this.permissionGuideDivide1 = view;
        this.permissionGuideDivide2 = view2;
        this.permissionGuideDivide3 = view3;
        this.tvOpenFloat = textView2;
        this.tvOpenNotify = textView3;
        this.tvOpenPermission = textView4;
        this.tvSubTitleFloat = textView5;
        this.tvSubTitleNotify = textView6;
        this.tvSubTitlePermission = textView7;
        this.tvTitleFloat = textView8;
        this.tvTitleNotify = textView9;
        this.tvTitlePermission = textView10;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityPermissionGuideBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.MJImageView findChildViewById;
        android.view.View findChildViewById2;
        android.view.View findChildViewById3;
        android.view.View findChildViewById4;
        int i = moji.com.mjweather.R.id.guidePermissionBack;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.guide_permission_title;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweather.R.id.icon_float_ball;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = moji.com.mjweather.R.id.icon_notification_remind;
                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = moji.com.mjweather.R.id.icon_notify_system;
                        android.widget.ImageView imageView4 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.image_title))) != null) {
                            i = moji.com.mjweather.R.id.mDesktopLayout;
                            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.permission_guide_divide1))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.permission_guide_divide2))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.permission_guide_divide3))) != null) {
                                i = moji.com.mjweather.R.id.tvOpenFloat;
                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = moji.com.mjweather.R.id.tvOpenNotify;
                                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = moji.com.mjweather.R.id.tvOpenPermission;
                                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = moji.com.mjweather.R.id.tvSubTitleFloat;
                                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = moji.com.mjweather.R.id.tvSubTitleNotify;
                                                android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = moji.com.mjweather.R.id.tvSubTitlePermission;
                                                    android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = moji.com.mjweather.R.id.tvTitleFloat;
                                                        android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = moji.com.mjweather.R.id.tvTitleNotify;
                                                            android.widget.TextView textView9 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (textView9 != null) {
                                                                i = moji.com.mjweather.R.id.tvTitlePermission;
                                                                android.widget.TextView textView10 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                if (textView10 != null) {
                                                                    return new moji.com.mjweather.databinding.ActivityPermissionGuideBinding((android.widget.RelativeLayout) view, imageView, textView, imageView2, imageView3, imageView4, findChildViewById, relativeLayout, findChildViewById2, findChildViewById3, findChildViewById4, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityPermissionGuideBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityPermissionGuideBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_permission_guide, viewGroup, false);
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
