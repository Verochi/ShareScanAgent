package com.otaliastudios.cameraview.gesture;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'PINCH' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes19.dex */
public final class Gesture {
    private static final /* synthetic */ com.otaliastudios.cameraview.gesture.Gesture[] $VALUES;
    public static final com.otaliastudios.cameraview.gesture.Gesture LONG_TAP;
    public static final com.otaliastudios.cameraview.gesture.Gesture PINCH;
    public static final com.otaliastudios.cameraview.gesture.Gesture SCROLL_HORIZONTAL;
    public static final com.otaliastudios.cameraview.gesture.Gesture SCROLL_VERTICAL;
    public static final com.otaliastudios.cameraview.gesture.Gesture TAP;
    private com.otaliastudios.cameraview.gesture.GestureType type;

    static {
        com.otaliastudios.cameraview.gesture.GestureType gestureType = com.otaliastudios.cameraview.gesture.GestureType.CONTINUOUS;
        com.otaliastudios.cameraview.gesture.Gesture gesture = new com.otaliastudios.cameraview.gesture.Gesture("PINCH", 0, gestureType);
        PINCH = gesture;
        com.otaliastudios.cameraview.gesture.GestureType gestureType2 = com.otaliastudios.cameraview.gesture.GestureType.ONE_SHOT;
        com.otaliastudios.cameraview.gesture.Gesture gesture2 = new com.otaliastudios.cameraview.gesture.Gesture("TAP", 1, gestureType2);
        TAP = gesture2;
        com.otaliastudios.cameraview.gesture.Gesture gesture3 = new com.otaliastudios.cameraview.gesture.Gesture("LONG_TAP", 2, gestureType2);
        LONG_TAP = gesture3;
        com.otaliastudios.cameraview.gesture.Gesture gesture4 = new com.otaliastudios.cameraview.gesture.Gesture("SCROLL_HORIZONTAL", 3, gestureType);
        SCROLL_HORIZONTAL = gesture4;
        com.otaliastudios.cameraview.gesture.Gesture gesture5 = new com.otaliastudios.cameraview.gesture.Gesture("SCROLL_VERTICAL", 4, gestureType);
        SCROLL_VERTICAL = gesture5;
        $VALUES = new com.otaliastudios.cameraview.gesture.Gesture[]{gesture, gesture2, gesture3, gesture4, gesture5};
    }

    private Gesture(@androidx.annotation.NonNull java.lang.String str, int i, com.otaliastudios.cameraview.gesture.GestureType gestureType) {
        this.type = gestureType;
    }

    public static com.otaliastudios.cameraview.gesture.Gesture valueOf(java.lang.String str) {
        return (com.otaliastudios.cameraview.gesture.Gesture) java.lang.Enum.valueOf(com.otaliastudios.cameraview.gesture.Gesture.class, str);
    }

    public static com.otaliastudios.cameraview.gesture.Gesture[] values() {
        return (com.otaliastudios.cameraview.gesture.Gesture[]) $VALUES.clone();
    }

    public boolean isAssignableTo(@androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.GestureAction gestureAction) {
        return gestureAction == com.otaliastudios.cameraview.gesture.GestureAction.NONE || gestureAction.type() == this.type;
    }
}
