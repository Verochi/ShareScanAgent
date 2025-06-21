package jp.co.cyberagent.android.gpuimage.filter;

/* loaded from: classes14.dex */
public class GPUImageTwoPassFilter extends jp.co.cyberagent.android.gpuimage.filter.GPUImageFilterGroup {
    public GPUImageTwoPassFilter(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        super(null);
        addFilter(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter(str, str2));
        addFilter(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter(str3, str4));
    }
}
