package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class SettingAboutBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView aboutTextVersion;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar aboutTitlebar;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout agreementLayout;

    @androidx.annotation.NonNull
    public final android.view.View checkVersionLine;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout checkoutVersionLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView copyright;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout debugSwitch;

    @androidx.annotation.NonNull
    public final android.widget.TextView forum;

    @androidx.annotation.NonNull
    public final android.view.View leftDoor;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llContact;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout logoLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mojiLogo;

    @androidx.annotation.NonNull
    public final android.widget.TextView mojiLogoText;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView recordNum;

    @androidx.annotation.NonNull
    public final android.view.View rightDoor;

    @androidx.annotation.NonNull
    public final android.widget.TextView settingAboutContact;

    @androidx.annotation.NonNull
    public final android.widget.TextView settingAboutEmail;

    @androidx.annotation.NonNull
    public final android.widget.TextView settingAboutOpenSource;

    @androidx.annotation.NonNull
    public final android.widget.TextView settingAboutPhone;

    @androidx.annotation.NonNull
    public final android.widget.TextView settingAboutPrivacy;

    @androidx.annotation.NonNull
    public final android.widget.TextView settingAboutService;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout tellFriendLayout;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout userHelpLayout;

    @androidx.annotation.NonNull
    public final android.view.View userHelpView;

    @androidx.annotation.NonNull
    public final android.widget.TextView weibo;

    @androidx.annotation.NonNull
    public final android.view.View yearFlashLine;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout yearFlashScreenLayout;

    public SettingAboutBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout3, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8, @androidx.annotation.NonNull android.widget.TextView textView9, @androidx.annotation.NonNull android.widget.TextView textView10, @androidx.annotation.NonNull android.widget.TextView textView11, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout4, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout5, @androidx.annotation.NonNull android.view.View view4, @androidx.annotation.NonNull android.widget.TextView textView12, @androidx.annotation.NonNull android.view.View view5, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout6) {
        this.n = relativeLayout;
        this.aboutTextVersion = textView;
        this.aboutTitlebar = mJTitleBar;
        this.agreementLayout = linearLayout;
        this.checkVersionLine = view;
        this.checkoutVersionLayout = relativeLayout2;
        this.copyright = textView2;
        this.debugSwitch = relativeLayout3;
        this.forum = textView3;
        this.leftDoor = view2;
        this.llContact = linearLayout2;
        this.logoLayout = linearLayout3;
        this.mojiLogo = imageView;
        this.mojiLogoText = textView4;
        this.recordNum = textView5;
        this.rightDoor = view3;
        this.settingAboutContact = textView6;
        this.settingAboutEmail = textView7;
        this.settingAboutOpenSource = textView8;
        this.settingAboutPhone = textView9;
        this.settingAboutPrivacy = textView10;
        this.settingAboutService = textView11;
        this.tellFriendLayout = relativeLayout4;
        this.userHelpLayout = relativeLayout5;
        this.userHelpView = view4;
        this.weibo = textView12;
        this.yearFlashLine = view5;
        this.yearFlashScreenLayout = relativeLayout6;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.SettingAboutBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        android.view.View findChildViewById2;
        android.view.View findChildViewById3;
        android.view.View findChildViewById4;
        android.view.View findChildViewById5;
        android.view.View findChildViewById6;
        int i = moji.com.mjweather.R.id.about_text_version;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.about_titlebar))) != null) {
            i = moji.com.mjweather.R.id.agreement_layout;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.check_version_line))) != null) {
                i = moji.com.mjweather.R.id.checkout_version_layout;
                android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = moji.com.mjweather.R.id.copyright;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = moji.com.mjweather.R.id.debug_switch;
                        android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            i = moji.com.mjweather.R.id.forum;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.left_door))) != null) {
                                i = moji.com.mjweather.R.id.ll_contact;
                                android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = moji.com.mjweather.R.id.logo_layout;
                                    android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (linearLayout3 != null) {
                                        i = moji.com.mjweather.R.id.moji_logo;
                                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = moji.com.mjweather.R.id.moji_logo_Text;
                                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = moji.com.mjweather.R.id.record_num;
                                                android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.right_door))) != null) {
                                                    i = moji.com.mjweather.R.id.setting_about_contact;
                                                    android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = moji.com.mjweather.R.id.setting_about_email;
                                                        android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = moji.com.mjweather.R.id.setting_about_open_source;
                                                            android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = moji.com.mjweather.R.id.setting_about_phone;
                                                                android.widget.TextView textView9 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                if (textView9 != null) {
                                                                    i = moji.com.mjweather.R.id.setting_about_privacy;
                                                                    android.widget.TextView textView10 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                    if (textView10 != null) {
                                                                        i = moji.com.mjweather.R.id.setting_about_service;
                                                                        android.widget.TextView textView11 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                        if (textView11 != null) {
                                                                            i = moji.com.mjweather.R.id.tell_friend_layout;
                                                                            android.widget.RelativeLayout relativeLayout3 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                            if (relativeLayout3 != null) {
                                                                                i = moji.com.mjweather.R.id.user_help_layout;
                                                                                android.widget.RelativeLayout relativeLayout4 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                                if (relativeLayout4 != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.user_help_view))) != null) {
                                                                                    i = moji.com.mjweather.R.id.weibo;
                                                                                    android.widget.TextView textView12 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                                    if (textView12 != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.year_flash_line))) != null) {
                                                                                        i = moji.com.mjweather.R.id.year_flash_screen_layout;
                                                                                        android.widget.RelativeLayout relativeLayout5 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                                        if (relativeLayout5 != null) {
                                                                                            return new moji.com.mjweather.databinding.SettingAboutBinding((android.widget.RelativeLayout) view, textView, findChildViewById, linearLayout, findChildViewById2, relativeLayout, textView2, relativeLayout2, textView3, findChildViewById3, linearLayout2, linearLayout3, imageView, textView4, textView5, findChildViewById4, textView6, textView7, textView8, textView9, textView10, textView11, relativeLayout3, relativeLayout4, findChildViewById5, textView12, findChildViewById6, relativeLayout5);
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
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.SettingAboutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.SettingAboutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.setting_about, viewGroup, false);
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
