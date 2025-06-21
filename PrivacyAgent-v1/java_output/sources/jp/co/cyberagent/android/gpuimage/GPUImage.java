package jp.co.cyberagent.android.gpuimage;

/* loaded from: classes14.dex */
public class GPUImage {
    public final android.content.Context a;
    public final jp.co.cyberagent.android.gpuimage.GPUImageRenderer b;
    public android.opengl.GLSurfaceView d;
    public jp.co.cyberagent.android.gpuimage.GLTextureView e;
    public jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter f;
    public android.graphics.Bitmap g;
    public int c = 0;
    public jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType h = jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_CROP;

    public class LoadImageFileTask extends jp.co.cyberagent.android.gpuimage.GPUImage.LoadImageTask {
        public final java.io.File e;

        public LoadImageFileTask(jp.co.cyberagent.android.gpuimage.GPUImage gPUImage, java.io.File file) {
            super(gPUImage);
            this.e = file;
        }

        @Override // jp.co.cyberagent.android.gpuimage.GPUImage.LoadImageTask
        public android.graphics.Bitmap b(android.graphics.BitmapFactory.Options options) {
            return android.graphics.BitmapFactory.decodeFile(this.e.getAbsolutePath(), options);
        }

        @Override // jp.co.cyberagent.android.gpuimage.GPUImage.LoadImageTask
        public int d() throws java.io.IOException {
            int attributeInt = new android.media.ExifInterface(this.e.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        }
    }

    public abstract class LoadImageTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, android.graphics.Bitmap> {
        public final jp.co.cyberagent.android.gpuimage.GPUImage a;
        public int b;
        public int c;

        public LoadImageTask(jp.co.cyberagent.android.gpuimage.GPUImage gPUImage) {
            this.a = gPUImage;
        }

        public final boolean a(boolean z, boolean z2) {
            return jp.co.cyberagent.android.gpuimage.GPUImage.this.h == jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_CROP ? z && z2 : z || z2;
        }

        public abstract android.graphics.Bitmap b(android.graphics.BitmapFactory.Options options);

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public android.graphics.Bitmap doInBackground(java.lang.Void... voidArr) {
            if (jp.co.cyberagent.android.gpuimage.GPUImage.this.b != null && jp.co.cyberagent.android.gpuimage.GPUImage.this.b.getFrameWidth() == 0) {
                try {
                    synchronized (jp.co.cyberagent.android.gpuimage.GPUImage.this.b.surfaceChangedWaiter) {
                        jp.co.cyberagent.android.gpuimage.GPUImage.this.b.surfaceChangedWaiter.wait(3000L);
                    }
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.b = jp.co.cyberagent.android.gpuimage.GPUImage.this.g();
            this.c = jp.co.cyberagent.android.gpuimage.GPUImage.this.f();
            return f();
        }

        public abstract int d() throws java.io.IOException;

        public final int[] e(int i, int i2) {
            float f;
            float f2;
            float f3 = i;
            float f4 = f3 / this.b;
            float f5 = i2;
            float f6 = f5 / this.c;
            if (jp.co.cyberagent.android.gpuimage.GPUImage.this.h != jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_CROP ? f4 < f6 : f4 > f6) {
                f2 = this.c;
                f = (f2 / f5) * f3;
            } else {
                float f7 = this.b;
                float f8 = (f7 / f3) * f5;
                f = f7;
                f2 = f8;
            }
            return new int[]{java.lang.Math.round(f), java.lang.Math.round(f2)};
        }

        public final android.graphics.Bitmap f() {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            b(options);
            int i = 1;
            while (true) {
                if (!a(options.outWidth / i > this.b, options.outHeight / i > this.c)) {
                    break;
                }
                i++;
            }
            int i2 = i - 1;
            if (i2 < 1) {
                i2 = 1;
            }
            android.graphics.BitmapFactory.Options options2 = new android.graphics.BitmapFactory.Options();
            options2.inSampleSize = i2;
            options2.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
            options2.inPurgeable = true;
            options2.inTempStorage = new byte[32768];
            android.graphics.Bitmap b = b(options2);
            if (b == null) {
                return null;
            }
            return i(h(b));
        }

        @Override // android.os.AsyncTask
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(android.graphics.Bitmap bitmap) {
            super.onPostExecute(bitmap);
            this.a.deleteImage();
            this.a.setImage(bitmap);
        }

        public final android.graphics.Bitmap h(android.graphics.Bitmap bitmap) {
            android.graphics.Bitmap bitmap2;
            java.io.IOException e;
            int d;
            if (bitmap == null) {
                return null;
            }
            try {
                d = d();
            } catch (java.io.IOException e2) {
                bitmap2 = bitmap;
                e = e2;
            }
            if (d == 0) {
                return bitmap;
            }
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.postRotate(d);
            bitmap2 = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            try {
                bitmap.recycle();
            } catch (java.io.IOException e3) {
                e = e3;
                e.printStackTrace();
                return bitmap2;
            }
            return bitmap2;
        }

        public final android.graphics.Bitmap i(android.graphics.Bitmap bitmap) {
            int[] e = e(bitmap.getWidth(), bitmap.getHeight());
            android.graphics.Bitmap createScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmap, e[0], e[1], true);
            if (createScaledBitmap != bitmap) {
                bitmap.recycle();
                java.lang.System.gc();
                bitmap = createScaledBitmap;
            }
            if (jp.co.cyberagent.android.gpuimage.GPUImage.this.h != jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType.CENTER_CROP) {
                return bitmap;
            }
            int i = e[0];
            int i2 = i - this.b;
            int i3 = e[1];
            int i4 = i3 - this.c;
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap, i2 / 2, i4 / 2, i - i2, i3 - i4);
            if (createBitmap == bitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        }
    }

