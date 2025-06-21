package androidx.databinding.adapters;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AbsSpinnerBindingAdapter {
    @androidx.databinding.BindingAdapter({"android:entries"})
    public static <T> void setEntries(android.widget.AbsSpinner absSpinner, java.util.List<T> list) {
        if (list == null) {
            absSpinner.setAdapter((android.widget.SpinnerAdapter) null);
            return;
        }
        android.widget.SpinnerAdapter adapter = absSpinner.getAdapter();
        if (adapter instanceof androidx.databinding.adapters.ObservableListAdapter) {
            ((androidx.databinding.adapters.ObservableListAdapter) adapter).setList(list);
        } else {
            absSpinner.setAdapter((android.widget.SpinnerAdapter) new androidx.databinding.adapters.ObservableListAdapter(absSpinner.getContext(), list, android.R.layout.simple_spinner_item, android.R.layout.simple_spinner_dropdown_item, 0));
        }
    }

    @androidx.databinding.BindingAdapter({"android:entries"})
    public static <T extends java.lang.CharSequence> void setEntries(android.widget.AbsSpinner absSpinner, T[] tArr) {
        if (tArr == null) {
            absSpinner.setAdapter((android.widget.SpinnerAdapter) null);
            return;
        }
        android.widget.SpinnerAdapter adapter = absSpinner.getAdapter();
        boolean z = true;
        if (adapter != null && adapter.getCount() == tArr.length) {
            int i = 0;
            while (true) {
                if (i >= tArr.length) {
                    z = false;
                    break;
                } else if (!tArr[i].equals(adapter.getItem(i))) {
                    break;
                } else {
                    i++;
                }
            }
        }
        if (z) {
            android.widget.ArrayAdapter arrayAdapter = new android.widget.ArrayAdapter(absSpinner.getContext(), android.R.layout.simple_spinner_item, tArr);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            absSpinner.setAdapter((android.widget.SpinnerAdapter) arrayAdapter);
        }
    }
}
