package android.support.v4.media.session;

@androidx.annotation.RequiresApi(22)
/* loaded from: classes.dex */
class PlaybackStateCompatApi22 {
    private PlaybackStateCompatApi22() {
    }

    public static android.os.Bundle getExtras(java.lang.Object obj) {
        android.os.Bundle extras;
        extras = ((android.media.session.PlaybackState) obj).getExtras();
        return extras;
    }

    public static java.lang.Object newInstance(int i, long j, long j2, float f, long j3, java.lang.CharSequence charSequence, long j4, java.util.List<java.lang.Object> list, long j5, android.os.Bundle bundle) {
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
        builder.setExtras(bundle);
        return builder.build();
    }
}
