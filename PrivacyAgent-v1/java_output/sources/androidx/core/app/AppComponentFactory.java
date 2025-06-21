package androidx.core.app;

@androidx.annotation.RequiresApi(28)
/* loaded from: classes.dex */
public class AppComponentFactory extends android.app.AppComponentFactory {
    @Override // android.app.AppComponentFactory
    @androidx.annotation.NonNull
    public final android.app.Activity instantiateActivity(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (android.app.Activity) androidx.core.app.CoreComponentFactory.checkCompatWrapper(instantiateActivityCompat(classLoader, str, intent));
    }

    @androidx.annotation.NonNull
    public android.app.Activity instantiateActivityCompat(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        try {
            return (android.app.Activity) java.lang.Class.forName(str, false, classLoader).asSubclass(android.app.Activity.class).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.RuntimeException("Couldn't call constructor", e);
        }
    }

    @Override // android.app.AppComponentFactory
    @androidx.annotation.NonNull
    public final android.app.Application instantiateApplication(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (android.app.Application) androidx.core.app.CoreComponentFactory.checkCompatWrapper(instantiateApplicationCompat(classLoader, str));
    }

    @androidx.annotation.NonNull
    public android.app.Application instantiateApplicationCompat(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        try {
            return (android.app.Application) java.lang.Class.forName(str, false, classLoader).asSubclass(android.app.Application.class).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.RuntimeException("Couldn't call constructor", e);
        }
    }

    @Override // android.app.AppComponentFactory
    @androidx.annotation.NonNull
    public final android.content.ContentProvider instantiateProvider(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (android.content.ContentProvider) androidx.core.app.CoreComponentFactory.checkCompatWrapper(instantiateProviderCompat(classLoader, str));
    }

    @androidx.annotation.NonNull
    public android.content.ContentProvider instantiateProviderCompat(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        try {
            return (android.content.ContentProvider) java.lang.Class.forName(str, false, classLoader).asSubclass(android.content.ContentProvider.class).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.RuntimeException("Couldn't call constructor", e);
        }
    }

    @Override // android.app.AppComponentFactory
    @androidx.annotation.NonNull
    public final android.content.BroadcastReceiver instantiateReceiver(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (android.content.BroadcastReceiver) androidx.core.app.CoreComponentFactory.checkCompatWrapper(instantiateReceiverCompat(classLoader, str, intent));
    }

    @androidx.annotation.NonNull
    public android.content.BroadcastReceiver instantiateReceiverCompat(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        try {
            return (android.content.BroadcastReceiver) java.lang.Class.forName(str, false, classLoader).asSubclass(android.content.BroadcastReceiver.class).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.RuntimeException("Couldn't call constructor", e);
        }
    }

    @Override // android.app.AppComponentFactory
    @androidx.annotation.NonNull
    public final android.app.Service instantiateService(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (android.app.Service) androidx.core.app.CoreComponentFactory.checkCompatWrapper(instantiateServiceCompat(classLoader, str, intent));
    }

    @androidx.annotation.NonNull
    public android.app.Service instantiateServiceCompat(@androidx.annotation.NonNull java.lang.ClassLoader classLoader, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.content.Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        try {
            return (android.app.Service) java.lang.Class.forName(str, false, classLoader).asSubclass(android.app.Service.class).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.RuntimeException("Couldn't call constructor", e);
        }
    }
}
