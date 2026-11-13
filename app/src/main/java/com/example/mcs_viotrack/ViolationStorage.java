package com.example.mcs_viotrack;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONObject;

public class ViolationStorage extends Activity {

    static final String PREF_NAME = "ViolationData";
    private static final String KEY_VIOLATIONS = "violations";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewviolationhistory_fetchviolationrecords_completeviolationhistoryshown);
    }

    // Save a new violation
    public static boolean saveViolation(
            Context context,
            String name,
            String category,
            String penalty) {

        try {
            SharedPreferences prefs = context.getSharedPreferences(
                    PREF_NAME,
                    Context.MODE_PRIVATE
            );

            String oldData = prefs.getString(KEY_VIOLATIONS, "[]");
            JSONArray records = new JSONArray(oldData);

            JSONObject violation = new JSONObject();
            violation.put("name", name);
            violation.put("category", category);
            violation.put("penalty", penalty);

            records.put(violation);

            prefs.edit()
                    .putString(KEY_VIOLATIONS, records.toString())
                    .apply();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ NEW: Read all saved violations
    public static String getViolations(Context context) {
        try {
            SharedPreferences prefs = context.getSharedPreferences(
                    PREF_NAME,
                    Context.MODE_PRIVATE
            );
            return prefs.getString(KEY_VIOLATIONS, "[]");
        } catch (Exception e) {
            e.printStackTrace();
            return "[]";
        }
    }
}
