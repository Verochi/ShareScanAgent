package androidx.lifecycle;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class ViewModelProviders {

    @java.lang.Deprecated
    public static class DefaultFactory extends androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory {
        @java.lang.Deprecated
        public DefaultFactory(@androidx.annotation.NonNull android.app.Application application) {
            super(application);
        }
    }

    @java.lang.Deprecated
    public ViewModelProviders() {
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    @java.lang.Deprecated
    public static androidx.lifecycle.ViewModelProvider of(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        return new androidx.lifecycle.ViewModelProvider(fragment);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    @java.lang.Deprecated
    public static androidx.lifecycle.ViewModelProvider of(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.Nullable androidx.lifecycle.ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragment.getDefaultViewModelProviderFactory();
        }
        return new androidx.lifecycle.ViewModelProvider(fragment.getViewModelStore(), factory);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    @java.lang.Deprecated
    public static androidx.lifecycle.ViewModelProvider of(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity fragmentActivity) {
        return new androidx.lifecycle.ViewModelProvider(fragmentActivity);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    @java.lang.Deprecated
    public static androidx.lifecycle.ViewModelProvider of(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity fragmentActivity, @androidx.annotation.Nullable androidx.lifecycle.ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragmentActivity.getDefaultViewModelProviderFactory();
        }
        return new androidx.lifecycle.ViewModelProvider(fragmentActivity.getViewModelStore(), factory);
    }
}
