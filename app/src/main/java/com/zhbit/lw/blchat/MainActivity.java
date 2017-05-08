package com.zhbit.lw.blchat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zhbit.lw.fragment.ChatFragment;
import com.zhbit.lw.fragment.ContactFragment;
import com.zhbit.lw.fragment.FoundFragment;
import com.zhbit.lw.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener{

    // 定义组件
    private ViewPager viewPager;
    private ChatFragment chatFragment;
    private ContactFragment contactFragment;
    private FoundFragment foundFragment;
    private MeFragment meFragment;
    private List<Fragment> fragmentList;    //　用于存放fragment的列表
    private FragmentPagerAdapter fragmentPagerAdapter;  //fragment页面的适配器

    // 顶部Toolbar
    private Toolbar toolbar;

    // 界面底部四个Tab
    private ChangeColorIconWithText chatTabIndicator, contactTabIndicator, foundTabIndicator, meTabIndicator;
    private List<ChangeColorIconWithText> mTabIndicators = new ArrayList<ChangeColorIconWithText>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();     // 初始化组件视图
        initDatas();    // 初始化数据

        viewPager.setAdapter(fragmentPagerAdapter);     // 设置viewpager的适配器
        initEvent();   // 初始化事件

    }

    // actionbar的菜单按钮
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    // 初始化组件试图
    private void initView() {
        // 实例化组件视图
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        chatFragment = new ChatFragment();
        contactFragment = new ContactFragment();
        foundFragment = new FoundFragment();
        meFragment = new MeFragment();

        // 实例化顶部ToolBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("BLChat");     //　设置Toolbar的标题
        toolbar.setTitleTextColor(Color.WHITE);     // 设置Toolbar的标题字体颜色
        toolbar.inflateMenu(R.menu.toolbar_menu);

        // 实例化底部四个Tab
        chatTabIndicator = (ChangeColorIconWithText) findViewById(R.id.indicator_chat);
        contactTabIndicator = (ChangeColorIconWithText) findViewById(R.id.indicator_contact);
        foundTabIndicator = (ChangeColorIconWithText) findViewById(R.id.indicator_found);
        meTabIndicator = (ChangeColorIconWithText) findViewById(R.id.indicator_me);
        mTabIndicators.add(chatTabIndicator);
        mTabIndicators.add(contactTabIndicator);
        mTabIndicators.add(foundTabIndicator);
        mTabIndicators.add(meTabIndicator);

        chatTabIndicator.setIconAlpha(1.0f);     // 默认第一个有颜色

    }

    // 初始化数据
    private void initDatas() {
        // 测试数据
        fragmentList = new ArrayList<Fragment>();

        // 添加四个Fragment到列表当中
        fragmentList.add(chatFragment);
        fragmentList.add(contactFragment);
        fragmentList.add(foundFragment);
        fragmentList.add(meFragment);

        // 初始化fragmentPagerAdapter
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
    }

    // 初始化所有事件
    private void initEvent() {
        // viewpager的页面变化监听事件
        viewPager.addOnPageChangeListener(this);

        // 顶部Toolbar的菜单监听事件
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()){
//                    case  R.id.menu_group_chat:
//                        Toast.makeText(MainActivity.this, "Group Chat", Toast.LENGTH_SHORT).show();
//                        break;
//                    case  R.id.menu_add_friend:
//                        Toast.makeText(MainActivity.this, "Add Friend", Toast.LENGTH_SHORT).show();
//                        break;
//                    case  R.id.menu_scan:
//                        Toast.makeText(MainActivity.this, "Scan", Toast.LENGTH_SHORT).show();
//                        break;
//                    case  R.id.menu_feedback:
//                        Toast.makeText(MainActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return true;
//            }
//        });

        // 底部Tab的监听事件
        chatTabIndicator.setOnClickListener(this);
        contactTabIndicator.setOnClickListener(this);
        foundTabIndicator.setOnClickListener(this);
        meTabIndicator.setOnClickListener(this);

    }

    // viewpager的滚动监听事件
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0) {
            ChangeColorIconWithText left = mTabIndicators.get(position);
            ChangeColorIconWithText right = mTabIndicators.get(position + 1);
            left.setIconAlpha(1 - positionOffset);
            right.setIconAlpha(positionOffset);
        }
    }

    // viewpager的页面选择监听事件
    @Override
    public void onPageSelected(int position) {}

    // viewpager的页面滑动状态监听事件
    @Override
    public void onPageScrollStateChanged(int state) {}

    // 事件监听事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.indicator_chat:
                resetAllTabsAlpha();
                mTabIndicators.get(0).setIconAlpha(1.0f);
                viewPager.setCurrentItem(0, false);
                break;
            case R.id.indicator_contact:
                resetAllTabsAlpha();
                mTabIndicators.get(1).setIconAlpha(1.0f);
                viewPager.setCurrentItem(1, false);
                break;
            case R.id.indicator_found:
                resetAllTabsAlpha();
                mTabIndicators.get(2).setIconAlpha(1.0f);
                viewPager.setCurrentItem(2, false);
                break;
            case R.id.indicator_me:
                resetAllTabsAlpha();
                mTabIndicators.get(3).setIconAlpha(1.0f);
                viewPager.setCurrentItem(3, false);
                break;
        }

    }

    // 将底部所有tab的图标透明度调成0
    private void resetAllTabsAlpha() {
        for (int i = 0;i < mTabIndicators.size();i++) {
            mTabIndicators.get(i).setIconAlpha(0);
        }

    }

}
