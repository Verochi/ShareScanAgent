package androidx.media;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes.dex */
class VolumeProviderCompatApi21 {

    /* renamed from: androidx.media.VolumeProviderCompatApi21$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.media.VolumeProvider {
        final /* synthetic */ androidx.media.VolumeProviderCompatApi21.Delegate val$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, int i2, int i3, androidx.media.VolumeProviderCompatApi21.Delegate delegate) {
            super(i, i2, i3);
            this.val$delegate = delegate;
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i) {
            this.val$delegate.onAdjustVolume(i);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i) {
            this.val$delegate.onSetVolumeTo(i);
        }
    }

    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    private VolumeProviderCompatApi21() {
    }

    public static java.lang.Object createVolumeProvider(int i, int i2, int i3, androidx.media.VolumeProviderCompatApi21.Delegate delegate) {
        return new androidx.media.VolumeProviderCompatApi21.AnonymousClass1(i, i2, i3, delegate);
    }

    public static void setCurrentVolume(java.lang.Object obj, int i) {
        ((android.media.VolumeProvider) obj).setCurrentVolume(i);
    }
}
