package com.otaliastudios.cameraview.engine.options;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class Camera2Options extends com.otaliastudios.cameraview.CameraOptions {
    public Camera2Options(@androidx.annotation.NonNull android.hardware.camera2.CameraManager cameraManager, @androidx.annotation.NonNull java.lang.String str, boolean z, int i) throws android.hardware.camera2.CameraAccessException {
        com.otaliastudios.cameraview.controls.Facing unmapFacing;
        com.otaliastudios.cameraview.engine.mappers.Camera2Mapper camera2Mapper = com.otaliastudios.cameraview.engine.mappers.Camera2Mapper.get();
        android.hardware.camera2.CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
        for (java.lang.String str2 : cameraManager.getCameraIdList()) {
            java.lang.Integer num = (java.lang.Integer) cameraManager.getCameraCharacteristics(str2).get(android.hardware.camera2.CameraCharacteristics.LENS_FACING);
            if (num != null && (unmapFacing = camera2Mapper.unmapFacing(num.intValue())) != null) {
                this.supportedFacing.add(unmapFacing);
            }
        }
        for (int i2 : (int[]) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)) {
            com.otaliastudios.cameraview.controls.WhiteBalance unmapWhiteBalance = camera2Mapper.unmapWhiteBalance(i2);
            if (unmapWhiteBalance != null) {
                this.supportedWhiteBalance.add(unmapWhiteBalance);
            }
        }
        this.supportedFlash.add(com.otaliastudios.cameraview.controls.Flash.OFF);
        java.lang.Boolean bool = (java.lang.Boolean) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool != null && bool.booleanValue()) {
            for (int i3 : (int[]) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) {
                this.supportedFlash.addAll(camera2Mapper.unmapFlash(i3));
            }
        }
        this.supportedHdr.add(com.otaliastudios.cameraview.controls.Hdr.OFF);
        for (int i4 : (int[]) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
            com.otaliastudios.cameraview.controls.Hdr unmapHdr = camera2Mapper.unmapHdr(i4);
            if (unmapHdr != null) {
                this.supportedHdr.add(unmapHdr);
            }
        }
        java.lang.Float f = (java.lang.Float) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        boolean z2 = true;
        if (f != null) {
            this.zoomSupported = f.floatValue() > 1.0f;
        }
        java.lang.Integer num2 = (java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        java.lang.Integer num3 = (java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        java.lang.Integer num4 = (java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        this.autoFocusSupported = (num2 != null && num2.intValue() > 0) || (num3 != null && num3.intValue() > 0) || (num4 != null && num4.intValue() > 0);
        android.util.Range range = (android.util.Range) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        android.util.Rational rational = (android.util.Rational) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (range != null && rational != null && rational.floatValue() != 0.0f) {
            this.exposureCorrectionMinValue = ((java.lang.Integer) range.getLower()).intValue() / rational.floatValue();
            this.exposureCorrectionMaxValue = ((java.lang.Integer) range.getUpper()).intValue() / rational.floatValue();
        }
        this.exposureCorrectionSupported = (this.exposureCorrectionMinValue == 0.0f || this.exposureCorrectionMaxValue == 0.0f) ? false : true;
        android.hardware.camera2.params.StreamConfigurationMap streamConfigurationMap = (android.hardware.camera2.params.StreamConfigurationMap) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new java.lang.RuntimeException("StreamConfigurationMap is null. Should not happen.");
        }
        int[] outputFormats = streamConfigurationMap.getOutputFormats();
        int length = outputFormats.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                z2 = false;
                break;
            } else if (outputFormats[i5] == i) {
                break;
            } else {
                i5++;
            }
        }
        if (!z2) {
            throw new java.lang.IllegalStateException("Picture format not supported: " + i);
        }
        for (android.util.Size size : streamConfigurationMap.getOutputSizes(i)) {
            int height = z ? size.getHeight() : size.getWidth();
            int width = z ? size.getWidth() : size.getHeight();
            this.supportedPictureSizes.add(new com.otaliastudios.cameraview.size.Size(height, width));
            this.supportedPictureAspectRatio.add(com.otaliastudios.cameraview.size.AspectRatio.of(height, width));
        }
        android.media.CamcorderProfile camcorderProfile = com.otaliastudios.cameraview.internal.CamcorderProfiles.get(str, new com.otaliastudios.cameraview.size.Size(Integer.MAX_VALUE, Integer.MAX_VALUE));
        com.otaliastudios.cameraview.size.Size size2 = new com.otaliastudios.cameraview.size.Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        for (android.util.Size size3 : streamConfigurationMap.getOutputSizes(android.media.MediaRecorder.class)) {
            if (size3.getWidth() <= size2.getWidth() && size3.getHeight() <= size2.getHeight()) {
                int height2 = z ? size3.getHeight() : size3.getWidth();
                int width2 = z ? size3.getWidth() : size3.getHeight();
                this.supportedVideoSizes.add(new com.otaliastudios.cameraview.size.Size(height2, width2));
                this.supportedVideoAspectRatio.add(com.otaliastudios.cameraview.size.AspectRatio.of(height2, width2));
            }
        }
        android.util.Range[] rangeArr = (android.util.Range[]) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr != null) {
            this.previewFrameRateMinValue = Float.MAX_VALUE;
            this.previewFrameRateMaxValue = -3.4028235E38f;
            for (android.util.Range range2 : rangeArr) {
                this.previewFrameRateMinValue = java.lang.Math.min(this.previewFrameRateMinValue, ((java.lang.Integer) range2.getLower()).intValue());
                this.previewFrameRateMaxValue = java.lang.Math.max(this.previewFrameRateMaxValue, ((java.lang.Integer) range2.getUpper()).intValue());
            }
        } else {
            this.previewFrameRateMinValue = 0.0f;
            this.previewFrameRateMaxValue = 0.0f;
        }
        this.supportedPictureFormats.add(com.otaliastudios.cameraview.controls.PictureFormat.JPEG);
        int[] iArr = (int[]) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i6 : iArr) {
                if (i6 == 3) {
                    this.supportedPictureFormats.add(com.otaliastudios.cameraview.controls.PictureFormat.DNG);
                }
            }
        }
        this.supportedFrameProcessingFormats.add(35);
        for (int i7 : streamConfigurationMap.getOutputFormats()) {
            if (android.graphics.ImageFormat.getBitsPerPixel(i7) > 0) {
                this.supportedFrameProcessingFormats.add(java.lang.Integer.valueOf(i7));
            }
        }
    }
}
