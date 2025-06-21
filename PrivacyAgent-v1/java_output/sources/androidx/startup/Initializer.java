package androidx.startup;

/* loaded from: classes.dex */
public interface Initializer<T> {
    @androidx.annotation.NonNull
    T create(@androidx.annotation.NonNull android.content.Context context);

    @androidx.annotation.NonNull
    java.util.List<java.lang.Class<? extends androidx.startup.Initializer<?>>> dependencies();
}
