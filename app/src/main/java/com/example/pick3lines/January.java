package com.example.pick3lines;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

public class January extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View myview =  inflater.inflate(R.layout.fragment_january, container, false);

         boolean[] pick3bool = {false};
         boolean[] pick3linebool = {false};
        boolean[] pick4bool = {false};
        boolean[] checkboxbool = {false};

       int[] count = {0};

        EditText first, second;
        TextView removedisplay, adddisplay;
        Button pick3, reset;
        ImageView remove, add;
        Button pick3lines;
        Button pick4;
        TextView payout, bet, profit, word, line;
        CheckBox checkBox;

        final String[] payouts = {""};
        final String[] bets = {""};
        final int[] c1 = {1};
        final int[] c2 ={1};
        final int[] ans ={1};


        first = myview.findViewById(R.id.first);
        second = myview.findViewById(R.id.second);
        pick3 = myview.findViewById(R.id.pick3);
        payout = myview.findViewById(R.id.payout);
        bet = myview.findViewById(R.id.bet);
        profit = myview.findViewById(R.id.profit);
        word = myview.findViewById(R.id.word);
        pick3lines = myview.findViewById(R.id.pic3line);
        pick4 = myview.findViewById(R.id.pick4);
        line = myview.findViewById(R.id.line);
        checkBox = myview.findViewById(R.id.box);
        remove = myview.findViewById(R.id.remove);
        add = myview.findViewById(R.id.add);
        adddisplay = myview.findViewById(R.id.adddisplay);
        removedisplay = myview.findViewById(R.id.removedisplay);
        reset = myview.findViewById(R.id.resett);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                first.setText("");
                second.setText("");
            }
        });


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                payouts[0]  = first.getText().toString();
                bets[0]  = second.getText().toString();

                if (checked){
                    checkboxbool[0] = true;

                    if(pick3bool[0]== true){

                        if (TextUtils.isEmpty(payouts[0])) {
                            first.setError("Please Enter The Number");
                            first.requestFocus();
                            return;
                        }    if (TextUtils.isEmpty(bets[0])) {
                            second.setError("Please Enter The Number");
                            second.requestFocus();
                            return;
                        }

                        payouts[0] = first.getText().toString();
                        bets[0] = second.getText().toString();
                        c1[0] = Integer.parseInt(payouts[0]);
                        c2[0] = Integer.parseInt(bets[0]);
                        c1[0] = c1[0] * 7 * 3*2;
                        c2[0] = c2[0] * 80;

                         ans[0] = c2[0] - c1[0];
                         count[0]=0;

                        String words = convertIntoWords((double) ans[0],"en","US");

                        payout.setText(""+ c2[0] +" Payout");
                        bet.setText("-"+ c1[0] +" Bet amount");
                        profit.setText("= "+ ans[0]+ " profit");
                        word.setText("= " +words+ " dollars");




                        line.setText("= The is the count for having selected pick 4- "+ count[0]+" dollars a number for the past year");

                    }

                    else if(pick4bool[0]== true){
                        if (TextUtils.isEmpty(payouts[0])) {
                            first.setError("Please Enter The Number");
                            first.requestFocus();
                            return;
                        }    if (TextUtils.isEmpty(bets[0])) {
                            second.setError("Please Enter The Number");
                            second.requestFocus();
                            return;
                        }

                        payouts[0] = first.getText().toString();
                        bets[0] = second.getText().toString();
                        c1[0] = Integer.parseInt(payouts[0]);
                        c2[0]= Integer.parseInt(bets[0]);
                        c1[0] = c1[0] * 7 * 3*2;
                        c2[0] = c2[0] * 200;

                        ans[0] = c2[0] - c1[0];
                        count[0]=0;

                        String words = convertIntoWords((double) ans[0],"en","US");

                        payout.setText(""+ c2[0] +" Payout");
                        bet.setText("-"+ c1[0] +" Bet amount");
                        profit.setText("= "+ ans[0]+ " profit");
                        word.setText("= " +words+ " dollars");




                        line.setText("= The is the count for having selected pick 4-"+ count[0]+"dollars a number for the past year");

                    }
                    else if(pick3linebool[0]== true){
                        if (TextUtils.isEmpty(payouts[0])) {
                            first.setError("Please Enter The Number");
                            first.requestFocus();
                            return;
                        }    if (TextUtils.isEmpty(bets[0])) {
                            second.setError("Please Enter The Number");
                            second.requestFocus();
                            return;
                        }

                        payouts[0] = first.getText().toString();
                        bets[0] = second.getText().toString();
                        c1[0] = Integer.parseInt(payouts[0]);
                        c2[0] = Integer.parseInt(bets[0]);
                        c1[0] = c1[0] * 4 * 3*2;
                        c2[0] = c2[0] * 80;

                     ans[0] = c2[0] - c1[0];
                        count[0]=0;
                        String words = convertIntoWords((double) ans[0],"en","US");

                        payout.setText(""+ c2[0]+" Payout");
                        bet.setText("-"+ c1[0]+" Bet amount");
                        profit.setText("= "+ ans[0]+ " profit");
                        word.setText("= " +words+ " dollars");


                        pick3.setBackgroundColor(Color.GREEN);
                        pick4.setBackgroundColor(Color.WHITE);
                        pick3lines.setBackgroundColor(Color.WHITE);

                        line.setText("= The is the count for having selected pick 3 Lines-"+ count[0]+"dollars a number for the past year");

                    }

                }
                else{
                    checkboxbool[0] = false;


                    if(pick3bool[0]== true){
                        if (TextUtils.isEmpty(payouts[0])) {
                            first.setError("Please Enter The Number");
                            first.requestFocus();
                            return;
                        }    if (TextUtils.isEmpty(bets[0])) {
                            second.setError("Please Enter The Number");
                            second.requestFocus();
                            return;
                        }

                        payouts[0] = first.getText().toString();
                        bets[0] = second.getText().toString();
                        c1[0] = Integer.parseInt(payouts[0]);
                        c2[0] = Integer.parseInt(bets[0]);
                        c1[0] = c1[0] * 7 * 3*2;
                        c2[0] = c2[0] * 150;

                     ans[0] = c2[0] - c1[0];
                        count[0]=0;
                        String words = convertIntoWords((double) ans[0],"en","US");

                        payout.setText(""+ c2[0]+ "Payout");
                        bet.setText("-"+ c1[0]+" Bet amount");
                        profit.setText("= "+ ans[0]+ " profit");
                        word.setText("= " +words+ " dollars");



                        line.setText("= The is the count for having selected pick 3- "+ count[0]+" dollars a number for the past year");

                    }

                    if(pick4bool[0]== true){
                        if (TextUtils.isEmpty(payouts[0])) {
                            first.setError("Please Enter The Number");
                            first.requestFocus();
                            return;
                        }    if (TextUtils.isEmpty(bets[0])) {
                            second.setError("Please Enter The Number");
                            second.requestFocus();
                            return;
                        }

                        payouts[0]  = first.getText().toString();
                        bets[0]  = second.getText().toString();
                        c1[0]  = Integer.parseInt(payouts[0] );
                        c2[0]  = Integer.parseInt(bets[0] );
                        c1[0]  = c1[0]  * 7 * 3*2;
                        c2 [0] = c2[0]  * 375;
                        count[0]=0;
                     ans[0]  = c2[0]  - c1[0] ;

                        String words = convertIntoWords((double) ans[0] ,"en","US");

                        payout.setText(""+ c2[0] +" Payout");
                        bet.setText("-"+ c1[0] +" Bet amount");
                        profit.setText("= "+ ans[0] + " profit");
                        word.setText("= " +words+ " dollars");




                        line.setText("= The is the count for having selected pick 4- "+ count[0]+" dollars a number for the past year");

                    }

                    if(pick3linebool[0]== true){
                        if (TextUtils.isEmpty(payouts[0])) {
                            first.setError("Please Enter The Number");
                            first.requestFocus();
                            return;
                        }    if (TextUtils.isEmpty(bets[0])) {
                            second.setError("Please Enter The Number");
                            second.requestFocus();
                            return;
                        }

                        payouts[0]  = first.getText().toString();
                        bets[0]  = second.getText().toString();
                        c1[0]  = Integer.parseInt(payouts[0] );
                        c2[0]  = Integer.parseInt(bets[0]);
                        c1[0]  = c1[0]  * 4 * 3*2;
                        c2[0]  = c2[0]  * 150;
                        count[0]=0;
                       ans[0]  = c2[0]  - c1[0] ;

                        String words = convertIntoWords((double) ans[0] ,"en","US");

                        payout.setText(""+ c2[0] +" Payout");
                        bet.setText("-"+ c1[0] +" Bet amount");
                        profit.setText("= "+ ans[0] + " profit");
                        word.setText("= " +words+ " dollars");




                        line.setText("= The is the count for having selected pick 3 Lines -"+ count[0]+" dollars a number for the past year");

                    }


                }
            }
        });


        pick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payouts[0]  = first.getText().toString();
                bets[0]  = second.getText().toString();
                if (TextUtils.isEmpty(payouts[0])) {
                    first.setError("Please Enter The Number");
                    first.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(bets[0])) {
                    second.setError("Please Enter The Number");
                    second.requestFocus();
                    return;
                }
             if(checkboxbool[0]== true){

                 payouts[0]  = first.getText().toString();
                 bets[0]  = second.getText().toString();
                 c1[0]  = Integer.parseInt(payouts[0] );
                 c2[0]  = Integer.parseInt(bets[0] );
                 c1[0]  = c1[0]  * 7 * 3*2;
                 c2[0]  = c2[0]  * 80;
                 count[0]=0;
                 ans[0]  = c2[0]  - c1[0] ;
             }else{
                 if (TextUtils.isEmpty(payouts[0])) {
                     first.setError("Please Enter The Number");
                     first.requestFocus();
                     return;
                 }    if (TextUtils.isEmpty(bets[0])) {
                     second.setError("Please Enter The Number");
                     second.requestFocus();
                     return;
                 }
                 payouts[0]  = first.getText().toString();
                 bets[0]  = second.getText().toString();
                 c1[0]  = Integer.parseInt(payouts[0] );
                 c2[0]  = Integer.parseInt(bets[0]);
                 c1[0]  = c1[0]  * 7 * 3*2;
                 c2[0]  = c2[0]  * 150;
                 count[0]=0;
                 ans[0] = c2[0]  - c1[0] ;

             }

                String words = convertIntoWords((double) ans[0] ,"en","US");

                payout.setText(""+ c2[0] +" Payout");
                bet.setText("-"+ c1[0] +" Bet amount");
                profit.setText("= "+ ans[0] + " profit");
                word.setText("= " +words+ " dollars");


                pick3.setBackgroundColor(Color.GREEN);
                pick4.setBackgroundColor(Color.WHITE);
                pick3lines.setBackgroundColor(Color.WHITE);

                line.setText("= The is the count for having selected pick 3- "+ count[0]+" dollars a number for the past year");


                pick3bool[0] = true;
                pick3linebool[0] = false;

                pick4bool[0] = false;





            }
        });
        //Pick 3 Lines

        pick3lines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payouts[0]  = first.getText().toString();
                bets[0]  = second.getText().toString();

                if(checkboxbool[0]== true){
                    if (TextUtils.isEmpty(payouts[0])) {
                        first.setError("Please Enter The Number");
                        first.requestFocus();
                        return;
                    }    if (TextUtils.isEmpty(bets[0])) {
                        second.setError("Please Enter The Number");
                        second.requestFocus();
                        return;
                    }

                    payouts[0]  = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0]  = Integer.parseInt(payouts[0] );
                    c2[0]  = Integer.parseInt(bets[0] );
                    c1[0]  = c1[0]  * 4 * 3*2;
                    c2[0]  = c2[0] * 80;
                    count[0]=0;
                    ans[0]  = c2[0]  - c1[0] ;
                }else{
                    if (TextUtils.isEmpty(payouts[0])) {
                        first.setError("Please Enter The Number");
                        first.requestFocus();
                        return;
                    }    if (TextUtils.isEmpty(bets[0])) {
                        second.setError("Please Enter The Number");
                        second.requestFocus();
                        return;
                    }
                    payouts[0]  = first.getText().toString();
                    bets[0]  = second.getText().toString();
                    c1[0]  = Integer.parseInt(payouts[0] );
                    c2[0]  = Integer.parseInt(bets[0] );
                    c1[0]  = c1[0]  * 4 * 3*2;
                    c2[0]  = c2[0]  * 150;
                    count[0]=0;
                    ans[0]  = c2[0]  - c1[0];

                }

                String words = convertIntoWords((double) ans[0],"en","US");

                payout.setText(""+ c2[0]+" Payout");
                bet.setText("-"+ c1[0]+" Bet amount");
                profit.setText("= "+ ans[0]+ " profit");
                word.setText("= " +words+ " dollars");


                pick3.setBackgroundColor(Color.WHITE);
                pick4.setBackgroundColor(Color.WHITE);
                pick3lines.setBackgroundColor(Color.GREEN);

                line.setText("= The is the count for having selected pick 3 Lines- "+ count[0]+" dollars a number for the past year");


                pick3bool[0] = false;
                pick3linebool[0] = true;

                pick4bool[0] = false;





            }
        });

        // pick 4



        pick4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payouts[0]  = first.getText().toString();
                bets[0]  = second.getText().toString();

                if(checkboxbool[0]== true){
                    if (TextUtils.isEmpty(payouts[0])) {
                        first.setError("Please Enter The Number");
                        first.requestFocus();
                        return;
                    }    if (TextUtils.isEmpty(bets[0])) {
                        second.setError("Please Enter The Number");
                        second.requestFocus();
                        return;
                    }
                    payouts[0] = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0] = Integer.parseInt(payouts[0]);
                    c2[0] = Integer.parseInt(bets[0]);
                    c1[0] = c1[0] * 7 * 3*2;
                    c2[0] = c2[0] * 200;
                    count[0]=0;
                    ans[0] = c2[0] - c1[0];
                }else{
                    if (TextUtils.isEmpty(payouts[0])) {
                        first.setError("Please Enter The Number");
                        first.requestFocus();
                        return;
                    }    if (TextUtils.isEmpty(bets[0])) {
                        second.setError("Please Enter The Number");
                        second.requestFocus();
                        return;
                    }
                    payouts[0] = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0] = Integer.parseInt(payouts[0]);
                    c2[0] = Integer.parseInt(bets[0]);
                    c1[0]= c1[0] * 7 * 3*2;
                    c2[0] = c2[0] * 375;
                    count[0]=0;
                    ans[0] = c2[0] - c1[0];

                }

                String words = convertIntoWords((double) ans[0],"en","US");

                payout.setText(""+ c2[0]+" Payout");
                bet.setText("-"+ c1[0]+" Bet amount");
                profit.setText("= "+ ans[0]+ " profit");
                word.setText("= " +words+ " dollars");


                pick3.setBackgroundColor(Color.WHITE);
                pick4.setBackgroundColor(Color.GREEN);
                pick3lines.setBackgroundColor(Color.WHITE);

                line.setText("= The is the count for having selected pick 4-"+ count[0]+" dollars a number for the past year");


                pick3bool[0] = false;
                pick3linebool[0] = false;

                pick4bool[0] = true;





            }
        });

        ///Add And Remove

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payouts[0]  = first.getText().toString();
                bets[0]  = second.getText().toString();
                if (TextUtils.isEmpty(payouts[0])) {
                    first.setError("Please Enter The Number");
                    first.requestFocus();
                    return;
                }    if (TextUtils.isEmpty(bets[0])) {
                    second.setError("Please Enter The Number");
                    second.requestFocus();
                    return;
                }

                count[0]++;
                adddisplay.setText(""+ count[0]);
                removedisplay.setText("0");


                if (checkboxbool[0] == true && pick3bool[0] == true) {


                    payouts[0] = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0] = Integer.parseInt(payouts[0]);
                    c2[0] = Integer.parseInt(bets[0]);
                    c1[0] = c1[0] * 7 * 3*2;

                    c2[0] = c2[0] * 80;

                    ans[0] = c2[0] - c1[0];
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0],"en","US");

                    payout.setText(""+ c2[0]+" Payout");
                    bet.setText("-"+ c1[0]+" Bet amount");
                    profit.setText("= "+ ans[0]+ " profit");
                    word.setText("= " +words+ " dollars");


                    line.setText("= The is the count for having selected pick 3- "+count[0]+ " dollars a number for the past year");

                }


                else if (checkboxbool[0] == true && pick3linebool[0] == true)
                {

                    payouts[0] = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0] = Integer.parseInt(payouts[0]);
                    c2[0] = Integer.parseInt(bets[0]);
                    c1[0] = c1[0] * 4 * 3*2;
                    c2[0]= c2[0] * 150;

                  ans[0] = c2[0] - c1[0];
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0],"en","US");

                    payout.setText(""+ c2[0]+" Payout");
                    bet.setText("-"+ c1[0]+" Bet amount");
                    profit.setText("= "+ ans[0]+ " profit");
                    word.setText("= " +words+ " dollars");



                    line.setText("= The is the count for having selected pick 3- "+count[0]+ " dollars a number for the past year");

                } else if (checkboxbool[0]==true && pick4bool[0]==true) {
                    if (TextUtils.isEmpty(payouts[0])) {
                        first.setError("Please Enter The Number");
                        first.requestFocus();
                        return;
                    }    if (TextUtils.isEmpty(bets[0])) {
                        second.setError("Please Enter The Number");
                        second.requestFocus();
                        return;
                    }


                    payouts[0] = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0] = Integer.parseInt(payouts[0]);
                    c2[0] = Integer.parseInt(bets[0]);
                    c1[0] = c1[0] * 7 * 3*2;
                    c2[0] = c2[0] * 200;

                   ans[0] = c2[0] - c1[0];
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0],"en","US");

                    payout.setText(""+ c2[0]+" Payout");
                    bet.setText("-"+ c1[0]+" Bet amount");
                    profit.setText("= "+ ans[0]+ " profit");
                    word.setText("= " +words+ " dollars");



                    line.setText("= The is the count for having selected pick 4- "+count[0]+ " dollars a number for the past year");



                }


              else if(pick3bool[0]== true){

                    payouts[0] = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0] = Integer.parseInt(payouts[0]);
                    c2[0] = Integer.parseInt(bets[0]);
                    c1[0] = c1[0] * 7 * 3*2;
                    c2[0] = c2[0] * 150;

                    ans[0] = c2[0] - c1[0];
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0],"en","US");

                    payout.setText(""+ c2[0]+" Payout");
                    bet.setText("-"+ c1[0]+" Bet amount");
                    profit.setText("= "+ ans[0]+ " profit");
                    word.setText("= " +words+ " dollars");



                    line.setText("= The is the count for having selected pick 3- "+count[0]+ " dollars a number for the past year");

                }

                else if(pick4bool[0]== true){

                    payouts[0]  = first.getText().toString();
                    bets[0]  = second.getText().toString();
                    c1[0]  = Integer.parseInt(payouts[0] );
                    c2[0]  = Integer.parseInt(bets[0] );
                    c1[0]  = c1[0]  * 7 * 3*2;
                    c2 [0] = c2[0]  * 375;

                    ans[0]  = c2[0]  - c1[0] ;
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0] ,"en","US");

                    payout.setText(""+ c2[0] +" Payout");
                    bet.setText("-"+ c1[0] +" Bet amount");
                    profit.setText("= "+ ans[0] + " profit");
                    word.setText("= " +words+ " dollars");




                    line.setText("= The is the count for having selected pick 4- "+count[0]+ " dollars a number for the past year");

                }

                else if(pick3linebool[0]== true){

                    payouts[0]  = first.getText().toString();
                    bets[0]  = second.getText().toString();
                    c1[0]  = Integer.parseInt(payouts[0] );
                    c2[0]  = Integer.parseInt(bets[0]);
                    c1[0]  = c1[0]  * 4 * 3*2;
                    c2[0]  = c2[0]  * 150;

                    ans[0]  = c2[0]  - c1[0] ;
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0] ,"en","US");

                    payout.setText(""+ c2[0] +" Payout");
                    bet.setText("-"+ c1[0] +" Bet amount");
                    profit.setText("= "+ ans[0] + " profit");
                    word.setText("= " +words+ " dollars");



                    line.setText("= The is the count for having selected pick 3 Lines-"+count[0]+ " dollars a number for the past year");

                }


            }
        });
   remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payouts[0]  = first.getText().toString();
                bets[0]  = second.getText().toString();

                count[0]--;
               removedisplay.setText(""+ count[0]);
                adddisplay.setText("0");


                if (checkboxbool[0] == true && pick3bool[0] == true) {


                    payouts[0] = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0] = Integer.parseInt(payouts[0]);
                    c2[0] = Integer.parseInt(bets[0]);
                    c1[0] = c1[0] * 7 * 3*2;

                    c2[0] = c2[0] * 80;

                    ans[0] = c2[0] - c1[0];
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0],"en","US");

                    payout.setText(""+ c2[0]+" Payout");
                    bet.setText("-"+ c1[0]+" Bet amount");
                    profit.setText("= "+ ans[0]+ " profit");
                    word.setText("= " +words+ " dollars");


                    line.setText("= The is the count for having selected pick 3- "+count[0]+ " dollars a number for the past year");

                }


                else if (checkboxbool[0] == true && pick3linebool[0] == true)
                {

                    payouts[0] = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0] = Integer.parseInt(payouts[0]);
                    c2[0] = Integer.parseInt(bets[0]);
                    c1[0] = c1[0] * 4 * 3*2;
                    c2[0]= c2[0] * 150;

                    ans[0] = c2[0] - c1[0];
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0],"en","US");

                    payout.setText(""+ c2[0]+" Payout");
                    bet.setText("-"+ c1[0]+" Bet amount");
                    profit.setText("= "+ ans[0]+ " profit");
                    word.setText("= " +words+ " dollars");



                    line.setText("= The is the count for having selected pick 3- "+count[0]+ " dollars a number for the past year");

                } else if (checkboxbool[0]==true && pick4bool[0]==true) {


                    payouts[0] = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0] = Integer.parseInt(payouts[0]);
                    c2[0] = Integer.parseInt(bets[0]);
                    c1[0] = c1[0] * 7 * 3*2;
                    c2[0] = c2[0] * 200;

                    ans[0] = c2[0] - c1[0];
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0],"en","US");

                    payout.setText(""+ c2[0]+" Payout");
                    bet.setText("-"+ c1[0]+" Bet amount");
                    profit.setText("= "+ ans[0]+ " profit");
                    word.setText("= " +words+ " dollars");



                    line.setText("= The is the count for having selected pick 4- "+count[0]+ " dollars a number for the past year");



                }


                else if(pick3bool[0]== true){

                    payouts[0] = first.getText().toString();
                    bets[0] = second.getText().toString();
                    c1[0] = Integer.parseInt(payouts[0]);
                    c2[0] = Integer.parseInt(bets[0]);
                    c1[0] = c1[0] * 7 * 3*2;
                    c2[0] = c2[0] * 150;

                    ans[0] = c2[0] - c1[0];
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0],"en","US");

                    payout.setText(""+ c2[0]+" Payout");
                    bet.setText("-"+ c1[0]+" Bet amount");
                    profit.setText("= "+ ans[0]+ " profit");
                    word.setText("= " +words+ " dollars");



                    line.setText("= The is the count for having selected pick 3- "+count[0]+ " dollars a number for the past year");

                }

                else if(pick4bool[0]== true){

                    payouts[0]  = first.getText().toString();
                    bets[0]  = second.getText().toString();
                    c1[0]  = Integer.parseInt(payouts[0] );
                    c2[0]  = Integer.parseInt(bets[0] );
                    c1[0]  = c1[0]  * 7 * 3*2;
                    c2 [0] = c2[0]  * 375;

                    ans[0]  = c2[0]  - c1[0] ;
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0] ,"en","US");

                    payout.setText(""+ c2[0] +" Payout");
                    bet.setText("-"+ c1[0] +" Bet amount");
                    profit.setText("= "+ ans[0] + " profit");
                    word.setText("= " +words+ " dollars");




                    line.setText("= The is the count for having selected pick 4- "+count[0]+ " dollars a number for the past year");

                }

                else if(pick3linebool[0]== true){

                    payouts[0]  = first.getText().toString();
                    bets[0]  = second.getText().toString();
                    c1[0]  = Integer.parseInt(payouts[0] );
                    c2[0]  = Integer.parseInt(bets[0]);
                    c1[0]  = c1[0]  * 4 * 3*2;
                    c2[0]  = c2[0]  * 150;

                    ans[0]  = c2[0]  - c1[0] ;
                    c1[0] = c1[0] * count[0];
                    c2[0] = c2[0] * count[0];
                    ans[0] = ans[0] * count[0];

                    String words = convertIntoWords((double) ans[0] ,"en","US");

                    payout.setText(""+ c2[0] +" Payout");
                    bet.setText("-"+ c1[0] +" Bet amount");
                    profit.setText("= "+ ans[0] + " profit");
                    word.setText("= " +words+ " dollars");



                    line.setText("= The is the count for having selected pick 3 Lines- "+count[0]+ " dollars a number for the past year");

                }


            }
        });


























        return myview;
    }

    private String convertIntoWords(Double str,String language,String Country) {
        Locale local = new Locale(language, Country);
        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(local, RuleBasedNumberFormat.SPELLOUT);
        return ruleBasedNumberFormat.format(str);
    }
}