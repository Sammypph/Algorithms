package webspoon;

/**
 * Created by oakinrele on Oct, 2020
 */
/**
 *   WagonR class
 **/
class WagonR extends Car{
    int mileage;
    public WagonR(int mileage)
    {
        super(false,"4");
        this.mileage = mileage;
    }


    public String getMileage()
    {
        return String.valueOf(this.mileage)+" kmpl" ;
    }

}
