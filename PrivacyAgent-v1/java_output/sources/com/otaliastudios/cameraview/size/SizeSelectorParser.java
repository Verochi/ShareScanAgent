package com.otaliastudios.cameraview.size;

/* loaded from: classes19.dex */
public class SizeSelectorParser {
    public com.otaliastudios.cameraview.size.SizeSelector a;
    public com.otaliastudios.cameraview.size.SizeSelector b;

    public SizeSelectorParser(@androidx.annotation.NonNull android.content.res.TypedArray typedArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList(3);
        int i = com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureSizeMinWidth;
        if (typedArray.hasValue(i)) {
            arrayList.add(com.otaliastudios.cameraview.size.SizeSelectors.minWidth(typedArray.getInteger(i, 0)));
        }
        int i2 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureSizeMaxWidth;
        if (typedArray.hasValue(i2)) {
            arrayList.add(com.otaliastudios.cameraview.size.SizeSelectors.maxWidth(typedArray.getInteger(i2, 0)));
        }
        int i3 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureSizeMinHeight;
        if (typedArray.hasValue(i3)) {
            arrayList.add(com.otaliastudios.cameraview.size.SizeSelectors.minHeight(typedArray.getInteger(i3, 0)));
        }
        int i4 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureSizeMaxHeight;
        if (typedArray.hasValue(i4)) {
            arrayList.add(com.otaliastudios.cameraview.size.SizeSelectors.maxHeight(typedArray.getInteger(i4, 0)));
        }
        int i5 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureSizeMinArea;
        if (typedArray.hasValue(i5)) {
            arrayList.add(com.otaliastudios.cameraview.size.SizeSelectors.minArea(typedArray.getInteger(i5, 0)));
        }
        int i6 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureSizeMaxArea;
        if (typedArray.hasValue(i6)) {
            arrayList.add(com.otaliastudios.cameraview.size.SizeSelectors.maxArea(typedArray.getInteger(i6, 0)));
        }
        int i7 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureSizeAspectRatio;
        if (typedArray.hasValue(i7)) {
            arrayList.add(com.otaliastudios.cameraview.size.SizeSelectors.aspectRatio(com.otaliastudios.cameraview.size.AspectRatio.parse(typedArray.getString(i7)), 0.0f));
        }
        if (typedArray.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureSizeSmallest, false)) {
            arrayList.add(com.otaliastudios.cameraview.size.SizeSelectors.smallest());
        }
        if (typedArray.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureSizeBiggest, false)) {
            arrayList.add(com.otaliastudios.cameraview.size.SizeSelectors.biggest());
        }
        this.a = !arrayList.isEmpty() ? com.otaliastudios.cameraview.size.SizeSelectors.and((com.otaliastudios.cameraview.size.SizeSelector[]) arrayList.toArray(new com.otaliastudios.cameraview.size.SizeSelector[0])) : com.otaliastudios.cameraview.size.SizeSelectors.biggest();
        java.util.ArrayList arrayList2 = new java.util.ArrayList(3);
        int i8 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoSizeMinWidth;
        if (typedArray.hasValue(i8)) {
            arrayList2.add(com.otaliastudios.cameraview.size.SizeSelectors.minWidth(typedArray.getInteger(i8, 0)));
        }
        int i9 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoSizeMaxWidth;
        if (typedArray.hasValue(i9)) {
            arrayList2.add(com.otaliastudios.cameraview.size.SizeSelectors.maxWidth(typedArray.getInteger(i9, 0)));
        }
        int i10 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoSizeMinHeight;
        if (typedArray.hasValue(i10)) {
            arrayList2.add(com.otaliastudios.cameraview.size.SizeSelectors.minHeight(typedArray.getInteger(i10, 0)));
        }
        int i11 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoSizeMaxHeight;
        if (typedArray.hasValue(i11)) {
            arrayList2.add(com.otaliastudios.cameraview.size.SizeSelectors.maxHeight(typedArray.getInteger(i11, 0)));
        }
        int i12 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoSizeMinArea;
        if (typedArray.hasValue(i12)) {
            arrayList2.add(com.otaliastudios.cameraview.size.SizeSelectors.minArea(typedArray.getInteger(i12, 0)));
        }
        int i13 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoSizeMaxArea;
        if (typedArray.hasValue(i13)) {
            arrayList2.add(com.otaliastudios.cameraview.size.SizeSelectors.maxArea(typedArray.getInteger(i13, 0)));
        }
        int i14 = com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoSizeAspectRatio;
        if (typedArray.hasValue(i14)) {
            arrayList2.add(com.otaliastudios.cameraview.size.SizeSelectors.aspectRatio(com.otaliastudios.cameraview.size.AspectRatio.parse(typedArray.getString(i14)), 0.0f));
        }
        if (typedArray.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoSizeSmallest, false)) {
            arrayList2.add(com.otaliastudios.cameraview.size.SizeSelectors.smallest());
        }
        if (typedArray.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoSizeBiggest, false)) {
            arrayList2.add(com.otaliastudios.cameraview.size.SizeSelectors.biggest());
        }
        this.b = !arrayList2.isEmpty() ? com.otaliastudios.cameraview.size.SizeSelectors.and((com.otaliastudios.cameraview.size.SizeSelector[]) arrayList2.toArray(new com.otaliastudios.cameraview.size.SizeSelector[0])) : com.otaliastudios.cameraview.size.SizeSelectors.biggest();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.size.SizeSelector getPictureSizeSelector() {
        return this.a;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.size.SizeSelector getVideoSizeSelector() {
        return this.b;
    }
}
