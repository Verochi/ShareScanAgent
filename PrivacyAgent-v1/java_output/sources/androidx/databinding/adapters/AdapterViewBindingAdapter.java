package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:onItemClick", method = "setOnItemClickListener", type = android.widget.AdapterView.class), @androidx.databinding.BindingMethod(attribute = "android:onItemLongClick", method = "setOnItemLongClickListener", type = android.widget.AdapterView.class)})
@androidx.databinding.InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute = "android:selectedItemPosition", type = android.widget.AdapterView.class), @androidx.databinding.InverseBindingMethod(attribute = "android:selection", event = "android:selectedItemPositionAttrChanged", method = "getSelectedItemPosition", type = android.widget.AdapterView.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AdapterViewBindingAdapter {

    public interface OnItemSelected {
        void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j);
    }

    public static class OnItemSelectedComponentListener implements android.widget.AdapterView.OnItemSelectedListener {
        private final androidx.databinding.InverseBindingListener mAttrChanged;
        private final androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected mNothingSelected;
        private final androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected mSelected;

        public OnItemSelectedComponentListener(androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected onItemSelected, androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected onNothingSelected, androidx.databinding.InverseBindingListener inverseBindingListener) {
            this.mSelected = onItemSelected;
            this.mNothingSelected = onNothingSelected;
            this.mAttrChanged = inverseBindingListener;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected onItemSelected = this.mSelected;
            if (onItemSelected != null) {
                onItemSelected.onItemSelected(adapterView, view, i, j);
            }
            androidx.databinding.InverseBindingListener inverseBindingListener = this.mAttrChanged;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(android.widget.AdapterView<?> adapterView) {
            androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected onNothingSelected = this.mNothingSelected;
            if (onNothingSelected != null) {
                onNothingSelected.onNothingSelected(adapterView);
            }
            androidx.databinding.InverseBindingListener inverseBindingListener = this.mAttrChanged;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
        }
    }

    public interface OnNothingSelected {
        void onNothingSelected(android.widget.AdapterView<?> adapterView);
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onItemSelected", "android:onNothingSelected", "android:selectedItemPositionAttrChanged"})
    public static void setOnItemSelectedListener(android.widget.AdapterView adapterView, androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected onItemSelected, androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected onNothingSelected, androidx.databinding.InverseBindingListener inverseBindingListener) {
        if (onItemSelected == null && onNothingSelected == null && inverseBindingListener == null) {
            adapterView.setOnItemSelectedListener(null);
        } else {
            adapterView.setOnItemSelectedListener(new androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelectedComponentListener(onItemSelected, onNothingSelected, inverseBindingListener));
        }
    }

    @androidx.databinding.BindingAdapter({"android:selectedItemPosition"})
    public static void setSelectedItemPosition(android.widget.AdapterView adapterView, int i) {
        if (adapterView.getSelectedItemPosition() != i) {
            adapterView.setSelection(i);
        }
    }

    @androidx.databinding.BindingAdapter({"android:selectedItemPosition", "android:adapter"})
    public static void setSelectedItemPosition(android.widget.AdapterView adapterView, int i, android.widget.Adapter adapter) {
        if (adapter != adapterView.getAdapter()) {
            adapterView.setAdapter(adapter);
            adapterView.setSelection(i);
        } else if (adapterView.getSelectedItemPosition() != i) {
            adapterView.setSelection(i);
        }
    }

    @androidx.databinding.BindingAdapter({"android:selection"})
    public static void setSelection(android.widget.AdapterView adapterView, int i) {
        setSelectedItemPosition(adapterView, i);
    }

    @androidx.databinding.BindingAdapter({"android:selection", "android:adapter"})
    public static void setSelection(android.widget.AdapterView adapterView, int i, android.widget.Adapter adapter) {
        setSelectedItemPosition(adapterView, i, adapter);
    }
}
