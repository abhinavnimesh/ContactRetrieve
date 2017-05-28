package com.animator_abhi.contactretrieve;


import java.util.ArrayList;

        import android.app.Activity;
        import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
        import android.os.AsyncTask;
        import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
        import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
        import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
        import android.widget.ListView;
import android.widget.TextView;

public class ContactActivity extends Activity {
    ListView list;
    LinearLayout ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        list = (ListView) findViewById(R.id.list);

        LoadContactsAyscn lca = new LoadContactsAyscn();
        lca.execute();

    }

    class LoadContactsAyscn extends AsyncTask<Void, Void, ArrayList<String>> {


        @Override
        protected void onPreExecute() {

            super.onPreExecute();

//
        }

        @Override
        protected ArrayList<String> doInBackground(Void... params) {

            ArrayList<String> contacts = new ArrayList<String>();

            Cursor c = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    null, null, null);
            while (c.moveToNext()) {

                String contactName = c
                        .getString(c
                                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phNumber = c
                        .getString(c
                                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                contacts.add(contactName + " :  " + phNumber);

            }
            c.close();

            return contacts;
        }

        @Override
        protected void onPostExecute(ArrayList<String> contacts) {

            super.onPostExecute(contacts);





            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    getApplicationContext(), R.layout.text, contacts);

            list.setAdapter(adapter);

        }

    }

    @Override
    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        Parcelable listViewState = state.getParcelable("listview.state");
        list.onRestoreInstanceState(listViewState);

    }
    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putParcelable("listview.state", list.onSaveInstanceState());

    }

    }





