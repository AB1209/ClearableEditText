package com.ab1209.clearableedittext.views;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.ab1209.clearableedittext.R;

public class ClearableEditText extends RelativeLayout {

    private final static String TAG = "ClearableEditText";
    private LayoutInflater inflater = null;
    private EditText editText;
    private Button btnClear;

    public ClearableEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public ClearableEditText(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.clearable_edit_text, this, true);
        editText = (EditText) findViewById(R.id.clearable_edit);
        btnClear = (Button) findViewById(R.id.clearable_button_clear);
        btnClear.setVisibility(RelativeLayout.INVISIBLE);
        clearText();
        showHideClearButton();
    }

    private void clearText() {
        btnClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }

    private void showHideClearButton() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0)
                    btnClear.setVisibility(RelativeLayout.VISIBLE);
                else
                    btnClear.setVisibility(RelativeLayout.INVISIBLE);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public Editable getText() {
        Editable text = editText.getText();
        return text;
    }
}