package com.otaliastudios.cameraview.gesture;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NONE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes19.dex */
public final class GestureAction {
    private static final /* synthetic */ com.otaliastudios.cameraview.gesture.GestureAction[] $VALUES;
    public static final com.otaliastudios.cameraview.gesture.GestureAction AUTO_FOCUS;
    static final com.otaliastudios.cameraview.gesture.GestureAction DEFAULT_LONG_TAP;
    static final com.otaliastudios.cameraview.gesture.GestureAction DEFAULT_PINCH;
    static final com.otaliastudios.cameraview.gesture.GestureAction DEFAULT_SCROLL_HORIZONTAL;
    static final com.otaliastudios.cameraview.gesture.GestureAction DEFAULT_SCROLL_VERTICAL;
    static final com.otaliastudios.cameraview.gesture.GestureAction DEFAULT_TAP;
    public static final com.otaliastudios.cameraview.gesture.GestureAction EXPOSURE_CORRECTION;
    public static final com.otaliastudios.cameraview.gesture.GestureAction FILTER_CONTROL_1;
    public static final com.otaliastudios.cameraview.gesture.GestureAction FILTER_CONTROL_2;
    public static final com.otaliastudios.cameraview.gesture.GestureAction NONE;
    public static final com.otaliastudios.cameraview.gesture.GestureAction TAKE_PICTURE;
    public static final com.otaliastudios.cameraview.gesture.GestureAction ZOOM;
    private com.otaliastudios.cameraview.gesture.GestureType type;
    private int value;

    static {
        com.otaliastudios.cameraview.gesture.GestureType gestureType = com.otaliastudios.cameraview.gesture.GestureType.ONE_SHOT;
        com.otaliastudios.cameraview.gesture.GestureAction gestureAction = new com.otaliastudios.cameraview.gesture.GestureAction("NONE", 0, 0, gestureType);
        NONE = gestureAction;
        com.otaliastudios.cameraview.gesture.GestureAction gestureAction2 = new com.otaliastudios.cameraview.gesture.GestureAction("AUTO_FOCUS", 1, 1, gestureType);
        AUTO_FOCUS = gestureAction2;
        com.otaliastudios.cameraview.gesture.GestureAction gestureAction3 = new com.otaliastudios.cameraview.gesture.GestureAction("TAKE_PICTURE", 2, 2, gestureType);
        TAKE_PICTURE = gestureAction3;
        com.otaliastudios.cameraview.gesture.GestureType gestureType2 = com.otaliastudios.cameraview.gesture.GestureType.CONTINUOUS;
        com.otaliastudios.cameraview.gesture.GestureAction gestureAction4 = new com.otaliastudios.cameraview.gesture.GestureAction("ZOOM", 3, 3, gestureType2);
        ZOOM = gestureAction4;
        com.otaliastudios.cameraview.gesture.GestureAction gestureAction5 = new com.otaliastudios.cameraview.gesture.GestureAction("EXPOSURE_CORRECTION", 4, 4, gestureType2);
        EXPOSURE_CORRECTION = gestureAction5;
        com.otaliastudios.cameraview.gesture.GestureAction gestureAction6 = new com.otaliastudios.cameraview.gesture.GestureAction("FILTER_CONTROL_1", 5, 5, gestureType2);
        FILTER_CONTROL_1 = gestureAction6;
        com.otaliastudios.cameraview.gesture.GestureAction gestureAction7 = new com.otaliastudios.cameraview.gesture.GestureAction("FILTER_CONTROL_2", 6, 6, gestureType2);
        FILTER_CONTROL_2 = gestureAction7;
        $VALUES = new com.otaliastudios.cameraview.gesture.GestureAction[]{gestureAction, gestureAction2, gestureAction3, gestureAction4, gestureAction5, gestureAction6, gestureAction7};
        DEFAULT_PINCH = gestureAction;
        DEFAULT_TAP = gestureAction;
        DEFAULT_LONG_TAP = gestureAction;
        DEFAULT_SCROLL_HORIZONTAL = gestureAction;
        DEFAULT_SCROLL_VERTICAL = gestureAction;
    }

    private GestureAction(java.lang.String str, @androidx.annotation.NonNull int i, int i2, com.otaliastudios.cameraview.gesture.GestureType gestureType) {
        this.value = i2;
        this.type = gestureType;
    }

    @androidx.annotation.Nullable
    public static com.otaliastudios.cameraview.gesture.GestureAction fromValue(int i) {
        for (com.otaliastudios.cameraview.gesture.GestureAction gestureAction : values()) {
            if (gestureAction.value() == i) {
                return gestureAction;
            }
        }
        return null;
    }

    public static com.otaliastudios.cameraview.gesture.GestureAction valueOf(java.lang.String str) {
        return (com.otaliastudios.cameraview.gesture.GestureAction) java.lang.Enum.valueOf(com.otaliastudios.cameraview.gesture.GestureAction.class, str);
    }

    public static com.otaliastudios.cameraview.gesture.GestureAction[] values() {
        return (com.otaliastudios.cameraview.gesture.GestureAction[]) $VALUES.clone();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.gesture.GestureType type() {
        return this.type;
    }

    public int value() {
        return this.value;
    }
}
