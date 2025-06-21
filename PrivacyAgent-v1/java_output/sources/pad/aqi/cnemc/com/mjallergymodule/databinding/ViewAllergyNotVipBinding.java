package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class ViewAllergyNotVipBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivBtn;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FaceImageView ivFace;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llIntroduce;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDesc;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvNick;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout userInfoLayout;

    public ViewAllergyNotVipBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.imageview.FaceImageView faceImageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2) {
        this.n = constraintLayout;
        this.ivBtn = imageView;
        this.ivFace = faceImageView;
        this.llIntroduce = linearLayout;
        this.tvDesc = textView;
        this.tvNick = textView2;
        this.userInfoLayout = constraintLayout2;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyNotVipBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.FaceImageView findChildViewById;
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.iv_btn;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = pad.aqi.cnemc.com.mjallergymodule.R.id.iv_face))) != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.ll_introduce;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_desc;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_nick;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.user_info_layout;
                        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            return new pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyNotVipBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, findChildViewById, linearLayout, textView, textView2, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyNotVipBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.ViewAllergyNotVipBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.view_allergy_not_vip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.n;
    }
}
