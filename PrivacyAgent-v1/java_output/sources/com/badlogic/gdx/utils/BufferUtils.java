package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public final class BufferUtils {
    public static com.badlogic.gdx.utils.Array<java.nio.ByteBuffer> a = new com.badlogic.gdx.utils.Array<>();
    public static int b = 0;

    public static int a(java.nio.Buffer buffer, int i) {
        if (buffer instanceof java.nio.ByteBuffer) {
            return i;
        }
        if (!(buffer instanceof java.nio.ShortBuffer) && !(buffer instanceof java.nio.CharBuffer)) {
            if (buffer instanceof java.nio.IntBuffer) {
                return i >>> 2;
            }
            if (buffer instanceof java.nio.LongBuffer) {
                return i >>> 3;
            }
            if (buffer instanceof java.nio.FloatBuffer) {
                return i >>> 2;
            }
            if (buffer instanceof java.nio.DoubleBuffer) {
                return i >>> 3;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Can't copy to a " + buffer.getClass().getName() + " instance");
        }
        return i >>> 1;
    }

    public static int b(java.nio.Buffer buffer, int i) {
        if (buffer instanceof java.nio.ByteBuffer) {
            return i;
        }
        if (!(buffer instanceof java.nio.ShortBuffer) && !(buffer instanceof java.nio.CharBuffer)) {
            if (buffer instanceof java.nio.IntBuffer) {
                return i << 2;
            }
            if (buffer instanceof java.nio.LongBuffer) {
                return i << 3;
            }
            if (buffer instanceof java.nio.FloatBuffer) {
                return i << 2;
            }
            if (buffer instanceof java.nio.DoubleBuffer) {
                return i << 3;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Can't copy to a " + buffer.getClass().getName() + " instance");
        }
        return i << 1;
    }

    public static int c(java.nio.Buffer buffer) {
        if (buffer instanceof java.nio.ByteBuffer) {
            return buffer.position();
        }
        if (!(buffer instanceof java.nio.ShortBuffer) && !(buffer instanceof java.nio.CharBuffer)) {
            if (buffer instanceof java.nio.IntBuffer) {
                return buffer.position() << 2;
            }
            if (buffer instanceof java.nio.LongBuffer) {
                return buffer.position() << 3;
            }
            if (buffer instanceof java.nio.FloatBuffer) {
                return buffer.position() << 2;
            }
            if (buffer instanceof java.nio.DoubleBuffer) {
                return buffer.position() << 3;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Can't copy to a " + buffer.getClass().getName() + " instance");
        }
        return buffer.position() << 1;
    }

    public static native void clear(java.nio.ByteBuffer byteBuffer, int i);

    public static void copy(java.nio.Buffer buffer, java.nio.Buffer buffer2, int i) {
        int b2 = b(buffer, i);
        buffer2.limit(buffer2.position() + a(buffer2, b2));
        copyJni(buffer, c(buffer), buffer2, c(buffer2), b2);
    }

    public static void copy(byte[] bArr, int i, java.nio.Buffer buffer, int i2) {
        buffer.limit(buffer.position() + a(buffer, i2));
        copyJni(bArr, i, buffer, c(buffer), i2);
    }

    public static void copy(char[] cArr, int i, int i2, java.nio.Buffer buffer) {
        copyJni(cArr, i, buffer, c(buffer), i2 << 1);
    }

    public static void copy(char[] cArr, int i, java.nio.Buffer buffer, int i2) {
        int i3 = i2 << 1;
        buffer.limit(buffer.position() + a(buffer, i3));
        copyJni(cArr, i, buffer, c(buffer), i3);
    }

    public static void copy(double[] dArr, int i, int i2, java.nio.Buffer buffer) {
        copyJni(dArr, i, buffer, c(buffer), i2 << 3);
    }

    public static void copy(double[] dArr, int i, java.nio.Buffer buffer, int i2) {
        int i3 = i2 << 3;
        buffer.limit(buffer.position() + a(buffer, i3));
        copyJni(dArr, i, buffer, c(buffer), i3);
    }

    public static void copy(float[] fArr, int i, int i2, java.nio.Buffer buffer) {
        copyJni(fArr, i, buffer, c(buffer), i2 << 2);
    }

    public static void copy(float[] fArr, int i, java.nio.Buffer buffer, int i2) {
        int i3 = i2 << 2;
        buffer.limit(buffer.position() + a(buffer, i3));
        copyJni(fArr, i, buffer, c(buffer), i3);
    }

    public static void copy(float[] fArr, java.nio.Buffer buffer, int i, int i2) {
        if (buffer instanceof java.nio.ByteBuffer) {
            buffer.limit(i << 2);
        } else if (buffer instanceof java.nio.FloatBuffer) {
            buffer.limit(i);
        }
        copyJni(fArr, buffer, i, i2);
        buffer.position(0);
    }

    public static void copy(int[] iArr, int i, int i2, java.nio.Buffer buffer) {
        copyJni(iArr, i, buffer, c(buffer), i2 << 2);
    }

    public static void copy(int[] iArr, int i, java.nio.Buffer buffer, int i2) {
        int i3 = i2 << 2;
        buffer.limit(buffer.position() + a(buffer, i3));
        copyJni(iArr, i, buffer, c(buffer), i3);
    }

    public static void copy(long[] jArr, int i, int i2, java.nio.Buffer buffer) {
        copyJni(jArr, i, buffer, c(buffer), i2 << 3);
    }

    public static void copy(long[] jArr, int i, java.nio.Buffer buffer, int i2) {
        int i3 = i2 << 3;
        buffer.limit(buffer.position() + a(buffer, i3));
        copyJni(jArr, i, buffer, c(buffer), i3);
    }

    public static void copy(short[] sArr, int i, java.nio.Buffer buffer, int i2) {
        int i3 = i2 << 1;
        buffer.limit(buffer.position() + a(buffer, i3));
        copyJni(sArr, i, buffer, c(buffer), i3);
    }

    private static native void copyJni(java.nio.Buffer buffer, int i, java.nio.Buffer buffer2, int i2, int i3);

    private static native void copyJni(byte[] bArr, int i, java.nio.Buffer buffer, int i2, int i3);

    private static native void copyJni(char[] cArr, int i, java.nio.Buffer buffer, int i2, int i3);

    private static native void copyJni(double[] dArr, int i, java.nio.Buffer buffer, int i2, int i3);

    private static native void copyJni(float[] fArr, int i, java.nio.Buffer buffer, int i2, int i3);

    private static native void copyJni(float[] fArr, java.nio.Buffer buffer, int i, int i2);

    private static native void copyJni(int[] iArr, int i, java.nio.Buffer buffer, int i2, int i3);

    private static native void copyJni(long[] jArr, int i, java.nio.Buffer buffer, int i2, int i3);

    private static native void copyJni(short[] sArr, int i, java.nio.Buffer buffer, int i2, int i3);

    public static void disposeUnsafeByteBuffer(java.nio.ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        synchronized (a) {
            if (!a.removeValue(byteBuffer, true)) {
                throw new java.lang.IllegalArgumentException("buffer not allocated with newUnsafeByteBuffer or already disposed");
            }
        }
        b -= capacity;
        freeMemory(byteBuffer);
    }

    private static native long find(java.nio.Buffer buffer, int i, int i2, java.nio.Buffer buffer2, int i3, int i4);

    private static native long find(java.nio.Buffer buffer, int i, int i2, java.nio.Buffer buffer2, int i3, int i4, float f);

    private static native long find(java.nio.Buffer buffer, int i, int i2, float[] fArr, int i3, int i4);

    private static native long find(java.nio.Buffer buffer, int i, int i2, float[] fArr, int i3, int i4, float f);

    private static native long find(float[] fArr, int i, int i2, java.nio.Buffer buffer, int i3, int i4);

    private static native long find(float[] fArr, int i, int i2, java.nio.Buffer buffer, int i3, int i4, float f);

    private static native long find(float[] fArr, int i, int i2, float[] fArr2, int i3, int i4);

    private static native long find(float[] fArr, int i, int i2, float[] fArr2, int i3, int i4, float f);

    public static long findFloats(java.nio.Buffer buffer, int i, java.nio.Buffer buffer2, int i2) {
        return find(buffer, c(buffer), i, buffer2, c(buffer2), i2);
    }

    public static long findFloats(java.nio.Buffer buffer, int i, java.nio.Buffer buffer2, int i2, float f) {
        return find(buffer, c(buffer), i, buffer2, c(buffer2), i2, f);
    }

    public static long findFloats(java.nio.Buffer buffer, int i, float[] fArr, int i2) {
        return find(buffer, c(buffer), i, fArr, 0, i2);
    }

    public static long findFloats(java.nio.Buffer buffer, int i, float[] fArr, int i2, float f) {
        return find(buffer, c(buffer), i, fArr, 0, i2, f);
    }

    public static long findFloats(float[] fArr, int i, java.nio.Buffer buffer, int i2) {
        return find(fArr, 0, i, buffer, c(buffer), i2);
    }

    public static long findFloats(float[] fArr, int i, java.nio.Buffer buffer, int i2, float f) {
        return find(fArr, 0, i, buffer, c(buffer), i2, f);
    }

    public static long findFloats(float[] fArr, int i, float[] fArr2, int i2) {
        return find(fArr, 0, i, fArr2, 0, i2);
    }

    public static long findFloats(float[] fArr, int i, float[] fArr2, int i2, float f) {
        return find(fArr, 0, i, fArr2, 0, i2, f);
    }

    private static native void freeMemory(java.nio.ByteBuffer byteBuffer);

    public static int getAllocatedBytesUnsafe() {
        return b;
    }

    private static native long getBufferAddress(java.nio.Buffer buffer);

    public static long getUnsafeBufferAddress(java.nio.Buffer buffer) {
        return getBufferAddress(buffer) + buffer.position();
    }

    public static java.nio.ByteBuffer newByteBuffer(int i) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(i);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        return allocateDirect;
    }

    public static java.nio.CharBuffer newCharBuffer(int i) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(i * 2);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        return allocateDirect.asCharBuffer();
    }

    private static native java.nio.ByteBuffer newDisposableByteBuffer(int i);

    public static java.nio.DoubleBuffer newDoubleBuffer(int i) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(i * 8);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        return allocateDirect.asDoubleBuffer();
    }

    public static java.nio.FloatBuffer newFloatBuffer(int i) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(i * 4);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        return allocateDirect.asFloatBuffer();
    }

    public static java.nio.IntBuffer newIntBuffer(int i) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(i * 4);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        return allocateDirect.asIntBuffer();
    }

    public static java.nio.LongBuffer newLongBuffer(int i) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(i * 8);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        return allocateDirect.asLongBuffer();
    }

    public static java.nio.ShortBuffer newShortBuffer(int i) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(i * 2);
        allocateDirect.order(java.nio.ByteOrder.nativeOrder());
        return allocateDirect.asShortBuffer();
    }

    public static java.nio.ByteBuffer newUnsafeByteBuffer(int i) {
        java.nio.ByteBuffer newDisposableByteBuffer = newDisposableByteBuffer(i);
        newDisposableByteBuffer.order(java.nio.ByteOrder.nativeOrder());
        b += i;
        synchronized (a) {
            a.add(newDisposableByteBuffer);
        }
        return newDisposableByteBuffer;
    }

    public static java.nio.ByteBuffer newUnsafeByteBuffer(java.nio.ByteBuffer byteBuffer) {
        b += byteBuffer.capacity();
        synchronized (a) {
            a.add(byteBuffer);
        }
        return byteBuffer;
    }

    public static void transform(java.nio.Buffer buffer, int i, int i2, int i3, com.badlogic.gdx.math.Matrix3 matrix3) {
        transform(buffer, i, i2, i3, matrix3, 0);
    }

    public static void transform(java.nio.Buffer buffer, int i, int i2, int i3, com.badlogic.gdx.math.Matrix3 matrix3, int i4) {
        if (i == 2) {
            transformV2M3Jni(buffer, i2, i3, matrix3.val, c(buffer) + i4);
        } else {
            if (i != 3) {
                throw new java.lang.IllegalArgumentException();
            }
            transformV3M3Jni(buffer, i2, i3, matrix3.val, c(buffer) + i4);
        }
    }

    public static void transform(java.nio.Buffer buffer, int i, int i2, int i3, com.badlogic.gdx.math.Matrix4 matrix4) {
        transform(buffer, i, i2, i3, matrix4, 0);
    }

    public static void transform(java.nio.Buffer buffer, int i, int i2, int i3, com.badlogic.gdx.math.Matrix4 matrix4, int i4) {
        if (i == 2) {
            transformV2M4Jni(buffer, i2, i3, matrix4.val, c(buffer) + i4);
        } else if (i == 3) {
            transformV3M4Jni(buffer, i2, i3, matrix4.val, c(buffer) + i4);
        } else {
            if (i != 4) {
                throw new java.lang.IllegalArgumentException();
            }
            transformV4M4Jni(buffer, i2, i3, matrix4.val, c(buffer) + i4);
        }
    }

    public static void transform(float[] fArr, int i, int i2, int i3, com.badlogic.gdx.math.Matrix3 matrix3) {
        transform(fArr, i, i2, i3, matrix3, 0);
    }

    public static void transform(float[] fArr, int i, int i2, int i3, com.badlogic.gdx.math.Matrix3 matrix3, int i4) {
        if (i == 2) {
            transformV2M3Jni(fArr, i2, i3, matrix3.val, i4);
        } else {
            if (i != 3) {
                throw new java.lang.IllegalArgumentException();
            }
            transformV3M3Jni(fArr, i2, i3, matrix3.val, i4);
        }
    }

    public static void transform(float[] fArr, int i, int i2, int i3, com.badlogic.gdx.math.Matrix4 matrix4) {
        transform(fArr, i, i2, i3, matrix4, 0);
    }

    public static void transform(float[] fArr, int i, int i2, int i3, com.badlogic.gdx.math.Matrix4 matrix4, int i4) {
        if (i == 2) {
            transformV2M4Jni(fArr, i2, i3, matrix4.val, i4);
        } else if (i == 3) {
            transformV3M4Jni(fArr, i2, i3, matrix4.val, i4);
        } else {
            if (i != 4) {
                throw new java.lang.IllegalArgumentException();
            }
            transformV4M4Jni(fArr, i2, i3, matrix4.val, i4);
        }
    }

    private static native void transformV2M3Jni(java.nio.Buffer buffer, int i, int i2, float[] fArr, int i3);

    private static native void transformV2M3Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    private static native void transformV2M4Jni(java.nio.Buffer buffer, int i, int i2, float[] fArr, int i3);

    private static native void transformV2M4Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    private static native void transformV3M3Jni(java.nio.Buffer buffer, int i, int i2, float[] fArr, int i3);

    private static native void transformV3M3Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    private static native void transformV3M4Jni(java.nio.Buffer buffer, int i, int i2, float[] fArr, int i3);

    private static native void transformV3M4Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    private static native void transformV4M4Jni(java.nio.Buffer buffer, int i, int i2, float[] fArr, int i3);

    private static native void transformV4M4Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);
}
