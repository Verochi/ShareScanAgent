package androidx.media;

/* loaded from: classes.dex */
public final class MediaSessionManager {
    private static volatile androidx.media.MediaSessionManager sSessionManager;
    androidx.media.MediaSessionManager.MediaSessionManagerImpl mImpl;
    static final java.lang.String TAG = "MediaSessionManager";
    static final boolean DEBUG = android.util.Log.isLoggable(TAG, 3);
    private static final java.lang.Object sLock = new java.lang.Object();

    public interface MediaSessionManagerImpl {
        android.content.Context getContext();

        boolean isTrustedForMediaControl(androidx.media.MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl);
    }

    public static final class RemoteUserInfo {
        public static final java.lang.String LEGACY_CONTROLLER = "android.media.session.MediaController";
        androidx.media.MediaSessionManager.RemoteUserInfoImpl mImpl;

        @androidx.annotation.RequiresApi(28)
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.mImpl = new androidx.media.MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
        }

        public RemoteUserInfo(@androidx.annotation.NonNull java.lang.String str, int i, int i2) {
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                this.mImpl = new androidx.media.MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i, i2);
            } else {
                this.mImpl = new androidx.media.MediaSessionManagerImplBase.RemoteUserInfoImplBase(str, i, i2);
            }
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof androidx.media.MediaSessionManager.RemoteUserInfo) {
                return this.mImpl.equals(((androidx.media.MediaSessionManager.RemoteUserInfo) obj).mImpl);
            }
            return false;
        }

        @androidx.annotation.NonNull
        public java.lang.String getPackageName() {
            return this.mImpl.getPackageName();
        }

        public int getPid() {
            return this.mImpl.getPid();
        }

        public int getUid() {
            return this.mImpl.getUid();
        }

        public int hashCode() {
            return this.mImpl.hashCode();
        }
    }

    public interface RemoteUserInfoImpl {
        java.lang.String getPackageName();

        int getPid();

        int getUid();
    }

    private MediaSessionManager(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new androidx.media.MediaSessionManagerImplApi28(context);
        } else {
            this.mImpl = new androidx.media.MediaSessionManagerImplApi21(context);
        }
    }

    @androidx.annotation.NonNull
    public static androidx.media.MediaSessionManager getSessionManager(@androidx.annotation.NonNull android.content.Context context) {
        androidx.media.MediaSessionManager mediaSessionManager = sSessionManager;
        if (mediaSessionManager == null) {
            synchronized (sLock) {
                mediaSessionManager = sSessionManager;
                if (mediaSessionManager == null) {
                    sSessionManager = new androidx.media.MediaSessionManager(context.getApplicationContext());
                    mediaSessionManager = sSessionManager;
                }
            }
        }
        return mediaSessionManager;
    }

    public android.content.Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(@androidx.annotation.NonNull androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.mImpl.isTrustedForMediaControl(remoteUserInfo.mImpl);
        }
        throw new java.lang.IllegalArgumentException("userInfo should not be null");
    }
}
