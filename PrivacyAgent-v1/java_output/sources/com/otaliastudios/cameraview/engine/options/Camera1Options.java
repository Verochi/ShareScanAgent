package com.otaliastudios.cameraview.engine.options;

/* loaded from: classes19.dex */
public class Camera1Options extends com.otaliastudios.cameraview.CameraOptions {
    public Camera1Options(@androidx.annotation.NonNull android.hardware.Camera.Parameters parameters, int i, boolean z) {
        com.otaliastudios.cameraview.engine.mappers.Camera1Mapper camera1Mapper = com.otaliastudios.cameraview.engine.mappers.Camera1Mapper.get();
        android.hardware.Camera.CameraInfo cameraInfo = new android.hardware.Camera.CameraInfo();
        int numberOfCameras = android.hardware.Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            android.hardware.Camera.getCameraInfo(i2, cameraInfo);
            com.otaliastudios.cameraview.controls.Facing unmapFacing = camera1Mapper.unmapFacing(cameraInfo.facing);
            if (unmapFacing != null) {
                this.supportedFacing.add(unmapFacing);
            }
        }
        java.util.List<java.lang.String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            java.util.Iterator<java.lang.String> it = supportedWhiteBalance.iterator();
            while (it.hasNext()) {
                com.otaliastudios.cameraview.controls.WhiteBalance unmapWhiteBalance = camera1Mapper.unmapWhiteBalance(it.next());
                if (unmapWhiteBalance != null) {
                    this.supportedWhiteBalance.add(unmapWhiteBalance);
                }
            }
        }
        this.supportedFlash.add(com.otaliastudios.cameraview.controls.Flash.OFF);
        java.util.List<java.lang.String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            java.util.Iterator<java.lang.String> it2 = supportedFlashModes.iterator();
            while (it2.hasNext()) {
                com.otaliastudios.cameraview.controls.Flash unmapFlash = camera1Mapper.unmapFlash(it2.next());
                if (unmapFlash != null) {
                    this.supportedFlash.add(unmapFlash);
                }
            }
        }
        this.supportedHdr.add(com.otaliastudios.cameraview.controls.Hdr.OFF);
        java.util.List<java.lang.String> supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            java.util.Iterator<java.lang.String> it3 = supportedSceneModes.iterator();
            while (it3.hasNext()) {
                com.otaliastudios.cameraview.controls.Hdr unmapHdr = camera1Mapper.unmapHdr(it3.next());
                if (unmapHdr != null) {
                    this.supportedHdr.add(unmapHdr);
                }
            }
        }
        this.zoomSupported = parameters.isZoomSupported();
        this.autoFocusSupported = parameters.getSupportedFocusModes().contains("auto");
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        this.exposureCorrectionMinValue = parameters.getMinExposureCompensation() * exposureCompensationStep;
        this.exposureCorrectionMaxValue = parameters.getMaxExposureCompensation() * exposureCompensationStep;
        this.exposureCorrectionSupported = (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) ? false : true;
        for (android.hardware.Camera.Size size : parameters.getSupportedPictureSizes()) {
            int i3 = z ? size.height : size.width;
            int i4 = z ? size.width : size.height;
            this.supportedPictureSizes.add(new com.otaliastudios.cameraview.size.Size(i3, i4));
            this.supportedPictureAspectRatio.add(com.otaliastudios.cameraview.size.AspectRatio.of(i3, i4));
        }
        android.media.CamcorderProfile camcorderProfile = com.otaliastudios.cameraview.internal.CamcorderProfiles.get(i, new com.otaliastudios.cameraview.size.Size(Integer.MAX_VALUE, Integer.MAX_VALUE));
        com.otaliastudios.cameraview.size.Size size2 = new com.otaliastudios.cameraview.size.Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        java.util.List<android.hardware.Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            for (android.hardware.Camera.Size size3 : supportedVideoSizes) {
                if (size3.width <= size2.getWidth() && size3.height <= size2.getHeight()) {
                    int i5 = z ? size3.height : size3.width;
                    int i6 = z ? size3.width : size3.height;
                    this.supportedVideoSizes.add(new com.otaliastudios.cameraview.size.Size(i5, i6));
                    this.supportedVideoAspectRatio.add(com.otaliastudios.cameraview.size.AspectRatio.of(i5, i6));
                }
            }
        } else {
            for (android.hardware.Camera.Size size4 : parameters.getSupportedPreviewSizes()) {
                if (size4.width <= size2.getWidth() && size4.height <= size2.getHeight()) {
                    int i7 = z ? size4.height : size4.width;
                    int i8 = z ? size4.width : size4.height;
                    this.supportedVideoSizes.add(new com.otaliastudios.cameraview.size.Size(i7, i8));
                    this.supportedVideoAspectRatio.add(com.otaliastudios.cameraview.size.AspectRatio.of(i7, i8));
                }
            }
        }
        this.previewFrameRateMinValue = Float.MAX_VALUE;
        this.previewFrameRateMaxValue = -3.4028235E38f;
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            float f = iArr[0] / 1000.0f;
            this.previewFrameRateMinValue = java.lang.Math.min(this.previewFrameRateMinValue, f);
            this.previewFrameRateMaxValue = java.lang.Math.max(this.previewFrameRateMaxValue, iArr[1] / 1000.0f);
        }
        this.supportedPictureFormats.add(com.otaliastudios.cameraview.controls.PictureFormat.JPEG);
        this.supportedFrameProcessingFormats.add(17);
    }
}
