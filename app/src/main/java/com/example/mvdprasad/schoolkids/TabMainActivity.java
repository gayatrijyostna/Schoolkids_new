package com.example.mvdprasad.schoolkids;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabMainActivity  extends Fragment {

    int position;
    private TextView textView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabMainActivity tabFragment = new TabMainActivity();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        position = getArguments().getInt("pos");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.tab, container, false);
        mViewPager = view.findViewById(R.id.products_viewPager);
        mTabLayout = view.findViewById(R.id.tabs);
        setUpViewPager();

        mViewPager.setOffscreenPageLimit(1);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabSelectedListener());
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        textView = (TextView) view.findViewById(R.id.textView);
//
//        textView.setText("Fragment " + (position + 1));

    }
    class TabSelectedListener implements TabLayout.OnTabSelectedListener {
        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            /*LinearLayout tabLayout = (LinearLayout)((ViewGroup) mTabLayout.getChildAt(0)).getChildAt(tab.getPosition());
            TextView tabTextView = (TextView) tabLayout.getChildAt(1);
            tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.NORMAL);*/
        }



        public void onTabSelected(TabLayout.Tab tab) {
            /*LinearLayout tabLayout = (LinearLayout)((ViewGroup) mTabLayout.getChildAt(0)).getChildAt(tab.getPosition());
            TextView tabTextView = (TextView) tabLayout.getChildAt(1);
            tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.BOLD);*/
            mViewPager.setCurrentItem(tab.getPosition());
        }
    }
    private void setUpViewPager() {

        Tabpageadapter adapter = new Tabpageadapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new Busposition_fragment(), "Student_image");
        adapter.addFrag(new Busposition_fragment(), "Profile");
        adapter.addFrag(new Busposition_fragment(), "Student_list");
        adapter.addFrag(new Busposition_fragment(), "Route_details");
        adapter.addFrag(new Busposition_fragment(), "Route_landmarks");
        adapter.addFrag(new Busposition_fragment(), "Bus_position");
        adapter.addFrag(new Busposition_fragment(), "Change password");
        adapter.addFrag(new Busposition_fragment(), "Sign Out");



        mViewPager.setAdapter(adapter);

        // viewPager.setOffscreenPageLimit(-1);
        adapter.notifyDataSetChanged();

    }
}
