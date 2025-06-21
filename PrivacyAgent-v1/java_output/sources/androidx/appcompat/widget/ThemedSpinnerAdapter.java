package androidx.appcompat.widget;

/* loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends android.widget.SpinnerAdapter {

    public static final class Helper {
        private final android.content.Context mContext;
        private android.view.LayoutInflater mDropDownInflater;
        private final android.view.LayoutInflater mInflater;

        public Helper(@androidx.annotation.NonNull android.content.Context context) {
            this.mContext = context;
            this.mInflater = android.view.LayoutInflater.from(context);
        }

        @androidx.annotation.NonNull
        public android.view.LayoutInflater getDropDownViewInflater() {
            android.view.LayoutInflater layoutInflater = this.mDropDownInflater;
            return layoutInflater != null ? layoutInflater : this.mInflater;
        }

        @androidx.annotation.Nullable
        public android.content.res.Resources.Theme getDropDownViewTheme() {
            android.view.LayoutInflater layoutInflater = this.mDropDownInflater;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void setDropDownViewTheme(@androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
            if (theme == null) {
                this.mDropDownInflater = null;
            } else if (theme == this.mContext.getTheme()) {
                this.mDropDownInflater = this.mInflater;
            } else {
                this.mDropDownInflater = android.view.LayoutInflater.from(new androidx.appcompat.view.ContextThemeWrapper(this.mContext, theme));
            }
        }
    }

    @androidx.annotation.Nullable
    android.content.res.Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@androidx.annotation.Nullable android.content.res.Resources.Theme theme);
}
