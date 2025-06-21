package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class Animation<T> {
    public T[] a;
    public float b;
    public float c;
    public int d;
    public float e;
    public com.badlogic.gdx.graphics.g2d.Animation.PlayMode f;

    /* renamed from: com.badlogic.gdx.graphics.g2d.Animation$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.badlogic.gdx.graphics.g2d.Animation.PlayMode.values().length];
            a = iArr;
            try {
                iArr[com.badlogic.gdx.graphics.g2d.Animation.PlayMode.NORMAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP_PINGPONG.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP_RANDOM.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.badlogic.gdx.graphics.g2d.Animation.PlayMode.REVERSED.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP_REVERSED.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    public enum PlayMode {
        NORMAL,
        REVERSED,
        LOOP,
        LOOP_REVERSED,
        LOOP_PINGPONG,
        LOOP_RANDOM
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Animation(float f, com.badlogic.gdx.utils.Array<? extends T> array) {
        this.f = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.NORMAL;
        this.b = f;
        int i = array.size;
        java.lang.Object[] objArr = new java.lang.Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = array.get(i2);
        }
        setKeyFrames(objArr);
    }

    public Animation(float f, com.badlogic.gdx.utils.Array<? extends T> array, com.badlogic.gdx.graphics.g2d.Animation.PlayMode playMode) {
        this(f, array);
        setPlayMode(playMode);
    }

    public Animation(float f, T... tArr) {
        this.f = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.NORMAL;
        this.b = f;
        setKeyFrames(tArr);
    }

    public float getAnimationDuration() {
        return this.c;
    }

    public float getFrameDuration() {
        return this.b;
    }

    public T getKeyFrame(float f) {
        return this.a[getKeyFrameIndex(f)];
    }

    public T getKeyFrame(float f, boolean z) {
        com.badlogic.gdx.graphics.g2d.Animation.PlayMode playMode;
        com.badlogic.gdx.graphics.g2d.Animation.PlayMode playMode2;
        com.badlogic.gdx.graphics.g2d.Animation.PlayMode playMode3 = this.f;
        if (z && (playMode3 == (playMode2 = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.NORMAL) || playMode3 == com.badlogic.gdx.graphics.g2d.Animation.PlayMode.REVERSED)) {
            if (playMode3 == playMode2) {
                this.f = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
            } else {
                this.f = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP_REVERSED;
            }
        } else if (!z && playMode3 != com.badlogic.gdx.graphics.g2d.Animation.PlayMode.NORMAL && playMode3 != (playMode = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.REVERSED)) {
            if (playMode3 == com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP_REVERSED) {
                this.f = playMode;
            } else {
                this.f = com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
            }
        }
        T keyFrame = getKeyFrame(f);
        this.f = playMode3;
        return keyFrame;
    }

    public int getKeyFrameIndex(float f) {
        if (this.a.length == 1) {
            return 0;
        }
        int i = (int) (f / this.b);
        switch (com.badlogic.gdx.graphics.g2d.Animation.AnonymousClass1.a[this.f.ordinal()]) {
            case 1:
                i = java.lang.Math.min(this.a.length - 1, i);
                break;
            case 2:
                i %= this.a.length;
                break;
            case 3:
                T[] tArr = this.a;
                i %= (tArr.length * 2) - 2;
                if (i >= tArr.length) {
                    i = (tArr.length - 2) - (i - tArr.length);
                    break;
                }
                break;
            case 4:
                if (((int) (this.e / this.b)) == i) {
                    i = this.d;
                    break;
                } else {
                    i = com.badlogic.gdx.math.MathUtils.random(this.a.length - 1);
                    break;
                }
            case 5:
                i = java.lang.Math.max((this.a.length - i) - 1, 0);
                break;
            case 6:
                T[] tArr2 = this.a;
                i = (tArr2.length - (i % tArr2.length)) - 1;
                break;
        }
        this.d = i;
        this.e = f;
        return i;
    }

    public T[] getKeyFrames() {
        return this.a;
    }

    public com.badlogic.gdx.graphics.g2d.Animation.PlayMode getPlayMode() {
        return this.f;
    }

    public boolean isAnimationFinished(float f) {
        return this.a.length - 1 < ((int) (f / this.b));
    }

    public void setFrameDuration(float f) {
        this.b = f;
        this.c = this.a.length * f;
    }

    public void setKeyFrames(T... tArr) {
        this.a = tArr;
        this.c = tArr.length * this.b;
    }

    public void setPlayMode(com.badlogic.gdx.graphics.g2d.Animation.PlayMode playMode) {
        this.f = playMode;
    }
}
