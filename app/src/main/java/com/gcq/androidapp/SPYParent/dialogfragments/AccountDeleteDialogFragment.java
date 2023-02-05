package com.gcq.androidapp.SPYParent.dialogfragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.gcq.androidapp.SPYParent.R;
import com.gcq.androidapp.SPYParent.interfaces.OnDeleteAccountListener;
import com.gcq.androidapp.SPYParent.utils.Constant;
import com.gcq.androidapp.SPYParent.utils.SharedPrefsUtils;
import com.gcq.androidapp.SPYParent.utils.Validators;

public class AccountDeleteDialogFragment extends DialogFragment {
	private EditText txtDeleteAccountPassword;
	private Button btnDeleteAccount;
	private Button btnCancelDeleteAccount;
	private OnDeleteAccountListener onDeleteAccountListener;
	
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_dialog_delete_account, container, false);
	}
	
	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		onDeleteAccountListener = (OnDeleteAccountListener) getActivity();
		
		txtDeleteAccountPassword = view.findViewById(R.id.txtDeleteAccountPassword);
		btnDeleteAccount = view.findViewById(R.id.btnDeleteAccount);
		btnDeleteAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (isValid()) {
					onDeleteAccountListener.onDeleteAccount(txtDeleteAccountPassword.getText().toString());
					dismiss();
				}
			}
		});
		
		
		btnCancelDeleteAccount = view.findViewById(R.id.btnCancelDeleteAccount);
		btnCancelDeleteAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				dismiss();
			}
		});
		
		
	}
	
	private boolean isValid() {
		if (!Validators.isValidPassword(txtDeleteAccountPassword.getText().toString())) {
			txtDeleteAccountPassword.setError(getString(R.string.wrong_password));
			txtDeleteAccountPassword.requestFocus();
			return false;
		}
		
		if (!txtDeleteAccountPassword.getText().toString().equals(SharedPrefsUtils.getStringPreference(getContext(), Constant.PASSWORD, ""))) {
			txtDeleteAccountPassword.setError(getString(R.string.wrong_password));
			txtDeleteAccountPassword.requestFocus();
			return false;
		}
		
		return true;
	}
}
