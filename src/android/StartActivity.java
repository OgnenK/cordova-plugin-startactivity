package cordova-plugin-startActivity;



import org.apache.cordova.CordovaPlugin;


import org.apache.cordova.CallbackContext;

import org.apache.cordova.PluginResult;


import org.json.JSONArray;

import org.json.JSONException;

import org.json.JSONObject;



import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;
import java.util;
import android.os.Build;
import android;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;

/**
 * This class echoes a string called from JavaScript.
 */



public class StartActivity extends CordovaPlugin {


private CallbackContext callbackContext;
private JSONArray args;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

	
	this.callbackContext = callbackContext;
	this.args = args;
 

        if (action.equals("launchApp")) {


            String appName = args.getString(0);


            this.openIntent(true);


            return true;


        }

        return false;



    }





    public void openIntent(boolean noChooser) {

	cordova.getThreadPool().execute(new Runnable() {
			@Override
			public void run() {
			  try {
				launchMethod(noChooser);				}
				callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
			  } catch (JSONException ex) {
				callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
			  }
			

		    	}

	});
	return true;
    }


@SuppressLint("NewApi")
  public void launchMethod(boolean noChooser) {
	if(noChooser){



		Intent sendIntent = new Intent(Intent.ACTION_VIEW);         
		sendIntent.setData(Uri.parse("sms:"));
		sendIntent.putExtra("sms_body", x);
		this.cordova.getActivity().startActivity(sendIntent);
	} else {

		Intent j = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));
		j.putExtra("name", "NO -> appName");

		//j.setType("text/plain");

		j.setType("text/http");

		this.cordova.getActivity().startActivity(Intent.createChooser(j, "Open With"));

	}	
  }

}





/*Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));
		i.putExtra("name", "NO -> appName");

		i.setType("text/plain");

		startActivity(Intent.createChooser(i, "Open With"));

*/
/*


public class StartActivity extends CordovaPlugin {


@Override
    
public boolean execute(String action, JSONArray args, 
CallbackContext callbackContext) throws JSONException {

	String appName = args.getString(0);
	if (action.equals("launchApp")) {

            this.launchApp(appName, callbackContext);


            return true;
	}else if (action.equals("launchSpecificApp")) {

            this.launchSpecificApp(appName, callbackContext);


            return true;
	}else if (action.equals("launchForResults")) {

            this.launchForResults(appName, callbackContext);


            return true;
	}else if (action.equals("recieveResults")) {

            this.recieveResults(appName, callbackContext);


            return true;
	}else return false;
}}
*/