package jp.co.cyberagent.android.gpuimage.filter;

/* loaded from: classes14.dex */
public class GPUImageTwoPassTextureSamplingFilter extends jp.co.cyberagent.android.gpuimage.filter.GPUImageTwoPassFilter {
    public GPUImageTwoPassTextureSamplingFilter(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        super(str, str2, str3, str4);
    }

    public float getHorizontalTexelOffsetRatio() {
        return 1.0f;
    }

    public float getVerticalTexelOffsetRatio() {
        return 1.0f;
    }

    public void initTexelOffsets() {
        float horizontalTexelOffsetRatio = getHorizontalTexelOffsetRatio();
        jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter gPUImageFilter = getFilters().get(0);
        int glGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(gPUImageFilter.getProgram(), "texelWidthOffset");
        int glGetUniformLocation2 = android.opengl.GLES20.glGetUniformLocation(gPUImageFilter.getProgram(), "texelHeightOffset");
        gPUImageFilter.setFloat(glGetUniformLocation, horizontalTexelOffsetRatio / getOutputWidth());
        gPUImageFilter.setFloat(glGetUniformLocation2, 0.0f);
        float verticalTexelOffsetRatio = getVerticalTexelOffsetRatio();
        jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter gPUImageFilter2 = getFilters().get(1);
        int glGetUniformLocation3 = android.opengl.GLES20.glGetUniformLocation(gPUImageFilter2.getProgram(), "texelWidthOffset");
        int glGetUniformLocation4 = android.opengl.GLES20.glGetUniformLocation(gPUImageFilter2.getProgram(), "texelHeightOffset");
        gPUImageFilter2.setFloat(glGetUniformLocation3, 0.0f);
        gPUImageFilter2.setFloat(glGetUniformLocation4, verticalTexelOffsetRatio / getOutputHeight());
    }

    @Override // jp.co.cyberagent.android.gpuimage.filter.GPUImageFilterGroup, jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
    public void onInit() {
        super.onInit();
        initTexelOffsets();
    }

    @Override // jp.co.cyberagent.android.gpuimage.filter.GPUImageFilterGroup, jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        initTexelOffsets();
    }
}
