package com.firnazluztian.myportofolio.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firnazluztian.myportofolio.R;

public class SendEmailFragment extends Fragment {
    private EditText toEditText, contentEditText, subjectEditText;
    private Button sendEmailButton;
    private String subject, message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_send_email, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toEditText = (EditText) getView().findViewById(R.id.toEditText);
        subjectEditText = (EditText) getView().findViewById(R.id.subjectEditText);
        contentEditText = (EditText) getView().findViewById(R.id.contentEditText);
        sendEmailButton = (Button) getView().findViewById(R.id.sendEmailButton);
        toEditText.setText("To: firnazadiansyah@gmail.com");

        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] to = {"firnazadiansyah@gmail.com"};
                subject = subjectEditText.getText().toString();
                message = contentEditText.getText().toString();

                try {
                    Intent email = new Intent(Intent.ACTION_SEND);

                    email.putExtra(Intent.EXTRA_EMAIL, to);
                    email.putExtra(Intent.EXTRA_SUBJECT, subject);
                    email.putExtra(Intent.EXTRA_TEXT, message);

                    // need this to prompts email client only
                    email.setType("message/rfc822");

                    startActivity(Intent.createChooser(email, "Choose an Email client"));
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "something is wrong" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
