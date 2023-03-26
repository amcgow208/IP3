package org.me.gcu.ip3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class RegistrationFragment extends Fragment {

    private Button backButton;
    Button btnSignUp;
    EditText et_firname, et_surname, et_usrnme, et_pswrd, et_email;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        //component variables
        backButton = view.findViewById(R.id.back_button);
        btnSignUp = view.findViewById(R.id.sign_up);
        et_firname = view.findViewById(R.id.first_name);
        et_surname = view.findViewById(R.id.surname_name);
        et_usrnme = view.findViewById(R.id.username);
        et_pswrd = view.findViewById(R.id.password);
        et_email = view.findViewById(R.id.email_address);

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                sqlConnect sql;
                dbHelper dbH = new dbHelper(getActivity());
                List<sqlConnect> returnList = dbH.checkUsrnme();

                //Checks that fields are empty
                if (et_firname.getText().toString().isEmpty() || et_surname.getText().toString().isEmpty() || et_usrnme.getText().toString().isEmpty() || et_pswrd.getText().toString().isEmpty() || et_email.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Field(s) Null", Toast.LENGTH_SHORT).show();
                    return;
                }

                sql = new sqlConnect(-1, et_firname.getText().toString(), et_surname.getText().toString(), et_usrnme.getText().toString(), et_pswrd.getText().toString(), et_email.getText().toString());

                try {
                    if(returnList.toString().contains(sql.getUsername())){
                        Toast.makeText(getActivity(), "Username " + et_usrnme.getText() + " Already Exists", Toast.LENGTH_SHORT).show();
                    } else {
                        dbH.addOne(sql);
                        Toast.makeText(getActivity(), sql.getUsername() + " Succesfully Created!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    Log.d("Error Occured = ", ""+e);
                }

            }

        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to LoginActivity
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}


