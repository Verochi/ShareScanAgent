package com.badlogic.gdx.graphics.profiling;

/* loaded from: classes12.dex */
public class GL20Profiler extends com.badlogic.gdx.graphics.profiling.GLProfiler implements com.badlogic.gdx.graphics.GL20 {
    public final com.badlogic.gdx.graphics.GL20 gl20;

    public GL20Profiler(com.badlogic.gdx.graphics.GL20 gl20) {
        this.gl20 = gl20;
    }

    public final void a() {
        int glGetError = this.gl20.glGetError();
        while (glGetError != 0) {
            com.badlogic.gdx.graphics.profiling.GLProfiler.listener.onError(glGetError);
            glGetError = this.gl20.glGetError();
        }
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glActiveTexture(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glActiveTexture(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glAttachShader(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glAttachShader(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindAttribLocation(int i, int i2, java.lang.String str) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBindAttribLocation(i, i2, str);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindBuffer(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBindBuffer(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindFramebuffer(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBindFramebuffer(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindRenderbuffer(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBindRenderbuffer(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindTexture(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.textureBindings++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBindTexture(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendColor(float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBlendColor(f, f2, f3, f4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendEquation(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBlendEquation(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendEquationSeparate(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBlendEquationSeparate(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendFunc(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBlendFunc(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendFuncSeparate(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBlendFuncSeparate(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBufferData(int i, int i2, java.nio.Buffer buffer, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBufferData(i, i2, buffer, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBufferSubData(int i, int i2, int i3, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glBufferSubData(i, i2, i3, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glCheckFramebufferStatus(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glCheckFramebufferStatus = this.gl20.glCheckFramebufferStatus(i);
        a();
        return glCheckFramebufferStatus;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClear(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glClear(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClearColor(float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glClearColor(f, f2, f3, f4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClearDepthf(float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glClearDepthf(f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClearStencil(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glClearStencil(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glColorMask(boolean z, boolean z2, boolean z3, boolean z4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glColorMask(z, z2, z3, z4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCompileShader(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glCompileShader(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glCompressedTexImage2D(i, i2, i3, i4, i5, i6, i7, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glCompressedTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCopyTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glCopyTexImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCopyTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glCopyTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glCreateProgram() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glCreateProgram = this.gl20.glCreateProgram();
        a();
        return glCreateProgram;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glCreateShader(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glCreateShader = this.gl20.glCreateShader(i);
        a();
        return glCreateShader;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCullFace(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glCullFace(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteBuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDeleteBuffer(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteBuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDeleteBuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteFramebuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDeleteFramebuffer(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteFramebuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDeleteFramebuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteProgram(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDeleteProgram(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteRenderbuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDeleteRenderbuffer(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteRenderbuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDeleteRenderbuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteShader(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDeleteShader(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteTexture(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDeleteTexture(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteTextures(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDeleteTextures(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDepthFunc(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDepthFunc(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDepthMask(boolean z) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDepthMask(z);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDepthRangef(float f, float f2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDepthRangef(f, f2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDetachShader(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDetachShader(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDisable(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDisable(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDisableVertexAttribArray(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDisableVertexAttribArray(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDrawArrays(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.vertexCount.put(i3);
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDrawArrays(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDrawElements(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.vertexCount.put(i2);
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDrawElements(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDrawElements(int i, int i2, int i3, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.vertexCount.put(i2);
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glDrawElements(i, i2, i3, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glEnable(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glEnable(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glEnableVertexAttribArray(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glEnableVertexAttribArray(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFinish() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glFinish();
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFlush() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glFlush();
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFramebufferRenderbuffer(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glFramebufferRenderbuffer(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFramebufferTexture2D(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glFramebufferTexture2D(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFrontFace(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glFrontFace(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenBuffer() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGenBuffer = this.gl20.glGenBuffer();
        a();
        return glGenBuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenBuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGenBuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenFramebuffer() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGenFramebuffer = this.gl20.glGenFramebuffer();
        a();
        return glGenFramebuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenFramebuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGenFramebuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenRenderbuffer() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGenRenderbuffer = this.gl20.glGenRenderbuffer();
        a();
        return glGenRenderbuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenRenderbuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGenRenderbuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenTexture() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGenTexture = this.gl20.glGenTexture();
        a();
        return glGenTexture;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenTextures(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGenTextures(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenerateMipmap(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGenerateMipmap(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetActiveAttrib(int i, int i2, java.nio.IntBuffer intBuffer, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetActiveAttrib = this.gl20.glGetActiveAttrib(i, i2, intBuffer, buffer);
        a();
        return glGetActiveAttrib;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetActiveUniform(int i, int i2, java.nio.IntBuffer intBuffer, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetActiveUniform = this.gl20.glGetActiveUniform(i, i2, intBuffer, buffer);
        a();
        return glGetActiveUniform;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetAttachedShaders(int i, int i2, java.nio.Buffer buffer, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetAttachedShaders(i, i2, buffer, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGetAttribLocation(int i, java.lang.String str) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGetAttribLocation = this.gl20.glGetAttribLocation(i, str);
        a();
        return glGetAttribLocation;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetBooleanv(int i, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetBooleanv(i, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetBufferParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetBufferParameteriv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGetError() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        return this.gl20.glGetError();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetFloatv(int i, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetFloatv(i, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetFramebufferAttachmentParameteriv(int i, int i2, int i3, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetFramebufferAttachmentParameteriv(i, i2, i3, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetIntegerv(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetIntegerv(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetProgramInfoLog(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetProgramInfoLog = this.gl20.glGetProgramInfoLog(i);
        a();
        return glGetProgramInfoLog;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetProgramiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetProgramiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetRenderbufferParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetRenderbufferParameteriv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetShaderInfoLog(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetShaderInfoLog = this.gl20.glGetShaderInfoLog(i);
        a();
        return glGetShaderInfoLog;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetShaderPrecisionFormat(int i, int i2, java.nio.IntBuffer intBuffer, java.nio.IntBuffer intBuffer2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetShaderPrecisionFormat(i, i2, intBuffer, intBuffer2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetShaderiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetShaderiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetString(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetString = this.gl20.glGetString(i);
        a();
        return glGetString;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetTexParameterfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetTexParameterfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetTexParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetTexParameteriv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGetUniformLocation(int i, java.lang.String str) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGetUniformLocation = this.gl20.glGetUniformLocation(i, str);
        a();
        return glGetUniformLocation;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetUniformfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetUniformfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetUniformiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetUniformiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetVertexAttribPointerv(int i, int i2, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetVertexAttribPointerv(i, i2, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetVertexAttribfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetVertexAttribfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetVertexAttribiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glGetVertexAttribiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glHint(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glHint(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsBuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsBuffer = this.gl20.glIsBuffer(i);
        a();
        return glIsBuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsEnabled(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsEnabled = this.gl20.glIsEnabled(i);
        a();
        return glIsEnabled;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsFramebuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsFramebuffer = this.gl20.glIsFramebuffer(i);
        a();
        return glIsFramebuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsProgram(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsProgram = this.gl20.glIsProgram(i);
        a();
        return glIsProgram;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsRenderbuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsRenderbuffer = this.gl20.glIsRenderbuffer(i);
        a();
        return glIsRenderbuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsShader(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsShader = this.gl20.glIsShader(i);
        a();
        return glIsShader;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsTexture(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsTexture = this.gl20.glIsTexture(i);
        a();
        return glIsTexture;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glLineWidth(float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glLineWidth(f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glLinkProgram(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glLinkProgram(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glPixelStorei(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glPixelStorei(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glPolygonOffset(float f, float f2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glPolygonOffset(f, f2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glReadPixels(i, i2, i3, i4, i5, i6, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glReleaseShaderCompiler() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glReleaseShaderCompiler();
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glRenderbufferStorage(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glRenderbufferStorage(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glSampleCoverage(float f, boolean z) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glSampleCoverage(f, z);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glScissor(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glScissor(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glShaderBinary(int i, java.nio.IntBuffer intBuffer, int i2, java.nio.Buffer buffer, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glShaderBinary(i, intBuffer, i2, buffer, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glShaderSource(int i, java.lang.String str) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glShaderSource(i, str);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilFunc(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glStencilFunc(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilFuncSeparate(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glStencilFuncSeparate(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilMask(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glStencilMask(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilMaskSeparate(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glStencilMaskSeparate(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilOp(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glStencilOp(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilOpSeparate(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glStencilOpSeparate(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glTexImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameterf(int i, int i2, float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glTexParameterf(i, i2, f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameterfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glTexParameterfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameteri(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glTexParameteri(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glTexParameteriv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1f(int i, float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform1f(i, f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform1fv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1fv(int i, int i2, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform1fv(i, i2, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1i(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform1i(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform1iv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1iv(int i, int i2, int[] iArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform1iv(i, i2, iArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2f(int i, float f, float f2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform2f(i, f, f2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform2fv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2fv(int i, int i2, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform2fv(i, i2, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2i(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform2i(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform2iv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2iv(int i, int i2, int[] iArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform2iv(i, i2, iArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3f(int i, float f, float f2, float f3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform3f(i, f, f2, f3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform3fv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3fv(int i, int i2, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform3fv(i, i2, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3i(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform3i(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform3iv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3iv(int i, int i2, int[] iArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform3iv(i, i2, iArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4f(int i, float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform4f(i, f, f2, f3, f4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform4fv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4fv(int i, int i2, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform4fv(i, i2, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4i(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform4i(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform4iv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4iv(int i, int i2, int[] iArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniform4iv(i, i2, iArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix2fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniformMatrix2fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix2fv(int i, int i2, boolean z, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniformMatrix2fv(i, i2, z, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix3fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniformMatrix3fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix3fv(int i, int i2, boolean z, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniformMatrix3fv(i, i2, z, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix4fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniformMatrix4fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix4fv(int i, int i2, boolean z, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUniformMatrix4fv(i, i2, z, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUseProgram(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.shaderSwitches++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glUseProgram(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glValidateProgram(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glValidateProgram(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib1f(int i, float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glVertexAttrib1f(i, f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib1fv(int i, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glVertexAttrib1fv(i, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib2f(int i, float f, float f2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glVertexAttrib2f(i, f, f2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib2fv(int i, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glVertexAttrib2fv(i, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib3f(int i, float f, float f2, float f3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glVertexAttrib3f(i, f, f2, f3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib3fv(int i, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glVertexAttrib3fv(i, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib4f(int i, float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glVertexAttrib4f(i, f, f2, f3, f4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib4fv(int i, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glVertexAttrib4fv(i, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glVertexAttribPointer(i, i2, i3, z, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glVertexAttribPointer(i, i2, i3, z, i4, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glViewport(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl20.glViewport(i, i2, i3, i4);
        a();
    }
}
