package com.badlogic.gdx.scenes.scene2d;

/* loaded from: classes12.dex */
public class Group extends com.badlogic.gdx.scenes.scene2d.Actor implements com.badlogic.gdx.scenes.scene2d.utils.Cullable {
    public static final com.badlogic.gdx.math.Vector2 z = new com.badlogic.gdx.math.Vector2();
    public final com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> t = new com.badlogic.gdx.utils.SnapshotArray<>(true, 4, com.badlogic.gdx.scenes.scene2d.Actor.class);
    public final com.badlogic.gdx.math.Affine2 u = new com.badlogic.gdx.math.Affine2();
    public final com.badlogic.gdx.math.Matrix4 v = new com.badlogic.gdx.math.Matrix4();
    public final com.badlogic.gdx.math.Matrix4 w = new com.badlogic.gdx.math.Matrix4();
    public boolean x = true;
    public com.badlogic.gdx.math.Rectangle y;

    public void a(java.lang.StringBuilder sb, int i) {
        sb.append(super.toString());
        sb.append('\n');
        com.badlogic.gdx.scenes.scene2d.Actor[] begin = this.t.begin();
        int i2 = this.t.size;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                sb.append("|  ");
            }
            com.badlogic.gdx.scenes.scene2d.Actor actor = begin[i3];
            if (actor instanceof com.badlogic.gdx.scenes.scene2d.Group) {
                ((com.badlogic.gdx.scenes.scene2d.Group) actor).a(sb, i + 1);
            } else {
                sb.append(actor);
                sb.append('\n');
            }
        }
        this.t.end();
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Actor
    public void act(float f) {
        super.act(f);
        com.badlogic.gdx.scenes.scene2d.Actor[] begin = this.t.begin();
        int i = this.t.size;
        for (int i2 = 0; i2 < i; i2++) {
            begin[i2].act(f);
        }
        this.t.end();
    }

    public void addActor(com.badlogic.gdx.scenes.scene2d.Actor actor) {
        com.badlogic.gdx.scenes.scene2d.Group group = actor.b;
        if (group != null) {
            if (group == this) {
                return;
            } else {
                group.removeActor(actor, false);
            }
        }
        this.t.add(actor);
        actor.setParent(this);
        actor.setStage(getStage());
        childrenChanged();
    }

    public void addActorAfter(com.badlogic.gdx.scenes.scene2d.Actor actor, com.badlogic.gdx.scenes.scene2d.Actor actor2) {
        com.badlogic.gdx.scenes.scene2d.Group group = actor2.b;
        if (group != null) {
            if (group == this) {
                return;
            } else {
                group.removeActor(actor2, false);
            }
        }
        int indexOf = this.t.indexOf(actor, true);
        com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> snapshotArray = this.t;
        if (indexOf == snapshotArray.size) {
            snapshotArray.add(actor2);
        } else {
            snapshotArray.insert(indexOf + 1, actor2);
        }
        actor2.setParent(this);
        actor2.setStage(getStage());
        childrenChanged();
    }

    public void addActorAt(int i, com.badlogic.gdx.scenes.scene2d.Actor actor) {
        com.badlogic.gdx.scenes.scene2d.Group group = actor.b;
        if (group != null) {
            if (group == this) {
                return;
            } else {
                group.removeActor(actor, false);
            }
        }
        com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> snapshotArray = this.t;
        if (i >= snapshotArray.size) {
            snapshotArray.add(actor);
        } else {
            snapshotArray.insert(i, actor);
        }
        actor.setParent(this);
        actor.setStage(getStage());
        childrenChanged();
    }

    public void addActorBefore(com.badlogic.gdx.scenes.scene2d.Actor actor, com.badlogic.gdx.scenes.scene2d.Actor actor2) {
        com.badlogic.gdx.scenes.scene2d.Group group = actor2.b;
        if (group != null) {
            if (group == this) {
                return;
            } else {
                group.removeActor(actor2, false);
            }
        }
        this.t.insert(this.t.indexOf(actor, true), actor2);
        actor2.setParent(this);
        actor2.setStage(getStage());
        childrenChanged();
    }

    public void applyTransform(com.badlogic.gdx.graphics.g2d.Batch batch, com.badlogic.gdx.math.Matrix4 matrix4) {
        this.w.set(batch.getTransformMatrix());
        batch.setTransformMatrix(matrix4);
    }

    public void applyTransform(com.badlogic.gdx.graphics.glutils.ShapeRenderer shapeRenderer, com.badlogic.gdx.math.Matrix4 matrix4) {
        this.w.set(shapeRenderer.getTransformMatrix());
        shapeRenderer.setTransformMatrix(matrix4);
    }

    public void childrenChanged() {
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Actor
    public void clear() {
        super.clear();
        clearChildren();
    }

    public void clearChildren() {
        com.badlogic.gdx.scenes.scene2d.Actor[] begin = this.t.begin();
        int i = this.t.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.badlogic.gdx.scenes.scene2d.Actor actor = begin[i2];
            actor.setStage(null);
            actor.setParent(null);
        }
        this.t.end();
        this.t.clear();
        childrenChanged();
    }

    public com.badlogic.gdx.math.Matrix4 computeTransform() {
        com.badlogic.gdx.math.Affine2 affine2 = this.u;
        float f = this.m;
        float f2 = this.n;
        affine2.setToTrnRotScl(this.i + f, this.j + f2, this.q, this.o, this.p);
        if (f != 0.0f || f2 != 0.0f) {
            affine2.translate(-f, -f2);
        }
        com.badlogic.gdx.scenes.scene2d.Group group = this.b;
        while (group != null && !group.x) {
            group = group.b;
        }
        if (group != null) {
            affine2.preMul(group.u);
        }
        this.v.set(affine2);
        return this.v;
    }

    public com.badlogic.gdx.scenes.scene2d.Group debugAll() {
        setDebug(true, true);
        return this;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Actor
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f) {
        if (this.x) {
            applyTransform(batch, computeTransform());
        }
        drawChildren(batch, f);
        if (this.x) {
            resetTransform(batch);
        }
    }

    public void drawChildren(com.badlogic.gdx.graphics.g2d.Batch batch, float f) {
        float f2;
        float f3 = this.r.a * f;
        com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> snapshotArray = this.t;
        com.badlogic.gdx.scenes.scene2d.Actor[] begin = snapshotArray.begin();
        com.badlogic.gdx.math.Rectangle rectangle = this.y;
        int i = 0;
        if (rectangle != null) {
            float f4 = rectangle.x;
            float f5 = rectangle.width + f4;
            float f6 = rectangle.y;
            float f7 = rectangle.height + f6;
            if (this.x) {
                int i2 = snapshotArray.size;
                while (i < i2) {
                    com.badlogic.gdx.scenes.scene2d.Actor actor = begin[i];
                    if (actor.isVisible()) {
                        float f8 = actor.i;
                        float f9 = actor.j;
                        if (f8 <= f5 && f9 <= f7 && f8 + actor.k >= f4 && f9 + actor.l >= f6) {
                            actor.draw(batch, f3);
                        }
                    }
                    i++;
                }
            } else {
                float f10 = this.i;
                float f11 = this.j;
                this.i = 0.0f;
                this.j = 0.0f;
                int i3 = snapshotArray.size;
                while (i < i3) {
                    com.badlogic.gdx.scenes.scene2d.Actor actor2 = begin[i];
                    if (actor2.isVisible()) {
                        float f12 = actor2.i;
                        float f13 = actor2.j;
                        if (f12 <= f5 && f13 <= f7) {
                            f2 = f7;
                            if (actor2.k + f12 >= f4 && actor2.l + f13 >= f6) {
                                actor2.i = f12 + f10;
                                actor2.j = f13 + f11;
                                actor2.draw(batch, f3);
                                actor2.i = f12;
                                actor2.j = f13;
                            }
                            i++;
                            f7 = f2;
                        }
                    }
                    f2 = f7;
                    i++;
                    f7 = f2;
                }
                this.i = f10;
                this.j = f11;
            }
        } else if (this.x) {
            int i4 = snapshotArray.size;
            while (i < i4) {
                com.badlogic.gdx.scenes.scene2d.Actor actor3 = begin[i];
                if (actor3.isVisible()) {
                    actor3.draw(batch, f3);
                }
                i++;
            }
        } else {
            float f14 = this.i;
            float f15 = this.j;
            this.i = 0.0f;
            this.j = 0.0f;
            int i5 = snapshotArray.size;
            while (i < i5) {
                com.badlogic.gdx.scenes.scene2d.Actor actor4 = begin[i];
                if (actor4.isVisible()) {
                    float f16 = actor4.i;
                    float f17 = actor4.j;
                    actor4.i = f16 + f14;
                    actor4.j = f17 + f15;
                    actor4.draw(batch, f3);
                    actor4.i = f16;
                    actor4.j = f17;
                }
                i++;
            }
            this.i = f14;
            this.j = f15;
        }
        snapshotArray.end();
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Actor
    public void drawDebug(com.badlogic.gdx.graphics.glutils.ShapeRenderer shapeRenderer) {
        drawDebugBounds(shapeRenderer);
        if (this.x) {
            applyTransform(shapeRenderer, computeTransform());
        }
        drawDebugChildren(shapeRenderer);
        if (this.x) {
            resetTransform(shapeRenderer);
        }
    }

    public void drawDebugChildren(com.badlogic.gdx.graphics.glutils.ShapeRenderer shapeRenderer) {
        com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> snapshotArray = this.t;
        com.badlogic.gdx.scenes.scene2d.Actor[] begin = snapshotArray.begin();
        int i = 0;
        if (this.x) {
            int i2 = snapshotArray.size;
            while (i < i2) {
                com.badlogic.gdx.scenes.scene2d.Actor actor = begin[i];
                if (actor.isVisible() && (actor.getDebug() || (actor instanceof com.badlogic.gdx.scenes.scene2d.Group))) {
                    actor.drawDebug(shapeRenderer);
                }
                i++;
            }
            shapeRenderer.flush();
        } else {
            float f = this.i;
            float f2 = this.j;
            this.i = 0.0f;
            this.j = 0.0f;
            int i3 = snapshotArray.size;
            while (i < i3) {
                com.badlogic.gdx.scenes.scene2d.Actor actor2 = begin[i];
                if (actor2.isVisible() && (actor2.getDebug() || (actor2 instanceof com.badlogic.gdx.scenes.scene2d.Group))) {
                    float f3 = actor2.i;
                    float f4 = actor2.j;
                    actor2.i = f3 + f;
                    actor2.j = f4 + f2;
                    actor2.drawDebug(shapeRenderer);
                    actor2.i = f3;
                    actor2.j = f4;
                }
                i++;
            }
            this.i = f;
            this.j = f2;
        }
        snapshotArray.end();
    }

    public <T extends com.badlogic.gdx.scenes.scene2d.Actor> T findActor(java.lang.String str) {
        T t;
        com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> snapshotArray = this.t;
        int i = snapshotArray.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (str.equals(snapshotArray.get(i2).getName())) {
                return (T) snapshotArray.get(i2);
            }
        }
        int i3 = snapshotArray.size;
        for (int i4 = 0; i4 < i3; i4++) {
            com.badlogic.gdx.scenes.scene2d.Actor actor = snapshotArray.get(i4);
            if ((actor instanceof com.badlogic.gdx.scenes.scene2d.Group) && (t = (T) ((com.badlogic.gdx.scenes.scene2d.Group) actor).findActor(str)) != null) {
                return t;
            }
        }
        return null;
    }

    public com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> getChildren() {
        return this.t;
    }

    public com.badlogic.gdx.math.Rectangle getCullingArea() {
        return this.y;
    }

    public boolean hasChildren() {
        return this.t.size > 0;
    }

    public boolean isTransform() {
        return this.x;
    }

    public com.badlogic.gdx.math.Vector2 localToDescendantCoordinates(com.badlogic.gdx.scenes.scene2d.Actor actor, com.badlogic.gdx.math.Vector2 vector2) {
        com.badlogic.gdx.scenes.scene2d.Group group = actor.b;
        if (group != null) {
            if (group != this) {
                localToDescendantCoordinates(group, vector2);
            }
            actor.parentToLocalCoordinates(vector2);
            return vector2;
        }
        throw new java.lang.IllegalArgumentException("Child is not a descendant: " + actor);
    }

    public boolean removeActor(com.badlogic.gdx.scenes.scene2d.Actor actor) {
        return removeActor(actor, true);
    }

    public boolean removeActor(com.badlogic.gdx.scenes.scene2d.Actor actor, boolean z2) {
        if (!this.t.removeValue(actor, true)) {
            return false;
        }
        actor.setParent(null);
        actor.setStage(null);
        childrenChanged();
        return true;
    }

    public void resetTransform(com.badlogic.gdx.graphics.g2d.Batch batch) {
        batch.setTransformMatrix(this.w);
    }

    public void resetTransform(com.badlogic.gdx.graphics.glutils.ShapeRenderer shapeRenderer) {
        shapeRenderer.setTransformMatrix(this.w);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.utils.Cullable
    public void setCullingArea(com.badlogic.gdx.math.Rectangle rectangle) {
        this.y = rectangle;
    }

    public void setDebug(boolean z2, boolean z3) {
        setDebug(z2);
        if (z3) {
            java.util.Iterator<com.badlogic.gdx.scenes.scene2d.Actor> it = this.t.iterator();
            while (it.hasNext()) {
                com.badlogic.gdx.scenes.scene2d.Actor next = it.next();
                if (next instanceof com.badlogic.gdx.scenes.scene2d.Group) {
                    ((com.badlogic.gdx.scenes.scene2d.Group) next).setDebug(z2, z3);
                } else {
                    next.setDebug(z2);
                }
            }
        }
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Actor
    public void setStage(com.badlogic.gdx.scenes.scene2d.Stage stage) {
        super.setStage(stage);
        com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> snapshotArray = this.t;
        com.badlogic.gdx.scenes.scene2d.Actor[] actorArr = snapshotArray.items;
        int i = snapshotArray.size;
        for (int i2 = 0; i2 < i; i2++) {
            actorArr[i2].setStage(stage);
        }
    }

    public void setTransform(boolean z2) {
        this.x = z2;
    }

    public boolean swapActor(int i, int i2) {
        com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.scenes.scene2d.Actor> snapshotArray = this.t;
        int i3 = snapshotArray.size;
        if (i < 0 || i >= i3 || i2 < 0 || i2 >= i3) {
            return false;
        }
        snapshotArray.swap(i, i2);
        return true;
    }

    public boolean swapActor(com.badlogic.gdx.scenes.scene2d.Actor actor, com.badlogic.gdx.scenes.scene2d.Actor actor2) {
        int indexOf = this.t.indexOf(actor, true);
        int indexOf2 = this.t.indexOf(actor2, true);
        if (indexOf == -1 || indexOf2 == -1) {
            return false;
        }
        this.t.swap(indexOf, indexOf2);
        return true;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Actor
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        a(sb, 1);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
