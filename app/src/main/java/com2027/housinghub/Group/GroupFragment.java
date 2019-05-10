package com2027.housinghub.Group;
/**
 * Fragment that wil hold the Group members of the user, and settings
 * considering groups.
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com2027.housinghub.R;

public class GroupFragment extends Fragment {

    //Contains profile images
    int[] images = {R.drawable.profile_1, R.drawable.profile_2, R.drawable.profile_3};
    //2d array each containing [[full name, uni attending, course], [...], [etc]]
    String[][] user = {{"John Smith", "Uni Of Surrey", "Computer Science"}, {"Johnathon Smithsonian", "UOS", "Compsci"}, {"J Smithy", "Uni O' Surrey", "C-Science"}};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group, container, false);

        ListView list = (ListView) view.findViewById(R.id.listViewGroup);

        NewAdapter adapter = new NewAdapter();
        list.setAdapter(adapter);

        return view;
    }

    class NewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.layout_group, null);

            ImageView image = (ImageView) view.findViewById(R.id.imageViewGroup);
            image.setImageResource(images[position]);

            TextView textName = (TextView) view.findViewById(R.id.textNameGroup);
            TextView textUni = (TextView) view.findViewById(R.id.textUniGroup);
            TextView textCourse = (TextView) view.findViewById(R.id.textCourseGroup);

            textName.setText(user[position][0]);
            textUni.setText(user[position][1]);
            textCourse.setText(user[position][2]);

            return view;
        }

    }

}
