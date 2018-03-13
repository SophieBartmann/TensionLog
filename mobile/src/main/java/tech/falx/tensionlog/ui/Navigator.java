package tech.falx.tensionlog.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import tech.falx.tensionlog.R;
import tech.falx.tensionlog.ui.activity.MainActivity;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class Navigator {
    private static Navigator instance;
    private MainActivity mainActivity;

    private Navigator(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public static boolean createInstance(MainActivity mainActivity) {
        if (Navigator.instance != null)
            return false;
        Navigator.instance = new Navigator(mainActivity);
        return true;
    }

    public static Navigator getInstance() {
        return Navigator.instance;
    }

    public void navigateTo(@NonNull Fragment fragment, boolean addToStack) {
        FragmentTransaction transaction =
                this.mainActivity.getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.fragment_container, fragment);
        if (addToStack)
            transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

}
