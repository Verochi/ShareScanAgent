package androidx.databinding.adapters;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class TableLayoutBindingAdapter {
    private static final int MAX_COLUMNS = 20;
    private static java.util.regex.Pattern sColumnPattern = java.util.regex.Pattern.compile("\\s*,\\s*");

    private static android.util.SparseBooleanArray parseColumns(java.lang.CharSequence charSequence) {
        android.util.SparseBooleanArray sparseBooleanArray = new android.util.SparseBooleanArray();
        if (charSequence == null) {
            return sparseBooleanArray;
        }
        for (java.lang.String str : sColumnPattern.split(charSequence)) {
            try {
                int parseInt = java.lang.Integer.parseInt(str);
                if (parseInt >= 0) {
                    sparseBooleanArray.put(parseInt, true);
                }
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return sparseBooleanArray;
    }

    @androidx.databinding.BindingAdapter({"android:collapseColumns"})
    public static void setCollapseColumns(android.widget.TableLayout tableLayout, java.lang.CharSequence charSequence) {
        android.util.SparseBooleanArray parseColumns = parseColumns(charSequence);
        for (int i = 0; i < 20; i++) {
            boolean z = parseColumns.get(i, false);
            if (z != tableLayout.isColumnCollapsed(i)) {
                tableLayout.setColumnCollapsed(i, z);
            }
        }
    }

    @androidx.databinding.BindingAdapter({"android:shrinkColumns"})
    public static void setShrinkColumns(android.widget.TableLayout tableLayout, java.lang.CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && charSequence.charAt(0) == '*') {
            tableLayout.setShrinkAllColumns(true);
            return;
        }
        tableLayout.setShrinkAllColumns(false);
        android.util.SparseBooleanArray parseColumns = parseColumns(charSequence);
        int size = parseColumns.size();
        for (int i = 0; i < size; i++) {
            int keyAt = parseColumns.keyAt(i);
            boolean valueAt = parseColumns.valueAt(i);
            if (valueAt) {
                tableLayout.setColumnShrinkable(keyAt, valueAt);
            }
        }
    }

    @androidx.databinding.BindingAdapter({"android:stretchColumns"})
    public static void setStretchColumns(android.widget.TableLayout tableLayout, java.lang.CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && charSequence.charAt(0) == '*') {
            tableLayout.setStretchAllColumns(true);
            return;
        }
        tableLayout.setStretchAllColumns(false);
        android.util.SparseBooleanArray parseColumns = parseColumns(charSequence);
        int size = parseColumns.size();
        for (int i = 0; i < size; i++) {
            int keyAt = parseColumns.keyAt(i);
            boolean valueAt = parseColumns.valueAt(i);
            if (valueAt) {
                tableLayout.setColumnStretchable(keyAt, valueAt);
            }
        }
    }
}
