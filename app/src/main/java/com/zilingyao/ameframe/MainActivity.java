package com.zilingyao.ameframe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.zilingyao.ameframe.fragment.HomeFragment;
import com.zilingyao.ameframe.fragment.ThreeFragment;
import com.zilingyao.ameframe.fragment.TwoFragment;
import com.zilingyao.uimodule.WidgetFragment;
import com.zilingyao.uimodule.widget.bottomnavigation.BadgeItem;
import com.zilingyao.uimodule.widget.bottomnavigation.BottomNavigationBar;
import com.zilingyao.uimodule.widget.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{


    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.main_container)
    FrameLayout mMainContainer;
    private FragmentManager mFragmentManager;

    private HomeFragment mHomeFragment;
    private TwoFragment mTwoFragment;
    private ThreeFragment mThreeFragment;
    private WidgetFragment mWidgetFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        initView();
    }

    private void initView() {
        mHomeFragment = (HomeFragment) mFragmentManager.findFragmentByTag("home_fg");
        mTwoFragment = (TwoFragment) mFragmentManager.findFragmentByTag("two_fg");
        mThreeFragment = (ThreeFragment) mFragmentManager.findFragmentByTag("three_fg");
        mWidgetFragment = (WidgetFragment) mFragmentManager.findFragmentByTag("four_fg");

        if(mHomeFragment == null){
            mHomeFragment = HomeFragment.newInstance();
            addFragment(R.id.main_container, mHomeFragment, "home_fg");
        }
        if(mTwoFragment == null){
            mTwoFragment = TwoFragment.newInstance();
            addFragment(R.id.main_container, mTwoFragment, "two_fg");
        }

        if(mThreeFragment == null){
            mThreeFragment = ThreeFragment.newInstance();
            addFragment(R.id.main_container, mThreeFragment, "three_fg");
        }
        if(mWidgetFragment == null){
            mWidgetFragment = WidgetFragment.newInstance();
            addFragment(R.id.main_container, mWidgetFragment, "four_fg");
        }
        mFragmentManager.beginTransaction()
                .show(mHomeFragment)
                .hide(mTwoFragment)
                .hide(mThreeFragment)
                .hide(mWidgetFragment)
                .commitAllowingStateLoss();

        initBottomNavigation();
    }

    protected void addFragment(int containerViewId, Fragment fragment , String tag) {
        final FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(containerViewId, fragment , tag);
        fragmentTransaction.commit();
    }

    private void initBottomNavigation() {
        BadgeItem numberBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.colorAccent)
                .setText("99+")
                .setHideOnSelect(false);

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        //bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        //bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        //bottomNavigationBar.setAutoHideEnabled(true);

        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.axh, "").setInactiveIconResource(R.drawable.axg).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.axd, "").setInactiveIconResource(R.drawable.axc).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.axf, "").setInactiveIconResource(R.drawable.axe).setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.axb, "").setInactiveIconResource(R.drawable.axa).setActiveColorResource(R.color.colorAccent).setBadgeItem(numberBadgeItem))
//                .addItem(new BottomNavigationItem(R.drawable.axj, "").setInactiveIconResource(R.drawable.axi).setActiveColorResource(R.color.colorAccent))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
    }


    @Override
    public void onTabSelected(int position) {
        if(position == 0){
            mFragmentManager
                    .beginTransaction()
                    .hide(mTwoFragment)
                    .hide(mThreeFragment)
                    .hide(mWidgetFragment)
                    .show(mHomeFragment)
                    .commitAllowingStateLoss();
        }else if(position == 1){
            mFragmentManager
                    .beginTransaction()
                    .hide(mHomeFragment)
                    .hide(mThreeFragment)
                    .hide(mWidgetFragment)
                    .show(mTwoFragment)
                    .commitAllowingStateLoss();
        }else if(position == 2){
            mFragmentManager.beginTransaction()
                    .hide(mHomeFragment)
                    .hide(mTwoFragment)
                    .hide(mWidgetFragment)
                    .show(mThreeFragment)
                    .commitAllowingStateLoss();
        }else if(position == 3){
            mFragmentManager.beginTransaction()
                    .hide(mHomeFragment)
                    .hide(mTwoFragment)
                    .hide(mThreeFragment)
                    .show(mWidgetFragment)
                    .commitAllowingStateLoss();
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
