package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class Logger {
    public static final int DEBUG = 3;
    public static final int ERROR = 1;
    public static final int INFO = 2;
    public static final int NONE = 0;
    public final java.lang.String a;
    public int b;

    public Logger(java.lang.String str) {
        this(str, 1);
    }

    public Logger(java.lang.String str, int i) {
        this.a = str;
        this.b = i;
    }

    public void debug(java.lang.String str) {
        if (this.b >= 3) {
            com.badlogic.gdx.Gdx.app.debug(this.a, str);
        }
    }

    public void debug(java.lang.String str, java.lang.Exception exc) {
        if (this.b >= 3) {
            com.badlogic.gdx.Gdx.app.debug(this.a, str, exc);
        }
    }

    public void error(java.lang.String str) {
        if (this.b >= 1) {
            com.badlogic.gdx.Gdx.app.error(this.a, str);
        }
    }

    public void error(java.lang.String str, java.lang.Throwable th) {
        if (this.b >= 1) {
            com.badlogic.gdx.Gdx.app.error(this.a, str, th);
        }
    }

    public int getLevel() {
        return this.b;
    }

    public void info(java.lang.String str) {
        if (this.b >= 2) {
            com.badlogic.gdx.Gdx.app.log(this.a, str);
        }
    }

    public void info(java.lang.String str, java.lang.Exception exc) {
        if (this.b >= 2) {
            com.badlogic.gdx.Gdx.app.log(this.a, str, exc);
        }
    }

    public void setLevel(int i) {
        this.b = i;
    }
}
