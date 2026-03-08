package com.payroll.model;

public class SalaryComponents {

    private double basic;
    private double hra;
    private double allowances;
    private double pf;   // Provident Fund
    private double tax;  // Income Tax
    private double netPay;

    public SalaryComponents() {}

    public SalaryComponents(double basic, double hra, double allowances, double pf, double tax) {
        this.basic = basic;
        this.hra = hra;
        this.allowances = allowances;
        this.pf = pf;
        this.tax = tax;
        this.netPay = (basic + hra + allowances) - (pf + tax);
    }

    public double getBasic() { return basic; }
    public double getHra() { return hra; }
    public double getAllowances() { return allowances; }
    public double getPf() { return pf; }
    public double getTax() { return tax; }
    public double getNetPay() { return netPay; }

    public SalaryComponents setBasic(double basic) { this.basic = basic; return this; }
    public SalaryComponents setHra(double hra) { this.hra = hra; return this; }
    public SalaryComponents setAllowances(double allowances) { this.allowances = allowances; return this; }
    public SalaryComponents setPf(double pf) { this.pf = pf; return this; }
    public SalaryComponents setTax(double tax) { this.tax = tax; return this; }
    public SalaryComponents setNetPay(double netPay) { this.netPay = netPay; return this; }

    @Override
    public String toString() {
        return String.format(
            "Basic: %.2f\nHRA: %.2f\nAllowances: %.2f\nPF: %.2f\nTax: %.2f\nNet Pay: %.2f",
            basic, hra, allowances, pf, tax, netPay
        );
    }
}