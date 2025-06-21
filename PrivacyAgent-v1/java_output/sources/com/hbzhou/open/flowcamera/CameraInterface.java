package com.hbzhou.open.flowcamera;

/* loaded from: classes22.dex */
public class CameraInterface implements android.hardware.Camera.PreviewCallback {
    public static final int TYPE_CAPTURE = 145;
    public static final int TYPE_RECORDER = 144;
    public static volatile com.hbzhou.open.flowcamera.CameraInterface W;
    public android.media.MediaRecorder B;
    public java.lang.String C;
    public java.lang.String D;
    public java.lang.String E;
    public com.hbzhou.open.flowcamera.listener.ErrorListener G;
    public android.widget.ImageView H;
    public android.widget.ImageView I;
    public int J;
    public int K;
    public byte[] O;
    public int U;
    public android.hardware.Camera n;
    public android.hardware.Camera.Parameters t;
    public int v;
    public boolean u = false;
    public int w = -1;
    public int x = -1;
    public android.view.SurfaceHolder y = null;
    public float z = -1.0f;
    public boolean A = false;
    public android.graphics.Bitmap F = null;
    public int L = 0;
    public int M = 90;
    public int N = 0;
    public int P = 0;
    public int Q = 0;
    public int R = com.hbzhou.open.flowcamera.JCameraView.MEDIA_QUALITY_MIDDLE;
    public android.hardware.SensorManager S = null;
    public android.hardware.SensorEventListener T = new com.hbzhou.open.flowcamera.CameraInterface.AnonymousClass1();
    public int V = 0;

    /* renamed from: com.hbzhou.open.flowcamera.CameraInterface$1, reason: invalid class name */
    public class AnonymousClass1 implements android.hardware.SensorEventListener {
        public AnonymousClass1() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
            if (1 != sensorEvent.sensor.getType()) {
                return;
            }
            float[] fArr = sensorEvent.values;
            com.hbzhou.open.flowcamera.CameraInterface.this.L = com.hbzhou.open.flowcamera.util.AngleUtil.getSensorAngle(fArr[0], fArr[1]);
            com.hbzhou.open.flowcamera.CameraInterface.this.o();
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CameraInterface$2, reason: invalid class name */
    public class AnonymousClass2 implements android.hardware.Camera.PictureCallback {
        public final /* synthetic */ com.hbzhou.open.flowcamera.CameraInterface.TakePictureCallback a;

