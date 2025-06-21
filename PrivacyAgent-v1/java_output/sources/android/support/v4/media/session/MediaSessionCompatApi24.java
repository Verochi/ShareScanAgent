package android.support.v4.media.session;

@androidx.annotation.RequiresApi(24)
/* loaded from: classes.dex */
class MediaSessionCompatApi24 {
    private static final java.lang.String TAG = "MediaSessionCompatApi24";

    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(java.lang.String str, android.os.Bundle bundle);

        void onPrepareFromSearch(java.lang.String str, android.os.Bundle bundle);

        void onPrepareFromUri(android.net.Uri uri, android.os.Bundle bundle);
    }

    public static class CallbackProxy<T extends android.support.v4.media.session.MediaSessionCompatApi24.Callback> extends android.support.v4.media.session.MediaSessionCompatApi23.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((android.support.v4.media.session.MediaSessionCompatApi24.Callback) this.mCallback).onPrepare();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            ((android.support.v4.media.session.MediaSessionCompatApi24.Callback) this.mCallback).onPrepareFromMediaId(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(java.lang.String str, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            ((android.support.v4.media.session.MediaSessionCompatApi24.Callback) this.mCallback).onPrepareFromSearch(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(android.net.Uri uri, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            ((android.support.v4.media.session.MediaSessionCompatApi24.Callback) this.mCallback).onPrepareFromUri(uri, bundle);
        }
    }

    private MediaSessionCompatApi24() {
    }

    public static java.lang.Object createCallback(android.support.v4.media.session.MediaSessionCompatApi24.Callback callback) {
        return new android.support.v4.media.session.MediaSessionCompatApi24.CallbackProxy(callback);
    }

    public static java.lang.String getCallingPackage(java.lang.Object obj) {
        android.media.session.MediaSession mediaSession = (android.media.session.MediaSession) obj;
        try {
            return (java.lang.String) mediaSession.getClass().getMethod("getCallingPackage", new java.lang.Class[0]).invoke(mediaSession, new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }
}
