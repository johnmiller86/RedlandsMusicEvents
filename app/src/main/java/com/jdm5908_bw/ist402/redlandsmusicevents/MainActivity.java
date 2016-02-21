package com.jdm5908_bw.ist402.redlandsmusicevents;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().add(R.id.container, new MusicEventFragment()).commit();
        }
    }

    /**
     * MusicEventFragment class
     */
    public static class MusicEventFragment extends Fragment{

        public MusicEventFragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

            // Collect data from music events
            String[] eventData = MusicEvents.data;
            List<String> seasonEvents = new ArrayList<>(Arrays.asList(eventData));

            ArrayAdapter<String> musicEventAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_event, R.id.list_item_event_textView, seasonEvents);

            View rootView = inflater.inflate(R.layout.fragment_my, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.listView_event);
            listView.setAdapter(musicEventAdapter);
            return rootView;
        }
    }
}
