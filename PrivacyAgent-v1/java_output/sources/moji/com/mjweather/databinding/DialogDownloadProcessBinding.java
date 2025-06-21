package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogDownloadProcessBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView downloadProgressTxt;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    public DialogDownloadProcessBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = frameLayout;
        this.downloadProgressTxt = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogDownloadProcessBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.download_progress_txt;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new moji.com.mjweather.databinding.DialogDownloadProcessBinding((android.widget.FrameLayout) view, textView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogDownloadProcessBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogDownloadProcessBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_download_process, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
