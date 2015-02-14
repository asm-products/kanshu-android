package com.kanshu.kanshu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanshu.kanshu.model.Addon;
import com.kanshu.kanshu.widget.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alouanemed on 26-01-2015.
 */
public class UserAddOnsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static UserAddOnsFragment newInstance(int sectionNumber) {
        UserAddOnsFragment fragment = new UserAddOnsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_add_ons, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        //This is the code to provide a sectioned list
        List<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<SimpleSectionedRecyclerViewAdapter.Section>();

        //add data to the list
        List<Addon> addonsList = new ArrayList<>();
        addonsList.add(new Addon());
        addonsList.add(new Addon());
        addonsList.add(new Addon());
        addonsList.add(new Addon());
        addonsList.add(new Addon());
        addonsList.add(new Addon());
        addonsList.add(new Addon());
        addonsList.add(new Addon());
        addonsList.add(new Addon());

        //Sections
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0,"Newspaper And Magazines"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(3,"Memorization Exercises"));


        mAdapter = new AddonsAdapter(addonsList);
        //Add your adapter to the sectionAdapter
        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new
                SimpleSectionedRecyclerViewAdapter(getActivity(),R.layout.row_section,R.id.section_text,mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        recyclerView.setAdapter(mSectionedAdapter);



        return rootView;
    }

}
