package company.webspoon;

/**
 * Created by oakinrele on Oct, 2020
 */

/**
 *   InnovaCrysta class
 **/
class InnovaCrysta extends Car{
    int mileage;
    public InnovaCrysta(int mileage)
    {
        super(false,"6");
        this.mileage = mileage;
    }
    public String getMileage()
    {
        return String.valueOf(this.mileage)+" kmpl" ;
    }
}