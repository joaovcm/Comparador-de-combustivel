package br.com.jvcm.comparadordecombustivel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentResult extends Fragment {

    private TextView tvResult;

    public static FragmentResult newInstance (String value){
        Bundle args =new Bundle();
        args.putString("RESULT", value);

        FragmentResult fragmentResult = new FragmentResult();
        fragmentResult.setArguments(args);
        return fragmentResult;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_result, null);

        tvResult = rootView.findViewById(R.id.tv_result);

        if (getArguments().containsKey("RESULT")){
            tvResult.setText(((MainActivity)getActivity()).getResult());
        }
        return rootView;
    }
}
