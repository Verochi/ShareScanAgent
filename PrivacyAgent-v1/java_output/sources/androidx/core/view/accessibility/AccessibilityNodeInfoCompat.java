package androidx.core.view.accessibility;

/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final java.lang.String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final java.lang.String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final java.lang.String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final java.lang.String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final java.lang.String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final java.lang.String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

    @android.annotation.SuppressLint({"ActionValue"})
    public static final java.lang.String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final java.lang.String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final java.lang.String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final java.lang.String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final java.lang.String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final java.lang.String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final java.lang.String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final java.lang.String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final java.lang.String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final java.lang.String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final java.lang.String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final java.lang.String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final java.lang.String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final java.lang.String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final java.lang.String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final java.lang.String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final java.lang.String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static int sClickableSpanId;
    private final android.view.accessibility.AccessibilityNodeInfo mInfo;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mParentVirtualDescendantId = -1;
    private int mVirtualDescendantId = -1;

    public static class AccessibilityActionCompat {
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CONTEXT_CLICK;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_HIDE_TOOLTIP;

        @androidx.annotation.NonNull
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_IME_ENTER;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_MOVE_WINDOW;

        @androidx.annotation.NonNull
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_DOWN;

        @androidx.annotation.NonNull
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_LEFT;

        @androidx.annotation.NonNull
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_RIGHT;

        @androidx.annotation.NonNull
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_UP;

        @androidx.annotation.NonNull
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_DOWN;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_LEFT;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_RIGHT;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_UP;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_PROGRESS;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
        private static final java.lang.String TAG = "A11yActionCompat";
        final java.lang.Object mAction;

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected final androidx.core.view.accessibility.AccessibilityViewCommand mCommand;
        private final int mId;
        private final java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_FOCUS = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(1, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_FOCUS = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(2, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SELECT = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(4, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_SELECTION = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(8, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLICK = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_LONG_CLICK = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(64, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(128, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(256, (java.lang.CharSequence) null, (java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments>) androidx.core.view.accessibility.AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(512, (java.lang.CharSequence) null, (java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments>) androidx.core.view.accessibility.AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(1024, (java.lang.CharSequence) null, (java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments>) androidx.core.view.accessibility.AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(2048, (java.lang.CharSequence) null, (java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments>) androidx.core.view.accessibility.AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_FORWARD = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(4096, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(8192, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_COPY = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PASTE = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CUT = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_SELECTION = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, (java.lang.CharSequence) null, (java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments>) androidx.core.view.accessibility.AccessibilityViewCommand.SetSelectionArguments.class);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_EXPAND = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_COLLAPSE = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_DISMISS = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, null);
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_TEXT = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, (java.lang.CharSequence) null, (java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments>) androidx.core.view.accessibility.AccessibilityViewCommand.SetTextArguments.class);

        static {
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction22;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction23;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction24;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction25;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction26;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction27;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction28;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction29;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction30;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction31;
            android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction accessibilityAction32;
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 23) {
                accessibilityAction32 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
                accessibilityAction = accessibilityAction32;
            } else {
                accessibilityAction = null;
            }
            ACTION_SHOW_ON_SCREEN = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction, android.R.id.accessibilityActionShowOnScreen, null, null, null);
            if (i >= 23) {
                accessibilityAction31 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
                accessibilityAction2 = accessibilityAction31;
            } else {
                accessibilityAction2 = null;
            }
            ACTION_SCROLL_TO_POSITION = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction2, android.R.id.accessibilityActionScrollToPosition, null, null, androidx.core.view.accessibility.AccessibilityViewCommand.ScrollToPositionArguments.class);
            if (i >= 23) {
                accessibilityAction30 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
                accessibilityAction3 = accessibilityAction30;
            } else {
                accessibilityAction3 = null;
            }
            ACTION_SCROLL_UP = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction3, android.R.id.accessibilityActionScrollUp, null, null, null);
            if (i >= 23) {
                accessibilityAction29 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
                accessibilityAction4 = accessibilityAction29;
            } else {
                accessibilityAction4 = null;
            }
            ACTION_SCROLL_LEFT = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction4, android.R.id.accessibilityActionScrollLeft, null, null, null);
            if (i >= 23) {
                accessibilityAction28 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
                accessibilityAction5 = accessibilityAction28;
            } else {
                accessibilityAction5 = null;
            }
            ACTION_SCROLL_DOWN = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction5, android.R.id.accessibilityActionScrollDown, null, null, null);
            if (i >= 23) {
                accessibilityAction27 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
                accessibilityAction6 = accessibilityAction27;
            } else {
                accessibilityAction6 = null;
            }
            ACTION_SCROLL_RIGHT = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction6, android.R.id.accessibilityActionScrollRight, null, null, null);
            if (i >= 29) {
                accessibilityAction26 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
                accessibilityAction7 = accessibilityAction26;
            } else {
                accessibilityAction7 = null;
            }
            ACTION_PAGE_UP = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction7, android.R.id.accessibilityActionPageUp, null, null, null);
            if (i >= 29) {
                accessibilityAction25 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
                accessibilityAction8 = accessibilityAction25;
            } else {
                accessibilityAction8 = null;
            }
            ACTION_PAGE_DOWN = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction8, android.R.id.accessibilityActionPageDown, null, null, null);
            if (i >= 29) {
                accessibilityAction24 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
                accessibilityAction9 = accessibilityAction24;
            } else {
                accessibilityAction9 = null;
            }
            ACTION_PAGE_LEFT = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction9, android.R.id.accessibilityActionPageLeft, null, null, null);
            if (i >= 29) {
                accessibilityAction23 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
                accessibilityAction10 = accessibilityAction23;
            } else {
                accessibilityAction10 = null;
            }
            ACTION_PAGE_RIGHT = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction10, android.R.id.accessibilityActionPageRight, null, null, null);
            if (i >= 23) {
                accessibilityAction22 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
                accessibilityAction11 = accessibilityAction22;
            } else {
                accessibilityAction11 = null;
            }
            ACTION_CONTEXT_CLICK = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction11, android.R.id.accessibilityActionContextClick, null, null, null);
            if (i >= 24) {
                accessibilityAction21 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
                accessibilityAction12 = accessibilityAction21;
            } else {
                accessibilityAction12 = null;
            }
            ACTION_SET_PROGRESS = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction12, android.R.id.accessibilityActionSetProgress, null, null, androidx.core.view.accessibility.AccessibilityViewCommand.SetProgressArguments.class);
            if (i >= 26) {
                accessibilityAction20 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
                accessibilityAction13 = accessibilityAction20;
            } else {
                accessibilityAction13 = null;
            }
            ACTION_MOVE_WINDOW = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction13, android.R.id.accessibilityActionMoveWindow, null, null, androidx.core.view.accessibility.AccessibilityViewCommand.MoveWindowArguments.class);
            if (i >= 28) {
                accessibilityAction19 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
                accessibilityAction14 = accessibilityAction19;
            } else {
                accessibilityAction14 = null;
            }
            ACTION_SHOW_TOOLTIP = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction14, android.R.id.accessibilityActionShowTooltip, null, null, null);
            if (i >= 28) {
                accessibilityAction18 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
                accessibilityAction15 = accessibilityAction18;
            } else {
                accessibilityAction15 = null;
            }
            ACTION_HIDE_TOOLTIP = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction15, android.R.id.accessibilityActionHideTooltip, null, null, null);
            if (i >= 30) {
                accessibilityAction17 = android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
                accessibilityAction16 = accessibilityAction17;
            } else {
                accessibilityAction16 = null;
            }
            ACTION_PRESS_AND_HOLD = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction16, android.R.id.accessibilityActionPressAndHold, null, null, null);
            ACTION_IME_ENTER = new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(i >= 30 ? android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, android.R.id.accessibilityActionImeEnter, null, null, null);
        }

        public AccessibilityActionCompat(int i, java.lang.CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int i, java.lang.CharSequence charSequence, androidx.core.view.accessibility.AccessibilityViewCommand accessibilityViewCommand) {
            this(null, i, charSequence, accessibilityViewCommand, null);
        }

        private AccessibilityActionCompat(int i, java.lang.CharSequence charSequence, java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments> cls) {
            this(null, i, charSequence, null, cls);
        }

        public AccessibilityActionCompat(java.lang.Object obj) {
            this(obj, 0, null, null, null);
        }

        public AccessibilityActionCompat(java.lang.Object obj, int i, java.lang.CharSequence charSequence, androidx.core.view.accessibility.AccessibilityViewCommand accessibilityViewCommand, java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments> cls) {
            this.mId = i;
            this.mCommand = accessibilityViewCommand;
            if (obj == null) {
                this.mAction = new android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.mAction = obj;
            }
            this.mViewCommandArgumentClass = cls;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat createReplacementAction(java.lang.CharSequence charSequence, androidx.core.view.accessibility.AccessibilityViewCommand accessibilityViewCommand) {
            return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, this.mId, charSequence, accessibilityViewCommand, this.mViewCommandArgumentClass);
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (obj == null || !(obj instanceof androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat)) {
                return false;
            }
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = (androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat) obj;
            java.lang.Object obj2 = this.mAction;
            return obj2 == null ? accessibilityActionCompat.mAction == null : obj2.equals(accessibilityActionCompat.mAction);
        }

        public int getId() {
            return ((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
        }

        public java.lang.CharSequence getLabel() {
            return ((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) this.mAction).getLabel();
        }

        public int hashCode() {
            java.lang.Object obj = this.mAction;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean perform(android.view.View view, android.os.Bundle bundle) {
            androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments newInstance;
            if (this.mCommand == null) {
                return false;
            }
            java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments> cls = this.mViewCommandArgumentClass;
            androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments commandArguments = null;
            if (cls != null) {
                try {
                    newInstance = cls.getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
                } catch (java.lang.Exception unused) {
                }
                try {
                    newInstance.setBundle(bundle);
                    commandArguments = newInstance;
                } catch (java.lang.Exception unused2) {
                    commandArguments = newInstance;
                    java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments> cls2 = this.mViewCommandArgumentClass;
                    java.lang.String name = cls2 == null ? com.igexin.push.core.b.m : cls2.getName();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Failed to execute command with argument class ViewCommandArgument: ");
                    sb.append(name);
                    return this.mCommand.perform(view, commandArguments);
                }
            }
            return this.mCommand.perform(view, commandArguments);
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final java.lang.Object mInfo;

        public CollectionInfoCompat(java.lang.Object obj) {
            this.mInfo = obj;
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat obtain(int i, int i2, boolean z) {
            return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat(android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat obtain(int i, int i2, boolean z, int i3) {
            return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat(android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
        }

        public int getColumnCount() {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) this.mInfo).getColumnCount();
        }

        public int getRowCount() {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) this.mInfo).getRowCount();
        }

        public int getSelectionMode() {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) this.mInfo).getSelectionMode();
        }

        public boolean isHierarchical() {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) this.mInfo).isHierarchical();
        }
    }

    public static class CollectionItemInfoCompat {
        final java.lang.Object mInfo;

        public CollectionItemInfoCompat(java.lang.Object obj) {
            this.mInfo = obj;
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z) {
            return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat(android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat(android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
        }

        public int getColumnIndex() {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnIndex();
        }

        public int getColumnSpan() {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnSpan();
        }

        public int getRowIndex() {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowIndex();
        }

        public int getRowSpan() {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowSpan();
        }

        @java.lang.Deprecated
        public boolean isHeading() {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isHeading();
        }

        public boolean isSelected() {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isSelected();
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final java.lang.Object mInfo;

        public RangeInfoCompat(java.lang.Object obj) {
            this.mInfo = obj;
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat obtain(int i, float f, float f2, float f3) {
            return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat(android.view.accessibility.AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3));
        }

        public float getCurrent() {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) this.mInfo).getCurrent();
        }

        public float getMax() {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) this.mInfo).getMax();
        }

        public float getMin() {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) this.mInfo).getMin();
        }

        public int getType() {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) this.mInfo).getType();
        }
    }

    public static final class TouchDelegateInfoCompat {
        final android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        public TouchDelegateInfoCompat(@androidx.annotation.NonNull android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.mInfo = touchDelegateInfo;
        }

        public TouchDelegateInfoCompat(@androidx.annotation.NonNull java.util.Map<android.graphics.Region, android.view.View> map) {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                this.mInfo = new android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo(map);
            } else {
                this.mInfo = null;
            }
        }

        @androidx.annotation.Nullable
        public android.graphics.Region getRegionAt(@androidx.annotation.IntRange(from = 0) int i) {
            android.graphics.Region regionAt;
            if (android.os.Build.VERSION.SDK_INT < 29) {
                return null;
            }
            regionAt = this.mInfo.getRegionAt(i);
            return regionAt;
        }

        @androidx.annotation.IntRange(from = 0)
        public int getRegionCount() {
            int regionCount;
            if (android.os.Build.VERSION.SDK_INT < 29) {
                return 0;
            }
            regionCount = this.mInfo.getRegionCount();
            return regionCount;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
        
            r3 = r2.mInfo.getTargetForRegion(r3);
         */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getTargetForRegion(@androidx.annotation.NonNull android.graphics.Region region) {
            android.view.accessibility.AccessibilityNodeInfo targetForRegion;
            if (android.os.Build.VERSION.SDK_INT < 29 || targetForRegion == null) {
                return null;
            }
            return androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(targetForRegion);
        }
    }

    private AccessibilityNodeInfoCompat(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mInfo = accessibilityNodeInfo;
    }

    @java.lang.Deprecated
    public AccessibilityNodeInfoCompat(java.lang.Object obj) {
        this.mInfo = (android.view.accessibility.AccessibilityNodeInfo) obj;
    }

    private void addSpanLocationToExtras(android.text.style.ClickableSpan clickableSpan, android.text.Spanned spanned, int i) {
        extrasIntList(SPANS_START_KEY).add(java.lang.Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        extrasIntList(SPANS_END_KEY).add(java.lang.Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        extrasIntList(SPANS_FLAGS_KEY).add(java.lang.Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        extrasIntList(SPANS_ID_KEY).add(java.lang.Integer.valueOf(i));
    }

    private void clearExtrasSpans() {
        this.mInfo.getExtras().remove(SPANS_START_KEY);
        this.mInfo.getExtras().remove(SPANS_END_KEY);
        this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
        this.mInfo.getExtras().remove(SPANS_ID_KEY);
    }

    private java.util.List<java.lang.Integer> extrasIntList(java.lang.String str) {
        java.util.ArrayList<java.lang.Integer> integerArrayList = this.mInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        java.util.ArrayList<java.lang.Integer> arrayList = new java.util.ArrayList<>();
        this.mInfo.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static java.lang.String getActionSymbolicName(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case android.R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case android.R.id.accessibilityActionImeEnter:
                return "ACTION_IME_ENTER";
            default:
                switch (i) {
                    case android.R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case android.R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case android.R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case android.R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case android.R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case android.R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case android.R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case android.R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case android.R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case android.R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case android.R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case android.R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case android.R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case android.R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case android.R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    private boolean getBooleanProperty(int i) {
        android.os.Bundle extras = getExtras();
        return extras != null && (extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & i) == i;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static android.text.style.ClickableSpan[] getClickableSpans(java.lang.CharSequence charSequence) {
        if (charSequence instanceof android.text.Spanned) {
            return (android.text.style.ClickableSpan[]) ((android.text.Spanned) charSequence).getSpans(0, charSequence.length(), android.text.style.ClickableSpan.class);
        }
        return null;
    }

    private android.util.SparseArray<java.lang.ref.WeakReference<android.text.style.ClickableSpan>> getOrCreateSpansFromViewTags(android.view.View view) {
        android.util.SparseArray<java.lang.ref.WeakReference<android.text.style.ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags != null) {
            return spansFromViewTags;
        }
        android.util.SparseArray<java.lang.ref.WeakReference<android.text.style.ClickableSpan>> sparseArray = new android.util.SparseArray<>();
        view.setTag(androidx.core.R.id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private android.util.SparseArray<java.lang.ref.WeakReference<android.text.style.ClickableSpan>> getSpansFromViewTags(android.view.View view) {
        return (android.util.SparseArray) view.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
    }

    private boolean hasSpans() {
        return !extrasIntList(SPANS_START_KEY).isEmpty();
    }

    private int idForClickableSpan(android.text.style.ClickableSpan clickableSpan, android.util.SparseArray<java.lang.ref.WeakReference<android.text.style.ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = sClickableSpanId;
        sClickableSpanId = i2 + 1;
        return i2;
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat obtain() {
        return wrap(android.view.accessibility.AccessibilityNodeInfo.obtain());
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat obtain(android.view.View view) {
        return wrap(android.view.accessibility.AccessibilityNodeInfo.obtain(view));
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat obtain(android.view.View view, int i) {
        return wrapNonNullInstance(android.view.accessibility.AccessibilityNodeInfo.obtain(view, i));
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat obtain(androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrap(android.view.accessibility.AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.mInfo));
    }

    private void removeCollectedSpans(android.view.View view) {
        android.util.SparseArray<java.lang.ref.WeakReference<android.text.style.ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < spansFromViewTags.size(); i++) {
                if (spansFromViewTags.valueAt(i).get() == null) {
                    arrayList.add(java.lang.Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spansFromViewTags.remove(((java.lang.Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    private void setBooleanProperty(int i, boolean z) {
        android.os.Bundle extras = getExtras();
        if (extras != null) {
            int i2 = extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~i);
            if (!z) {
                i = 0;
            }
            extras.putInt(BOOLEAN_PROPERTY_KEY, i | i2);
        }
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat wrap(@androidx.annotation.NonNull android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat wrapNonNullInstance(java.lang.Object obj) {
        if (obj != null) {
            return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public void addAction(int i) {
        this.mInfo.addAction(i);
    }

    public void addAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        this.mInfo.addAction((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    public void addChild(android.view.View view) {
        this.mInfo.addChild(view);
    }

    public void addChild(android.view.View view, int i) {
        this.mInfo.addChild(view, i);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(java.lang.CharSequence charSequence, android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            clearExtrasSpans();
            removeCollectedSpans(view);
            android.text.style.ClickableSpan[] clickableSpans = getClickableSpans(charSequence);
            if (clickableSpans == null || clickableSpans.length <= 0) {
                return;
            }
            getExtras().putInt(SPANS_ACTION_ID_KEY, androidx.core.R.id.accessibility_action_clickable_span);
            android.util.SparseArray<java.lang.ref.WeakReference<android.text.style.ClickableSpan>> orCreateSpansFromViewTags = getOrCreateSpansFromViewTags(view);
            for (int i = 0; i < clickableSpans.length; i++) {
                int idForClickableSpan = idForClickableSpan(clickableSpans[i], orCreateSpansFromViewTags);
                orCreateSpansFromViewTags.put(idForClickableSpan, new java.lang.ref.WeakReference<>(clickableSpans[i]));
                addSpanLocationToExtras(clickableSpans[i], (android.text.Spanned) charSequence, idForClickableSpan);
            }
        }
    }

    public boolean canOpenPopup() {
        return this.mInfo.canOpenPopup();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof androidx.core.view.accessibility.AccessibilityNodeInfoCompat)) {
            return false;
        }
        androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (androidx.core.view.accessibility.AccessibilityNodeInfoCompat) obj;
        android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.mInfo)) {
            return false;
        }
        return this.mVirtualDescendantId == accessibilityNodeInfoCompat.mVirtualDescendantId && this.mParentVirtualDescendantId == accessibilityNodeInfoCompat.mParentVirtualDescendantId;
    }

    public java.util.List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<android.view.accessibility.AccessibilityNodeInfo> findAccessibilityNodeInfosByText = this.mInfo.findAccessibilityNodeInfosByText(str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(wrap(findAccessibilityNodeInfosByText.get(i)));
        }
        return arrayList;
    }

    public java.util.List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(java.lang.String str) {
        java.util.List<android.view.accessibility.AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = this.mInfo.findAccessibilityNodeInfosByViewId(str);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<android.view.accessibility.AccessibilityNodeInfo> it = findAccessibilityNodeInfosByViewId.iterator();
        while (it.hasNext()) {
            arrayList.add(wrap(it.next()));
        }
        return arrayList;
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat findFocus(int i) {
        return wrapNonNullInstance(this.mInfo.findFocus(i));
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat focusSearch(int i) {
        return wrapNonNullInstance(this.mInfo.focusSearch(i));
    }

    public java.util.List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList() {
        java.util.List<android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction> actionList = this.mInfo.getActionList();
        if (actionList == null) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionList.get(i)));
        }
        return arrayList;
    }

    public int getActions() {
        return this.mInfo.getActions();
    }

    @java.lang.Deprecated
    public void getBoundsInParent(android.graphics.Rect rect) {
        this.mInfo.getBoundsInParent(rect);
    }

    public void getBoundsInScreen(android.graphics.Rect rect) {
        this.mInfo.getBoundsInScreen(rect);
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getChild(int i) {
        return wrapNonNullInstance(this.mInfo.getChild(i));
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public java.lang.CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat getCollectionInfo() {
        android.view.accessibility.AccessibilityNodeInfo.CollectionInfo collectionInfo = this.mInfo.getCollectionInfo();
        if (collectionInfo != null) {
            return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat(collectionInfo);
        }
        return null;
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat getCollectionItemInfo() {
        android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.mInfo.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat(collectionItemInfo);
        }
        return null;
    }

    public java.lang.CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        int drawingOrder;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        drawingOrder = this.mInfo.getDrawingOrder();
        return drawingOrder;
    }

    public java.lang.CharSequence getError() {
        return this.mInfo.getError();
    }

    public android.os.Bundle getExtras() {
        return this.mInfo.getExtras();
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getHintText() {
        java.lang.CharSequence hintText;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return this.mInfo.getExtras().getCharSequence(HINT_TEXT_KEY);
        }
        hintText = this.mInfo.getHintText();
        return hintText;
    }

    @java.lang.Deprecated
    public java.lang.Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return this.mInfo.getInputType();
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    public java.lang.CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getPaneTitle() {
        java.lang.CharSequence paneTitle;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return this.mInfo.getExtras().getCharSequence(PANE_TITLE_KEY);
        }
        paneTitle = this.mInfo.getPaneTitle();
        return paneTitle;
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat getRangeInfo() {
        android.view.accessibility.AccessibilityNodeInfo.RangeInfo rangeInfo = this.mInfo.getRangeInfo();
        if (rangeInfo != null) {
            return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat(rangeInfo);
        }
        return null;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getRoleDescription() {
        return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getStateDescription() {
        java.lang.CharSequence stateDescription;
        if (!androidx.core.os.BuildCompat.isAtLeastR()) {
            return this.mInfo.getExtras().getCharSequence(STATE_DESCRIPTION_KEY);
        }
        stateDescription = this.mInfo.getStateDescription();
        return stateDescription;
    }

    public java.lang.CharSequence getText() {
        if (!hasSpans()) {
            return this.mInfo.getText();
        }
        java.util.List<java.lang.Integer> extrasIntList = extrasIntList(SPANS_START_KEY);
        java.util.List<java.lang.Integer> extrasIntList2 = extrasIntList(SPANS_END_KEY);
        java.util.List<java.lang.Integer> extrasIntList3 = extrasIntList(SPANS_FLAGS_KEY);
        java.util.List<java.lang.Integer> extrasIntList4 = extrasIntList(SPANS_ID_KEY);
        android.text.SpannableString spannableString = new android.text.SpannableString(android.text.TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
        for (int i = 0; i < extrasIntList.size(); i++) {
            spannableString.setSpan(new androidx.core.view.accessibility.AccessibilityClickableSpanCompat(extrasIntList4.get(i).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), extrasIntList.get(i).intValue(), extrasIntList2.get(i).intValue(), extrasIntList3.get(i).intValue());
        }
        return spannableString;
    }

    public int getTextSelectionEnd() {
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getTooltipText() {
        java.lang.CharSequence tooltipText;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return this.mInfo.getExtras().getCharSequence(TOOLTIP_TEXT_KEY);
        }
        tooltipText = this.mInfo.getTooltipText();
        return tooltipText;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r2.mInfo.getTouchDelegateInfo();
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.TouchDelegateInfoCompat getTouchDelegateInfo() {
        android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        if (android.os.Build.VERSION.SDK_INT < 29 || touchDelegateInfo == null) {
            return null;
        }
        return new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.TouchDelegateInfoCompat(touchDelegateInfo);
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getTraversalAfter() {
        android.view.accessibility.AccessibilityNodeInfo traversalAfter;
        if (android.os.Build.VERSION.SDK_INT < 22) {
            return null;
        }
        traversalAfter = this.mInfo.getTraversalAfter();
        return wrapNonNullInstance(traversalAfter);
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getTraversalBefore() {
        android.view.accessibility.AccessibilityNodeInfo traversalBefore;
        if (android.os.Build.VERSION.SDK_INT < 22) {
            return null;
        }
        traversalBefore = this.mInfo.getTraversalBefore();
        return wrapNonNullInstance(traversalBefore);
    }

    public java.lang.String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    public androidx.core.view.accessibility.AccessibilityWindowInfoCompat getWindow() {
        return androidx.core.view.accessibility.AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    public int hashCode() {
        android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        boolean isContextClickable;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return false;
        }
        isContextClickable = this.mInfo.isContextClickable();
        return isContextClickable;
    }

    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
        return this.mInfo.isEditable();
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isHeading() {
        boolean isHeading;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            isHeading = this.mInfo.isHeading();
            return isHeading;
        }
        if (getBooleanProperty(2)) {
            return true;
        }
        androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfo = getCollectionItemInfo();
        return collectionItemInfo != null && collectionItemInfo.isHeading();
    }

    public boolean isImportantForAccessibility() {
        boolean isImportantForAccessibility;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return true;
        }
        isImportantForAccessibility = this.mInfo.isImportantForAccessibility();
        return isImportantForAccessibility;
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        boolean isScreenReaderFocusable;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return getBooleanProperty(1);
        }
        isScreenReaderFocusable = this.mInfo.isScreenReaderFocusable();
        return isScreenReaderFocusable;
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        boolean isShowingHintText;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return getBooleanProperty(4);
        }
        isShowingHintText = this.mInfo.isShowingHintText();
        return isShowingHintText;
    }

    public boolean isTextEntryKey() {
        boolean isTextEntryKey;
        if (android.os.Build.VERSION.SDK_INT < 29) {
            return getBooleanProperty(8);
        }
        isTextEntryKey = this.mInfo.isTextEntryKey();
        return isTextEntryKey;
    }

    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int i) {
        return this.mInfo.performAction(i);
    }

    public boolean performAction(int i, android.os.Bundle bundle) {
        return this.mInfo.performAction(i, bundle);
    }

    public void recycle() {
        this.mInfo.recycle();
    }

    public boolean refresh() {
        return this.mInfo.refresh();
    }

    public boolean removeAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        return this.mInfo.removeAction((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    public boolean removeChild(android.view.View view) {
        return this.mInfo.removeChild(view);
    }

    public boolean removeChild(android.view.View view, int i) {
        return this.mInfo.removeChild(view, i);
    }

    public void setAccessibilityFocused(boolean z) {
        this.mInfo.setAccessibilityFocused(z);
    }

    @java.lang.Deprecated
    public void setBoundsInParent(android.graphics.Rect rect) {
        this.mInfo.setBoundsInParent(rect);
    }

    public void setBoundsInScreen(android.graphics.Rect rect) {
        this.mInfo.setBoundsInScreen(rect);
    }

    public void setCanOpenPopup(boolean z) {
        this.mInfo.setCanOpenPopup(z);
    }

    public void setCheckable(boolean z) {
        this.mInfo.setCheckable(z);
    }

    public void setChecked(boolean z) {
        this.mInfo.setChecked(z);
    }

    public void setClassName(java.lang.CharSequence charSequence) {
        this.mInfo.setClassName(charSequence);
    }

    public void setClickable(boolean z) {
        this.mInfo.setClickable(z);
    }

    public void setCollectionInfo(java.lang.Object obj) {
        this.mInfo.setCollectionInfo(obj == null ? null : (android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) ((androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat) obj).mInfo);
    }

    public void setCollectionItemInfo(java.lang.Object obj) {
        this.mInfo.setCollectionItemInfo(obj == null ? null : (android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) ((androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat) obj).mInfo);
    }

    public void setContentDescription(java.lang.CharSequence charSequence) {
        this.mInfo.setContentDescription(charSequence);
    }

    public void setContentInvalid(boolean z) {
        this.mInfo.setContentInvalid(z);
    }

    public void setContextClickable(boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.mInfo.setContextClickable(z);
        }
    }

    public void setDismissable(boolean z) {
        this.mInfo.setDismissable(z);
    }

    public void setDrawingOrder(int i) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            this.mInfo.setDrawingOrder(i);
        }
    }

    public void setEditable(boolean z) {
        this.mInfo.setEditable(z);
    }

    public void setEnabled(boolean z) {
        this.mInfo.setEnabled(z);
    }

    public void setError(java.lang.CharSequence charSequence) {
        this.mInfo.setError(charSequence);
    }

    public void setFocusable(boolean z) {
        this.mInfo.setFocusable(z);
    }

    public void setFocused(boolean z) {
        this.mInfo.setFocused(z);
    }

    public void setHeading(boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setHeading(z);
        } else {
            setBooleanProperty(2, z);
        }
    }

    public void setHintText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setHintText(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(HINT_TEXT_KEY, charSequence);
        }
    }

    public void setImportantForAccessibility(boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            this.mInfo.setImportantForAccessibility(z);
        }
    }

    public void setInputType(int i) {
        this.mInfo.setInputType(i);
    }

    public void setLabelFor(android.view.View view) {
        this.mInfo.setLabelFor(view);
    }

    public void setLabelFor(android.view.View view, int i) {
        this.mInfo.setLabelFor(view, i);
    }

    public void setLabeledBy(android.view.View view) {
        this.mInfo.setLabeledBy(view);
    }

    public void setLabeledBy(android.view.View view, int i) {
        this.mInfo.setLabeledBy(view, i);
    }

    public void setLiveRegion(int i) {
        this.mInfo.setLiveRegion(i);
    }

    public void setLongClickable(boolean z) {
        this.mInfo.setLongClickable(z);
    }

    public void setMaxTextLength(int i) {
        this.mInfo.setMaxTextLength(i);
    }

    public void setMovementGranularities(int i) {
        this.mInfo.setMovementGranularities(i);
    }

    public void setMultiLine(boolean z) {
        this.mInfo.setMultiLine(z);
    }

    public void setPackageName(java.lang.CharSequence charSequence) {
        this.mInfo.setPackageName(charSequence);
    }

    public void setPaneTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setPaneTitle(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(PANE_TITLE_KEY, charSequence);
        }
    }

    public void setParent(android.view.View view) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(view);
    }

    public void setParent(android.view.View view, int i) {
        this.mParentVirtualDescendantId = i;
        this.mInfo.setParent(view, i);
    }

    public void setPassword(boolean z) {
        this.mInfo.setPassword(z);
    }

    public void setRangeInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat rangeInfoCompat) {
        this.mInfo.setRangeInfo((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.mInfo);
    }

    public void setRoleDescription(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        this.mInfo.getExtras().putCharSequence(ROLE_DESCRIPTION_KEY, charSequence);
    }

    public void setScreenReaderFocusable(boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setScreenReaderFocusable(z);
        } else {
            setBooleanProperty(1, z);
        }
    }

    public void setScrollable(boolean z) {
        this.mInfo.setScrollable(z);
    }

    public void setSelected(boolean z) {
        this.mInfo.setSelected(z);
    }

    public void setShowingHintText(boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setShowingHintText(z);
        } else {
            setBooleanProperty(4, z);
        }
    }

    public void setSource(android.view.View view) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(view);
    }

    public void setSource(android.view.View view, int i) {
        this.mVirtualDescendantId = i;
        this.mInfo.setSource(view, i);
    }

    public void setStateDescription(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (androidx.core.os.BuildCompat.isAtLeastR()) {
            this.mInfo.setStateDescription(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(STATE_DESCRIPTION_KEY, charSequence);
        }
    }

    public void setText(java.lang.CharSequence charSequence) {
        this.mInfo.setText(charSequence);
    }

    public void setTextEntryKey(boolean z) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTextEntryKey(z);
        } else {
            setBooleanProperty(8, z);
        }
    }

    public void setTextSelection(int i, int i2) {
        this.mInfo.setTextSelection(i, i2);
    }

    public void setTooltipText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setTooltipText(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(TOOLTIP_TEXT_KEY, charSequence);
        }
    }

    public void setTouchDelegateInfo(@androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat.TouchDelegateInfoCompat touchDelegateInfoCompat) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTouchDelegateInfo(touchDelegateInfoCompat.mInfo);
        }
    }

    public void setTraversalAfter(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            this.mInfo.setTraversalAfter(view);
        }
    }

    public void setTraversalAfter(android.view.View view, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            this.mInfo.setTraversalAfter(view, i);
        }
    }

    public void setTraversalBefore(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            this.mInfo.setTraversalBefore(view);
        }
    }

    public void setTraversalBefore(android.view.View view, int i) {
        if (android.os.Build.VERSION.SDK_INT >= 22) {
            this.mInfo.setTraversalBefore(view, i);
        }
    }

    public void setViewIdResourceName(java.lang.String str) {
        this.mInfo.setViewIdResourceName(str);
    }

    public void setVisibleToUser(boolean z) {
        this.mInfo.setVisibleToUser(z);
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(super.toString());
        android.graphics.Rect rect = new android.graphics.Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(getPackageName());
        sb.append("; className: ");
        sb.append(getClassName());
        sb.append("; text: ");
        sb.append(getText());
        sb.append("; contentDescription: ");
        sb.append(getContentDescription());
        sb.append("; viewId: ");
        sb.append(getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(isCheckable());
        sb.append("; checked: ");
        sb.append(isChecked());
        sb.append("; focusable: ");
        sb.append(isFocusable());
        sb.append("; focused: ");
        sb.append(isFocused());
        sb.append("; selected: ");
        sb.append(isSelected());
        sb.append("; clickable: ");
        sb.append(isClickable());
        sb.append("; longClickable: ");
        sb.append(isLongClickable());
        sb.append("; enabled: ");
        sb.append(isEnabled());
        sb.append("; password: ");
        sb.append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; [");
        java.util.List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList();
        for (int i = 0; i < actionList.size(); i++) {
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = actionList.get(i);
            java.lang.String actionSymbolicName = getActionSymbolicName(accessibilityActionCompat.getId());
            if (actionSymbolicName.equals("ACTION_UNKNOWN") && accessibilityActionCompat.getLabel() != null) {
                actionSymbolicName = accessibilityActionCompat.getLabel().toString();
            }
            sb.append(actionSymbolicName);
            if (i != actionList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public android.view.accessibility.AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }
}
