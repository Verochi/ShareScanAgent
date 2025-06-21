package com.otaliastudios.cameraview;

/* loaded from: classes19.dex */
public abstract class CameraOptions {
    protected boolean autoFocusSupported;
    protected float exposureCorrectionMaxValue;
    protected float exposureCorrectionMinValue;
    protected boolean exposureCorrectionSupported;
    protected float previewFrameRateMaxValue;
    protected float previewFrameRateMinValue;
    protected boolean zoomSupported;
    protected java.util.Set<com.otaliastudios.cameraview.controls.WhiteBalance> supportedWhiteBalance = new java.util.HashSet(5);
    protected java.util.Set<com.otaliastudios.cameraview.controls.Facing> supportedFacing = new java.util.HashSet(2);
    protected java.util.Set<com.otaliastudios.cameraview.controls.Flash> supportedFlash = new java.util.HashSet(4);
    protected java.util.Set<com.otaliastudios.cameraview.controls.Hdr> supportedHdr = new java.util.HashSet(2);
    protected java.util.Set<com.otaliastudios.cameraview.size.Size> supportedPictureSizes = new java.util.HashSet(15);
    protected java.util.Set<com.otaliastudios.cameraview.size.Size> supportedVideoSizes = new java.util.HashSet(5);
    protected java.util.Set<com.otaliastudios.cameraview.size.AspectRatio> supportedPictureAspectRatio = new java.util.HashSet(4);
    protected java.util.Set<com.otaliastudios.cameraview.size.AspectRatio> supportedVideoAspectRatio = new java.util.HashSet(3);
    protected java.util.Set<com.otaliastudios.cameraview.controls.PictureFormat> supportedPictureFormats = new java.util.HashSet(2);
    protected java.util.Set<java.lang.Integer> supportedFrameProcessingFormats = new java.util.HashSet(2);

