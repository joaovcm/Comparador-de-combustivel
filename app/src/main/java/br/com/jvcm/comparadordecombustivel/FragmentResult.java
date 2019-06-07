package br.com.jvcm.comparadordecombustivel;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentResult extends Fragment {

    private TextView tvResult;
    private Snackbar snackbar;


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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(tvResult == null){
            showMessage("Sem valor inserido!");
        }else {
            showMessage("Valor calculado com sucesso!");
        }
    }

    public void showMessage(String message) {

        snackbar = Snackbar.make(getView(), "", Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        layout.setBackgroundResource(android.R.color.holo_red_dark);
        LayoutInflater inflater = LayoutInflater.from(getView().getContext());
        View view = inflater.inflate(R.layout.snackbar_custom_layout, null);
        ((TextView) view.findViewById(R.id.tv_message)).setText(message);
        layout.addView(view, 0);
        snackbar.show();
    }

    @Override
    public void onDestroyView() {
        if(snackbar.isShown()){
            snackbar.dismiss();
        }
        super.onDestroyView();
    }
}
