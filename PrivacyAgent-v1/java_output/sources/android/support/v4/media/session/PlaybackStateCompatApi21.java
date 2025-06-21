package android.support.v4.media.session;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes.dex */
class PlaybackStateCompatApi21 {

    public static final class CustomAction {
        private CustomAction() {
        }

        public static java.lang.String getAction(java.lang.Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getAction();
        }

        public static android.os.Bundle getExtras(java.lang.Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getExtras();
        }

        public static int getIcon(java.lang.Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getIcon();
        }

        public static java.lang.CharSequence getName(java.lang.Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getName();
        }

        public static java.lang.Object newInstance(java.lang.String str, java.lang.CharSequence charSequence, int i, android.os.Bundle bundle) {
            android.media.session.PlaybackState.CustomAction.Builder builder = new android.media.session.PlaybackState.CustomAction.Builder(str, charSequence, i);
            builder.setExtras(bundle);
            return builder.build();
        }
    }

    private PlaybackStateCompatApi21() {
    }

    public static long getActions(java.lang.Object obj) {
        return ((android.media.session.PlaybackState) obj).getActions();
    }

    public static long getActiveQueueItemId(java.lang.Object obj) {
        return ((android.media.session.PlaybackState) obj).getActiveQueueItemId();
    }

    public static long getBufferedPosition(java.lang.Object obj) {
        return ((android.media.session.PlaybackState) obj).getBufferedPosition();
    }

    public static java.util.List<java.lang.Object> getCustomActions(java.lang.Object obj) {
        return ((android.media.session.PlaybackState) obj).getCustomActions();
    }

    public static java.lang.CharSequence getErrorMessage(java.lang.Object obj) {
        return ((android.media.session.PlaybackState) obj).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(java.lang.Object obj) {
        return ((android.media.session.PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static float getPlaybackSpeed(java.lang.Object obj) {
        return ((android.media.session.PlaybackState) obj).getPlaybackSpeed();
    }

    public static long getPosition(java.lang.Object obj) {
        return ((android.media.session.PlaybackState) obj).getPosition();
    }

    public static int getState(java.lang.Object obj) {
        return ((android.media.session.PlaybackState) obj).getState();
    }

    public static java.lang.Object newInstance(int i, long j, long j2, float f, long j3, java.lang.CharSequence charSequence, long j4, java.util.List<java.lang.Object> list, long j5) {
        android.media.session.PlaybackState.Builder builder = new android.media.session.PlaybackState.Builder();
        builder.setState(i, j, f, j4);
        builder.setBufferedPosition(j2);
        builder.setActions(j3);
        builder.setErrorMessage(charSequence);
        java.util.Iterator<java.lang.Object> it = list.iterator();
        while (it.hasNext()) {
            builder.addCustomAction((android.media.session.PlaybackState.CustomAction) it.next());
        }
        builder.setActiveQueueItemId(j5);
        return builder.build();
    }
}
