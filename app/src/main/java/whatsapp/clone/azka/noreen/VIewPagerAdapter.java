package whatsapp.clone.azka.noreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VIewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentArrayList;
    ArrayList<String> Title;
    public VIewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragmentArrayList=new ArrayList<>();
        Title=new ArrayList<>();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment,String title){
        fragmentArrayList.add(fragment);
        Title.add(title);
    }

    //for tab
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);
        return Title.get(position);

    }

}
