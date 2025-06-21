package com.badlogic.gdx.backends.android.surfaceview;

/* loaded from: classes12.dex */
public class GdxEglConfigChooser implements com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLConfigChooser {
    public static final int EGL_COVERAGE_BUFFERS_NV = 12512;
    public static final int EGL_COVERAGE_SAMPLES_NV = 12513;
    protected int mAlphaSize;
    protected int mBlueSize;
    protected int mDepthSize;
    protected int mGreenSize;
    protected int mNumSamples;
    protected int mRedSize;
    protected int mStencilSize;
    public int[] a = new int[1];
    protected final int[] mConfigAttribs = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};

    public GdxEglConfigChooser(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mRedSize = i;
        this.mGreenSize = i2;
        this.mBlueSize = i3;
        this.mAlphaSize = i4;
        this.mDepthSize = i5;
        this.mStencilSize = i6;
        this.mNumSamples = i7;
    }

    public final int a(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, int i, int i2) {
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.a) ? this.a[0] : i2;
    }

    @Override // com.badlogic.gdx.backends.android.surfaceview.GLTextureView.EGLConfigChooser
    public javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplay, this.mConfigAttribs, null, 0, iArr);
        int i = iArr[0];
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("No configs match configSpec");
        }
        javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[i];
        egl10.eglChooseConfig(eGLDisplay, this.mConfigAttribs, eGLConfigArr, i, iArr);
        return chooseConfig(egl10, eGLDisplay, eGLConfigArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e2, code lost:
    
        if (r5 == r19.mAlphaSize) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr) {
        int i;
        javax.microedition.khronos.egl.EGLConfig eGLConfig;
        javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr2 = eGLConfigArr;
        int length = eGLConfigArr2.length;
        javax.microedition.khronos.egl.EGLConfig eGLConfig2 = null;
        javax.microedition.khronos.egl.EGLConfig eGLConfig3 = null;
        javax.microedition.khronos.egl.EGLConfig eGLConfig4 = null;
        int i2 = 0;
        while (i2 < length) {
            javax.microedition.khronos.egl.EGLConfig eGLConfig5 = eGLConfigArr2[i2];
            int a = a(egl10, eGLDisplay, eGLConfig5, 12325, 0);
            int a2 = a(egl10, eGLDisplay, eGLConfig5, 12326, 0);
            if (a < this.mDepthSize || a2 < this.mStencilSize) {
                i = length;
            } else {
                int a3 = a(egl10, eGLDisplay, eGLConfig5, 12324, 0);
                int a4 = a(egl10, eGLDisplay, eGLConfig5, 12323, 0);
                int a5 = a(egl10, eGLDisplay, eGLConfig5, 12322, 0);
                int a6 = a(egl10, eGLDisplay, eGLConfig5, 12321, 0);
                if (eGLConfig2 == null && a3 == 5 && a4 == 6 && a5 == 5 && a6 == 0) {
                    eGLConfig2 = eGLConfig5;
                }
                if (eGLConfig3 == null && a3 == this.mRedSize && a4 == this.mGreenSize && a5 == this.mBlueSize && a6 == this.mAlphaSize) {
                    eGLConfig3 = eGLConfig5;
                    if (this.mNumSamples == 0) {
                        break;
                    }
                }
                i = length;
                int a7 = a(egl10, eGLDisplay, eGLConfig5, 12338, 0);
                javax.microedition.khronos.egl.EGLConfig eGLConfig6 = eGLConfig2;
                int a8 = a(egl10, eGLDisplay, eGLConfig5, 12337, 0);
                if (eGLConfig4 == null && a7 == 1 && a8 >= this.mNumSamples && a3 == this.mRedSize && a4 == this.mGreenSize && a5 == this.mBlueSize && a6 == this.mAlphaSize) {
                    eGLConfig = eGLConfig3;
                } else {
                    eGLConfig = eGLConfig3;
                    int a9 = a(egl10, eGLDisplay, eGLConfig5, EGL_COVERAGE_BUFFERS_NV, 0);
                    int a10 = a(egl10, eGLDisplay, eGLConfig5, EGL_COVERAGE_SAMPLES_NV, 0);
                    if (eGLConfig4 == null) {
                        if (a9 == 1) {
                            if (a10 >= this.mNumSamples) {
                                if (a3 == this.mRedSize) {
                                    if (a4 == this.mGreenSize) {
                                        if (a5 == this.mBlueSize) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    eGLConfig3 = eGLConfig;
                    eGLConfig2 = eGLConfig6;
                }
                eGLConfig4 = eGLConfig5;
                eGLConfig3 = eGLConfig;
                eGLConfig2 = eGLConfig6;
            }
            i2++;
            eGLConfigArr2 = eGLConfigArr;
            length = i;
        }
        return eGLConfig4 != null ? eGLConfig4 : eGLConfig3 != null ? eGLConfig3 : eGLConfig2;
    }
}
