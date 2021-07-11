package webspoon;

/**
 * Created by oakinrele on Oct, 2020
 */


/**
 *   HondaCity class
 **/

class HondaCity extends Car{
    int mileage;
    public HondaCity(int mileage)
    {
        super(true,"4");
        this.mileage = mileage;
    }
    public String getMileage()
    {
        return String.valueOf(this.mileage)+" kmpl" ;
    }
}

