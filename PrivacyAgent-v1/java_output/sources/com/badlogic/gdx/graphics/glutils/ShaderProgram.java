package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class ShaderProgram implements com.badlogic.gdx.utils.Disposable {
    public static final java.lang.String BINORMAL_ATTRIBUTE = "a_binormal";
    public static final java.lang.String BONEWEIGHT_ATTRIBUTE = "a_boneWeight";
    public static final java.lang.String COLOR_ATTRIBUTE = "a_color";
    public static final java.lang.String NORMAL_ATTRIBUTE = "a_normal";
    public static final java.lang.String POSITION_ATTRIBUTE = "a_position";
    public static final java.lang.String TANGENT_ATTRIBUTE = "a_tangent";
    public static final java.lang.String TEXCOORD_ATTRIBUTE = "a_texCoord";
    public static boolean pedantic = true;
    public static java.lang.String prependFragmentCode = "";
    public static java.lang.String prependVertexCode = "";
    public static final com.badlogic.gdx.utils.ObjectMap<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.glutils.ShaderProgram>> u = new com.badlogic.gdx.utils.ObjectMap<>();
    public static final java.nio.IntBuffer v = com.badlogic.gdx.utils.BufferUtils.newIntBuffer(1);
    public java.lang.String a;
    public boolean b;
    public final com.badlogic.gdx.utils.ObjectIntMap<java.lang.String> c;
    public final com.badlogic.gdx.utils.ObjectIntMap<java.lang.String> d;
    public final com.badlogic.gdx.utils.ObjectIntMap<java.lang.String> e;
    public java.lang.String[] f;
    public final com.badlogic.gdx.utils.ObjectIntMap<java.lang.String> g;
    public final com.badlogic.gdx.utils.ObjectIntMap<java.lang.String> h;
    public final com.badlogic.gdx.utils.ObjectIntMap<java.lang.String> i;
    public java.lang.String[] j;
    public int k;
    public int l;
    public int m;
    public final java.nio.FloatBuffer n;
    public final java.lang.String o;
    public final java.lang.String p;
    public boolean q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public java.nio.IntBuffer f291s;
    public java.nio.IntBuffer t;

    public ShaderProgram(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2) {
        this(fileHandle.readString(), fileHandle2.readString());
    }

    public ShaderProgram(java.lang.String str, java.lang.String str2) {
        this.a = "";
        this.c = new com.badlogic.gdx.utils.ObjectIntMap<>();
        this.d = new com.badlogic.gdx.utils.ObjectIntMap<>();
        this.e = new com.badlogic.gdx.utils.ObjectIntMap<>();
        this.g = new com.badlogic.gdx.utils.ObjectIntMap<>();
        this.h = new com.badlogic.gdx.utils.ObjectIntMap<>();
        this.i = new com.badlogic.gdx.utils.ObjectIntMap<>();
        this.r = 0;
        this.f291s = com.badlogic.gdx.utils.BufferUtils.newIntBuffer(1);
        this.t = com.badlogic.gdx.utils.BufferUtils.newIntBuffer(1);
        if (str == null) {
            throw new java.lang.IllegalArgumentException("vertex shader must not be null");
        }
        if (str2 == null) {
            throw new java.lang.IllegalArgumentException("fragment shader must not be null");
        }
        java.lang.String str3 = prependVertexCode;
        if (str3 != null && str3.length() > 0) {
            str = prependVertexCode + str;
        }
        java.lang.String str4 = prependFragmentCode;
        if (str4 != null && str4.length() > 0) {
            str2 = prependFragmentCode + str2;
        }
        this.o = str;
        this.p = str2;
        this.n = com.badlogic.gdx.utils.BufferUtils.newFloatBuffer(16);
        c(str, str2);
        if (isCompiled()) {
            e();
            g();
            a(com.badlogic.gdx.Gdx.app, this);
        }
    }

    public static void clearAllShaderPrograms(com.badlogic.gdx.Application application) {
        u.remove(application);
    }

    public static java.lang.String getManagedStatus() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Managed shaders/app: { ");
        com.badlogic.gdx.utils.ObjectMap.Keys<com.badlogic.gdx.Application> it = u.keys().iterator();
        while (it.hasNext()) {
            sb.append(u.get(it.next()).size);
            sb.append(" ");
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    public static int getNumManagedShaderPrograms() {
        return u.get(com.badlogic.gdx.Gdx.app).size;
    }

    public static void invalidateAllShaderPrograms(com.badlogic.gdx.Application application) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.glutils.ShaderProgram> array;
        if (com.badlogic.gdx.Gdx.gl20 == null || (array = u.get(application)) == null) {
            return;
        }
        for (int i = 0; i < array.size; i++) {
            array.get(i).q = true;
            array.get(i).b();
        }
    }

    public final void a(com.badlogic.gdx.Application application, com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        com.badlogic.gdx.utils.ObjectMap<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.glutils.ShaderProgram>> objectMap = u;
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.glutils.ShaderProgram> array = objectMap.get(application);
        if (array == null) {
            array = new com.badlogic.gdx.utils.Array<>();
        }
        array.add(shaderProgram);
        objectMap.put(application, array);
    }

    public final void b() {
        if (this.q) {
            c(this.o, this.p);
            this.q = false;
        }
    }

    public void begin() {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUseProgram(this.k);
    }

    public final void c(java.lang.String str, java.lang.String str2) {
        this.l = i(com.badlogic.gdx.graphics.GL20.GL_VERTEX_SHADER, str);
        int i = i(com.badlogic.gdx.graphics.GL20.GL_FRAGMENT_SHADER, str2);
        this.m = i;
        if (this.l == -1 || i == -1) {
            this.b = false;
            return;
        }
        int h = h(createProgram());
        this.k = h;
        if (h == -1) {
            this.b = false;
        } else {
            this.b = true;
        }
    }

    public int createProgram() {
        int glCreateProgram = com.badlogic.gdx.Gdx.gl20.glCreateProgram();
        if (glCreateProgram != 0) {
            return glCreateProgram;
        }
        return -1;
    }

    public final int d(java.lang.String str) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        int i = this.g.get(str, -2);
        if (i != -2) {
            return i;
        }
        int glGetAttribLocation = gl20.glGetAttribLocation(this.k, str);
        this.g.put(str, glGetAttribLocation);
        return glGetAttribLocation;
    }

    public void disableVertexAttribute(int i) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glDisableVertexAttribArray(i);
    }

    public void disableVertexAttribute(java.lang.String str) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        int d = d(str);
        if (d == -1) {
            return;
        }
        gl20.glDisableVertexAttribArray(d);
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        gl20.glUseProgram(0);
        gl20.glDeleteShader(this.l);
        gl20.glDeleteShader(this.m);
        gl20.glDeleteProgram(this.k);
        com.badlogic.gdx.utils.ObjectMap<com.badlogic.gdx.Application, com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.glutils.ShaderProgram>> objectMap = u;
        if (objectMap.get(com.badlogic.gdx.Gdx.app) != null) {
            objectMap.get(com.badlogic.gdx.Gdx.app).removeValue(this, true);
        }
    }

    public final void e() {
        this.f291s.clear();
        com.badlogic.gdx.Gdx.gl20.glGetProgramiv(this.k, com.badlogic.gdx.graphics.GL20.GL_ACTIVE_ATTRIBUTES, this.f291s);
        int i = this.f291s.get(0);
        this.j = new java.lang.String[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f291s.clear();
            this.f291s.put(0, 1);
            this.t.clear();
            java.lang.String glGetActiveAttrib = com.badlogic.gdx.Gdx.gl20.glGetActiveAttrib(this.k, i2, this.f291s, this.t);
            this.g.put(glGetActiveAttrib, com.badlogic.gdx.Gdx.gl20.glGetAttribLocation(this.k, glGetActiveAttrib));
            this.h.put(glGetActiveAttrib, this.t.get(0));
            this.i.put(glGetActiveAttrib, this.f291s.get(0));
            this.j[i2] = glGetActiveAttrib;
        }
    }

    public void enableVertexAttribute(int i) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glEnableVertexAttribArray(i);
    }

    public void enableVertexAttribute(java.lang.String str) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        int d = d(str);
        if (d == -1) {
            return;
        }
        gl20.glEnableVertexAttribArray(d);
    }

    public void end() {
        com.badlogic.gdx.Gdx.gl20.glUseProgram(0);
    }

    public final int f(java.lang.String str) {
        return fetchUniformLocation(str, pedantic);
    }

    public int fetchUniformLocation(java.lang.String str, boolean z) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        int i = this.c.get(str, -2);
        if (i == -2) {
            i = gl20.glGetUniformLocation(this.k, str);
            if (i == -1 && z) {
                throw new java.lang.IllegalArgumentException("no uniform with name '" + str + "' in shader");
            }
            this.c.put(str, i);
        }
        return i;
    }

    public final void g() {
        this.f291s.clear();
        com.badlogic.gdx.Gdx.gl20.glGetProgramiv(this.k, com.badlogic.gdx.graphics.GL20.GL_ACTIVE_UNIFORMS, this.f291s);
        int i = this.f291s.get(0);
        this.f = new java.lang.String[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f291s.clear();
            this.f291s.put(0, 1);
            this.t.clear();
            java.lang.String glGetActiveUniform = com.badlogic.gdx.Gdx.gl20.glGetActiveUniform(this.k, i2, this.f291s, this.t);
            this.c.put(glGetActiveUniform, com.badlogic.gdx.Gdx.gl20.glGetUniformLocation(this.k, glGetActiveUniform));
            this.d.put(glGetActiveUniform, this.t.get(0));
            this.e.put(glGetActiveUniform, this.f291s.get(0));
            this.f[i2] = glGetActiveUniform;
        }
    }

    public int getAttributeLocation(java.lang.String str) {
        return this.g.get(str, -1);
    }

    public int getAttributeSize(java.lang.String str) {
        return this.i.get(str, 0);
    }

    public int getAttributeType(java.lang.String str) {
        return this.h.get(str, 0);
    }

    public java.lang.String[] getAttributes() {
        return this.j;
    }

    public java.lang.String getFragmentShaderSource() {
        return this.p;
    }

    public java.lang.String getLog() {
        if (!this.b) {
            return this.a;
        }
        java.lang.String glGetProgramInfoLog = com.badlogic.gdx.Gdx.gl20.glGetProgramInfoLog(this.k);
        this.a = glGetProgramInfoLog;
        return glGetProgramInfoLog;
    }

    public int getUniformLocation(java.lang.String str) {
        return this.c.get(str, -1);
    }

    public int getUniformSize(java.lang.String str) {
        return this.e.get(str, 0);
    }

    public int getUniformType(java.lang.String str) {
        return this.d.get(str, 0);
    }

    public java.lang.String[] getUniforms() {
        return this.f;
    }

    public java.lang.String getVertexShaderSource() {
        return this.o;
    }

    public final int h(int i) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        if (i == -1) {
            return -1;
        }
        gl20.glAttachShader(i, this.l);
        gl20.glAttachShader(i, this.m);
        gl20.glLinkProgram(i);
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(4);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        java.nio.IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
        gl20.glGetProgramiv(i, com.badlogic.gdx.graphics.GL20.GL_LINK_STATUS, asIntBuffer);
        if (asIntBuffer.get(0) != 0) {
            return i;
        }
        this.a = com.badlogic.gdx.Gdx.gl20.glGetProgramInfoLog(i);
        return -1;
    }

    public boolean hasAttribute(java.lang.String str) {
        return this.g.containsKey(str);
    }

    public boolean hasUniform(java.lang.String str) {
        return this.c.containsKey(str);
    }

    public final int i(int i, java.lang.String str) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        java.nio.IntBuffer newIntBuffer = com.badlogic.gdx.utils.BufferUtils.newIntBuffer(1);
        int glCreateShader = gl20.glCreateShader(i);
        if (glCreateShader == 0) {
            return -1;
        }
        gl20.glShaderSource(glCreateShader, str);
        gl20.glCompileShader(glCreateShader);
        gl20.glGetShaderiv(glCreateShader, com.badlogic.gdx.graphics.GL20.GL_COMPILE_STATUS, newIntBuffer);
        if (newIntBuffer.get(0) != 0) {
            return glCreateShader;
        }
        java.lang.String glGetShaderInfoLog = gl20.glGetShaderInfoLog(glCreateShader);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.a);
        sb.append(i == 35633 ? "Vertex shader\n" : "Fragment shader:\n");
        this.a = sb.toString();
        this.a += glGetShaderInfoLog;
        return -1;
    }

    public boolean isCompiled() {
        return this.b;
    }

    public void setAttributef(java.lang.String str, float f, float f2, float f3, float f4) {
        com.badlogic.gdx.Gdx.gl20.glVertexAttrib4f(d(str), f, f2, f3, f4);
    }

    public void setUniform1fv(int i, float[] fArr, int i2, int i3) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform1fv(i, i3, fArr, i2);
    }

    public void setUniform1fv(java.lang.String str, float[] fArr, int i, int i2) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform1fv(f(str), i2, fArr, i);
    }

    public void setUniform2fv(int i, float[] fArr, int i2, int i3) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform2fv(i, i3 / 2, fArr, i2);
    }

    public void setUniform2fv(java.lang.String str, float[] fArr, int i, int i2) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform2fv(f(str), i2 / 2, fArr, i);
    }

    public void setUniform3fv(int i, float[] fArr, int i2, int i3) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform3fv(i, i3 / 3, fArr, i2);
    }

    public void setUniform3fv(java.lang.String str, float[] fArr, int i, int i2) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform3fv(f(str), i2 / 3, fArr, i);
    }

    public void setUniform4fv(int i, float[] fArr, int i2, int i3) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform4fv(i, i3 / 4, fArr, i2);
    }

    public void setUniform4fv(java.lang.String str, float[] fArr, int i, int i2) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform4fv(f(str), i2 / 4, fArr, i);
    }

    public void setUniformMatrix(int i, com.badlogic.gdx.math.Matrix3 matrix3) {
        setUniformMatrix(i, matrix3, false);
    }

    public void setUniformMatrix(int i, com.badlogic.gdx.math.Matrix3 matrix3, boolean z) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniformMatrix3fv(i, 1, z, matrix3.val, 0);
    }

    public void setUniformMatrix(int i, com.badlogic.gdx.math.Matrix4 matrix4) {
        setUniformMatrix(i, matrix4, false);
    }

    public void setUniformMatrix(int i, com.badlogic.gdx.math.Matrix4 matrix4, boolean z) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniformMatrix4fv(i, 1, z, matrix4.val, 0);
    }

    public void setUniformMatrix(java.lang.String str, com.badlogic.gdx.math.Matrix3 matrix3) {
        setUniformMatrix(str, matrix3, false);
    }

    public void setUniformMatrix(java.lang.String str, com.badlogic.gdx.math.Matrix3 matrix3, boolean z) {
        setUniformMatrix(f(str), matrix3, z);
    }

    public void setUniformMatrix(java.lang.String str, com.badlogic.gdx.math.Matrix4 matrix4) {
        setUniformMatrix(str, matrix4, false);
    }

    public void setUniformMatrix(java.lang.String str, com.badlogic.gdx.math.Matrix4 matrix4, boolean z) {
        setUniformMatrix(f(str), matrix4, z);
    }

    public void setUniformMatrix3fv(java.lang.String str, java.nio.FloatBuffer floatBuffer, int i, boolean z) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        floatBuffer.position(0);
        gl20.glUniformMatrix3fv(f(str), i, z, floatBuffer);
    }

    public void setUniformMatrix4fv(int i, float[] fArr, int i2, int i3) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniformMatrix4fv(i, i3 / 16, false, fArr, i2);
    }

    public void setUniformMatrix4fv(java.lang.String str, java.nio.FloatBuffer floatBuffer, int i, boolean z) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        floatBuffer.position(0);
        gl20.glUniformMatrix4fv(f(str), i, z, floatBuffer);
    }

    public void setUniformMatrix4fv(java.lang.String str, float[] fArr, int i, int i2) {
        setUniformMatrix4fv(f(str), fArr, i, i2);
    }

    public void setUniformf(int i, float f) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform1f(i, f);
    }

    public void setUniformf(int i, float f, float f2) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform2f(i, f, f2);
    }

    public void setUniformf(int i, float f, float f2, float f3) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform3f(i, f, f2, f3);
    }

    public void setUniformf(int i, float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform4f(i, f, f2, f3, f4);
    }

    public void setUniformf(int i, com.badlogic.gdx.graphics.Color color) {
        setUniformf(i, color.r, color.g, color.b, color.a);
    }

    public void setUniformf(int i, com.badlogic.gdx.math.Vector2 vector2) {
        setUniformf(i, vector2.x, vector2.y);
    }

    public void setUniformf(int i, com.badlogic.gdx.math.Vector3 vector3) {
        setUniformf(i, vector3.x, vector3.y, vector3.z);
    }

    public void setUniformf(java.lang.String str, float f) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform1f(f(str), f);
    }

    public void setUniformf(java.lang.String str, float f, float f2) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform2f(f(str), f, f2);
    }

    public void setUniformf(java.lang.String str, float f, float f2, float f3) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform3f(f(str), f, f2, f3);
    }

    public void setUniformf(java.lang.String str, float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform4f(f(str), f, f2, f3, f4);
    }

    public void setUniformf(java.lang.String str, com.badlogic.gdx.graphics.Color color) {
        setUniformf(str, color.r, color.g, color.b, color.a);
    }

    public void setUniformf(java.lang.String str, com.badlogic.gdx.math.Vector2 vector2) {
        setUniformf(str, vector2.x, vector2.y);
    }

    public void setUniformf(java.lang.String str, com.badlogic.gdx.math.Vector3 vector3) {
        setUniformf(str, vector3.x, vector3.y, vector3.z);
    }

    public void setUniformi(int i, int i2) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform1i(i, i2);
    }

    public void setUniformi(int i, int i2, int i3) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform2i(i, i2, i3);
    }

    public void setUniformi(int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform3i(i, i2, i3, i4);
    }

    public void setUniformi(int i, int i2, int i3, int i4, int i5) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform4i(i, i2, i3, i4, i5);
    }

    public void setUniformi(java.lang.String str, int i) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform1i(f(str), i);
    }

    public void setUniformi(java.lang.String str, int i, int i2) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform2i(f(str), i, i2);
    }

    public void setUniformi(java.lang.String str, int i, int i2, int i3) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform3i(f(str), i, i2, i3);
    }

    public void setUniformi(java.lang.String str, int i, int i2, int i3, int i4) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glUniform4i(f(str), i, i2, i3, i4);
    }

    public void setVertexAttribute(int i, int i2, int i3, boolean z, int i4, int i5) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glVertexAttribPointer(i, i2, i3, z, i4, i5);
    }

    public void setVertexAttribute(int i, int i2, int i3, boolean z, int i4, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        gl20.glVertexAttribPointer(i, i2, i3, z, i4, buffer);
    }

    public void setVertexAttribute(java.lang.String str, int i, int i2, boolean z, int i3, int i4) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        int d = d(str);
        if (d == -1) {
            return;
        }
        gl20.glVertexAttribPointer(d, i, i2, z, i3, i4);
    }

    public void setVertexAttribute(java.lang.String str, int i, int i2, boolean z, int i3, java.nio.Buffer buffer) {
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        b();
        int d = d(str);
        if (d == -1) {
            return;
        }
        gl20.glVertexAttribPointer(d, i, i2, z, i3, buffer);
    }
}
