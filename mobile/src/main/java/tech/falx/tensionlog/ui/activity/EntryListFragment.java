/*
 * Copyright (c) 2018. Kristoffer Schneider Licensed under the Apache-2.0 License.
 */

package tech.falx.tensionlog.ui.activity;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.greendao.query.QueryBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.falx.tensionlog.App;
import tech.falx.tensionlog.R;
import tech.falx.tensionlog.db.entity.TensionEntryEntity;
import tech.falx.tensionlog.db.entity.TensionEntryEntityDao;
import tech.falx.tensionlog.ui.Navigator;
import tech.falx.tensionlog.ui.binding.DayListBinding;
import tech.falx.tensionlog.ui.fragment.EntryDetailFragment;
import tech.falx.tensionlog.ui.viewmodel.EntryListVM;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link EntryDetailFragment} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class EntryListFragment extends Fragment {

    /***
     * Bundle argument to hold the day which entries should be listed in this view
     */
    public static final String ARG_DAY_TO_LIST = "ARG_DAY_TO_LIST";

    @BindView(R.id.item_list)
    protected View recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        DayListBinding binding = DataBindingUtil.inflate(inflater,
                                                         R.layout.fragment_item_list,
                                                         container,
                                                         false);
        View view = binding.getRoot();
        binding.setVm(new EntryListVM(new Date(),
                                      ((App) getActivity().getApplication()).getDaoSession()));
        ButterKnife.bind(this, view);
        setupRecyclerView((RecyclerView) recyclerView);
        return view;
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        Date dayToListLower = (Date)this.getArguments().get(ARG_DAY_TO_LIST);
        Calendar cal = Calendar.getInstance();
//       cal.set(dayToListLower.);
//        TensionEntryEntityDao tensionEntryEntityDao = ((App) this.getActivity().getApplication())
//                .getDaoSession()
//                .getTensionEntryEntityDao();
//        QueryBuilder<TensionEntryEntity> queryBuilder = tensionEntryEntityDao.queryBuilder()
//                .where(TensionEntryEntityDao.Properties.Date)
        List<TensionEntryEntity> list = new ArrayList<>();
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this,
                                                                  list
        ));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<TensionEntryEntity> mValues;
        private final View.OnClickListener mOnClickListener = view -> {
            TensionEntryEntity item = (TensionEntryEntity) view.getTag();
            Bundle bundle = new Bundle();
            bundle.putLong(EntryDetailFragment.ARG_ENTRY_ID, item.getId());
            EntryDetailFragment entryDetailFragment = new EntryDetailFragment();
            entryDetailFragment.setArguments(bundle);
            Navigator navigator = Navigator.getInstance();
            navigator.navigateTo(entryDetailFragment, true);
        };

        SimpleItemRecyclerViewAdapter(EntryListFragment parent,
                                      List<TensionEntryEntity> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                                      .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.itemLayout.setBackgroundColor(0x00ff40);
            DateFormat format = SimpleDateFormat.getTimeInstance();
            holder.mIdView.setText(format.format(mValues.get(position).getDate()));
            holder.mContentView.setText(mValues.get(position).getTension().toString());

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;
            final LinearLayout itemLayout;

            ViewHolder(View view) {
                super(view);
                mIdView = view.findViewById(R.id.id_text);
                mContentView = view.findViewById(R.id.content);
                itemLayout = view.findViewById(R.id.list_item_layout);
            }
        }
    }
}
