package com.badlogic.gdx.graphics.glutils;

/* loaded from: classes12.dex */
public class ShapeRenderer implements com.badlogic.gdx.utils.Disposable {
    public final com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer a;
    public boolean b;
    public final com.badlogic.gdx.math.Matrix4 c;
    public final com.badlogic.gdx.math.Matrix4 d;
    public final com.badlogic.gdx.math.Matrix4 e;
    public final com.badlogic.gdx.math.Vector2 f;
    public final com.badlogic.gdx.graphics.Color g;
    public com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType h;
    public boolean i;
    public float j;

    public enum ShapeType {
        Point(0),
        Line(1),
        Filled(4);

        private final int glType;

        ShapeType(int i) {
            this.glType = i;
        }

        public int getGlType() {
            return this.glType;
        }
    }

    public ShapeRenderer() {
        this(5000);
    }

    public ShapeRenderer(int i) {
        this(i, null);
    }

    public ShapeRenderer(int i, com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram) {
        this.b = false;
        com.badlogic.gdx.math.Matrix4 matrix4 = new com.badlogic.gdx.math.Matrix4();
        this.c = matrix4;
        this.d = new com.badlogic.gdx.math.Matrix4();
        this.e = new com.badlogic.gdx.math.Matrix4();
        this.f = new com.badlogic.gdx.math.Vector2();
        this.g = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.j = 0.75f;
        if (shaderProgram == null) {
            this.a = new com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20(i, false, true, 0);
        } else {
            this.a = new com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer20(i, false, true, 0, shaderProgram);
        }
        matrix4.setToOrtho2D(0.0f, 0.0f, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
        this.b = true;
    }

    public final void a(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType2, int i) {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType3 = this.h;
        if (shapeType3 == null) {
            throw new java.lang.IllegalStateException("begin must be called first.");
        }
        if (shapeType3 == shapeType || shapeType3 == shapeType2) {
            if (this.b) {
                end();
                begin(shapeType3);
                return;
            } else {
                if (this.a.getMaxVertices() - this.a.getNumVertices() < i) {
                    com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType4 = this.h;
                    end();
                    begin(shapeType4);
                    return;
                }
                return;
            }
        }
        if (this.i) {
            end();
            begin(shapeType);
            return;
        }
        if (shapeType2 == null) {
            throw new java.lang.IllegalStateException("Must call begin(ShapeType." + shapeType + ").");
        }
        throw new java.lang.IllegalStateException("Must call begin(ShapeType." + shapeType + ") or begin(ShapeType." + shapeType2 + ").");
    }

    public void arc(float f, float f2, float f3, float f4, float f5) {
        arc(f, f2, f3, f4, f5, java.lang.Math.max(1, (int) (((float) java.lang.Math.cbrt(f3)) * 6.0f * (f5 / 360.0f))));
    }

    public void arc(float f, float f2, float f3, float f4, float f5, int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("segments must be > 0.");
        }
        float floatBits = this.g.toFloatBits();
        float f6 = ((f5 / 360.0f) * 6.2831855f) / i;
        float cos = com.badlogic.gdx.math.MathUtils.cos(f6);
        float sin = com.badlogic.gdx.math.MathUtils.sin(f6);
        float f7 = f4 * 0.017453292f;
        float cos2 = com.badlogic.gdx.math.MathUtils.cos(f7) * f3;
        float sin2 = f3 * com.badlogic.gdx.math.MathUtils.sin(f7);
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = this.h;
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType2 = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        int i2 = 0;
        if (shapeType == shapeType2) {
            a(shapeType2, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, (i * 2) + 2);
            this.a.color(floatBits);
            this.a.vertex(f, f2, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f + cos2, f2 + sin2, 0.0f);
            while (i2 < i) {
                this.a.color(floatBits);
                this.a.vertex(f + cos2, f2 + sin2, 0.0f);
                float f8 = (cos * cos2) - (sin * sin2);
                sin2 = (sin2 * cos) + (cos2 * sin);
                this.a.color(floatBits);
                this.a.vertex(f + f8, f2 + sin2, 0.0f);
                i2++;
                cos2 = f8;
            }
            this.a.color(floatBits);
            this.a.vertex(cos2 + f, sin2 + f2, 0.0f);
        } else {
            a(shapeType2, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, (i * 3) + 3);
            while (i2 < i) {
                this.a.color(floatBits);
                this.a.vertex(f, f2, 0.0f);
                this.a.color(floatBits);
                this.a.vertex(f + cos2, f2 + sin2, 0.0f);
                float f9 = (cos * cos2) - (sin * sin2);
                sin2 = (sin2 * cos) + (cos2 * sin);
                this.a.color(floatBits);
                this.a.vertex(f + f9, f2 + sin2, 0.0f);
                i2++;
                cos2 = f9;
            }
            this.a.color(floatBits);
            this.a.vertex(f, f2, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(cos2 + f, sin2 + f2, 0.0f);
        }
        this.a.color(floatBits);
        this.a.vertex(f + 0.0f, f2 + 0.0f, 0.0f);
    }

    public void begin() {
        if (!this.i) {
            throw new java.lang.IllegalStateException("autoShapeType must be true to use this method.");
        }
        begin(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line);
    }

    public void begin(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType) {
        if (this.h != null) {
            throw new java.lang.IllegalStateException("Call end() before beginning a new shape batch.");
        }
        this.h = shapeType;
        if (this.b) {
            this.e.set(this.c);
            com.badlogic.gdx.math.Matrix4.mul(this.e.val, this.d.val);
            this.b = false;
        }
        this.a.begin(this.e, this.h.getGlType());
    }

    public void box(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = -f6;
        float floatBits = this.g.toFloatBits();
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = this.h;
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType2 = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        if (shapeType == shapeType2) {
            a(shapeType2, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, 24);
            this.a.color(floatBits);
            this.a.vertex(f, f2, f3);
            this.a.color(floatBits);
            float f8 = f4 + f;
            this.a.vertex(f8, f2, f3);
            this.a.color(floatBits);
            this.a.vertex(f8, f2, f3);
            this.a.color(floatBits);
            float f9 = f7 + f3;
            this.a.vertex(f8, f2, f9);
            this.a.color(floatBits);
            this.a.vertex(f8, f2, f9);
            this.a.color(floatBits);
            this.a.vertex(f, f2, f9);
            this.a.color(floatBits);
            this.a.vertex(f, f2, f9);
            this.a.color(floatBits);
            this.a.vertex(f, f2, f3);
            this.a.color(floatBits);
            this.a.vertex(f, f2, f3);
            this.a.color(floatBits);
            float f10 = f5 + f2;
            this.a.vertex(f, f10, f3);
            this.a.color(floatBits);
            this.a.vertex(f, f10, f3);
            this.a.color(floatBits);
            this.a.vertex(f8, f10, f3);
            this.a.color(floatBits);
            this.a.vertex(f8, f10, f3);
            this.a.color(floatBits);
            this.a.vertex(f8, f10, f9);
            this.a.color(floatBits);
            this.a.vertex(f8, f10, f9);
            this.a.color(floatBits);
            this.a.vertex(f, f10, f9);
            this.a.color(floatBits);
            this.a.vertex(f, f10, f9);
            this.a.color(floatBits);
            this.a.vertex(f, f10, f3);
            this.a.color(floatBits);
            this.a.vertex(f8, f2, f3);
            this.a.color(floatBits);
            this.a.vertex(f8, f10, f3);
            this.a.color(floatBits);
            this.a.vertex(f8, f2, f9);
            this.a.color(floatBits);
            this.a.vertex(f8, f10, f9);
            this.a.color(floatBits);
            this.a.vertex(f, f2, f9);
            this.a.color(floatBits);
            this.a.vertex(f, f10, f9);
            return;
        }
        a(shapeType2, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, 36);
        this.a.color(floatBits);
        this.a.vertex(f, f2, f3);
        this.a.color(floatBits);
        float f11 = f4 + f;
        this.a.vertex(f11, f2, f3);
        this.a.color(floatBits);
        float f12 = f5 + f2;
        this.a.vertex(f11, f12, f3);
        this.a.color(floatBits);
        this.a.vertex(f, f2, f3);
        this.a.color(floatBits);
        this.a.vertex(f11, f12, f3);
        this.a.color(floatBits);
        this.a.vertex(f, f12, f3);
        this.a.color(floatBits);
        float f13 = f7 + f3;
        this.a.vertex(f11, f2, f13);
        this.a.color(floatBits);
        this.a.vertex(f, f2, f13);
        this.a.color(floatBits);
        this.a.vertex(f11, f12, f13);
        this.a.color(floatBits);
        this.a.vertex(f, f12, f13);
        this.a.color(floatBits);
        this.a.vertex(f, f2, f13);
        this.a.color(floatBits);
        this.a.vertex(f11, f12, f13);
        this.a.color(floatBits);
        this.a.vertex(f, f2, f13);
        this.a.color(floatBits);
        this.a.vertex(f, f2, f3);
        this.a.color(floatBits);
        this.a.vertex(f, f12, f3);
        this.a.color(floatBits);
        this.a.vertex(f, f2, f13);
        this.a.color(floatBits);
        this.a.vertex(f, f12, f3);
        this.a.color(floatBits);
        this.a.vertex(f, f12, f13);
        this.a.color(floatBits);
        this.a.vertex(f11, f2, f3);
        this.a.color(floatBits);
        this.a.vertex(f11, f2, f13);
        this.a.color(floatBits);
        this.a.vertex(f11, f12, f13);
        this.a.color(floatBits);
        this.a.vertex(f11, f2, f3);
        this.a.color(floatBits);
        this.a.vertex(f11, f12, f13);
        this.a.color(floatBits);
        this.a.vertex(f11, f12, f3);
        this.a.color(floatBits);
        this.a.vertex(f, f12, f3);
        this.a.color(floatBits);
        this.a.vertex(f11, f12, f3);
        this.a.color(floatBits);
        this.a.vertex(f11, f12, f13);
        this.a.color(floatBits);
        this.a.vertex(f, f12, f3);
        this.a.color(floatBits);
        this.a.vertex(f11, f12, f13);
        this.a.color(floatBits);
        this.a.vertex(f, f12, f13);
        this.a.color(floatBits);
        this.a.vertex(f, f2, f13);
        this.a.color(floatBits);
        this.a.vertex(f11, f2, f13);
        this.a.color(floatBits);
        this.a.vertex(f11, f2, f3);
        this.a.color(floatBits);
        this.a.vertex(f, f2, f13);
        this.a.color(floatBits);
        this.a.vertex(f11, f2, f3);
        this.a.color(floatBits);
        this.a.vertex(f, f2, f3);
    }

    public void circle(float f, float f2, float f3) {
        circle(f, f2, f3, java.lang.Math.max(1, (int) (((float) java.lang.Math.cbrt(f3)) * 6.0f)));
    }

    public void circle(float f, float f2, float f3, int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("segments must be > 0.");
        }
        float floatBits = this.g.toFloatBits();
        float f4 = 6.2831855f / i;
        float cos = com.badlogic.gdx.math.MathUtils.cos(f4);
        float sin = com.badlogic.gdx.math.MathUtils.sin(f4);
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = this.h;
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType2 = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        int i2 = 0;
        if (shapeType == shapeType2) {
            a(shapeType2, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, (i * 2) + 2);
            float f5 = f3;
            float f6 = 0.0f;
            while (i2 < i) {
                this.a.color(floatBits);
                this.a.vertex(f + f5, f2 + f6, 0.0f);
                float f7 = (cos * f5) - (sin * f6);
                f6 = (f6 * cos) + (f5 * sin);
                this.a.color(floatBits);
                this.a.vertex(f + f7, f2 + f6, 0.0f);
                i2++;
                f5 = f7;
            }
            this.a.color(floatBits);
            this.a.vertex(f5 + f, f6 + f2, 0.0f);
        } else {
            a(shapeType2, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, (i * 3) + 3);
            int i3 = i - 1;
            float f8 = f3;
            float f9 = 0.0f;
            while (i2 < i3) {
                this.a.color(floatBits);
                this.a.vertex(f, f2, 0.0f);
                this.a.color(floatBits);
                this.a.vertex(f + f8, f2 + f9, 0.0f);
                float f10 = (cos * f8) - (sin * f9);
                f9 = (f9 * cos) + (f8 * sin);
                this.a.color(floatBits);
                this.a.vertex(f + f10, f2 + f9, 0.0f);
                i2++;
                f8 = f10;
            }
            this.a.color(floatBits);
            this.a.vertex(f, f2, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f8 + f, f9 + f2, 0.0f);
        }
        this.a.color(floatBits);
        this.a.vertex(f + f3, f2 + 0.0f, 0.0f);
    }

