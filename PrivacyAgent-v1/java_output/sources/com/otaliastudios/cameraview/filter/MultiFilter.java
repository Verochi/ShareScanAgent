package com.otaliastudios.cameraview.filter;

/* loaded from: classes19.dex */
public class MultiFilter implements com.otaliastudios.cameraview.filter.Filter, com.otaliastudios.cameraview.filter.OneParameterFilter, com.otaliastudios.cameraview.filter.TwoParameterFilter {

    @androidx.annotation.VisibleForTesting
    public final java.util.List<com.otaliastudios.cameraview.filter.Filter> a;

    @androidx.annotation.VisibleForTesting
    public final java.util.Map<com.otaliastudios.cameraview.filter.Filter, com.otaliastudios.cameraview.filter.MultiFilter.State> b;
    public final java.lang.Object c;
    public com.otaliastudios.cameraview.size.Size d;
    public float e;
    public float f;

    @androidx.annotation.VisibleForTesting
    public static class State {

        @androidx.annotation.VisibleForTesting
        public boolean a = false;

        @androidx.annotation.VisibleForTesting
        public boolean b = false;
        public boolean c = false;

        @androidx.annotation.VisibleForTesting
        public com.otaliastudios.cameraview.size.Size d = null;
        public int e = -1;
        public com.otaliastudios.opengl.texture.GlFramebuffer f = null;
        public com.otaliastudios.opengl.texture.GlTexture g = null;
    }

    public MultiFilter(@androidx.annotation.NonNull java.util.Collection<com.otaliastudios.cameraview.filter.Filter> collection) {
        this.a = new java.util.ArrayList();
        this.b = new java.util.HashMap();
        this.c = new java.lang.Object();
        this.d = null;
        this.e = 0.0f;
        this.f = 0.0f;
        java.util.Iterator<com.otaliastudios.cameraview.filter.Filter> it = collection.iterator();
        while (it.hasNext()) {
            addFilter(it.next());
        }
    }

    public MultiFilter(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter... filterArr) {
        this(java.util.Arrays.asList(filterArr));
    }

