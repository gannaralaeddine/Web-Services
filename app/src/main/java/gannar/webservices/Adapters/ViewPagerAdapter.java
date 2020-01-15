package gannar.webservices.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import gannar.webservices.Fragments.addUser;
import gannar.webservices.Fragments.deleteUser;
import gannar.webservices.Fragments.getAllUsers;
import gannar.webservices.Fragments.getUser;
import gannar.webservices.Fragments.updateUser;

public class ViewPagerAdapter extends FragmentStatePagerAdapter
{
    private int numberOfTabs;
    public ViewPagerAdapter(FragmentManager fragmentManager, int numberOfTabs)
    {
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0: return new getAllUsers();
            case 1: return new getUser();
            case 2: return new deleteUser();
            case 3: return new addUser();
            case 4: return new updateUser();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
