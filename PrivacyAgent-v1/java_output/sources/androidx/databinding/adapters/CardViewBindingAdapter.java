package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "cardCornerRadius", method = "setRadius", type = androidx.cardview.widget.CardView.class), @androidx.databinding.BindingMethod(attribute = "cardMaxElevation", method = "setMaxCardElevation", type = androidx.cardview.widget.CardView.class), @androidx.databinding.BindingMethod(attribute = "cardPreventCornerOverlap", method = "setPreventCornerOverlap", type = androidx.cardview.widget.CardView.class), @androidx.databinding.BindingMethod(attribute = "cardUseCompatPadding", method = "setUseCompatPadding", type = androidx.cardview.widget.CardView.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class CardViewBindingAdapter {
    @androidx.databinding.BindingAdapter({"contentPadding"})
    public static void setContentPadding(androidx.cardview.widget.CardView cardView, int i) {
        cardView.setContentPadding(i, i, i, i);
    }

    @androidx.databinding.BindingAdapter({"contentPaddingBottom"})
    public static void setContentPaddingBottom(androidx.cardview.widget.CardView cardView, int i) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), cardView.getContentPaddingTop(), cardView.getContentPaddingRight(), i);
    }

    @androidx.databinding.BindingAdapter({"contentPaddingLeft"})
    public static void setContentPaddingLeft(androidx.cardview.widget.CardView cardView, int i) {
        cardView.setContentPadding(i, cardView.getContentPaddingTop(), cardView.getContentPaddingRight(), cardView.getContentPaddingBottom());
    }

    @androidx.databinding.BindingAdapter({"contentPaddingRight"})
    public static void setContentPaddingRight(androidx.cardview.widget.CardView cardView, int i) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), cardView.getContentPaddingTop(), i, cardView.getContentPaddingBottom());
    }

    @androidx.databinding.BindingAdapter({"contentPaddingTop"})
    public static void setContentPaddingTop(androidx.cardview.widget.CardView cardView, int i) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), i, cardView.getContentPaddingRight(), cardView.getContentPaddingBottom());
    }
}
