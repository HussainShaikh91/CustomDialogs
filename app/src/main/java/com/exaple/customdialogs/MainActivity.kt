package com.exaple.customdialogs

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val snackbarBtn : Button = findViewById(R.id.btn_seekbar)
       val aleartDialog : Button = findViewById(R.id.btn_dialog)
       val btncustomdialog : Button = findViewById(R.id.btn_dialog1)
       val btnProgressDialog : Button = findViewById(R.id.btnCustomProgressDialog)
       val btnAnimatedProgressbar : Button = findViewById(R.id.btnAnimatedProgressbar)

        //for SnackBar
        snackbarBtn.setOnClickListener { view ->
            Snackbar.make(view, "This is a SnackBar", Snackbar.LENGTH_SHORT).show()
        }
        //this is a alert dialog
        aleartDialog.setOnClickListener {
            alertDialog()
        }
        //this is a custom alert dialog
        btncustomdialog.setOnClickListener {
            customAlertDialog()
        }
        //this is a custom progress dialog
        btnProgressDialog.setOnClickListener {
            CustomProgressDialog()
        }
        //this is for Animated progress dialog
        btnAnimatedProgressbar.setOnClickListener {
            AnimatedProgressDialog()
        }
    }

    /*
    * this method for alert dialog show
    * */
    private fun alertDialog() {
       //Use the Builder class for convenient dialog construction
        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle("Alert")
        //set message for alert dialog
        builder.setMessage("This is Alert Dialog. Which is used to show alert dialog in out app")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        //performing positive action
        builder.setPositiveButton("Yes"){dialogInterface,which ->
            Toast.makeText(applicationContext,"Clicked yes",Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }
        //performing cancel action
        builder.setNeutralButton("Cancel"){dialogInterface,which ->
            Toast.makeText(applicationContext,"Clicked Cancel",Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }
        //performing Negative action
        builder.setNegativeButton("No"){dialogInterface,which ->
            Toast.makeText(applicationContext,"Clicked No",Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss() // Dialog will be dismissed
        }
        //Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        //Set other dialog properties
        alertDialog.setCancelable(false) //Will not allow user to cancel alter clicking on remaining screen area.
        //Show the dialog to UI
        alertDialog.show()

    }
    //this method for Custom alert dialog show
    private fun customAlertDialog(){
        val customDialog = Dialog(this)
        //Set the screen content from a layout resource.
        //the resource will be inflated,adding all top level views
        customDialog.setContentView(R.layout.dialog_custom)
        val btnCancel = customDialog.findViewById<Button>(R.id.btnCancel)
        btnCancel.setOnClickListener {
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        val btnSubmit = customDialog.findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            Toast.makeText(this,"Submit",Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        //Start the dialog and display it on Screen
        customDialog.show()

    }
    //this method for custom progress dialog
    private fun CustomProgressDialog(){
        val customProgressDialog = Dialog(this)
        //Set the Custom Progress dialog Layout
        customProgressDialog.setContentView(R.layout.dialog_custom_progress)
        //customProgressDialog.setCancelable(false)
        customProgressDialog.show()
    }
    //this method for Animated Progress Dialog
    private fun AnimatedProgressDialog(){
        val animProgressDialog = Dialog(this)
        animProgressDialog.setContentView(R.layout.animated_progress_dialog)
        animProgressDialog.show()
    }

}