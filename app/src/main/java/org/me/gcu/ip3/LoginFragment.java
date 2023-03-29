package org.me.gcu.ip3;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginFragment extends Fragment {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private Button mRegisterButton;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        // Get references to UI elements
        mUsernameEditText = rootView.findViewById(R.id.username);
        mPasswordEditText = rootView.findViewById(R.id.password);
        mLoginButton = rootView.findViewById(R.id.login_button);
        mRegisterButton = rootView.findViewById(R.id.register_button);

        // Set up click listener for login button
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get username and password
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                dbHelper dbH = new dbHelper(getActivity());

                if(username.isEmpty()|| password.isEmpty()){
                    ToastUtils.showToast(getActivity(), "Field(s) Null");
                    return;
                }


                // TODO: Check user's credentials

                try {
                    sqlConnect sql;
                    sql = new sqlConnect(-1, null, null, username, password, null);
                    List<sqlConnect> returnList = dbH.checkLogin(username);

                    //Checks if username exists in db
                    if(returnList.toString().contains(sql.getPassword())){
                        // If the login is successful, display a toast message and navigate to the WelcomeFragment
                        Toast.makeText(getActivity(), "Login successful!", Toast.LENGTH_SHORT).show();
                        ((MainActivity) getActivity()).loadFragment(new WelcomeFragment());
                    } else {
                        //Creates new entry as long as username doesn't exist in db
                        Toast.makeText(getActivity(), sql.getUsername() + " Login Failed", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    Log.d("Error Occured = ", ""+e);
                }

            }
        });

        // Set up click listener for register button
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).loadFragment(new RegistrationFragment());
            }
        });

        return rootView;
    }
}
