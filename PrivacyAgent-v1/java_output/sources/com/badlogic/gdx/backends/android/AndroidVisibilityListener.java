package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class AndroidVisibilityListener {

    /* renamed from: com.badlogic.gdx.backends.android.AndroidVisibilityListener$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnSystemUiVisibilityChangeListener {
        public final /* synthetic */ com.badlogic.gdx.backends.android.AndroidApplicationBase a;

        /* renamed from: com.badlogic.gdx.backends.android.AndroidVisibilityListener$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC02491 implements java.lang.Runnable {
            public RunnableC02491() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.badlogic.gdx.backends.android.AndroidVisibilityListener.AnonymousClass1.this.a.useImmersiveMode(true);
            }
        }

        public AnonymousClass1(com.badlogic.gdx.backends.android.AndroidApplicationBase androidApplicationBase) {
            this.a = androidApplicationBase;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            this.a.getHandler().post(new com.badlogic.gdx.backends.android.AndroidVisibilityListener.AnonymousClass1.RunnableC02491());
        }
    }

    public void createListener(com.badlogic.gdx.backends.android.AndroidApplicationBase androidApplicationBase) {
        try {
            androidApplicationBase.getApplicationWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new com.badlogic.gdx.backends.android.AndroidVisibilityListener.AnonymousClass1(androidApplicationBase));
        } catch (java.lang.Throwable th) {
            androidApplicationBase.log("AndroidApplication", "Can't create OnSystemUiVisibilityChangeListener, unable to use immersive mode.", th);
        }
    }
}
