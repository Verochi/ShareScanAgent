package kotlin.annotation;

@java.lang.annotation.Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
@kotlin.annotation.MustBeDocumented
@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/annotation/Target;", "", "allowedTargets", "", "Lkotlin/annotation/AnnotationTarget;", "()[Lkotlin/annotation/AnnotationTarget;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {kotlin.annotation.AnnotationTarget.ANNOTATION_CLASS})
@java.lang.annotation.Documented
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes14.dex */
public @interface Target {
    kotlin.annotation.AnnotationTarget[] allowedTargets();
}
