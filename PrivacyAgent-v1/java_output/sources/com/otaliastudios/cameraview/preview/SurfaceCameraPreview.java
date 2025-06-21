package com.otaliastudios.cameraview.preview;

/* loaded from: classes19.dex */
public class SurfaceCameraPreview extends com.otaliastudios.cameraview.preview.CameraPreview<android.view.SurfaceView, android.view.SurfaceHolder> {
    public static final com.otaliastudios.cameraview.CameraLogger f = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.preview.SurfaceCameraPreview.class.getSimpleName());
    public boolean d;
    public android.view.View e;

    /* renamed from: com.otaliastudios.cameraview.preview.SurfaceCameraPreview$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.SurfaceHolder.Callback {
        public AnonymousClass1() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            com.otaliastudios.cameraview.preview.SurfaceCameraPreview.f.i("callback:", "surfaceChanged", "w:", java.lang.Integer.valueOf(i2), "h:", java.lang.Integer.valueOf(i3), "dispatched:", java.lang.Boolean.valueOf(com.otaliastudios.cameraview.preview.SurfaceCameraPreview.this.d));
            if (com.otaliastudios.cameraview.preview.SurfaceCameraPreview.this.d) {
                com.otaliastudios.cameraview.preview.SurfaceCameraPreview.this.dispatchOnSurfaceSizeChanged(i2, i3);
            } else {
                com.otaliastudios.cameraview.preview.SurfaceCameraPreview.this.dispatchOnSurfaceAvailable(i2, i3);
                com.otaliastudios.cameraview.preview.SurfaceCameraPreview.this.d = true;
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            com.otaliastudios.cameraview.preview.SurfaceCameraPreview.f.i("callback:", "surfaceDestroyed");
            com.otaliastudios.cameraview.preview.SurfaceCameraPreview.this.dispatchOnSurfaceDestroyed();
            com.otaliastudios.cameraview.preview.SurfaceCameraPreview.this.d = false;
        }
    }

    public SurfaceCameraPreview(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public android.view.SurfaceHolder getOutput() {
        return getView().getHolder();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public java.lang.Class<android.view.SurfaceHolder> getOutputClass() {
        return android.view.SurfaceHolder.class;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public android.view.View getRootView() {
        return this.e;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @androidx.annotation.NonNull
    public android.view.SurfaceView onCreateView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.otaliastudios.cameraview.R.layout.cameraview_surface_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        android.view.SurfaceView surfaceView = (android.view.SurfaceView) inflate.findViewById(com.otaliastudios.cameraview.R.id.surface_view);
        android.view.SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new com.otaliastudios.cameraview.preview.SurfaceCameraPreview.AnonymousClass1());
        this.e = inflate;
        return surfaceView;
    }
}
