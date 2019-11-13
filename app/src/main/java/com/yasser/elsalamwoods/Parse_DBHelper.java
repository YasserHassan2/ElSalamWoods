package com.yasser.elsalamwoods;

import android.content.Context;

import com.parse.Parse;

public class Parse_DBHelper {

    Context context;

    public Parse_DBHelper(Context context) {
        this.context = context;
    }


    public void connectToDB(Context context) {

        //# database connection
        Parse.initialize(new Parse.Configuration.Builder(context)
                .applicationId("Ay04kZlMdPUIqG1cApGChhMDKUS96lAd01qQHpoG")
                .clientKey("PLvSQGa0GHOtroT8FAbEbaCYwHs7psxyu0TJp7Eh")
                .server("https://parseapi.back4app.com")
                .build()
        );

    }
}
