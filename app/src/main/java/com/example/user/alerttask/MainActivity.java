
package com.example.user.alerttask;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

 //   final Context context = this;
    private Button button;
    private AppCompatButton buttonConfirm;
    private EditText editTextConfirmOtp;
    private TextView txtview;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonShowCustomDialog);
        txtview=findViewById(R.id.textvw);

        // add button listener
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                LayoutInflater li = LayoutInflater.from(MainActivity.this);
                //Creating a view to get the dialog box
                View confirmDialog = li.inflate(R.layout.dialog_confirm, null);

                //Initizliaing confirm button fo dialog box and edittext of dialog box
                buttonConfirm = confirmDialog.findViewById(R.id.buttonConfirm);
                editTextConfirmOtp = (EditText) confirmDialog.findViewById(R.id.editTextOtp);

                //Creating an alertdialog builder
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                //Adding our dialog box to the view of alert dialog
                alert.setView(confirmDialog);


                //Creating an alert dialog
                final AlertDialog alertDialog = alert.create();
//Getting the user entered otp from edittext

                //Displaying the alert dialog
                alertDialog.show();
                buttonConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String otp = editTextConfirmOtp.getText().toString().trim();
                        Toast.makeText(MainActivity.this, otp, Toast.LENGTH_SHORT).show();
                     //   String
                       // .setText(otp);
                        //Hiding the alert dialog
                        alertDialog.dismiss();
                        txtview.setText(otp);

                        //Displaying a progressbar
                      //  final ProgressDialog loading = ProgressDialog.show(MainActivity.this, "Authenticating", "Please wait while we check the entered code", false, false);



                    }
                });
            }
        });

    }
}