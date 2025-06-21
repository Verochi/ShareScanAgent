package com.badlogic.gdx.scenes.scene2d.utils;

/* loaded from: classes12.dex */
public class ScissorStack {
    public static com.badlogic.gdx.utils.Array<com.badlogic.gdx.math.Rectangle> a = new com.badlogic.gdx.utils.Array<>();
    public static com.badlogic.gdx.math.Vector3 b = new com.badlogic.gdx.math.Vector3();
    public static final com.badlogic.gdx.math.Rectangle c = new com.badlogic.gdx.math.Rectangle();

    public static void a(com.badlogic.gdx.math.Rectangle rectangle) {
        rectangle.x = java.lang.Math.round(rectangle.x);
        rectangle.y = java.lang.Math.round(rectangle.y);
        rectangle.width = java.lang.Math.round(rectangle.width);
        float round = java.lang.Math.round(rectangle.height);
        rectangle.height = round;
        float f = rectangle.width;
        if (f < 0.0f) {
            float f2 = -f;
            rectangle.width = f2;
            rectangle.x -= f2;
        }
        if (round < 0.0f) {
            float f3 = -round;
            rectangle.height = f3;
            rectangle.y -= f3;
        }
    }

    public static void calculateScissors(com.badlogic.gdx.graphics.Camera camera, float f, float f2, float f3, float f4, com.badlogic.gdx.math.Matrix4 matrix4, com.badlogic.gdx.math.Rectangle rectangle, com.badlogic.gdx.math.Rectangle rectangle2) {
        b.set(rectangle.x, rectangle.y, 0.0f);
        b.mul(matrix4);
        camera.project(b, f, f2, f3, f4);
        com.badlogic.gdx.math.Vector3 vector3 = b;
        rectangle2.x = vector3.x;
        rectangle2.y = vector3.y;
        vector3.set(rectangle.x + rectangle.width, rectangle.y + rectangle.height, 0.0f);
        b.mul(matrix4);
        camera.project(b, f, f2, f3, f4);
        com.badlogic.gdx.math.Vector3 vector32 = b;
        rectangle2.width = vector32.x - rectangle2.x;
        rectangle2.height = vector32.y - rectangle2.y;
    }

    public static void calculateScissors(com.badlogic.gdx.graphics.Camera camera, com.badlogic.gdx.math.Matrix4 matrix4, com.badlogic.gdx.math.Rectangle rectangle, com.badlogic.gdx.math.Rectangle rectangle2) {
        calculateScissors(camera, 0.0f, 0.0f, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight(), matrix4, rectangle, rectangle2);
    }

    public static com.badlogic.gdx.math.Rectangle getViewport() {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.math.Rectangle> array = a;
        if (array.size == 0) {
            com.badlogic.gdx.math.Rectangle rectangle = c;
            rectangle.set(0.0f, 0.0f, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
            return rectangle;
        }
        com.badlogic.gdx.math.Rectangle peek = array.peek();
        com.badlogic.gdx.math.Rectangle rectangle2 = c;
        rectangle2.set(peek);
        return rectangle2;
    }

    public static com.badlogic.gdx.math.Rectangle peekScissors() {
        return a.peek();
    }

    public static com.badlogic.gdx.math.Rectangle popScissors() {
        com.badlogic.gdx.math.Rectangle pop = a.pop();
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.math.Rectangle> array = a;
        if (array.size == 0) {
            com.badlogic.gdx.Gdx.gl.glDisable(com.badlogic.gdx.graphics.GL20.GL_SCISSOR_TEST);
        } else {
            com.badlogic.gdx.math.Rectangle peek = array.peek();
            com.badlogic.gdx.graphics.glutils.HdpiUtils.glScissor((int) peek.x, (int) peek.y, (int) peek.width, (int) peek.height);
        }
        return pop;
    }

    public static boolean pushScissors(com.badlogic.gdx.math.Rectangle rectangle) {
        a(rectangle);
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.math.Rectangle> array = a;
        int i = array.size;
        if (i != 0) {
            com.badlogic.gdx.math.Rectangle rectangle2 = array.get(i - 1);
            float max = java.lang.Math.max(rectangle2.x, rectangle.x);
            float min = java.lang.Math.min(rectangle2.x + rectangle2.width, rectangle.x + rectangle.width) - max;
            if (min < 1.0f) {
                return false;
            }
            float max2 = java.lang.Math.max(rectangle2.y, rectangle.y);
            float min2 = java.lang.Math.min(rectangle2.y + rectangle2.height, rectangle.y + rectangle.height) - max2;
            if (min2 < 1.0f) {
                return false;
            }
            rectangle.x = max;
            rectangle.y = max2;
            rectangle.width = min;
            rectangle.height = java.lang.Math.max(1.0f, min2);
        } else {
            if (rectangle.width < 1.0f || rectangle.height < 1.0f) {
                return false;
            }
            com.badlogic.gdx.Gdx.gl.glEnable(com.badlogic.gdx.graphics.GL20.GL_SCISSOR_TEST);
        }
        a.add(rectangle);
        com.badlogic.gdx.graphics.glutils.HdpiUtils.glScissor((int) rectangle.x, (int) rectangle.y, (int) rectangle.width, (int) rectangle.height);
        return true;
    }
}
