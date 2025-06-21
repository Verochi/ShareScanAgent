package jp.co.cyberagent.android.gpuimage.filter;

/* loaded from: classes14.dex */
public class GPUImageFilterGroup extends jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter {
    public java.util.List<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> k;
    public java.util.List<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> l;
    public int[] m;
    public int[] n;
    public final java.nio.FloatBuffer o;
    public final java.nio.FloatBuffer p;
    public final java.nio.FloatBuffer q;

    public GPUImageFilterGroup() {
        this(null);
    }

    public GPUImageFilterGroup(java.util.List<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> list) {
        this.k = list;
        if (list == null) {
            this.k = new java.util.ArrayList();
        } else {
            updateMergedFilters();
        }
        float[] fArr = jp.co.cyberagent.android.gpuimage.GPUImageRenderer.CUBE;
        java.nio.FloatBuffer asFloatBuffer = java.nio.ByteBuffer.allocateDirect(fArr.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        this.o = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = jp.co.cyberagent.android.gpuimage.util.TextureRotationUtil.TEXTURE_NO_ROTATION;
        java.nio.FloatBuffer asFloatBuffer2 = java.nio.ByteBuffer.allocateDirect(fArr2.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        this.p = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
        float[] rotation = jp.co.cyberagent.android.gpuimage.util.TextureRotationUtil.getRotation(jp.co.cyberagent.android.gpuimage.util.Rotation.NORMAL, false, true);
        java.nio.FloatBuffer asFloatBuffer3 = java.nio.ByteBuffer.allocateDirect(rotation.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        this.q = asFloatBuffer3;
        asFloatBuffer3.put(rotation).position(0);
    }

    public void addFilter(jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter gPUImageFilter) {
        if (gPUImageFilter == null) {
            return;
        }
        this.k.add(gPUImageFilter);
        updateMergedFilters();
    }

    public final void b() {
        int[] iArr = this.n;
        if (iArr != null) {
            android.opengl.GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.n = null;
        }
        int[] iArr2 = this.m;
        if (iArr2 != null) {
            android.opengl.GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.m = null;
        }
    }

    public java.util.List<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> getFilters() {
        return this.k;
    }

    public java.util.List<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> getMergedFilters() {
        return this.l;
    }

    @Override // jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
    public void onDestroy() {
        b();
        java.util.Iterator<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        super.onDestroy();
    }

    @Override // jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
    @android.annotation.SuppressLint({"WrongCall"})
    public void onDraw(int i, java.nio.FloatBuffer floatBuffer, java.nio.FloatBuffer floatBuffer2) {
        java.util.List<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> list;
        runPendingOnDrawTasks();
        if (!isInitialized() || this.m == null || this.n == null || (list = this.l) == null) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter gPUImageFilter = this.l.get(i2);
            int i3 = size - 1;
            boolean z = i2 < i3;
            if (z) {
                android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, this.m[i2]);
                android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            }
            if (i2 == 0) {
                gPUImageFilter.onDraw(i, floatBuffer, floatBuffer2);
            } else if (i2 == i3) {
                gPUImageFilter.onDraw(i, this.o, size % 2 == 0 ? this.q : this.p);
            } else {
                gPUImageFilter.onDraw(i, this.o, this.p);
            }
            if (z) {
                android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, 0);
                i = this.n[i2];
            }
            i2++;
        }
    }

    @Override // jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
    public void onInit() {
        super.onInit();
        java.util.Iterator<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().ifNeedInit();
        }
    }

    @Override // jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        if (this.m != null) {
            b();
        }
        int size = this.k.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.k.get(i3).onOutputSizeChanged(i, i2);
        }
        java.util.List<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> list = this.l;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i4 = 1;
        int size2 = this.l.size() - 1;
        this.m = new int[size2];
        this.n = new int[size2];
        int i5 = 0;
        while (i5 < size2) {
            android.opengl.GLES20.glGenFramebuffers(i4, this.m, i5);
            android.opengl.GLES20.glGenTextures(i4, this.n, i5);
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, this.n[i5]);
            android.opengl.GLES20.glTexImage2D(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0, com.badlogic.gdx.graphics.GL20.GL_RGBA, i, i2, 0, com.badlogic.gdx.graphics.GL20.GL_RGBA, com.badlogic.gdx.graphics.GL20.GL_UNSIGNED_BYTE, null);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 10240, 9729.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_MIN_FILTER, 9729.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_S, 33071.0f);
            android.opengl.GLES20.glTexParameterf(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_WRAP_T, 33071.0f);
            android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, this.m[i5]);
            android.opengl.GLES20.glFramebufferTexture2D(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, com.badlogic.gdx.graphics.GL20.GL_COLOR_ATTACHMENT0, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, this.n[i5], 0);
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0);
            android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, 0);
            i5++;
            i4 = 1;
        }
    }

    public void updateMergedFilters() {
        if (this.k == null) {
            return;
        }
        java.util.List<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> list = this.l;
        if (list == null) {
            this.l = new java.util.ArrayList();
        } else {
            list.clear();
        }
        for (jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter gPUImageFilter : this.k) {
            if (gPUImageFilter instanceof jp.co.cyberagent.android.gpuimage.filter.GPUImageFilterGroup) {
                jp.co.cyberagent.android.gpuimage.filter.GPUImageFilterGroup gPUImageFilterGroup = (jp.co.cyberagent.android.gpuimage.filter.GPUImageFilterGroup) gPUImageFilter;
                gPUImageFilterGroup.updateMergedFilters();
                java.util.List<jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter> mergedFilters = gPUImageFilterGroup.getMergedFilters();
                if (mergedFilters != null && !mergedFilters.isEmpty()) {
                    this.l.addAll(mergedFilters);
                }
            } else {
                this.l.add(gPUImageFilter);
            }
        }
    }
}
