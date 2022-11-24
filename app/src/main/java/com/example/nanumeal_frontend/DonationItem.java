package com.example.nanumeal_frontend;

public class DonationItem {

    String storeTitleTv;
    String openCloseTv;
    String line;
    String distanceTv;
    String kmTV;
    String availableAmountTv;
    String donationAmountTv;
    String wonTv;
    Integer storeProfileImage;
    Integer store_go_btn;
    Integer bottom_line;
    String buttonTv;

    public DonationItem(String storeTitleTv, String openCloseTv, String line, String distanceTv, String kmTV,
                    String availableAmountTv, String donationAmountTv, String wonTv, Integer storeProfileImage, Integer store_go_btn, String buttonTv, Integer bottom_line) {
        this.storeTitleTv = storeTitleTv;
        this.openCloseTv = openCloseTv;
        this.line = line;
        this.distanceTv = distanceTv;
        this.kmTV = kmTV;
        this.availableAmountTv = availableAmountTv;
        this.donationAmountTv = donationAmountTv;
        this.wonTv = wonTv;
        this.storeProfileImage = storeProfileImage;
        this.store_go_btn = store_go_btn;
        this.buttonTv = buttonTv;
        this.bottom_line = bottom_line;

    }

    public String getStoreTitleTv() { return storeTitleTv; }

    public String getOpenCloseTv() {
        return openCloseTv;
    }

    public String getLine() { return line; }

    public String getDistanceTv() { return distanceTv; }

    public String getKmTV() {
        return kmTV;
    }

    public String getAvailableAmountTv() { return availableAmountTv; }

    public String getDonationAmountTv() {
        return donationAmountTv;
    }

    public String getButtonTv() { return buttonTv; }

    public String getWonTv() { return wonTv; }

    public Integer getStoreProfileImage() { return storeProfileImage; }

    public Integer getStoreGoBtn() { return store_go_btn; }

    public Integer getBottomLine() { return bottom_line; }

    public void setStoreTitleTv(String storeTitleTv) {
        this.storeTitleTv = storeTitleTv;
    }

    public void setOpenCloseTv(String openCloseTv) {
        this.openCloseTv = openCloseTv;
    }

    public void setLine(String line) { this.line = line; }

    public void setDistanceTv(String distanceTv) { this.distanceTv = distanceTv; }

    public void setKmTV(String kmTV) { this.kmTV = kmTV; }

    public void setAvailableAmountTv(String availableAmountTv) { this.availableAmountTv = availableAmountTv; }

    public void setDonationAmountTv(String donationAmountTv) { this.donationAmountTv = donationAmountTv; }

    public void setWonTv(String wonTv) { this.wonTv = wonTv; }

    public void setStoreProfileImage(Integer storeProfileImage) { this.storeProfileImage = storeProfileImage; }

    public void setStoreGoBtn(Integer store_go_btn) { this.storeProfileImage = store_go_btn; }

    public void setBottomLine(Integer bottom_line) { this.bottom_line = bottom_line; }


}
