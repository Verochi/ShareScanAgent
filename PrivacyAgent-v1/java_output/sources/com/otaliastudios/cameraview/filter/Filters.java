package com.otaliastudios.cameraview.filter;

/* loaded from: classes19.dex */
public enum Filters {
    NONE(com.otaliastudios.cameraview.filter.NoFilter.class),
    AUTO_FIX(com.otaliastudios.cameraview.filters.AutoFixFilter.class),
    BLACK_AND_WHITE(com.otaliastudios.cameraview.filters.BlackAndWhiteFilter.class),
    BRIGHTNESS(com.otaliastudios.cameraview.filters.BrightnessFilter.class),
    CONTRAST(com.otaliastudios.cameraview.filters.ContrastFilter.class),
    CROSS_PROCESS(com.otaliastudios.cameraview.filters.CrossProcessFilter.class),
    DOCUMENTARY(com.otaliastudios.cameraview.filters.DocumentaryFilter.class),
    DUOTONE(com.otaliastudios.cameraview.filters.DuotoneFilter.class),
    FILL_LIGHT(com.otaliastudios.cameraview.filters.FillLightFilter.class),
    GAMMA(com.otaliastudios.cameraview.filters.GammaFilter.class),
    GRAIN(com.otaliastudios.cameraview.filters.GrainFilter.class),
    GRAYSCALE(com.otaliastudios.cameraview.filters.GrayscaleFilter.class),
    HUE(com.otaliastudios.cameraview.filters.HueFilter.class),
    INVERT_COLORS(com.otaliastudios.cameraview.filters.InvertColorsFilter.class),
    LOMOISH(com.otaliastudios.cameraview.filters.LomoishFilter.class),
    POSTERIZE(com.otaliastudios.cameraview.filters.PosterizeFilter.class),
    SATURATION(com.otaliastudios.cameraview.filters.SaturationFilter.class),
    SEPIA(com.otaliastudios.cameraview.filters.SepiaFilter.class),
    SHARPNESS(com.otaliastudios.cameraview.filters.SharpnessFilter.class),
    TEMPERATURE(com.otaliastudios.cameraview.filters.TemperatureFilter.class),
    TINT(com.otaliastudios.cameraview.filters.TintFilter.class),
    VIGNETTE(com.otaliastudios.cameraview.filters.VignetteFilter.class);

    private java.lang.Class<? extends com.otaliastudios.cameraview.filter.Filter> filterClass;

    Filters(@androidx.annotation.NonNull java.lang.Class cls) {
        this.filterClass = cls;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.filter.Filter newInstance() {
        try {
            return this.filterClass.newInstance();
        } catch (java.lang.IllegalAccessException unused) {
            return new com.otaliastudios.cameraview.filter.NoFilter();
        } catch (java.lang.InstantiationException unused2) {
            return new com.otaliastudios.cameraview.filter.NoFilter();
        }
    }
}
