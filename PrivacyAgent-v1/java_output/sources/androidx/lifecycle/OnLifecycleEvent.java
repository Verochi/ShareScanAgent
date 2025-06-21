package androidx.lifecycle;

@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.Deprecated
/* loaded from: classes.dex */
public @interface OnLifecycleEvent {
    androidx.lifecycle.Lifecycle.Event value();
}
