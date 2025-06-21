package com.anythink.basead.ui.d;

/* loaded from: classes12.dex */
public final class b {
    private static final java.lang.String a = "TouchEventClickTrigger";
    private static final int b = -1;
    private static final int c = 10;
    private int e;
    private int f;
    private com.anythink.basead.ui.c.a h;
    private boolean i;
    private int d = -1;
    private boolean g = false;

    /* renamed from: com.anythink.basead.ui.d.b$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ android.view.View a;

        /* renamed from: com.anythink.basead.ui.d.b$1$1, reason: invalid class name and collision with other inner class name */
        public class ViewOnTouchListenerC01511 implements android.view.View.OnTouchListener {
            final /* synthetic */ int[] a;
            final /* synthetic */ boolean[] b;
            final /* synthetic */ int c;
            final /* synthetic */ int d;

            public ViewOnTouchListenerC01511(int[] iArr, boolean[] zArr, int i, int i2) {
                this.a = iArr;
                this.b = zArr;
                this.c = i;
                this.d = i2;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int[] iArr = this.a;
                int i = iArr[0];
                int i2 = iArr[1];
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.b[0] = false;
                } else if (action != 1) {
                    if (action == 2 && rawX > i && rawX < i + this.c && rawY > i2 && rawY < i2 + this.d) {
                        this.b[0] = true;
                    }
                } else if (this.b[0]) {
                    com.anythink.basead.ui.d.b.this.a(12);
                }
                return false;
            }
        }

        public AnonymousClass1(android.view.View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            try {
                this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                android.view.View view = this.a;
                while (view.getParent() != null) {
                    java.lang.Object parent = view.getParent();
                    if (!(parent instanceof android.view.View)) {
                        break;
                    } else {
                        view = (android.view.View) parent;
                    }
                }
                android.view.View view2 = this.a;
                if (view == view2) {
                    return;
                }
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                view.setOnTouchListener(new com.anythink.basead.ui.d.b.AnonymousClass1.ViewOnTouchListenerC01511(iArr, new boolean[]{false}, this.a.getWidth(), this.a.getHeight()));
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.anythink.basead.ui.c.a aVar = this.h;
        if (aVar != null) {
            aVar.a(i, 13);
        }
    }

    private void a(android.view.View view) {
        if (this.i) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new com.anythink.basead.ui.d.b.AnonymousClass1(view));
        }
    }

    public final com.anythink.basead.ui.d.b a(com.anythink.basead.ui.c.a aVar) {
        this.h = aVar;
        return this;
    }

    public final com.anythink.basead.ui.d.b a(boolean z) {
        this.i = z;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r0 != 3) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(android.view.MotionEvent motionEvent) {
        int findPointerIndex;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i = this.d;
                    if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                        int y = (int) motionEvent.getY(findPointerIndex);
                        int x = (int) motionEvent.getX(findPointerIndex);
                        int abs = java.lang.Math.abs(y - this.e);
                        int abs2 = java.lang.Math.abs(x - this.f);
                        if (abs > 10 || abs2 > 10) {
                            this.g = true;
                        }
                    }
                }
            }
            if (this.g) {
                a(13);
            }
            int findPointerIndex2 = motionEvent.findPointerIndex(this.d);
            this.f = (int) motionEvent.getX(findPointerIndex2);
            this.e = (int) motionEvent.getY(findPointerIndex2);
            this.g = false;
            this.d = -1;
        } else {
            this.e = (int) motionEvent.getY();
            this.f = (int) motionEvent.getX();
            this.d = motionEvent.getPointerId(0);
            this.g = false;
        }
        return this.g;
    }

    public final boolean a(android.view.View view, android.view.MotionEvent motionEvent) {
        int findPointerIndex;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = (int) motionEvent.getY();
            this.f = (int) motionEvent.getX();
            this.d = motionEvent.getPointerId(0);
            this.g = false;
        } else if (action == 1) {
            if (this.g) {
                a(13);
            }
            int findPointerIndex2 = motionEvent.findPointerIndex(this.d);
            this.f = (int) motionEvent.getX(findPointerIndex2);
            this.e = (int) motionEvent.getY(findPointerIndex2);
            this.g = false;
            this.d = -1;
        } else if (action == 2 && (findPointerIndex = motionEvent.findPointerIndex(this.d)) != -1) {
            int x = (int) motionEvent.getX(findPointerIndex);
            int y = (int) motionEvent.getY(findPointerIndex);
            int abs = java.lang.Math.abs(x - this.f);
            if (java.lang.Math.abs(y - this.e) > 10 || abs > 10) {
                this.g = true;
                android.view.ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }
}
