package tech.falx.tensionlog.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;

import butterknife.ButterKnife;
import tech.falx.tensionlog.App;
import tech.falx.tensionlog.R;
import tech.falx.tensionlog.ui.binding.CalendarOverviewBinding;
import tech.falx.tensionlog.ui.binding.DayListBinding;
import tech.falx.tensionlog.ui.viewmodel.EntryListVM;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class CalendarOverviewFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        CalendarOverviewBinding binding = DataBindingUtil.inflate(inflater,
                                                                  R.layout.fragment_calendar_overview,
                                                                  container,
                                                                  false);
        View view = binding.getRoot();
//        binding.setVm(new EntryListVM(new Date(),
//                                      ((App) getActivity().getApplication()).getDaoSession()));
        ButterKnife.bind(this, view);
        return view;
    }
}
