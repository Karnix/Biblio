package com.astuetz.cyber.teen.biblio;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.multidex.MultiDex;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.karnix.cyberteen.biblio.R;
import com.parse.Parse;
import com.parse.ParseInstallation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class Biblio extends Application
{
    static String userEmail, userName;
    static ArrayList<NavigationItem> nitems = new ArrayList<>();
    static ArrayList<NavigationItem> litems = new ArrayList<>();


    @Override
    public void onCreate()
    {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this).applicationId(getResources().getString(R.string.app_id)).clientKey(getResources().getString(R.string.client_key)).server("https://parseapi.back4app.com").build());

        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put("GCMSenderId", "644469506430");
        installation.saveInBackground();

        FacebookSdk.sdkInitialize(this);
        printHashkey();
        nitems.add(new NavigationItem(R.drawable.search, "Search"));
        nitems.add(new NavigationItem(R.drawable.recent,"Recent"));
        nitems.add(new NavigationItem(R.drawable.npost,"Post"));

        litems.add(new NavigationItem(R.drawable.myposts, "My Posts"));
        //litems.add(new NavigationItem(R.drawable.star,"My Bookmarks"));

    }

    public void printHashkey()
    {
        try
        {
            PackageInfo info = getPackageManager().getPackageInfo("com.karnix.cyberteen.biblio",
                    PackageManager.GET_SIGNATURES);
            for(Signature signature : info.signatures)
            {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(),Base64.DEFAULT));
            }
        }
        catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
    }
}
