package com.example.pick3lines;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewPage extends FragmentStateAdapter {

    public MyViewPage(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new January();
                case 1:
                return new January();
                case 2:
                return new January();
                case 3:
                return new January();
                case 4:
                return new January();
                case 5:
                return new January();
                case 6:
                return new January();
                case 7:
                return new January();
                case 8:
                return new January();
                case 9:
                return new January();
                case 10:
                return new January();
                case 11:
                return new January();
                case 12:
                return new January();
                case 13:
                return new January();
            default:
                return new January();
        }
    }

    @Override
    public int getItemCount() {
        return 14;
    }
}
