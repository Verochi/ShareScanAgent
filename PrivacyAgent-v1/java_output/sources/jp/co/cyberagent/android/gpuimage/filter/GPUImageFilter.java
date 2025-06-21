package jp.co.cyberagent.android.gpuimage.filter;

/* loaded from: classes14.dex */
public class GPUImageFilter {
    public static final java.lang.String NO_FILTER_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    public static final java.lang.String NO_FILTER_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
    public final java.util.LinkedList<java.lang.Runnable> a;
    public final java.lang.String b;
    public final java.lang.String c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;

    /* renamed from: jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ int t;

        public AnonymousClass1(int i, int i2) {
            this.n = i;
            this.t = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.this.ifNeedInit();
            android.opengl.GLES20.glUniform1i(this.n, this.t);
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ float t;

        public AnonymousClass2(int i, float f) {
            this.n = i;
            this.t = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.this.ifNeedInit();
            android.opengl.GLES20.glUniform1f(this.n, this.t);
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ float[] t;

        public AnonymousClass3(int i, float[] fArr) {
            this.n = i;
            this.t = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.this.ifNeedInit();
            android.opengl.GLES20.glUniform2fv(this.n, 1, java.nio.FloatBuffer.wrap(this.t));
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ float[] t;

        public AnonymousClass4(int i, float[] fArr) {
            this.n = i;
            this.t = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.this.ifNeedInit();
            android.opengl.GLES20.glUniform3fv(this.n, 1, java.nio.FloatBuffer.wrap(this.t));
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ float[] t;

        public AnonymousClass5(int i, float[] fArr) {
            this.n = i;
            this.t = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.this.ifNeedInit();
            android.opengl.GLES20.glUniform4fv(this.n, 1, java.nio.FloatBuffer.wrap(this.t));
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ float[] t;

        public AnonymousClass6(int i, float[] fArr) {
            this.n = i;
            this.t = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.this.ifNeedInit();
            int i = this.n;
            float[] fArr = this.t;
            android.opengl.GLES20.glUniform1fv(i, fArr.length, java.nio.FloatBuffer.wrap(fArr));
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        public final /* synthetic */ android.graphics.PointF n;
        public final /* synthetic */ int t;

        public AnonymousClass7(android.graphics.PointF pointF, int i) {
            this.n = pointF;
            this.t = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.this.ifNeedInit();
            android.graphics.PointF pointF = this.n;
            android.opengl.GLES20.glUniform2fv(this.t, 1, new float[]{pointF.x, pointF.y}, 0);
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ float[] t;

        public AnonymousClass8(int i, float[] fArr) {
            this.n = i;
            this.t = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.this.ifNeedInit();
            android.opengl.GLES20.glUniformMatrix3fv(this.n, 1, false, this.t, 0);
        }
    }

    /* renamed from: jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        public final /* synthetic */ int n;
        public final /* synthetic */ float[] t;

