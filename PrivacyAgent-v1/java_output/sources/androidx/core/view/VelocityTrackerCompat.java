package androidx.core.view;

@java.lang.Deprecated
/* loaded from: classes.dex */
public final class VelocityTrackerCompat {
    private VelocityTrackerCompat() {
    }

    @java.lang.Deprecated
    public static float getXVelocity(android.view.VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    @java.lang.Deprecated
    public static float getYVelocity(android.view.VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }
}