    public void cone(float f, float f2, float f3, float f4, float f5) {
        cone(f, f2, f3, f4, f5, java.lang.Math.max(1, (int) (((float) java.lang.Math.sqrt(f4)) * 4.0f)));
    }

    public void cone(float f, float f2, float f3, float f4, float f5, int i) {
        float f6;
        float f7;
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("segments must be > 0.");
        }
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        a(shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, (i * 4) + 2);
        float floatBits = this.g.toFloatBits();
        float f8 = 6.2831855f / i;
        float cos = com.badlogic.gdx.math.MathUtils.cos(f8);
        float sin = com.badlogic.gdx.math.MathUtils.sin(f8);
        int i2 = 0;
        if (this.h == shapeType) {
            f6 = f4;
            f7 = 0.0f;
            while (i2 < i) {
                this.a.color(floatBits);
                float f9 = f + f6;
                float f10 = f2 + f7;
                this.a.vertex(f9, f10, f3);
                this.a.color(floatBits);
                this.a.vertex(f, f2, f3 + f5);
                this.a.color(floatBits);
                this.a.vertex(f9, f10, f3);
                float f11 = (cos * f6) - (sin * f7);
                f7 = (f7 * cos) + (f6 * sin);
                this.a.color(floatBits);
                this.a.vertex(f + f11, f2 + f7, f3);
                i2++;
                f6 = f11;
            }
            this.a.color(floatBits);
            this.a.vertex(f + f6, f2 + f7, f3);
        } else {
            int i3 = i - 1;
            f6 = f4;
            f7 = 0.0f;
            while (i2 < i3) {
                this.a.color(floatBits);
                this.a.vertex(f, f2, f3);
                this.a.color(floatBits);
                float f12 = f + f6;
                float f13 = f2 + f7;
                this.a.vertex(f12, f13, f3);
                float f14 = (cos * f6) - (sin * f7);
                f7 = (f7 * cos) + (f6 * sin);
                this.a.color(floatBits);
                float f15 = f + f14;
                float f16 = f2 + f7;
                this.a.vertex(f15, f16, f3);
                this.a.color(floatBits);
                this.a.vertex(f12, f13, f3);
                this.a.color(floatBits);
                this.a.vertex(f15, f16, f3);
                this.a.color(floatBits);
                this.a.vertex(f, f2, f3 + f5);
                i2++;
                f6 = f14;
            }
            this.a.color(floatBits);
            this.a.vertex(f, f2, f3);
            this.a.color(floatBits);
            this.a.vertex(f + f6, f2 + f7, f3);
        }
        this.a.color(floatBits);
        float f17 = f + f4;
        float f18 = 0.0f + f2;
        this.a.vertex(f17, f18, f3);
        if (this.h != com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line) {
            this.a.color(floatBits);
            this.a.vertex(f6 + f, f7 + f2, f3);
            this.a.color(floatBits);
            this.a.vertex(f17, f18, f3);
            this.a.color(floatBits);
            this.a.vertex(f, f2, f3 + f5);
        }
    }

    public void curve(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) {
        a(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line, null, (i * 2) + 2);
        float floatBits = this.g.toFloatBits();
        float f9 = 1.0f / i;
        float f10 = f9 * f9;
        float f11 = f10 * f9;
        float f12 = f9 * 3.0f;
        float f13 = f10 * 3.0f;
        float f14 = f10 * 6.0f;
        float f15 = 6.0f * f11;
        float f16 = (f - (f3 * 2.0f)) + f5;
        float f17 = (f2 - (2.0f * f4)) + f6;
        float f18 = (((f3 - f5) * 3.0f) - f) + f7;
        float f19 = (((f4 - f6) * 3.0f) - f2) + f8;
        float f20 = ((f3 - f) * f12) + (f16 * f13) + (f18 * f11);
        float f21 = ((f4 - f2) * f12) + (f13 * f17) + (f11 * f19);
        float f22 = f18 * f15;
        float f23 = (f16 * f14) + f22;
        float f24 = f19 * f15;
        float f25 = (f17 * f14) + f24;
        float f26 = f2;
        int i2 = i;
        float f27 = f;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                this.a.color(floatBits);
                this.a.vertex(f27, f26, 0.0f);
                this.a.color(floatBits);
                this.a.vertex(f7, f8, 0.0f);
                return;
            }
            this.a.color(floatBits);
            this.a.vertex(f27, f26, 0.0f);
            f27 += f20;
            f26 += f21;
            f20 += f23;
            f21 += f25;
            f23 += f22;
            f25 += f24;
            this.a.color(floatBits);
            this.a.vertex(f27, f26, 0.0f);
            i2 = i3;
        }
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        this.a.dispose();
    }

    public void ellipse(float f, float f2, float f3, float f4) {
        ellipse(f, f2, f3, f4, java.lang.Math.max(1, (int) (((float) java.lang.Math.cbrt(java.lang.Math.max(f3 * 0.5f, 0.5f * f4))) * 12.0f)));
    }

    public void ellipse(float f, float f2, float f3, float f4, float f5) {
        ellipse(f, f2, f3, f4, f5, java.lang.Math.max(1, (int) (((float) java.lang.Math.cbrt(java.lang.Math.max(f3 * 0.5f, 0.5f * f4))) * 12.0f)));
    }

    public void ellipse(float f, float f2, float f3, float f4, float f5, int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("segments must be > 0.");
        }
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        a(shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, i * 3);
        float floatBits = this.g.toFloatBits();
        float f6 = 6.2831855f / i;
        float f7 = (3.1415927f * f5) / 180.0f;
        float sin = com.badlogic.gdx.math.MathUtils.sin(f7);
        float cos = com.badlogic.gdx.math.MathUtils.cos(f7);
        float f8 = f + (f3 / 2.0f);
        float f9 = f2 + (f4 / 2.0f);
        float f10 = 0.5f;
        float f11 = f3 * 0.5f;
        int i2 = 0;
        if (this.h == shapeType) {
            float f12 = f11;
            float f13 = 0.0f;
            while (i2 < i) {
                this.a.color(floatBits);
                this.a.vertex(((cos * f12) + f8) - (sin * f13), (f12 * sin) + f9 + (f13 * cos), 0.0f);
                i2++;
                float f14 = i2 * f6;
                float cos2 = com.badlogic.gdx.math.MathUtils.cos(f14) * f11;
                float sin2 = com.badlogic.gdx.math.MathUtils.sin(f14) * f4 * f10;
                this.a.color(floatBits);
                this.a.vertex(((cos * cos2) + f8) - (sin * sin2), f9 + (sin * cos2) + (cos * sin2), 0.0f);
                f10 = 0.5f;
                f13 = sin2;
                f12 = cos2;
            }
            return;
        }
        float f15 = f11;
        float f16 = 0.0f;
        while (i2 < i) {
            this.a.color(floatBits);
            this.a.vertex(((cos * f15) + f8) - (sin * f16), (f15 * sin) + f9 + (f16 * cos), 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f8, f9, 0.0f);
            i2++;
            float f17 = i2 * f6;
            float cos3 = com.badlogic.gdx.math.MathUtils.cos(f17) * f11;
            float sin3 = com.badlogic.gdx.math.MathUtils.sin(f17) * f4 * 0.5f;
            this.a.color(floatBits);
            this.a.vertex(((cos * cos3) + f8) - (sin * sin3), f9 + (sin * cos3) + (cos * sin3), 0.0f);
            f16 = sin3;
            f15 = cos3;
        }
    }

    public void ellipse(float f, float f2, float f3, float f4, int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("segments must be > 0.");
        }
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        a(shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, i * 3);
        float floatBits = this.g.toFloatBits();
        float f5 = 6.2831855f / i;
        float f6 = f + (f3 / 2.0f);
        float f7 = f2 + (f4 / 2.0f);
        int i2 = 0;
        if (this.h == shapeType) {
            while (i2 < i) {
                this.a.color(floatBits);
                float f8 = f3 * 0.5f;
                float f9 = i2 * f5;
                float f10 = f4 * 0.5f;
                this.a.vertex((com.badlogic.gdx.math.MathUtils.cos(f9) * f8) + f6, (com.badlogic.gdx.math.MathUtils.sin(f9) * f10) + f7, 0.0f);
                this.a.color(floatBits);
                i2++;
                float f11 = i2 * f5;
                this.a.vertex((f8 * com.badlogic.gdx.math.MathUtils.cos(f11)) + f6, (f10 * com.badlogic.gdx.math.MathUtils.sin(f11)) + f7, 0.0f);
            }
            return;
        }
        while (i2 < i) {
            this.a.color(floatBits);
            float f12 = f3 * 0.5f;
            float f13 = i2 * f5;
            float f14 = f4 * 0.5f;
            this.a.vertex((com.badlogic.gdx.math.MathUtils.cos(f13) * f12) + f6, (com.badlogic.gdx.math.MathUtils.sin(f13) * f14) + f7, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f6, f7, 0.0f);
            this.a.color(floatBits);
            i2++;
            float f15 = i2 * f5;
            this.a.vertex((f12 * com.badlogic.gdx.math.MathUtils.cos(f15)) + f6, (f14 * com.badlogic.gdx.math.MathUtils.sin(f15)) + f7, 0.0f);
        }
    }

    public void end() {
        this.a.end();
        this.h = null;
    }

    public void flush() {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = this.h;
        end();
        begin(shapeType);
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.g;
    }

    public com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType getCurrentType() {
        return this.h;
    }

    public com.badlogic.gdx.math.Matrix4 getProjectionMatrix() {
        return this.c;
    }

    public com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer getRenderer() {
        return this.a;
    }

    public com.badlogic.gdx.math.Matrix4 getTransformMatrix() {
        return this.d;
    }

    public void identity() {
        this.d.idt();
        this.b = true;
    }

    public boolean isDrawing() {
        return this.h != null;
    }

    public final void line(float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.Color color = this.g;
        line(f, f2, 0.0f, f3, f4, 0.0f, color, color);
    }

    public final void line(float f, float f2, float f3, float f4, float f5, float f6) {
        com.badlogic.gdx.graphics.Color color = this.g;
        line(f, f2, f3, f4, f5, f6, color, color);
    }

    public void line(float f, float f2, float f3, float f4, float f5, float f6, com.badlogic.gdx.graphics.Color color, com.badlogic.gdx.graphics.Color color2) {
        if (this.h == com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled) {
            rectLine(f, f2, f4, f5, this.j, color, color2);
            return;
        }
        a(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line, null, 2);
        this.a.color(color.r, color.g, color.b, color.a);
        this.a.vertex(f, f2, f3);
        this.a.color(color2.r, color2.g, color2.b, color2.a);
        this.a.vertex(f4, f5, f6);
    }

    public final void line(float f, float f2, float f3, float f4, com.badlogic.gdx.graphics.Color color, com.badlogic.gdx.graphics.Color color2) {
        line(f, f2, 0.0f, f3, f4, 0.0f, color, color2);
    }

    public final void line(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22) {
        float f = vector2.x;
        float f2 = vector2.y;
        float f3 = vector22.x;
        float f4 = vector22.y;
        com.badlogic.gdx.graphics.Color color = this.g;
        line(f, f2, 0.0f, f3, f4, 0.0f, color, color);
    }

    public final void line(com.badlogic.gdx.math.Vector3 vector3, com.badlogic.gdx.math.Vector3 vector32) {
        float f = vector3.x;
        float f2 = vector3.y;
        float f3 = vector3.z;
        float f4 = vector32.x;
        float f5 = vector32.y;
        float f6 = vector32.z;
        com.badlogic.gdx.graphics.Color color = this.g;
        line(f, f2, f3, f4, f5, f6, color, color);
    }

    public void point(float f, float f2, float f3) {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = this.h;
        if (shapeType == com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line) {
            float f4 = this.j * 0.5f;
            line(f - f4, f2 - f4, f3, f + f4, f2 + f4, f3);
        } else if (shapeType == com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled) {
            float f5 = this.j;
            float f6 = 0.5f * f5;
            box(f - f6, f2 - f6, f3 - f6, f5, f5, f5);
        } else {
            a(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Point, null, 1);
            this.a.color(this.g);
            this.a.vertex(f, f2, f3);
        }
    }

    public void polygon(float[] fArr) {
        polygon(fArr, 0, fArr.length);
    }

    public void polygon(float[] fArr, int i, int i2) {
        float f;
        float f2;
        if (i2 < 6) {
            throw new java.lang.IllegalArgumentException("Polygons must contain at least 3 points.");
        }
        if (i2 % 2 != 0) {
            throw new java.lang.IllegalArgumentException("Polygons must have an even number of vertices.");
        }
        a(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line, null, i2);
        float floatBits = this.g.toFloatBits();
        float f3 = fArr[0];
        float f4 = fArr[1];
        int i3 = i + i2;
        while (i < i3) {
            float f5 = fArr[i];
            float f6 = fArr[i + 1];
            int i4 = i + 2;
            if (i4 >= i2) {
                f = f3;
                f2 = f4;
            } else {
                f = fArr[i4];
                f2 = fArr[i + 3];
            }
            this.a.color(floatBits);
            this.a.vertex(f5, f6, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f, f2, 0.0f);
            i = i4;
        }
    }

    public void polyline(float[] fArr) {
        polyline(fArr, 0, fArr.length);
    }

    public void polyline(float[] fArr, int i, int i2) {
        if (i2 < 4) {
            throw new java.lang.IllegalArgumentException("Polylines must contain at least 2 points.");
        }
        if (i2 % 2 != 0) {
            throw new java.lang.IllegalArgumentException("Polylines must have an even number of vertices.");
        }
        a(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line, null, i2);
        float floatBits = this.g.toFloatBits();
        int i3 = (i2 + i) - 2;
        while (i < i3) {
            float f = fArr[i];
            float f2 = fArr[i + 1];
            int i4 = i + 2;
            float f3 = fArr[i4];
            float f4 = fArr[i + 3];
            this.a.color(floatBits);
            this.a.vertex(f, f2, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f3, f4, 0.0f);
            i = i4;
        }
    }

    public void rect(float f, float f2, float f3, float f4) {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        a(shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, 8);
        float floatBits = this.g.toFloatBits();
        if (this.h != shapeType) {
            this.a.color(floatBits);
            this.a.vertex(f, f2, 0.0f);
            this.a.color(floatBits);
            float f5 = f3 + f;
            this.a.vertex(f5, f2, 0.0f);
            this.a.color(floatBits);
            float f6 = f4 + f2;
            this.a.vertex(f5, f6, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f5, f6, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f, f6, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f, f2, 0.0f);
            return;
        }
        this.a.color(floatBits);
        this.a.vertex(f, f2, 0.0f);
        this.a.color(floatBits);
        float f7 = f3 + f;
        this.a.vertex(f7, f2, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f7, f2, 0.0f);
        this.a.color(floatBits);
        float f8 = f4 + f2;
        this.a.vertex(f7, f8, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f7, f8, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f, f8, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f, f8, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f, f2, 0.0f);
    }

    public void rect(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        com.badlogic.gdx.graphics.Color color = this.g;
        rect(f, f2, f3, f4, f5, f6, f7, f8, f9, color, color, color, color);
    }

    public void rect(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, com.badlogic.gdx.graphics.Color color, com.badlogic.gdx.graphics.Color color2, com.badlogic.gdx.graphics.Color color3, com.badlogic.gdx.graphics.Color color4) {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        a(shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, 8);
        float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f9);
        float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(f9);
        float f10 = -f3;
        float f11 = -f4;
        float f12 = f5 - f3;
        float f13 = f6 - f4;
        if (f7 != 1.0f || f8 != 1.0f) {
            f10 *= f7;
            f11 *= f8;
            f12 *= f7;
            f13 *= f8;
        }
        float f14 = f + f3;
        float f15 = f2 + f4;
        float f16 = sinDeg * f11;
        float f17 = ((cosDeg * f10) - f16) + f14;
        float f18 = f11 * cosDeg;
        float f19 = (f10 * sinDeg) + f18 + f15;
        float f20 = cosDeg * f12;
        float f21 = (f20 - f16) + f14;
        float f22 = f12 * sinDeg;
        float f23 = f18 + f22 + f15;
        float f24 = (f20 - (sinDeg * f13)) + f14;
        float f25 = f22 + (cosDeg * f13) + f15;
        float f26 = (f24 - f21) + f17;
        float f27 = f25 - (f23 - f19);
        if (this.h != shapeType) {
            this.a.color(color.r, color.g, color.b, color.a);
            this.a.vertex(f17, f19, 0.0f);
            this.a.color(color2.r, color2.g, color2.b, color2.a);
            this.a.vertex(f21, f23, 0.0f);
            this.a.color(color3.r, color3.g, color3.b, color3.a);
            this.a.vertex(f24, f25, 0.0f);
            this.a.color(color3.r, color3.g, color3.b, color3.a);
            this.a.vertex(f24, f25, 0.0f);
            this.a.color(color4.r, color4.g, color4.b, color4.a);
            this.a.vertex(f26, f27, 0.0f);
            this.a.color(color.r, color.g, color.b, color.a);
            this.a.vertex(f17, f19, 0.0f);
            return;
        }
        this.a.color(color.r, color.g, color.b, color.a);
        this.a.vertex(f17, f19, 0.0f);
        this.a.color(color2.r, color2.g, color2.b, color2.a);
        this.a.vertex(f21, f23, 0.0f);
        this.a.color(color2.r, color2.g, color2.b, color2.a);
        this.a.vertex(f21, f23, 0.0f);
        this.a.color(color3.r, color3.g, color3.b, color3.a);
        this.a.vertex(f24, f25, 0.0f);
        this.a.color(color3.r, color3.g, color3.b, color3.a);
        this.a.vertex(f24, f25, 0.0f);
        this.a.color(color4.r, color4.g, color4.b, color4.a);
        this.a.vertex(f26, f27, 0.0f);
        this.a.color(color4.r, color4.g, color4.b, color4.a);
        this.a.vertex(f26, f27, 0.0f);
        this.a.color(color.r, color.g, color.b, color.a);
        this.a.vertex(f17, f19, 0.0f);
    }

    public void rect(float f, float f2, float f3, float f4, com.badlogic.gdx.graphics.Color color, com.badlogic.gdx.graphics.Color color2, com.badlogic.gdx.graphics.Color color3, com.badlogic.gdx.graphics.Color color4) {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        a(shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, 8);
        if (this.h != shapeType) {
            this.a.color(color.r, color.g, color.b, color.a);
            this.a.vertex(f, f2, 0.0f);
            this.a.color(color2.r, color2.g, color2.b, color2.a);
            float f5 = f3 + f;
            this.a.vertex(f5, f2, 0.0f);
            this.a.color(color3.r, color3.g, color3.b, color3.a);
            float f6 = f4 + f2;
            this.a.vertex(f5, f6, 0.0f);
            this.a.color(color3.r, color3.g, color3.b, color3.a);
            this.a.vertex(f5, f6, 0.0f);
            this.a.color(color4.r, color4.g, color4.b, color4.a);
            this.a.vertex(f, f6, 0.0f);
            this.a.color(color.r, color.g, color.b, color.a);
            this.a.vertex(f, f2, 0.0f);
            return;
        }
        this.a.color(color.r, color.g, color.b, color.a);
        this.a.vertex(f, f2, 0.0f);
        this.a.color(color2.r, color2.g, color2.b, color2.a);
        float f7 = f3 + f;
        this.a.vertex(f7, f2, 0.0f);
        this.a.color(color2.r, color2.g, color2.b, color2.a);
        this.a.vertex(f7, f2, 0.0f);
        this.a.color(color3.r, color3.g, color3.b, color3.a);
        float f8 = f4 + f2;
        this.a.vertex(f7, f8, 0.0f);
        this.a.color(color3.r, color3.g, color3.b, color3.a);
        this.a.vertex(f7, f8, 0.0f);
        this.a.color(color4.r, color4.g, color4.b, color4.a);
        this.a.vertex(f, f8, 0.0f);
        this.a.color(color4.r, color4.g, color4.b, color4.a);
        this.a.vertex(f, f8, 0.0f);
        this.a.color(color.r, color.g, color.b, color.a);
        this.a.vertex(f, f2, 0.0f);
    }

    public void rectLine(float f, float f2, float f3, float f4, float f5) {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        a(shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, 8);
        float floatBits = this.g.toFloatBits();
        com.badlogic.gdx.math.Vector2 nor = this.f.set(f4 - f2, f - f3).nor();
        float f6 = f5 * 0.5f;
        float f7 = nor.x * f6;
        float f8 = nor.y * f6;
        if (this.h != shapeType) {
            this.a.color(floatBits);
            this.a.vertex(f + f7, f2 + f8, 0.0f);
            this.a.color(floatBits);
            float f9 = f - f7;
            float f10 = f2 - f8;
            this.a.vertex(f9, f10, 0.0f);
            this.a.color(floatBits);
            float f11 = f3 + f7;
            float f12 = f4 + f8;
            this.a.vertex(f11, f12, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f3 - f7, f4 - f8, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f11, f12, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f9, f10, 0.0f);
            return;
        }
        this.a.color(floatBits);
        float f13 = f + f7;
        float f14 = f2 + f8;
        this.a.vertex(f13, f14, 0.0f);
        this.a.color(floatBits);
        float f15 = f - f7;
        float f16 = f2 - f8;
        this.a.vertex(f15, f16, 0.0f);
        this.a.color(floatBits);
        float f17 = f3 + f7;
        float f18 = f4 + f8;
        this.a.vertex(f17, f18, 0.0f);
        this.a.color(floatBits);
        float f19 = f3 - f7;
        float f20 = f4 - f8;
        this.a.vertex(f19, f20, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f17, f18, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f13, f14, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f19, f20, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f15, f16, 0.0f);
    }

    public void rectLine(float f, float f2, float f3, float f4, float f5, com.badlogic.gdx.graphics.Color color, com.badlogic.gdx.graphics.Color color2) {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        a(shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, 8);
        float floatBits = color.toFloatBits();
        float floatBits2 = color2.toFloatBits();
        com.badlogic.gdx.math.Vector2 nor = this.f.set(f4 - f2, f - f3).nor();
        float f6 = f5 * 0.5f;
        float f7 = nor.x * f6;
        float f8 = nor.y * f6;
        if (this.h != shapeType) {
            this.a.color(floatBits);
            this.a.vertex(f + f7, f2 + f8, 0.0f);
            this.a.color(floatBits);
            float f9 = f - f7;
            float f10 = f2 - f8;
            this.a.vertex(f9, f10, 0.0f);
            this.a.color(floatBits2);
            float f11 = f3 + f7;
            float f12 = f4 + f8;
            this.a.vertex(f11, f12, 0.0f);
            this.a.color(floatBits2);
            this.a.vertex(f3 - f7, f4 - f8, 0.0f);
            this.a.color(floatBits2);
            this.a.vertex(f11, f12, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f9, f10, 0.0f);
            return;
        }
        this.a.color(floatBits);
        float f13 = f + f7;
        float f14 = f2 + f8;
        this.a.vertex(f13, f14, 0.0f);
        this.a.color(floatBits);
        float f15 = f - f7;
        float f16 = f2 - f8;
        this.a.vertex(f15, f16, 0.0f);
        this.a.color(floatBits2);
        float f17 = f3 + f7;
        float f18 = f4 + f8;
        this.a.vertex(f17, f18, 0.0f);
        this.a.color(floatBits2);
        float f19 = f3 - f7;
        float f20 = f4 - f8;
        this.a.vertex(f19, f20, 0.0f);
        this.a.color(floatBits2);
        this.a.vertex(f17, f18, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f13, f14, 0.0f);
        this.a.color(floatBits2);
        this.a.vertex(f19, f20, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f15, f16, 0.0f);
    }

    public void rectLine(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22, float f) {
        rectLine(vector2.x, vector2.y, vector22.x, vector22.y, f);
    }

    public void rotate(float f, float f2, float f3, float f4) {
        this.d.rotate(f, f2, f3, f4);
        this.b = true;
    }

    public void scale(float f, float f2, float f3) {
        this.d.scale(f, f2, f3);
        this.b = true;
    }

    public void set(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType) {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType2 = this.h;
        if (shapeType2 == shapeType) {
            return;
        }
        if (shapeType2 == null) {
            throw new java.lang.IllegalStateException("begin must be called first.");
        }
        if (!this.i) {
            throw new java.lang.IllegalStateException("autoShapeType must be enabled.");
        }
        end();
        begin(shapeType);
    }

    public void setAutoShapeType(boolean z) {
        this.i = z;
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.g.set(f, f2, f3, f4);
    }

    public void setColor(com.badlogic.gdx.graphics.Color color) {
        this.g.set(color);
    }

    public void setProjectionMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        this.c.set(matrix4);
        this.b = true;
    }

    public void setTransformMatrix(com.badlogic.gdx.math.Matrix4 matrix4) {
        this.d.set(matrix4);
        this.b = true;
    }

    public void translate(float f, float f2, float f3) {
        this.d.translate(f, f2, f3);
        this.b = true;
    }

    public void triangle(float f, float f2, float f3, float f4, float f5, float f6) {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        a(shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, 6);
        float floatBits = this.g.toFloatBits();
        if (this.h != shapeType) {
            this.a.color(floatBits);
            this.a.vertex(f, f2, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f3, f4, 0.0f);
            this.a.color(floatBits);
            this.a.vertex(f5, f6, 0.0f);
            return;
        }
        this.a.color(floatBits);
        this.a.vertex(f, f2, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f3, f4, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f3, f4, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f5, f6, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f5, f6, 0.0f);
        this.a.color(floatBits);
        this.a.vertex(f, f2, 0.0f);
    }

    public void triangle(float f, float f2, float f3, float f4, float f5, float f6, com.badlogic.gdx.graphics.Color color, com.badlogic.gdx.graphics.Color color2, com.badlogic.gdx.graphics.Color color3) {
        com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType shapeType = com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line;
        a(shapeType, com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled, 6);
        if (this.h != shapeType) {
            this.a.color(color.r, color.g, color.b, color.a);
            this.a.vertex(f, f2, 0.0f);
            this.a.color(color2.r, color2.g, color2.b, color2.a);
            this.a.vertex(f3, f4, 0.0f);
            this.a.color(color3.r, color3.g, color3.b, color3.a);
            this.a.vertex(f5, f6, 0.0f);
            return;
        }
        this.a.color(color.r, color.g, color.b, color.a);
        this.a.vertex(f, f2, 0.0f);
        this.a.color(color2.r, color2.g, color2.b, color2.a);
        this.a.vertex(f3, f4, 0.0f);
        this.a.color(color2.r, color2.g, color2.b, color2.a);
        this.a.vertex(f3, f4, 0.0f);
        this.a.color(color3.r, color3.g, color3.b, color3.a);
        this.a.vertex(f5, f6, 0.0f);
        this.a.color(color3.r, color3.g, color3.b, color3.a);
        this.a.vertex(f5, f6, 0.0f);
        this.a.color(color.r, color.g, color.b, color.a);
        this.a.vertex(f, f2, 0.0f);
    }

    public void updateMatrices() {
        this.b = true;
    }

    public void x(float f, float f2, float f3) {
        float f4 = f - f3;
        float f5 = f2 - f3;
        float f6 = f + f3;
        float f7 = f2 + f3;
        line(f4, f5, f6, f7);
        line(f4, f7, f6, f5);
    }

    public void x(com.badlogic.gdx.math.Vector2 vector2, float f) {
        x(vector2.x, vector2.y, f);
    }
}
