package androidx.media;

/* loaded from: classes.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private androidx.media.VolumeProviderCompat.Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private java.lang.Object mVolumeProviderObj;

    /* renamed from: androidx.media.VolumeProviderCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.media.VolumeProviderCompatApi21.Delegate {
        public AnonymousClass1() {
        }

        @Override // androidx.media.VolumeProviderCompatApi21.Delegate
        public void onAdjustVolume(int i) {
            androidx.media.VolumeProviderCompat.this.onAdjustVolume(i);
        }

        @Override // androidx.media.VolumeProviderCompatApi21.Delegate
        public void onSetVolumeTo(int i) {
            androidx.media.VolumeProviderCompat.this.onSetVolumeTo(i);
        }
    }

    public static abstract class Callback {
        public abstract void onVolumeChanged(androidx.media.VolumeProviderCompat volumeProviderCompat);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this.mControlType = i;
        this.mMaxVolume = i2;
        this.mCurrentVolume = i3;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public java.lang.Object getVolumeProvider() {
        if (this.mVolumeProviderObj == null) {
            this.mVolumeProviderObj = androidx.media.VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new androidx.media.VolumeProviderCompat.AnonymousClass1());
        }
        return this.mVolumeProviderObj;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(androidx.media.VolumeProviderCompat.Callback callback) {
        this.mCallback = callback;
    }

    public final void setCurrentVolume(int i) {
        this.mCurrentVolume = i;
        java.lang.Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null) {
            androidx.media.VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, i);
        }
        androidx.media.VolumeProviderCompat.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }
}