    public final void a(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter, boolean z, boolean z2) {
        com.otaliastudios.cameraview.filter.MultiFilter.State state = this.b.get(filter);
        if (z2) {
            state.c = false;
            return;
        }
        if (state.c) {
            c(filter);
            state.c = false;
        }
        if (state.b) {
            return;
        }
        state.b = true;
        state.g = new com.otaliastudios.opengl.texture.GlTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0, com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, state.d.getWidth(), state.d.getHeight());
        state.f = new com.otaliastudios.opengl.texture.GlFramebuffer();
        state.f.attach(state.g);
    }

    public void addFilter(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
        if (filter instanceof com.otaliastudios.cameraview.filter.MultiFilter) {
            java.util.Iterator<com.otaliastudios.cameraview.filter.Filter> it = ((com.otaliastudios.cameraview.filter.MultiFilter) filter).a.iterator();
            while (it.hasNext()) {
                addFilter(it.next());
            }
        } else {
            synchronized (this.c) {
                if (!this.a.contains(filter)) {
                    this.a.add(filter);
                    this.b.put(filter, new com.otaliastudios.cameraview.filter.MultiFilter.State());
                }
            }
        }
    }

    public final void b(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter, boolean z, boolean z2) {
        com.otaliastudios.cameraview.filter.MultiFilter.State state = this.b.get(filter);
        if (state.a) {
            return;
        }
        state.a = true;
        state.e = com.otaliastudios.opengl.program.GlProgram.create(filter.getVertexShader(), z ? filter.getFragmentShader() : filter.getFragmentShader().replace("samplerExternalOES ", "sampler2D "));
        filter.onCreate(state.e);
    }

    public final void c(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
        com.otaliastudios.cameraview.filter.MultiFilter.State state = this.b.get(filter);
        if (state.b) {
            state.b = false;
            state.f.release();
            state.f = null;
            state.g.release();
            state.g = null;
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.filter.Filter copy() {
        com.otaliastudios.cameraview.filter.MultiFilter multiFilter;
        synchronized (this.c) {
            multiFilter = new com.otaliastudios.cameraview.filter.MultiFilter(new com.otaliastudios.cameraview.filter.Filter[0]);
            com.otaliastudios.cameraview.size.Size size = this.d;
            if (size != null) {
                multiFilter.setSize(size.getWidth(), this.d.getHeight());
            }
            java.util.Iterator<com.otaliastudios.cameraview.filter.Filter> it = this.a.iterator();
            while (it.hasNext()) {
                multiFilter.addFilter(it.next().copy());
            }
        }
        return multiFilter;
    }

    public final void d(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
        com.otaliastudios.cameraview.filter.MultiFilter.State state = this.b.get(filter);
        if (state.a) {
            state.a = false;
            filter.onDestroy();
            android.opengl.GLES20.glDeleteProgram(state.e);
            state.e = -1;
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void draw(long j, @androidx.annotation.NonNull float[] fArr) {
        synchronized (this.c) {
            int i = 0;
            while (i < this.a.size()) {
                boolean z = true;
                boolean z2 = i == 0;
                if (i != this.a.size() - 1) {
                    z = false;
                }
                com.otaliastudios.cameraview.filter.Filter filter = this.a.get(i);
                com.otaliastudios.cameraview.filter.MultiFilter.State state = this.b.get(filter);
                e(filter);
                b(filter, z2, z);
                a(filter, z2, z);
                android.opengl.GLES20.glUseProgram(state.e);
                if (z) {
                    android.opengl.GLES20.glBindFramebuffer(com.badlogic.gdx.graphics.GL20.GL_FRAMEBUFFER, 0);
                } else {
                    state.f.bind();
                    android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
                if (z2) {
                    filter.draw(j, fArr);
                } else {
                    filter.draw(j, com.otaliastudios.opengl.core.Egloo.IDENTITY_MATRIX);
                }
                if (z) {
                    android.opengl.GLES20.glBindTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE_2D, 0);
                    android.opengl.GLES20.glActiveTexture(com.badlogic.gdx.graphics.GL20.GL_TEXTURE0);
                } else {
                    state.g.bind();
                }
                android.opengl.GLES20.glUseProgram(0);
                i++;
            }
        }
    }

    public final void e(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
        com.otaliastudios.cameraview.filter.MultiFilter.State state = this.b.get(filter);
        com.otaliastudios.cameraview.size.Size size = this.d;
        if (size == null || size.equals(state.d)) {
            return;
        }
        state.d = this.d;
        state.c = true;
        filter.setSize(this.d.getWidth(), this.d.getHeight());
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getFragmentShader() {
        return com.otaliastudios.opengl.program.GlTextureProgram.SIMPLE_FRAGMENT_SHADER;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public float getParameter2() {
        return this.f;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @androidx.annotation.NonNull
    public java.lang.String getVertexShader() {
        return com.otaliastudios.opengl.program.GlTextureProgram.SIMPLE_VERTEX_SHADER;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        synchronized (this.c) {
            for (com.otaliastudios.cameraview.filter.Filter filter : this.a) {
                c(filter);
                d(filter);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f) {
        this.e = f;
        synchronized (this.c) {
            for (com.otaliastudios.cameraview.filter.Filter filter : this.a) {
                if (filter instanceof com.otaliastudios.cameraview.filter.OneParameterFilter) {
                    ((com.otaliastudios.cameraview.filter.OneParameterFilter) filter).setParameter1(f);
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public void setParameter2(float f) {
        this.f = f;
        synchronized (this.c) {
            for (com.otaliastudios.cameraview.filter.Filter filter : this.a) {
                if (filter instanceof com.otaliastudios.cameraview.filter.TwoParameterFilter) {
                    ((com.otaliastudios.cameraview.filter.TwoParameterFilter) filter).setParameter2(f);
                }
            }
        }
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i, int i2) {
        this.d = new com.otaliastudios.cameraview.size.Size(i, i2);
        synchronized (this.c) {
            java.util.Iterator<com.otaliastudios.cameraview.filter.Filter> it = this.a.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
        }
    }
}
