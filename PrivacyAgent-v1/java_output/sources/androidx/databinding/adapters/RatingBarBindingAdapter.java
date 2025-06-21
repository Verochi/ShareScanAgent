package androidx.databinding.adapters;

@androidx.databinding.InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute = "android:rating", type = android.widget.RatingBar.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class RatingBarBindingAdapter {

    /* renamed from: androidx.databinding.adapters.RatingBarBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.RatingBar.OnRatingBarChangeListener {
        final /* synthetic */ android.widget.RatingBar.OnRatingBarChangeListener val$listener;
        final /* synthetic */ androidx.databinding.InverseBindingListener val$ratingChange;

        public AnonymousClass1(android.widget.RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
            this.val$listener = onRatingBarChangeListener;
            this.val$ratingChange = inverseBindingListener;
        }

        @Override // android.widget.RatingBar.OnRatingBarChangeListener
        public void onRatingChanged(android.widget.RatingBar ratingBar, float f, boolean z) {
            android.widget.RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = this.val$listener;
            if (onRatingBarChangeListener != null) {
                onRatingBarChangeListener.onRatingChanged(ratingBar, f, z);
            }
            this.val$ratingChange.onChange();
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onRatingChanged", "android:ratingAttrChanged"})
    public static void setListeners(android.widget.RatingBar ratingBar, android.widget.RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            ratingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);
        } else {
            ratingBar.setOnRatingBarChangeListener(new androidx.databinding.adapters.RatingBarBindingAdapter.AnonymousClass1(onRatingBarChangeListener, inverseBindingListener));
        }
    }

    @androidx.databinding.BindingAdapter({"android:rating"})
    public static void setRating(android.widget.RatingBar ratingBar, float f) {
        if (ratingBar.getRating() != f) {
            ratingBar.setRating(f);
        }
    }
}
