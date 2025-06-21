package com.badlogic.gdx.scenes.scene2d;

/* loaded from: classes12.dex */
public class Actor {
    public com.badlogic.gdx.scenes.scene2d.Stage a;
    public com.badlogic.gdx.scenes.scene2d.Group b;
    public java.lang.String f;
    public boolean h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float q;

    /* renamed from: s, reason: collision with root package name */
    public java.lang.Object f292s;
    public final com.badlogic.gdx.utils.DelayedRemovalArray<com.badlogic.gdx.scenes.scene2d.EventListener> c = new com.badlogic.gdx.utils.DelayedRemovalArray<>(0);
    public final com.badlogic.gdx.utils.DelayedRemovalArray<com.badlogic.gdx.scenes.scene2d.EventListener> d = new com.badlogic.gdx.utils.DelayedRemovalArray<>(0);
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.scenes.scene2d.Action> e = new com.badlogic.gdx.utils.Array<>(0);
    public boolean g = true;
    public float o = 1.0f;
    public float p = 1.0f;
    public final com.badlogic.gdx.graphics.Color r = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);

    public void act(float f) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.scenes.scene2d.Action> array = this.e;
        if (array.size > 0) {
            com.badlogic.gdx.scenes.scene2d.Stage stage = this.a;
            if (stage != null && stage.getActionsRequestRendering()) {
                com.badlogic.gdx.Gdx.graphics.requestRendering();
            }
            int i = 0;
            while (i < array.size) {
                com.badlogic.gdx.scenes.scene2d.Action action = array.get(i);
                if (action.act(f) && i < array.size) {
                    int indexOf = array.get(i) == action ? i : array.indexOf(action, true);
                    if (indexOf != -1) {
                        array.removeIndex(indexOf);
                        action.setActor(null);
                        i--;
                    }
                }
                i++;
            }
        }
    }

    public void addAction(com.badlogic.gdx.scenes.scene2d.Action action) {
        action.setActor(this);
        this.e.add(action);
        com.badlogic.gdx.scenes.scene2d.Stage stage = this.a;
        if (stage == null || !stage.getActionsRequestRendering()) {
            return;
        }
        com.badlogic.gdx.Gdx.graphics.requestRendering();
    }

    public boolean addCaptureListener(com.badlogic.gdx.scenes.scene2d.EventListener eventListener) {
        if (eventListener == null) {
            throw new java.lang.IllegalArgumentException("listener cannot be null.");
        }
        if (!this.d.contains(eventListener, true)) {
            this.d.add(eventListener);
        }
        return true;
    }

    public boolean addListener(com.badlogic.gdx.scenes.scene2d.EventListener eventListener) {
        if (eventListener == null) {
            throw new java.lang.IllegalArgumentException("listener cannot be null.");
        }
        if (this.c.contains(eventListener, true)) {
            return false;
        }
        this.c.add(eventListener);
        return true;
    }

    public void clear() {
        clearActions();
        clearListeners();
    }

    public void clearActions() {
        for (int i = this.e.size - 1; i >= 0; i--) {
            this.e.get(i).setActor(null);
        }
        this.e.clear();
    }

    public void clearListeners() {
        this.c.clear();
        this.d.clear();
    }

    public boolean clipBegin() {
        return clipBegin(this.i, this.j, this.k, this.l);
    }

    public boolean clipBegin(float f, float f2, float f3, float f4) {
        if (f3 > 0.0f && f4 > 0.0f) {
            com.badlogic.gdx.math.Rectangle rectangle = com.badlogic.gdx.math.Rectangle.tmp;
            rectangle.x = f;
            rectangle.y = f2;
            rectangle.width = f3;
            rectangle.height = f4;
            com.badlogic.gdx.scenes.scene2d.Stage stage = this.a;
            com.badlogic.gdx.math.Rectangle rectangle2 = (com.badlogic.gdx.math.Rectangle) com.badlogic.gdx.utils.Pools.obtain(com.badlogic.gdx.math.Rectangle.class);
            stage.calculateScissors(rectangle, rectangle2);
            if (com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.pushScissors(rectangle2)) {
                return true;
            }
            com.badlogic.gdx.utils.Pools.free(rectangle2);
        }
        return false;
    }

    public void clipEnd() {
        com.badlogic.gdx.utils.Pools.free(com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.popScissors());
    }

    public com.badlogic.gdx.scenes.scene2d.Actor debug() {
        setDebug(true);
        return this;
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f) {
    }

    public void drawDebug(com.badlogic.gdx.graphics.glutils.ShapeRenderer shapeRenderer) {
        drawDebugBounds(shapeRenderer);
    }

    public void drawDebugBounds(com.badlogic.gdx.graphics.glutils.ShapeRenderer shapeRenderer) {
        if (this.h) {
            shapeRenderer.set(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(this.a.getDebugColor());
            shapeRenderer.rect(this.i, this.j, this.m, this.n, this.k, this.l, this.o, this.p, this.q);
        }
    }

    public boolean fire(com.badlogic.gdx.scenes.scene2d.Event event) {
        boolean isCancelled;
        if (event.getStage() == null) {
            event.setStage(getStage());
        }
        event.setTarget(this);
        com.badlogic.gdx.utils.Array array = (com.badlogic.gdx.utils.Array) com.badlogic.gdx.utils.Pools.obtain(com.badlogic.gdx.utils.Array.class);
        for (com.badlogic.gdx.scenes.scene2d.Group group = this.b; group != null; group = group.b) {
            array.add(group);
        }
        try {
            java.lang.Object[] objArr = array.items;
            int i = array.size - 1;
            while (true) {
                if (i < 0) {
                    notify(event, true);
                    if (!event.isStopped()) {
                        notify(event, false);
                        if (!event.getBubbles()) {
                            isCancelled = event.isCancelled();
                        } else if (!event.isStopped()) {
                            int i2 = array.size;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= i2) {
                                    isCancelled = event.isCancelled();
                                    break;
                                }
                                ((com.badlogic.gdx.scenes.scene2d.Group) objArr[i3]).notify(event, false);
                                if (event.isStopped()) {
                                    isCancelled = event.isCancelled();
                                    break;
                                }
                                i3++;
                            }
                        } else {
                            isCancelled = event.isCancelled();
                        }
                    } else {
                        isCancelled = event.isCancelled();
                    }
                } else {
                    ((com.badlogic.gdx.scenes.scene2d.Group) objArr[i]).notify(event, true);
                    if (event.isStopped()) {
                        isCancelled = event.isCancelled();
                        break;
                    }
                    i--;
                }
            }
            return isCancelled;
        } finally {
            array.clear();
            com.badlogic.gdx.utils.Pools.free(array);
        }
    }

    public <T extends com.badlogic.gdx.scenes.scene2d.Actor> T firstAscendant(java.lang.Class<T> cls) {
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("actor cannot be null.");
        }
        com.badlogic.gdx.scenes.scene2d.Group group = (T) this;
        while (!com.badlogic.gdx.utils.reflect.ClassReflection.isInstance(cls, group)) {
            group = group.getParent();
            if (group == null) {
                return null;
            }
        }
        return group;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.scenes.scene2d.Action> getActions() {
        return this.e;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.scenes.scene2d.EventListener> getCaptureListeners() {
        return this.d;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.r;
    }

    public boolean getDebug() {
        return this.h;
    }

    public float getHeight() {
        return this.l;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.scenes.scene2d.EventListener> getListeners() {
        return this.c;
    }

    public java.lang.String getName() {
        return this.f;
    }

    public float getOriginX() {
        return this.m;
    }

    public float getOriginY() {
        return this.n;
    }

    public com.badlogic.gdx.scenes.scene2d.Group getParent() {
        return this.b;
    }

    public float getRight() {
        return this.i + this.k;
    }

    public float getRotation() {
        return this.q;
    }

    public float getScaleX() {
        return this.o;
    }

    public float getScaleY() {
        return this.p;
    }

    public com.badlogic.gdx.scenes.scene2d.Stage getStage() {
        return this.a;
    }

    public float getTop() {
        return this.j + this.l;
    }

    public java.lang.Object getUserObject() {
        return this.f292s;
    }

    public float getWidth() {
        return this.k;
    }

    public float getX() {
        return this.i;
    }

    public float getX(int i) {
        float f;
        float f2 = this.i;
        if ((i & 16) != 0) {
            f = this.k;
        } else {
            if ((i & 8) != 0) {
                return f2;
            }
            f = this.k / 2.0f;
        }
        return f2 + f;
    }

    public float getY() {
        return this.j;
    }

    public float getY(int i) {
        float f;
        float f2 = this.j;
        if ((i & 2) != 0) {
            f = this.l;
        } else {
            if ((i & 4) != 0) {
                return f2;
            }
            f = this.l / 2.0f;
        }
        return f2 + f;
    }

    public int getZIndex() {
        com.badlogic.gdx.scenes.scene2d.Group group = this.b;
        if (group == null) {
            return -1;
        }
        return group.t.indexOf(this, true);
    }

    public boolean hasActions() {
        return this.e.size > 0;
    }

    public boolean hasParent() {
        return this.b != null;
    }

    public boolean isAscendantOf(com.badlogic.gdx.scenes.scene2d.Actor actor) {
        if (actor == null) {
            throw new java.lang.IllegalArgumentException("actor cannot be null.");
        }
        while (actor != null) {
            if (actor == this) {
                return true;
            }
            actor = actor.b;
        }
        return false;
    }

    public boolean isDescendantOf(com.badlogic.gdx.scenes.scene2d.Actor actor) {
        if (actor == null) {
            throw new java.lang.IllegalArgumentException("actor cannot be null.");
        }
        for (com.badlogic.gdx.scenes.scene2d.Actor actor2 = this; actor2 != null; actor2 = actor2.b) {
            if (actor2 == actor) {
                return true;
            }
        }
        return false;
    }

    public boolean isVisible() {
        return this.g;
    }

    public com.badlogic.gdx.math.Vector2 localToAscendantCoordinates(com.badlogic.gdx.scenes.scene2d.Actor actor, com.badlogic.gdx.math.Vector2 vector2) {
        com.badlogic.gdx.scenes.scene2d.Actor actor2 = this;
        while (actor2 != null) {
            actor2.localToParentCoordinates(vector2);
            actor2 = actor2.b;
            if (actor2 == actor) {
                break;
            }
        }
        return vector2;
    }

    public com.badlogic.gdx.math.Vector2 localToParentCoordinates(com.badlogic.gdx.math.Vector2 vector2) {
        float f = -this.q;
        float f2 = this.o;
        float f3 = this.p;
        float f4 = this.i;
        float f5 = this.j;
        if (f != 0.0f) {
            double d = f * 0.017453292f;
            float cos = (float) java.lang.Math.cos(d);
            float sin = (float) java.lang.Math.sin(d);
            float f6 = this.m;
            float f7 = this.n;
            float f8 = (vector2.x - f6) * f2;
            float f9 = (vector2.y - f7) * f3;
            vector2.x = (f8 * cos) + (f9 * sin) + f6 + f4;
            vector2.y = (f8 * (-sin)) + (f9 * cos) + f7 + f5;
        } else if (f2 == 1.0f && f3 == 1.0f) {
            vector2.x += f4;
            vector2.y += f5;
        } else {
            float f10 = this.m;
            float f11 = this.n;
            vector2.x = ((vector2.x - f10) * f2) + f10 + f4;
            vector2.y = ((vector2.y - f11) * f3) + f11 + f5;
        }
        return vector2;
    }

    public com.badlogic.gdx.math.Vector2 localToStageCoordinates(com.badlogic.gdx.math.Vector2 vector2) {
        return localToAscendantCoordinates(null, vector2);
    }

    public void moveBy(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.i += f;
        this.j += f2;
        positionChanged();
    }

    public boolean notify(com.badlogic.gdx.scenes.scene2d.Event event, boolean z) {
        if (event.getTarget() == null) {
            throw new java.lang.IllegalArgumentException("The event target cannot be null.");
        }
        com.badlogic.gdx.utils.DelayedRemovalArray<com.badlogic.gdx.scenes.scene2d.EventListener> delayedRemovalArray = z ? this.d : this.c;
        if (delayedRemovalArray.size == 0) {
            return event.isCancelled();
        }
        event.setListenerActor(this);
        event.setCapture(z);
        if (event.getStage() == null) {
            event.setStage(this.a);
        }
        delayedRemovalArray.begin();
        int i = delayedRemovalArray.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (delayedRemovalArray.get(i2).handle(event)) {
                event.handle();
            }
        }
        delayedRemovalArray.end();
        return event.isCancelled();
    }

    public com.badlogic.gdx.math.Vector2 parentToLocalCoordinates(com.badlogic.gdx.math.Vector2 vector2) {
        float f = this.q;
        float f2 = this.o;
        float f3 = this.p;
        float f4 = this.i;
        float f5 = this.j;
        if (f != 0.0f) {
            double d = f * 0.017453292f;
            float cos = (float) java.lang.Math.cos(d);
            float sin = (float) java.lang.Math.sin(d);
            float f6 = this.m;
            float f7 = this.n;
            float f8 = (vector2.x - f4) - f6;
            float f9 = (vector2.y - f5) - f7;
            vector2.x = (((f8 * cos) + (f9 * sin)) / f2) + f6;
            vector2.y = (((f8 * (-sin)) + (f9 * cos)) / f3) + f7;
        } else if (f2 == 1.0f && f3 == 1.0f) {
            vector2.x -= f4;
            vector2.y -= f5;
        } else {
            float f10 = this.m;
            float f11 = this.n;
            vector2.x = (((vector2.x - f4) - f10) / f2) + f10;
            vector2.y = (((vector2.y - f5) - f11) / f3) + f11;
        }
        return vector2;
    }

    public void positionChanged() {
    }

    public boolean remove() {
        com.badlogic.gdx.scenes.scene2d.Group group = this.b;
        if (group != null) {
            return group.removeActor(this, true);
        }
        return false;
    }

    public void removeAction(com.badlogic.gdx.scenes.scene2d.Action action) {
        if (this.e.removeValue(action, true)) {
            action.setActor(null);
        }
    }

    public boolean removeCaptureListener(com.badlogic.gdx.scenes.scene2d.EventListener eventListener) {
        if (eventListener != null) {
            return this.d.removeValue(eventListener, true);
        }
        throw new java.lang.IllegalArgumentException("listener cannot be null.");
    }

    public boolean removeListener(com.badlogic.gdx.scenes.scene2d.EventListener eventListener) {
        if (eventListener != null) {
            return this.c.removeValue(eventListener, true);
        }
        throw new java.lang.IllegalArgumentException("listener cannot be null.");
    }

    public void rotateBy(float f) {
        if (f != 0.0f) {
            this.q += f;
            rotationChanged();
        }
    }

    public void rotationChanged() {
    }

    public void scaleBy(float f) {
        this.o += f;
        this.p += f;
    }

    public void scaleBy(float f, float f2) {
        this.o += f;
        this.p += f2;
    }

    public com.badlogic.gdx.math.Vector2 screenToLocalCoordinates(com.badlogic.gdx.math.Vector2 vector2) {
        com.badlogic.gdx.scenes.scene2d.Stage stage = this.a;
        return stage == null ? vector2 : stageToLocalCoordinates(stage.screenToStageCoordinates(vector2));
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        if (this.i != f || this.j != f2) {
            this.i = f;
            this.j = f2;
            positionChanged();
        }
        if (this.k == f3 && this.l == f4) {
            return;
        }
        this.k = f3;
        this.l = f4;
        sizeChanged();
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.r.set(f, f2, f3, f4);
    }

    public void setColor(com.badlogic.gdx.graphics.Color color) {
        this.r.set(color);
    }

    public void setDebug(boolean z) {
        this.h = z;
        if (z) {
            com.badlogic.gdx.scenes.scene2d.Stage.l = true;
        }
    }

    public void setHeight(float f) {
        if (this.l != f) {
            this.l = f;
            sizeChanged();
        }
    }

    public void setName(java.lang.String str) {
        this.f = str;
    }

    public void setOrigin(float f, float f2) {
        this.m = f;
        this.n = f2;
    }

    public void setOrigin(int i) {
        if ((i & 8) != 0) {
            this.m = 0.0f;
        } else if ((i & 16) != 0) {
            this.m = this.k;
        } else {
            this.m = this.k / 2.0f;
        }
        if ((i & 4) != 0) {
            this.n = 0.0f;
        } else if ((i & 2) != 0) {
            this.n = this.l;
        } else {
            this.n = this.l / 2.0f;
        }
    }

    public void setOriginX(float f) {
        this.m = f;
    }

    public void setOriginY(float f) {
        this.n = f;
    }

    public void setParent(com.badlogic.gdx.scenes.scene2d.Group group) {
        this.b = group;
    }

    public void setPosition(float f, float f2) {
        if (this.i == f && this.j == f2) {
            return;
        }
        this.i = f;
        this.j = f2;
        positionChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setPosition(float f, float f2, int i) {
        float f3;
        float f4;
        if ((i & 16) == 0) {
            if ((i & 8) == 0) {
                f3 = this.k / 2.0f;
            }
            if ((i & 2) != 0) {
                if ((i & 4) == 0) {
                    f4 = this.l / 2.0f;
                }
                if (this.i == f || this.j != f2) {
                    this.i = f;
                    this.j = f2;
                    positionChanged();
                }
                return;
            }
            f4 = this.l;
            f2 -= f4;
            if (this.i == f) {
            }
            this.i = f;
            this.j = f2;
            positionChanged();
        }
        f3 = this.k;
        f -= f3;
        if ((i & 2) != 0) {
        }
        f2 -= f4;
        if (this.i == f) {
        }
        this.i = f;
        this.j = f2;
        positionChanged();
    }

    public void setRotation(float f) {
        if (this.q != f) {
            this.q = f;
            rotationChanged();
        }
    }

    public void setScale(float f) {
        this.o = f;
        this.p = f;
    }

    public void setScale(float f, float f2) {
        this.o = f;
        this.p = f2;
    }

    public void setScaleX(float f) {
        this.o = f;
    }

    public void setScaleY(float f) {
        this.p = f;
    }

    public void setSize(float f, float f2) {
        if (this.k == f && this.l == f2) {
            return;
        }
        this.k = f;
        this.l = f2;
        sizeChanged();
    }

    public void setStage(com.badlogic.gdx.scenes.scene2d.Stage stage) {
        this.a = stage;
    }

    public void setUserObject(java.lang.Object obj) {
        this.f292s = obj;
    }

    public void setVisible(boolean z) {
        this.g = z;
    }

    public void setWidth(float f) {
        if (this.k != f) {
            this.k = f;
            sizeChanged();
        }
    }

    public void setX(float f) {
        if (this.i != f) {
            this.i = f;
            positionChanged();
        }
    }

    public void setY(float f) {
        if (this.j != f) {
            this.j = f;
            positionChanged();
        }
    }

    public void setZIndex(int i) {
        com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> snapshotArray;
        int i2;
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("ZIndex cannot be < 0.");
        }
        com.badlogic.gdx.scenes.scene2d.Group group = this.b;
        if (group == null || (i2 = (snapshotArray = group.t).size) == 1) {
            return;
        }
        int min = java.lang.Math.min(i, i2 - 1);
        if (snapshotArray.get(min) != this && snapshotArray.removeValue(this, true)) {
            snapshotArray.insert(min, this);
        }
    }

    public void sizeBy(float f) {
        if (f != 0.0f) {
            this.k += f;
            this.l += f;
            sizeChanged();
        }
    }

    public void sizeBy(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.k += f;
        this.l += f2;
        sizeChanged();
    }

    public void sizeChanged() {
    }

    public com.badlogic.gdx.math.Vector2 stageToLocalCoordinates(com.badlogic.gdx.math.Vector2 vector2) {
        com.badlogic.gdx.scenes.scene2d.Group group = this.b;
        if (group != null) {
            group.stageToLocalCoordinates(vector2);
        }
        parentToLocalCoordinates(vector2);
        return vector2;
    }

    public void toBack() {
        setZIndex(0);
    }

    public void toFront() {
        setZIndex(Integer.MAX_VALUE);
    }

    public java.lang.String toString() {
        java.lang.String str = this.f;
        if (str != null) {
            return str;
        }
        java.lang.String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf != -1 ? name.substring(lastIndexOf + 1) : name;
    }
}
