package com.example.nanumeal_frontend;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
//
//import kr.co.bootpay.Bootpay;
//import kr.co.bootpay.BootpayAnalytics;
//import kr.co.bootpay.enums.Method;
//import kr.co.bootpay.enums.PG;
//import kr.co.bootpay.enums.UX;
//import kr.co.bootpay.listener.CancelListener;
//import kr.co.bootpay.listener.CloseListener;
//import kr.co.bootpay.listener.ConfirmListener;
//import kr.co.bootpay.listener.DoneListener;
//import kr.co.bootpay.listener.ReadyListener;
//import kr.co.bootpay.model.BootExtra;
//import kr.co.bootpay.model.BootUser;

public class DonationRecieveDetailActivity extends AppCompatActivity {

    private int stuck = 10;
    ImageView support_bottom_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_recieve_detail);

        ImageView eight_btn = (ImageView) findViewById(R.id.eight_btn);
        ImageView five_btn = (ImageView) findViewById(R.id.five_btn);
        ImageView one_btn = (ImageView) findViewById(R.id.one_btn);
        ImageView three_btn = (ImageView) findViewById(R.id.three_btn);
        ImageView five_plus_btn = (ImageView) findViewById(R.id.five_plus_btn);
        ImageView eight_fill_btn = (ImageView) findViewById(R.id.eight_fill_btn);
        ImageView five_fill_btn = (ImageView) findViewById(R.id.five_fill_btn);
        ImageView one_fill_btn = (ImageView) findViewById(R.id.one_fill_btn);
        ImageView three_fill_btn = (ImageView) findViewById(R.id.three_fill_btn);
        ImageView five_plus_fill_btn = (ImageView) findViewById(R.id.five_plus_fill_btn);

        EditText Login_email_et = (EditText) findViewById(R.id.Login_email_et);

        ImageView card_btn = (ImageView) findViewById(R.id.card_btn);
        ImageView card_fill_btn = (ImageView) findViewById(R.id.card_fill_btn);
        ImageView account_btn = (ImageView) findViewById(R.id.account_btn);
        ImageView account_fill_btn = (ImageView) findViewById(R.id.account_fill_btn);
        ImageView naverpay_btn = (ImageView) findViewById(R.id.naverpay_btn);
        ImageView naverpay_fill_btn = (ImageView) findViewById(R.id.naverpay_fill_btn);
        ImageView kakaopay_btn = (ImageView) findViewById(R.id.kakaopay_btn);
        ImageView kakaopay_fill_btn = (ImageView) findViewById(R.id.kakaopay_fill_btn);

        eight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eight_btn.setVisibility(View.INVISIBLE);
                eight_fill_btn.setVisibility(View.VISIBLE);
                Login_email_et.setText("    8,000");
            }
        });

        eight_fill_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eight_fill_btn.setVisibility(View.INVISIBLE);
                eight_btn.setVisibility(View.VISIBLE);
                Login_email_et.setText("");
            }
        });

        five_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                five_btn.setVisibility(View.INVISIBLE);
                five_fill_btn.setVisibility(View.VISIBLE);
                Login_email_et.setText("    5,000");
            }
        });

        five_fill_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                five_fill_btn.setVisibility(View.INVISIBLE);
                five_btn.setVisibility(View.VISIBLE);
                Login_email_et.setText("");
            }
        });

        one_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one_btn.setVisibility(View.INVISIBLE);
                one_fill_btn.setVisibility(View.VISIBLE);
                Login_email_et.setText("    10,000");
            }
        });

        one_fill_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one_fill_btn.setVisibility(View.INVISIBLE);
                one_btn.setVisibility(View.VISIBLE);
                Login_email_et.setText("");
            }
        });

        three_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                three_btn.setVisibility(View.INVISIBLE);
                three_fill_btn.setVisibility(View.VISIBLE);
                Login_email_et.setText("    30,000");
            }
        });

        three_fill_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                three_fill_btn.setVisibility(View.INVISIBLE);
                three_btn.setVisibility(View.VISIBLE);
                Login_email_et.setText("");
            }
        });

        five_plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                five_plus_btn.setVisibility(View.INVISIBLE);
                five_plus_fill_btn.setVisibility(View.VISIBLE);
                Login_email_et.setText("    50,000");
            }
        });

        five_plus_fill_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                five_plus_fill_btn.setVisibility(View.INVISIBLE);
                five_plus_btn.setVisibility(View.VISIBLE);
                Login_email_et.setText("");
            }
        });

        card_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                card_btn.setVisibility(View.INVISIBLE);
                card_fill_btn.setVisibility(View.VISIBLE);
            }
        });

        card_fill_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                card_fill_btn.setVisibility(View.INVISIBLE);
                card_btn.setVisibility(View.VISIBLE);
            }
        });

        account_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                account_btn.setVisibility(View.INVISIBLE);
                account_fill_btn.setVisibility(View.VISIBLE);
            }
        });

        account_fill_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                account_fill_btn.setVisibility(View.INVISIBLE);
                account_btn.setVisibility(View.VISIBLE);
            }
        });

        naverpay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                naverpay_btn.setVisibility(View.INVISIBLE);
                account_fill_btn.setVisibility(View.VISIBLE);
            }
        });

        naverpay_fill_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                naverpay_fill_btn.setVisibility(View.INVISIBLE);
                naverpay_btn.setVisibility(View.VISIBLE);
            }
        });

        kakaopay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                kakaopay_btn.setVisibility(View.INVISIBLE);
                kakaopay_fill_btn.setVisibility(View.VISIBLE);
            }
        });

        kakaopay_fill_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                kakaopay_fill_btn.setVisibility(View.INVISIBLE);
                kakaopay_btn.setVisibility(View.VISIBLE);
            }
        });

