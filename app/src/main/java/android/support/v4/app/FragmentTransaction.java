package android.support.v4.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sprinkles.R;

public class FragmentTransaction {
    import android.os.Bundle;
import android.support.v4.app.MainFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


    /**
     * A simple {@link Fragment} subclass.
     */
    public class MainFragment extends Fragment {


        public MainFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_main, container, false);


            return view;
        }

    }

}
