package com.badlogic.gdx.scenes.scene2d;

/* loaded from: classes12.dex */
public class Stage implements com.badlogic.gdx.utils.Disposable {
    public static boolean l;
    public com.badlogic.gdx.utils.viewport.Viewport a;
    public final com.badlogic.gdx.graphics.g2d.Batch b;
    public boolean c;
    public com.badlogic.gdx.scenes.scene2d.Group d;
    public boolean e;
    public com.badlogic.gdx.graphics.glutils.ShapeRenderer f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final com.badlogic.gdx.graphics.Color k;

    public Stage() {
        this(new com.badlogic.gdx.utils.viewport.ScalingViewport(com.badlogic.gdx.utils.Scaling.stretch, com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight(), new com.badlogic.gdx.graphics.OrthographicCamera()), new com.badlogic.gdx.graphics.g2d.SpriteBatch());
        this.c = true;
    }

    public Stage(com.badlogic.gdx.utils.viewport.Viewport viewport) {
        this(viewport, new com.badlogic.gdx.graphics.g2d.SpriteBatch());
        this.c = true;
    }

    public Stage(com.badlogic.gdx.utils.viewport.Viewport viewport, com.badlogic.gdx.graphics.g2d.Batch batch) {
        this.e = true;
        this.k = new com.badlogic.gdx.graphics.Color(0.0f, 1.0f, 0.0f, 0.85f);
        if (viewport == null) {
            throw new java.lang.IllegalArgumentException("viewport cannot be null.");
        }
        if (batch == null) {
            throw new java.lang.IllegalArgumentException("batch cannot be null.");
        }
        this.a = viewport;
        this.b = batch;
        com.badlogic.gdx.scenes.scene2d.Group group = new com.badlogic.gdx.scenes.scene2d.Group();
        this.d = group;
        group.setStage(this);
        viewport.update(com.badlogic.gdx.Gdx.graphics.getWidth(), com.badlogic.gdx.Gdx.graphics.getHeight(), true);
    }

    public void act() {
        act(java.lang.Math.min(com.badlogic.gdx.Gdx.graphics.getDeltaTime(), 0.033333335f));
    }

    public void act(float f) {
        this.d.act(f);
    }

    public void addAction(com.badlogic.gdx.scenes.scene2d.Action action) {
        this.d.addAction(action);
    }

    public void addActor(com.badlogic.gdx.scenes.scene2d.Actor actor) {
        this.d.addActor(actor);
    }

    public boolean addCaptureListener(com.badlogic.gdx.scenes.scene2d.EventListener eventListener) {
        return this.d.addCaptureListener(eventListener);
    }

    public boolean addListener(com.badlogic.gdx.scenes.scene2d.EventListener eventListener) {
        return this.d.addListener(eventListener);
    }

    public void calculateScissors(com.badlogic.gdx.math.Rectangle rectangle, com.badlogic.gdx.math.Rectangle rectangle2) {
        this.a.calculateScissors(this.b.getTransformMatrix(), rectangle, rectangle2);
        com.badlogic.gdx.graphics.glutils.ShapeRenderer shapeRenderer = this.f;
        this.a.calculateScissors((shapeRenderer == null || !shapeRenderer.isDrawing()) ? this.b.getTransformMatrix() : this.f.getTransformMatrix(), rectangle, rectangle2);
    }

    public void clear() {
        this.d.clear();
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        clear();
        if (this.c) {
            this.b.dispose();
        }
    }

    public void draw() {
        com.badlogic.gdx.graphics.Camera camera = this.a.getCamera();
        camera.update();
        if (this.d.isVisible()) {
            com.badlogic.gdx.graphics.g2d.Batch batch = this.b;
            batch.setProjectionMatrix(camera.combined);
            batch.begin();
            this.d.draw(batch, 1.0f);
            batch.end();
        }
    }

    public boolean getActionsRequestRendering() {
        return this.e;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.scenes.scene2d.Actor> getActors() {
        return this.d.t;
    }

    public com.badlogic.gdx.graphics.g2d.Batch getBatch() {
        return this.b;
    }

    public com.badlogic.gdx.graphics.Camera getCamera() {
        return this.a.getCamera();
    }

    public com.badlogic.gdx.graphics.Color getDebugColor() {
        return this.k;
    }

    public float getHeight() {
        return this.a.getWorldHeight();
    }

    public com.badlogic.gdx.scenes.scene2d.Group getRoot() {
        return this.d;
    }

    public com.badlogic.gdx.utils.viewport.Viewport getViewport() {
        return this.a;
    }

    public float getWidth() {
        return this.a.getWorldWidth();
    }

    public boolean removeCaptureListener(com.badlogic.gdx.scenes.scene2d.EventListener eventListener) {
        return this.d.removeCaptureListener(eventListener);
    }

    public boolean removeListener(com.badlogic.gdx.scenes.scene2d.EventListener eventListener) {
        return this.d.removeListener(eventListener);
    }

    public com.badlogic.gdx.math.Vector2 screenToStageCoordinates(com.badlogic.gdx.math.Vector2 vector2) {
        this.a.unproject(vector2);
        return vector2;
    }

    public void setActionsRequestRendering(boolean z) {
        this.e = z;
    }

    public void setDebugAll(boolean z) {
        if (this.h == z) {
            return;
        }
        this.h = z;
        if (z) {
            l = true;
        } else {
            this.d.setDebug(false, true);
        }
    }

    public void setDebugInvisible(boolean z) {
        this.g = z;
    }

    public void setDebugParentUnderMouse(boolean z) {
        if (this.j == z) {
            return;
        }
        this.j = z;
        if (z) {
            l = true;
        } else {
            this.d.setDebug(false, true);
        }
    }

    public void setDebugUnderMouse(boolean z) {
        if (this.i == z) {
            return;
        }
        this.i = z;
        if (z) {
            l = true;
        } else {
            this.d.setDebug(false, true);
        }
    }

    public void setRoot(com.badlogic.gdx.scenes.scene2d.Group group) {
        this.d = group;
    }

    public void setViewport(com.badlogic.gdx.utils.viewport.Viewport viewport) {
        this.a = viewport;
    }

    public com.badlogic.gdx.math.Vector2 stageToScreenCoordinates(com.badlogic.gdx.math.Vector2 vector2) {
        this.a.project(vector2);
        vector2.y = this.a.getScreenHeight() - vector2.y;
        return vector2;
    }

    public com.badlogic.gdx.math.Vector2 toScreenCoordinates(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Matrix4 matrix4) {
        return this.a.toScreenCoordinates(vector2, matrix4);
    }
}
