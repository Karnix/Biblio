package com.astuetz.cyber.teen.biblio;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.andexert.library.RippleView;
import com.karnix.cyberteen.biblio.R;

public class AboutActivity extends Activity
{
    TextView title,tc,sp;
    ImageView fb1,fb2,fb3;

    RippleView rippleLogin, rippleInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        title = (TextView) findViewById(R.id.tool_title);
        title.setTypeface(Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/TitleFont.otf"));

        fb1 = (ImageView) findViewById(R.id.fb1);
        fb2 = (ImageView)findViewById(R.id.fb2);
        fb3 = (ImageView) findViewById(R.id.fb3);

        tc = (TextView) findViewById(R.id.tc);
        sp = (TextView) findViewById(R.id.sp);

        fb1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/678829498")));
                }
                catch (Exception e)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.facebook.com/karnik28")));
                }
            }
        });

        fb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/1260756861")));
                }
                catch(Exception e)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.facebook.com/Shankar.Sridhar.95")));
                }
            }
        });

        fb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1643122802")));
                }
                catch(Exception e)
                {
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.facebook.com/tvphere")));
                }
            }
        });

        rippleLogin = (RippleView) findViewById(R.id.rippleUser);
        rippleInfo = (RippleView) findViewById(R.id.rippleInfo);

        rippleLogin.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener()
        {
            @Override
            public void onComplete(RippleView rippleView)
            {
                startActivity(new Intent(AboutActivity.this, AccountActivity.class));
            }
        });

        rippleInfo.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener()
        {
            @Override
            public void onComplete(RippleView rippleView)
            {

                startActivity(new Intent(AboutActivity.this, AboutActivity.class));
            }
        });

        tc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showTC();
            }
        });

        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                showSP();
            }
        });



    }
    void showTC()
    {
        new MaterialDialog.Builder(this)
                .title("Terms & Conditions")
                .content(R.string.tc)
                .positiveText("Dismiss")
                .show();
    }

    void showSP()
    {
        new MaterialDialog.Builder(this)
                .title("Safety Guidelines")
                .content(R.string.sp)
                .positiveText("Dismiss")
                .show();
    }
}