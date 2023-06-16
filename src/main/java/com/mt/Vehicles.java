package com.mt;

public class Vehicles {
    private String vin;
    private Boolean sold;
    private String sale_date;
    private String vehicle_type;

    public Vehicles(String vin, Boolean sold, String sale_date, String vehicle_type) {
        this.vin = vin;
        this.sold = sold;
        this.sale_date = sale_date;
        this.vehicle_type = vehicle_type;
    }

    public String getVin() {
        return vin;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public Boolean getSold() {
        return sold;
    }
    public void setSold(Boolean sold) {
        this.sold = sold;
    }
    public String getSale_date() {
        return sale_date;
    }
    public void setSale_date(String sale_date) {
        this.sale_date = sale_date;
    }
    public String getVehicle_type() {
        return vehicle_type;
    }
    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "vin='" + vin + '\'' +
                ", sold=" + sold +
                ", sale_date='" + sale_date + '\'' +
                '}';
    }
}
