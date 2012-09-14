package rs.pedjaapps.DualCore;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;
import android.text.method.*;
import java.util.*;
import android.widget.*;

public class about extends Activity{


    	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.about);
	
  checkAnthrax();
		TextView	anthrax = (TextView) findViewById(R.id.textView5);
			if (anthrax != null) {
				anthrax.setMovementMethod(LinkMovementMethod.getInstance());
			}

			TextView	xda = (TextView) findViewById(R.id.textView6);
			if (xda != null) {
				xda.setMovementMethod(LinkMovementMethod.getInstance());
			}
			
			TextView	official = (TextView) findViewById(R.id.textView8);
			if (official != null) {
				official.setMovementMethod(LinkMovementMethod.getInstance());
			}
			

		/*	Random randomGenerator = new Random();
			
				int randomInt = randomGenerator.nextInt(16);
				
				
				int[] i =  {
					R.drawable.tux_droid,
					R.drawable.tux2, 
					R.drawable.tux_gandalf, 
					R.drawable.tux_goku,
					R.drawable.tux_harry,
					R.drawable.tux_homer,
					R.drawable.tux_king,
					R.drawable.tux_luke,
					R.drawable.tux_patrick,
					R.drawable.tux_pika,
					R.drawable.tux_predator,
					R.drawable.tux_ubuntu,
					R.drawable.tux_wader,
					R.drawable.tux_yoda,
					R.drawable.yoda_tux
				};*/
				ImageView tux = (ImageView)findViewById(R.id.tux);
			   tux.setImageResource(R.drawable.tux_gandalf);
			   try
				{
					PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
				String	version = pInfo.versionName;
				TextView versiontext = (TextView)findViewById(R.id.textView3);
				versiontext.setText("version: " + version);
				}
				catch (PackageManager.NameNotFoundException e)
				{}
				
				
}
				
	public void checkAnthrax(){
		String anthrax = null;
		try {
			File myFile = new File("/proc/version");
			FileInputStream fIn = new FileInputStream(myFile);
			BufferedReader myReader = new BufferedReader(
				new InputStreamReader(fIn));
			String aDataRow = "";
			String aBuffer = "";
			while ((aDataRow = myReader.readLine()) != null) {
				aBuffer += aDataRow + "\n";
			}
			anthrax = aBuffer;
			myReader.close();

		} catch (Exception e) {
			anthrax="notfound";
		}


		TextView anth = (TextView)findViewById(R.id.textView5);
		int intIndex = anthrax.indexOf("anthrax");
		if(intIndex == - 1){
			System.out.println("not found");

			anth.setVisibility(View.GONE);
		}else{
			System.out.println("Found anthrax at index "
							   + intIndex);
			anth.setVisibility(View.VISIBLE);

		}
	}
}