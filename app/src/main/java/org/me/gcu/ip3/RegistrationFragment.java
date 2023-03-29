package org.me.gcu.ip3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.text.TextUtils;
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


    Button btnSignUp, backButton;
    EditText firstName, surname, username, password, email;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        //component variables
        backButton = view.findViewById(R.id.back_button);
        btnSignUp = view.findViewById(R.id.sign_up);
        firstName = view.findViewById(R.id.first_name);
        surname = view.findViewById(R.id.surname_name);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        email = view.findViewById(R.id.email_address);

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                sqlConnect sql;
                dbHelper dbH = new dbHelper(getActivity());
                List<sqlConnect> returnList = dbH.checkUsrnme();

                //Checks that fields are empty
                if (firstName.getText().toString().isEmpty() || surname.getText().toString().isEmpty() || username.getText().toString().isEmpty() || password.getText().toString().isEmpty() || email.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Field(s) Null", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Values entered by user passed to sql object
                sql = new sqlConnect(-1, firstName.getText().toString(), surname.getText().toString(), username.getText().toString(), password.getText().toString(), email.getText().toString());

                try {
                    //Checks if username exists in db
                    if(returnList.toString().contains(sql.getUsername())){
                        Toast.makeText(getActivity(), "Username " + username.getText() + " Already Exists", Toast.LENGTH_SHORT).show();
                    } else {
                        //Creates new entry as long as username doesn't exist in db
                        dbH.addOne(sql);
                        Toast.makeText(getActivity(), sql.getUsername() + " Succesfully Created!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
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
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}


