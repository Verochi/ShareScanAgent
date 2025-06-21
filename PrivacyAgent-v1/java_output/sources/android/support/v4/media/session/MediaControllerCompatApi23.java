package android.support.v4.media.session;

@androidx.annotation.RequiresApi(23)
/* loaded from: classes.dex */
class MediaControllerCompatApi23 {

    public static class TransportControls {
        private TransportControls() {
        }

        public static void playFromUri(java.lang.Object obj, android.net.Uri uri, android.os.Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).playFromUri(uri, bundle);
        }
    }

    private MediaControllerCompatApi23() {
    }
}
