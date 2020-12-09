package com.example.zahfit_trainer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zahfit_trainer.pages.MainFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabFragment newInstance(String param1, String param2) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



//    ===============================================
    TabLayout tabLayout;
    ViewPager viewPager;

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> tab) {
//        initialize main adapter
        MainAdapter adapter = new MainAdapter(getFragmentManager());
//        Initialize the fragment
        ListTrainingProgramFragment training = new ListTrainingProgramFragment();
//        for (int i = 0; i < tab.size(); i++) {
////            initialize bundle
//            Bundle bundle = new Bundle();
////            put string
//            bundle.putString("title", tab.get(i));
////            set arguments
//            fragment.setArguments(bundle);
////            add fragment
//            adapter.addFragment(fragment, tab.get(i));
////            define new fragment
//            fragment = new MainFragment();
//        }
        PageMealPlan mealPlan = new PageMealPlan();
        PageTrainingProgram train = new PageTrainingProgram();
        adapter.addFragment(training,tab.get(0));
        adapter.addFragment(mealPlan,tab.get(1));
        adapter.addFragment(train,tab.get(2));
        adapter.addFragment(training,tab.get(3));
//        set adapter
        viewPager.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

//        assign variable
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

//        initialize Array list
        ArrayList<String> tab = new ArrayList<>();
        tab.add("Program");
        tab.add("Meal Plan");
        tab.add("Progress");
        tab.add("Chat");

//        prepare view pager
        prepareViewPager(viewPager, tab);

//        setup with view pager
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(141414);
        tabLayout.setMinimumHeight(90);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_assignment_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_fastfood_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_timeline_24);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_baseline_chat_24);

        return view;
    }

    private class MainAdapter extends FragmentPagerAdapter {
        //        Initializing arryalist
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Fragment> fragmentList = new ArrayList<>();

        //        create constructor
        public void addFragment(Fragment fragment, String title){
//            add array title
            arrayList.add(title);
//            add fragment
            fragmentList.add(fragment);
        }

        public MainAdapter(@NonNull FragmentManager p0) {
            super(p0);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
//            return fragment position
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
//            return fragmentList size
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
//            return array list position
            return arrayList.get(position);
        }
    }
}