    public class LoadImageUriTask extends jp.co.cyberagent.android.gpuimage.GPUImage.LoadImageTask {
        public final android.net.Uri e;

        public LoadImageUriTask(jp.co.cyberagent.android.gpuimage.GPUImage gPUImage, android.net.Uri uri) {
            super(gPUImage);
            this.e = uri;
        }

        @Override // jp.co.cyberagent.android.gpuimage.GPUImage.LoadImageTask
        public android.graphics.Bitmap b(android.graphics.BitmapFactory.Options options) {
            java.io.InputStream openStream;
            try {
                if (!this.e.getScheme().startsWith(com.alipay.sdk.m.l.a.q) && !this.e.getScheme().startsWith("https")) {
                    openStream = this.e.getPath().startsWith("/android_asset/") ? jp.co.cyberagent.android.gpuimage.GPUImage.this.a.getAssets().open(this.e.getPath().substring(15)) : jp.co.cyberagent.android.gpuimage.GPUImage.this.a.getContentResolver().openInputStream(this.e);
                    return android.graphics.BitmapFactory.decodeStream(openStream, null, options);
                }
                openStream = new java.net.URL(this.e.toString()).openStream();
                return android.graphics.BitmapFactory.decodeStream(openStream, null, options);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // jp.co.cyberagent.android.gpuimage.GPUImage.LoadImageTask
        public int d() throws java.io.IOException {
            android.database.Cursor query = jp.co.cyberagent.android.gpuimage.GPUImage.this.a.getContentResolver().query(this.e, new java.lang.String[]{"orientation"}, null, null, null);
            if (query == null || query.getCount() != 1) {
                return 0;
            }
            query.moveToFirst();
            int i = query.getInt(0);
            query.close();
            return i;
        }
    }

    public interface OnPictureSavedListener {
        void onPictureSaved(android.net.Uri uri);
    }

    public interface ResponseListener<T> {
        void response(T t);
    }

    public enum ScaleType {
        CENTER_INSIDE,
        CENTER_CROP
    }

    public GPUImage(android.content.Context context) {
        if (!h(context)) {
            throw new java.lang.IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
        }
        this.a = context;
        this.f = new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter();
        this.b = new jp.co.cyberagent.android.gpuimage.GPUImageRenderer(this.f);
    }

    public void deleteImage() {
        this.b.deleteImage();
        this.g = null;
        requestRender();
    }

    public final int f() {
        jp.co.cyberagent.android.gpuimage.GPUImageRenderer gPUImageRenderer = this.b;
        if (gPUImageRenderer != null && gPUImageRenderer.getFrameHeight() != 0) {
            return this.b.getFrameHeight();
        }
        android.graphics.Bitmap bitmap = this.g;
        return bitmap != null ? bitmap.getHeight() : ((android.view.WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public final int g() {
        jp.co.cyberagent.android.gpuimage.GPUImageRenderer gPUImageRenderer = this.b;
        if (gPUImageRenderer != null && gPUImageRenderer.getFrameWidth() != 0) {
            return this.b.getFrameWidth();
        }
        android.graphics.Bitmap bitmap = this.g;
        return bitmap != null ? bitmap.getWidth() : ((android.view.WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public final boolean h(android.content.Context context) {
        return ((android.app.ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public void requestRender() {
        jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView;
        int i = this.c;
        if (i == 0) {
            android.opengl.GLSurfaceView gLSurfaceView = this.d;
            if (gLSurfaceView != null) {
                gLSurfaceView.requestRender();
                return;
            }
            return;
        }
        if (i != 1 || (gLTextureView = this.e) == null) {
            return;
        }
        gLTextureView.requestRender();
    }

    public void saveToPictures(android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2, jp.co.cyberagent.android.gpuimage.GPUImage.OnPictureSavedListener onPictureSavedListener) {
    }

    public void saveToPictures(java.lang.String str, java.lang.String str2, jp.co.cyberagent.android.gpuimage.GPUImage.OnPictureSavedListener onPictureSavedListener) {
        saveToPictures(this.g, str, str2, onPictureSavedListener);
    }

    public void setBackgroundColor(float f, float f2, float f3) {
        this.b.setBackgroundColor(f, f2, f3);
    }

    public void setFilter(jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter gPUImageFilter) {
        this.f = gPUImageFilter;
        this.b.setFilter(gPUImageFilter);
        requestRender();
    }

    public void setGLSurfaceView(android.opengl.GLSurfaceView gLSurfaceView) {
        this.c = 0;
        this.d = gLSurfaceView;
        gLSurfaceView.setEGLContextClientVersion(2);
        this.d.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.d.getHolder().setFormat(1);
        this.d.setRenderer(this.b);
        this.d.setRenderMode(0);
        this.d.requestRender();
    }

    public void setGLTextureView(jp.co.cyberagent.android.gpuimage.GLTextureView gLTextureView) {
        this.c = 1;
        this.e = gLTextureView;
        gLTextureView.setEGLContextClientVersion(2);
        this.e.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.e.setOpaque(false);
        this.e.setRenderer(this.b);
        this.e.setRenderMode(0);
        this.e.requestRender();
    }

    public void setImage(android.graphics.Bitmap bitmap) {
        this.g = bitmap;
        this.b.setImageBitmap(bitmap, false);
        requestRender();
    }

    public void setImage(android.net.Uri uri) {
        new jp.co.cyberagent.android.gpuimage.GPUImage.LoadImageUriTask(this, uri).execute(new java.lang.Void[0]);
    }

    public void setImage(java.io.File file) {
        new jp.co.cyberagent.android.gpuimage.GPUImage.LoadImageFileTask(this, file).execute(new java.lang.Void[0]);
    }

    public void setRotation(jp.co.cyberagent.android.gpuimage.util.Rotation rotation) {
        this.b.setRotation(rotation);
    }

    public void setRotation(jp.co.cyberagent.android.gpuimage.util.Rotation rotation, boolean z, boolean z2) {
        this.b.setRotation(rotation, z, z2);
    }

    public void setScaleType(jp.co.cyberagent.android.gpuimage.GPUImage.ScaleType scaleType) {
        this.h = scaleType;
        this.b.setScaleType(scaleType);
        this.b.deleteImage();
        this.g = null;
        requestRender();
    }

    @java.lang.Deprecated
    public void setUpCamera(android.hardware.Camera camera) {
        setUpCamera(camera, 0, false, false);
    }

    @java.lang.Deprecated
    public void setUpCamera(android.hardware.Camera camera, int i, boolean z, boolean z2) {
        int i2 = this.c;
        if (i2 == 0) {
            this.d.setRenderMode(1);
        } else if (i2 == 1) {
            this.e.setRenderMode(1);
        }
        this.b.setUpSurfaceTexture(camera);
        jp.co.cyberagent.android.gpuimage.util.Rotation rotation = jp.co.cyberagent.android.gpuimage.util.Rotation.NORMAL;
        if (i == 90) {
            rotation = jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_90;
        } else if (i == 180) {
            rotation = jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_180;
        } else if (i == 270) {
            rotation = jp.co.cyberagent.android.gpuimage.util.Rotation.ROTATION_270;
        }
        this.b.setRotationCamera(rotation, z, z2);
    }

    public void updatePreviewFrame(byte[] bArr, int i, int i2) {
        this.b.onPreviewFrame(bArr, i, i2);
    }
}