//        BootpayAnalytics.init(this, "637e5e79cf9f6d001f1b49f3");

        support_bottom_btn = (ImageView) findViewById(R.id.support_bottom_btn);
        support_bottom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonationRecieveDetailActivity.this, DonationCompleteActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

//    private void payApi() {
//        BootUser bootUser = new BootUser().setPhone("010-6566-4932");
//        BootExtra bootExtra = new BootExtra().setQuotas(new int[]{0, 2, 3});
//
//        Bootpay.init(getFragmentManager())
//                .setApplicationId("637e5e79cf9f6d001f1b49f3") // 해당 프로젝트(안드로이드)의 application id 값(위의 값 복붙)
//                .setPG(PG.INICIS) // 결제할 PG 사
//                .setMethod(Method.CARD) // 결제수단
//                .setContext(DonationRecieveDetailActivity.this)
//                .setBootUser(bootUser)
//                .setBootExtra(bootExtra)
//                .setUX(UX.PG_DIALOG)
//                .setName("최강금돈까스") // 결제할 상품명
//                .setOrderId("1234") // 결제 고유번호 (expire_month)
//                .setPrice(8000) // 결제할 금액
//                .addItem("최강금돈까스", 1, "ITEM_CODE_FLOWER", 8000) // 주문정보에 담길 상품정보, 통계를 위해 사용
//                .onConfirm(new ConfirmListener() { // 결제가 진행되기 바로 직전 호출되는 함수로, 주로 재고처리 등의 로직이 수행
//                    @Override
//                    public void onConfirm(@Nullable String message) {
//
//                        if (0 < stuck) Bootpay.confirm(message); // 재고가 있을 경우.
//                        else Bootpay.removePaymentWindow(); // 재고가 없어 중간에 결제창을 닫고 싶을 경우
//                        Log.d("confirm", message);
//                    }
//                })
//                .onDone(new DoneListener() { // 결제완료시 호출, 아이템 지급 등 데이터 동기화 로직을 수행합니다
//                    @Override
//                    public void onDone(@Nullable String message) {
//                        Log.d("done", message);
//                    }
//                })
//                .onReady(new ReadyListener() { // 가상계좌 입금 계좌번호가 발급되면 호출되는 함수입니다.
//                    @Override
//                    public void onReady(@Nullable String message) {
//                        Log.d("ready", message);
//                    }
//                })
//                .onCancel(new CancelListener() { // 결제 취소시 호출
//                    @Override
//                    public void onCancel(@Nullable String message) {
//
//                        Log.d("cancel", message);
//                    }
//                })
//                .onClose(
//                        new CloseListener() { //결제창이 닫힐때 실행되는 부분
//                            @Override
//                            public void onClose(String message) {
//                                Log.d("close", "close");
//                            }
//                        })
//                .request();
//    }
}