package org.me.gcu.ip3;
import org.me.gcu.ip3.ToastUtils;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class RegistrationFragment extends Fragment {

    private EditText firstName, surname, username, password, emailAddress;
    private Button signUpButton, backButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        firstName = view.findViewById(R.id.first_name);
        surname = view.findViewById(R.id.surname_name);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        emailAddress = view.findViewById(R.id.email_address);

        signUpButton = view.findViewById(R.id.sign_up);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // Handle successful registration here
                    ToastUtils.showToast(getActivity(), "Account created successfully!");
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                } else {
                    ToastUtils.showToast(getActivity(), "Please fill in all fields!");
                }
            }
        });



        backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous fragment
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.popBackStack();
            }
        });

        return view;
    }

    private boolean validateInput() {
        return !TextUtils.isEmpty(firstName.getText()) &&
                !TextUtils.isEmpty(surname.getText()) &&
                !TextUtils.isEmpty(username.getText()) &&
                !TextUtils.isEmpty(password.getText()) &&
                !TextUtils.isEmpty(emailAddress.getText());
    }


}
