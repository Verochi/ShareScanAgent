package com.badlogic.gdx;

/* loaded from: classes12.dex */
public abstract class Game implements com.badlogic.gdx.ApplicationListener {
    protected com.badlogic.gdx.Screen screen;

    @Override // com.badlogic.gdx.ApplicationListener
    public void dispose() {
        com.badlogic.gdx.Screen screen = this.screen;
        if (screen != null) {
            screen.hide();
        }
    }

    public com.badlogic.gdx.Screen getScreen() {
        return this.screen;
    }

    @Override // com.badlogic.gdx.ApplicationListener
    public void pause() {
        com.badlogic.gdx.Screen screen = this.screen;
        if (screen != null) {
            screen.pause();
        }
    }

    @Override // com.badlogic.gdx.ApplicationListener
    public void render() {
        com.badlogic.gdx.Screen screen = this.screen;
        if (screen != null) {
            screen.render(com.badlogic.gdx.Gdx.graphics.getDeltaTime());
        }
    }

    @Override // com.badlogic.gdx.ApplicationListener
    public void resize(int i, int i2) {
        com.badlogic.gdx.Screen screen = this.screen;
        if (screen != null) {
            screen.resize(i, i2);
        }
    }

    @Override // com.badlogic.gdx.ApplicationListener
    public void resume() {
        com.badlogic.gdx.Screen screen = this.screen;
        if (screen != null) {
            screen.resume();
        }
    }

    public void setScreen(com.badlogic.gdx.Screen screen) {
        com.badlogic.gdx.Screen screen2 = this.screen;
        if (screen2 != null) {
            screen2.hide();
        }
        this.screen = screen;
        if (screen != null) {
            screen.show();
            this.screen.resize(com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight());
        }
    }
}
