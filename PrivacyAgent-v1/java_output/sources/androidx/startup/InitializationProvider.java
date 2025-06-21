package androidx.startup;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class InitializationProvider extends android.content.ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        throw new java.lang.IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public java.lang.String getType(@androidx.annotation.NonNull android.net.Uri uri) {
        throw new java.lang.IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.net.Uri insert(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues) {
        throw new java.lang.IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        android.content.Context context = getContext();
        if (context == null) {
            throw new androidx.startup.StartupException("Context cannot be null");
        }
        androidx.startup.AppInitializer.getInstance(context).discoverAndInitialize();
        return true;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable java.lang.String str2) {
        throw new java.lang.IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public int update(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        throw new java.lang.IllegalStateException("Not allowed.");
    }
}