        public AnonymousClass9(int i, float[] fArr) {
            this.n = i;
            this.t = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.this.ifNeedInit();
            android.opengl.GLES20.glUniformMatrix4fv(this.n, 1, false, this.t, 0);
        }
    }

    public GPUImageFilter() {
        this(NO_FILTER_VERTEX_SHADER, NO_FILTER_FRAGMENT_SHADER);
    }

    public GPUImageFilter(java.lang.String str, java.lang.String str2) {
        this.a = new java.util.LinkedList<>();
        this.b = str;
        this.c = str2;
    }

    public static java.lang.String convertStreamToString(java.io.InputStream inputStream) {
        java.util.Scanner useDelimiter = new java.util.Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static java.lang.String loadShader(java.lang.String str, android.content.Context context) {
        try {
            java.io.InputStream open = context.getAssets().open(str);
            java.lang.String convertStreamToString = convertStreamToString(open);
            open.close();
            return convertStreamToString;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final void a() {
        onInit();
        onInitialized();
    }

    public final void destroy() {
        this.j = false;
        android.opengl.GLES20.glDeleteProgram(this.d);
        onDestroy();
    }

    public int getAttribPosition() {
        return this.e;
    }

    public int getAttribTextureCoordinate() {
        return this.g;
    }

    public int getOutputHeight() {
        return this.i;
    }

    public int getOutputWidth() {
        return this.h;
    }

    public int getProgram() {
        return this.d;
    }

    public int getUniformTexture() {
        return this.f;
    }

    public void ifNeedInit() {
        if (this.j) {
            return;
        }
        a();
    }

    public boolean isInitialized() {
        return this.j;
    }

    public void onDestroy() {
    }

    public void onDraw(int i, java.nio.FloatBuffer floatBuffer, java.nio.FloatBuffer floatBuffer2) {
        android.opengl.GLES20.glUseProgram(this.d);
        runPendingOnDrawTasks();
        if (this.j) {
            floatBuffer.position(0);
            android.opengl.GLES20.glVertexAttribPointer(this.e, 2, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, 0, (java.nio.Buffer) floatBuffer);
            android.opengl.GLES20.glEnableVertexAttribArray(this.e);
            floatBuffer2.position(0);
            android.opengl.GLES20.glVertexAttribPointer(this.g, 2, com.badlogic.gdx.graphics.GL20.GL_FLOAT, false, 0, (java.nio.Buffer) floatBuffer2);
            android.opengl.GLES20.glEnableVertexAttribArray(this.g);
            if (i != -1) {
                android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0);
                android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, i);
                android.opengl.GLES20.glUniform1i(this.f, 0);
            }
            onDrawArraysPre();
            android.opengl.GLES20.glDrawArrays(5, 0, 4);
            android.opengl.GLES20.glDisableVertexAttribArray(this.e);
            android.opengl.GLES20.glDisableVertexAttribArray(this.g);
            android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0);
        }
    }

    public void onDrawArraysPre() {
    }

    public void onInit() {
        int loadProgram = jp.co.cyberagent.android.gpuimage.util.OpenGlUtils.loadProgram(this.b, this.c);
        this.d = loadProgram;
        this.e = android.opengl.GLES20.glGetAttribLocation(loadProgram, com.alibaba.sdk.android.oss.common.RequestParameters.POSITION);
        this.f = android.opengl.GLES20.glGetUniformLocation(this.d, "inputImageTexture");
        this.g = android.opengl.GLES20.glGetAttribLocation(this.d, "inputTextureCoordinate");
        this.j = true;
    }

    public void onInitialized() {
    }

    public void onOutputSizeChanged(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public void runOnDraw(java.lang.Runnable runnable) {
        synchronized (this.a) {
            this.a.addLast(runnable);
        }
    }

    public void runPendingOnDrawTasks() {
        while (!this.a.isEmpty()) {
            this.a.removeFirst().run();
        }
    }

    public void setFloat(int i, float f) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.AnonymousClass2(i, f));
    }

    public void setFloatArray(int i, float[] fArr) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.AnonymousClass6(i, fArr));
    }

    public void setFloatVec2(int i, float[] fArr) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.AnonymousClass3(i, fArr));
    }

    public void setFloatVec3(int i, float[] fArr) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.AnonymousClass4(i, fArr));
    }

    public void setFloatVec4(int i, float[] fArr) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.AnonymousClass5(i, fArr));
    }

    public void setInteger(int i, int i2) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.AnonymousClass1(i, i2));
    }

    public void setPoint(int i, android.graphics.PointF pointF) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.AnonymousClass7(pointF, i));
    }

    public void setUniformMatrix3f(int i, float[] fArr) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.AnonymousClass8(i, fArr));
    }

    public void setUniformMatrix4f(int i, float[] fArr) {
        runOnDraw(new jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter.AnonymousClass9(i, fArr));
    }
}
