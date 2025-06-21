package com.badlogic.gdx.graphics.profiling;

/* loaded from: classes12.dex */
public abstract class GLProfiler {
    public static int calls;
    public static int drawCalls;
    public static int shaderSwitches;
    public static int textureBindings;
    public static final com.badlogic.gdx.math.FloatCounter vertexCount = new com.badlogic.gdx.math.FloatCounter(0);
    public static com.badlogic.gdx.graphics.profiling.GLErrorListener listener = com.badlogic.gdx.graphics.profiling.GLErrorListener.LOGGING_LISTENER;

    public static void disable() {
        com.badlogic.gdx.graphics.GL30 gl30 = com.badlogic.gdx.Gdx.gl30;
        if (gl30 != null && (gl30 instanceof com.badlogic.gdx.graphics.profiling.GL30Profiler)) {
            com.badlogic.gdx.Gdx.gl30 = ((com.badlogic.gdx.graphics.profiling.GL30Profiler) gl30).gl30;
        }
        com.badlogic.gdx.graphics.GL20 gl20 = com.badlogic.gdx.Gdx.gl20;
        if (gl20 != null && (gl20 instanceof com.badlogic.gdx.graphics.profiling.GL30Profiler)) {
            com.badlogic.gdx.Gdx.gl20 = ((com.badlogic.gdx.graphics.profiling.GL30Profiler) com.badlogic.gdx.Gdx.gl).gl30;
        }
        com.badlogic.gdx.graphics.GL20 gl202 = com.badlogic.gdx.Gdx.gl20;
        if (gl202 != null && (gl202 instanceof com.badlogic.gdx.graphics.profiling.GL20Profiler)) {
            com.badlogic.gdx.Gdx.gl20 = ((com.badlogic.gdx.graphics.profiling.GL20Profiler) com.badlogic.gdx.Gdx.gl).gl20;
        }
        com.badlogic.gdx.graphics.GL20 gl203 = com.badlogic.gdx.Gdx.gl;
        if (gl203 == null || !(gl203 instanceof com.badlogic.gdx.graphics.profiling.GL20Profiler)) {
            return;
        }
        com.badlogic.gdx.Gdx.gl = ((com.badlogic.gdx.graphics.profiling.GL20Profiler) gl203).gl20;
    }

    public static void enable() {
        if (isEnabled()) {
            return;
        }
        com.badlogic.gdx.graphics.GL30 gl30 = com.badlogic.gdx.Gdx.gl30;
        com.badlogic.gdx.graphics.profiling.GL30Profiler gL30Profiler = gl30 == null ? null : new com.badlogic.gdx.graphics.profiling.GL30Profiler(gl30);
        com.badlogic.gdx.Gdx.gl30 = gL30Profiler;
        com.badlogic.gdx.graphics.GL20 gl20 = gL30Profiler;
        if (gL30Profiler == null) {
            gl20 = new com.badlogic.gdx.graphics.profiling.GL20Profiler(com.badlogic.gdx.Gdx.gl20);
        }
        com.badlogic.gdx.Gdx.gl20 = gl20;
        com.badlogic.gdx.Gdx.gl = gl20;
    }

    public static boolean isEnabled() {
        return (com.badlogic.gdx.Gdx.gl30 instanceof com.badlogic.gdx.graphics.profiling.GL30Profiler) || (com.badlogic.gdx.Gdx.gl20 instanceof com.badlogic.gdx.graphics.profiling.GL20Profiler);
    }

    public static void reset() {
        calls = 0;
        textureBindings = 0;
        drawCalls = 0;
        shaderSwitches = 0;
        vertexCount.reset();
    }

    public static java.lang.String resolveErrorNumber(int i) {
        switch (i) {
            case 1280:
                return "GL_INVALID_ENUM";
            case com.badlogic.gdx.graphics.GL20.GL_INVALID_VALUE /* 1281 */:
                return "GL_INVALID_VALUE";
            case com.badlogic.gdx.graphics.GL20.GL_INVALID_OPERATION /* 1282 */:
                return "GL_INVALID_OPERATION";
            case 1283:
            case 1284:
            default:
                return "number " + i;
            case com.badlogic.gdx.graphics.GL20.GL_OUT_OF_MEMORY /* 1285 */:
                return "GL_OUT_OF_MEMORY";
            case com.badlogic.gdx.graphics.GL20.GL_INVALID_FRAMEBUFFER_OPERATION /* 1286 */:
                return "GL_INVALID_FRAMEBUFFER_OPERATION";
        }
    }
}
