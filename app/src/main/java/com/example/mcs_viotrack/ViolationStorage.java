
package com.example.mcs_viotrack;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONObject;

public class ViolationStorage {

    private static final String PREF_NAME = "ViolationData";
    private static final String KEY_VIOLATIONS = "violations";

    public static boolean saveViolation(
            Context context,
            String name,
            String category,
            String penalty) {

        try {
            SharedPreferences prefs =
                    context.getSharedPreferences(
                            PREF_NAME,
                            Context.MODE_PRIVATE
                    );

            String oldData =
                    prefs.getString(KEY_VIOLATIONS, "[]");

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

    public static String getViolations(Context context) {

        SharedPreferences prefs =
                context.getSharedPreferences(
                        PREF_NAME,
                        Context.MODE_PRIVATE
                );

        String data = prefs.getString(KEY_VIOLATIONS, "[]");

        StringBuilder result = new StringBuilder();

        try {
            JSONArray records = new JSONArray(data);

            if (records.length() == 0) {
                return "No saved violations yet.";
            }

            for (int i = 0; i < records.length(); i++) {

                JSONObject item = records.getJSONObject(i);

                result.append("VIOLATION ")
                        .append(i + 1)
                        .append("\n");

                result.append("Name: ")
                        .append(item.optString("name"))
                        .append("\n");

                result.append("Category: ")
                        .append(item.optString("category"))
                        .append("\n");

                result.append("Penalty: ")
                        .append(item.optString("penalty"))
                        .append("\n\n");
            }

        } catch (Exception e) {
            return "Unable to load violation records.";
        }

        return result.toString();
    }
}

