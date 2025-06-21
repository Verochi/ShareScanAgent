package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityFeedBackBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.Button btnFeedBackSend;

    @androidx.annotation.NonNull
    public final android.widget.EditText etFeedBackInput;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar feedBackTitleBar;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivFunctionMenu;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivSuggestBannerClose;

    @androidx.annotation.NonNull
    public final com.moji.LabelLayout labelLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutFeedbackFAQ;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutFeedbackIMG;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutFeedbackLog;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout layoutFunctionMenu;

    @androidx.annotation.NonNull
    public final android.widget.ListView lvFeedBackMsg;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout mainContent;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlFeedBackBottom;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlFeedBackReportErrorWeather;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlFeedbackBottom;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout statusLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvChangeUser;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvSuggestReportWrongWeather;

    public ActivityFeedBackBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.Button button, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.moji.LabelLayout labelLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.ListView listView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout3, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout4, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout5, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout6, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = relativeLayout;
        this.btnFeedBackSend = button;
        this.etFeedBackInput = editText;
        this.feedBackTitleBar = mJTitleBar;
        this.ivFunctionMenu = imageView;
        this.ivSuggestBannerClose = imageView2;
        this.labelLayout = labelLayout;
        this.layoutFeedbackFAQ = linearLayout;
        this.layoutFeedbackIMG = linearLayout2;
        this.layoutFeedbackLog = linearLayout3;
        this.layoutFunctionMenu = relativeLayout2;
        this.lvFeedBackMsg = listView;
        this.mainContent = relativeLayout3;
        this.rlFeedBackBottom = relativeLayout4;
        this.rlFeedBackReportErrorWeather = relativeLayout5;
        this.rlFeedbackBottom = relativeLayout6;
        this.statusLayout = mJMultipleStatusLayout;
        this.tvChangeUser = textView;
        this.tvSuggestReportWrongWeather = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityFeedBackBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        com.moji.LabelLayout findChildViewById2;
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById3;
        int i = moji.com.mjweather.R.id.btn_feed_back_send;
        android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = moji.com.mjweather.R.id.et_feed_back_input;
            android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (editText != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.feed_back_title_bar))) != null) {
                i = moji.com.mjweather.R.id.ivFunctionMenu;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = moji.com.mjweather.R.id.iv_suggest_banner_close;
                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.labelLayout))) != null) {
                        i = moji.com.mjweather.R.id.layoutFeedbackFAQ;
                        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = moji.com.mjweather.R.id.layoutFeedbackIMG;
                            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = moji.com.mjweather.R.id.layoutFeedbackLog;
                                android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    i = moji.com.mjweather.R.id.layoutFunctionMenu;
                                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = moji.com.mjweather.R.id.lv_feed_back_msg;
                                        android.widget.ListView listView = (android.widget.ListView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (listView != null) {
                                            android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) view;
                                            i = moji.com.mjweather.R.id.rl_feed_back_bottom;
                                            android.widget.RelativeLayout relativeLayout3 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout3 != null) {
                                                i = moji.com.mjweather.R.id.rl_feed_back_report_error_weather;
                                                android.widget.RelativeLayout relativeLayout4 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout4 != null) {
                                                    i = moji.com.mjweather.R.id.rlFeedbackBottom;
                                                    android.widget.RelativeLayout relativeLayout5 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout5 != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.status_layout))) != null) {
                                                        i = moji.com.mjweather.R.id.tv_change_user;
                                                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            i = moji.com.mjweather.R.id.tv_suggest_report_wrong_weather;
                                                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                return new moji.com.mjweather.databinding.ActivityFeedBackBinding(relativeLayout2, button, editText, findChildViewById, imageView, imageView2, findChildViewById2, linearLayout, linearLayout2, linearLayout3, relativeLayout, listView, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, findChildViewById3, textView, textView2);
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
    public static moji.com.mjweather.databinding.ActivityFeedBackBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityFeedBackBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_feed_back, viewGroup, false);
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
