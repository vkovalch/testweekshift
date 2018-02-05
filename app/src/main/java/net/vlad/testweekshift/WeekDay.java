package net.vlad.testweekshift;

import android.view.View;
import android.widget.TextView;

import org.joda.time.DateTime;

/* compiled from: WeekView.kt */
public final class WeekDay {
    private TextView dayLetterTextView;
    private TextView dayNumberTextView;
    private View hasShiftsView;
    private final int position;
    private final View root;
    private View selectorView;
    private final WeekView weekView;


    public interface OnDayClickListener {
        void dayClicked(int i, DateTime dateTime);
    }

    public WeekDay(View root, WeekView weekView, int position) {
        //Intrinsics.checkParameterIsNotNull(root, "root");
        //Intrinsics.checkParameterIsNotNull(weekView, "weekView");
        this.root = root;
        this.weekView = weekView;
        this.position = position;
        View findViewById = this.root.findViewById(R.id.sdv_day_letter);
        //Intrinsics.checkExpressionValueIsNotNull(findViewById, "root.findViewById(R.id.sdv_day_letter)");
        this.dayLetterTextView = (TextView) findViewById;
        findViewById = this.root.findViewById(R.id.sdv_indicator_day_selected);
        //Intrinsics.checkExpressionValueIsNotNull(findViewById, "root.findViewById(R.id.sdv_indicator_day_selected)");
        this.selectorView = findViewById;
        findViewById = this.root.findViewById(R.id.sdv_day_number);
        //Intrinsics.checkExpressionValueIsNotNull(findViewById, "root.findViewById(R.id.sdv_day_number)");
        this.dayNumberTextView = (TextView) findViewById;
        findViewById = this.root.findViewById(R.id.sdv_indicator_has_shifts);
        //Intrinsics.checkExpressionValueIsNotNull(findViewById, "root.findViewById(R.id.sdv_indicator_has_shifts)");
        this.hasShiftsView = this.root.findViewById(R.id.sdv_indicator_has_shifts);
    }

    public final int getPosition() {
        return this.position;
    }

    public final View getRoot() {
        return this.root;
    }

    public final void setDayLetter(String letter) {
        //Intrinsics.checkParameterIsNotNull(letter, "letter");
        this.dayLetterTextView.setText(letter);
    }

    public final void setDayNumber(int number) {
        this.dayNumberTextView.setText(String.valueOf(number));
    }

    public final void setHasShifts(boolean hasShifts) {
        this.hasShiftsView.setVisibility(hasShifts ? View.VISIBLE : View.INVISIBLE);
    }

    public final void setDayAsSelected(boolean isSelected) {
        if (isSelected) {
            this.weekView.removeLastSelectedDay();
            this.weekView.setLastSelected(this.position);
        }
        this.selectorView.setVisibility(isSelected ? View.VISIBLE : View.INVISIBLE);
    }

    public final void setDateTime(DateTime date) {
        //Intrinsics.checkParameterIsNotNull(date, "date");
        this.dayNumberTextView.setTag(date);
    }

    public final DateTime getDateTime() {
        Object tag = this.dayNumberTextView.getTag();
        if (tag != null) {
            return (DateTime) tag;
        } else return org.joda.time.DateTime.now();

    }
}