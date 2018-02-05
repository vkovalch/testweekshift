package net.vlad.testweekshift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import net.vlad.testweekshift.WeekDay.OnDayClickListener;

import java.util.ArrayList;
//import kotlin.jvm.internal.Intrinsics;

/* compiled from: WeekView.kt */
public final class WeekView extends LinearLayout {
    private ArrayList<WeekDay> days = new ArrayList();
    private int lastSelected = -1;
    private OnDayClickListener listener;

    public final void clearSetData() {

        throw new UnsupportedOperationException("Method not decompiled: com.thisclicks.wiw.scheduler.WeekView.clearSetData():void");
    }

    public final void setOnDayClickListener(net.vlad.testweekshift.WeekDay.OnDayClickListener r1) {
        listener.dayClicked(getLastSelected(),getDays().get(getLastSelected()).getDateTime());
        throw new UnsupportedOperationException("Method not decompiled: com.thisclicks.wiw.scheduler.WeekView.setOnDayClickListener(com.thisclicks.wiw.scheduler.WeekDay$OnDayClickListener):void");
    }

    public WeekView(Context context) {
        //Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
        init();
    }

    public WeekView(Context context, AttributeSet attrs) {
        //Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attrs);
        init();
    }

    public WeekView(Context context, AttributeSet attrs, int defStyleAttr) {
        //Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attrs, defStyleAttr);
        init();
    }

    public final ArrayList<WeekDay> getDays() {
        return this.days;
    }

    public final void setDays(ArrayList<WeekDay> days) {
        this.days = days;
    }

    public final int getLastSelected() {
        return this.lastSelected;
    }

    public final void setLastSelected(int i) {
        this.lastSelected = i;
    }

    public final void init() {
        int position = 0;
        WeekView wv = this;
        setOrientation(HORIZONTAL);
        setWeightSum(7.0f);
        while (position < 7) {
            View inflate = LinearLayout.inflate(getContext(), R.layout.week_day_view, null);
            LayoutParams lp = new LayoutParams(-2, -1);
            lp.weight = 1.0f;
            inflate.setLayoutParams(lp);
            ArrayList arrayList = this.days;
            //Intrinsics.checkExpressionValueIsNotNull(inflate, "this");
            arrayList.add(new WeekDay(inflate, wv, position));
            addView(inflate);
            position++;
        }
    }

    public final void removeLastSelectedDay() {
        if (this.lastSelected != -1) {
            ((WeekDay) this.days.get(this.lastSelected)).setDayAsSelected(false);
        }
    }
}