package com.badlogic.gdx.scenes.scene2d.utils;

/* loaded from: classes12.dex */
public abstract class ChangeListener implements com.badlogic.gdx.scenes.scene2d.EventListener {

    public static class ChangeEvent extends com.badlogic.gdx.scenes.scene2d.Event {
    }

    public abstract void changed(com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent changeEvent, com.badlogic.gdx.scenes.scene2d.Actor actor);

    @Override // com.badlogic.gdx.scenes.scene2d.EventListener
    public boolean handle(com.badlogic.gdx.scenes.scene2d.Event event) {
        if (!(event instanceof com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent)) {
            return false;
        }
        changed((com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent) event, event.getTarget());
        return false;
    }
}
