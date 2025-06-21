package androidx.room;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@androidx.annotation.RequiresApi(16)
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Fts3 {
    java.lang.String tokenizer() default "simple";

    java.lang.String[] tokenizerArgs() default {};
}
