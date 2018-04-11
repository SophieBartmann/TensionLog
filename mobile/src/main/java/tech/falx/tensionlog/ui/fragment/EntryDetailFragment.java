/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import tech.falx.tensionlog.App;
import tech.falx.tensionlog.R;
import tech.falx.tensionlog.db.entity.TensionEntryEntity;
import tech.falx.tensionlog.ui.activity.EntryListFragment;
import tech.falx.tensionlog.ui.binding.ItemDetailBinding;
import tech.falx.tensionlog.ui.viewmodel.TensionEntryVM;

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link EntryListFragment}.
 */
public class EntryDetailFragment extends Fragment {

    public static final String ARG_ENTRY_ID = "ARG_ENTRY_ID";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ItemDetailBinding binding = DataBindingUtil.inflate(inflater,
                                                            R.layout.fragment_entry_detail,
                                                            container,
                                                            false);
        TensionEntryVM tvm = new TensionEntryVM(new TensionEntryEntity(),
                                                ((App) getActivity().getApplication()).getDaoSession());
        binding.setVm(tvm);
        View view = binding.getRoot();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {

        }
    }


}
