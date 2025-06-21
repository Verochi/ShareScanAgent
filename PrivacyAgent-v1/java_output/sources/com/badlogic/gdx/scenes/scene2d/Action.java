package com.badlogic.gdx.scenes.scene2d;

/* loaded from: classes12.dex */
public abstract class Action implements com.badlogic.gdx.utils.Pool.Poolable {
    public com.badlogic.gdx.utils.Pool a;
    protected com.badlogic.gdx.scenes.scene2d.Actor actor;
    protected com.badlogic.gdx.scenes.scene2d.Actor target;

    public abstract boolean act(float f);

    public com.badlogic.gdx.scenes.scene2d.Actor getActor() {
        return this.actor;
    }

    public com.badlogic.gdx.utils.Pool getPool() {
        return this.a;
    }

    public com.badlogic.gdx.scenes.scene2d.Actor getTarget() {
        return this.target;
    }

    @Override // com.badlogic.gdx.utils.Pool.Poolable
    public void reset() {
        this.actor = null;
        this.target = null;
        this.a = null;
        restart();
    }

    public void restart() {
    }

    public void setActor(com.badlogic.gdx.scenes.scene2d.Actor actor) {
        com.badlogic.gdx.utils.Pool pool;
        this.actor = actor;
        if (this.target == null) {
            setTarget(actor);
        }
        if (actor != null || (pool = this.a) == null) {
            return;
        }
        pool.free(this);
        this.a = null;
    }

    public void setPool(com.badlogic.gdx.utils.Pool pool) {
        this.a = pool;
    }

    public void setTarget(com.badlogic.gdx.scenes.scene2d.Actor actor) {
        this.target = actor;
    }

    public java.lang.String toString() {
        java.lang.String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf != -1) {
            name = name.substring(lastIndexOf + 1);
        }
        return name.endsWith(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_ACTION) ? name.substring(0, name.length() - 6) : name;
    }
}
