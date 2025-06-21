package androidx.core.content;

/* loaded from: classes.dex */
public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    @androidx.annotation.NonNull
    public static android.content.Context requireContext(@androidx.annotation.NonNull android.content.ContentProvider contentProvider) {
        android.content.Context context = contentProvider.getContext();
        if (context != null) {
            return context;
        }
        throw new java.lang.IllegalStateException("Cannot find context from the provider.");
    }
}
