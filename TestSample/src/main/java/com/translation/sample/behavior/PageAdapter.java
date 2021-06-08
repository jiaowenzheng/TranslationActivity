package com.translation.sample.behavior;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.translation.sample.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: TranslationActivity
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-06 15:24
 **/
public class PageAdapter extends FragmentStatePagerAdapter {

    private List<String> titleArray = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        titleArray.add("title1");
        titleArray.add("title2");
        titleArray.add("title3");
        fragmentList.add(new FlingBehaviorFragment());
        fragmentList.add(new FlingBehaviorFragment());
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titleArray.size();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleArray.get(position);
    }
}
