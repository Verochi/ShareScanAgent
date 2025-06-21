package android.support.v4.media.session;

@androidx.annotation.RequiresApi(24)
/* loaded from: classes.dex */
class MediaControllerCompatApi24 {

    public static class TransportControls {
        private TransportControls() {
        }

        public static void prepare(java.lang.Object obj) {
            ((android.media.session.MediaController.TransportControls) obj).prepare();
        }

        public static void prepareFromMediaId(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).prepareFromMediaId(str, bundle);
        }

        public static void prepareFromSearch(java.lang.Object obj, java.lang.String str, android.os.Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).prepareFromSearch(str, bundle);
        }

        public static void prepareFromUri(java.lang.Object obj, android.net.Uri uri, android.os.Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).prepareFromUri(uri, bundle);
        }
    }

    private MediaControllerCompatApi24() {
    }
}
