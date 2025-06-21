package com.google.android.gms.dynamic;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public abstract class RemoteCreator<T> {
    public final java.lang.String a;
    public T b;

    @com.google.android.gms.common.annotation.KeepForSdk
    public static class RemoteCreatorException extends java.lang.Exception {
        public RemoteCreatorException(@androidx.annotation.RecentlyNonNull java.lang.String str) {
            super(str);
        }

        public RemoteCreatorException(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
            super(str, th);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public RemoteCreator(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        this.a = str;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public abstract T getRemoteCreator(@androidx.annotation.RecentlyNonNull android.os.IBinder iBinder);

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final T getRemoteCreatorInstance(@androidx.annotation.RecentlyNonNull android.content.Context context) throws com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException {
        if (this.b == null) {
            com.google.android.gms.common.internal.Preconditions.checkNotNull(context);
            android.content.Context remoteContext = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                throw new com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.b = getRemoteCreator((android.os.IBinder) remoteContext.getClassLoader().loadClass(this.a).newInstance());
            } catch (java.lang.ClassNotFoundException e) {
                throw new com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException("Could not load creator class.", e);
            } catch (java.lang.IllegalAccessException e2) {
                throw new com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException("Could not access creator.", e2);
            } catch (java.lang.InstantiationException e3) {
                throw new com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException("Could not instantiate creator.", e3);
            }
        }
        return this.b;
    }
}
