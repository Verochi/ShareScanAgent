package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class CardDetailTopInformationBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView imageView2;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final android.widget.TextView viewSpotAddress;

    @androidx.annotation.NonNull
    public final android.widget.ImageView viewSpotImg;

    @androidx.annotation.NonNull
    public final android.widget.TextView viewSpotName;

    public CardDetailTopInformationBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = view;
        this.imageView2 = imageView;
        this.viewSpotAddress = textView;
        this.viewSpotImg = imageView2;
        this.viewSpotName = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.CardDetailTopInformationBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweatherservicebase.R.id.imageView2;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweatherservicebase.R.id.view_spot_address;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweatherservicebase.R.id.view_spot_img;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = moji.com.mjweatherservicebase.R.id.view_spot_name;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new moji.com.mjweatherservicebase.databinding.CardDetailTopInformationBinding(view, imageView, textView, imageView2, textView2);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.CardDetailTopInformationBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.card_detail_top_information, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
