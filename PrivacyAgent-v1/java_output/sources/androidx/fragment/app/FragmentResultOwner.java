package androidx.fragment.app;

/* loaded from: classes.dex */
public interface FragmentResultOwner {
    void clearFragmentResult(@androidx.annotation.NonNull java.lang.String str);

    void clearFragmentResultListener(@androidx.annotation.NonNull java.lang.String str);

    void setFragmentResult(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.os.Bundle bundle);

    void setFragmentResultListener(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.fragment.app.FragmentResultListener fragmentResultListener);
}
