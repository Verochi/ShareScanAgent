package com.otaliastudios.cameraview.preview;

/* loaded from: classes19.dex */
public abstract class CameraPreview<T extends android.view.View, Output> {
    protected static final com.otaliastudios.cameraview.CameraLogger LOG = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.preview.CameraPreview.class.getSimpleName());

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.preview.CameraPreview.CropCallback a;
    public com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback b;
    public T c;
    protected boolean mCropping;
    protected int mDrawRotation;
    protected int mInputStreamHeight;
    protected int mInputStreamWidth;
    protected int mOutputSurfaceHeight;
    protected int mOutputSurfaceWidth;

    /* renamed from: com.otaliastudios.cameraview.preview.CameraPreview$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.google.android.gms.tasks.TaskCompletionSource n;

        public AnonymousClass1(com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource) {
            this.n = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.preview.CameraPreview.this.onDestroyView();
            this.n.setResult(null);
        }
    }

    public interface CropCallback {
        void onCrop();
    }

    public interface SurfaceCallback {
        void onSurfaceAvailable();

        void onSurfaceChanged();

        void onSurfaceDestroyed();
    }

    public CameraPreview(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        this.c = onCreateView(context, viewGroup);
    }

    public void crop(@androidx.annotation.Nullable com.otaliastudios.cameraview.preview.CameraPreview.CropCallback cropCallback) {
        if (cropCallback != null) {
            cropCallback.onCrop();
        }
    }

    public final void dispatchOnSurfaceAvailable(int i, int i2) {
        LOG.i("dispatchOnSurfaceAvailable:", "w=", java.lang.Integer.valueOf(i), "h=", java.lang.Integer.valueOf(i2));
        this.mOutputSurfaceWidth = i;
        this.mOutputSurfaceHeight = i2;
        if (i > 0 && i2 > 0) {
            crop(this.a);
        }
        com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback surfaceCallback = this.b;
        if (surfaceCallback != null) {
            surfaceCallback.onSurfaceAvailable();
        }
    }

    public final void dispatchOnSurfaceDestroyed() {
        this.mOutputSurfaceWidth = 0;
        this.mOutputSurfaceHeight = 0;
        com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback surfaceCallback = this.b;
        if (surfaceCallback != null) {
            surfaceCallback.onSurfaceDestroyed();
        }
    }

    public final void dispatchOnSurfaceSizeChanged(int i, int i2) {
        LOG.i("dispatchOnSurfaceSizeChanged:", "w=", java.lang.Integer.valueOf(i), "h=", java.lang.Integer.valueOf(i2));
        if (i == this.mOutputSurfaceWidth && i2 == this.mOutputSurfaceHeight) {
            return;
        }
        this.mOutputSurfaceWidth = i;
        this.mOutputSurfaceHeight = i2;
        if (i > 0 && i2 > 0) {
            crop(this.a);
        }
        com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback surfaceCallback = this.b;
        if (surfaceCallback != null) {
            surfaceCallback.onSurfaceChanged();
        }
    }

    @androidx.annotation.NonNull
    public abstract Output getOutput();

    @androidx.annotation.NonNull
    public abstract java.lang.Class<Output> getOutputClass();

    @androidx.annotation.NonNull
    public abstract android.view.View getRootView();

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.size.Size getSurfaceSize() {
        return new com.otaliastudios.cameraview.size.Size(this.mOutputSurfaceWidth, this.mOutputSurfaceHeight);
    }

    @androidx.annotation.NonNull
    public final T getView() {
        return this.c;
    }

    public final boolean hasSurface() {
        return this.mOutputSurfaceWidth > 0 && this.mOutputSurfaceHeight > 0;
    }

    public boolean isCropping() {
        return this.mCropping;
    }

    @androidx.annotation.NonNull
    public abstract T onCreateView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup);

    @androidx.annotation.CallSuper
    public void onDestroy() {
        if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
            onDestroyView();
            return;
        }
        android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
        com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource = new com.google.android.gms.tasks.TaskCompletionSource();
        handler.post(new com.otaliastudios.cameraview.preview.CameraPreview.AnonymousClass1(taskCompletionSource));
        try {
            com.google.android.gms.tasks.Tasks.await(taskCompletionSource.getTask());
        } catch (java.lang.Exception unused) {
        }
    }

    @androidx.annotation.UiThread
    public void onDestroyView() {
        android.view.View rootView = getRootView();
        android.view.ViewParent parent = rootView.getParent();
        if (parent instanceof android.view.ViewGroup) {
            ((android.view.ViewGroup) parent).removeView(rootView);
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void setDrawRotation(int i) {
        this.mDrawRotation = i;
    }

    public void setStreamSize(int i, int i2) {
        LOG.i("setStreamSize:", "desiredW=", java.lang.Integer.valueOf(i), "desiredH=", java.lang.Integer.valueOf(i2));
        this.mInputStreamWidth = i;
        this.mInputStreamHeight = i2;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        crop(this.a);
    }

    public void setSurfaceCallback(@androidx.annotation.Nullable com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback surfaceCallback) {
        com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback surfaceCallback2;
        com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback surfaceCallback3;
        if (hasSurface() && (surfaceCallback3 = this.b) != null) {
            surfaceCallback3.onSurfaceDestroyed();
        }
        this.b = surfaceCallback;
        if (!hasSurface() || (surfaceCallback2 = this.b) == null) {
            return;
        }
        surfaceCallback2.onSurfaceAvailable();
    }

    public boolean supportsCropping() {
        return false;
    }
}
