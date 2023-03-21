package org.me.gcu.ip3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

                try{
                   sql = new sqlConnect(-1, et_firname.getText().toString(), et_surname.getText().toString(), et_usrnme.getText().toString(), et_pswrd.getText().toString(), et_email.getText().toString());
                   //Toast.makeText(getActivity(), sql.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Toast.makeText(getActivity(), "Error Creating User", Toast.LENGTH_SHORT).show();
                    sql = new sqlConnect(-1, "error", "error", "error", "error", "error");
                }

                dbHelper dbH = new dbHelper(getActivity());
                boolean result = dbH.addOne(sql);
                if(!result){
                    Toast.makeText(getActivity(), "Error Creating User", Toast.LENGTH_SHORT).show();
                };
                //Toast.makeText(getActivity(), "Registration = " + result, Toast.LENGTH_SHORT).show();
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


