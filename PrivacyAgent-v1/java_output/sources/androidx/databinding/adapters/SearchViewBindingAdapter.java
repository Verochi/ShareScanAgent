package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:onQueryTextFocusChange", method = "setOnQueryTextFocusChangeListener", type = android.widget.SearchView.class), @androidx.databinding.BindingMethod(attribute = "android:onSearchClick", method = "setOnSearchClickListener", type = android.widget.SearchView.class), @androidx.databinding.BindingMethod(attribute = "android:onClose", method = "setOnCloseListener", type = android.widget.SearchView.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class SearchViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.SearchViewBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.SearchView.OnQueryTextListener {
        final /* synthetic */ androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextChange val$change;
        final /* synthetic */ androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit val$submit;

        public AnonymousClass1(androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit onQueryTextSubmit, androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextChange onQueryTextChange) {
            this.val$submit = onQueryTextSubmit;
            this.val$change = onQueryTextChange;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(java.lang.String str) {
            androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextChange onQueryTextChange = this.val$change;
            if (onQueryTextChange != null) {
                return onQueryTextChange.onQueryTextChange(str);
            }
            return false;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(java.lang.String str) {
            androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit onQueryTextSubmit = this.val$submit;
            if (onQueryTextSubmit != null) {
                return onQueryTextSubmit.onQueryTextSubmit(str);
            }
            return false;
        }
    }

    /* renamed from: androidx.databinding.adapters.SearchViewBindingAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements android.widget.SearchView.OnSuggestionListener {
        final /* synthetic */ androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionClick val$change;
        final /* synthetic */ androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionSelect val$submit;

        public AnonymousClass2(androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionSelect onSuggestionSelect, androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionClick onSuggestionClick) {
            this.val$submit = onSuggestionSelect;
            this.val$change = onSuggestionClick;
        }

        @Override // android.widget.SearchView.OnSuggestionListener
        public boolean onSuggestionClick(int i) {
            androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionClick onSuggestionClick = this.val$change;
            if (onSuggestionClick != null) {
                return onSuggestionClick.onSuggestionClick(i);
            }
            return false;
        }

        @Override // android.widget.SearchView.OnSuggestionListener
        public boolean onSuggestionSelect(int i) {
            androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionSelect onSuggestionSelect = this.val$submit;
            if (onSuggestionSelect != null) {
                return onSuggestionSelect.onSuggestionSelect(i);
            }
            return false;
        }
    }

    @android.annotation.TargetApi(11)
    public interface OnQueryTextChange {
        boolean onQueryTextChange(java.lang.String str);
    }

    @android.annotation.TargetApi(11)
    public interface OnQueryTextSubmit {
        boolean onQueryTextSubmit(java.lang.String str);
    }

    @android.annotation.TargetApi(11)
    public interface OnSuggestionClick {
        boolean onSuggestionClick(int i);
    }

    @android.annotation.TargetApi(11)
    public interface OnSuggestionSelect {
        boolean onSuggestionSelect(int i);
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onQueryTextSubmit", "android:onQueryTextChange"})
    public static void setOnQueryTextListener(android.widget.SearchView searchView, androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit onQueryTextSubmit, androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextChange onQueryTextChange) {
        if (onQueryTextSubmit == null && onQueryTextChange == null) {
            searchView.setOnQueryTextListener(null);
        } else {
            searchView.setOnQueryTextListener(new androidx.databinding.adapters.SearchViewBindingAdapter.AnonymousClass1(onQueryTextSubmit, onQueryTextChange));
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onSuggestionSelect", "android:onSuggestionClick"})
    public static void setOnSuggestListener(android.widget.SearchView searchView, androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionSelect onSuggestionSelect, androidx.databinding.adapters.SearchViewBindingAdapter.OnSuggestionClick onSuggestionClick) {
        if (onSuggestionSelect == null && onSuggestionClick == null) {
            searchView.setOnSuggestionListener(null);
        } else {
            searchView.setOnSuggestionListener(new androidx.databinding.adapters.SearchViewBindingAdapter.AnonymousClass2(onSuggestionSelect, onSuggestionClick));
        }
    }
}
