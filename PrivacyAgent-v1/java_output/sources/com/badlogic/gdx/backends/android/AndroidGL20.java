package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class AndroidGL20 implements com.badlogic.gdx.graphics.GL20 {
    @Override // com.badlogic.gdx.graphics.GL20
    public void glActiveTexture(int i) {
        android.opengl.GLES20.glActiveTexture(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glAttachShader(int i, int i2) {
        android.opengl.GLES20.glAttachShader(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindAttribLocation(int i, int i2, java.lang.String str) {
        android.opengl.GLES20.glBindAttribLocation(i, i2, str);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindBuffer(int i, int i2) {
        android.opengl.GLES20.glBindBuffer(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindFramebuffer(int i, int i2) {
        android.opengl.GLES20.glBindFramebuffer(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindRenderbuffer(int i, int i2) {
        android.opengl.GLES20.glBindRenderbuffer(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindTexture(int i, int i2) {
        android.opengl.GLES20.glBindTexture(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendColor(float f, float f2, float f3, float f4) {
        android.opengl.GLES20.glBlendColor(f, f2, f3, f4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendEquation(int i) {
        android.opengl.GLES20.glBlendEquation(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendEquationSeparate(int i, int i2) {
        android.opengl.GLES20.glBlendEquationSeparate(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendFunc(int i, int i2) {
        android.opengl.GLES20.glBlendFunc(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendFuncSeparate(int i, int i2, int i3, int i4) {
        android.opengl.GLES20.glBlendFuncSeparate(i, i2, i3, i4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBufferData(int i, int i2, java.nio.Buffer buffer, int i3) {
        android.opengl.GLES20.glBufferData(i, i2, buffer, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBufferSubData(int i, int i2, int i3, java.nio.Buffer buffer) {
        android.opengl.GLES20.glBufferSubData(i, i2, i3, buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glCheckFramebufferStatus(int i) {
        return android.opengl.GLES20.glCheckFramebufferStatus(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClear(int i) {
        android.opengl.GLES20.glClear(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClearColor(float f, float f2, float f3, float f4) {
        android.opengl.GLES20.glClearColor(f, f2, f3, f4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClearDepthf(float f) {
        android.opengl.GLES20.glClearDepthf(f);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClearStencil(int i) {
        android.opengl.GLES20.glClearStencil(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glColorMask(boolean z, boolean z2, boolean z3, boolean z4) {
        android.opengl.GLES20.glColorMask(z, z2, z3, z4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCompileShader(int i) {
        android.opengl.GLES20.glCompileShader(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, java.nio.Buffer buffer) {
        android.opengl.GLES20.glCompressedTexImage2D(i, i2, i3, i4, i5, i6, i7, buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, java.nio.Buffer buffer) {
        android.opengl.GLES20.glCompressedTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCopyTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        android.opengl.GLES20.glCopyTexImage2D(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCopyTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        android.opengl.GLES20.glCopyTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glCreateProgram() {
        return android.opengl.GLES20.glCreateProgram();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glCreateShader(int i) {
        return android.opengl.GLES20.glCreateShader(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCullFace(int i) {
        android.opengl.GLES20.glCullFace(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteBuffer(int i) {
        android.opengl.GLES20.glDeleteBuffers(1, new int[]{i}, 0);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteBuffers(int i, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glDeleteBuffers(i, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteFramebuffer(int i) {
        android.opengl.GLES20.glDeleteBuffers(1, new int[]{i}, 0);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteFramebuffers(int i, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glDeleteFramebuffers(i, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteProgram(int i) {
        android.opengl.GLES20.glDeleteProgram(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteRenderbuffer(int i) {
        android.opengl.GLES20.glDeleteRenderbuffers(1, new int[]{i}, 0);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteRenderbuffers(int i, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glDeleteRenderbuffers(i, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteShader(int i) {
        android.opengl.GLES20.glDeleteShader(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteTexture(int i) {
        android.opengl.GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteTextures(int i, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glDeleteTextures(i, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDepthFunc(int i) {
        android.opengl.GLES20.glDepthFunc(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDepthMask(boolean z) {
        android.opengl.GLES20.glDepthMask(z);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDepthRangef(float f, float f2) {
        android.opengl.GLES20.glDepthRangef(f, f2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDetachShader(int i, int i2) {
        android.opengl.GLES20.glDetachShader(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDisable(int i) {
        android.opengl.GLES20.glDisable(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDisableVertexAttribArray(int i) {
        android.opengl.GLES20.glDisableVertexAttribArray(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDrawArrays(int i, int i2, int i3) {
        android.opengl.GLES20.glDrawArrays(i, i2, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDrawElements(int i, int i2, int i3, int i4) {
        android.opengl.GLES20.glDrawElements(i, i2, i3, i4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDrawElements(int i, int i2, int i3, java.nio.Buffer buffer) {
        android.opengl.GLES20.glDrawElements(i, i2, i3, buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glEnable(int i) {
        android.opengl.GLES20.glEnable(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glEnableVertexAttribArray(int i) {
        android.opengl.GLES20.glEnableVertexAttribArray(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFinish() {
        android.opengl.GLES20.glFinish();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFlush() {
        android.opengl.GLES20.glFlush();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFramebufferRenderbuffer(int i, int i2, int i3, int i4) {
        android.opengl.GLES20.glFramebufferRenderbuffer(i, i2, i3, i4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFramebufferTexture2D(int i, int i2, int i3, int i4, int i5) {
        android.opengl.GLES20.glFramebufferTexture2D(i, i2, i3, i4, i5);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFrontFace(int i) {
        android.opengl.GLES20.glFrontFace(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenBuffer() {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenBuffers(1, iArr, 0);
        return iArr[0];
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenBuffers(int i, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGenBuffers(i, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenFramebuffer() {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenFramebuffers(int i, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGenFramebuffers(i, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenRenderbuffer() {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenRenderbuffers(1, iArr, 0);
        return iArr[0];
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenRenderbuffers(int i, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGenRenderbuffers(i, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenTexture() {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenTextures(int i, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGenTextures(i, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenerateMipmap(int i) {
        android.opengl.GLES20.glGenerateMipmap(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetActiveAttrib(int i, int i2, java.nio.IntBuffer intBuffer, java.nio.Buffer buffer) {
        return android.opengl.GLES20.glGetActiveAttrib(i, i2, intBuffer, (java.nio.IntBuffer) buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetActiveUniform(int i, int i2, java.nio.IntBuffer intBuffer, java.nio.Buffer buffer) {
        return android.opengl.GLES20.glGetActiveUniform(i, i2, intBuffer, (java.nio.IntBuffer) buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetAttachedShaders(int i, int i2, java.nio.Buffer buffer, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGetAttachedShaders(i, i2, (java.nio.IntBuffer) buffer, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGetAttribLocation(int i, java.lang.String str) {
        return android.opengl.GLES20.glGetAttribLocation(i, str);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetBooleanv(int i, java.nio.Buffer buffer) {
        android.opengl.GLES20.glGetBooleanv(i, (java.nio.IntBuffer) buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetBufferParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGetBufferParameteriv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGetError() {
        return android.opengl.GLES20.glGetError();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetFloatv(int i, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glGetFloatv(i, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetFramebufferAttachmentParameteriv(int i, int i2, int i3, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGetFramebufferAttachmentParameteriv(i, i2, i3, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetIntegerv(int i, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGetIntegerv(i, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetProgramInfoLog(int i) {
        return android.opengl.GLES20.glGetProgramInfoLog(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetProgramiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGetProgramiv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetRenderbufferParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGetRenderbufferParameteriv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetShaderInfoLog(int i) {
        return android.opengl.GLES20.glGetShaderInfoLog(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetShaderPrecisionFormat(int i, int i2, java.nio.IntBuffer intBuffer, java.nio.IntBuffer intBuffer2) {
        android.opengl.GLES20.glGetShaderPrecisionFormat(i, i2, intBuffer, intBuffer2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetShaderiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGetShaderiv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetString(int i) {
        return android.opengl.GLES20.glGetString(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetTexParameterfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glGetTexParameterfv(i, i2, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetTexParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGetTexParameteriv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGetUniformLocation(int i, java.lang.String str) {
        return android.opengl.GLES20.glGetUniformLocation(i, str);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetUniformfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glGetUniformfv(i, i2, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetUniformiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGetUniformiv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetVertexAttribPointerv(int i, int i2, java.nio.Buffer buffer) {
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetVertexAttribfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glGetVertexAttribfv(i, i2, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetVertexAttribiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glGetVertexAttribiv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glHint(int i, int i2) {
        android.opengl.GLES20.glHint(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsBuffer(int i) {
        return android.opengl.GLES20.glIsBuffer(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsEnabled(int i) {
        return android.opengl.GLES20.glIsEnabled(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsFramebuffer(int i) {
        return android.opengl.GLES20.glIsFramebuffer(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsProgram(int i) {
        return android.opengl.GLES20.glIsProgram(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsRenderbuffer(int i) {
        return android.opengl.GLES20.glIsRenderbuffer(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsShader(int i) {
        return android.opengl.GLES20.glIsShader(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsTexture(int i) {
        return android.opengl.GLES20.glIsTexture(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glLineWidth(float f) {
        android.opengl.GLES20.glLineWidth(f);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glLinkProgram(int i) {
        android.opengl.GLES20.glLinkProgram(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glPixelStorei(int i, int i2) {
        android.opengl.GLES20.glPixelStorei(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glPolygonOffset(float f, float f2) {
        android.opengl.GLES20.glPolygonOffset(f, f2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, java.nio.Buffer buffer) {
        android.opengl.GLES20.glReadPixels(i, i2, i3, i4, i5, i6, buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glReleaseShaderCompiler() {
        android.opengl.GLES20.glReleaseShaderCompiler();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glRenderbufferStorage(int i, int i2, int i3, int i4) {
        android.opengl.GLES20.glRenderbufferStorage(i, i2, i3, i4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glSampleCoverage(float f, boolean z) {
        android.opengl.GLES20.glSampleCoverage(f, z);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glScissor(int i, int i2, int i3, int i4) {
        android.opengl.GLES20.glScissor(i, i2, i3, i4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glShaderBinary(int i, java.nio.IntBuffer intBuffer, int i2, java.nio.Buffer buffer, int i3) {
        android.opengl.GLES20.glShaderBinary(i, intBuffer, i2, buffer, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glShaderSource(int i, java.lang.String str) {
        android.opengl.GLES20.glShaderSource(i, str);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilFunc(int i, int i2, int i3) {
        android.opengl.GLES20.glStencilFunc(i, i2, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilFuncSeparate(int i, int i2, int i3, int i4) {
        android.opengl.GLES20.glStencilFuncSeparate(i, i2, i3, i4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilMask(int i) {
        android.opengl.GLES20.glStencilMask(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilMaskSeparate(int i, int i2) {
        android.opengl.GLES20.glStencilMaskSeparate(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilOp(int i, int i2, int i3) {
        android.opengl.GLES20.glStencilOp(i, i2, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilOpSeparate(int i, int i2, int i3, int i4) {
        android.opengl.GLES20.glStencilOpSeparate(i, i2, i3, i4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, java.nio.Buffer buffer) {
        android.opengl.GLES20.glTexImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameterf(int i, int i2, float f) {
        android.opengl.GLES20.glTexParameterf(i, i2, f);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameterfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glTexParameterfv(i, i2, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameteri(int i, int i2, int i3) {
        android.opengl.GLES20.glTexParameteri(i, i2, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glTexParameteriv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, java.nio.Buffer buffer) {
        android.opengl.GLES20.glTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1f(int i, float f) {
        android.opengl.GLES20.glUniform1f(i, f);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glUniform1fv(i, i2, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1fv(int i, int i2, float[] fArr, int i3) {
        android.opengl.GLES20.glUniform1fv(i, i2, fArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1i(int i, int i2) {
        android.opengl.GLES20.glUniform1i(i, i2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glUniform1iv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1iv(int i, int i2, int[] iArr, int i3) {
        android.opengl.GLES20.glUniform1iv(i, i2, iArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2f(int i, float f, float f2) {
        android.opengl.GLES20.glUniform2f(i, f, f2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glUniform2fv(i, i2, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2fv(int i, int i2, float[] fArr, int i3) {
        android.opengl.GLES20.glUniform2fv(i, i2, fArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2i(int i, int i2, int i3) {
        android.opengl.GLES20.glUniform2i(i, i2, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glUniform2iv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2iv(int i, int i2, int[] iArr, int i3) {
        android.opengl.GLES20.glUniform2iv(i, i2, iArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3f(int i, float f, float f2, float f3) {
        android.opengl.GLES20.glUniform3f(i, f, f2, f3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glUniform3fv(i, i2, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3fv(int i, int i2, float[] fArr, int i3) {
        android.opengl.GLES20.glUniform3fv(i, i2, fArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3i(int i, int i2, int i3, int i4) {
        android.opengl.GLES20.glUniform3i(i, i2, i3, i4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glUniform3iv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3iv(int i, int i2, int[] iArr, int i3) {
        android.opengl.GLES20.glUniform3iv(i, i2, iArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4f(int i, float f, float f2, float f3, float f4) {
        android.opengl.GLES20.glUniform4f(i, f, f2, f3, f4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glUniform4fv(i, i2, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4fv(int i, int i2, float[] fArr, int i3) {
        android.opengl.GLES20.glUniform4fv(i, i2, fArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4i(int i, int i2, int i3, int i4, int i5) {
        android.opengl.GLES20.glUniform4i(i, i2, i3, i4, i5);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        android.opengl.GLES20.glUniform4iv(i, i2, intBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4iv(int i, int i2, int[] iArr, int i3) {
        android.opengl.GLES20.glUniform4iv(i, i2, iArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix2fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glUniformMatrix2fv(i, i2, z, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix2fv(int i, int i2, boolean z, float[] fArr, int i3) {
        android.opengl.GLES20.glUniformMatrix2fv(i, i2, z, fArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix3fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glUniformMatrix3fv(i, i2, z, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix3fv(int i, int i2, boolean z, float[] fArr, int i3) {
        android.opengl.GLES20.glUniformMatrix3fv(i, i2, z, fArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix4fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glUniformMatrix4fv(i, i2, z, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix4fv(int i, int i2, boolean z, float[] fArr, int i3) {
        android.opengl.GLES20.glUniformMatrix4fv(i, i2, z, fArr, i3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUseProgram(int i) {
        android.opengl.GLES20.glUseProgram(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glValidateProgram(int i) {
        android.opengl.GLES20.glValidateProgram(i);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib1f(int i, float f) {
        android.opengl.GLES20.glVertexAttrib1f(i, f);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib1fv(int i, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glVertexAttrib1fv(i, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib2f(int i, float f, float f2) {
        android.opengl.GLES20.glVertexAttrib2f(i, f, f2);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib2fv(int i, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glVertexAttrib2fv(i, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib3f(int i, float f, float f2, float f3) {
        android.opengl.GLES20.glVertexAttrib3f(i, f, f2, f3);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib3fv(int i, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glVertexAttrib3fv(i, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib4f(int i, float f, float f2, float f3, float f4) {
        android.opengl.GLES20.glVertexAttrib4f(i, f, f2, f3, f4);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib4fv(int i, java.nio.FloatBuffer floatBuffer) {
        android.opengl.GLES20.glVertexAttrib4fv(i, floatBuffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, int i5) {
        android.opengl.GLES20.glVertexAttribPointer(i, i2, i3, z, i4, i5);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, java.nio.Buffer buffer) {
        android.opengl.GLES20.glVertexAttribPointer(i, i2, i3, z, i4, buffer);
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glViewport(int i, int i2, int i3, int i4) {
        android.opengl.GLES20.glViewport(i, i2, i3, i4);
    }
}
