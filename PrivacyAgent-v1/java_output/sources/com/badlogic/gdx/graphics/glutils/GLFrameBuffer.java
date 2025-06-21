package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public abstract class GLFrameBuffer<T extends com.badlogic.gdx.graphics.GLTexture> implements com.badlogic.gdx.utils.Disposable {
    protected static final int GL_DEPTH24_STENCIL8_OES = 35056;
    protected static int defaultFramebufferHandle;
    protected T colorTexture;
    protected int depthStencilPackedBufferHandle;
    protected int depthbufferHandle;
    protected final com.badlogic.gdx.graphics.Pixmap.Format format;
    protected int framebufferHandle;
    protected final boolean hasDepth;
    protected boolean hasDepthStencilPackedBuffer;
    protected final boolean hasStencil;
    protected final int height;
    protected int stencilbufferHandle;
    protected final int width;
    protected static final java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.glutils.GLFrameBuffer>> buffers = new java.util.HashMap();
    protected static boolean defaultFramebufferHandleInitialized = false;

    public GLFrameBuffer(com.badlogic.gdx.graphics.Pixmap.Format format, int i, int i2, boolean z) {
        this(format, i, i2, z, false);
    }

    public GLFrameBuffer(com.badlogic.gdx.graphics.Pixmap.Format format, int i, int i2, boolean z, boolean z2) {
        this.width = i;
        this.height = i2;
        this.format = format;
        this.hasDepth = z;
        this.hasStencil = z2;
        build();
        a(com.badlogic.gdx.Gdx.app, this);
    }

    public static void a(com.badlogic.gdx.Application application, com.badlogic.gdx.graphics.glutils.GLFrameBuffer gLFrameBuffer) {
        java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.glutils.GLFrameBuffer>> map = buffers;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.glutils.GLFrameBuffer> array = map.get(application);
        if (array == null) {
            array = new com.badlogic.gdx.utils.Array<>();
        }
        array.add(gLFrameBuffer);
        map.put(application, array);
    }

    public static void clearAllFrameBuffers(com.badlogic.gdx.Application application) {
        buffers.remove(application);
    }

    public static java.lang.String getManagedStatus() {
        return getManagedStatus(new java.lang.StringBuilder()).toString();
    }

    public static java.lang.StringBuilder getManagedStatus(java.lang.StringBuilder sb) {
        sb.append("Managed buffers/app: { ");
        java.util.Iterator<com.badlogic.gdx.Application> it = buffers.keySet().iterator();
        while (it.hasNext()) {
            sb.append(buffers.get(it.next()).size);
            sb.append(" ");
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb;
    }

    public static void invalidateAllFrameBuffers(com.badlogic.gdx.Application application) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.glutils.GLFrameBuffer> array;
        if (com.badlogic.gdx.Gdx.gl20 == null || (array = buffers.get(application)) == null) {
            return;
        }
        for (int i = 0; i < array.size; i++) {
            array.get(i).build();
        }
    }

    public static void unbind() {
        com.badlogic.gdx.Gdx.gl20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, defaultFramebufferHandle);
    }

    public abstract void attachFrameBufferColorTexture();

    public void begin() {
        bind();
        setFrameBufferViewport();
    }

    public void bind() {
        com.badlogic.gdx.Gdx.gl20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, this.framebufferHandle);
    }

    public void build() {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        if (!defaultFramebufferHandleInitialized) {
            defaultFramebufferHandleInitialized = true;
            if (com.badlogic.gdx.Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.iOS) {
                java.nio.IntBuffer asIntBuffer = java.nio.ByteBuffer.allocateDirect(64).order(java.nio.ByteOrder.nativeOrder()).asIntBuffer();
                gl20.glGetIntegerv(36006, asIntBuffer);
                defaultFramebufferHandle = asIntBuffer.get(0);
            } else {
                defaultFramebufferHandle = 0;
            }
        }
        this.colorTexture = createColorTexture();
        this.framebufferHandle = gl20.glGenFramebuffer();
        if (this.hasDepth) {
            this.depthbufferHandle = gl20.glGenRenderbuffer();
        }
        if (this.hasStencil) {
            this.stencilbufferHandle = gl20.glGenRenderbuffer();
        }
        T t = this.colorTexture;
        gl20.glBindTexture(t.glTarget, t.getTextureObjectHandle());
        if (this.hasDepth) {
            gl20.glBindRenderbuffer(com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, this.depthbufferHandle);
            gl20.glRenderbufferStorage(com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, com.badlogic.gdx.graphics.GL20.GL_DEPTH_COMPONENT16, this.colorTexture.getWidth(), this.colorTexture.getHeight());
        }
        if (this.hasStencil) {
            gl20.glBindRenderbuffer(com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, this.stencilbufferHandle);
            gl20.glRenderbufferStorage(com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, com.badlogic.gdx.graphics.GL20.GL_STENCIL_INDEX8, this.colorTexture.getWidth(), this.colorTexture.getHeight());
        }
        gl20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, this.framebufferHandle);
        attachFrameBufferColorTexture();
        if (this.hasDepth) {
            gl20.glFramebufferRenderbuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, com.badlogic.gdx.graphics.GL20.GL_DEPTH_ATTACHMENT, com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, this.depthbufferHandle);
        }
        if (this.hasStencil) {
            gl20.glFramebufferRenderbuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, com.badlogic.gdx.graphics.GL20.GL_STENCIL_ATTACHMENT, com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, this.stencilbufferHandle);
        }
        gl20.glBindRenderbuffer(com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, 0);
        gl20.glBindTexture(this.colorTexture.glTarget, 0);
        int glCheckFramebufferStatus = gl20.glCheckFramebufferStatus(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER);
        if (glCheckFramebufferStatus == 36061 && this.hasDepth && this.hasStencil && (com.badlogic.gdx.Gdx.graphics.supportsExtension("GL_OES_packed_depth_stencil") || com.badlogic.gdx.Gdx.graphics.supportsExtension("GL_EXT_packed_depth_stencil"))) {
            if (this.hasDepth) {
                gl20.glDeleteRenderbuffer(this.depthbufferHandle);
                this.depthbufferHandle = 0;
            }
            if (this.hasStencil) {
                gl20.glDeleteRenderbuffer(this.stencilbufferHandle);
                this.stencilbufferHandle = 0;
            }
            int glGenRenderbuffer = gl20.glGenRenderbuffer();
            this.depthStencilPackedBufferHandle = glGenRenderbuffer;
            this.hasDepthStencilPackedBuffer = true;
            gl20.glBindRenderbuffer(com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, glGenRenderbuffer);
            gl20.glRenderbufferStorage(com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, 35056, this.colorTexture.getWidth(), this.colorTexture.getHeight());
            gl20.glBindRenderbuffer(com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, 0);
            gl20.glFramebufferRenderbuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, com.badlogic.gdx.graphics.GL20.GL_DEPTH_ATTACHMENT, com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, this.depthStencilPackedBufferHandle);
            gl20.glFramebufferRenderbuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, com.badlogic.gdx.graphics.GL20.GL_STENCIL_ATTACHMENT, com.badlogic.gdx.graphics.GL20.GL_RENDERBUFFER, this.depthStencilPackedBufferHandle);
            glCheckFramebufferStatus = gl20.glCheckFramebufferStatus(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER);
        }
        gl20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, defaultFramebufferHandle);
        if (glCheckFramebufferStatus != 36053) {
            disposeColorTexture(this.colorTexture);
            if (this.hasDepthStencilPackedBuffer) {
                gl20.glDeleteBuffer(this.depthStencilPackedBufferHandle);
            } else {
                if (this.hasDepth) {
                    gl20.glDeleteRenderbuffer(this.depthbufferHandle);
                }
                if (this.hasStencil) {
                    gl20.glDeleteRenderbuffer(this.stencilbufferHandle);
                }
            }
            gl20.glDeleteFramebuffer(this.framebufferHandle);
            if (glCheckFramebufferStatus == 36054) {
                throw new java.lang.IllegalStateException("frame buffer couldn't be constructed: incomplete attachment");
            }
            if (glCheckFramebufferStatus == 36057) {
                throw new java.lang.IllegalStateException("frame buffer couldn't be constructed: incomplete dimensions");
            }
            if (glCheckFramebufferStatus == 36055) {
                throw new java.lang.IllegalStateException("frame buffer couldn't be constructed: missing attachment");
            }
            if (glCheckFramebufferStatus == 36061) {
                throw new java.lang.IllegalStateException("frame buffer couldn't be constructed: unsupported combination of formats");
            }
            throw new java.lang.IllegalStateException("frame buffer couldn't be constructed: unknown error " + glCheckFramebufferStatus);
        }
    }

    public abstract T createColorTexture();

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        disposeColorTexture(this.colorTexture);
        if (this.hasDepthStencilPackedBuffer) {
            gl20.glDeleteRenderbuffer(this.depthStencilPackedBufferHandle);
        } else {
            if (this.hasDepth) {
                gl20.glDeleteRenderbuffer(this.depthbufferHandle);
            }
            if (this.hasStencil) {
                gl20.glDeleteRenderbuffer(this.stencilbufferHandle);
            }
        }
        gl20.glDeleteFramebuffer(this.framebufferHandle);
        java.util.Map<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.glutils.GLFrameBuffer>> map = buffers;
        if (map.get(com.badlogic.gdx.Gdx.app) != null) {
            map.get(com.badlogic.gdx.Gdx.app).removeValue(this, true);
        }
    }

    public abstract void disposeColorTexture(T t);

    public void end() {
        end(0, 0, com.badlogic.gdx.Gdx.graphics.getBackBufferWidth(), com.badlogic.gdx.Gdx.graphics.getBackBufferHeight());
    }

    public void end(int i, int i2, int i3, int i4) {
        unbind();
        com.badlogic.gdx.Gdx.gl20.glViewport(i, i2, i3, i4);
    }

    public T getColorBufferTexture() {
        return this.colorTexture;
    }

    public int getDepth() {
        return this.colorTexture.getDepth();
    }

    public int getDepthBufferHandle() {
        return this.depthbufferHandle;
    }

    public int getDepthStencilPackedBuffer() {
        return this.depthStencilPackedBufferHandle;
    }

    public int getFramebufferHandle() {
        return this.framebufferHandle;
    }

    public int getHeight() {
        return this.colorTexture.getHeight();
    }

    public int getStencilBufferHandle() {
        return this.stencilbufferHandle;
    }

    public int getWidth() {
        return this.colorTexture.getWidth();
    }

    public void setFrameBufferViewport() {
        com.badlogic.gdx.Gdx.gl20.glViewport(0, 0, this.colorTexture.getWidth(), this.colorTexture.getHeight());
    }
}
