package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class h32 {
    public static void a(com.google.android.exoplayer2.Player.EventListener eventListener, boolean z) {
    }

    public static void b(com.google.android.exoplayer2.Player.EventListener eventListener, boolean z) {
        eventListener.onLoadingChanged(z);
    }

    public static void c(com.google.android.exoplayer2.Player.EventListener eventListener, boolean z) {
    }

    @java.lang.Deprecated
    public static void d(com.google.android.exoplayer2.Player.EventListener eventListener, boolean z) {
    }

    public static void e(com.google.android.exoplayer2.Player.EventListener eventListener, @androidx.annotation.Nullable com.google.android.exoplayer2.MediaItem mediaItem, int i) {
    }

    public static void f(com.google.android.exoplayer2.Player.EventListener eventListener, boolean z, int i) {
    }

    public static void g(com.google.android.exoplayer2.Player.EventListener eventListener, com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
    }

    public static void h(com.google.android.exoplayer2.Player.EventListener eventListener, int i) {
    }

    public static void i(com.google.android.exoplayer2.Player.EventListener eventListener, int i) {
    }

    public static void j(com.google.android.exoplayer2.Player.EventListener eventListener, com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
    }

    @java.lang.Deprecated
    public static void k(com.google.android.exoplayer2.Player.EventListener eventListener, boolean z, int i) {
    }

    public static void l(com.google.android.exoplayer2.Player.EventListener eventListener, int i) {
    }

    public static void m(com.google.android.exoplayer2.Player.EventListener eventListener, int i) {
    }

    @java.lang.Deprecated
    public static void n(com.google.android.exoplayer2.Player.EventListener eventListener) {
    }

    public static void o(com.google.android.exoplayer2.Player.EventListener eventListener, boolean z) {
    }

    public static void p(com.google.android.exoplayer2.Player.EventListener eventListener, com.google.android.exoplayer2.Timeline timeline, int i) {
        eventListener.onTimelineChanged(timeline, timeline.getWindowCount() == 1 ? timeline.getWindow(0, new com.google.android.exoplayer2.Timeline.Window()).manifest : null, i);
    }

    @java.lang.Deprecated
    public static void q(com.google.android.exoplayer2.Player.EventListener eventListener, com.google.android.exoplayer2.Timeline timeline, @androidx.annotation.Nullable java.lang.Object obj, int i) {
    }

    public static void r(com.google.android.exoplayer2.Player.EventListener eventListener, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
    }
}
