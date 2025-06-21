package com.badlogic.gdx.graphics.profiling;

/* loaded from: classes12.dex */
public class GL30Profiler extends com.badlogic.gdx.graphics.profiling.GLProfiler implements com.badlogic.gdx.graphics.GL30 {
    public final com.badlogic.gdx.graphics.GL30 gl30;

    public GL30Profiler(com.badlogic.gdx.graphics.GL30 gl30) {
        this.gl30 = gl30;
    }

    public final void a() {
        int glGetError = this.gl30.glGetError();
        while (glGetError != 0) {
            com.badlogic.gdx.graphics.profiling.GLProfiler.listener.onError(glGetError);
            glGetError = this.gl30.glGetError();
        }
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glActiveTexture(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glActiveTexture(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glAttachShader(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glAttachShader(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glBeginQuery(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBeginQuery(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glBeginTransformFeedback(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBeginTransformFeedback(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindAttribLocation(int i, int i2, java.lang.String str) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBindAttribLocation(i, i2, str);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindBuffer(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBindBuffer(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glBindBufferBase(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBindBufferBase(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glBindBufferRange(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBindBufferRange(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindFramebuffer(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBindFramebuffer(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindRenderbuffer(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBindRenderbuffer(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glBindSampler(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBindSampler(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBindTexture(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.textureBindings++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBindTexture(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glBindTransformFeedback(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBindTransformFeedback(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glBindVertexArray(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBindVertexArray(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendColor(float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBlendColor(f, f2, f3, f4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendEquation(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBlendEquation(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendEquationSeparate(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBlendEquationSeparate(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendFunc(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBlendFunc(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBlendFuncSeparate(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBlendFuncSeparate(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glBlitFramebuffer(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBlitFramebuffer(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBufferData(int i, int i2, java.nio.Buffer buffer, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBufferData(i, i2, buffer, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glBufferSubData(int i, int i2, int i3, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glBufferSubData(i, i2, i3, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glCheckFramebufferStatus(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glCheckFramebufferStatus = this.gl30.glCheckFramebufferStatus(i);
        a();
        return glCheckFramebufferStatus;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClear(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glClear(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glClearBufferfi(int i, int i2, float f, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glClearBufferfi(i, i2, f, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glClearBufferfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glClearBufferfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glClearBufferiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glClearBufferiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glClearBufferuiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glClearBufferuiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClearColor(float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glClearColor(f, f2, f3, f4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClearDepthf(float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glClearDepthf(f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glClearStencil(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glClearStencil(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glColorMask(boolean z, boolean z2, boolean z3, boolean z4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glColorMask(z, z2, z3, z4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCompileShader(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glCompileShader(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glCompressedTexImage2D(i, i2, i3, i4, i5, i6, i7, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glCompressedTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glCopyBufferSubData(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glCopyBufferSubData(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCopyTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glCopyTexImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCopyTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glCopyTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glCopyTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glCopyTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glCreateProgram() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glCreateProgram = this.gl30.glCreateProgram();
        a();
        return glCreateProgram;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glCreateShader(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glCreateShader = this.gl30.glCreateShader(i);
        a();
        return glCreateShader;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glCullFace(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glCullFace(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteBuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteBuffer(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteBuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteBuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteFramebuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteFramebuffer(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteFramebuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteFramebuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteProgram(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteProgram(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDeleteQueries(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteQueries(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDeleteQueries(int i, int[] iArr, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteQueries(i, iArr, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteRenderbuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteRenderbuffer(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteRenderbuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteRenderbuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDeleteSamplers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteSamplers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDeleteSamplers(int i, int[] iArr, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteSamplers(i, iArr, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteShader(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteShader(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteTexture(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteTexture(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDeleteTextures(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteTextures(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDeleteTransformFeedbacks(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteTransformFeedbacks(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDeleteTransformFeedbacks(int i, int[] iArr, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteTransformFeedbacks(i, iArr, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDeleteVertexArrays(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteVertexArrays(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDeleteVertexArrays(int i, int[] iArr, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDeleteVertexArrays(i, iArr, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDepthFunc(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDepthFunc(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDepthMask(boolean z) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDepthMask(z);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDepthRangef(float f, float f2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDepthRangef(f, f2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDetachShader(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDetachShader(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDisable(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDisable(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDisableVertexAttribArray(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDisableVertexAttribArray(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDrawArrays(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.vertexCount.put(i3);
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDrawArrays(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDrawArraysInstanced(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.vertexCount.put(i3);
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDrawArraysInstanced(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDrawBuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDrawBuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDrawElements(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.vertexCount.put(i2);
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDrawElements(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glDrawElements(int i, int i2, int i3, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.vertexCount.put(i2);
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDrawElements(i, i2, i3, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDrawElementsInstanced(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.vertexCount.put(i2);
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDrawElementsInstanced(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDrawRangeElements(int i, int i2, int i3, int i4, int i5, int i6) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.vertexCount.put(i4);
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDrawRangeElements(i, i2, i3, i4, i5, i6);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glDrawRangeElements(int i, int i2, int i3, int i4, int i5, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.vertexCount.put(i4);
        com.badlogic.gdx.graphics.profiling.GLProfiler.drawCalls++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glDrawRangeElements(i, i2, i3, i4, i5, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glEnable(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glEnable(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glEnableVertexAttribArray(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glEnableVertexAttribArray(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glEndQuery(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glEndQuery(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glEndTransformFeedback() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glEndTransformFeedback();
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFinish() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glFinish();
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFlush() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glFlush();
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glFlushMappedBufferRange(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glFlushMappedBufferRange(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFramebufferRenderbuffer(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glFramebufferRenderbuffer(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFramebufferTexture2D(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glFramebufferTexture2D(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glFramebufferTextureLayer(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glFramebufferTextureLayer(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glFrontFace(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glFrontFace(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenBuffer() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGenBuffer = this.gl30.glGenBuffer();
        a();
        return glGenBuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenBuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenBuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenFramebuffer() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGenFramebuffer = this.gl30.glGenFramebuffer();
        a();
        return glGenFramebuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenFramebuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenFramebuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGenQueries(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenQueries(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGenQueries(int i, int[] iArr, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenQueries(i, iArr, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenRenderbuffer() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGenRenderbuffer = this.gl30.glGenRenderbuffer();
        a();
        return glGenRenderbuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenRenderbuffers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenRenderbuffers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGenSamplers(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenSamplers(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGenSamplers(int i, int[] iArr, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenSamplers(i, iArr, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGenTexture() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGenTexture = this.gl30.glGenTexture();
        a();
        return glGenTexture;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenTextures(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenTextures(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGenTransformFeedbacks(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenTransformFeedbacks(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGenTransformFeedbacks(int i, int[] iArr, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenTransformFeedbacks(i, iArr, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGenVertexArrays(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenVertexArrays(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGenVertexArrays(int i, int[] iArr, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenVertexArrays(i, iArr, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGenerateMipmap(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGenerateMipmap(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetActiveAttrib(int i, int i2, java.nio.IntBuffer intBuffer, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetActiveAttrib = this.gl30.glGetActiveAttrib(i, i2, intBuffer, buffer);
        a();
        return glGetActiveAttrib;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetActiveUniform(int i, int i2, java.nio.IntBuffer intBuffer, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetActiveUniform = this.gl30.glGetActiveUniform(i, i2, intBuffer, buffer);
        a();
        return glGetActiveUniform;
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public java.lang.String glGetActiveUniformBlockName(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetActiveUniformBlockName = this.gl30.glGetActiveUniformBlockName(i, i2);
        a();
        return glGetActiveUniformBlockName;
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetActiveUniformBlockName(int i, int i2, java.nio.Buffer buffer, java.nio.Buffer buffer2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetActiveUniformBlockName(i, i2, buffer, buffer2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetActiveUniformBlockiv(int i, int i2, int i3, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetActiveUniformBlockiv(i, i2, i3, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetActiveUniformsiv(int i, int i2, java.nio.IntBuffer intBuffer, int i3, java.nio.IntBuffer intBuffer2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetActiveUniformsiv(i, i2, intBuffer, i3, intBuffer2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetAttachedShaders(int i, int i2, java.nio.Buffer buffer, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetAttachedShaders(i, i2, buffer, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGetAttribLocation(int i, java.lang.String str) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGetAttribLocation = this.gl30.glGetAttribLocation(i, str);
        a();
        return glGetAttribLocation;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetBooleanv(int i, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetBooleanv(i, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetBufferParameteri64v(int i, int i2, java.nio.LongBuffer longBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetBufferParameteri64v(i, i2, longBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetBufferParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetBufferParameteriv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public java.nio.Buffer glGetBufferPointerv(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.nio.Buffer glGetBufferPointerv = this.gl30.glGetBufferPointerv(i, i2);
        a();
        return glGetBufferPointerv;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGetError() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        return this.gl30.glGetError();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetFloatv(int i, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetFloatv(i, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public int glGetFragDataLocation(int i, java.lang.String str) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGetFragDataLocation = this.gl30.glGetFragDataLocation(i, str);
        a();
        return glGetFragDataLocation;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetFramebufferAttachmentParameteriv(int i, int i2, int i3, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetFramebufferAttachmentParameteriv(i, i2, i3, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetInteger64v(int i, java.nio.LongBuffer longBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetInteger64v(i, longBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetIntegerv(int i, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetIntegerv(i, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetProgramInfoLog(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetProgramInfoLog = this.gl30.glGetProgramInfoLog(i);
        a();
        return glGetProgramInfoLog;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetProgramiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetProgramiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetQueryObjectuiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetQueryObjectuiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetQueryiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetQueryiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetRenderbufferParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetRenderbufferParameteriv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetSamplerParameterfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetSamplerParameterfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetSamplerParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetSamplerParameteriv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetShaderInfoLog(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetShaderInfoLog = this.gl30.glGetShaderInfoLog(i);
        a();
        return glGetShaderInfoLog;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetShaderPrecisionFormat(int i, int i2, java.nio.IntBuffer intBuffer, java.nio.IntBuffer intBuffer2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetShaderPrecisionFormat(i, i2, intBuffer, intBuffer2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetShaderiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetShaderiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public java.lang.String glGetString(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetString = this.gl30.glGetString(i);
        a();
        return glGetString;
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public java.lang.String glGetStringi(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        java.lang.String glGetStringi = this.gl30.glGetStringi(i, i2);
        a();
        return glGetStringi;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetTexParameterfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetTexParameterfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetTexParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetTexParameteriv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public int glGetUniformBlockIndex(int i, java.lang.String str) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGetUniformBlockIndex = this.gl30.glGetUniformBlockIndex(i, str);
        a();
        return glGetUniformBlockIndex;
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetUniformIndices(int i, java.lang.String[] strArr, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetUniformIndices(i, strArr, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public int glGetUniformLocation(int i, java.lang.String str) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        int glGetUniformLocation = this.gl30.glGetUniformLocation(i, str);
        a();
        return glGetUniformLocation;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetUniformfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetUniformfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetUniformiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetUniformiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetUniformuiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetUniformuiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetVertexAttribIiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetVertexAttribIiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glGetVertexAttribIuiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetVertexAttribIuiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetVertexAttribPointerv(int i, int i2, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetVertexAttribPointerv(i, i2, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetVertexAttribfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetVertexAttribfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glGetVertexAttribiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glGetVertexAttribiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glHint(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glHint(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glInvalidateFramebuffer(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glInvalidateFramebuffer(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glInvalidateSubFramebuffer(int i, int i2, java.nio.IntBuffer intBuffer, int i3, int i4, int i5, int i6) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glInvalidateSubFramebuffer(i, i2, intBuffer, i3, i4, i5, i6);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsBuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsBuffer = this.gl30.glIsBuffer(i);
        a();
        return glIsBuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsEnabled(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsEnabled = this.gl30.glIsEnabled(i);
        a();
        return glIsEnabled;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsFramebuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsFramebuffer = this.gl30.glIsFramebuffer(i);
        a();
        return glIsFramebuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsProgram(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsProgram = this.gl30.glIsProgram(i);
        a();
        return glIsProgram;
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public boolean glIsQuery(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsQuery = this.gl30.glIsQuery(i);
        a();
        return glIsQuery;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsRenderbuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsRenderbuffer = this.gl30.glIsRenderbuffer(i);
        a();
        return glIsRenderbuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public boolean glIsSampler(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsSampler = this.gl30.glIsSampler(i);
        a();
        return glIsSampler;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsShader(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsShader = this.gl30.glIsShader(i);
        a();
        return glIsShader;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public boolean glIsTexture(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsTexture = this.gl30.glIsTexture(i);
        a();
        return glIsTexture;
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public boolean glIsTransformFeedback(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsTransformFeedback = this.gl30.glIsTransformFeedback(i);
        a();
        return glIsTransformFeedback;
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public boolean glIsVertexArray(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glIsVertexArray = this.gl30.glIsVertexArray(i);
        a();
        return glIsVertexArray;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glLineWidth(float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glLineWidth(f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glLinkProgram(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glLinkProgram(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glPauseTransformFeedback() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glPauseTransformFeedback();
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glPixelStorei(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glPixelStorei(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glPolygonOffset(float f, float f2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glPolygonOffset(f, f2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glProgramParameteri(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glProgramParameteri(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glReadBuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glReadBuffer(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glReadPixels(i, i2, i3, i4, i5, i6, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glReleaseShaderCompiler() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glReleaseShaderCompiler();
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glRenderbufferStorage(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glRenderbufferStorage(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glRenderbufferStorageMultisample(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glRenderbufferStorageMultisample(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glResumeTransformFeedback() {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glResumeTransformFeedback();
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glSampleCoverage(float f, boolean z) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glSampleCoverage(f, z);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glSamplerParameterf(int i, int i2, float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glSamplerParameterf(i, i2, f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glSamplerParameterfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glSamplerParameterfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glSamplerParameteri(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glSamplerParameteri(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glSamplerParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glSamplerParameteriv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glScissor(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glScissor(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glShaderBinary(int i, java.nio.IntBuffer intBuffer, int i2, java.nio.Buffer buffer, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glShaderBinary(i, intBuffer, i2, buffer, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glShaderSource(int i, java.lang.String str) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glShaderSource(i, str);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilFunc(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glStencilFunc(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilFuncSeparate(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glStencilFuncSeparate(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilMask(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glStencilMask(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilMaskSeparate(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glStencilMaskSeparate(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilOp(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glStencilOp(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glStencilOpSeparate(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glStencilOpSeparate(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTexImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameterf(int i, int i2, float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTexParameterf(i, i2, f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameterfv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTexParameterfv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameteri(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTexParameteri(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexParameteriv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTexParameteriv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glTransformFeedbackVaryings(int i, java.lang.String[] strArr, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glTransformFeedbackVaryings(i, strArr, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1f(int i, float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform1f(i, f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform1fv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1fv(int i, int i2, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform1fv(i, i2, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1i(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform1i(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform1iv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform1iv(int i, int i2, int[] iArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform1iv(i, i2, iArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glUniform1uiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform1uiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2f(int i, float f, float f2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform2f(i, f, f2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform2fv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2fv(int i, int i2, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform2fv(i, i2, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2i(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform2i(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform2iv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform2iv(int i, int i2, int[] iArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform2iv(i, i2, iArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3f(int i, float f, float f2, float f3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform3f(i, f, f2, f3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform3fv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3fv(int i, int i2, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform3fv(i, i2, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3i(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform3i(i, i2, i3, i4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform3iv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform3iv(int i, int i2, int[] iArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform3iv(i, i2, iArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glUniform3uiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform3uiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4f(int i, float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform4f(i, f, f2, f3, f4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4fv(int i, int i2, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform4fv(i, i2, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4fv(int i, int i2, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform4fv(i, i2, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4i(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform4i(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4iv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform4iv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniform4iv(int i, int i2, int[] iArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform4iv(i, i2, iArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glUniform4uiv(int i, int i2, java.nio.IntBuffer intBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniform4uiv(i, i2, intBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glUniformBlockBinding(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformBlockBinding(i, i2, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix2fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix2fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix2fv(int i, int i2, boolean z, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix2fv(i, i2, z, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glUniformMatrix2x3fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix2x3fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glUniformMatrix2x4fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix2x4fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix3fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix3fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix3fv(int i, int i2, boolean z, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix3fv(i, i2, z, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glUniformMatrix3x2fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix3x2fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glUniformMatrix3x4fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix3x4fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix4fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix4fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUniformMatrix4fv(int i, int i2, boolean z, float[] fArr, int i3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix4fv(i, i2, z, fArr, i3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glUniformMatrix4x2fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix4x2fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glUniformMatrix4x3fv(int i, int i2, boolean z, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUniformMatrix4x3fv(i, i2, z, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public boolean glUnmapBuffer(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        boolean glUnmapBuffer = this.gl30.glUnmapBuffer(i);
        a();
        return glUnmapBuffer;
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glUseProgram(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.shaderSwitches++;
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glUseProgram(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glValidateProgram(int i) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glValidateProgram(i);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib1f(int i, float f) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttrib1f(i, f);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib1fv(int i, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttrib1fv(i, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib2f(int i, float f, float f2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttrib2f(i, f, f2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib2fv(int i, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttrib2fv(i, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib3f(int i, float f, float f2, float f3) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttrib3f(i, f, f2, f3);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib3fv(int i, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttrib3fv(i, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib4f(int i, float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttrib4f(i, f, f2, f3, f4);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttrib4fv(int i, java.nio.FloatBuffer floatBuffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttrib4fv(i, floatBuffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glVertexAttribDivisor(int i, int i2) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttribDivisor(i, i2);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glVertexAttribI4i(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttribI4i(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glVertexAttribI4ui(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttribI4ui(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30
    public void glVertexAttribIPointer(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttribIPointer(i, i2, i3, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, int i5) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttribPointer(i, i2, i3, z, i4, i5);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL30, com.badlogic.gdx.graphics.GL20
    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glVertexAttribPointer(i, i2, i3, z, i4, buffer);
        a();
    }

    @Override // com.badlogic.gdx.graphics.GL20
    public void glViewport(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.profiling.GLProfiler.calls++;
        this.gl30.glViewport(i, i2, i3, i4);
        a();
    }
}
