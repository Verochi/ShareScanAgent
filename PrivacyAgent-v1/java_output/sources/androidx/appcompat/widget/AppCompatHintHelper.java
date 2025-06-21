package androidx.appcompat.widget;

/* loaded from: classes.dex */
class AppCompatHintHelper {
    private AppCompatHintHelper() {
    }

    public static android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.InputConnection inputConnection, android.view.inputmethod.EditorInfo editorInfo, android.view.View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            android.view.ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof android.view.View)) {
                    break;
                }
                if (parent instanceof androidx.appcompat.widget.WithHint) {
                    editorInfo.hintText = ((androidx.appcompat.widget.WithHint) parent).getHint();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }
}
