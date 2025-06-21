package com.badlogic.gdx.scenes.scene2d;

/* loaded from: classes12.dex */
public class Event implements com.badlogic.gdx.utils.Pool.Poolable {
    public com.badlogic.gdx.scenes.scene2d.Stage a;
    public com.badlogic.gdx.scenes.scene2d.Actor b;
    public com.badlogic.gdx.scenes.scene2d.Actor c;
    public boolean d;
    public boolean e = true;
    public boolean f;
    public boolean g;
    public boolean h;

    public void cancel() {
        this.h = true;
        this.g = true;
        this.f = true;
    }

    public boolean getBubbles() {
        return this.e;
    }

    public com.badlogic.gdx.scenes.scene2d.Actor getListenerActor() {
        return this.c;
    }

    public com.badlogic.gdx.scenes.scene2d.Stage getStage() {
        return this.a;
    }

    public com.badlogic.gdx.scenes.scene2d.Actor getTarget() {
        return this.b;
    }

    public void handle() {
        this.f = true;
    }

    public boolean isCancelled() {
        return this.h;
    }

    public boolean isCapture() {
        return this.d;
    }

    public boolean isHandled() {
        return this.f;
    }

    public boolean isStopped() {
        return this.g;
    }

    @Override // com.badlogic.gdx.utils.Pool.Poolable
    public void reset() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = false;
    }

    public void setBubbles(boolean z) {
        this.e = z;
    }

    public void setCapture(boolean z) {
        this.d = z;
    }

    public void setListenerActor(com.badlogic.gdx.scenes.scene2d.Actor actor) {
        this.c = actor;
    }

    public void setStage(com.badlogic.gdx.scenes.scene2d.Stage stage) {
        this.a = stage;
    }

    public void setTarget(com.badlogic.gdx.scenes.scene2d.Actor actor) {
        this.b = actor;
    }

    public void stop() {
        this.g = true;
    }
}
