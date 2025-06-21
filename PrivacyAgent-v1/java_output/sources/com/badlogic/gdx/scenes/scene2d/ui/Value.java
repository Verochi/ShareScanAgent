package com.badlogic.gdx.scenes.scene2d.ui;

/* loaded from: classes12.dex */
public abstract class Value {
    public static final com.badlogic.gdx.scenes.scene2d.ui.Value.Fixed zero = new com.badlogic.gdx.scenes.scene2d.ui.Value.Fixed(0.0f);
    public static com.badlogic.gdx.scenes.scene2d.ui.Value minWidth = new com.badlogic.gdx.scenes.scene2d.ui.Value.AnonymousClass1();
    public static com.badlogic.gdx.scenes.scene2d.ui.Value minHeight = new com.badlogic.gdx.scenes.scene2d.ui.Value.AnonymousClass2();
    public static com.badlogic.gdx.scenes.scene2d.ui.Value prefWidth = new com.badlogic.gdx.scenes.scene2d.ui.Value.AnonymousClass3();
    public static com.badlogic.gdx.scenes.scene2d.ui.Value prefHeight = new com.badlogic.gdx.scenes.scene2d.ui.Value.AnonymousClass4();
    public static com.badlogic.gdx.scenes.scene2d.ui.Value maxWidth = new com.badlogic.gdx.scenes.scene2d.ui.Value.AnonymousClass5();
    public static com.badlogic.gdx.scenes.scene2d.ui.Value maxHeight = new com.badlogic.gdx.scenes.scene2d.ui.Value.AnonymousClass6();

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$1, reason: invalid class name */
    public class AnonymousClass1 extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            if (actor instanceof com.badlogic.gdx.scenes.scene2d.utils.Layout) {
                return ((com.badlogic.gdx.scenes.scene2d.utils.Layout) actor).getMinWidth();
            }
            if (actor == 0) {
                return 0.0f;
            }
            return actor.getWidth();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$10, reason: invalid class name */
    public class AnonymousClass10 extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        public final /* synthetic */ com.badlogic.gdx.scenes.scene2d.Actor a;
        public final /* synthetic */ float b;

        public AnonymousClass10(com.badlogic.gdx.scenes.scene2d.Actor actor, float f) {
            this.a = actor;
            this.b = f;
        }

        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            return this.a.getHeight() * this.b;
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$2, reason: invalid class name */
    public class AnonymousClass2 extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            if (actor instanceof com.badlogic.gdx.scenes.scene2d.utils.Layout) {
                return ((com.badlogic.gdx.scenes.scene2d.utils.Layout) actor).getMinHeight();
            }
            if (actor == 0) {
                return 0.0f;
            }
            return actor.getHeight();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$3, reason: invalid class name */
    public class AnonymousClass3 extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            if (actor instanceof com.badlogic.gdx.scenes.scene2d.utils.Layout) {
                return ((com.badlogic.gdx.scenes.scene2d.utils.Layout) actor).getPrefWidth();
            }
            if (actor == 0) {
                return 0.0f;
            }
            return actor.getWidth();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$4, reason: invalid class name */
    public class AnonymousClass4 extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            if (actor instanceof com.badlogic.gdx.scenes.scene2d.utils.Layout) {
                return ((com.badlogic.gdx.scenes.scene2d.utils.Layout) actor).getPrefHeight();
            }
            if (actor == 0) {
                return 0.0f;
            }
            return actor.getHeight();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$5, reason: invalid class name */
    public class AnonymousClass5 extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            if (actor instanceof com.badlogic.gdx.scenes.scene2d.utils.Layout) {
                return ((com.badlogic.gdx.scenes.scene2d.utils.Layout) actor).getMaxWidth();
            }
            if (actor == 0) {
                return 0.0f;
            }
            return actor.getWidth();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$6, reason: invalid class name */
    public class AnonymousClass6 extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            if (actor instanceof com.badlogic.gdx.scenes.scene2d.utils.Layout) {
                return ((com.badlogic.gdx.scenes.scene2d.utils.Layout) actor).getMaxHeight();
            }
            if (actor == 0) {
                return 0.0f;
            }
            return actor.getHeight();
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$7, reason: invalid class name */
    public class AnonymousClass7 extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        public final /* synthetic */ float a;

        public AnonymousClass7(float f) {
            this.a = f;
        }

        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            return actor.getWidth() * this.a;
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$8, reason: invalid class name */
    public class AnonymousClass8 extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        public final /* synthetic */ float a;

        public AnonymousClass8(float f) {
            this.a = f;
        }

        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            return actor.getHeight() * this.a;
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Value$9, reason: invalid class name */
    public class AnonymousClass9 extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        public final /* synthetic */ com.badlogic.gdx.scenes.scene2d.Actor a;
        public final /* synthetic */ float b;

        public AnonymousClass9(com.badlogic.gdx.scenes.scene2d.Actor actor, float f) {
            this.a = actor;
            this.b = f;
        }

        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            return this.a.getWidth() * this.b;
        }
    }

    public static class Fixed extends com.badlogic.gdx.scenes.scene2d.ui.Value {
        public final float a;

        public Fixed(float f) {
            this.a = f;
        }

        @Override // com.badlogic.gdx.scenes.scene2d.ui.Value
        public float get(com.badlogic.gdx.scenes.scene2d.Actor actor) {
            return this.a;
        }
    }

    public static com.badlogic.gdx.scenes.scene2d.ui.Value percentHeight(float f) {
        return new com.badlogic.gdx.scenes.scene2d.ui.Value.AnonymousClass8(f);
    }

    public static com.badlogic.gdx.scenes.scene2d.ui.Value percentHeight(float f, com.badlogic.gdx.scenes.scene2d.Actor actor) {
        if (actor != null) {
            return new com.badlogic.gdx.scenes.scene2d.ui.Value.AnonymousClass10(actor, f);
        }
        throw new java.lang.IllegalArgumentException("actor cannot be null.");
    }

    public static com.badlogic.gdx.scenes.scene2d.ui.Value percentWidth(float f) {
        return new com.badlogic.gdx.scenes.scene2d.ui.Value.AnonymousClass7(f);
    }

    public static com.badlogic.gdx.scenes.scene2d.ui.Value percentWidth(float f, com.badlogic.gdx.scenes.scene2d.Actor actor) {
        if (actor != null) {
            return new com.badlogic.gdx.scenes.scene2d.ui.Value.AnonymousClass9(actor, f);
        }
        throw new java.lang.IllegalArgumentException("actor cannot be null.");
    }

    public abstract float get(com.badlogic.gdx.scenes.scene2d.Actor actor);
}
