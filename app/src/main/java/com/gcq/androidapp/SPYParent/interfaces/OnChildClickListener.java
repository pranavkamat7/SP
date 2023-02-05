package com.gcq.androidapp.SPYParent.interfaces;

import com.gcq.androidapp.SPYParent.models.User;

public interface OnChildClickListener {
    void onItemClick(/*View view, */int position);

    void onWebFilterClick(boolean checked, User child);

    void onBtnLockClick(boolean checked, User child);

    void onLockPhoneSet(int hours, int minutes);

    void onLockCanceled();

    //void onLockDismiss();


}
