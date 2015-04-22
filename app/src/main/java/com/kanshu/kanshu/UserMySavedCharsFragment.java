package com.kanshu.kanshu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kanshu.kanshu.model.SavedChars;
import com.kanshu.kanshu.model.User;
import com.kanshu.kanshu.widget.SimpleDividerItemDecoration;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by alouanemed on 26-01-2015.
 */
public class UserMySavedCharsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static UserMySavedCharsFragment newInstance(int sectionNumber) {
        UserMySavedCharsFragment fragment = new UserMySavedCharsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_my_saved_chars, container, false);

        User loggedInUser = getActivity().getIntent().getExtras().getParcelable("user");
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        //add data to the list
        final List<SavedChars> savedCharsList = new ArrayList<SavedChars>();

        SavedChars s = new SavedChars();
        s.setWordID(1);
        s.save(loggedInUser.getSessionId());

        s = new SavedChars();
        s.setWordID(2);
        s.save(loggedInUser.getSessionId());

        mAdapter = new MySavedCharsAdapter(savedCharsList);
        mRecyclerView.setAdapter(mAdapter);

        ApiHandler.kanshuApi.getWords(loggedInUser.getSessionId(), new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject, Response response) {
                Iterator<JsonElement> allWords = jsonObject.get("words").getAsJsonArray().iterator();
                while(allWords.hasNext()){
                    SavedChars savedCharElem = new SavedChars();
                    JsonElement elem = allWords.next();
                    savedCharElem.setWordID(elem.getAsJsonObject().get("id").getAsInt());
                    savedCharElem.setChar(elem.getAsJsonObject().get("simplified").getAsString());
                    String description = "";
                    for(int i = 0; i < elem.getAsJsonObject().get("definitions").getAsJsonArray().size(); i++)
                    {
                        description += elem.getAsJsonObject().get("definitions").getAsJsonArray().get(i).getAsString() + ";";
                    }
                    savedCharElem.setChardescription(description);
                    savedCharElem.setTranslation(elem.getAsJsonObject().get("translatedto").getAsString());
                    savedCharsList.add(savedCharElem);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("UserMySavedCharsFragment", "failed to load words");
            }
        });

        return rootView;
    }

}