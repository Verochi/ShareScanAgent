package com.otaliastudios.cameraview.preview;

/* loaded from: classes19.dex */
public class TextureCameraPreview extends com.otaliastudios.cameraview.preview.CameraPreview<android.view.TextureView, android.graphics.SurfaceTexture> {
    public android.view.View d;

    /* renamed from: com.otaliastudios.cameraview.preview.TextureCameraPreview$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.TextureView.SurfaceTextureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.otaliastudios.cameraview.preview.TextureCameraPreview.this.dispatchOnSurfaceAvailable(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            com.otaliastudios.cameraview.preview.TextureCameraPreview.this.dispatchOnSurfaceDestroyed();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.otaliastudios.cameraview.preview.TextureCameraPreview.this.dispatchOnSurfaceSizeChanged(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }
    }

    /* renamed from: com.otaliastudios.cameraview.preview.TextureCameraPreview$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.preview.CameraPreview.CropCallback n;

        public AnonymousClass2(com.otaliastudios.cameraview.preview.CameraPreview.CropCallback cropCallback) {
            this.n = cropCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            float f;
            com.otaliastudios.cameraview.preview.TextureCameraPreview textureCameraPreview = com.otaliastudios.cameraview.preview.TextureCameraPreview.this;
            if (textureCameraPreview.mInputStreamHeight == 0 || textureCameraPreview.mInputStreamWidth == 0 || (i = textureCameraPreview.mOutputSurfaceHeight) == 0 || (i2 = textureCameraPreview.mOutputSurfaceWidth) == 0) {
                com.otaliastudios.cameraview.preview.CameraPreview.CropCallback cropCallback = this.n;
                if (cropCallback != null) {
                    cropCallback.onCrop();
                    return;
                }
                return;
            }
            com.otaliastudios.cameraview.size.AspectRatio of = com.otaliastudios.cameraview.size.AspectRatio.of(i2, i);
            com.otaliastudios.cameraview.preview.TextureCameraPreview textureCameraPreview2 = com.otaliastudios.cameraview.preview.TextureCameraPreview.this;
            com.otaliastudios.cameraview.size.AspectRatio of2 = com.otaliastudios.cameraview.size.AspectRatio.of(textureCameraPreview2.mInputStreamWidth, textureCameraPreview2.mInputStreamHeight);
            float f2 = 1.0f;
            if (of.toFloat() >= of2.toFloat()) {
                f = of.toFloat() / of2.toFloat();
            } else {
                f2 = of2.toFloat() / of.toFloat();
                f = 1.0f;
            }
            com.otaliastudios.cameraview.preview.TextureCameraPreview.this.getView().setScaleX(f2);
            com.otaliastudios.cameraview.preview.TextureCameraPreview.this.getView().setScaleY(f);
            com.otaliastudios.cameraview.preview.TextureCameraPreview.this.mCropping = f2 > 1.02f || f > 1.02f;
            com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.preview.CameraPreview.LOG;
            cameraLogger.i("crop:", "applied scaleX=", java.lang.Float.valueOf(f2));
            cameraLogger.i("crop:", "applied scaleY=", java.lang.Float.valueOf(f));
            com.otaliastudios.cameraview.preview.CameraPreview.CropCallback cropCallback2 = this.n;
            if (cropCallback2 != null) {
                cropCallback2.onCrop();
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.preview.TextureCameraPreview$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ com.google.android.gms.tasks.TaskCompletionSource t;

        public AnonymousClass3(int i, com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource) {
            this.n = i;
            this.t = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            com.otaliastudios.cameraview.preview.TextureCameraPreview textureCameraPreview = com.otaliastudios.cameraview.preview.TextureCameraPreview.this;
            int i = textureCameraPreview.mOutputSurfaceWidth;
            float f = i / 2.0f;
            int i2 = textureCameraPreview.mOutputSurfaceHeight;
            float f2 = i2 / 2.0f;
            if (this.n % 180 != 0) {
                float f3 = i2 / i;
                matrix.postScale(f3, 1.0f / f3, f, f2);
            }
            matrix.postRotate(this.n, f, f2);
            com.otaliastudios.cameraview.preview.TextureCameraPreview.this.getView().setTransform(matrix);
            this.t.setResult(null);
        }
    }

    public TextureCameraPreview(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void crop(@androidx.annotation.Nullable com.otaliastudios.cameraview.preview.CameraPreview.CropCallback cropCallback) {
        getView().post(new com.otaliastudios.cameraview.preview.TextureCameraPreview.AnonymousClass2(cropCallback));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public android.graphics.SurfaceTexture getOutput() {
        return getView().getSurfaceTexture();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public java.lang.Class<android.graphics.SurfaceTexture> getOutputClass() {
        return android.graphics.SurfaceTexture.class;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public android.view.View getRootView() {
        return this.d;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public android.view.TextureView onCreateView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.otaliastudios.cameraview.R.layout.cameraview_texture_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        android.view.TextureView textureView = (android.view.TextureView) inflate.findViewById(com.otaliastudios.cameraview.R.id.texture_view);
        textureView.setSurfaceTextureListener(new com.otaliastudios.cameraview.preview.TextureCameraPreview.AnonymousClass1());
        this.d = inflate;
        return textureView;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void setDrawRotation(int i) {
        super.setDrawRotation(i);
        com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource = new com.google.android.gms.tasks.TaskCompletionSource();
        getView().post(new com.otaliastudios.cameraview.preview.TextureCameraPreview.AnonymousClass3(i, taskCompletionSource));
        try {
            com.google.android.gms.tasks.Tasks.await(taskCompletionSource.getTask());
        } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException unused) {
        }
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public boolean supportsCropping() {
        return true;
    }
}