    /* renamed from: com.otaliastudios.cameraview.CameraOptions$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.otaliastudios.cameraview.gesture.GestureAction.values().length];
            a = iArr;
            try {
                iArr[com.otaliastudios.cameraview.gesture.GestureAction.AUTO_FOCUS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.otaliastudios.cameraview.gesture.GestureAction.TAKE_PICTURE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.otaliastudios.cameraview.gesture.GestureAction.FILTER_CONTROL_1.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.otaliastudios.cameraview.gesture.GestureAction.FILTER_CONTROL_2.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.otaliastudios.cameraview.gesture.GestureAction.NONE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.otaliastudios.cameraview.gesture.GestureAction.ZOOM.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.otaliastudios.cameraview.gesture.GestureAction.EXPOSURE_CORRECTION.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public final float getExposureCorrectionMaxValue() {
        return this.exposureCorrectionMaxValue;
    }

    public final float getExposureCorrectionMinValue() {
        return this.exposureCorrectionMinValue;
    }

    public final float getPreviewFrameRateMaxValue() {
        return this.previewFrameRateMaxValue;
    }

    public final float getPreviewFrameRateMinValue() {
        return this.previewFrameRateMinValue;
    }

    @androidx.annotation.NonNull
    public final <T extends com.otaliastudios.cameraview.controls.Control> java.util.Collection<T> getSupportedControls(@androidx.annotation.NonNull java.lang.Class<T> cls) {
        return cls.equals(com.otaliastudios.cameraview.controls.Audio.class) ? java.util.Arrays.asList(com.otaliastudios.cameraview.controls.Audio.values()) : cls.equals(com.otaliastudios.cameraview.controls.Facing.class) ? getSupportedFacing() : cls.equals(com.otaliastudios.cameraview.controls.Flash.class) ? getSupportedFlash() : cls.equals(com.otaliastudios.cameraview.controls.Grid.class) ? java.util.Arrays.asList(com.otaliastudios.cameraview.controls.Grid.values()) : cls.equals(com.otaliastudios.cameraview.controls.Hdr.class) ? getSupportedHdr() : cls.equals(com.otaliastudios.cameraview.controls.Mode.class) ? java.util.Arrays.asList(com.otaliastudios.cameraview.controls.Mode.values()) : cls.equals(com.otaliastudios.cameraview.controls.VideoCodec.class) ? java.util.Arrays.asList(com.otaliastudios.cameraview.controls.VideoCodec.values()) : cls.equals(com.otaliastudios.cameraview.controls.AudioCodec.class) ? java.util.Arrays.asList(com.otaliastudios.cameraview.controls.AudioCodec.values()) : cls.equals(com.otaliastudios.cameraview.controls.WhiteBalance.class) ? getSupportedWhiteBalance() : cls.equals(com.otaliastudios.cameraview.controls.Engine.class) ? java.util.Arrays.asList(com.otaliastudios.cameraview.controls.Engine.values()) : cls.equals(com.otaliastudios.cameraview.controls.Preview.class) ? java.util.Arrays.asList(com.otaliastudios.cameraview.controls.Preview.values()) : cls.equals(com.otaliastudios.cameraview.controls.PictureFormat.class) ? getSupportedPictureFormats() : java.util.Collections.emptyList();
    }

    @androidx.annotation.NonNull
    public final java.util.Collection<com.otaliastudios.cameraview.controls.Facing> getSupportedFacing() {
        return java.util.Collections.unmodifiableSet(this.supportedFacing);
    }

    @androidx.annotation.NonNull
    public final java.util.Collection<com.otaliastudios.cameraview.controls.Flash> getSupportedFlash() {
        return java.util.Collections.unmodifiableSet(this.supportedFlash);
    }

    @androidx.annotation.NonNull
    public final java.util.Collection<java.lang.Integer> getSupportedFrameProcessingFormats() {
        return java.util.Collections.unmodifiableSet(this.supportedFrameProcessingFormats);
    }

    @androidx.annotation.NonNull
    public final java.util.Collection<com.otaliastudios.cameraview.controls.Hdr> getSupportedHdr() {
        return java.util.Collections.unmodifiableSet(this.supportedHdr);
    }

    @androidx.annotation.NonNull
    public final java.util.Collection<com.otaliastudios.cameraview.size.AspectRatio> getSupportedPictureAspectRatios() {
        return java.util.Collections.unmodifiableSet(this.supportedPictureAspectRatio);
    }

    @androidx.annotation.NonNull
    public final java.util.Collection<com.otaliastudios.cameraview.controls.PictureFormat> getSupportedPictureFormats() {
        return java.util.Collections.unmodifiableSet(this.supportedPictureFormats);
    }

    @androidx.annotation.NonNull
    public final java.util.Collection<com.otaliastudios.cameraview.size.Size> getSupportedPictureSizes() {
        return java.util.Collections.unmodifiableSet(this.supportedPictureSizes);
    }

    @androidx.annotation.NonNull
    public final java.util.Collection<com.otaliastudios.cameraview.size.AspectRatio> getSupportedVideoAspectRatios() {
        return java.util.Collections.unmodifiableSet(this.supportedVideoAspectRatio);
    }

    @androidx.annotation.NonNull
    public final java.util.Collection<com.otaliastudios.cameraview.size.Size> getSupportedVideoSizes() {
        return java.util.Collections.unmodifiableSet(this.supportedVideoSizes);
    }

    @androidx.annotation.NonNull
    public final java.util.Collection<com.otaliastudios.cameraview.controls.WhiteBalance> getSupportedWhiteBalance() {
        return java.util.Collections.unmodifiableSet(this.supportedWhiteBalance);
    }

    public final boolean isAutoFocusSupported() {
        return this.autoFocusSupported;
    }

    public final boolean isExposureCorrectionSupported() {
        return this.exposureCorrectionSupported;
    }

    public final boolean isZoomSupported() {
        return this.zoomSupported;
    }

    public final boolean supports(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Control control) {
        return getSupportedControls(control.getClass()).contains(control);
    }

    public final boolean supports(@androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.GestureAction gestureAction) {
        switch (com.otaliastudios.cameraview.CameraOptions.AnonymousClass1.a[gestureAction.ordinal()]) {
            case 1:
                return isAutoFocusSupported();
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            case 6:
                return isZoomSupported();
            case 7:
                return isExposureCorrectionSupported();
            default:
                return false;
        }
    }
}
