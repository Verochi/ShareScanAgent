package androidx.core.app;

@androidx.annotation.RequiresApi(api = 28)
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class CoreComponentFactory extends android.app.AppComponentFactory {

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface CompatWrapped {
        java.lang.Object getWrapper();
    }

    public static <T> T checkCompatWrapper(T t) {
        T t2;
        return (!(t instanceof androidx.core.app.CoreComponentFactory.CompatWrapped) || (t2 = (T) ((androidx.core.app.CoreComponentFactory.CompatWrapped) t).getWrapper()) == null) ? t : t2;
    }

    @Override // android.app.AppComponentFactory
    @androidx.annotation.NonNull
    public android.app.Activity instantiateActivity(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (android.app.Activity) checkCompatWrapper(super.instantiateActivity(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    @androidx.annotation.NonNull
    public android.app.Application instantiateApplication(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (android.app.Application) checkCompatWrapper(super.instantiateApplication(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    @androidx.annotation.NonNull
    public android.content.ContentProvider instantiateProvider(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (android.content.ContentProvider) checkCompatWrapper(super.instantiateProvider(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    @androidx.annotation.NonNull
    public android.content.BroadcastReceiver instantiateReceiver(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (android.content.BroadcastReceiver) checkCompatWrapper(super.instantiateReceiver(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    @androidx.annotation.NonNull
    public android.app.Service instantiateService(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (android.app.Service) checkCompatWrapper(super.instantiateService(classLoader, str, intent));
    }
}
