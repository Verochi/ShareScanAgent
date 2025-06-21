package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityCommentBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout activityRoot;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout buttomLayout;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar commentTitle;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout emotionComment;

    @androidx.annotation.NonNull
    public final android.widget.ImageView emotionFace;

    @androidx.annotation.NonNull
    public final android.widget.EditText etMallCommentContent;

    @androidx.annotation.NonNull
    public final android.widget.EditText etMallCommentTitle;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.me.comment.ShopPhotoGridView gbShopCommentPhotos;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMallCommentScore1;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMallCommentScore2;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMallCommentScore3;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMallCommentScore4;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMallCommentScore5;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlAddEmotion;

    public ActivityCommentBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.EditText editText2, @androidx.annotation.NonNull com.moji.mjweather.me.comment.ShopPhotoGridView shopPhotoGridView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.ImageView imageView4, @androidx.annotation.NonNull android.widget.ImageView imageView5, @androidx.annotation.NonNull android.widget.ImageView imageView6, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2) {
        this.n = linearLayout;
        this.activityRoot = relativeLayout;
        this.buttomLayout = linearLayout2;
        this.commentTitle = mJTitleBar;
        this.emotionComment = linearLayout3;
        this.emotionFace = imageView;
        this.etMallCommentContent = editText;
        this.etMallCommentTitle = editText2;
        this.gbShopCommentPhotos = shopPhotoGridView;
        this.ivMallCommentScore1 = imageView2;
        this.ivMallCommentScore2 = imageView3;
        this.ivMallCommentScore3 = imageView4;
        this.ivMallCommentScore4 = imageView5;
        this.ivMallCommentScore5 = imageView6;
        this.rlAddEmotion = relativeLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityCommentBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        com.moji.mjweather.me.comment.ShopPhotoGridView findChildViewById2;
        int i = moji.com.mjweather.R.id.activityRoot;
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = moji.com.mjweather.R.id.buttomLayout;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.comment_title))) != null) {
                i = moji.com.mjweather.R.id.emotion_comment;
                android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = moji.com.mjweather.R.id.emotion_face;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = moji.com.mjweather.R.id.et_mall_comment_content;
                        android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (editText != null) {
                            i = moji.com.mjweather.R.id.et_mall_comment_title;
                            android.widget.EditText editText2 = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (editText2 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.gb_shop_comment_photos))) != null) {
                                i = moji.com.mjweather.R.id.iv_mall_comment_score1;
                                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = moji.com.mjweather.R.id.iv_mall_comment_score2;
                                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = moji.com.mjweather.R.id.iv_mall_comment_score3;
                                        android.widget.ImageView imageView4 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = moji.com.mjweather.R.id.iv_mall_comment_score4;
                                            android.widget.ImageView imageView5 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (imageView5 != null) {
                                                i = moji.com.mjweather.R.id.iv_mall_comment_score5;
                                                android.widget.ImageView imageView6 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (imageView6 != null) {
                                                    i = moji.com.mjweather.R.id.rl_add_emotion;
                                                    android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout2 != null) {
                                                        return new moji.com.mjweather.databinding.ActivityCommentBinding((android.widget.LinearLayout) view, relativeLayout, linearLayout, findChildViewById, linearLayout2, imageView, editText, editText2, findChildViewById2, imageView2, imageView3, imageView4, imageView5, imageView6, relativeLayout2);
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
    public static moji.com.mjweather.databinding.ActivityCommentBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityCommentBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_comment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.n;
    }
}
