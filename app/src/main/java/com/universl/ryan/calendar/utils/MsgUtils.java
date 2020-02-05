package com.universl.ryan.calendar.utils;

import android.app.Activity;

import com.universl.ryan.calendar.R;
import com.universl.smsnotifier.Constants;
import com.universl.smsnotifier.MessageOperator;
import com.universl.smsnotifier.MsgOperatorFactory;

import java.util.ArrayList;
import java.util.List;

public class MsgUtils {

    public static List<MessageOperator> getOperators(Activity activity) {
        List<MessageOperator> ussdOperators = new ArrayList<>();
        MessageOperator ideaMartOperator = MsgOperatorFactory.createMessageOperator("", Constants.SP_DIALOG1, Constants.SP_DIALOG2, Constants.SP_DIALOG3, Constants.SP_AIRTEL, Constants.SP_HUTCH, Constants.SP_ETISALAT);
        ideaMartOperator.setSmsMsg("#780*942#");
        ideaMartOperator.setCharge("5 LKR + Tax P/D");
        ideaMartOperator.setAlertMsg(activity.getResources().getString(R.string.sms_msg_ex));
        ussdOperators.add(ideaMartOperator);

        MessageOperator mobitelOperator = MsgOperatorFactory.createMessageOperator("", Constants.SP_MOBITEL);
        mobitelOperator.setSmsMsg("#780*942#");
        mobitelOperator.setCharge("1.25 LKR + Tax P/D");
        mobitelOperator.setAlertMsg(activity.getResources().getString(R.string.sms_msg_ex));
        ussdOperators.add(mobitelOperator);

        return ussdOperators;
    }
}
