package androidx.appcompat.widget;

/* loaded from: classes.dex */
final class AppCompatTextClassifierHelper {

    @androidx.annotation.Nullable
    private android.view.textclassifier.TextClassifier mTextClassifier;

    @androidx.annotation.NonNull
    private android.widget.TextView mTextView;

    public AppCompatTextClassifierHelper(@androidx.annotation.NonNull android.widget.TextView textView) {
        this.mTextView = (android.widget.TextView) androidx.core.util.Preconditions.checkNotNull(textView);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(api = 26)
    public android.view.textclassifier.TextClassifier getTextClassifier() {
        java.lang.Object systemService;
        android.view.textclassifier.TextClassifier textClassifier;
        android.view.textclassifier.TextClassifier textClassifier2;
        android.view.textclassifier.TextClassifier textClassifier3 = this.mTextClassifier;
        if (textClassifier3 != null) {
            return textClassifier3;
        }
        systemService = this.mTextView.getContext().getSystemService((java.lang.Class<java.lang.Object>) android.view.textclassifier.TextClassificationManager.class);
        android.view.textclassifier.TextClassificationManager textClassificationManager = (android.view.textclassifier.TextClassificationManager) systemService;
        if (textClassificationManager != null) {
            textClassifier2 = textClassificationManager.getTextClassifier();
            return textClassifier2;
        }
        textClassifier = android.view.textclassifier.TextClassifier.NO_OP;
        return textClassifier;
    }

    @androidx.annotation.RequiresApi(api = 26)
    public void setTextClassifier(@androidx.annotation.Nullable android.view.textclassifier.TextClassifier textClassifier) {
        this.mTextClassifier = textClassifier;
    }
}
