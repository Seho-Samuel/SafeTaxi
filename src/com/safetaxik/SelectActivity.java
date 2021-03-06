package com.safetaxik;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SelectActivity extends Activity {

	Button	btn_camera, btn_write;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);

		btn_camera = (Button) findViewById(R.id.btn_camera);
		btn_write = (Button) findViewById(R.id.btn_write);

		btn_camera.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(SelectActivity.this, CameraActivity.class));
				finish();
			}
		});

		btn_write.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(1);

			}
		});

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder builder;
		AlertDialog alertDialog;

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.write_dialog, (ViewGroup) findViewById(R.id.layout_root));
		final EditText sex = (EditText) layout.findViewById(R.id.edit_carno);
		builder = new AlertDialog.Builder(SelectActivity.this);
		builder.setView(layout);
		builder.setTitle("차량 번호 입력");
		builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent mIntent = new Intent(SelectActivity.this, RidingActivity.class);
				mIntent.putExtra("CARNO", sex.getText().toString());
				startActivity(mIntent);
				finish();
			}
		});
		alertDialog = builder.create();
		return alertDialog;

	}
}