        public AnonymousClass2(com.hbzhou.open.flowcamera.CameraInterface.TakePictureCallback takePictureCallback) {
            this.a = takePictureCallback;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, android.hardware.Camera camera) {
            android.graphics.Bitmap decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            if (com.hbzhou.open.flowcamera.CameraInterface.this.v == com.hbzhou.open.flowcamera.CameraInterface.this.w) {
                matrix.setRotate(com.hbzhou.open.flowcamera.CameraInterface.this.U);
            } else if (com.hbzhou.open.flowcamera.CameraInterface.this.v == com.hbzhou.open.flowcamera.CameraInterface.this.x) {
                matrix.setRotate(360 - com.hbzhou.open.flowcamera.CameraInterface.this.U);
                matrix.postScale(-1.0f, 1.0f);
            }
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            if (this.a != null) {
                if (com.hbzhou.open.flowcamera.CameraInterface.this.U == 90 || com.hbzhou.open.flowcamera.CameraInterface.this.U == 270) {
                    this.a.captureResult(createBitmap, true);
                } else {
                    this.a.captureResult(createBitmap, false);
                }
            }
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CameraInterface$3, reason: invalid class name */
    public class AnonymousClass3 implements android.hardware.Camera.AutoFocusCallback {
        public final /* synthetic */ java.lang.String a;
        public final /* synthetic */ com.hbzhou.open.flowcamera.CameraInterface.FocusCallback b;
        public final /* synthetic */ android.content.Context c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;

        public AnonymousClass3(java.lang.String str, com.hbzhou.open.flowcamera.CameraInterface.FocusCallback focusCallback, android.content.Context context, float f, float f2) {
            this.a = str;
            this.b = focusCallback;
            this.c = context;
            this.d = f;
            this.e = f2;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, android.hardware.Camera camera) {
            com.hbzhou.open.flowcamera.CameraInterface cameraInterface;
            int i;
            if (!z && (i = (cameraInterface = com.hbzhou.open.flowcamera.CameraInterface.this).V) <= 10) {
                cameraInterface.V = i + 1;
                cameraInterface.handleFocus(this.c, this.d, this.e, this.b);
                return;
            }
            android.hardware.Camera.Parameters parameters = camera.getParameters();
            parameters.setFocusMode(this.a);
            camera.setParameters(parameters);
            com.hbzhou.open.flowcamera.CameraInterface.this.V = 0;
            this.b.focusSuccess();
        }
    }

    public interface CameraOpenOverCallback {
        void cameraHasOpened();
    }

    public interface ErrorCallback {
    }

    public interface FocusCallback {
        void focusSuccess();
    }

    public interface StopRecordCallback {
        void recordResult(java.lang.String str, android.graphics.Bitmap bitmap);
    }

    public interface TakePictureCallback {
        void captureResult(android.graphics.Bitmap bitmap, boolean z);
    }

    public CameraInterface() {
        this.v = -1;
        k();
        this.v = this.w;
        this.D = "";
    }

    public static void destroyCameraInterface() {
        if (W != null) {
            W = null;
        }
    }

    public static android.graphics.Rect g(float f, float f2, float f3, android.content.Context context) {
        int screenWidth = (int) (((f / com.hbzhou.open.flowcamera.util.ScreenUtils.getScreenWidth(context)) * 2000.0f) - 1000.0f);
        int screenHeight = (int) (((f2 / com.hbzhou.open.flowcamera.util.ScreenUtils.getScreenHeight(context)) * 2000.0f) - 1000.0f);
        int intValue = java.lang.Float.valueOf(f3 * 300.0f).intValue() / 2;
        android.graphics.RectF rectF = new android.graphics.RectF(h(screenWidth - intValue, -1000, 1000), h(screenHeight - intValue, -1000, 1000), r2 + r4, r3 + r4);
        return new android.graphics.Rect(java.lang.Math.round(rectF.left), java.lang.Math.round(rectF.top), java.lang.Math.round(rectF.right), java.lang.Math.round(rectF.bottom));
    }

    public static synchronized com.hbzhou.open.flowcamera.CameraInterface getInstance() {
        com.hbzhou.open.flowcamera.CameraInterface cameraInterface;
        synchronized (com.hbzhou.open.flowcamera.CameraInterface.class) {
            if (W == null) {
                synchronized (com.hbzhou.open.flowcamera.CameraInterface.class) {
                    if (W == null) {
                        W = new com.hbzhou.open.flowcamera.CameraInterface();
                    }
                }
            }
            cameraInterface = W;
        }
        return cameraInterface;
    }

    public static int h(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public void doStartPreview(android.view.SurfaceHolder surfaceHolder, float f) {
        if (this.u) {
            com.hbzhou.open.flowcamera.util.LogUtil.i("doStartPreview isPreviewing");
        }
        if (this.z < 0.0f) {
            this.z = f;
        }
        if (surfaceHolder == null) {
            return;
        }
        this.y = surfaceHolder;
        android.hardware.Camera camera = this.n;
        if (camera != null) {
            try {
                this.t = camera.getParameters();
                android.hardware.Camera.Size previewSize = com.hbzhou.open.flowcamera.util.CameraParamUtil.getInstance().getPreviewSize(this.t.getSupportedPreviewSizes(), 1000, f);
                android.hardware.Camera.Size pictureSize = com.hbzhou.open.flowcamera.util.CameraParamUtil.getInstance().getPictureSize(this.t.getSupportedPictureSizes(), com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS, f);
                this.t.setPreviewSize(previewSize.width, previewSize.height);
                this.J = previewSize.width;
                this.K = previewSize.height;
                this.t.setPictureSize(pictureSize.width, pictureSize.height);
                if (com.hbzhou.open.flowcamera.util.CameraParamUtil.getInstance().isSupportedFocusMode(this.t.getSupportedFocusModes(), "auto")) {
                    this.t.setFocusMode("auto");
                }
                if (com.hbzhou.open.flowcamera.util.CameraParamUtil.getInstance().isSupportedPictureFormats(this.t.getSupportedPictureFormats(), 256)) {
                    this.t.setPictureFormat(256);
                    this.t.setJpegQuality(100);
                }
                this.n.setParameters(this.t);
                this.t = this.n.getParameters();
                this.n.setPreviewDisplay(surfaceHolder);
                this.n.setDisplayOrientation(this.M);
                this.n.setPreviewCallback(this);
                this.n.startPreview();
                this.u = true;
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void doStopPreview() {
        android.hardware.Camera camera = this.n;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.n.stopPreview();
                this.n.setPreviewDisplay(null);
                this.u = false;
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleFocus(android.content.Context context, float f, float f2, com.hbzhou.open.flowcamera.CameraInterface.FocusCallback focusCallback) {
        android.hardware.Camera camera = this.n;
        if (camera == null) {
            return;
        }
        android.hardware.Camera.Parameters parameters = camera.getParameters();
        android.graphics.Rect g = g(f, f2, 1.0f, context);
        this.n.cancelAutoFocus();
        if (parameters.getMaxNumFocusAreas() <= 0) {
            focusCallback.focusSuccess();
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new android.hardware.Camera.Area(g, 800));
        parameters.setFocusAreas(arrayList);
        java.lang.String focusMode = parameters.getFocusMode();
        try {
            parameters.setFocusMode("auto");
            this.n.setParameters(parameters);
            this.n.autoFocus(new com.hbzhou.open.flowcamera.CameraInterface.AnonymousClass3(focusMode, focusCallback, context, f, f2));
        } catch (java.lang.Exception unused) {
        }
    }

    public void i() {
        this.G = null;
        android.hardware.Camera camera = this.n;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.H = null;
                this.I = null;
                this.n.stopPreview();
                this.n.setPreviewDisplay(null);
                this.y = null;
                this.u = false;
                this.n.release();
                this.n = null;
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void j(com.hbzhou.open.flowcamera.CameraInterface.CameraOpenOverCallback cameraOpenOverCallback) {
        com.hbzhou.open.flowcamera.listener.ErrorListener errorListener;
        if (android.os.Build.VERSION.SDK_INT < 23 && !com.hbzhou.open.flowcamera.util.CheckPermission.isCameraUseable(this.v) && (errorListener = this.G) != null) {
            errorListener.onError();
            return;
        }
        if (this.n == null) {
            m(this.v);
        }
        cameraOpenOverCallback.cameraHasOpened();
    }

    public final void k() {
        android.hardware.Camera.CameraInfo cameraInfo = new android.hardware.Camera.CameraInfo();
        int numberOfCameras = android.hardware.Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            android.hardware.Camera.getCameraInfo(i, cameraInfo);
            int i2 = cameraInfo.facing;
            if (i2 == 0) {
                this.w = i2;
            } else if (i2 == 1) {
                this.x = i2;
            }
        }
    }

    public void l(boolean z) {
        this.u = z;
    }

    public final synchronized void m(int i) {
        try {
            this.n = android.hardware.Camera.open(i);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.hbzhou.open.flowcamera.listener.ErrorListener errorListener = this.G;
            if (errorListener != null) {
                errorListener.onError();
            }
        }
        android.hardware.Camera camera = this.n;
        if (camera != null) {
            try {
                camera.enableShutterSound(false);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void n(android.content.Context context) {
        if (this.S == null) {
            this.S = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
        }
        android.hardware.SensorManager sensorManager = this.S;
        sensorManager.registerListener(this.T, sensorManager.getDefaultSensor(1), 3);
    }

    public final void o() {
        int i;
        int i2;
        int i3;
        android.widget.ImageView imageView = this.H;
        if (imageView == null || (i = this.N) == (i2 = this.L)) {
            return;
        }
        if (i != 0) {
            i3 = 180;
            if (i == 90) {
                if (i2 != 0 && i2 == 180) {
                    i3 = com.autonavi.amap.mapcore.AMapEngineUtils.MIN_LONGITUDE_DEGREE;
                }
                i3 = 0;
            } else if (i != 180) {
                if (i != 270) {
                    r3 = 0;
                } else if (i2 == 0 || i2 != 180) {
                    r3 = 90;
                } else {
                    r3 = 90;
                }
                i3 = 0;
            } else {
                i3 = i2 != 90 ? i2 != 270 ? 0 : 90 : 270;
                r3 = 180;
            }
        } else {
            i3 = i2 != 90 ? i2 != 270 ? 0 : 90 : -90;
            r3 = 0;
        }
        float f = r3;
        float f2 = i3;
        android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(imageView, "rotation", f, f2);
        android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this.I, "rotation", f, f2);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(500L);
        animatorSet.start();
        this.N = this.L;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, android.hardware.Camera camera) {
        this.O = bArr;
    }

    public void p(com.hbzhou.open.flowcamera.listener.ErrorListener errorListener) {
        this.G = errorListener;
    }

    public void q(int i) {
        this.R = i;
    }

    public void r(java.lang.String str) {
        this.D = str;
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public void s(android.content.Context context) {
        if (this.S == null) {
            this.S = (android.hardware.SensorManager) context.getSystemService(com.umeng.analytics.pro.bo.ac);
        }
        this.S.unregisterListener(this.T);
    }

    public void setFlashMode(java.lang.String str) {
        android.hardware.Camera camera = this.n;
        if (camera == null) {
            return;
        }
        android.hardware.Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(str);
        this.n.setParameters(parameters);
    }

    public void setSwitchView(android.widget.ImageView imageView, android.widget.ImageView imageView2) {
        this.H = imageView;
        this.I = imageView2;
        if (imageView != null) {
            this.M = com.hbzhou.open.flowcamera.util.CameraParamUtil.getInstance().getCameraDisplayOrientation(imageView.getContext(), this.v);
        }
    }

    public void setZoom(float f, int i) {
        int i2;
        android.hardware.Camera camera = this.n;
        if (camera == null) {
            return;
        }
        if (this.t == null) {
            this.t = camera.getParameters();
        }
        if (this.t.isZoomSupported() && this.t.isSmoothZoomSupported()) {
            if (i == 144) {
                if (this.A && f >= 0.0f && (i2 = (int) (f / 40.0f)) <= this.t.getMaxZoom() && i2 >= this.P && this.Q != i2) {
                    this.t.setZoom(i2);
                    this.n.setParameters(this.t);
                    this.Q = i2;
                    return;
                }
                return;
            }
            if (i == 145 && !this.A) {
                int i3 = (int) (f / 50.0f);
                if (i3 < this.t.getMaxZoom()) {
                    int i4 = this.P + i3;
                    this.P = i4;
                    if (i4 < 0) {
                        this.P = 0;
                    } else if (i4 > this.t.getMaxZoom()) {
                        this.P = this.t.getMaxZoom();
                    }
                    this.t.setZoom(this.P);
                    this.n.setParameters(this.t);
                }
                com.hbzhou.open.flowcamera.util.LogUtil.i("setZoom = " + this.P);
            }
        }
    }

    public void startRecord(android.view.Surface surface, float f, com.hbzhou.open.flowcamera.CameraInterface.ErrorCallback errorCallback) {
        this.n.setPreviewCallback(null);
        int i = (this.L + 90) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
        android.hardware.Camera.Parameters parameters = this.n.getParameters();
        int i2 = parameters.getPreviewSize().width;
        int i3 = parameters.getPreviewSize().height;
        android.graphics.YuvImage yuvImage = new android.graphics.YuvImage(this.O, parameters.getPreviewFormat(), i2, i3, null);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        yuvImage.compressToJpeg(new android.graphics.Rect(0, 0, i2, i3), 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.F = android.graphics.BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        int i4 = this.v;
        if (i4 == this.w) {
            matrix.setRotate(i);
        } else if (i4 == this.x) {
            matrix.setRotate(270.0f);
        }
        android.graphics.Bitmap bitmap = this.F;
        this.F = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.F.getHeight(), matrix, true);
        if (this.A) {
            return;
        }
        if (this.n == null) {
            m(this.v);
        }
        if (this.B == null) {
            this.B = new android.media.MediaRecorder();
        }
        if (this.t == null) {
            this.t = this.n.getParameters();
        }
        if (this.t.getSupportedFocusModes().contains("continuous-video")) {
            this.t.setFocusMode("continuous-video");
        }
        this.n.setParameters(this.t);
        this.n.unlock();
        this.B.reset();
        this.B.setCamera(this.n);
        this.B.setVideoSource(1);
        this.B.setAudioSource(1);
        this.B.setOutputFormat(2);
        this.B.setVideoEncoder(2);
        this.B.setAudioEncoder(3);
        android.hardware.Camera.Size previewSize = this.t.getSupportedVideoSizes() == null ? com.hbzhou.open.flowcamera.util.CameraParamUtil.getInstance().getPreviewSize(this.t.getSupportedPreviewSizes(), 600, f) : com.hbzhou.open.flowcamera.util.CameraParamUtil.getInstance().getPreviewSize(this.t.getSupportedVideoSizes(), 600, f);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("setVideoSize    width = ");
        sb.append(previewSize.width);
        sb.append("height = ");
        sb.append(previewSize.height);
        int i5 = previewSize.width;
        int i6 = previewSize.height;
        if (i5 == i6) {
            this.B.setVideoSize(this.J, this.K);
        } else {
            this.B.setVideoSize(i5, i6);
        }
        if (this.v != this.x) {
            this.B.setOrientationHint(i);
        } else if (this.M == 270) {
            if (i == 0) {
                this.B.setOrientationHint(180);
            } else if (i == 270) {
                this.B.setOrientationHint(270);
            } else {
                this.B.setOrientationHint(90);
            }
        } else if (i == 90) {
            this.B.setOrientationHint(270);
        } else if (i == 270) {
            this.B.setOrientationHint(90);
        } else {
            this.B.setOrientationHint(i);
        }
        if (com.hbzhou.open.flowcamera.util.DeviceUtil.isHuaWeiRongyao()) {
            this.B.setVideoEncodingBitRate(com.hbzhou.open.flowcamera.JCameraView.MEDIA_QUALITY_FUNNY);
        } else {
            this.B.setVideoEncodingBitRate(this.R);
        }
        this.B.setPreviewDisplay(surface);
        this.C = "video_" + java.lang.System.currentTimeMillis() + ".mp4";
        if (this.D.equals("")) {
            this.D = com.moji.tool.FilePathUtil.getMojiDCIMPath();
        }
        java.lang.String str = this.D + java.io.File.separator + this.C;
        this.E = str;
        this.B.setOutputFile(str);
        try {
            this.B.prepare();
            this.B.start();
            this.A = true;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            com.hbzhou.open.flowcamera.listener.ErrorListener errorListener = this.G;
            if (errorListener != null) {
                errorListener.onError();
            }
        } catch (java.lang.IllegalStateException e2) {
            e2.printStackTrace();
            com.hbzhou.open.flowcamera.listener.ErrorListener errorListener2 = this.G;
            if (errorListener2 != null) {
                errorListener2.onError();
            }
        } catch (java.lang.RuntimeException unused) {
        }
    }

    public void stopRecord(boolean z, com.hbzhou.open.flowcamera.CameraInterface.StopRecordCallback stopRecordCallback) {
        android.media.MediaRecorder mediaRecorder;
        if (!this.A || (mediaRecorder = this.B) == null) {
            return;
        }
        mediaRecorder.setOnErrorListener(null);
        this.B.setOnInfoListener(null);
        this.B.setPreviewDisplay(null);
        try {
            try {
                this.B.stop();
            } catch (java.lang.RuntimeException e) {
                e.printStackTrace();
                this.B = null;
                android.media.MediaRecorder mediaRecorder2 = new android.media.MediaRecorder();
                this.B = mediaRecorder2;
            }
        } finally {
            android.media.MediaRecorder mediaRecorder3 = this.B;
            if (mediaRecorder3 != null) {
                mediaRecorder3.release();
            }
            this.B = null;
            this.A = false;
        }
        if (z) {
            if (com.hbzhou.open.flowcamera.util.FileUtil.deleteFile(this.E)) {
                stopRecordCallback.recordResult(null, null);
            }
        } else {
            doStopPreview();
            stopRecordCallback.recordResult(this.D + java.io.File.separator + this.C, this.F);
        }
    }

    public synchronized void switchCamera(android.view.SurfaceHolder surfaceHolder, float f) {
        int i = this.v;
        int i2 = this.w;
        if (i == i2) {
            this.v = this.x;
        } else {
            this.v = i2;
        }
        i();
        com.hbzhou.open.flowcamera.util.LogUtil.i("open start");
        m(this.v);
        android.hardware.Camera camera = this.n;
        if (camera != null) {
            try {
                camera.enableShutterSound(false);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        com.hbzhou.open.flowcamera.util.LogUtil.i("open end");
        doStartPreview(surfaceHolder, f);
    }

    public void takePicture(com.hbzhou.open.flowcamera.CameraInterface.TakePictureCallback takePictureCallback) {
        if (this.n == null) {
            return;
        }
        int i = this.M;
        if (i == 90) {
            this.U = java.lang.Math.abs(this.L + i) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
        } else if (i == 270) {
            this.U = java.lang.Math.abs(i - this.L);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.L);
        sb.append(" = ");
        sb.append(this.M);
        sb.append(" = ");
        sb.append(this.U);
        this.n.takePicture(null, null, new com.hbzhou.open.flowcamera.CameraInterface.AnonymousClass2(takePictureCallback));
    }
}
